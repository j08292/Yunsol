package kr.spring.qna.domain;

public class QnaReplyCommand {

	private int qna_re_num;
	private int qna_num;
	private String mem_id;
	private String qna_re_content;
	private String qna_re_regdate;
	private int mem_level;
	
	
	
	
	
	
	public int getQna_re_num() {
		return qna_re_num;
	}
	public void setQna_re_num(int qna_re_num) {
		this.qna_re_num = qna_re_num;
	}
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQna_re_content() {
		return qna_re_content;
	}
	public void setQna_re_content(String qna_re_content) {
		this.qna_re_content = qna_re_content;
	}
	public String getQna_re_regdate() {
		return qna_re_regdate;
	}
	public void setQna_re_regdate(String qna_re_regdate) {
		this.qna_re_regdate = qna_re_regdate;
	}
	public int getMem_level() {
		return mem_level;
	}
	public void setMem_level(int mem_level) {
		this.mem_level = mem_level;
	}
	
	
	@Override
	public String toString() {
		return "QnaReplyCommand [qna_re_num=" + qna_re_num + ", qna_num=" + qna_num + ", mem_id=" + mem_id
				+ ", qna_re_content=" + qna_re_content + ", qna_re_regdate=" + qna_re_regdate + ", mem_level="
				+ mem_level + "]";
	}
	
	
	
	
}
