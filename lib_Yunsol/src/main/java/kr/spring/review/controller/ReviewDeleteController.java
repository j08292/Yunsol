package kr.spring.review.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.FileUtil;

@Controller
public class ReviewDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name="reviewService")
	private ReviewService reviewService;
	
	@RequestMapping("/board/delete.do")
	public String submit(@RequestParam("review_num") int review_num,
			             HttpSession session) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("review_num : " + review_num);
		}
		
		ReviewCommand reviewCommand = reviewService.selectReview(review_num);
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(reviewCommand.getMem_id())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 삭제할 수 없습니다.");
		}
		
		//글 삭제
		reviewService.delete(reviewCommand.getReview_num());
		
		//파일 삭제 여부 체크
		if(reviewCommand.getReview_file()!=null){
			FileUtil.removeFile(reviewCommand.getReview_file());
		}
		
		return "redirect:/board/list.do";
	}
}
