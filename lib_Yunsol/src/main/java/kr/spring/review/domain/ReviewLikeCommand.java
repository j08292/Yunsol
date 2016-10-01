package kr.spring.review.domain;

public class ReviewLikeCommand {
	private int review_like_num;
	private String mem_id;
	private int review_num;
	private int review_like_status;
	
	public int getReview_like_num() {
		return review_like_num;
	}
	public void setReview_like_num(int review_like_num) {
		this.review_like_num = review_like_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public int getReview_like_status() {
		return review_like_status;
	}
	public void setReview_like_status(int review_like_status) {
		this.review_like_status = review_like_status;
	}
	@Override
	public String toString() {
		return "ReviewLikeCommand [review_like_num=" + review_like_num + ", mem_id=" + mem_id + ", review_num="
				+ review_num + ", review_like_status=" + review_like_status + "]";
	}
}
