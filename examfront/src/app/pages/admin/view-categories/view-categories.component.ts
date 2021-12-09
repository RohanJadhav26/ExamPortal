import { Component, OnInit } from '@angular/core';
import { switchAll } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-view-categories',
  templateUrl: './view-categories.component.html',
  styleUrls: ['./view-categories.component.css']
})
export class ViewCategoriesComponent implements OnInit {
  categories=[
    {
      cid:0,
      title:'',
      description:''
    },
    
  ]

  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.categoryService.categories().subscribe((data:any)=>{
      this.categories=data;
      console.log(this.categories);
    },
    (error)=>{
      console.log(error);
      alert("Error !!, error in loading data")
    });
  }

}
