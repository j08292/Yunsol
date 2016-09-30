package kr.spring.book.domain;

import java.sql.Date;

public class BookListCommand {

	private int list_num;
	private String list_code;
	private String list_title;
	private String list_writer;
	private String list_publish;
	private int list_page;
	private String list_filename;
	private Date list_regdate;
	private int list_grade;
	private int list_status;
	private String mem_id;
	private Date rent_regdate;
	private Date rent_returndate;
	private int rent_status;
	private String list_contents;

	public String getList_contents() {
		return list_contents;
	}

	public void setList_contents(String list_contents) {
		this.list_contents = list_contents;
	}

	public Date getRent_regdate() {
		return rent_regdate;
	}

	public void setRent_regdate(Date rent_regdate) {
		this.rent_regdate = rent_regdate;
	}

	public Date getRent_returndate() {
		return rent_returndate;
	}

	public void setRent_returndate(Date rent_returndate) {
		this.rent_returndate = rent_returndate;
	}

	public int getRent_status() {
		return rent_status;
	}

	public void setRent_status(int rent_status) {
		this.rent_status = rent_status;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getList_num() {
		return list_num;
	}

	public void setList_num(int list_num) {
		this.list_num = list_num;
	}	

	public String getList_code() {
		return list_code;
	}

	public void setList_code(String list_code) {
		this.list_code = list_code;
	}

	public String getList_title() {
		return list_title;
	}

	public void setList_title(String list_title) {
		this.list_title = list_title;
	}

	public String getList_writer() {
		return list_writer;
	}

	public void setList_writer(String list_writer) {
		this.list_writer = list_writer;
	}

	public String getList_publish() {
		return list_publish;
	}

	public void setList_publish(String list_publish) {
		this.list_publish = list_publish;
	}

	public int getList_page() {
		return list_page;
	}

	public void setList_page(int list_page) {
		this.list_page = list_page;
	}

	public String getList_filename() {
		return list_filename;
	}

	public void setList_filename(String list_filename) {
		this.list_filename = list_filename;
	}

	public Date getList_regdate() {
		return list_regdate;
	}

	public void setList_regdate(Date list_regdate) {
		this.list_regdate = list_regdate;
	}

	public int getList_grade() {
		return list_grade;
	}

	public void setList_grade(int list_grade) {
		this.list_grade = list_grade;
	}

	public int getList_status() {
		return list_status;
	}

	public void setList_status(int list_status) {
		this.list_status = list_status;
	}

	@Override
	public String toString() {
		return "BookListCommand [list_num=" + list_num + ", list_code=" + list_code + ", list_title=" + list_title
				+ ", list_writer=" + list_writer + ", list_publish=" + list_publish + ", list_page=" + list_page
				+ ", list_filename=" + list_filename + ", list_regdate=" + list_regdate + ", list_grade=" + list_grade
				+ ", list_status=" + list_status + ", mem_id=" + mem_id + ", rent_regdate=" + rent_regdate
				+ ", rent_returndate=" + rent_returndate + ", rent_status=" + rent_status + "]";
	}

}
