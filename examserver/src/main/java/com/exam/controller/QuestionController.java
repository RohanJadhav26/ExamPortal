package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	//get all question of any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
//		Quiz quiz = new Quiz();
//		quiz.setqId(qid);
//		Set<Question> questionOfQuiz = questionService.getQuestionOfQuiz(quiz);
//		return ResponseEntity.ok(questionOfQuiz);
		
		Quiz quiz = quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestion();
		List<Question> list = new ArrayList<>(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list= list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return questionService.getQuestion(quesId);
	}
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId) {
		questionService.deleteQuestion(quesId);
	}
}
