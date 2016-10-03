package kr.admin.speech.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.service.SpeechService;
import kr.spring.util.FileUtil;

@Controller
public class SpeechDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/admin/speech/delete.do")
	public String submit(@RequestParam("speech_num") int speech_num) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("speech_num : " + speech_num);
		}
		
		SpeechCommand speechCommand = speechService.selectSpeech(speech_num);
		int resCount = speechService.checkRes(speech_num);
		if(resCount==0){
			speechService.delete(speechCommand.getSpeech_num());
			//颇老 昏力 咯何 眉农
			if(speechCommand.getSpeech_filename()!=null){
				FileUtil.removeFile(speechCommand.getSpeech_filename());
			}
		}
		
		return "redirect:/admin/speech/list.do";
		
	}
}
