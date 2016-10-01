package kr.spring.review.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.review.domain.ReviewLikeCommand;
import kr.spring.review.service.ReviewService;

@Controller
public class ReviewLikeInsertController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ReviewService reviewService;
	
	@RequestMapping("/board/insertLike.do")
	public ModelAndView process(@RequestParam("review_num") int review_num,
						  @RequestParam("review_like_status") int review_like_status,
						  SessionStatus status,
						  HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("review_num : " + review_num);
		}
		String mem_id = (String)session.getAttribute("userId");
		
		ReviewLikeCommand reviewLike = new ReviewLikeCommand();
		
		if(mem_id==null){//로그인 안됨
			ModelAndView mav = new ModelAndView();
			mav.setViewName("memberLogin");
			return mav;
		}else{//로그인 됨
			reviewLike.setMem_id(mem_id);
			reviewLike.setReview_num(review_num);
			
			int checkCount = reviewService.checkReviewLike(reviewLike);
			
			if(checkCount>0){//이미 좋아요 혹은 싫어요를 누른사람
				return new ModelAndView("redirect:/board/detail.do?review_num="+review_num);
			}else{
				reviewLike.setReview_like_status(review_like_status);
				
				reviewService.insertLike(reviewLike);
				status.setComplete();
				
				return new ModelAndView("redirect:/board/detail.do?review_num="+review_num);
			}
		}
	}
}
