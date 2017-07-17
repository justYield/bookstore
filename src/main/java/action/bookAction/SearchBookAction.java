package action.bookAction;

import java.util.ArrayList;
import java.util.List;

import action.BaseAction;
import model.Book;
import service.AppService;

public class SearchBookAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private String searchString;
	private AppService appService;
	
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<Book> books = new ArrayList();
		Book book = appService.getBookByName(searchString);
		if(book != null){
			books.add(book);
			request().setAttribute("books", books);
		}

		return SUCCESS;
	}
}
