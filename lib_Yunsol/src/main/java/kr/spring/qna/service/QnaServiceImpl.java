package kr.spring.qna.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.qna.dao.QnaMapper;
import kr.spring.qna.domain.QnaCommand;
import kr.spring.qna.domain.QnaReplyCommand;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{

	@Resource
	private QnaMapper QnaMapper;
	
	@Override
	public List<QnaCommand> list(Map<String, Object> map) {
		return QnaMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return QnaMapper.getRowCount(map);
	}

	@Override
	public void insert(QnaCommand Qnacommand) {
		QnaMapper.insert(Qnacommand);
		
	}

	@Override
	public QnaCommand selectQna(Integer qna_num) {
		return QnaMapper.selectQna(qna_num);
	}

	@Override
	public void updateHit(Integer qna_num) {
		QnaMapper.updateHit(qna_num);
		
	}

	@Override
	public void update(QnaCommand qnaCommand) {
		QnaMapper.update(qnaCommand);
		
	}

	@Override
	public void delete(Integer qna_num) {
		QnaMapper.delete(qna_num);
		
	}

	
	
	//댓글
	
	
	@Override
	public List<QnaReplyCommand> listReply(Map<String, Object> map) {
		return QnaMapper.listReply(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		System.out.println(map);
		return QnaMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(QnaReplyCommand qnaReplyCommand) {
		QnaMapper.insertReply(qnaReplyCommand);
		
	}

	@Override
	public void updateReply(QnaReplyCommand qnaRepluCommand) {
		QnaMapper.updateReply(qnaRepluCommand);
		
	}

	@Override
	public void deleteReply(Integer qna_re_num) {
		QnaMapper.deleteReply(qna_re_num);
		
	}

	@Override
	public List<QnaCommand> adminList(Map<String, Object> map) {
		return QnaMapper.adminList(map);
	}

	@Override
	public void deleteByQnaNum(List<Integer> list) {
		//해당 글번호에 작성된 모든 댓글 삭제
		QnaMapper.deleteReplyByQnaNum(list);
		//해당 글번호의 게시글 삭제
		QnaMapper.deleteByQnaNum(list);
	}
}
