package kr.admin.speech.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.speech.domain.SpeechCommand;
import kr.spring.speech.service.SpeechService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class SpeechUpdateController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private SpeechService speechService;
	
	@RequestMapping(value="/admin/speech/update.do",method=RequestMethod.GET)
	public String form(@RequestParam("speech_num") int speech_num, Model model){
		SpeechCommand speechCommand = speechService.selectSpeech(speech_num);
		model.addAttribute("command",speechCommand);
		
		return "speechUpdate";
	}
	
	@RequestMapping(value="/admin/speech/update.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid SpeechCommand speechCommand, BindingResult result,SessionStatus status, HttpSession session) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("speechCommand : " + speechCommand);
		}
				
		if(result.hasErrors()){
			return "speechUpdate";
		}
		
		SpeechCommand speech = speechService.selectSpeech(speechCommand.getSpeech_num());
		String oldFileName="";
		
		//기존 파일명을 구함
		//업로드되는 파일이 있을 경우 기존 파일을 삭제 새로운 파일명 셋팅
		//업로드되는 파일이 없을 경우 기존 파일명을 셋팅
		oldFileName =speech.getSpeech_filename();
		
		if(!speechCommand.getUpload().isEmpty()){
			speechCommand.setSpeech_filename(FileUtil.rename(speechCommand.getUpload().getOriginalFilename()));
		}else{
			speechCommand.setSpeech_filename(oldFileName);
		}
		
		//글수정
		speechService.update(speechCommand);
		status.setComplete();
		
		if(!speechCommand.getUpload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH+"/"+speechCommand.getSpeech_filename());
			
			speechCommand.getUpload().transferTo(file);
			
			if(oldFileName!=null){
				FileUtil.removeFile(oldFileName);
			}
		}
		
		return "redirect:/admin/speech/list.do";
	}
}
