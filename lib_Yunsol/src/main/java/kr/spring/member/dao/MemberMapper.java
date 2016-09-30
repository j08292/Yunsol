package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.member.domain.MemberCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Repository
public interface MemberMapper {
	@Insert("INSERT INTO member(mem_id, mem_name, mem_passwd, mem_cell, mem_email, mem_address, sample3_postcode ,mem_regdate) VALUES (#{mem_id}, #{mem_name}, #{mem_passwd}, #{mem_cell}, #{mem_email}, #{mem_address}, #{sample3_postcode} ,sysdate)")
	public void insert(MemberCommand member);
	
	@Select("SELECT * FROM member WHERE mem_id = #{mem_id}")
	public MemberCommand selectMember(String mem_id);
	
	@Update("UPDATE member SET"
			+ " mem_passwd = #{mem_passwd}, mem_name = #{mem_name}, mem_cell=${mem_cell}, mem_email=#{mem_email}, mem_address=#{mem_address} WHERE mem_id = #{mem_id}")
	public void update(MemberCommand member);
	
	@Delete("DELETE FROM member WHERE mem_id = #{mem_id}") 	
	public void delete(String id);
	
	//관리자 회원관리
	@Select("SELECT count(*) FROM penalty WHERE penalty_blockcanceldate > sysdate AND mem_id=#{mem_id}")
	public int checkBlock(String mem_id);//아직 차단회원일경우 1, 아니면 0
	@Select("SELECT mem_id,blockcanceldate,penalty_reason FROM(SELECT a.*,rownum FROM (SELECT mem_id,max(penalty_blockcanceldate)blockcanceldate,penalty_reason FROM penalty GROUP BY mem_id,penalty_reason HAVING mem_id=#{mem_id} ORDER BY max(penalty_blockcanceldate)desc)a) WHERE rownum=1")
	public PenaltyCommand selectBlockMember(String mem_id);//차단사유, 차단해지 예정일
}