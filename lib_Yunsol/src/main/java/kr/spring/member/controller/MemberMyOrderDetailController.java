package kr.spring.member.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.book.domain.BookListCommand;
import kr.spring.book.domain.BookRentCommand;
import kr.spring.book.service.BookListService;
import kr.spring.book.service.BookRentService;
import kr.spring.book.service.DeliveryService;
import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberMyOrderDetailController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;

	@Resource
	private BookListService bookListService;

	@Resource
	private BookRentService bookRentService;

	@Resource
	private DeliveryService deliveryService;

	@RequestMapping(value = "/member/myOrderDetail.do", method = RequestMethod.GET)
	public ModelAndView form(HttpSession session,
			@RequestParam(value = "rent_num")Integer rent_num,
			@RequestParam(value = "list_num")Integer list_num,
			@RequestParam(value = "list_title")String list_title) {

		String mem_id = (String) session.getAttribute("userId");
		
		MemberCommand member = new MemberCommand();
		member = memberService.selectMember(mem_id);
		String name = memberService.selectMember(mem_id).getMem_name();
		BookListCommand book = new BookListCommand();
		book = bookListService.select_num(list_num);
		
		BookRentCommand rent = new BookRentCommand();
		rent = bookRentService.selectRent(rent_num);

		if (log.isDebugEnabled()) {
			log.debug("rent : " + rent );
			log.debug("member : " + member);
			log.debug("book : " + book);
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberMyOrderDetail");
		mav.addObject("rent", rent);
		mav.addObject("member", member);
		mav.addObject("name", name);
		mav.addObject("book", book);
		
		return mav;
	}

}
