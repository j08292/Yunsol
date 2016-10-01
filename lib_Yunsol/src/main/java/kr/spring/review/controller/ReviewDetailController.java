package kr.spring.review.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.domain.ReviewLikeCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.FileUtil;
import kr.spring.util.StringUtil;

@Controller
public class ReviewDetailController {

	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private ReviewService reviewService;
	
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("review_num") int review_num,HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("review_num : " + review_num);
		}
		
		//해당 글의 조회수 증가
		reviewService.updateHit(review_num);
		ReviewCommand review = reviewService.selectReview(review_num);
		
		//타이틀 태그 불허
		review.setReview_title(StringUtil.useNoHtml(review.getReview_title()));
		
		//줄바꿈처리
		review.setReview_content(StringUtil.useBrNoHtml(review.getReview_content()));
		
		
		String userId = (String)session.getAttribute("userId");
		ReviewLikeCommand reviewLike = new ReviewLikeCommand();
		reviewLike.setReview_num(review_num);
		reviewLike.setReview_like_status(0);
		int reviewLikeCount = reviewService.getReviewLikeCount(reviewLike);//이 글의 좋아요수
		
		ReviewLikeCommand reviewUnlike = new ReviewLikeCommand();
		reviewUnlike.setReview_num(review_num);
		reviewUnlike.setReview_like_status(1);
		int reviewUnlikeCount = reviewService.getReviewLikeCount(reviewUnlike);//이 글의 싫어요수
		
		if(userId==null){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("reviewView");
			mav.addObject("review",review);
			mav.addObject("reviewLikeCount",reviewLikeCount);
			mav.addObject("reviewUnlikeCount",reviewUnlikeCount);
			return mav;
		}else{
			ReviewLikeCommand reviewAllLike = new ReviewLikeCommand();
			reviewAllLike.setMem_id(userId);
			reviewAllLike.setReview_num(review_num);
			int checkCount = reviewService.checkReviewLike(reviewAllLike);//로그인 회원이 좋아요 싫어요 했는지 안했는지 체크
			if(checkCount>0){//좋아요 혹은 싫어요 했을 경우
				int likeOrUnlike = reviewService.getWhatDidYouCheck(reviewAllLike);
				ModelAndView mav = new ModelAndView();
				mav.setViewName("reviewView");
				mav.addObject("review",review);
				mav.addObject("reviewLikeCount",reviewLikeCount);
				mav.addObject("reviewUnlikeCount",reviewUnlikeCount);
				mav.addObject("checkCount",checkCount);
				mav.addObject("likeOrUnlike",likeOrUnlike);
				return mav;
			}else{//좋아요 혹은 싫어요 안했을 경우
				ModelAndView mav = new ModelAndView();
				mav.setViewName("reviewView");
				mav.addObject("review",review);
				mav.addObject("reviewLikeCount",reviewLikeCount);
				mav.addObject("reviewUnlikeCount",reviewUnlikeCount);
				mav.addObject("checkCount",checkCount);
				return mav;
			}
		}
	}
	
	//파일 다운로드
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("review_file")
									String review_file)throws Exception{					
		File downloadFile= new File(FileUtil.UPLOAD_PATH + "/" +review_file);
		
		
		return new ModelAndView("downloadView","downloadFile",downloadFile);
	}
	
	
	
}

