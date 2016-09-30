package kr.spring.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.book.dao.BasketMapper;
import kr.spring.book.domain.BasketCommand;

@Service("basketService")
public class BasketServiceImpl implements BasketService {

	@Resource
	private BasketMapper basketMapper;

	@Override
	public void insert(BasketCommand basket) {
		basketMapper.insert(basket);
	}

	@Override
	public BasketCommand selectBasket(String mem_id) {
		return basketMapper.selectBasket(mem_id);
	}

	@Override
	public void updateAmount(int basket_amount) {
		basketMapper.updateAmount(basket_amount);
	}

	@Override
	public void delete(Integer basket_num) {
		basketMapper.delete(basket_num);
	}

	@Override
	public List<BasketCommand> list(String mem_id) {
		return basketMapper.list(mem_id);
	}

	@Override
	public int getRowCount(String mem_id) {
		return basketMapper.getRowCount(mem_id);
	}

	@Override
	public void updateDate(BasketCommand basket) {
		basketMapper.updateDate(basket);
	}

	@Override
	public List<BasketCommand> select_book_basket(String mem_id) {
		return basketMapper.select_book_basket(mem_id);
	}


}
