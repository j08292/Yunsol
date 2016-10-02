package kr.spring.main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.main.dao.MainMapper;

@Service("mainService")
public class MainServiceImpl implements MainService{

	@Resource
	private MainMapper mainMapper;
	
	@Override
	public int getMemberCount() {
		return mainMapper.getMemberCount();
	}

	@Override
	public int getBookCount() {
		return mainMapper.getBookCount();
	}

	@Override
	public int getSpeechCount() {
		return mainMapper.getSpeechCount();
	}

}
