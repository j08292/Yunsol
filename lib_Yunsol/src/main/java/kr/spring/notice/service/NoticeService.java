package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.notice.domain.NoticeCommand;

@Transactional
public interface NoticeService {
	@Transactional(readOnly=true)
	public List<NoticeCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);	
	public void insert(NoticeCommand notice);
	@Transactional(readOnly=true)
	public NoticeCommand selectNotice(Integer notice_num);
	public void updateHit(Integer notice_num);	
	public void update(NoticeCommand notice);	
	public void delete(Integer notice_num);
}