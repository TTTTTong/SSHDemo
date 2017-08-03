package Action;

import Entity.user;
import Service.userService;
import com.opensymphony.xwork2.ActionSupport;

public class updateUserAction extends ActionSupport {
    private userService userService;
    private user user;

    public Entity.user getUser()
    {
        return user;
    }

    public void setUser(Entity.user user)
    {
        this.user = user;
    }

    public void setUserService(Service.userService userService)
    {
        this.userService = userService;
    }

    public String execute()
    {
        if(userService.findById(user.getId()) != null)
        {
            setUser(user);
            userService.update(user);
            return SUCCESS;
        }

        addActionMessage(getText("error.message.not.exist"));
        return INPUT;
    }
}
