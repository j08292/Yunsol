package kr.spring.main.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMapper {
	
	@Select("SELECT count(*) FROM MEMBER WHERE mem_level!=2")
	public int getMemberCount();//관리자를 뺀 회원수
	@Select("SELECT count(*) FROM booklist")
	public int getBookCount();//보유 책 권수
	@Select("SELECT count(*) FROM speech WHERE speech_date>sysdate")
	public int getSpeechCount();//현재 진행중인 강연수
}
