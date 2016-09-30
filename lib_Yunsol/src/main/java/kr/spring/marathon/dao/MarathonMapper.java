package kr.spring.marathon.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.marathon.domain.MarathonCommand;
  
@Repository
public interface MarathonMapper {
	//특정 회원이 대출했던 목록
	public List<MarathonCommand> rentedList(Map<String, Object> map);
	public int getRowCount(Map<String , Object> map);
	//특정 회원 마라톤 누적시킬 목록
	public List<MarathonCommand> pageList(String mem_id);
	
	//marathon테이블에 삽입(완주혜택 신청시 추가)
	@Insert("INSERT INTO marathon(marathon_num,mem_id,marathon_page,marathon_regdate,marathon_status) VALUES (marathon_seq.nextval, #{mem_id},#{marathon_page},sysdate,0)")
	public void insert(MarathonCommand marathon);
	
	//member테이블의 mrt_status 변경
	@Update("UPDATE member SET mrt_status = 1 WHERE mem_id=#{mem_id}")
	public void applyMrtStatus(String mem_id);
	@Update("UPDATE member SET mrt_status = 2 WHERE mem_id=#{mem_id}")
	public void finishMrtStatus(String mem_id);
	
	//관리자쪽에서 보는 완주자 리스트
	public List<MarathonCommand> finishList(Map<String, Object> map);
	public int getFinishRowCount(Map<String , Object> map);
	@Update("UPDATE marathon SET marathon_status = #{marathon_status} WHERE marathon_num=#{marathon_num}")
	public void updateStatus(MarathonCommand marathon);
}
