package dao;

import java.io.File;
import java.util.List;

import model.Book;
import model.Picture;

public interface BookDao {

	public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookById(int id);
	
	public Book getBookByName(String name);

	public List<Book> getAllBooks();
	
    public Picture getPictureById(int id);

}