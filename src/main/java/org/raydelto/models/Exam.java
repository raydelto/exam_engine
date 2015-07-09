package org.raydelto.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name="exams")
@Entity
public class Exam {
	@Id
	@GeneratedValue
	private int id;	
	private String name;	
	private String description;
	@Column(name="total_score")
	private short totalScore;
	@Column(name="pass_score")
	private short passScore;
	@Column(name="exam_duration")
	private short examDuration; 	//duration in minutes
    @OneToMany
    private Set<Question> questions;

	public Exam(){
	}

	public Exam(String name, String description, short totalScore, short passScore, short examDuration) {
		super();
		this.name = name;
		this.description = description;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.examDuration = examDuration;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public short getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(short totalScore) {
		this.totalScore = totalScore;
	}


	public short getPassScore() {
		return passScore;
	}


	public void setPassScore(short passScore) {
		this.passScore = passScore;
	}


	public short getExamDuration() {
		return examDuration;
	}


	public void setExamDuration(short examDuration) {
		this.examDuration = examDuration;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", description=" + description + ", totalScore=" + totalScore
				+ ", passScore=" + passScore + ", examDuration=" + examDuration + ", questions=" + questions + "]";
	}
	
	

}
