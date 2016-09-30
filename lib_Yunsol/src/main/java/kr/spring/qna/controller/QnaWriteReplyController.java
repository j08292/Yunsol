package kr.spring.qna.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.qna.domain.QnaReplyCommand;
import kr.spring.qna.service.QnaService;

@Controller
public class QnaWriteReplyController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnaService qnaService;
	
	@RequestMapping("/board/qWriteReplyAjax.do")
	@ResponseBody
	public Map<String, String> process(
						QnaReplyCommand qnaReplyCommand,
						HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("qnaReplyCommand : " +qnaReplyCommand);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		try{
			String userId =(String)session.getAttribute("userId");
			if(userId == null ){
				map.put("result", "logout");
				
			}else{
				
				qnaService.insertReply(qnaReplyCommand);
				
				
				map.put("result", "success");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
	}
	