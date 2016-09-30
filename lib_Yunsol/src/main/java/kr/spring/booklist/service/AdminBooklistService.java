package kr.spring.booklist.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.booklist.domain.AdminBooklistCommand;

@Transactional
public interface AdminBooklistService {
	@Transactional(readOnly=true)
	public List<AdminBooklistCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	public void insert(AdminBooklistCommand booklist);
	@Transactional(readOnly=true)
	public AdminBooklistCommand selectBooklist(Integer list_num);
	public void update(AdminBooklistCommand booklist);
	public void updateStatusChange(AdminBooklistCommand booklist);
}