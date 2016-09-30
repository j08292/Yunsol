package kr.admin.booklist.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.booklist.domain.AdminBooklistCommand;
import kr.spring.booklist.service.AdminBooklistService;

@Controller
@SessionAttributes("command")
public class BooklistUpdateStatusController {
	private Logger log= Logger.getLogger(this.getClass());

	@Resource
	private AdminBooklistService booklistService;

	@RequestMapping("/admin/booklist/updateStatus.do")
	public ModelAndView process(@RequestParam("list_num") int list_num,
								@RequestParam("list_status") int list_status){

		if(log.isDebugEnabled()){
			log.debug("list_num : " +list_num);
			log.debug("list_status : " +list_status);
		}

		AdminBooklistCommand booklist = new AdminBooklistCommand();
		booklist.setList_num(list_num);
		booklist.setList_status(list_status);
		booklistService.updateStatusChange(booklist);

		return new ModelAndView("redirect:/admin/booklist/list.do");
	}
}