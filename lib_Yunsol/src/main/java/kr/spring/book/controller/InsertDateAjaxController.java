package kr.spring.book.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.book.domain.BasketCommand;
import kr.spring.book.service.BasketService;

@Controller
public class InsertDateAjaxController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private BasketService basketService;
	
	@RequestMapping("/book/insertDate.do")
	@ResponseBody
	public void process(HttpSession session, 
			@RequestParam("rentDate") String rentDate,
			@RequestParam("returnDate") String returnDate){
		
		String userId = (String) session.getAttribute("userId");
		
		BasketCommand basket = new BasketCommand();
		basket.setMem_id(userId);
		basket.setBasket_rentDate(rentDate);
		basket.setBasket_returnDate(returnDate);
		
		
		List<BasketCommand> list = null;
		list = basketService.list(userId);
	
		
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
			log.debug("rentDate : " + rentDate);
			log.debug("returnDate : " + returnDate);
			log.debug("basket : " + basket);
			log.debug("list : " + list);
		}

		try{
			basketService.updateDate(basket);
			
		}catch(Exception e){
			log.error(e);
		}
		
	}
}
