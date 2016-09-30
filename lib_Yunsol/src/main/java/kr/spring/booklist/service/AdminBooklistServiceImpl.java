package kr.spring.booklist.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.booklist.dao.AdminBooklistMapper;
import kr.spring.booklist.domain.AdminBooklistCommand;

@Service("booklistService")
public class AdminBooklistServiceImpl implements AdminBooklistService{
	
	@Resource
	private AdminBooklistMapper booklistMapper;
	
	@Override
	public List<AdminBooklistCommand> list(Map<String, Object> map) {
		return booklistMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return booklistMapper.getRowCount(map);
	}

	@Override
	public void insert(AdminBooklistCommand booklist) {
		booklistMapper.insert(booklist);
	}

	@Override
	public AdminBooklistCommand selectBooklist(Integer list_num) {
		return booklistMapper.selectBooklist(list_num);
	}

	@Override
	public void update(AdminBooklistCommand booklist) {
		booklistMapper.update(booklist);
	}

	@Override
	public void updateStatusChange(AdminBooklistCommand booklist) {
		booklistMapper.updateStatusChange(booklist);
	}
}