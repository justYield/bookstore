package dao;

import java.util.List;

import model.BookCart;

public interface BookCartDao {
	public Integer save(BookCart bookCart);

	public void delete(BookCart bookCart);

	public void update(BookCart bookCart);

	public BookCart getBookCartById(int id);
	
	public List<BookCart> getBookCartByUserid(int userid);

	public List<BookCart> getAllBookCarts();
	

}
