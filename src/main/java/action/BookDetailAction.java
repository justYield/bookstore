package action;

import model.Book;
import service.AppService;

public class BookDetailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private int id;
	private AppService appService;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		Book book = appService.getBookById(id);
		request().setAttribute("detail", book);
		return SUCCESS;
	}

}
