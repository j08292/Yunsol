package kr.spring.book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.book.domain.BookListCommand;

@Repository
public interface BookListMapper {
	public List<BookListCommand> list(Map<String, Object> map);

	public int getRowCount(Map<String, Object> map);

	@Select ("SELECT * FROM booklist WHERE list_num = #{list_num}")
	public BookListCommand select_num(int list_num);
	
	@Select("SELECT * FROM booklist b1, bookrent b2 WHERE b1.list_num = b2.list_num and b1.list_num = #{list_num}")
	public BookListCommand select_book_rent(int list_num);

	@Select("SELECT * FROM booklist WHERE mem_id = #{mem_id} ORDER BY list_num DESC")
	public List<BookListCommand> selectId(String mem_id);

	
	
	
	@Update("UPDATE booklist SET list_rentdate=#{list_rentDate}, list_returndate=#{list_returnDate}, list_rent=#{list_rent},mem_id=#{mem_id} WHERE list_num=#{list_num}")
	public void update(BookListCommand bookListCommand);

	@Update("UPDATE booklist SET list_order=#{list_order},list_reserveid=#{list_reserveId} WHERE list_title=#{list_title}")
	public void updateOrder(BookListCommand bookListCommand);
}
