package kr.spring.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.domain.ReviewReplyCommand;

@Transactional
public interface ReviewService {	
	//부모글
	@Transactional(readOnly=true)
	public List<ReviewCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);//list에서 글번호수?
	public void insert(ReviewCommand review);
	@Transactional(readOnly=true)
	public ReviewCommand selectReview(Integer review_num);//
	public void updateHit(Integer review_num);
	public void update(ReviewCommand review);
	public void delete(Integer review_num);

	//댓글
	@Transactional(readOnly=true)
	public List<ReviewReplyCommand> listReply (Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map <String, Object> map);
	public void insertReply(ReviewReplyCommand reviewReplyCommand);
	public void updateReply(ReviewReplyCommand reviewReplyCommand);
	public void deleteReply(Integer review_re_num);
	
	//관리자 게시물 관리===================================================================
	public List<ReviewCommand> adminList(Map<String, Object> map);
	//파일 삭제를 위해 글 정보 가져오기
	public List<ReviewCommand> selectReviewAdmin(List<Integer> list);
	//해당 글번호의 게시글 삭제
	public void deleteByReviewNum(List<Integer> list);
}