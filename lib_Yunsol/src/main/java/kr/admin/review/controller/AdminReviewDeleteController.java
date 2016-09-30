package kr.admin.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.review.domain.ReviewCommand;
import kr.spring.review.service.ReviewService;
import kr.spring.util.FileUtil;

@Controller
public class AdminReviewDeleteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="reviewService")
	private ReviewService reviewService;

	@RequestMapping("/admin/review/delete.do")
	@ResponseBody
	public Map<String,String> submit(@RequestParam(value="review_num") List<Integer> list) throws Exception{

		System.out.println("list : " + list);

		if(log.isDebugEnabled()){
			log.debug("list : " + list);
		}

		List<ReviewCommand> reviewList = reviewService.selectReviewAdmin(list);

		//包府磊 臂 昏力
		reviewService.deleteByReviewNum(list);


		for(ReviewCommand reviewCommand : reviewList){
			//颇老 昏力 咯何 眉农
			if(reviewCommand.getReview_file()!=null){
				FileUtil.removeFile(reviewCommand.getReview_file());
			}
		}

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