package kr.spring.grade.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class GradeCommand {
	private int grade_num;
	@NotEmpty
	private String grade_content;
	private String grade_regdate;
	private int list_num;
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private int grade_star;
	private String list_title;
	
	public int getGrade_num() {
		return grade_num;
	}
	public void setGrade_num(int grade_num) {
		this.grade_num = grade_num;
	}
	public String getGrade_content() {
		return grade_content;
	}
	public void setGrade_content(String grade_content) {
		this.grade_content = grade_content;
	}
	public String getGrade_regdate() {
		return grade_regdate;
	}
	public void setGrade_regdate(String grade_regdate) {
		this.grade_regdate = grade_regdate;
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
	public int getGrade_star() {
		return grade_star;
	}
	public void setGrade_star(int grade_star) {
		this.grade_star = grade_star;
	}
	public String getList_title() {
		return list_title;
	}
	public void setList_title(String list_title) {
		this.list_title = list_title;
	}
	
	@Override
	public String toString() {
		return "GradeCommand [grade_num=" + grade_num + ", grade_content=" + grade_content + ", grade_regdate="
				+ grade_regdate + ", list_num=" + list_num + ", mem_id=" + mem_id + ", grade_star=" + grade_star
				+ ", list_title=" + list_title + "]";
	}	
}