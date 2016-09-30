package kr.admin.event.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class EventWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private EventService eventService;
	
	@RequestMapping(value="/admin/event/write.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		String mem_id = (String)session.getAttribute("userId");
		
		EventCommand command = new EventCommand();
		command.setMem_id(mem_id);
		
		model.addAttribute("command", command);
		
		return "eventWrite";
	}
	
	@RequestMapping(value="/admin/event/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
						 @Valid EventCommand eventCommand,
						 BindingResult result,
						 SessionStatus status) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("eventCommand : " + eventCommand);
		}
		if(result.hasErrors()){
			return "eventWrite";
		}
		
		String newName = "";
		if(!eventCommand.getEvent_upload().isEmpty()){
			newName=FileUtil.rename(eventCommand.getEvent_upload().getOriginalFilename());
			eventCommand.setEvent_filename(newName);
		}
		//±Û µî·Ï
		eventService.insert(eventCommand);
		status.setComplete();
		
		if(!eventCommand.getEvent_upload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH+"/"+newName);
			eventCommand.getEvent_upload().transferTo(file);
		}
		return "redirect:/admin/event/list.do";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
