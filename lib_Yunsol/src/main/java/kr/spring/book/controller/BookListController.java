package kr.spring.book.controller;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.book.domain.BookListCommand;
import kr.spring.book.service.BookListService;
import kr.spring.util.PagingUtil;

@Controller
public class BookListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private BookListService bookListService;
	
/*	@RequestMapping(value = "/book/search.do", method = RequestMethod.GET)
	public String form(){
		return "bookSearch";
	}*/
	
	@RequestMapping("/book/search.do")
	public ModelAndView submit(
	                    @RequestParam(value="pageNum",defaultValue="1") 
    					int currentPage,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
    					@RequestParam(value="keyfield",defaultValue="")
						String keyfield,
						@RequestParam(value="keyword",defaultValue="")
						String keyword){
		
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = bookListService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,
				                  count,rowCount,pageCount,"search.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BookListCommand> list = null;
		if(count > 0){
			list = bookListService.list(map);
		}else{
			list = Collections.emptyList();
		}
		
		if(log.isDebugEnabled()){
			log.debug("count : " + count);
			log.debug("list : " + list);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookSearch");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
}
