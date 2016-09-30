package kr.spring.member.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.book.domain.BookRentCommand;
import kr.spring.book.domain.DeliveryCommand;
import kr.spring.book.service.BookListService;
import kr.spring.book.service.BookRentService;
import kr.spring.book.service.DeliveryService;
import kr.spring.member.service.MemberService;
import kr.spring.util.PagingUtil;

@Controller
public class MemberMyOrderController {
	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private MemberService memberService;

	@Resource
	private BookListService bookListService;

	@Resource
	private BookRentService bookRentService;

	@Resource
	private DeliveryService deliveryService;

	@RequestMapping(value = "/member/myOrder.do", method=RequestMethod.GET )
	public ModelAndView form(HttpSession session, HttpServletRequest request,
			@RequestParam(value="pageNum",defaultValue="1") 
				int currentPage){
		
		
//		String keyfield = request.getParameter("keyfield");
//		String keyword = request.getParameter("keyword");
//		
//		if(keyfield == null) keyfield = "";
//		if(keyword == null) keyword = "";

		String mem_id = (String)session.getAttribute("userId");
		String status = request.getParameter("rent_status");
		int rent_status;
		
		if(status == null){
			rent_status = 9;
		}else{
			rent_status = Integer.parseInt(status);
		}
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		int count = bookRentService.getRowCount(mem_id);
		
		int count2 = bookRentService.getRowCount2(map);

		PagingUtil page = new PagingUtil(currentPage,
                count,rowCount,pageCount,"myOrder.do");
		
		map.put("mem_id", mem_id);
		map.put("rent_status", rent_status);
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<DeliveryCommand> list_del = null;
		list_del = deliveryService.list(mem_id);

		List<BookRentCommand> list_rent = null;
		
		if(count2 > 0 ){
			list_rent = bookRentService.list2(map);
		}else{
			list_rent = Collections.emptyList();
		}

		if(log.isDebugEnabled()){
			log.debug("count : " + count);
			log.debug("count2 : " + count2);
			log.debug("currentPage : " + currentPage);
			log.debug("list_del : " + list_del);
			log.debug("list_rent : " + list_rent);
			log.debug("mem_id : " + mem_id);
			log.debug("list_rent.size() : " + list_rent.size());
			log.debug("rent_status : " + rent_status);
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberMyOrder");
		mav.addObject("count", count);
		mav.addObject("list_del", list_del);
		mav.addObject("list_rent", list_rent);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}

}



