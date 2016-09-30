package kr.spring.booklist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.booklist.domain.AdminBooklistCommand;

@Repository
public interface AdminBooklistMapper {
	public List<AdminBooklistCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	@Insert("INSERT INTO booklist(list_num,list_title,list_writer,list_publish,list_code,list_page,list_filename,list_regdate,mem_id) VALUES (booklist_seq.nextval,#{list_title},#{list_writer},#{list_publish},#{list_code},#{list_page},#{list_filename,jdbcType=VARCHAR},sysdate,#{mem_id})")
	public void insert(AdminBooklistCommand booklist);
	@Select("SELECT * FROM booklist WHERE list_num= #{list_num}")
	public AdminBooklistCommand selectBooklist(Integer list_num);
	@Update("UPDATE booklist SET list_title=#{list_title},list_writer=#{list_writer},list_publish=#{list_publish},list_code=#{list_code},list_page=#{list_page},list_filename=#{list_filename,jdbcType=VARCHAR} WHERE list_num=#{list_num}")
	public void update(AdminBooklistCommand booklist);
	@Update("UPDATE booklist set list_status=#{list_status} WHERE list_num=#{list_num}")
	public void updateStatusChange(AdminBooklistCommand booklist);
}