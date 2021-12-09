import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  category={
    title:'',
    description:'',
  };
  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
  }
  formSubmit(){
    if(this.category.title.trim()=='' || this.category.title==null){
      alert("Title Required")
      return;
    }

    this.categoryService.addCateogry(this.category).subscribe((data:any)=>{
      this.category.title='';
      this.category.description='';
      alert("Category Added Successfully!")
    },
    (error)=>{
      console.log(error)
      alert("Server Error!")
    })
  }
}
