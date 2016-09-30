package kr.spring.bookrent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.bookrent.domain.AdminBookrentCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Repository
public interface AdminBookrentMapper {
	//관리자 도서 대출  
	public List<AdminBookrentCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	@Select("SELECT count(*) FROM bookrent WHERE list_num=#{list_num} AND rent_status=2")
	public int getReserveCount(Integer list_num);
	@Update("UPDATE bookrent SET rent_status=#{rent_status},rent_regdate=sysdate,rent_returndate=to_date(to_char(sysdate+21,'yyyymmdd')) WHERE rent_num=#{rent_num}")
	public void updateBookRent(AdminBookrentCommand bookrent);//도서 대출처리 : 대출대기 -> 대출중
	@Update("UPDATE bookrent SET rent_status=#{rent_status},rent_returndate=sysdate WHERE rent_num=#{rent_num}")
	public void updateBookReturn(AdminBookrentCommand bookrent);//도서 반납처리
	@Insert("INSERT INTO penalty(penalty_num,penalty_regdate,penalty_reason,penalty_blockcanceldate,mem_id) VALUES (penalty_num.nextval,sysdate,#{penalty_reason},to_date(to_char(sysdate+#{penalty_day},'yyyymmdd'),'yyyymmdd'),#{mem_id})")
	public void insertPenalty(PenaltyCommand penalty);//연체일 존재하는 책 반납시 -> 패널티 테이블에 삽입
	@Update("UPDATE bookrent SET rent_status=3 WHERE list_num=#{list_num} AND rent_status=2")
	public void reserveToWaiting(Integer list_num);//예약도서 -> 대출대기
	@Update("UPDATE bookrent SET rent_status=#{rent_status},rent_returndate=sysdate WHERE rent_num=#{rent_num}")
	public void updateRentCancel(AdminBookrentCommand bookrent);//입금 지연등의 이유로 대여 취소
}