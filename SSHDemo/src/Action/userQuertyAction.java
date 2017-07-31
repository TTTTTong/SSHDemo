package Action;

import Entity.user;
import Service.userService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import java.util.List;


public class userQuertyAction extends ActionSupport
{
    private userService UserService;

    public void setUserService(userService userService)
    {
        this.UserService = userService;
    }

    public String execute()
    {
        List<user> list = UserService.findAll();
        //将所有用户存放在request范围内
        ServletActionContext.getRequest().setAttribute("userlist",list);

        return SUCCESS;
    }
}
