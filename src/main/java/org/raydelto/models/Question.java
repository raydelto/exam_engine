package org.raydelto.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name="questions")
@Entity
public class Question {
	@Id
	@GeneratedValue
	private int id;	
	private String title;	
	@Column(name="multiple_answers")
	private boolean multipleAnswers;
	private short priority;
	@ManyToOne
	@JoinColumn(name="exam_id")
	private Exam exam;
	@OneToMany
	private Set<Answer> answers;
	
	
	public Question(){
	}


	public Question(String title, boolean multipleAnswers, short priority, Exam exam) {
		super();
		this.title = title;
		this.multipleAnswers = multipleAnswers;
		this.priority = priority;
		this.exam = exam;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isMultipleAnswers() {
		return multipleAnswers;
	}


	public void setMultipleAnswers(boolean multipleAnswers) {
		this.multipleAnswers = multipleAnswers;
	}


	public short getPriority() {
		return priority;
	}


	public void setPriority(short priority) {
		this.priority = priority;
	}


	public Exam getExam() {
		return exam;
	}


	public void setExam(Exam exam) {
		this.exam = exam;
	}


	public Set<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
}
