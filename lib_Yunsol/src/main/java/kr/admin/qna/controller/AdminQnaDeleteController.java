package kr.admin.qna.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.qna.service.QnaService;

@Controller
public class AdminQnaDeleteController {
   private Logger log = Logger.getLogger(this.getClass());

   @Resource(name="qnaService")
   private QnaService qnaService;

   @RequestMapping("/admin/qna/delete.do")
   @ResponseBody
   public Map<String,String> submit(@RequestParam(value="qna_num") List<Integer> list) throws Exception{

      if(log.isDebugEnabled()){
         log.debug("list : " + list);
      }

      //관리자 글 삭제
      qnaService.deleteByQnaNum(list);

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