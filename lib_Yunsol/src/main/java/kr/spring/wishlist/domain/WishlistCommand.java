package kr.spring.wishlist.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class WishlistCommand {
	private int wish_num;
	@NotEmpty
	private String wish_title;
	@NotEmpty
	private String wish_writer;
	@NotEmpty
	private String wish_publish;
	private Date wish_regdate;
	private int wish_status;
	@NotEmpty
	private String mem_id;
	
	public int getWish_num() {
		return wish_num;
	}
	public void setWish_num(int wish_num) {
		this.wish_num = wish_num;
	}
	public String getWish_title() {
		return wish_title;
	}
	public void setWish_title(String wish_title) {
		this.wish_title = wish_title;
	}
	public String getWish_writer() {
		return wish_writer;
	}
	public void setWish_writer(String wish_writer) {
		this.wish_writer = wish_writer;
	}
	public String getWish_publish() {
		return wish_publish;
	}
	public void setWish_publish(String wish_publish) {
		this.wish_publish = wish_publish;
	}
	public Date getWish_regdate() {
		return wish_regdate;
	}
	public void setWish_regdate(Date wish_regdate) {
		this.wish_regdate = wish_regdate;
	}
	public int getWish_status() {
		return wish_status;
	}
	public void setWish_status(int wish_status) {
		this.wish_status = wish_status;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "WishlistCommand [wish_num=" + wish_num + ", wish_title=" + wish_title + ", wish_writer=" + wish_writer
				+ ", wish_publish=" + wish_publish + ", wish_regdate=" + wish_regdate + ", wish_status=" + wish_status
				+ ", mem_id=" + mem_id + "]";
	}	
}