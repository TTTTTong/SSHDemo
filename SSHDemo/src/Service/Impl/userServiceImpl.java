package Service.Impl;
import Dao.userDao;
import Entity.user;
import Service.userService;

import java.util.List;

public class userServiceImpl implements userService {

    private userDao userDao;
    public void setUserDao(userDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void save(user user) {
        if (userDao.findById(user.getId()) == null)
        {
            userDao.save(user);
        }
    }

    @Override
    public user getUser(String user) {
        return userDao.getUser(user);
    }

    @Override
    public void delete(int id) {
        if (userDao.findById(id) != null)
        {
            userDao.delete(id);
        }
    }

    @Override
    public void update(user user) {
        if (userDao.findById(user.getId()) != null)
        {
            userDao.update(user);
        }
    }

    @Override
    public user findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<?> findAll(String username) {
        return userDao.findAll(username);
    }
}
