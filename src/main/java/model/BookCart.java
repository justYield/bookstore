package model;

public class BookCart {
	private int id;
	private int userid;
	private int bookid;
	private int amount;
	
	public BookCart(){
		
	}
	
	public BookCart(int id, int userid, int bookid, int amount){
		this.id = id;
		this.userid = userid;
		this.bookid = bookid;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
