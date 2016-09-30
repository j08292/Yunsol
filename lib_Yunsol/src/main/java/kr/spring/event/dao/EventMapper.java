package kr.spring.event.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.domain.EventReplyCommand;

@Repository
public interface EventMapper {
	public List<EventCommand> list(Map<String, Object>map);
	public int getRowCount(Map<String, Object> map);
	@Insert("INSERT INTO event(event_num,event_title,event_content,event_filename,event_startdate,event_enddate,event_regdate,mem_id)"
			+ "	VALUES (event_seq.nextval,#{event_title},#{event_content},#{event_filename,jdbcType=VARCHAR},#{event_startdate},#{event_enddate},sysdate,#{mem_id})")
	public void insert(EventCommand event);
	@Select("SELECT * FROM event WHERE event_num = #{event_num}")
	public EventCommand selectEvent(Integer event_num);
	@Update("UPDATE event SET event_hit = event_hit+1 WHERE event_num=#{event_num}")
	public void updateHit(Integer event_num);
	@Update("UPDATE event SET event_title=#{event_title},event_content=#{event_content},event_filename=#{event_filename,jdbcType=VARCHAR},event_startdate=#{event_startdate},event_enddate=#{event_enddate} WHERE event_num=#{event_num}")
	public void update(EventCommand event);
	@Delete("DELETE FROM event WHERE event_num=#{event_num}")
	public void delete(Integer event_num);
	
	//event 댓글
	public List<EventReplyCommand> listReply(Map<String, Object> map);
	@Select("SELECT count(*) FROM event_reply WHERE event_num = #{event_num}")
	public int getRowCountReply(Map<String, Object> map);
	@Insert("INSERT INTO event_reply (event_re_num,event_re_content,event_re_date,event_num,mem_id) VALUES (event_re_seq.nextval,#{event_re_content},sysdate,#{event_num},#{mem_id})")
	public void insertReply(EventReplyCommand eventReply);
	@Update("UPDATE event_reply SET event_re_content=#{event_re_content} WHERE event_re_num=#{event_re_num}")
	public void updateReply(EventReplyCommand eventReply);
	@Delete("DELETE FROM event_reply WHERE event_re_num=#{event_re_num}")
	public void deleteReply(Integer event_re_num);
	
	//관리자 - 이벤트 관리
	//지난 이벤트
	public List<EventCommand> adminPrevEventList(Map<String, Object>map);
	public int getAdminPrevEventCount(Map<String, Object> map);
	//예정 이벤트
	public List<EventCommand> adminNextEventList(Map<String, Object>map);
	public int getAdminNextEventCount(Map<String, Object> map);
}