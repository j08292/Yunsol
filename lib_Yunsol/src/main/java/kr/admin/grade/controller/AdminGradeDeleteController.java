package kr.admin.grade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.grade.service.GradeService;

@Controller
public class AdminGradeDeleteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="gradeService")
	private GradeService gradeService;

	@RequestMapping("/admin/grade/delete.do")
	@ResponseBody
	public Map<String,String> submit(@RequestParam(value="grade_num") List<Integer> list) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("list : " + list);
		}

		//관리자 글 삭제
		gradeService.deleteByGradeNum(list);

		Map<String,String> map = new HashMap<String,String>();

		try{
			map.put("result" , "success");			
		}catch (Exception e){
			e.printStackTrace();
			map.put("result","failure");
		}

		return map;
	}
}