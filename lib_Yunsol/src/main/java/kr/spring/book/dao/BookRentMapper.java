package kr.spring.book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.book.domain.BookRentCommand;

@Repository
public interface BookRentMapper {
	public List<BookRentCommand> list2(Map<String, Object> map);

	public int getRowCount2(Map<String, Object> map);
	
	@Insert("INSERT INTO bookrent(rent_num,list_num,mem_id,rent_regdate) "
			+ "VALUES(bookrent_seq.nextval,#{list_num},#{mem_id},sysdate)")
	public void insert(BookRentCommand bookRentCommand);

	@Insert("INSERT INTO bookrent(rent_num,list_num,mem_id,rent_regdate,rent_status) "
			+ "VALUES(bookrent_seq.nextval,#{list_num},#{mem_id},sysdate,#{rent_status})")
	public void insertReserve(BookRentCommand bookRentCommand);
	
	@Select("SELECT * FROM bookrent WHERE mem_id = #{mem_id} ORDER BY rent_num DESC")
	public List<BookRentCommand> list(String mem_id);
	
	@Select("SELECT * FROM bookrent WHERE rent_num = #{rent_num}")
	public BookRentCommand selectRent(int rent_num);
	
	@Select("SELECT * FROM booklist b1, bookrent b2 WHERE b1.list_num = b2.list_num and b2.mem_id = #{mem_id}")
	public List<BookRentCommand> select_book_rent(String mem_id);
	
	@Select("SELECT * FROM booklist b1, bookrent b2 WHERE b1.list_num = b2.list_num and b1.list_num = #{list_num}")
	public BookRentCommand select(int list_num);
	
	@Select("SELECT * FROM bookrent WHERE list_num = #{list_num}")
	public List<BookRentCommand> selectNum(int list_num);
	
	@Select("SELECT * FROM booklist b1, bookrent b2 WHERE b1.list_num = b2.list_num and b1.list_num = #{list_num}")
	public List<BookRentCommand> selectList(int list_num);
	
	@Select("SELECT * FROM bookrent WHERE list_reserveid = #{list_reserveId} ORDER BY rent_num DESC")
	public List<BookRentCommand> selectReserveId(String reserveId);
	
	@Select("SELECT count(*) FROM bookrent WHERE mem_id = #{mem_id}")
	public int getRowCount(String mem_id);
	
	@Update("UPDATE bookrent SET rent_status=#{rent_status}, rent_returndate=sysdate WHERE rent_num=#{rent_num}")
	public void updateStatus(BookRentCommand bookRentCommand);
	
	@Update("UPDATE bookrent SET rent_reservedate=sysdate WHERE list_num=#{list_num}")
	public void updateReserveDate(int list_num);
	
	@Select("SELECT rent_status FROM (SELECT a.*, rownum rnum FROM(SELECT max(rent_returndate)returndate,list_num,rent_status "
			+ "FROM bookrent GROUP BY list_num,rent_status HAVING list_num=#{list_num} ORDER BY returndate DESC)a) WHERE rnum=1")
	public Integer recentStatus(int list_num);
	
	@Update("UPDATE bookrent SET rent_status=#{rent_status} WHERE rent_num=#{rent_num}")
	public void updateunmanned(BookRentCommand bookRentCommand);
	
}
