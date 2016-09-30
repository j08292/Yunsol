package kr.admin.speech.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.speech.service.SpeechService;

@Controller
public class SpeechCancelSaveController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/admin/speech/cancel.do")
	public String submit(@RequestParam("speech_num") int speech_num){
		if(log.isDebugEnabled()){
			log.debug("speech_num : " + speech_num);
		}
		
		speechService.cancel(speech_num);
		
		return "redirect:/admin/speech/list.do";
		
	}
}