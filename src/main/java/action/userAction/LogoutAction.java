package action.userAction;

import action.BaseAction;

public class LogoutAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	

	@Override
	public String execute() throws Exception {
		session().removeAttribute("username");
		session().removeAttribute("id");
		session().removeAttribute("role");
		return SUCCESS;
	}
	
}
