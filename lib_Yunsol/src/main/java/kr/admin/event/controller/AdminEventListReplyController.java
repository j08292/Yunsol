package kr.admin.event.controller;

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

import kr.spring.event.domain.EventReplyCommand;
import kr.spring.event.service.EventService;
import kr.spring.util.PagingUtil;

@Controller
public class AdminEventListReplyController {
   private Logger log = Logger.getLogger(this.getClass());
   private int rowCount = 10;
   private int pageCount = 10;
   
   @Resource
   private EventService eventService;
   
   @RequestMapping("/admin/event/listReplyAjax.do")
   @ResponseBody
   public Map<String, Object> process(@RequestParam(value="pageNum",defaultValue="1")int currentPage,
                              @RequestParam("event_num")int event_num){
      if(log.isDebugEnabled()){
         log.debug("pageNum : " + currentPage);
         log.debug("event_num : " + event_num);
      }
      
      HashMap<String,Object> hashMap = new HashMap<String,Object>();
      hashMap.put("event_num",event_num);
      
      //ÃÑ ´ñ±ÛÀÇ °¹¼ö
      int count = eventService.getRowCountReply(hashMap);
      
      PagingUtil page = new PagingUtil(currentPage, count,rowCount, pageCount, "listReplyAjax.do");
      hashMap.put("start",page.getStartCount());
      hashMap.put("end",page.getEndCount());
      
      List<EventReplyCommand> list = null;
      if(count > 0){
         list = eventService.listReply(hashMap);
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