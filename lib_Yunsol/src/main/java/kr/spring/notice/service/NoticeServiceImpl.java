package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.notice.dao.NoticeMapper;
import kr.spring.notice.domain.NoticeCommand;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Resource
	private NoticeMapper noticeMapper;

	@Override
	public List<NoticeCommand> list(Map<String, Object> map) {
		return noticeMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return noticeMapper.getRowCount(map);
	}

	@Override
	public void insert(NoticeCommand notice) {
		noticeMapper.insert(notice);
	}

	@Override
	public NoticeCommand selectNotice(Integer notice_num) {
		return noticeMapper.selectNotice(notice_num);
	}

	@Override
	public void updateHit(Integer notice_num) {
		noticeMapper.updateHit(notice_num);
	}

	@Override
	public void update(NoticeCommand notice) {
		noticeMapper.update(notice);
	}

	@Override
	public void delete(Integer notice_num) {
		noticeMapper.delete(notice_num);
	}
}