package com.exam.controller;

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

import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	//add quiz service
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	} 
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
	//get quiz
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(quizService.getQuizzes());
	}
	
	//get Single quiz
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid") Long qid) {
		return quizService.getQuiz(qid);
	}
	
	//delete the quiz
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") Long qid) {
		quizService.deleteQuiz(qid);
	}
}
