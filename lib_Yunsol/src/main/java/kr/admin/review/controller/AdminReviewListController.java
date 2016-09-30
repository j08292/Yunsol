package kr.admin.review.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.PagingUtil;

@Controller
public class AdminReviewListController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private ReviewService reviewService;

	@RequestMapping("admin/review/list.do")
	private ModelAndView process(@RequestParam(value="pageNum" , defaultValue="1")int currentPage,
								 @RequestParam(value="keyfield" , defaultValue="")String keyfield,
								 @RequestParam(value="keyword", defaultValue="")String keyword){
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " +keyword);
		}
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("keyfield" , keyfield);
		map.put("keyword", keyword);

		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = reviewService.getRowCount(map);

		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count,rowCount, pageCount, "list.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ReviewCommand> adminList = null;
		if(count > 0){
			adminList = reviewService.adminList(map);
		}else{
			adminList=Collections.emptyList();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminReviewList");
		mav.addObject("count",count);
		mav.addObject("list",adminList);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}	
}