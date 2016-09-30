package kr.spring.review.domain;

import kr.spring.util.DurationFromNow;

public class ReviewReplyCommand {
	private int review_re_num;//댓글의 글번호
	private int review_num;//게시물의 글번호
	private String review_re_content;//댓글내용
	private String review_re_regdate;
	private String mem_id;
	
	
	
	
	public int getReview_re_num() {
		return review_re_num;
	}
	public void setReview_re_num(int review_re_num) {
		this.review_re_num = review_re_num;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	
	public String getReview_re_content() {
		return review_re_content;
	}
	public void setReview_re_content(String review_re_content) {
		this.review_re_content = review_re_content;
	}
	public String getReview_re_regdate() {
		return review_re_regdate;
	}
	public void setReview_re_regdate(String review_re_regdate) {
		this.review_re_regdate = DurationFromNow.getTimeDiffLabel(review_re_regdate);
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "ReviewReplyCommand [review_re_num=" + review_re_num + ", review_num=" + review_num
				+ ", review_re_content=" + review_re_content + ", review_re_regdate=" + review_re_regdate + ", mem_id="
				+ mem_id + "]";
	}
	
	
	
	
	
	
}
