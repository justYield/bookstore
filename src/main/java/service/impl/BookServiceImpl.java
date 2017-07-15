package service.impl;

import java.io.File;

import dao.BookDao;
import model.Picture;
import service.BookService;

public class BookServiceImpl implements BookService{
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public boolean uploadPicture(int id, File image, String contentType, String fileName) {
		return bookDao.uploadPicture(id, image, contentType, fileName);
	}
	
	public Picture getPictureById(int id){
		return bookDao.getPictureById(id);
	}

}
