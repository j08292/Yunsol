package kr.admin.event.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;
import kr.spring.util.StringUtil;

@Controller
public class AdminEventDetailController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/admin/event/detail.do")
	public ModelAndView process(@RequestParam("event_num")int event_num){
		if(log.isDebugEnabled()){
			log.debug("event_num : " + event_num);
		}
		
		EventCommand event = eventService.selectEvent(event_num);
		
		//타이틀 태그 불허
		event.setEvent_title(StringUtil.useNoHtml(event.getEvent_title()));
		
		//줄바꿈처리
		event.setEvent_content(StringUtil.useBrNoHtml(event.getEvent_content()));
		
		return new ModelAndView("adminEventDetail","event",event);
	}
}
