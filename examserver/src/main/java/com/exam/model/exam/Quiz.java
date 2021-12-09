package com.exam.model.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long qId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String maxmarks;
	@Column
	private String numberOfQuestions;
	@Column
	private boolean active = false;

	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> question = new HashSet<>();

	public Quiz() {
		super();
	}

	public Quiz(long qId, String title, String description, String maxmarks, String numberOfQuestions, boolean active) {
		super();
		this.qId = qId;
		this.title = title;
		this.description = description;
		this.maxmarks = maxmarks;
		this.numberOfQuestions = numberOfQuestions;
		this.active = active;
	}

	public long getqId() {
		return qId;
	}

	public void setqId(long qId) {
		this.qId = qId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(String maxmarks) {
		this.maxmarks = maxmarks;
	}

	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

}
