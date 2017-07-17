package action.orderAction;


import java.sql.Date;
import java.util.List;

import action.BaseAction;
import model.BookCart;
import model.Order;
import model.Orderitem;
import service.AppService;

public class BuyAllAction extends BaseAction {

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
		List<BookCart> bcList = appService.getBookCartByUserId(id);
		Date date = new Date(System.currentTimeMillis());
		Order order = new Order(id, date);
		appService.addOrder(order);
		List<Order> orderls = appService.getOrderByUserid(id);
		int orderNum = orderls.get(orderls.size()-1).getId();
		
		for(int i=0; i<bcList.size(); i++){
			BookCart bc = bcList.get(i);
			int bookid = bc.getBookid();
			int amount = bc.getAmount();
			Orderitem orderitem = new Orderitem(orderNum, bookid, amount);
			appService.addOrderitem(orderitem);
			appService.deleteBookCart(bc);
		}

		return SUCCESS;
	}

}
