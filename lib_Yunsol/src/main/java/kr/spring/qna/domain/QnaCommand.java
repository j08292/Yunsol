package kr.spring.qna.domain;

import java.sql.Date;


import org.hibernate.validator.constraints.NotEmpty;

public class QnaCommand {

	
	private int qna_num;//글번호
	@NotEmpty
	private String qna_title;//글제목
	private String qna_passwd;//글작성 비밀번호
	@NotEmpty
	private String qna_content;//qna작성내용
	private Date qna_regdate;//작성일
	private int qna_hit;//조회수
	private String mem_id;
	private int qna_replyCount;//댓글수
	
	//비밀번호 일치여부 체크
		public boolean isCheckedPwd(String userPwd){
			if(qna_passwd.equals(userPwd)){
				return true;
			}
			return false;
		}
	
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_passwd() {
		return qna_passwd;
	}
	public void setQna_passwd(String qna_passwd) {
		this.qna_passwd = qna_passwd;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(Date qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	public int getQna_hit() {
		return qna_hit;
	}
	public void setQna_hit(int qna_hit) {
		this.qna_hit = qna_hit;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getQna_replyCount() {
		return qna_replyCount;
	}
	public void setQna_replyCount(int qna_replyCount) {
		this.qna_replyCount = qna_replyCount;
	}

	@Override
	public String toString() {
		return "QnaCommand [qna_num=" + qna_num + ", qna_title=" + qna_title + ", qna_passwd=" + qna_passwd
				+ ", qna_content=" + qna_content + ", qna_regdate=" + qna_regdate + ", qna_hit=" + qna_hit + ", mem_id="
				+ mem_id + ", qna_replyCount=" + qna_replyCount + "]";
	}

}
