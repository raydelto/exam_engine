package org.raydelto.models.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.raydelto.models.Answer;
import org.raydelto.models.Exam;
import org.raydelto.models.Question;
import org.raydelto.models.Result;
import org.raydelto.models.User;
import org.raydelto.util.PasswordUtil;
import org.springframework.ui.Model;

public class ExamHelper {
	
	public static void selectAnswer(int id, Model model){
		ArrayList<Integer> selectedAnswers = (ArrayList<Integer>) model.asMap().get("selectedAnswers");
		if( selectedAnswers == null){
			selectedAnswers = new ArrayList<Integer>();
			model.addAttribute("selectedAnswers", selectedAnswers);
		}
		
		Query query = PersistenceHelper.getHibernateSession().createQuery("from Answer a where a.id="+id );
        List<Answer> list = query.list();
        if(list.size() == 0){ // answer not found
        	return;
        }
        
        //remove previous answer saved for this question
        for(Answer answer: list.get(0).getQuestion().getAnswers()){
        	selectedAnswers.remove(new Integer(answer.getId()));
        }
        
        selectedAnswers.add(id);
	}
	
	
	public static void saveResults(Model model){
		String username = (String) model.asMap().get("username");
		Query query = PersistenceHelper.getHibernateSession().createQuery("from User u where u.username='"+username+"'");
        List<User> list = query.list();
        User user = list.get(0);
        Exam exam = (Exam) model.asMap().get("exam");
        int grade = (int) model.asMap().get("grade");
        
        Result result = new Result(user, exam, (short)grade, new Date());        
		Session session = PersistenceHelper.getHibernateSession();
		Transaction transaction = session.beginTransaction();
		session.persist(result);
		transaction.commit();
		session.close();		
	}
	
	
	
	public static void gradeExam(Model model){
		int totalQuestions = (int)model.asMap().get("totalQuestions");
		ArrayList<Integer> selectedAnswers = (ArrayList<Integer>) model.asMap().get("selectedAnswers");
		if(selectedAnswers == null){ //No question has been answered
			model.addAttribute("passed",  "failed");
			model.addAttribute("grade", 0);	
			return;			
		}
		Exam exam = (Exam) model.asMap().get("exam");
		int rightAnswers = 0;
		for(int i : selectedAnswers){
			Query query = PersistenceHelper.getHibernateSession().createQuery("from Answer a where a.id="+i);
	        List<Answer> list = query.list();
	        Answer answer = list.get(0);
	        if(answer.isCorrect()){
	        	rightAnswers++;
	        } 
		}
		float grade = ((float)rightAnswers /  (float)totalQuestions) * (float)exam.getTotalScore();
		model.addAttribute("passed", grade >= exam.getPassScore() ? "passed" : "failed");
		model.addAttribute("grade", (int) grade);	
	}
	
    public static int verifyBlankAnswer(Model model){
		Exam exam = (Exam) model.asMap().get("exam");
		ArrayList<Integer> selectedAnswers = (ArrayList<Integer>) model.asMap().get("selectedAnswers");
		Set<Question> questions = exam.getQuestions();
		boolean answered = false;
		if(selectedAnswers == null){
			return 1; //No answer have been selected, let's start from the first question
		}
		for(Question question: questions){
			answered = false;
			for(Answer answer: question.getAnswers()){
				if(selectedAnswers.contains(answer.getId())){
					answered = true;
					break;
				}				
			}
			if(!answered){
				return question.getPriority();	
			}			
		}
    	
    	return -1;
    }


	public static Exam getExam(){ // Just getting one exam for this demo		
        Query query = PersistenceHelper.getHibernateSession().createQuery("from Exam" );
        List<Exam> list = query.list();
		return list.size()> 0 ? list.get(0) : null;
	}
	
	public static Question getQuestionByPriority(Set<Question> questions, short priority){
		for(Question question : questions){
			if(question.getPriority() == priority){
				return question;
			}
		}
		return null;
	}
	

}
