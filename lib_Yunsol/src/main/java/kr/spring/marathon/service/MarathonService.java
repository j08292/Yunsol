package kr.spring.marathon.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.marathon.domain.MarathonCommand;

@Transactional
public interface MarathonService {
	//특정 회원이 대출했던 목록
	public List<MarathonCommand> rentedList(Map<String, Object> map);
	public int getRowCount(Map<String , Object> map);
	//특정 회원 마라톤 누적시킬 목록
	public List<MarathonCommand> pageList(String mem_id);
	//marathon테이블에 삽입(완주혜택 신청시 추가)
	public void insert(MarathonCommand marathon);
	//member테이블의 mrt_status 변경
	public void applyMrtStatus(String mem_id);		
	public void finishMrtStatus(String mem_id);
	
	//관리자쪽에서 보는 완주자 리스트
	public List<MarathonCommand> finishList(Map<String, Object> map);
	public int getFinishRowCount(Map<String , Object> map);
	public void updateStatus(MarathonCommand marathon);
}
