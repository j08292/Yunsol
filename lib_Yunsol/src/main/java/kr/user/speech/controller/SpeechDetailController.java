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
import kr.spring.util.StringUtil;

@Controller
public class SpeechDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/speech/detail.do")
	public ModelAndView process(@RequestParam("speech_num") int speech_num,HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("speech_num : "+speech_num);
		}
		
		//해당 글의 조회수 증가
		speechService.updateHit(speech_num);
		//해당 글의 예약자 확인
		int res = speechService.countRes(speech_num);
		SpeechCommand speech = speechService.selectSpeech(speech_num);
		
		//타이틀 태그 불허
		speech.setSpeech_title(StringUtil.useNoHtml(speech.getSpeech_title()));
		
		//줄바꿈 처리
		speech.setSpeech_content(StringUtil.useBrNoHtml(speech.getSpeech_content()));
		
		//예약자 불러오기
		String userId = (String)session.getAttribute("userId");
		if(userId==null){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userSpeechDetail");
			mav.addObject("speech",speech);
			mav.addObject("res",res);
			return mav;
		}else{
			SpeechReservationCommand command = new SpeechReservationCommand();
			command.setSpeech_num(speech_num);
			command.setMem_id(userId);
			SpeechReservationCommand speechReserve = speechService.selectReservation(command);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userSpeechDetail");
			mav.addObject("speech",speech);
			mav.addObject("speechReserve",speechReserve);
			mav.addObject("res",res);
			return mav;
		}
	}
	
}
