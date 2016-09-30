package kr.admin.wishlist.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.wishlist.domain.WishlistCommand;
import kr.spring.wishlist.service.WishlistService;

@Controller
@SessionAttributes("command")
public class WishlistUpdateStatusController {
	private Logger log= Logger.getLogger(this.getClass());

	@Resource
	private WishlistService wishlistService;

	@RequestMapping("/admin/wishlist/updateStatus.do")
	public ModelAndView process(@RequestParam("wish_num") int wish_num,
			@RequestParam("wish_status") int wish_status){
		if(log.isDebugEnabled()){
			log.debug("wish_num : " +wish_num);
			log.debug("wish_status : " +wish_status);
		}

		WishlistCommand wishlist = new WishlistCommand();
		wishlist.setWish_status(wish_status);
		wishlist.setWish_num(wish_num);
		wishlistService.updateStatusChange(wishlist);

		return new ModelAndView("redirect:/admin/wishlist/list.do");
	}
}