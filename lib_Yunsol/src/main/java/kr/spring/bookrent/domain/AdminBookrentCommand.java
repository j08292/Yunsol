package kr.spring.bookrent.domain;

import java.sql.Date;

public class AdminBookrentCommand {
	private int rent_num;
	private int list_num;
	private String mem_id;
	private Date rent_regdate;
	private int rent_status;
	private String list_title;
	private String list_code;
	private Date rent_returndate;
	
	public int getRent_num() {
		return rent_num;
	}
	public void setRent_num(int rent_num) {
		this.rent_num = rent_num;
	}
	public int getList_num() {
		return list_num;
	}
	public void setList_num(int list_num) {
		this.list_num = list_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getRent_regdate() {
		return rent_regdate;
	}
	public void setRent_regdate(Date rent_regdate) {
		this.rent_regdate = rent_regdate;
	}
	public int getRent_status() {
		return rent_status;
	}
	public void setRent_status(int rent_status) {
		this.rent_status = rent_status;
	}
	public String getList_title() {
		return list_title;
	}
	public void setList_title(String list_title) {
		this.list_title = list_title;
	}
	public String getList_code() {
		return list_code;
	}
	public void setList_code(String list_code) {
		this.list_code = list_code;
	}
	
	public Date getRent_returndate() {
		return rent_returndate;
	}
	public void setRent_returndate(Date rent_returndate) {
		this.rent_returndate = rent_returndate;
	}
	
	@Override
	public String toString() {
		return "AdminBookrentCommand [rent_num=" + rent_num + ", list_num=" + list_num + ", mem_id=" + mem_id
				+ ", rent_regdate=" + rent_regdate + ", rent_status=" + rent_status + ", list_title=" + list_title
				+ ", list_code=" + list_code + ", rent_returndate=" + rent_returndate + "]";
	}	
}