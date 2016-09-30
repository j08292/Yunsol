package kr.spring.book.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.book.service.BasketService;
import kr.spring.book.domain.BasketCommand;
import kr.spring.book.domain.BookListCommand;
import kr.spring.book.service.BookListService;

@Controller
public class BookBasketController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private BookListService bookListService;

	@Resource
	private BasketService basketService;

	@RequestMapping(value = "/book/basket.do", method = RequestMethod.GET)
	public ModelAndView form(HttpSession session) {

		String userId = (String) session.getAttribute("userId");
		String list_title = (String) session.getAttribute("list_title");
//		Integer list_num = (Integer) session.getAttribute("list_num");
		
		List<BasketCommand> list = null;
		list = basketService.select_book_basket(userId);
		
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
			log.debug("list_title : " + list_title);
//			log.debug("list_num : " + list_num);
			log.debug("list : " + list);
		}

		return new ModelAndView("bookBasket", "list", list);

	}

	@RequestMapping(value = "/book/basket.do", method = RequestMethod.POST)
	public ModelAndView submit(HttpSession session) {

		String userId = (String) session.getAttribute("userId");

		String list_title = (String) session.getAttribute("list_title");
		String list_filename = (String) session.getAttribute("list_filename");
		int list_num = (Integer) session.getAttribute("list_num");
		
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
			log.debug("list_title : " + list_title);
			log.debug("list_filename : " + list_filename);
			log.debug("list_num : " + list_num);
		}

		BookListCommand book = bookListService.select_num(list_num);
		BasketCommand basket = new BasketCommand();
		basket.setMem_id(userId);
		basket.setList_filename(list_filename);
		basket.setList_title(list_title);
		basket.setList_num(list_num);
		
		List<BasketCommand> list = null;

		list = basketService.list(userId);
		
		if (log.isDebugEnabled()) {
			log.debug("book : " + book);
			log.debug("basket : " + basket);
			log.debug("list : " + list);
		}

		
		if (list.size() == 0) {
			basketService.insert(basket);
		} else if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getList_num() != list_num) {
					basketService.insert(basket);
					break;
				} else if (list.get(i).getList_num() == list_num) {
					break;
				}
			}
		}

		list = basketService.select_book_basket(userId);

		if (log.isDebugEnabled()) {
			log.debug("list : " + list);
		}
		
		session.setAttribute("basket", basket);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bookBasket");
		mav.addObject("book", book);
		mav.addObject("list", list);

		return mav;
	}

}
