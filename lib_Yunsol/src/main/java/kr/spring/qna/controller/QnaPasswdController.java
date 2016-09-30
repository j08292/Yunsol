package kr.spring.qna.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.service.QnaService;

@Controller
@SessionAttributes("qnaCommand")
public class QnaPasswdController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private QnaService qnaService;
	
	@RequestMapping(value="/board/qnaPasswd.do", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("qna_num")int qna_num){
		QnaCommand qna = new QnaCommand();
		qna.setQna_num(qna_num);
		return new ModelAndView("qnaPasswd" ,"qnaCommand",qna);
	}
	
	@RequestMapping(value="/board/qnaPasswd.do", method=RequestMethod.POST)	
	public ModelAndView submit(@ModelAttribute("qnaCommand")
						@Valid QnaCommand qnaCommand,
						BindingResult result,
						SessionStatus status){
		
		if(log.isDebugEnabled()){
			log.debug("qnaCommand : " + qnaCommand);
		}
		
		
		QnaCommand qna = qnaService.selectQna(qnaCommand.getQna_num());
		
		if(!qna.isCheckedPwd(qnaCommand.getQna_passwd())){
			result.reject("invalidPassword");
			
			return form(qnaCommand.getQna_num());
		}else{
			return new ModelAndView("redirect:/board/qnaDetail.do?qna_num="+qnaCommand.getQna_num());
		}
		
	}
	
}
