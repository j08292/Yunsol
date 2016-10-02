package kr.spring.main.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MainService {
	@Transactional(readOnly=true)
	public int getMemberCount();//관리자를 뺀 회원수
	@Transactional(readOnly=true)
	public int getBookCount();//보유 책 권수
	@Transactional(readOnly=true)
	public int getSpeechCount();//현재 진행중인 강연수
}
