package kr.spring.bookrent.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.bookrent.domain.AdminBookrentCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Transactional
public interface AdminBookrentService {
	//관리자 도서 대출
	@Transactional(readOnly=true)
	public List<AdminBookrentCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	public int getReserveCount(Integer list_num);
	public void updateBookRent(AdminBookrentCommand bookrent);//도서 대출처리
	public void updateBookReturn(AdminBookrentCommand bookrent);//도서 반납처리
	public void insertPenalty(PenaltyCommand penalty);//연체일 존재하는 책 반납시 -> 패널티 테이블에 삽입
	public void reserveToWaiting(Integer list_num);//예약도서 -> 대출대기	
	public void updateRentCancel(AdminBookrentCommand bookrent);//입금 지연등의 이유로 대여 취소
}