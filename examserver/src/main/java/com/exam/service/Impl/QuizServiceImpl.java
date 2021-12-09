package com.exam.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.Repo.QuizRepository;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
@Component
public class QuizServiceImpl implements QuizService{
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<>(quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		return quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		quizRepository.delete(quiz);
		
		//quizRepository.deleteById(quizId);
	}
	
}
