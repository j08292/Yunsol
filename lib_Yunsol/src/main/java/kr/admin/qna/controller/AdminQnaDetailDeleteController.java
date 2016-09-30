package kr.admin.qna.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.qna.service.QnaService;

@Controller
public class AdminQnaDetailDeleteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private QnaService qnaService;
	
	@RequestMapping("/admin/qna/detailDelete.do")
	public String submit(@RequestParam("qna_num") int qna_num) throws Exception{
		
		if(log.isDebugEnabled()){
			log.debug("qna_num : " + qna_num);
		}

		//±€ ªË¡¶
		qnaService.delete(qna_num);

		
		return "redirect:/admin/qna/list.do";
	}
}
