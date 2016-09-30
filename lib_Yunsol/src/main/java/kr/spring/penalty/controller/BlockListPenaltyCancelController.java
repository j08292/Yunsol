package kr.spring.penalty.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.penalty.service.PenaltyService;

@Controller
public class BlockListPenaltyCancelController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PenaltyService penaltyService;
	
	@RequestMapping("/admin/blockmember/penaltyCancel.do")
	public String process(@RequestParam("mem_id") String mem_id){
		if(log.isDebugEnabled()){
			log.debug("mem_id : " + mem_id);
		}
		
		penaltyService.updateCancelDate(mem_id);
		
		return "redirect:/admin/blockmember/list.do";
	}
}
