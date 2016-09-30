package kr.spring.bookrent.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.bookrent.dao.AdminBookrentMapper;
import kr.spring.bookrent.domain.AdminBookrentCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Service("bookrentService")
public class AdminBookrentServiceImpl implements AdminBookrentService{

	@Resource
	private AdminBookrentMapper bookrentMapper;
	
	@Override
	public List<AdminBookrentCommand> list(Map<String, Object> map) {
		return bookrentMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return bookrentMapper.getRowCount(map);
	}
	
	@Override
	public int getReserveCount(Integer list_num) {		
		return bookrentMapper.getReserveCount(list_num);
	}
	
	@Override
	public void updateBookReturn(AdminBookrentCommand bookrent) {
		bookrentMapper.updateBookReturn(bookrent);
	}
	
	@Override
	public void reserveToWaiting(Integer list_num) {
		bookrentMapper.reserveToWaiting(list_num);
	}
	
	@Override
	public void insertPenalty(PenaltyCommand penalty) {
		bookrentMapper.insertPenalty(penalty);		
	}
	
	@Override
	public void updateBookRent(AdminBookrentCommand bookrent) {
		bookrentMapper.updateBookRent(bookrent);
	}

	@Override
	public void updateRentCancel(AdminBookrentCommand bookrent) {
		bookrentMapper.updateRentCancel(bookrent);
	}	
}