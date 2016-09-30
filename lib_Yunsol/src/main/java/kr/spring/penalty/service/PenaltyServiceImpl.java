package kr.spring.penalty.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.penalty.dao.PenaltyMapper;
import kr.spring.penalty.domain.PenaltyCommand;

@Service("penaltyService")
public class PenaltyServiceImpl implements PenaltyService{

	@Resource
	private PenaltyMapper penaltyMapper;
	
	@Override
	public List<PenaltyCommand> list(Map<String, Object> map) {
		return penaltyMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return penaltyMapper.getRowCount(map);
	}

	@Override
	public void insert(PenaltyCommand penalty) {
		penaltyMapper.insert(penalty);
	}
	
	@Override
	public void updateCancelDate(String mem_id) {
		penaltyMapper.updateCancelDate(mem_id);
	}

	@Override
	public List<PenaltyCommand> reasonView(String mem_id) {
		return penaltyMapper.reasonView(mem_id);
	}
	
	@Override
	public int getReasonCount(String mem_id) {
		return penaltyMapper.getReasonCount(mem_id);
	}	
}