package kr.spring.review.controller;

import java.io.File;
import java.sql.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.FileUtil;
import kr.spring.util.StringUtil;

@Controller
public class ReviewDetailController {

	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private ReviewService reviewService;
	
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("review_num") int review_num){
		
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
		
		return new ModelAndView("reviewView","review",review);
	}
	


	
	//파일 다운로드
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("review_file")
									String review_file)throws Exception{					
		File downloadFile= new File(FileUtil.UPLOAD_PATH + "/" +review_file);
		
		
		return new ModelAndView("downloadView","downloadFile",downloadFile);
	}
	
	
	
}

