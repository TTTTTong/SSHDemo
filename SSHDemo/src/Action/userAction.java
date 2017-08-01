package Action;

import Entity.user;
import Service.userService;
import com.opensymphony.xwork2.ActionSupport;

public class userAction extends ActionSupport{
    private userService UserService;

    public void setUserService(userService userService) {
        this.UserService = userService;
    }

    private user User;

    public user getUser()
    {
        return User;
    }

    public void setUser(user user)
    {
        User = user;
    }

    public String execute()
    {
        user u = new user();
        u.setId(User.getId());
        u.setName(User.getName());
        u.setPassword(User.getPassword());
        u.setType(User.getType());

        UserService.save(u);
        return SUCCESS;
    }
}
