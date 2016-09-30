package kr.spring.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.admin.dao.AdminMapper;
import kr.spring.booklist.domain.AdminBooklistCommand;
import kr.spring.penalty.domain.PenaltyCommand;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminMapper adminMapper;
	
	//메인 -  관리자 체크 사항 ====================================
	@Override
	public int getRentWaitingCount() {
		return adminMapper.getRentWaitingCount();
	}

	@Override
	public int getWishlistCount() {
		return adminMapper.getWishlistCount();
	}

	@Override
	public int getSpeechReserveCount() {
		return adminMapper.getSpeechReserveCount();
	}

	@Override
	public int getSpeechCancelCount() {
		return adminMapper.getSpeechCancelCount();
	}

	@Override
	public int getBookReserveCount() {
		return adminMapper.getBookReserveCount();
	}

	@Override
	public int getMarathonCount() {
		return adminMapper.getMarathonCount();
	}

	@Override
	public int getQnaWaitingCount() {
		return adminMapper.getQnaWaitingCount();
	}
	
	@Override
	public int getPrevEventCount() {
		return adminMapper.getPrevEventCount();
	}
	
	//메인 - 관리자 차단회원 관리 ==================================
	@Override
	public List<PenaltyCommand> penaltyList() {
		return adminMapper.penaltyList();
	}

	@Override
	public int getRowPenaltyCount() {
		return adminMapper.getRowPenaltyCount();
	}
	
	//메인 - 인기도서 관리 ======================================
	@Override
	public List<AdminBooklistCommand> rentRankList() {
		return adminMapper.rentRankList();
	}
	
	//메인 - 최근 3개월 도서현황 ==================================
	@Override
	public int getBookRentCount_2() {		
		return adminMapper.getBookRentCount_2();
	}

	@Override
	public int getBookRentCount_1() {
		return adminMapper.getBookRentCount_1();
	}

	@Override
	public int getBookRentCount_0() {
		return adminMapper.getBookRentCount_0();
	}

	@Override
	public int getWishlistCount_2() {
		return adminMapper.getWishlistCount_2();
	}

	@Override
	public int getBooklistCount_2() {
		return adminMapper.getBooklistCount_2();
	}

	@Override
	public int getWishlistCount_1() {
		return adminMapper.getWishlistCount_1();
	}

	@Override
	public int getBooklistCount_1() {
		return adminMapper.getBooklistCount_1();
	}

	@Override
	public int getWishlistCount_0() {
		return adminMapper.getWishlistCount_0();
	}

	@Override
	public int getBooklistCount_0() {
		return adminMapper.getBooklistCount_0();
	}	
}