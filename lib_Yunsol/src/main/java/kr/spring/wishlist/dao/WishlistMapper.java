package kr.spring.wishlist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.wishlist.domain.WishlistCommand;

@Repository
public interface WishlistMapper {
	public List<WishlistCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	@Insert("INSERT INTO wishlist(wish_num,wish_title,wish_writer,wish_publish,wish_regdate,wish_status,mem_id) VALUES (wishlist_seq.nextval,#{wish_title},#{wish_writer},#{wish_publish},sysdate,#{wish_status},#{mem_id})")
	public void insert(WishlistCommand wishlist);
	@Select("SELECT * FROM wishlist WHERE wish_num= #{wish_num}")
	public WishlistCommand selectWishlist(Integer wish_num);	
	@Update("UPDATE wishlist SET wish_status=#{wish_status} WHERE wish_num=#{wish_num}")
	public void updateStatusChange(WishlistCommand wishlist);	
}