package kr.admin.review.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.FileUtil;

@Controller
public class AdminReviewDetailDeleteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="reviewService")
	private ReviewService reviewService;

	@RequestMapping("/admin/review/detailDelete.do")
	public String submit(@RequestParam("review_num") int review_num) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("review_num : " + review_num);
		}

		ReviewCommand reviewCommand = reviewService.selectReview(review_num);
		
		//글 삭제
		reviewService.delete(reviewCommand.getReview_num());

		//파일 삭제 여부 체크
		if(reviewCommand.getReview_file()!=null){
			FileUtil.removeFile(reviewCommand.getReview_file());
		}
		
		return "redirect:/admin/review/list.do";
	}
}