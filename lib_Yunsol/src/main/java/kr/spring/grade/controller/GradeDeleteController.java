package kr.spring.grade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.grade.service.GradeService;

@Controller
public class GradeDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private GradeService gradeService;
	
	@RequestMapping("book/deleteGradeAjax.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam("grade_num") int grade_num,
									   @RequestParam("mem_id") String mem_id,
									   HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("grade_num : " + grade_num);
			log.debug("mem_id : " + mem_id);
		}
		Map<String, String> map = new HashMap<String, String>();
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId == null){
				map.put("result", "logout");
			}else if(userId!=null && userId.equals(mem_id)){
				//ªË¡¶
				gradeService.deleteGrade(grade_num);
				map.put("result", "success");
			}else{
				map.put("result", "wrongAccess");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
}
