package kr.spring.event.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class EventCommand {
	private int event_num;
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private String event_title;
	@NotEmpty
	private String event_content;
	private MultipartFile event_upload;
	private String event_filename;
	private int event_hit;
	private Date event_regdate;
	private Date event_startdate;
	private Date event_enddate;
	private int event_replyCount;
	
	public int getEvent_num() {
		return event_num;
	}
	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	public MultipartFile getEvent_upload() {
		return event_upload;
	}
	public void setEvent_upload(MultipartFile event_upload) {
		this.event_upload = event_upload;
	}
	public String getEvent_filename() {
		return event_filename;
	}
	public void setEvent_filename(String event_filename) {
		this.event_filename = event_filename;
	}
	public int getEvent_hit() {
		return event_hit;
	}
	public void setEvent_hit(int event_hit) {
		this.event_hit = event_hit;
	}
	public Date getEvent_regdate() {
		return event_regdate;
	}
	public void setEvent_regdate(Date event_regdate) {
		this.event_regdate = event_regdate;
	}
	public Date getEvent_startdate() {
		return event_startdate;
	}
	public void setEvent_startdate(Date event_startdate) {
		this.event_startdate = event_startdate;
	}
	public Date getEvent_enddate() {
		return event_enddate;
	}
	public void setEvent_enddate(Date event_enddate) {
		this.event_enddate = event_enddate;
	}
	public int getEvent_replyCount() {
		return event_replyCount;
	}
	public void setEvent_replyCount(int event_replyCount) {
		this.event_replyCount = event_replyCount;
	}
	
	@Override
	public String toString() {
		return "EventCommand [event_num=" + event_num + ", mem_id=" + mem_id + ", event_title=" + event_title
				+ ", event_content=" + event_content + ", event_upload=" + event_upload + ", event_filename="
				+ event_filename + ", event_hit=" + event_hit + ", event_regdate=" + event_regdate
				+ ", event_startdate=" + event_startdate + ", event_enddate=" + event_enddate + ", event_replyCount="
				+ event_replyCount + "]";
	}
}
