package dao.impl;

import java.util.List;

import model.Orderitem;

import model.Book;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.OrderitemDao;

public class OrderitemDaoImpl extends HibernateDaoSupport implements
		OrderitemDao {

	public Integer save(Orderitem orderitem) {
		int bookID = orderitem.getBookid();
		Book book = (Book) getHibernateTemplate().find("from Book as b where b.id=?", bookID).get(0);
		int price = book.getPrice();
		orderitem.setBookprice(price);
		return (Integer) getHibernateTemplate().save(orderitem);

	}

	public void delete(Orderitem orderitem) {
		getHibernateTemplate().delete(orderitem);
	}

	public void update(Orderitem orderitem) {
		int bookID = orderitem.getBookid();
		Book book = (Book) getHibernateTemplate().find("from Book as b where b.id=?", bookID).get(0);
		int price = book.getPrice();
		orderitem.setBookprice(price);
		getHibernateTemplate().merge(orderitem);
	}

	public Orderitem getOrderitemById(int id) {
		@SuppressWarnings("unchecked")
		List<Orderitem> orderitems = (List<Orderitem>) getHibernateTemplate()
				.find("from Orderitem as oi where oi.id=?", id);
		Orderitem orderitem = orderitems.size() > 0 ? orderitems.get(0) : null;
		return orderitem;
	}

	public List<Orderitem> getAllOrderitems() {
		@SuppressWarnings("unchecked")
		List<Orderitem> orderitems = (List<Orderitem>) getHibernateTemplate()
				.find("from Orderitem");
		return orderitems;
	}

}
