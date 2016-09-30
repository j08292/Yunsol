package kr.spring.qna.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.domain.QnaReplyCommand;

@Transactional
public interface QnaService {

	
	public List<QnaCommand> list(Map<String,Object>map);
	public int getRowCount(Map<String,Object>map);
	public void insert(QnaCommand qnaCommand);
	public QnaCommand selectQna(Integer qna_num);
	public void updateHit(Integer qna_num);
	public void update(QnaCommand qnaCommand);
	public void delete(Integer qna_num);
	
	
	@Transactional(readOnly=true)
	public List<QnaReplyCommand> listReply(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map <String, Object>map);
	public void insertReply(QnaReplyCommand qnaReplyCommand);
	public void updateReply(QnaReplyCommand qnaRepluCommand);
	public void deleteReply(Integer qna_re_num);
	
	//°ü¸®ÀÚ=========================================================
	public List<QnaCommand> adminList(Map<String, Object> map);
	public void deleteByQnaNum(List<Integer> list);
}
