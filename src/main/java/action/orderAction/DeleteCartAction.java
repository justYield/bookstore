package action.orderAction;

import action.BaseAction;
import model.BookCart;
import service.AppService;

public class DeleteCartAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private AppService appService;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AppService getAppService() {
		return appService;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	@Override
	public String execute() throws Exception {
		BookCart bc = appService.getBookCartById(id);
		appService.deleteBookCart(bc);
		return SUCCESS;
	}

}
