package kr.spring.speech.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.speech.dao.SpeechMapper;
import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.domain.SpeechReservationCommand;

@Service("speechService")
public class SpeechServiceImpl implements SpeechService{

	@Resource
	private SpeechMapper speechMapper;
	
	@Override
	public List<SpeechCommand> list(Map<String, Object> map) {
		return speechMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return speechMapper.getRowCount(map);
	}

	@Override
	public void insert(SpeechCommand speech) {
		speechMapper.insert(speech);
	}

	@Override
	public SpeechCommand selectSpeech(Integer speech_num) {
		return speechMapper.selectSpeech(speech_num);
	}

	@Override
	public void updateHit(Integer speech_num) {
		speechMapper.updateHit(speech_num);
	}

	@Override
	public void update(SpeechCommand speech) {
		speechMapper.update(speech);
	}

	@Override
	public void delete(Integer speech_num) {
		//부모글 삭제
		speechMapper.delete(speech_num);
	}

	@Override
	public int countRes(Integer speech_num) {
		return speechMapper.countRes(speech_num);
	}

	@Override
	public List<SpeechReservationCommand> reserveList(Map<String, Object> map) {
		return speechMapper.reserveList(map);
	}

	@Override
	public int getRowCountReservation(Map<String, Object> map) {
		return speechMapper.getRowCountReservation(map);
	}

	@Override
	public void insertReservation(SpeechReservationCommand speechReservation) {
		speechMapper.insertReservation(speechReservation);
	}
	

	@Override
	public void deleteReservation(Integer speech_reserve_num) {
		speechMapper.deleteReservation(speech_reserve_num);
	}

	@Override
	public void cancel(Integer speech) {
		speechMapper.cancel(speech);
		
	}

	@Override
	public Integer checkSpeechReservation(SpeechReservationCommand speechReserveCommand) {
		return speechMapper.checkSpeechReservation(speechReserveCommand);
	}

	@Override
	public void updateReservation(SpeechReservationCommand speechReserveCommand) {
		speechMapper.updateReservation(speechReserveCommand);
	}

	@Override
	public SpeechReservationCommand selectReservation(SpeechReservationCommand speechReserveCommand) {
		return speechMapper.selectReservation(speechReserveCommand);
	}

	@Override
	public Integer checkRes(Integer speech_num) {
		return speechMapper.checkRes(speech_num);
	}

	@Override
	public void adminUpdateReservation(SpeechReservationCommand speechReserveCommand) {
		speechMapper.adminUpdateReservation(speechReserveCommand);
	}

	@Override
	public List<SpeechReservationCommand> noCheckReserveList(Map<String, Object> map) {
		return speechMapper.noCheckReserveList(map);
	}

	@Override
	public int getRowCountNoCheck(Map<String, Object> map) {
		return speechMapper.getRowCountNoCheck(map);
	}

	@Override
	public List<SpeechReservationCommand> speechReserveCancelList(Map<String, Object> map) {
		return speechMapper.speechReserveCancelList(map);
	}

	@Override
	public int getReserveCancelCount(Map<String, Object> map) {
		return speechMapper.getReserveCancelCount(map);
	}
}