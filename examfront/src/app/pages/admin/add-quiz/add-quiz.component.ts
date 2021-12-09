import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {
  categories=[
    {
      cid:23,
      title:"Programming"
    }
  ]
  quizData={
    title:'',
    description:'',
    maxmarks:'',
    numberOfQuestions:'',
    active:true,
    category:{
      cid:''
    }
  };
  constructor(private categoryService:CategoryService, private quizService:QuizService) { }

  ngOnInit(): void {
    this.categoryService.categories().subscribe(
      (data:any)=>{
        this.categories=data
      //  console.log(this.categories)
    },
    (error)=>{
      console.log(error)
      alert("Error!,Error in loading data from server.")
    })
  }

  addQuiz(){
    if(this.quizData.title.trim()=='' || this.quizData.title==null){
      alert('Title required!!');
      return;
    }
  
    //call server
      this.quizService.addQuiz(this.quizData).subscribe(
        (data:any)=>{
          alert("Quiz added Successfully")
          this.quizData={
            title:'',
            description:'',
            maxmarks:'',
            numberOfQuestions:'',
            active:true,
            category:{
              cid:''
            }
          }
        },
        (error: any)=>{
          alert(error);
          console.log(error);
        })
  }

}
