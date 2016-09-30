package kr.admin.bookrent.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.bookrent.domain.AdminBookrentCommand;
import kr.spring.bookrent.service.AdminBookrentService;

@Controller  
public class BookrentRentController {
	private Logger log= Logger.getLogger(this.getClass());

	@Resource
	private AdminBookrentService bookrentService;
	
	@RequestMapping("/admin/bookrent/updateRent.do")
	public ModelAndView process(@RequestParam("rent_num") int rent_num,
								@RequestParam("rent_status") int rent_status){
		
		if(log.isDebugEnabled()){
			log.debug("rent_num : " +rent_num);
			log.debug("rent_status : " +rent_status);
		}
		
		AdminBookrentCommand bookrent = new AdminBookrentCommand();
		bookrent.setRent_num(rent_num);
		bookrent.setRent_status(rent_status);
		bookrentService.updateBookRent(bookrent);

		return new ModelAndView("redirect:/admin/bookrent/list.do");
	}
}