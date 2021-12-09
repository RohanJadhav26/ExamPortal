package com.exam.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.Repo.QuestionRepository;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
@Component
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		return questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		return questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question = new Question();
		question.setQuesId(quesId);
		questionRepository.delete(question);
		
	}

}
