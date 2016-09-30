package kr.spring.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperationGuideController {
	
	
	@RequestMapping(value="/board/operationGuide.do", method=RequestMethod.GET)
	public String form(){
		
		return "operationGuide";
	}
}
