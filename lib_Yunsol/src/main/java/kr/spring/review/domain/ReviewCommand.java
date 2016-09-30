package kr.spring.review.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ReviewCommand {
	
	private int review_num;//글번호
	@NotEmpty
	private String review_title;//글제목
	@NotEmpty   
	private String review_content;//내용
	private Date review_regdate;//날짜
	private int review_hit;//조회수
	private int review_like;//좋아요
	private int review_dislike;//싫어요
	private MultipartFile upload;	
	private String review_file;
	@NotEmpty
	private String mem_id;//작성자 아이디
	private int review_replyCount;//댓글수
	
	
	

	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Date getReview_regdate() {
		return review_regdate;
	}
	public void setReview_regdate(Date review_regdate) {
		this.review_regdate = review_regdate;
	}
	public int getReview_hit() {
		return review_hit;
	}
	public void setReview_hit(int review_hit) {
		this.review_hit = review_hit;
	}
	public int getReview_like() {
		return review_like;
	}
	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}
	public int getReview_dislike() {
		return review_dislike;
	}
	public void setReview_dislike(int review_dislike) {
		this.review_dislike = review_dislike;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getReview_file() {
		return review_file;
	}
	public void setReview_file(String review_file) {
		this.review_file = review_file;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getReview_replyCount() {
		return review_replyCount;
	}
	public void setReview_replyCount(int review_replyCount) {
		this.review_replyCount = review_replyCount;
	}
	@Override
	public String toString() {
		return "ReviewCommand [review_num=" + review_num + ", review_title=" + review_title + ", review_content="
				+ review_content + ", review_regdate=" + review_regdate + ", review_hit=" + review_hit
				+ ", review_like=" + review_like + ", review_dislike=" + review_dislike + ", upload=" + upload
				+ ", review_file=" + review_file + ", mem_id=" + mem_id + ", review_replyCount=" + review_replyCount
				+ "]";
	}
}
