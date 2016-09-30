package kr.spring.qna.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.service.QnaService;
import kr.spring.util.PagingUtil;

@Controller
public class QnaListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private QnaService qnaService;
	
	
	@RequestMapping("/board/qnaList.do")
	private ModelAndView process(@RequestParam(value = "pageNum", defaultValue="1")
								int currentPage,
								@RequestParam(value="keyfield" , defaultValue="")
								String keyfield,
								@RequestParam(value="keyword", defaultValue="")
								String keyword){
		
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " +keyword);
		}
		
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("keyfield" , keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = qnaService.getRowCount(map);
		
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count,
										rowCount, pageCount, "qnalist.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
	
		
		List<QnaCommand> list = null;
		if(count > 0){
			list = qnaService.adminList(map);
		}else{
			list=Collections.emptyList();
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaList");
		mav.addObject("count",count);
		mav.addObject("list",list);
		mav.addObject("pagingHtml" ,page.getPagingHtml());	
		
		
		return mav;
		
		
	}	

}
