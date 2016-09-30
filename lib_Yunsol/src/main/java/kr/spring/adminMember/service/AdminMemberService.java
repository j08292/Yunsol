package kr.spring.adminMember.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.adminMember.domain.AdminMemberCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Transactional
public interface AdminMemberService {
	@Transactional(readOnly=true)
	public List<AdminMemberCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
}