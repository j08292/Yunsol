package kr.spring.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CheckBasketAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private BasketService basketService;

	@RequestMapping("/book/checkBasket.do")
	@ResponseBody
	public Map<String, String> process(HttpSession session, @RequestParam("list_num") Integer list_num) {

		String userId = (String) session.getAttribute("userId");

		if (log.isDebugEnabled()) {
			log.debug("list_num : " + list_num);
		}
		Map<String, String> map = new HashMap<String, String>();
		List<BasketCommand> list = null;
		list = basketService.list(userId);

		try {
			if (userId != null) {
				int i = 0;
				
				if (list.size() != 0) {
					for (i = 0; i < list.size(); i++) {

						if (log.isDebugEnabled()) {
							log.debug("list.size() : " + list.size());
							log.debug("list : " + list);
						}
						
						if (list.get(i).getList_num() == list_num) {
								map.put("result", "duplicated");
								break;
						} else{
								map.put("result", "notFound");
								break;
						}
					}
				} else if (list.size() == 0) {
					if (log.isDebugEnabled()) {
						log.debug("list : " + list);
					}
					map.put("result", "notFound");
				}

			} else {
				map.put("result", "noUserId");
			}
		} catch (Exception e) {
			log.error(e);
			map.put("result", "failure");
		}

		return map;
	}

}
