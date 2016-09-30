package kr.spring.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.book.domain.BookListCommand;

@Transactional
public interface BookListService {
	@Transactional(readOnly = true)
	public List<BookListCommand> list(Map<String, Object> map);

	@Transactional(readOnly = true)
	public int getRowCount(Map<String, Object> map);

	@Transactional(readOnly = true)
	public BookListCommand select_num(int list_num);

	@Transactional(readOnly = true)
	public List<BookListCommand> selectId(String mem_id);

	@Transactional(readOnly = true)
	public BookListCommand select_book_rent(int list_num);

	public void update(BookListCommand bookListCommand);

	public void updateOrder(BookListCommand bookListCommand);
	
	
}
