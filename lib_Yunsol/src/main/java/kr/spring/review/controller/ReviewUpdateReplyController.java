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
public class ReviewUpdateReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ReviewService reviewService;
	
	
	@RequestMapping("/board/updateReplyAjax.do")
	@ResponseBody
	public Map<String,Object> process(
			ReviewReplyCommand reviewReplyCommand,
			HttpSession session){
		
		
		if(log.isDebugEnabled()){
			log.debug("reivewReplyCommand : " + reviewReplyCommand);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId == null){//로그인 안됨
				map.put("result", "logout");
			}else if(userId !=null && userId.equals(reviewReplyCommand.getMem_id())){
				//로그인, 작성자 일치, 댓글 등록
				reviewService.updateReply(reviewReplyCommand);
				map.put("result","success");
			}else{
				map.put("result","worngAccess");
			}			
		}catch(Exception e){
			e.printStackTrace();
			map.put("result","failure");
		}
		return map;
		
	}
	
	
	
}
