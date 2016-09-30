package kr.user.wishlist.controller;


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


import kr.spring.wishlist.domain.WishlistCommand;
import kr.spring.wishlist.service.WishlistService;

@Controller
@SessionAttributes("command")
public class WishlistWriteController {
	private Logger log= Logger.getLogger(this.getClass());

	@Resource
	private WishlistService wishlistService;

	@RequestMapping(value="/wishlist/write.do",method=RequestMethod.GET)
	public String form(HttpSession session, Model model){

		String mem_id= (String)session.getAttribute("userId");

		WishlistCommand command= new WishlistCommand();
		command.setMem_id(mem_id);

		model.addAttribute("command", command);

		return "wishlistWrite";
	}

	@RequestMapping(value="/wishlist/write.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command")@Valid WishlistCommand wishlistCommand,
			BindingResult result, SessionStatus status) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("wishlistCommand : "+wishlistCommand);
		}

		if(result.hasErrors()){
			return "wishlistWrite";
		}

		//±Û µî·Ï
		wishlistService.insert(wishlistCommand);
		status.setComplete();

		return "redirect:/main/main.do";
	}
}