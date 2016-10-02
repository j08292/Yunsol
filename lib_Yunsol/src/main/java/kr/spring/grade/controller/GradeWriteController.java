package kr.spring.grade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.grade.domain.GradeCommand;
import kr.spring.grade.service.GradeService;

@Controller
public class GradeWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private GradeService gradeService;
	
	@RequestMapping("/book/writeGradeAjax.do")
	@ResponseBody
	public Map<String, String> process(GradeCommand gradeCommand, HttpSession session){
		if(log.isDebugEnabled()){
			log.debug("gradeCommand : " + gradeCommand);
		}
		Map<String, String> map = new HashMap<String, String>();
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId == null){//로그인 안된경우
				map.put("result", "logout");
			}else{//로그인됨
				int checkGrade = gradeService.checkGrade(gradeCommand);
				if(checkGrade==0){//등록안되어있을경우
					//등록
					gradeService.insertGrade(gradeCommand);
					map.put("result", "success");
				}else{//등록되어 있을 경우
					map.put("result", "alreadyWrite");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
	
}
