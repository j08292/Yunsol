package kr.user.speech.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.speech.domain.SpeechReservationCommand;
import kr.spring.speech.service.SpeechService;

@Controller
public class SpeechReserveCancelController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/speech/cancelReserve.do")
	public ModelAndView submit(@RequestParam("speech_num") int speech_num,
						@RequestParam("speech_reserve_status") int speech_reserve_status,HttpSession session) throws Exception{
		String userId = (String)session.getAttribute("userId");
		SpeechReservationCommand command = new SpeechReservationCommand();
		
		if(log.isDebugEnabled()){
			log.debug("speech_num" + speech_num);
			log.debug("speech_reserve_status" + speech_reserve_status);
		}
		
		if(userId==null){//·Î±×ÀÎ ¾ÈµÊ
			ModelAndView mav = new ModelAndView();
			mav.setViewName("memberLogin");
			return mav;
		}else{//·Î±×ÀÎ µÊ
			command.setMem_id(userId);
			command.setSpeech_num(speech_num);
			command.setSpeech_reserve_status(speech_reserve_status);
			speechService.updateReservation(command);
			
			return new ModelAndView("redirect:/speech/reserveWaiting.do?speech_num="+speech_num);
		}
	}
}
