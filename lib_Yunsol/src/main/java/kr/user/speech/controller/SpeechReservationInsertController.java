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
public class SpeechReservationInsertController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/speech/reserveSuccess.do")
	public ModelAndView process(@RequestParam("speech_num") int speech_num,
								@RequestParam("speech_reserve_status") int speech_reserve_status,HttpSession session)throws Exception{
		String userId = (String)session.getAttribute("userId");
		
		SpeechReservationCommand command = new SpeechReservationCommand();
		
		if(log.isDebugEnabled()){
			log.debug("speechReservationCommand : " + command);
		}
		
		if(userId==null){//로그인 안됨
			ModelAndView mav = new ModelAndView();
			mav.setViewName("memberLogin");
			return mav;
		}else{//로그인 됨
			command.setMem_id(userId);
			command.setSpeech_num(speech_num);
			
			Integer checkCount = speechService.checkSpeechReservation(command);
			
			if(checkCount!=null){//이미 신청한 사람일경우 다시 돌아가게
				return new ModelAndView("redirect:/speech/detail.do?speech_num="+speech_num);
			}else{
				command.setMem_id(userId);
				command.setSpeech_num(speech_num);
				command.setSpeech_reserve_status(speech_reserve_status);
				speechService.insertReservation(command);
				SpeechCommand speech = speechService.selectSpeech(speech_num);
				SpeechReservationCommand speechReserve = speechService.selectReservation(command);
				ModelAndView mav = new ModelAndView();
				mav.setViewName("reserveSuccess");
				mav.addObject("speech",speech);
				mav.addObject("speechReserve",speechReserve);
				return mav;
			}
		}
	}
}
