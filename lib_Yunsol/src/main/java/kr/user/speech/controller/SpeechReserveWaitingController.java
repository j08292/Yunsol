package kr.user.speech.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.domain.SpeechReservationCommand;
import kr.spring.speech.service.SpeechService;

@Controller
public class SpeechReserveWaitingController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/speech/reserveWaiting.do")
	public ModelAndView process(@RequestParam("speech_num") int speech_num,HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("speech_num : "+speech_num);
		}
		String userId = (String)session.getAttribute("userId");
		SpeechCommand speech = speechService.selectSpeech(speech_num);
		
		SpeechReservationCommand speechReserveCommand = new SpeechReservationCommand();
		
		speechReserveCommand.setMem_id(userId);
		speechReserveCommand.setSpeech_num(speech_num);
		
		SpeechReservationCommand speechReserve = speechService.selectReservation(speechReserveCommand);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("speechReserveWaiting");
		mav.addObject("speech",	speech);
		mav.addObject("speechReserve",speechReserve);
		
		return mav;
	}
}
