package kr.spring.book.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.book.service.BasketService;

@Controller
public class DeleteBasketController {
	private Logger log = Logger.getLogger(this.getClass());	
	@Resource
	private BasketService basketService;
	
	@RequestMapping("/book/delete.do")
	@ResponseBody
	public Map<String, String> process(HttpSession session,
			@RequestParam("basket_num") Integer basket_num){
		
		String userId = (String) session.getAttribute("userId");
		
		if(log.isDebugEnabled()){
			log.debug("basket_num : " + basket_num);
			log.debug("userId : " + userId);
		}
		Map<String, String> map = new HashMap<String, String>();
		
		try{
			if(userId != null){
				basketService.delete(basket_num);
				map.put("result", "deleteSuccess");
			}else if(userId == null){
				map.put("result", "noUserId");
			}
			
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}
		
			return map;
		
	}
	
}








