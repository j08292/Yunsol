package kr.spring.qna.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.qna.service.QnaService;

@Controller
public class QnaDeleteReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource
	private QnaService qnaService;
	
	@RequestMapping("/board/qDeleteReplyAjax.do")
	@ResponseBody
	public Map<String, Object>process(@RequestParam("qna_re_num")int qna_re_num,
									@RequestParam("mem_id")String mem_id,
									HttpSession session){
		
		if(log.isDebugEnabled()){
			log.debug("qna_re_num : " +qna_re_num);
			log.debug("mem_id : " +mem_id);
		}
		Map<String, Object> map  = new HashMap<String, Object>();
		
		
		try{
			String userId = (String)session.getAttribute("userId");
			if(userId == null){
				map.put("result","logout");
			}else if(userId!=null && userId.equals(mem_id)){
				
				qnaService.deleteReply(qna_re_num);
				map.put("result", "success");
				
			}else{
				map.put("result", "wrongAcess");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}
	
		return map;
	}
	
}
