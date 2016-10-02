package kr.spring.grade.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.grade.dao.GradeMapper;
import kr.spring.grade.domain.GradeCommand;

@Service("gradeService")
public class GradeServiceImpl implements GradeService{

	@Resource
	private GradeMapper gradeMapper;
	
	@Override
	public List<GradeCommand> list(Map<String, Object> map) {		
		return gradeMapper.list(map);
	}

	@Override
	public int getRowCountGrade(Map<String, Object> map) {		
		return gradeMapper.getRowCountGrade(map);
	}

	@Override
	public void insertGrade(GradeCommand garde) {
		gradeMapper.insertGrade(garde);		
	}

	@Override
	public void deleteGrade(Integer grade_num) {
		gradeMapper.deleteGrade(grade_num);		
	}
	
	@Override
	public List<GradeCommand> adminGradeList(Map<String, Object> map) {
		return gradeMapper.adminGradeList(map);
	}

	@Override
	public int getAdminRowCountGrade(Map<String, Object> map) {
		return gradeMapper.getAdminRowCountGrade(map);
	}

	@Override
	public void deleteByGradeNum(List<Integer> list) {
		gradeMapper.deleteByGradeNum(list);
	}

	@Override
	public GradeCommand selectAdminGrade(Integer grade_num) {
		return gradeMapper.selectAdminGrade(grade_num);
	}
 
	@Override
	public int checkGrade(GradeCommand grade) {
		return gradeMapper.checkGrade(grade);
	}
}