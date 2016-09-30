package kr.spring.speech.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.domain.SpeechReservationCommand;

@Repository
public interface SpeechMapper {
	public List<SpeechCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String , Object> map);
	@Insert("INSERT INTO speech(speech_num,speech_title,speech_content,speech_regdate,speech_people,speech_date,speech_location,speech_location2,speech_price,mem_id) VALUES (speech_num.nextval, #{speech_title},#{speech_content},sysdate,#{speech_people},#{speech_date},#{speech_location},#{speech_location2,jdbcType=VARCHAR},#{speech_price},#{mem_id})")
	public void insert(SpeechCommand speech);
	@Select("SELECT * FROM speech WHERE speech_num = #{speech_num}")
	public SpeechCommand selectSpeech(Integer speech_num);
	@Update("UPDATE speech SET speech_hit = speech_hit+1 WHERE speech_num = #{speech_num}")
	public void updateHit(Integer speech_num);
	@Update("UPDATE speech SET speech_title=#{speech_title},speech_content=#{speech_content},speech_people=#{speech_people},speech_date=#{speech_date},speech_location=#{speech_location},speech_location2=#{speech_location2,jdbcType=VARCHAR},speech_price=#{speech_price} WHERE speech_num=#{speech_num}")
	public void update(SpeechCommand speech);
	@Update("UPDATE speech SET speech_status=1 WHERE speech_num=#{speech_num}")
	public void cancel(Integer speech);
	@Delete("DELETE FROM speech WHERE speech_num=#{speech_num}")
	public void delete(Integer speech_num);
	//해당 강연 글에 신청중,신청확정이 몇명인지
	@Select("SELECT count(sr.speech_num) FROM speech s, speech_reservation sr WHERE s.speech_num = sr.speech_num AND (sr.speech_reserve_status=0 or sr.speech_reserve_status=1) AND s.speech_num=#{speech_num}")
	public int countRes(Integer speech_num);
	//해당 강연 글에 예약한 사람이 있는지 체크
	@Select("SELECT count(sr.speech_num) FROM speech s, speech_reservation sr WHERE s.speech_num = sr.speech_num AND s.speech_num=#{speech_num}")
	public Integer checkRes(Integer speech_num);
	
	//예약자(신청자)
	public List<SpeechReservationCommand> reserveList(Map<String, Object> map);
	@Select("SELECT count(*) FROM speech_reservation WHERE speech_num=#{speech_num}")
	public int getRowCountReservation(Map<String, Object> map);
	@Insert("INSERT INTO speech_reservation (speech_reserve_num,speech_num,mem_id,speech_reserve_date,speech_reserve_status) VALUES (speech_reservation_seq.nextval,#{speech_num},#{mem_id},sysdate,#{speech_reserve_status})")
	public void insertReservation(SpeechReservationCommand speechReservation);
	@Update("UPDATE speech_reservation SET speech_reserve_status=#{speech_reserve_status} WHERE speech_num=#{speech_num} AND mem_id=#{mem_id}")
	public void updateReservation(SpeechReservationCommand speechReserveCommand);
	@Update("UPDATE speech_reservation SET speech_reserve_status=#{speech_reserve_status} WHERE speech_reserve_num=#{speech_reserve_num}")
	public void adminUpdateReservation(SpeechReservationCommand speechReserveCommand);
	//선택한 강연글에 아이디 정보
	@Select("SELECT * FROM speech_reservation WHERE speech_num=#{speech_num} AND mem_id=#{mem_id}")
	public Integer checkSpeechReservation(SpeechReservationCommand speechReserveCommand);
	@Delete("DELETE FROM speech_reservation WHERE speech_reserve_num = #{speech_reserve_num}")
	public void deleteReservation(Integer speech_reserve_num);
	@Select("SELECT * FROM speech_reservation WHERE speech_num=#{speech_num} AND mem_id=#{mem_id}")
	public SpeechReservationCommand selectReservation(SpeechReservationCommand speechReserveCommand);
	
	//미승인 예약자(신청자)
	public List<SpeechReservationCommand> noCheckReserveList(Map<String, Object> map);
	public int getRowCountNoCheck(Map<String, Object> map);
	
	//강연 취소 신청자
	public List<SpeechReservationCommand> speechReserveCancelList(Map<String, Object> map);
	public int getReserveCancelCount(Map<String, Object> map);
}
