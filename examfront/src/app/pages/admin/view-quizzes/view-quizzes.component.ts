import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit {
  quizzes=[
    {
      qId:0,
      title:'',
      description:'',
      maxmarks:'',
      numberOfQuestions:'',
      active:'',
      category: {
        title: ''
      }
    }
  ];
  constructor(private quizService:QuizService) { }

  ngOnInit(): void {
    this.quizService.quizzes().subscribe((data:any)=>{
      this.quizzes=data
      console.log(this.quizzes)
    },(error)=>{
      console.log(error)
    })
  }

}
