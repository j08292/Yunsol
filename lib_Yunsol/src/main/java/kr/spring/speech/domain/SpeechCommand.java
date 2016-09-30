package kr.spring.speech.domain;

import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;

public class SpeechCommand {
	private int speech_num;
	@NotEmpty
	private String speech_title;
	@NotEmpty
	private String speech_content;
	private Date speech_date;
	private int speech_people;
	private int speech_hit;
	private Date speech_regdate;
	@NotEmpty
	private String speech_location;
	private String speech_location2;
	private int speech_status;
	private int countres;
	
	public int getSpeech_status() {
		return speech_status;
	}
	public void setSpeech_status(int speech_status) {
		this.speech_status = speech_status;
	}
	public String getSpeech_location2() {
		return speech_location2;
	}
	public void setSpeech_location2(String speech_location2) {
		this.speech_location2 = speech_location2;
	}

	private int speech_price;
	@NotEmpty
	private String mem_id;
	
	public int getSpeech_num() {
		return speech_num;
	}
	public void setSpeech_num(int speech_num) {
		this.speech_num = speech_num;
	}
	public String getSpeech_title() {
		return speech_title;
	}
	public void setSpeech_title(String speech_title) {
		this.speech_title = speech_title;
	}
	public String getSpeech_content() {
		return speech_content;
	}
	public void setSpeech_content(String speech_content) {
		this.speech_content = speech_content;
	}
	public Date getSpeech_date() {
		return speech_date;
	}
	public void setSpeech_date(Date speech_date) {
		this.speech_date = speech_date;
	}
	public int getSpeech_people() {
		return speech_people;
	}
	public void setSpeech_people(int speech_people) {
		this.speech_people = speech_people;
	}
	public int getSpeech_hit() {
		return speech_hit;
	}
	public void setSpeech_hit(int speech_hit) {
		this.speech_hit = speech_hit;
	}
	public Date getSpeech_regdate() {
		return speech_regdate;
	}
	public void setSpeech_regdate(Date speech_regdate) {
		this.speech_regdate = speech_regdate;
	}
	public String getSpeech_location() {
		return speech_location;
	}
	public void setSpeech_location(String speech_location) {
		this.speech_location = speech_location;
	}
	public int getSpeech_price() {
		return speech_price;
	}
	public void setSpeech_price(int speech_price) {
		this.speech_price = speech_price;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCountres() {
		return countres;
	}
	public void setCountres(int countres) {
		this.countres = countres;
	}
	@Override
	public String toString() {
		return "SpeechCommand [speech_num=" + speech_num + ", speech_title=" + speech_title + ", speech_content="
				+ speech_content + ", speech_date=" + speech_date + ", speech_people=" + speech_people + ", speech_hit="
				+ speech_hit + ", speech_regdate=" + speech_regdate + ", speech_location=" + speech_location
				+ ", speech_location2=" + speech_location2 + ", speech_status=" + speech_status + ", countres="
				+ countres + ", speech_price=" + speech_price + ", mem_id=" + mem_id + "]";
	}
	
	
}
