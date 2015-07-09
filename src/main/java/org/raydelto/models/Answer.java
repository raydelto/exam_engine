package org.raydelto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "answers")
@Entity
public class Answer {
	@Id
	@GeneratedValue
	private int id;
	private String text;
	private short priority;
	private boolean correct;	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;

	public Answer() {
	}

	public Answer(String text, short priority, boolean correct, Question question) {
		super();
		this.text = text;
		this.priority = priority;
		this.correct = correct;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public short getPriority() {
		return priority;
	}

	public void setPriority(short priority) {
		this.priority = priority;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
