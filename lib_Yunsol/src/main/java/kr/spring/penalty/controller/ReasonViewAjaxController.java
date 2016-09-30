package kr.spring.penalty.controller;

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

import kr.spring.penalty.domain.PenaltyCommand;
import kr.spring.penalty.service.PenaltyService;

@Controller
public class ReasonViewAjaxController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PenaltyService penaltyService;
	
	@RequestMapping("/admin/blockmember/reasonViewAjax.do")
	@ResponseBody
	public Map<String, Object> process(@RequestParam("mem_id") String mem_id){
		if(log.isDebugEnabled()){
			log.debug("mem_id : " + mem_id);
		}
		
		//누적 사유 개수
		int count = penaltyService.getReasonCount(mem_id);
		
		List<PenaltyCommand> list = null;
		if(count>0){
			list = penaltyService.reasonView(mem_id);
		}else{
			list = Collections.emptyList();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count",count);
		map.put("list", list);
		
		return map;
	}
}
