__author__ = 'phoenix'
#coding:utf-8
from asyncore import dispatcher
from asynchat import async_chat
import socket
import asyncore

PORT = 5005
NAME = u'Sex  Chat Room'


class EndSession(Exception):
    pass


class CommandHandler:

    def unknow(self, session, cmd):
        session.push('Unknown command: %s\r\n' % cmd)

    def handle(self, session, line):
        """
        Main handle function
        """
        if not line.strip():
            return
        parts = line.split(' ', 1)
        cmd = parts[0]
        try:
            line = parts[1].strip()
        except IndexError:
            line = ''

        method = getattr(self, 'do_' + cmd, None)
        try:
            method(session, line)
        except TypeError:
            self.unknow(session, cmd)


class Room(CommandHandler):
    """
    Z作为一个创建聊天室房间的基类
    """
    def __init__(self, server):
        self.server = server
        self.sessions = []

    def add(self, session):
        self.sessions.append(session)

    def remove(self, session):
        self.sessions.remove(session)

    def broadcast(self, line):
        for session in self.sessions:
            session.push(line)

    def do_logout(self, session, line):
        raise EndSession


class LoginRoom(Room):
    """
    z准备用户登录房间,但是不是正式的聊天室
    """

    def add(self, session):
        Room.add(self, session)
        self.broadcast('welcome to %s!\r\n' % self.server.name)

    def unknow(self, session, cmd):
        session.push('Please log in \n Use "login<nick>"\r\n')

    def do_login(self, session, line):
        name = line.strip()
        if not name:
            session.push("please enter your login name\r\n")
        elif name in self.server.user:
            session.push('the name "%s" is taken.\r\n' % name)
            session.push('please try again.\r\n')
        else:
            session.name = name
            session.enter(self.server.main_room)


class ChatRoom(Room):

    def add(self, session):
        self.broadcast(session.name + 'has enterd the room.\r\n')
        self.server.user[session.name] = session
        Room.add(self,session)

    def remove(self, session):
        Room.remove(self, session)
        self.broadcast(session.name + ' has left the room\r\n')

    def do_say(self, session, line):
        self.broadcast(session.name + ': ' + line + '\r\n')

    def do_look(self, session, line):
        session.push('the following are logged in \r\n')
        for other in self.sessions:
            session.push(other.name + '\r\n')

    def do_who(self, session, line):
        session.push('the following are logged in :\r\n')
        for name in self.server.user:
            session.push(name + '\r\n')


class LogoutRoom(Room):

    def add(self, session):
        try:
            del self.server.user[session.name]
        except KeyError:
            pass


class ChatSession(async_chat):

    """
    这个类将会处理每一个客户端申请的会话，它将会所有新申请的客户端进入一个loginroom的房间内，
    测试你的用户名以及进入聊天室的条件，
    之后决定是否要客户端进入聊天室
    """
    def __init__(self, server, sock):
        async_chat.__init__(self, sock)
        self.server = server
        self.set_terminator("\r\n")
        self.data = []
        self.name = None
        self.enter(LoginRoom(server))

    def enter(self, room):
        """
        将调用这个函数的客户端添加到登录房间里面
        """
        try:
            cur = self.room
        except AttributeError:
            pass
        else:
            cur.remove(self)
        self.room = room
        room.add(self)

    def collect_incoming_data(self, data):
        self.data.append(data)

    def found_terminator(self):
        line = ''.join(self.data)
        self.data = []
        try:
            self.room.handle(self, line)
        except EndSession:
            self.handle_close()

    def handle_close(self):
        async_chat.handle_close(self)
        self.enter(LogoutRoom(self.server))


class ChatServer(dispatcher):
    """
    创建聊天服务器主类
    """

    def __init__(self, port, name):
        dispatcher.__init__(self)
        self.create_socket(socket.AF_INET, socket.SOCK_STREAM)     # 创建一个套接字
        self.set_reuse_addr()                                      # 用于服务器信息的清理工作
        self.bind(('', 5005))                                      # 将套接字绑定到指定的端口上准备监听
        self.listen(5)
        self.name = name
        self.user = {}
        self.main_room = ChatRoom(self)

    def handle_accept(self):
        """
        this function will accept user connection, then handle this connection
        """
        conn, addr = self.accept()               #conn将存储客户端的套接字，addr将存储具体的Ip地址
        ChatSession(self, conn)                  #conn作为参数，将把此次请求的客户端交给会话类的相关函数处理

if __name__ == '__main__':
    s = ChatServer(PORT, NAME)
    try:
        asyncore.loop()
    except KeyboardInterrupt:
        print