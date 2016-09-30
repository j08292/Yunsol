package kr.spring.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.book.domain.BasketCommand;

@Repository
public interface BasketMapper {

	public List<BasketCommand> list(String mem_id);

	public int getRowCount(String mem_id);
	
	@Select("SELECT * FROM booklist b1, basket b2 WHERE b1.list_num = b2.list_num and b2.mem_id = #{mem_id} ORDER BY basket_num DESC")
	public List<BasketCommand> select_book_basket(String mem_id);

	@Insert("INSERT INTO basket(basket_num, mem_id, list_num) VALUES(basket_seq.nextval, #{mem_id}, #{list_num})")
	public void insert(BasketCommand basket);
	
	@Update("UPDATE basket SET basket_rentDate=#{basket_rentDate}, basket_returnDate=#{basket_returnDate} WHERE mem_id = #{mem_id}")
	public void updateDate(BasketCommand basket);
	
	@Select("SELECT * FROM basket WHERE mem_id = #{mem_id}")
	public BasketCommand selectBasket(String mem_id);

	@Update("UPDATE basket SET basket_amount = #{basket_amount}")
	public void updateAmount(int basket_amount);

	@Delete("DELETE FROM basket WHERE basket_num = #{basket_num}")
	public void delete(Integer basket_num);

	@Select("SELECT * FROM basket b1, booklist b2 WHERE b1.list_num = b2.list_num and b1.mem_id = #{mem_id}")
	public BasketCommand selectJoin(String mem_id);
	
	

}
