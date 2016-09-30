package kr.spring.event.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.event.domain.EventReplyCommand;
import kr.spring.event.service.EventService;

@Controller
public class EventUpdateReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/event/updateReplyAjax.do")
	@ResponseBody
	public Map<String,String> process(
			EventReplyCommand eventReplyCommand,
			HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("eventReplyCommand : " + eventReplyCommand);
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId == null){//로그인 안됨
				map.put("result", "logout");
			}else if(userId != null && userId.equals(eventReplyCommand.getMem_id())){
				//로그인, 작성자 일치, 댓글 등록
				eventService.updateReply(eventReplyCommand);
				map.put("result", "success");
			}else{
				map.put("result", "wrongAccess");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
	
}