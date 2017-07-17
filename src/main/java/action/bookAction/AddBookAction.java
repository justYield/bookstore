package action.bookAction;

import java.sql.Date;

import action.BaseAction;
import model.Book;
import service.AppService;

public class AddBookAction extends BaseAction {
	

	private static final long serialVersionUID = 1L;

	private String title;
	private String author;
	private int price;
	private String publisher;
	private Date date;

	private AppService appService;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		Book book = new Book(title, author, price, publisher, date);
		appService.addBook(book);

		return SUCCESS;
	}

}
