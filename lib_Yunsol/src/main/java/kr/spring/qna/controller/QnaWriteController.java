package kr.spring.qna.controller;



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

import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.service.QnaService;

@SessionAttributes("qnaCommand")
@Controller
public class QnaWriteController {

	private Logger log= Logger.getLogger(this.getClass());
	
	
	@Resource
	private QnaService qnaService;
	
	
	@RequestMapping(value="/board/qnaWrite.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model){
		String mem_id=(String)session.getAttribute("userId");
		
		QnaCommand qnaCommand = new QnaCommand();
		qnaCommand.setMem_id(mem_id);
		
		model.addAttribute("qnaCommand" ,qnaCommand);
		
		return "qnaWrite";
	}
	@RequestMapping(value="/board/qnaWrite.do", method=RequestMethod.POST)
	public String submit (@ModelAttribute("qnaCommand")
						@Valid QnaCommand qnaCommand,
						BindingResult result,
						SessionStatus status)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("qnaCommand : " +qnaCommand);
		}
		if(result.hasErrors()){
			return "qnaWrite";
		}
		
		//±Ûµî·Ï
		qnaService.insert(qnaCommand);
		status.setComplete();
	
		return "redirect:/board/qnaList.do";
		
	}

}
