package kr.spring.penalty.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.penalty.domain.PenaltyCommand;

@Transactional
public interface PenaltyService {
	@Transactional(readOnly=true)
	public List<PenaltyCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);	
	public void insert(PenaltyCommand penalty);
	public void updateCancelDate(String mem_id);
	@Transactional(readOnly=true)
	public List<PenaltyCommand> reasonView(String mem_id);
	public int getReasonCount(String mem_id);
}