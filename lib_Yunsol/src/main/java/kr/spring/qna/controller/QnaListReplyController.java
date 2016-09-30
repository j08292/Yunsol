package kr.spring.qna.controller;

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

import kr.spring.qna.domain.QnaReplyCommand;
import kr.spring.qna.service.QnaService;
import kr.spring.util.PagingUtil;

@Controller
public class QnaListReplyController {
	
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	
	@Resource
	private QnaService qnaService;
	
	
	@RequestMapping("/board/qListReplyAjax.do")
	@ResponseBody
	public Map<String, Object> process(
					@RequestParam(value="pageNum" , defaultValue = "1")
					int currentPage,
					@RequestParam("qna_num")int qna_num){
		
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
			log.debug("qna_num : "+ qna_num);
		}
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("qna_num", qna_num);
		
		
		//ÃÑ ´ñ±ÛÀÇ °¹¼ö
		int count = qnaService.getRowCountReply(hashMap);
		
		PagingUtil page = new PagingUtil(currentPage, count,
						rowCount, pageCount, "qnaListReply.do");
		hashMap.put("start", page.getStartCount());
		hashMap.put("end",page.getEndCount());
		
	
	
	List<QnaReplyCommand>list = null;
	if(count>0){
		list = qnaService.listReply(hashMap);
	}else{
		list= Collections.emptyList();
	}
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("count", count);
	map.put("rowCount", rowCount);
	map.put("list", list);
	
	
	return map;
	}
}
