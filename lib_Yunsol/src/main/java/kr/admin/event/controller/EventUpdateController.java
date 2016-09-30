package kr.admin.event.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class EventUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping(value="/admin/event/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("event_num")int event_num, Model model){
		
		EventCommand eventCommand = eventService.selectEvent(event_num);
		model.addAttribute("command", eventCommand);
		
		return "eventModify";
	}
	
	@RequestMapping(value="/admin/event/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 @Valid EventCommand eventCommand,
						 BindingResult result,
						 SessionStatus status)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : " + eventCommand);
		}
		
		if(result.hasErrors()){
			return "eventModify";
		}
		
		EventCommand event = 
				eventService.selectEvent(eventCommand.getEvent_num());
		String oldFileName = "";
		//기존 파일명 구함
		//업로드되는 파일이 있을 경우 기존 파일을 삭제 새로운 파일명 셋팅
		//업로드되는 파일이 없을 경우 기존 파일명 셋팅
		oldFileName = event.getEvent_filename();
		if(!eventCommand.getEvent_upload().isEmpty()){
			eventCommand.setEvent_filename(FileUtil.rename(eventCommand.getEvent_upload().getOriginalFilename()));
		}else{
			//전송된 파일이 없을 경우
			eventCommand.setEvent_filename(oldFileName);
		}
		//글수정
		eventService.update(eventCommand);
		status.setComplete();
		
		if(!eventCommand.getEvent_upload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH+"/"+eventCommand.getEvent_filename());
			eventCommand.getEvent_upload().transferTo(file);
			
			if(oldFileName!=null){
				//이전파일삭제
				FileUtil.removeFile(oldFileName);
			}
		}
		return "redirect:/admin/event/list.do";
	}
}
