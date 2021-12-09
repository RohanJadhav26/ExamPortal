package com.exam.service.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exam.Repo.CategoryRepository;
import com.exam.model.exam.Category;
import com.exam.service.CategoryService;
@Component
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>(categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		
		return categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = new Category();
		category.setCid(categoryId);
		categoryRepository.delete(category);
	}
	

}
