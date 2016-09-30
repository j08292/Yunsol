package kr.spring.grade.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.spring.grade.domain.GradeCommand;

@Repository
public interface GradeMapper {
	public List<GradeCommand> list(Map<String, Object> map);
	public int getRowCountGrade(Map<String,Object> map);
	@Insert("INSERT INTO grade (grade_num,grade_content,grade_regdate,grade_star,list_num,mem_id) VALUES (grade_seq.nextval,#{grade_content},sysdate,#{grade_star},#{list_num},#{mem_id})")
	public void insertGrade(GradeCommand garde);
	@Delete("DELETE FROM grade WHERE grade_num=#{grade_num}")
	public void deleteGrade(Integer grade_num);
	
	//관리자 게시물 관리
	//관리자 글 목록
	public List<GradeCommand> adminGradeList(Map<String, Object> map);
	public int getAdminRowCountGrade(Map<String,Object> map);
	//한줄평 내용 더보기
	@Select("SELECT * FROM grade WHERE grade_num= #{grade_num}")
	public GradeCommand selectAdminGrade(Integer grade_num);
	//해당 글번호의 한줄평 삭제
	public void deleteByGradeNum(List<Integer> list);
}