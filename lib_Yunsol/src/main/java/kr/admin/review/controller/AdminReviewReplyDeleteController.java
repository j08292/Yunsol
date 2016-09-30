package kr.admin.review.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.review.service.ReviewService;

@Controller
public class AdminReviewReplyDeleteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private ReviewService reviewSerview;

	@RequestMapping("/admin/review/deleteReplyAjax.do")
	@ResponseBody
	public Map<String, String> process(@RequestParam("review_re_num") int review_re_num){

		if(log.isDebugEnabled()){
			log.debug("review_re_num : " +review_re_num);
		}

		Map<String, String> map = new HashMap<String, String>();

		try{
			//¥Ò±€ ªË¡¶
			reviewSerview.deleteReply(review_re_num);
			map.put("result" , "success");			
		}catch (Exception e){
			e.printStackTrace();
			map.put("result","failure");
		}
		return map;
	}
}