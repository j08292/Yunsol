package kr.spring.penalty.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import kr.spring.util.DurationFromNow;

public class PenaltyCommand {
	private int penalty_num;
	private Date penalty_regdate;
	private Date penalty_blockcanceldate;
	private int penalty_day;
	private String mem_id;
	@NotEmpty
	private String penalty_reason;
	private Date blockcanceldate;
	private String regdate_String;
	
	public int getPenalty_num() {
		return penalty_num;
	}
	public void setPenalty_num(int penalty_num) {
		this.penalty_num = penalty_num;
	}	
	public Date getPenalty_regdate() {
		return penalty_regdate;
	}
	public void setPenalty_regdate(Date penalty_regdate) {
		this.penalty_regdate = penalty_regdate;
	}
	public Date getPenalty_blockcanceldate() {
		return penalty_blockcanceldate;
	}
	public void setPenalty_blockcanceldate(Date penalty_blockcanceldate) {
		this.penalty_blockcanceldate = penalty_blockcanceldate;
	}
	public int getPenalty_day() {
		return penalty_day;
	}
	public void setPenalty_day(int penalty_day) {
		this.penalty_day = penalty_day;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPenalty_reason() {
		return penalty_reason;
	}
	public void setPenalty_reason(String penalty_reason) {
		this.penalty_reason = penalty_reason;
	}	
	public Date getBlockcanceldate() {
		return blockcanceldate;
	}
	public void setBlockcanceldate(Date blockcanceldate) {
		this.blockcanceldate = blockcanceldate;
	}
	public String getRegdate_String() {
		return regdate_String;
	}
	public void setRegdate_String(String regdate_String) {
		this.regdate_String = DurationFromNow.getTimeDiffLabel(regdate_String);
	}
	
	@Override
	public String toString() {
		return "PenaltyCommand [penalty_num=" + penalty_num + ", penalty_regdate=" + penalty_regdate
				+ ", penalty_blockcanceldate=" + penalty_blockcanceldate + ", penalty_day=" + penalty_day + ", mem_id="
				+ mem_id + ", penalty_reason=" + penalty_reason + ", blockcanceldate=" + blockcanceldate
				+ ", regdate_String=" + regdate_String + "]";
	}
}