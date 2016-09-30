package kr.spring.event.domain;

import kr.spring.util.DurationFromNow;

public class EventReplyCommand {
	private int event_re_num;
	private String event_re_content;
	private String event_re_date;
	private int event_num;
	private String mem_id;
	
	public int getEvent_re_num() {
		return event_re_num;
	}
	public void setEvent_re_num(int event_re_num) {
		this.event_re_num = event_re_num;
	}
	public String getEvent_re_content() {
		return event_re_content;
	}
	public void setEvent_re_content(String event_re_content) {
		this.event_re_content = event_re_content;
	}
	public String getEvent_re_date() {
		return event_re_date;
	}
	public void setEvent_re_date(String event_re_date) {
		this.event_re_date = DurationFromNow.getTimeDiffLabel(event_re_date);
	}
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
	
	@Override
	public String toString() {
		return "EventReplyCommand [event_re_num=" + event_re_num + ", event_re_content=" + event_re_content
				+ ", event_re_date=" + event_re_date + ", event_num=" + event_num + ", mem_id=" + mem_id + "]";
	}
	
	
	
}
