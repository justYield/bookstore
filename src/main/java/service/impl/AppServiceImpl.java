package service.impl;

import java.util.List;

import model.Book;
import model.BookCart;
import model.Order;
import model.Orderitem;
import model.Picture;
import model.User;
import service.AppService;
import dao.BookCartDao;
import dao.BookDao;
import dao.OrderDao;
import dao.OrderitemDao;
import dao.UserDao;

/**
 * @author seniyuting
 * @version 1.0
 * 
 */
public class AppServiceImpl implements AppService {

	private BookDao bookDao;
	private OrderDao orderDao;
	private OrderitemDao orderitemDao;
	private UserDao userDao;
	private BookCartDao bookCartDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setOrderitemDao(OrderitemDao orderitemDao) {
		this.orderitemDao = orderitemDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setBookCartDao(BookCartDao bookCartDao) {
		this.bookCartDao = bookCartDao;
	}

	/**
	 * book
	 * 
	 */
	public Integer addBook(Book book) {
		return bookDao.save(book);
	}

	public void deleteBook(Book book) {
		bookDao.delete(book);
	}

	public void updateBook(Book book) {
		bookDao.update(book);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	public Book getBookByName(String name) {
		return bookDao.getBookByName(name);
	}
	
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	public Picture getPictureById(int id){
		return bookDao.getPictureById(id);
	}

	/**
	 * order
	 * 
	 */
	public Integer addOrder(Order order) {
		return orderDao.save(order);
	}

	public void deleteOrder(Order order) {
		orderDao.delete(order);
	}

	public void updateOrder(Order order) {
		orderDao.update(order);
	}

	public Order getOrderById(int id) {
		return orderDao.getOrderById(id);
	}
	
	@Override
	public List<Order> getOrderByUserid(int id) {
		return orderDao.getOrderByUserId(id);
	}

	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	/**
	 * order item
	 * 
	 */
	public Integer addOrderitem(Orderitem orderitem) {
		return orderitemDao.save(orderitem);
	}

	public void deleteOrderitem(Orderitem orderitem) {
		orderitemDao.delete(orderitem);
	}

	public void updateOrderitem(Orderitem orderitem) {
		orderitemDao.update(orderitem);
	}

	public Orderitem getOrderitemById(int id) {
		return orderitemDao.getOrderitemById(id);
	}

	public List<Orderitem> getAllOrderitems() {
		return orderitemDao.getAllOrderitems();
	}

	/**
	 * user
	 * 
	 */
	public Integer addUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public boolean checkLogin(User user) {
		if(userDao.getUserByNameAndPassword(user) == null){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	/**
	 * book cart
	 * 
	 */
	@Override
	public Integer addBookCart(BookCart bookCart) {
		return bookCartDao.save(bookCart);
	}

	@Override
	public void deleteBookCart(BookCart bookCart) {
		bookCartDao.delete(bookCart);
	}

	@Override
	public void updateBookCart(BookCart bookCart) {
		bookCartDao.update(bookCart);
	}

	@Override
	public BookCart getBookCartById(int id) {
		return bookCartDao.getBookCartById(id);
	}

	@Override
	public List<BookCart> getBookCartByUserId(int userid) {
		return bookCartDao.getBookCartByUserid(userid);
	}

	@Override
	public List<BookCart> getAllBookCarts() {
		return bookCartDao.getAllBookCarts();
	}

}
