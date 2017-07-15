package action;

import model.User;
import service.AppService;

public class LoginAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private AppService appService;
	
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

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	@Override
	public String execute() throws Exception {
		User user = new User(username, password, null);
		if(appService.checkLogin(user)){
			session().setAttribute("username", username);
			user = appService.getUserByUsername(username);
			session().setAttribute("role", user.getRole());
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
	
}
