package kr.spring.main.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	public ModelAndView form(HttpSession session){
		
		int memberCount = mainService.getMemberCount();//ȸ����
		int bookCount = mainService.getBookCount();//���� å�Ǽ�
		int speechCount = mainService.getSpeechCount();//���� �������� ������
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		session.setAttribute("memberCount",memberCount);
		session.setAttribute("bookCount",bookCount);
		session.setAttribute("speechCount",speechCount);
		return mav;
	}
}
