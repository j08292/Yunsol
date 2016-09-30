package kr.spring.book.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.book.domain.BasketCommand;

@Transactional
public interface BasketService {
	@Transactional(readOnly=true)
	public List<BasketCommand> list(String mem_id);
	@Transactional(readOnly=true)
	public int getRowCount(String mem_id);
	@Transactional(readOnly=true)
	public BasketCommand selectBasket(String mem_id);
	@Transactional(readOnly=true)
	public List<BasketCommand> select_book_basket(String mem_id);
	
	public void insert(BasketCommand basket);
	public void updateDate(BasketCommand basket);
	public void updateAmount(int basket_amount); 
	public void delete(Integer basket_num);
	

}
