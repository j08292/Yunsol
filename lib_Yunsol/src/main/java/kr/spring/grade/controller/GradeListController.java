package kr.spring.grade.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.grade.domain.GradeCommand;
import kr.spring.grade.service.GradeService;
import kr.spring.util.PagingUtil;

@Controller
public class GradeListController {
	private Logger log = Logger.getLogger(getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource
	private GradeService gradeService;
	
	@RequestMapping("/book/listGradeAjax.do")
	@ResponseBody
	public Map<String, Object> process(
							@RequestParam(value="pageNum", defaultValue="1") int currentPage,
							@RequestParam(value="list_num") int list_num){
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
			log.debug("list_num : " + list_num );
		}
		
			HashMap<String, Object> hashMap = new HashMap<String,Object>();
			hashMap.put("list_num", list_num);
			
			//ÃÑ ´ñ±ÛÀÇ °¹¼ö
			int count = gradeService.getRowCountGrade(hashMap);
			
			PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"listGradeAjax.do");
			hashMap.put("start", page.getStartCount());
			hashMap.put("end", page.getEndCount());
			
			List<GradeCommand> list = null;
			if(count > 0){
				list = gradeService.list(hashMap);
			}else{
				list = Collections.emptyList();
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("count", count);
			map.put("rowCount", rowCount);
			map.put("list", list);
					
			return map;			

	}
}
