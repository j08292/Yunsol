package kr.spring.book.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.book.domain.BookRentCommand;

@Transactional
public interface BookRentService {
	@Transactional(readOnly = true)
	public List<BookRentCommand> list2(Map<String, Object> map);
	
	@Transactional(readOnly = true)
	public int getRowCount2(Map<String, Object> map);

	@Transactional(readOnly = true)
	public List<BookRentCommand> list(String mem_id);

	@Transactional(readOnly = true)
	public int getRowCount(String mem_id);

	@Transactional(readOnly = true)
	public BookRentCommand selectRent(int rent_num);

	@Transactional(readOnly = true)
	public List<BookRentCommand> select_book_rent(String mem_id);

	@Transactional(readOnly = true)
	public List<BookRentCommand> selectReserveId(String reserveId);

	@Transactional(readOnly = true)
	public BookRentCommand select(int list_num);
	
	public void insertReserve(BookRentCommand bookRentCommand);

	public void insert(BookRentCommand bookRentCommand);

	public void updateStatus(BookRentCommand bookRentCommand);

	public void updateReserveDate(int list_num);

	@Transactional(readOnly = true)
	public List<BookRentCommand> selectList(int list_num);
	@Transactional(readOnly = true)
	public List<BookRentCommand> selectNum(int list_num);
	@Transactional(readOnly = true)
	public Integer recentStatus(int list_num);
	public void updateunmanned(BookRentCommand bookRentCommand);

}
