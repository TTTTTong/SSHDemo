package Action;

import Service.userService;
import com.opensymphony.xwork2.ActionSupport;

public class deleteUserAction extends ActionSupport {
    private userService userService;
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUserService(Service.userService userService)
    {
        this.userService = userService;
    }
    public String execute()
    {
        userService.delete(id);
        return SUCCESS;
    }
}
