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
public class QnaDeleteController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="qnaService")
	private QnaService qnaService;
	
	
	@RequestMapping(value="/board/qnaDelete.do", method=RequestMethod.GET)	
	public ModelAndView form(@RequestParam("qna_num")int qna_num){
		
		
		QnaCommand qCommand = new QnaCommand();
		qCommand.setQna_num(qna_num);
		
		return new ModelAndView("qnaDelete" ,"qnaCommand",qCommand);
		
		
	}
	
	@RequestMapping(value="/board/qnaDelete.do", method=RequestMethod.POST)	
	public String submit(@ModelAttribute("qnaCommand")
						@Valid QnaCommand qnaCommand,
						BindingResult result,
						SessionStatus status){
		
		//pwd필드의 에러만 체크
		if(result.hasFieldErrors("qna_passwd")){
			return "qnaDelete";
		}
		
		QnaCommand qna = qnaService.selectQna(qnaCommand.getQna_num());
		
		
		//비밀번호 일치여부체크
		if(!qna.isCheckedPwd(qnaCommand.getQna_passwd())){
			result.rejectValue("qna_passwd", "invalidPassword");
		
		
		return "qnaDelete";
		}
		
		//글삭제	
		qnaService.delete(qnaCommand.getQna_num());
		status.setComplete();		
	
		
		

	return "redirect:/board/qnaList.do";
	}
}
	
	
	
	
	
	
		