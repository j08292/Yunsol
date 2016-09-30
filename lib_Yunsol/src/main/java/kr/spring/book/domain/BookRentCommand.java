package kr.spring.book.domain;

import java.sql.Date;

public class BookRentCommand {
	private int rent_num;
	private int list_num;
	private String mem_id;
	private Date rent_regdate;
	private int rent_status;
	private String rent_returndate;
	private String list_title;
	private String list_filename;

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

	public String getRent_returndate() {
		return rent_returndate;
	}

	public void setRent_returndate(String rent_returndate) {
		this.rent_returndate = rent_returndate;
	}

	public String getList_title() {
		return list_title;
	}

	public void setList_title(String list_title) {
		this.list_title = list_title;
	}

	public String getList_filename() {
		return list_filename;
	}

	public void setList_filename(String list_filename) {
		this.list_filename = list_filename;
	}

}
