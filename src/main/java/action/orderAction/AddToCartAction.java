package action.orderAction;

import java.sql.Date;

import action.BaseAction;
import model.BookCart;
import model.Order;
import service.AppService;

public class AddToCartAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int bookid;
	private int userid;
	private int amount;

	private AppService appService;


	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {
		BookCart bookCart = new BookCart();
		bookCart.setBookid(bookid);
		bookCart.setUserid(userid);
		bookCart.setAmount(amount);
		appService.addBookCart(bookCart);
		return SUCCESS;
	}

}
