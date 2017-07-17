package dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import model.Book;
import model.Picture;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import dao.BookDao;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

	public Integer save(Book book) {
		return (Integer) getHibernateTemplate().save(book);
	}

	public void delete(Book book) {
		getHibernateTemplate().delete(book);
	}

	public void update(Book book) {
		getHibernateTemplate().merge(book);
	}

	public Book getBookById(int id) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate().find(
				"from Book as b where b.id=?", id);
		Book book = books.size() > 0 ? books.get(0) : null;
		return book;
	}

	@Override
	public Book getBookByName(String name) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate().find(
				"from Book as b where b.title=?", name);
		Book book = books.size() > 0 ? books.get(0) : null;
		return book;
	}
	
	public List<Book> getAllBooks() {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate()
				.find("from Book");
		return books;
	}
	
	private GridFsTemplate GridFsTemplate;

	public void setGridFsTemplate(GridFsTemplate GridFsTemplate) {
	    this.GridFsTemplate = GridFsTemplate;
	}
	
	public Picture getPictureById(int id) {
		GridFSDBFile result = GridFsTemplate.findOne(new Query(Criteria.where("filename").is(String.valueOf(id)+".jpg")));
		if (result!= null){
			Picture picture =new Picture(result.getContentType(),result.getInputStream());
			return picture;
		}
		else{
			GridFSDBFile result0 = GridFsTemplate.findOne(new Query(Criteria.where("filename").is("404.png")));
			Picture picture =new Picture(result0.getContentType(),result0.getInputStream());
			return picture;
		}
		
	}

}
