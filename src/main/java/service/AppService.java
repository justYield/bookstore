package service;

import java.util.List;

import model.Book;
import model.BookCart;
import model.Order;
import model.Orderitem;
import model.Picture;
import model.User;

/**
 * @author seniyuting
 * @version 1.0
 * 
 */
public interface AppService {

	/**
	 * book
	 * 
	 */
	public Integer addBook(Book book);

	public void deleteBook(Book book);

	public void updateBook(Book book);

	public Book getBookById(int id);
	
	public Book getBookByName(String name);

	public List<Book> getAllBooks();
	
	public Picture getPictureById(int id);

	/**
	 * order
	 * 
	 */
	public Integer addOrder(Order order);

	public void deleteOrder(Order order);

	public void updateOrder(Order order);

	public Order getOrderById(int id);
	
	public List<Order> getOrderByUserid(int id);

	public List<Order> getAllOrders();

	/**
	 * order item
	 * 
	 */
	public Integer addOrderitem(Orderitem orderitem);

	public void deleteOrderitem(Orderitem orderitem);

	public void updateOrderitem(Orderitem orderitem);

	public Orderitem getOrderitemById(int id);

	public List<Orderitem> getAllOrderitems();
	
	/**
	 * book cart
	 * 
	 */
	public Integer addBookCart(BookCart bookCart);

	public void deleteBookCart(BookCart bookCart);

	public void updateBookCart(BookCart bookCart);

	public BookCart getBookCartById(int id);
	
	public List<BookCart> getBookCartByUserId(int userid);

	public List<BookCart> getAllBookCarts();

	/**
	 * user
	 * 
	 */
	public Integer addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();

	public boolean checkLogin(User user);
	
	public User getUserByUsername(String username);
	

}
