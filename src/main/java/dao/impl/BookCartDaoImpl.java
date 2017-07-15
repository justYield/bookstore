package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookCartDao;
import model.BookCart;

@SuppressWarnings("deprecation")
public class BookCartDaoImpl extends HibernateDaoSupport implements BookCartDao {

	public Integer save(BookCart bookCart) {
		return  (Integer) getHibernateTemplate().save(bookCart);
	}

	public void delete(BookCart bookCart) {
		getHibernateTemplate().delete(bookCart);
	}

	public void update(BookCart bookCart) {
		getHibernateTemplate().merge(bookCart);
	}

	public List<BookCart> getBookCartByUserid(int userid) {
		@SuppressWarnings("unchecked")
		List<BookCart> bookCarts = (List<BookCart>) getHibernateTemplate().find(
				"from BookCart as t where t.userid=?", userid);
		return bookCarts;
	}
	
	public BookCart getBookCartById(int id) {
		@SuppressWarnings("unchecked")
		List<BookCart> bookCarts = (List<BookCart>) getHibernateTemplate().find(
				"from BookCart as d where d.id=?", id);
		BookCart bookCart = bookCarts.size() > 0 ? bookCarts.get(0) : null;
		return bookCart;
	}
	
	public List<BookCart> getAllBookCarts() {
		@SuppressWarnings("unchecked")
		List<BookCart> bookCarts = (List<BookCart>) getHibernateTemplate()
				.find("from BookCart");
		return bookCarts;
	}
	
	
	
	
}