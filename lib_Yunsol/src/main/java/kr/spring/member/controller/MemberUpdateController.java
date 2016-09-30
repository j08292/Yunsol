package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
@SessionAttributes("command")
public class MemberUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/member/update.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		
		String mem_id = (String)session.getAttribute("userId");
		MemberCommand memberCommand = memberService.selectMember(mem_id);
		//모델에 저장된 정보는 @SessionAttributes("command")를
		//통해 세션에 저장
		model.addAttribute("command", memberCommand);
		
		return "memberModify";
	}
	
	@RequestMapping(value="/member/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")
	                     @Valid MemberCommand memberCommand,
	                     BindingResult result,
	                     SessionStatus status){
		
		if(log.isDebugEnabled()){
			log.debug("memberCommand : " + memberCommand);
		}
		
		//유효성 체크
		if(result.hasErrors()){
			return "memberModify";
		}
		
		memberService.update(memberCommand);
		//session에 저장된 model을 삭제하는 이벤트 발생
		status.setComplete();

		return "redirect:/member/detail.do";
	}
	
};




