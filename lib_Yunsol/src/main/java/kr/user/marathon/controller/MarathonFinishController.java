package kr.user.marathon.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.marathon.domain.MarathonCommand;
import kr.spring.marathon.service.MarathonService;

@Controller
public class MarathonFinishController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource 
	private MarathonService marathonService;
	
	@RequestMapping("/event/finishMarathon.do")
	public String process(@RequestParam("marathon_page") int marathon_page,HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("marathon_page : " + marathon_page);
		}
		String userId = (String)session.getAttribute("userId");
		if(userId == null){
			return "memberLogin";
		}else{
			marathonService.finishMrtStatus(userId);
			MarathonCommand marathonCommand = new MarathonCommand();
			marathonCommand.setMem_id(userId);
			marathonCommand.setMarathon_page(marathon_page);
			marathonService.insert(marathonCommand);
			return "redirect:/event/myMarathon.do";
		}
	}
}
