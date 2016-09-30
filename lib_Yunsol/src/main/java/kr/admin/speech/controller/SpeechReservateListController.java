package kr.admin.speech.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.domain.SpeechReservationCommand;
import kr.spring.speech.service.SpeechService;
import kr.spring.util.PagingUtil;
import kr.spring.util.PagingUtil_SpeechReserve;

@Controller
public class SpeechReservateListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private SpeechService speechService;
	//글번호 받아오기
	@RequestMapping("/admin/speech/reservationList.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage, 
			@RequestParam(value="keyfield",defaultValue="") String keyfield,
			@RequestParam(value="keyword",defaultValue="") String keyword,
			@RequestParam("speech_num") int speech_num){
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
			log.debug("speech_num : " + speech_num);
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		map.put("speech_num", speech_num);
		
		//총 글의 갯수 또는 검색된 글의 갯수
		int count = speechService.getRowCountReservation(map);
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount,pageCount,"reservationList.do?speech_num="+speech_num);
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		List<SpeechReservationCommand> list = null;
		if(count>0){
			list = speechService.reserveList(map);
		}else{
			list = Collections.emptyList();
		}
		
		SpeechCommand speech = speechService.selectSpeech(speech_num);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminSpeechReservateList");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("speech",speech);
		mav.addObject("pagingHtml",page.getPagingHtml());
		
		return mav;
	}
	
}
