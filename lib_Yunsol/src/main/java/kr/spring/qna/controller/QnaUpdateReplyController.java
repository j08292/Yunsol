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
public class QnaUpdateReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnaService qnaservice;
	
	
	
	@RequestMapping("/board/qUpdateReplyAjax.do")
	@ResponseBody
	public Map<String, Object> process(
						QnaReplyCommand qnaReplyCommand,
						HttpSession session){
		
		
		if(log.isDebugEnabled()){
			log.debug("qnaReplyCommand : " + qnaReplyCommand);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		try{
			String userId = (String) session.getAttribute("userId");
			if(userId == null){
				map.put("result", "logout");
			}else if(userId != null &&userId.equals(qnaReplyCommand.getMem_id())){
				qnaservice.updateReply(qnaReplyCommand);
				map.put("result", "success");
			}else{
				map.put("result", "worngAccess");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result","failure");
		
		
	}
	return map;
}
}
