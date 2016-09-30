package kr.spring.book.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.book.dao.BookRentMapper;
import kr.spring.book.domain.BookRentCommand;

@Service("bookRentService")
public class BookRentServiceImpl implements BookRentService {

	@Resource
	private BookRentMapper bookRentMapper;
	
	@Override
	public void insert(BookRentCommand bookRentCommand) {
		bookRentMapper.insert(bookRentCommand);
	}

	@Override
	public List<BookRentCommand> list(String mem_id) {
		return bookRentMapper.list(mem_id);
	}

	@Override
	public int getRowCount(String mem_id) {
		return bookRentMapper.getRowCount(mem_id);
	}

	@Override
	public BookRentCommand selectRent(int rent_num) {
		return bookRentMapper.selectRent(rent_num);
	}


	@Override
	public List<BookRentCommand> selectReserveId(String reserveId) {
		return bookRentMapper.selectReserveId(reserveId);
	}

	@Override
	public void updateReserveDate(int list_num) {
		bookRentMapper.updateReserveDate(list_num);
	}

	@Override
	public BookRentCommand select(int list_num) {
		return bookRentMapper.select(list_num);
	}

	@Override
	public void updateStatus(BookRentCommand bookRentCommand) {
		bookRentMapper.updateStatus(bookRentCommand);
	}

	@Override
	public List<BookRentCommand> select_book_rent(String mem_id) {
		return bookRentMapper.select_book_rent(mem_id);
	}

	@Override
	public void insertReserve(BookRentCommand bookRentCommand) {
		bookRentMapper.insertReserve(bookRentCommand);
	}

	@Override
	public List<BookRentCommand> selectList(int list_num) {
		return bookRentMapper.selectList(list_num);
	}

	@Override
	public List<BookRentCommand> selectNum(int list_num) {
		return bookRentMapper.selectNum(list_num);
	}

	@Override
	public Integer recentStatus(int list_num) {
		return bookRentMapper.recentStatus(list_num);
	}

	@Override
	public List<BookRentCommand> list2(Map<String, Object> map) {
		return bookRentMapper.list2(map);
	}

	@Override
	public int getRowCount2(Map<String, Object> map) {
		return bookRentMapper.getRowCount2(map);
	}

	@Override
	public void updateunmanned(BookRentCommand bookRentCommand) {
		bookRentMapper.updateunmanned(bookRentCommand);
	}


}
