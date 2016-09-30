package kr.spring.penalty.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.penalty.domain.PenaltyCommand;
import kr.spring.penalty.service.PenaltyService;

@Controller
public class PenaltyInsertController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private PenaltyService penaltyService;
	
	@RequestMapping("/admin/member/insertPenalty.do")
	public String process(@RequestParam("mem_id") String mem_id,
								@RequestParam("penalty_reason") String penalty_reason){
		
		if(log.isDebugEnabled()){
			log.debug("mem_id : " + mem_id);
			log.debug("penalty_reason : " + penalty_reason);
		}
		
		PenaltyCommand penalty = new PenaltyCommand();
		penalty.setMem_id(mem_id);
		penalty.setPenalty_reason(penalty_reason);
		penaltyService.insert(penalty);
		
		
		return "redirect:/admin/member/list.do";
	}
}