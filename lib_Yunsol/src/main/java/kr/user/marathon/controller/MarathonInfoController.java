package kr.user.marathon.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MarathonInfoController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/event/marathonInfo.do")
	public ModelAndView process(HttpSession session) throws Exception{
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null){
			return new ModelAndView("infoMarathon");
		}else{
			MemberCommand memberCommand = memberService.selectMember(userId);
			
			if(log.isDebugEnabled()){
				log.debug("memberCommand : " + memberCommand);
			}
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("infoMarathon");
			mav.addObject("member",memberCommand);
			
			return mav;
		}
	}
}
