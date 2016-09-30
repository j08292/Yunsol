package kr.admin.speech.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.speech.service.SpeechService;

@Controller
public class SpeechReservateDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/admin/speech/reservationDelete.do")
	public ModelAndView submit(@RequestParam("speech_reserve_num") int speech_reserve_num,
								@RequestParam("speech_num") int speech_num)throws Exception{
		if(log.isDebugEnabled()){
			log.debug("speech_reserve_num" + speech_reserve_num);
		}
		
		speechService.deleteReservation(speech_reserve_num);
		return new ModelAndView("redirect:/admin/speech/reservationList.do?speech_num="+speech_num);
	}
}
