package Action;

import Entity.user;
import com.opensymphony.xwork2.ActionSupport;
import Service.userService;

import java.util.Iterator;
import java.util.List;

public class loginAction extends ActionSupport{
    String username;
    String password;
    String usertype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    private userService UserService;

    public void setUserService(userService userService) {
        this.UserService = userService;
    }

    public String execute()
    {
        List<user> list = UserService.findAll();

        user u = new user();
        Iterator<user> it = list.iterator();

        while(it.hasNext())
        {
            u = (user)it.next();
            if (username.trim().equals(u.getName().trim())
                    && password.trim().equals(u.getPassword().trim())
                    &&usertype.equals(u.getType()))
            {
                return "success";
            }
            else
            {
                return "failer";
            }
        }
        String page = "failer";
        return  page;
    }
}
