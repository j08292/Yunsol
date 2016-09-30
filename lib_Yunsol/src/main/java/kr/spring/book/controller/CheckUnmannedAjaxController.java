package kr.spring.book.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

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
import kr.spring.book.domain.BookRentCommand;
import kr.spring.book.service.BasketService;
import kr.spring.book.service.BookListService;
import kr.spring.book.service.BookRentService;

@Controller
public class CheckUnmannedAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private BookListService bookListService;

	@Resource
	private BookRentService bookRentService;

	@RequestMapping("/book/checkUnmanned.do")
	@ResponseBody
	public Map<String, String> process(HttpSession session, @RequestParam("list_num") Integer list_num) {

		String userId = (String) session.getAttribute("userId");

		Map<String, String> map = new HashMap<String, String>();

		try {
			if (userId != null) {
				map.put("result", "unmanned");
				
			} else {
				map.put("result", "noUserId");
			}
		} catch (

		Exception e) {
			log.error(e);
			map.put("result", "failure");
		}
		return map;
	}

}
