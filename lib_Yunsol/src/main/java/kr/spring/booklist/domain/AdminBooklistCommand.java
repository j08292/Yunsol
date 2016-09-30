package kr.spring.booklist.domain;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class AdminBooklistCommand {
	private int list_num;
	@Size(min=10, max=13, message="ISBN은 필수입니다.")
	private String list_code;
	@NotEmpty
	private String list_title;
	@NotEmpty
	private String list_writer;
	@NotEmpty
	private String list_publish;
	@NotNull
	private int list_page;
	private MultipartFile upload;
	private String list_filename;
	private Date list_regdate;
	private int list_grade;
	private int list_status;
	@NotEmpty
	private String mem_id;
	private int rent_count;
	
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
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
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
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getRent_count() {
		return rent_count;
	}
	public void setRent_count(int rent_count) {
		this.rent_count = rent_count;
	}
	
	
	@Override
	public String toString() {
		return "AdminBooklistCommand [list_num=" + list_num + ", list_code=" + list_code + ", list_title=" + list_title
				+ ", list_writer=" + list_writer + ", list_publish=" + list_publish + ", list_page=" + list_page
				+ ", upload=" + upload + ", list_filename=" + list_filename + ", list_regdate=" + list_regdate
				+ ", list_grade=" + list_grade + ", list_status=" + list_status + ", mem_id=" + mem_id + ", rent_count="
				+ rent_count + "]";
	}
}