package action.orderAction;

import java.util.List;

import action.BaseAction;
import model.Order;
import service.AppService;

public class MyOrdersAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private AppService appService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<Order> orders = appService.getOrderByUserid(id);
		request().setAttribute("myOrder", orders);
		return SUCCESS;
	}
}
