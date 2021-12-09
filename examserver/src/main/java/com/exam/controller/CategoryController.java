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

import com.exam.model.exam.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;


	//add category
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category category1= categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	//get category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return categoryService.getCategory(categoryId);
	}
	
	//get all categories
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(categoryService.getCategories());
	}
	
	//update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
}
