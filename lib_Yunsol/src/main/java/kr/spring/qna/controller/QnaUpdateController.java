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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.service.QnaService;

@SessionAttributes("qnaCommand")
@Controller
public class QnaUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private QnaService qnaService;
	
	@RequestMapping(value="/board/qnaUpdate.do" , method=RequestMethod.GET)
	public String form(@RequestParam("qna_num")int qna_num, Model model){
		
		QnaCommand qnaCommand = qnaService.selectQna(qna_num);
		model.addAttribute("qnaCommand",qnaCommand);
		
		return "qnaModify";
		
		
	}
	@RequestMapping(value="/board/qnaUpdate.do" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("qnaCommand")
						@Valid QnaCommand qnaCommand,
						BindingResult result,
						SessionStatus status,
						HttpSession session)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("qnaCommand : " + qnaCommand);
		}
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(qnaCommand.getMem_id())){
			throw new Exception("로그인한 아이디로 작성된 글이 아니기 때문에 수정할수없습니다.");
		}
		if(result.hasErrors()){
			return "qnaModify";
		}
		
		QnaCommand qna = qnaService.selectQna(qnaCommand.getQna_num());
		
		
		
		//비밀번호
		if(!qna.isCheckedPwd(qnaCommand.getQna_passwd())){
			result.rejectValue("qna_passwd", "invalidPassword");
			return "qnaModify";
		}
		
		
		//글수정
		qnaService.update(qnaCommand);
		status.setComplete();
	
		
	
	return "redirect:/board/qnaList.do";
	
	
}
	
	
	
	
}
