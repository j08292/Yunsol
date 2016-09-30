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

import kr.spring.speech.domain.SpeechReservationCommand;
import kr.spring.speech.service.SpeechService;
import kr.spring.util.PagingUtil;

@Controller
public class SpeechReserveCancelListController {

	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping("/admin/speech/speechReserveCancelList.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage){
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		
		int count = speechService.getReserveCancelCount(map);
		
		PagingUtil page = new PagingUtil(null,null,currentPage, count, rowCount,pageCount,"speechReserveCancelList.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<SpeechReservationCommand> list = null;
		
		if(count>0){
			list = speechService.speechReserveCancelList(map);
		}else{
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminSpeechReserveCancelList");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}	
}