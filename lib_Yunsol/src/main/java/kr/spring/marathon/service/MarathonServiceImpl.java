package kr.spring.marathon.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.marathon.dao.MarathonMapper;
import kr.spring.marathon.domain.MarathonCommand;

@Service("marathonService")
public class MarathonServiceImpl implements MarathonService{

	@Resource
	private MarathonMapper marathonMapper;
	
	@Override
	public List<MarathonCommand> rentedList(Map<String, Object> map) {
		return marathonMapper.rentedList(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return marathonMapper.getRowCount(map);
	}

	@Override
	public List<MarathonCommand> pageList(String mem_id) {
		return marathonMapper.pageList(mem_id);
	}

	@Override
	public void applyMrtStatus(String mem_id) {
		marathonMapper.applyMrtStatus(mem_id);
	}

	@Override
	public void finishMrtStatus(String mem_id) {
		marathonMapper.finishMrtStatus(mem_id);
	}

	@Override
	public void insert(MarathonCommand marathon) {
		marathonMapper.insert(marathon);
	}

	@Override
	public List<MarathonCommand> finishList(Map<String, Object> map) {
		return marathonMapper.finishList(map);
	}

	@Override
	public int getFinishRowCount(Map<String, Object> map) {
		return marathonMapper.getFinishRowCount(map);
	}

	@Override
	public void updateStatus(MarathonCommand marathon) {
		marathonMapper.updateStatus(marathon);
	}
	
}
