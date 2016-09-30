package kr.spring.adminMember.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.adminMember.domain.AdminMemberCommand;
import kr.spring.adminMember.service.AdminMemberService;
import kr.spring.util.PagingUtil;

@Controller
public class AdminMemberListController {
	private Logger log= Logger.getLogger(this.getClass());

	private int rowCount=10;
	private int pageCount=10;

	@Resource
	private AdminMemberService adminMemberService;

	
	@RequestMapping("/admin/member/list.do")
	public ModelAndView submit(@RequestParam(value="pageNum",defaultValue="1")int currentPage,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
							   @RequestParam(value="keyfield",defaultValue="")String keyfield,
							   @RequestParam(value="keyword",defaultValue="")String keyword,
							   HttpServletRequest request){
		if(log.isDebugEnabled()){
			log.debug("currentPage : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);

		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = adminMemberService.getRowCount(map);

		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,request.getContextPath()+"/admin/member/list.do");

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<AdminMemberCommand> list = null;
		if(count > 0){
			list = adminMemberService.list(map);
		}else{
			list = Collections.emptyList();
		}

		if(log.isDebugEnabled()){
			log.debug("count : " + count);
			log.debug("list : " + list);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminMemberList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
}