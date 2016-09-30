package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	// 커맨드 객체 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping("/member/detail.do")
	public ModelAndView process(HttpSession session){
		
		String mem_id = (String)session.getAttribute("userId");
		
		if(log.isDebugEnabled()){
			log.debug("mem_id : " + mem_id);
		}
		
		MemberCommand member = memberService.selectMember(mem_id);
		                       //view이름      속성명    속성값
		return new ModelAndView("memberView","member",member);
	}
	
}










