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

import kr.spring.book.domain.BookRentCommand;
import kr.spring.book.service.BookListService;
import kr.spring.book.service.BookRentService;

@Controller
public class ReserveCancelAjaxController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private BookListService bookListService;

	@Resource
	private BookRentService bookRentService;

	@RequestMapping("/member/reserveCancel.do")
	@ResponseBody
	public Map<String, String> process(HttpSession session,
			@RequestParam(value = "list_num") Integer list_num,
			@RequestParam(value = "rent_num") Integer rent_num) {

		String userId = (String) session.getAttribute("userId");

		Map<String, String> map = new HashMap<String, String>();

		List<BookRentCommand> rentCommand = bookRentService.select_book_rent(userId);
		int status = bookRentService.recentStatus(list_num);
		BookRentCommand bookRentCommand = new BookRentCommand();
		
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
			log.debug("list_num : " + list_num);
			log.debug("rent_num : " + rent_num);
			log.debug("rentCommand : " + rentCommand);
			log.debug("size : " + rentCommand.size());
			log.debug("status : " + status);
		}
		
		try {
			if (userId != null) {
				if (rentCommand.size() != 0 ) {
					for (int i = 0; i < rentCommand.size(); i++) {
						if(rentCommand.get(i).getRent_num() == rent_num && status == 2){
							
							bookRentCommand.setRent_status(4);
							bookRentCommand.setRent_num(rent_num);
							bookRentService.updateStatus(bookRentCommand);
							map.put("result", "success");
							break;
						}else{
							map.put("result", "fail");
							break;
						}
					}
				}
			} else if (userId == null) {
				map.put("result", "noUserId");
			}

		} catch (Exception e) {
			log.error(e);
			map.put("result", "failure");
		}
		return map;
	}
}