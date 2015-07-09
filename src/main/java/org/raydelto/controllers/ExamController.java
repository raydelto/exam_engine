package org.raydelto.controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpSession;

import org.raydelto.models.Exam;
import org.raydelto.models.Question;
import org.raydelto.models.helpers.ExamHelper;
import org.raydelto.models.helpers.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes({"exam", "username", "totalQuestions", "priority", "selectedAnswers", "question", "blank", "startTime"})

public class ExamController {

    @RequestMapping(method=RequestMethod.GET, value={"/greeting"})
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping(method=RequestMethod.GET, value={"/"})
    public String index(Model model) {
    	model.addAttribute("exam", ExamHelper.getExam()); 
        return "index";
    }
    
    @RequestMapping(method=RequestMethod.GET, value={"/expired"})
    public String expired(Model model) {
		ExamHelper.gradeExam(model);    
		ExamHelper.saveResults(model);
        return "expired";
    }

    
    @RequestMapping(method=RequestMethod.GET, value={"/hasExpired"})
    public void hasExpired(Writer responseWriter, Model model) {
    	try {
    		long startTime = (long) model.asMap().get("startTime");
    		Exam exam = (Exam) model.asMap().get("exam");
    		long elapsedTime = System.currentTimeMillis() - startTime;
    		long elapsedMinutes = (elapsedTime/1000) / 60;
			responseWriter.write(elapsedMinutes>= exam.getExamDuration()?"true":"false");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    @RequestMapping(method=RequestMethod.GET, value={"/endtest"})
    public String endtest(Model model) {
    	int priority = ExamHelper.verifyBlankAnswer(model);
    	if(priority == -1){
    		ExamHelper.gradeExam(model);    
    		ExamHelper.saveResults(model);
    		return "endtest";
    	}else{
    		model.addAttribute("blank", "You haven't answered question " + priority);
    		return "redirect:showexam?priority=" + priority;
    	}    	
        
    }    
    
    @RequestMapping(method=RequestMethod.POST, value={"/saveanswers"})
    public String saveanswers(@RequestParam(value="answer", required=true) int answer, Model model, WebRequest request) {
    	ExamHelper.selectAnswer(answer, model);
    	short priority = (short) model.asMap().get("priority");
    	int totalQuestions = (int) model.asMap().get("totalQuestions");
    	model.asMap().remove("blank");    	
        request.removeAttribute("blank", WebRequest.SCOPE_SESSION);
    	if(priority != totalQuestions){
    		return "redirect:showexam?priority=" + (priority+1);
    	}else{ 
    		return "show_exam";
    	}
    		
    }    
    
    
    
    @RequestMapping(value={"/showexam"})
    public String showExam(@RequestParam(value="priority", required=false, defaultValue="1") short priority, Model model) {
    	Exam exam = ExamHelper.getExam();
    	model.addAttribute("priority", priority);
    	model.addAttribute("totalQuestions", exam.getQuestions().size());
    	//model.addAttribute("exam", exam);         	
    	Question question = null;
    	question = ExamHelper.getQuestionByPriority(exam.getQuestions(), priority);        	
    	model.addAttribute("question", question);
        return "show_exam";
    }

   
    @RequestMapping(method=RequestMethod.POST, value={"/login"})
    public String login(@RequestParam(value="username", required=true) String username,
    		@RequestParam(value="password", required=true) String password,
    		Model model) {
        model.addAttribute("username", username); 
        model.addAttribute("startTime", System.currentTimeMillis());
        if(UserHelper.login(username,password)){
        	return "redirect:showexam";
        }else{
        	model.addAttribute("message", "Username or password for user " + username + " is incorrect");
        	return index(model);
        }        
    }
    
    @RequestMapping(method=RequestMethod.GET, value={"/logout"})
    public String logout(HttpSession session, Model model) {
    	model.asMap().clear();
        session.invalidate();
        return "redirect:/";
      }
}
