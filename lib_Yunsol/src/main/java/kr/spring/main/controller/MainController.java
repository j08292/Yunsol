package kr.spring.main.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.main.service.MainService;

@Controller
public class MainController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private MainService mainService;
	
	@RequestMapping("/main/main.do")
	public ModelAndView form(){
		
		int memberCount = mainService.getMemberCount();//회원수
		int bookCount = mainService.getBookCount();//보유 책권수
		int speechCount = mainService.getSpeechCount();//현재 진행중인 강연수
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("memberCount",memberCount);
		mav.addObject("bookCount",bookCount);
		mav.addObject("speechCount",speechCount);
		return mav;
	}
}
