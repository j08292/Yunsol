package kr.admin.grade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.grade.domain.GradeCommand;
import kr.spring.grade.service.GradeService;

@Controller
public class AdminGradeViewAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private GradeService gradeService;
	
	@RequestMapping("/admin/grade/adminGradeViewAjax.do")
	@ResponseBody
	public Map<String, Object> process(@RequestParam("grade_num")int grade_num){
		
		if(log.isDebugEnabled()){
			log.debug("grade_num : " + grade_num);
		}
		
		GradeCommand gradeCommand= new GradeCommand();
			
		gradeCommand = gradeService.selectAdminGrade(grade_num);
		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("content", gradeCommand.getGrade_content());
		
		return map;
	}
}