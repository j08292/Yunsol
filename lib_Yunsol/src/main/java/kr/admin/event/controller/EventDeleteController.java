package kr.admin.event.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;
import kr.spring.util.FileUtil;

@Controller
public class EventDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/admin/event/delete.do")
	public String submit(@RequestParam("event_num")int event_num)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("event_num : " + event_num);
		}
		
		EventCommand eventCommand = eventService.selectEvent(event_num);
		//글삭제
		eventService.delete(eventCommand.getEvent_num());
		
		//파일삭제 여부 체크
		if(eventCommand.getEvent_filename()!=null){
			FileUtil.removeFile(eventCommand.getEvent_filename());
		}
		return "redirect:/admin/event/list.do";
	}
}
