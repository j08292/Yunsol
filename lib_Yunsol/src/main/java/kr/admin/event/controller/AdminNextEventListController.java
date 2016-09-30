package kr.admin.event.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.service.EventService;
import kr.spring.util.PagingUtil;

@Controller
public class AdminNextEventListController {
private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 12;
	private int pageCount = 10;
	
	@Resource
	private EventService eventService;
	
	@RequestMapping("/admin/event/nextEventList.do")
	public ModelAndView process(
			@RequestParam(value="pageNum", defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield", defaultValue="")
			String keyfield,
			@RequestParam(value="keyword", defaultValue="")
			String keyword){
		
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = eventService.getAdminNextEventCount(map);
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, 
								count, rowCount, pageCount,"nextEventList.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<EventCommand> list = null;
		
		if(count > 0){
			list = eventService.adminNextEventList(map);
		}else{
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminNextEventList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		return mav;
	}
}