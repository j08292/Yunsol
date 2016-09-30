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
public class ReserveBookAjaxController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private BookListService bookListService;

	@Resource
	private BookRentService bookRentService;

	@RequestMapping("/book/reserveBook.do")
	@ResponseBody
	public Map<String, String> process(HttpSession session, @RequestParam("list_title") String list_title,
			@RequestParam("list_num") Integer list_num) {

		String userId = (String) session.getAttribute("userId");

		Map<String, String> map = new HashMap<String, String>();
		BookRentCommand bookRentCommand = new BookRentCommand();

		List<BookRentCommand> rentCommand = bookRentService.selectNum(list_num);

		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
			log.debug("list_num : " + list_num);
			log.debug("list_title : " + list_title);
			log.debug("rentCommand : " + rentCommand);
			log.debug("size : " + rentCommand.size());
		}

		try {
			if(userId != null){
				if (rentCommand.size() != 0) {
					for (int i = 0; i < rentCommand.size(); i++) {
						if ((rentCommand.get(i).getList_num() == list_num) && (!rentCommand.get(i).getMem_id().equals(userId))) {
							if(rentCommand.get(i).getRent_status() == 2){
								map.put("result", "fail");
								break;
							}else if((rentCommand.get(i).getRent_status() == 3) || (bookRentCommand.getRent_status() == 0)){
								if (log.isDebugEnabled()) {
									log.debug("rentCommand.get(i).getMem_id() : " + rentCommand.get(i).getMem_id());
									log.debug("userId : " + userId);
								}
								map.put("result", "success");
								bookRentCommand.setList_num(list_num);
								bookRentCommand.setMem_id(userId);
								bookRentCommand.setRent_status(2);
								bookRentService.insertReserve(bookRentCommand);
								break;
							}else if((rentCommand.get(i).getList_num() == list_num) && (rentCommand.get(i).getMem_id().equals(userId))){
								if((rentCommand.get(i).getRent_status() == 3) || (bookRentCommand.getRent_status() == 0)){
									map.put("result", "duplicated");
									break;
								}else if((rentCommand.get(i).getRent_status() == 2)){
									map.put("result", "already");
									break;
								}	
							}
							
						}else{
							break;
						}
					}
				}
			}else if (userId == null) {
				map.put("result", "noUserId");
			}
			
		} catch (Exception e) {
			log.error(e);
			map.put("result", "failure");
		}
		return map;
	}
}
