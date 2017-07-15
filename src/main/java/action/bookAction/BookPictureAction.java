package action.bookAction;

import java.io.InputStream;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import action.BaseAction;
import model.Picture;
import service.BookService;

public class BookPictureAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private BookService bookService;
	private GridFsTemplate gridFsTemplate;
	private InputStream inputStream;
	private String contentType;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public GridFsTemplate getGridFsTemplate() {
		return gridFsTemplate;
	}

	public void setGridFsTemplate(GridFsTemplate gridFsTemplate) {
		this.gridFsTemplate = gridFsTemplate;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String execute() throws Exception {
		    Picture picture = bookService.getPictureById(id);
		    setInputStream(picture.getInputStream());
		    setContentType(picture.getContentType());
			return SUCCESS;
		}

}
