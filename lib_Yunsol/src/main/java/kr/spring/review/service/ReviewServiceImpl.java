package kr.spring.review.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.review.dao.ReviewMapper;
import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.domain.ReviewReplyCommand;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{

	@Resource
	private ReviewMapper reviewMapper;
	
	@Override
	public List<ReviewCommand> list(Map<String, Object> map) {
		return reviewMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return reviewMapper.getRowCount(map);
	}

	@Override
	public void insert(ReviewCommand review) {
		reviewMapper.insert(review);		
	}

	@Override
	public ReviewCommand selectReview(Integer review_num) {
		return reviewMapper.selectReview(review_num);
	}

	@Override
	public void updateHit(Integer review_num) {
		reviewMapper.updateHit(review_num);		
	}

	@Override
	public void update(ReviewCommand review) {
		reviewMapper.update(review);		
	}

	@Override
	public void delete(Integer review_num) {		
		reviewMapper.deleteReplyByReview_num(review_num);		
		reviewMapper.delete(review_num);		
	}	
	
	//댓글!!	
	@Override
	public List<ReviewReplyCommand> listReply(Map<String, Object> map) {
		return reviewMapper.listReply(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		System.out.println(map);
		return reviewMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(ReviewReplyCommand reviewReplyCommand) {
		reviewMapper.insertReply(reviewReplyCommand);		
	}

	@Override
	public void updateReply(ReviewReplyCommand reviewReplyCommand) {
		reviewMapper.updateReply(reviewReplyCommand);		
	}

	@Override
	public void deleteReply(Integer review_re_num) {
		reviewMapper.deleteReply(review_re_num);		
	}

	//관리자 게시물 관리 시작=======================================
	@Override
	public List<ReviewCommand> adminList(Map<String, Object> map) {
		return reviewMapper.adminList(map);
	}
	
	@Override
	public void deleteByReviewNum(List<Integer> list) {		
		//해당 글번호에 작성된 모든 댓글 삭제
		reviewMapper.deleteReplyByReviewNum(list);
		//해당 글번호의 게시글 삭제
		reviewMapper.deleteByReviewNum(list);
	}	

	@Override
	public List<ReviewCommand> selectReviewAdmin(List<Integer> list) {
		//파일 삭제를 위해 글 정보 가져오기
		return reviewMapper.selectReviewAdmin(list);
	}
	//관리자 게시물 관리 끝=======================================
}