package kr.spring.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.spring.booklist.domain.AdminBooklistCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Repository
public interface AdminMapper {
	//메인 - 관리자 체크사항
	@Select("SELECT count(*) FROM bookrent WHERE rent_status = 3")
	public int getRentWaitingCount();
	@Select("SELECT count(*) FROM wishlist WHERE wish_status = 0")
	public int getWishlistCount();
	@Select("SELECT count(*) FROM speech_reservation WHERE speech_reserve_status=0")
	public int getSpeechReserveCount();
	@Select("SELECT count(*) FROM speech_reservation WHERE speech_reserve_status=2")
	public int getSpeechCancelCount();
	@Select("SELECT count(*) FROM bookrent WHERE rent_status = 2")
	public int getBookReserveCount();
	@Select("SELECT count(*) FROM marathon WHERE marathon_status = 0")
	public int getMarathonCount();
	@Select("SELECT count(*) FROM (SELECT q.*, (SELECT count(*) FROM qna_reply qr WHERE qr.qna_num=q.qna_num)qna_replyCount FROM qna q) WHERE qna_replyCount = 0")
	public int getQnaWaitingCount();
	@Select("SELECT count(*) FROM event WHERE sysdate > event_enddate")
	public int getPrevEventCount();
	//메인 - 차단회원 관리
	public List<PenaltyCommand> penaltyList();
	public int getRowPenaltyCount();	
	//메인 - 인기도서 차트
	public List<AdminBooklistCommand> rentRankList();
	//메인 - 3개월 도서현황 비교
	//2개월 전_대여량|2개월 전_희망도서 신청 건수|2개월 전_신규 입고도서 건수
	@Select("SELECT count(*) FROM bookrent WHERE (rent_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,-2)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,-2)+1)-TO_CHAR(SYSDATE,'DD'))) AND (rent_status=0 OR rent_status = 1)")
	public int getBookRentCount_2();
	@Select("SELECT count(*) FROM wishlist WHERE (wish_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,-2)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,-2)+1)-TO_CHAR(SYSDATE,'DD')))")
	public int getWishlistCount_2();
	@Select("SELECT count(*) FROM booklist WHERE (list_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,-2)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,-2)+1)-TO_CHAR(SYSDATE,'DD')))")
	public int getBooklistCount_2();
	//1개월 전_대여량|1개월 전_희망도서 신청 건수|1개월 전_신규 입고도서 건수
	@Select("SELECT count(*) FROM bookrent WHERE (rent_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,-1)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,-1)+1)-TO_CHAR(SYSDATE,'DD'))) AND (rent_status=0 OR rent_status = 1)")
	public int getBookRentCount_1();
	@Select("SELECT count(*) FROM wishlist WHERE (wish_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,-1)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,-1)+1)-TO_CHAR(SYSDATE,'DD')))")
	public int getWishlistCount_1();
	@Select("SELECT count(*) FROM booklist WHERE (list_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,-1)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,-1)+1)-TO_CHAR(SYSDATE,'DD')))")
	public int getBooklistCount_1();
	//현재_대여량|현재_희망도서 신청 건수|현재_신규 입고도서 건수
	@Select("SELECT count(*) FROM bookrent WHERE (rent_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,0)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,0)+1)-TO_CHAR(SYSDATE,'DD'))) AND (rent_status=0 OR rent_status = 1)")
	public int getBookRentCount_0();
	@Select("SELECT count(*) FROM wishlist WHERE (wish_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,0)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,0)+1)-TO_CHAR(SYSDATE,'DD')))")
	public int getWishlistCount_0();
	@Select("SELECT count(*) FROM booklist WHERE (list_regdate BETWEEN TRUNC(ADD_MONTHS(SYSDATE,0)+1)-TO_CHAR(SYSDATE,'DD') AND LAST_DAY(TRUNC(ADD_MONTHS(SYSDATE,0)+1)-TO_CHAR(SYSDATE,'DD')))")
	public int getBooklistCount_0();
}