package kr.admin.notice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;

@Controller
public class NoticeDeleteController {
	private Logger log= Logger.getLogger(this.getClass());

	@Resource
	private NoticeService noticeService;

	@RequestMapping("/admin/notice/delete.do")
	public String submit(@RequestParam("notice_num")int notice_num,HttpSession session) throws Exception{

		if(log.isDebugEnabled()){
			log.debug("notice_num : "+notice_num);
		}

		NoticeCommand noticeCommand = noticeService.selectNotice(notice_num);
		
		//±€ ªË¡¶
		noticeService.delete(noticeCommand.getNotice_num());

		return "redirect:/admin/notice/list.do";
	}
}