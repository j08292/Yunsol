package kr.user.marathon.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.marathon.domain.MarathonCommand;
import kr.spring.marathon.service.MarathonService;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.util.PagingUtil;

@Controller
public class MarathonPageController {
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private MarathonService marathonService;
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/event/myMarathon.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage, HttpSession session) throws Exception{
		String userId = (String)session.getAttribute("userId");
		if(userId == null){
			return new ModelAndView("memberLogin");
		}else{
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("mem_id", userId);
			int count = marathonService.getRowCount(map);
			
			PagingUtil page = new PagingUtil(null, null, currentPage, count, rowCount,pageCount,"myMarathon.do");
			
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			List<MarathonCommand> pageList = null;
			List<MarathonCommand> rentedList = null;
			if(count>0){
				rentedList = marathonService.rentedList(map);
				pageList = marathonService.pageList(userId);
			}else{
				rentedList=Collections.emptyList();
				pageList = Collections.emptyList();
			}
			
			MemberCommand memberCommand = memberService.selectMember(userId);

			if(log.isDebugEnabled()){
				log.debug("memberCommand : " + memberCommand);
			}
			ModelAndView mav = new ModelAndView();
			mav.setViewName("myMarathon");
			mav.addObject("member",memberCommand);
			mav.addObject("count",count);
			mav.addObject("rentedList",rentedList);
			mav.addObject("pageList",pageList);
			mav.addObject("pagingHtml",page.getPagingHtml());
			return mav;
		}
	}
}
