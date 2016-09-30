package kr.spring.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.notice.domain.NoticeCommand;

@Repository
public interface NoticeMapper {
	public List<NoticeCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	@Insert("INSERT INTO notice(notice_num,notice_title,notice_content,notice_regdate,mem_id) VALUES (notice_seq.nextval,#{notice_title},#{notice_content},sysdate,#{mem_id})")
	public void insert(NoticeCommand notice);
	@Select("SELECT * FROM notice WHERE notice_num= #{notice_num}")
	public NoticeCommand selectNotice(Integer notice_num);
	@Update("UPDATE notice SET notice_hit=notice_hit+1 WHERE notice_num=#{notice_num}")
	public void updateHit(Integer notice_num);
	@Update("UPDATE notice SET notice_title=#{notice_title},notice_content=#{notice_content} WHERE notice_num=#{notice_num}")
	public void update(NoticeCommand notice);
	@Delete("DELETE FROM notice WHERE notice_num=#{notice_num}")
	public void delete(Integer notice_num);
}