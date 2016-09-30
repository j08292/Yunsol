package kr.spring.adminMember.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.adminMember.dao.AdminMemberMapper;
import kr.spring.adminMember.domain.AdminMemberCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{

	@Resource
	private AdminMemberMapper adminMemberMapper;
	
	@Override
	public List<AdminMemberCommand> list(Map<String, Object> map) {
		return adminMemberMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return adminMemberMapper.getRowCount(map);
	}

	
}