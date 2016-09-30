package kr.spring.event.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.event.domain.EventCommand;
import kr.spring.event.domain.EventReplyCommand;

@Transactional
public interface EventService {
	@Transactional(readOnly=true)
	public List<EventCommand> list(Map<String, Object>map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	public void insert(EventCommand event);
	@Transactional(readOnly=true)
	public EventCommand selectEvent(Integer event_num);
	public void updateHit(Integer event_num);
	public void update(EventCommand event);
	public void delete(Integer event_num);
	
	//이벤트 댓글
	@Transactional(readOnly=true)
	public List<EventReplyCommand> listReply(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(EventReplyCommand eventReply);
	public void updateReply(EventReplyCommand eventReply);
	public void deleteReply(Integer event_re_num);
	
	//관리자 - 이벤트 관리
	//지난 이벤트
	public List<EventCommand> adminPrevEventList(Map<String, Object>map);
	public int getAdminPrevEventCount(Map<String, Object> map);
	//예정 이벤트
	public List<EventCommand> adminNextEventList(Map<String, Object>map);
	public int getAdminNextEventCount(Map<String, Object> map);
}