package kr.spring.review.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.review.domain.ReviewReplyCommand;
import kr.spring.review.service.ReviewService;

@Controller
public class ReviewWriteReplyController {
	
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ReviewService reviewService;
	
	@RequestMapping("/board/writeReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(
			ReviewReplyCommand reviewReplyCommand,
			HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("reviewReplyCommand : " + reviewReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		int review_re_count= 1;
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId == null){//·Î±×ÀÎ ¾ÈµÊ
				map.put("result", "logout");
			}else{//·Î±×ÀÎ µÊ
				//´ñ±Û µî·Ï
				reviewService.insertReply(reviewReplyCommand);
			
				
				
							
				map.put("result", "success");
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
	
}
