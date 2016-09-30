package kr.spring.review.controller;

import java.io.File;

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

import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.FileUtil;


@SessionAttributes("command")
@Controller
public class ReviewWriteController {	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ReviewService reviewService;
	
	
	
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model){		
		String mem_id =(String)session.getAttribute("userId");
		
		ReviewCommand command = new ReviewCommand();
		command.setMem_id(mem_id);
		
		model.addAttribute("command", command);
		
		
		return "reviewWrite";
	}
	
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String submit (@ModelAttribute("command")
						 @Valid ReviewCommand reviewCommand,
						 BindingResult result,
						 SessionStatus status)throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("reviewCommand : " + reviewCommand);
		}		
		if(result.hasErrors()){
			return "reviewWrite";
		}
		
		String newName = "";
		if(!reviewCommand.getUpload().isEmpty()){
			newName = FileUtil.rename(reviewCommand.getUpload().getOriginalFilename());
			reviewCommand.setReview_file(newName);
		}
		
		
		
		
		//±Ûµî·Ï
		reviewService.insert(reviewCommand);
		status.setComplete();
		
		  
		if(!reviewCommand.getUpload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH + "/" + newName);
			reviewCommand.getUpload().transferTo(file);
		}
		
		
		
		return "redirect:/board/list.do";
	}
	
	
	
}
