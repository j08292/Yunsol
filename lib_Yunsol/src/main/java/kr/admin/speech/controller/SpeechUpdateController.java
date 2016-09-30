package kr.admin.speech.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.service.SpeechService;

@Controller
@SessionAttributes("command")
public class SpeechUpdateController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping(value="/admin/speech/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("speech_num") int speech_num, Model model){
		SpeechCommand speechCommand = speechService.selectSpeech(speech_num);
		model.addAttribute("command",speechCommand);
		
		return "speechUpdate";
	}
	
	@RequestMapping(value="/admin/speech/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid SpeechCommand speechCommand, BindingResult result,SessionStatus status, HttpSession session) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("speechCommand : " + speechCommand);
		}
				
		if(result.hasErrors()){
			return "speechUpdate";
		}
		
		//±Û¼öÁ¤
		speechService.update(speechCommand);
		status.setComplete();
		return "redirect:/admin/speech/list.do";
	}
}
