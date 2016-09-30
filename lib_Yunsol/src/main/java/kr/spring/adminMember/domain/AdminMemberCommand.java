package kr.spring.adminMember.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AdminMemberCommand {
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private String mem_name;
	@NotEmpty
	@Size(min=4, max=10, message="비밀번호는 필수입니다.")
	private String mem_passwd;
	@NotEmpty
	private String mem_cell;
	@Email
	@NotEmpty
	private String mem_email;
	@NotEmpty
	private String sample3_postcode;
	@NotEmpty
	private String mem_address;
	private Date mem_regdate;
	private int mrt_status;
	private int mem_level;
	private int mem_penalty;
	private int block_count;

	/*// 비밀번호 일치 여부 체크
	public boolean isCheckedPasswd(String userPasswd) {
		if (mem_passwd.equals(userPasswd)) {
			return true;
		}
		return false;
	}*/
	
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_passwd() {
		return mem_passwd;
	}

	public void setMem_passwd(String mem_passwd) {
		this.mem_passwd = mem_passwd;
	}

	public String getMem_cell() {
		return mem_cell;
	}

	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	
	public String getSample3_postcode() {
		return sample3_postcode;
	}

	public void setSample3_postcode(String sample3_postcode) {
		this.sample3_postcode = sample3_postcode;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public Date getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(Date mem_regdate) {
		this.mem_regdate = mem_regdate;
	}

	public int getMrt_status() {
		return mrt_status;
	}

	public void setMrt_status(int mrt_status) {
		this.mrt_status = mrt_status;
	}

	public int getMem_level() {
		return mem_level;
	}

	public void setMem_level(int mem_level) {
		this.mem_level = mem_level;
	}

	public int getMem_penalty() {
		return mem_penalty;
	}

	public void setMem_penalty(int mem_penalty) {
		this.mem_penalty = mem_penalty;
	}
	public int getBlock_count() {
		return block_count;
	}

	public void setBlock_count(int block_count) {
		this.block_count = block_count;
	}

	@Override
	public String toString() {
		return "AdminMemberCommand [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_passwd=" + mem_passwd
				+ ", mem_cell=" + mem_cell + ", mem_email=" + mem_email + ", sample3_postcode=" + sample3_postcode
				+ ", mem_address=" + mem_address + ", mem_regdate=" + mem_regdate + ", mrt_status=" + mrt_status
				+ ", mem_level=" + mem_level + ", mem_penalty=" + mem_penalty + ", block_count=" + block_count + "]";
	}
	
}