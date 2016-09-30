package kr.admin.booklist.controller;

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

import kr.spring.booklist.domain.AdminBooklistCommand;
import kr.spring.booklist.service.AdminBooklistService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class BooklistWriteController {
	private Logger log= Logger.getLogger(this.getClass());

	@Resource
	private AdminBooklistService booklistService;

	@RequestMapping(value="/admin/booklist/write.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){

		String mem_id= (String)session.getAttribute("userId");
		/*String mem_level= (String)session.getAttribute("userLevel");*/

		AdminBooklistCommand command= new AdminBooklistCommand();
		command.setMem_id(mem_id);

		model.addAttribute("command", command);

		return "booklistWrite";
	}

	@RequestMapping(value="/admin/booklist/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid AdminBooklistCommand booklistCommand,
			BindingResult result, SessionStatus status) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("booklistCommand : "+booklistCommand);
		}

		if(result.hasErrors()){
			return "booklistWrite";
		}

		String newName="";
		if(!booklistCommand.getUpload().isEmpty()){
			newName= FileUtil.rename(booklistCommand.getUpload().getOriginalFilename());
			booklistCommand.setList_filename(newName);;
		}

		//±Û µî·Ï
		booklistService.insert(booklistCommand);
		status.setComplete();

		if(!booklistCommand.getUpload().isEmpty()){
			File file= new File(FileUtil.UPLOAD_PATH+"/"+newName);
			booklistCommand.getUpload().transferTo(file);
		}

		return "redirect:/admin/booklist/list.do";
	}
}