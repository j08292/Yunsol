package kr.spring.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberMapper memberMapper;
	// @Resource
	// private BoardMapper boardMapper;

	@Override
	public void insert(MemberCommand member) {
		memberMapper.insert(member);
	}

	@Override
	public MemberCommand selectMember(String mem_id) {
		return memberMapper.selectMember(mem_id);
	}

	@Override
	public void update(MemberCommand member) {
		memberMapper.update(member);
	}

	@Override
	public void delete(String id) {
		// 해당id로 작성된 부모글의 글번호 구하기
		//List<Integer> seq = boardMapper.selectSeqById(id);
		// 해당id로 작성된 부모글에 달린 댓글 삭제
		//if (seq != null && !seq.isEmpty()) {
		//	boardMapper.deleteReplyBySeqList(seq);
		//}
		// 해당id로 작성된 댓글 삭제
		//boardMapper.deleteReplyById(id);
		// 해당id로 작성된 부모글 삭제
		//boardMapper.deleteById(id);
		// 해당id 삭제
		memberMapper.delete(id);

	}

	@Override
	public int checkBlock(String mem_id) {
		//차단 회원 관리
		return memberMapper.checkBlock(mem_id);
	}

	@Override
	public PenaltyCommand selectBlockMember(String mem_id) {
		//차단사유, 차단 해지 예정일
		return memberMapper.selectBlockMember(mem_id);
	}
}