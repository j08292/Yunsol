package kr.admin.grade.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.grade.domain.GradeCommand;
import kr.spring.grade.service.GradeService;
import kr.spring.util.PagingUtil;

@Controller
public class AdminGradeListController {
	private Logger log = Logger.getLogger(getClass());
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private GradeService gradeService;

	@RequestMapping("/admin/grade/list.do")
	private ModelAndView process(@RequestParam(value="pageNum" , defaultValue="1")int currentPage,
								 @RequestParam(value="keyfield" , defaultValue="")String keyfield,
								 @RequestParam(value="keyword", defaultValue="")String keyword){
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " +keyword);
		}

		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("keyfield" , keyfield);
		map.put("keyword", keyword);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = gradeService.getAdminRowCountGrade(map);

		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count,rowCount, pageCount, "list.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<GradeCommand> adminGradeList = null;
		if(count > 0){
			adminGradeList = gradeService.adminGradeList(map);
		}else{
			adminGradeList = Collections.emptyList();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminGradeList");
		mav.addObject("count",count);
		mav.addObject("list",adminGradeList);
		mav.addObject("pagingHtml",page.getPagingHtml());

		return mav;
	}
}