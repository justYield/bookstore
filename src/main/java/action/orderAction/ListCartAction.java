package action.orderAction;

import java.util.ArrayList;
import java.util.List;

import action.BaseAction;
import model.Book;
import model.BookCart;
import service.AppService;

public class ListCartAction extends BaseAction {

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
		List<BookCart> list = appService.getBookCartByUserId(id);
		
		List<Book> books = new ArrayList();
		for(int i=0; i < list.size(); i++){
			BookCart bc = list.get(i);
			Book book = appService.getBookById(bc.getBookid());
			books.add(book);
		}
		
		request().setAttribute("cart", list);
		request().setAttribute("booksInCart", books);
		return SUCCESS;
	}

}
