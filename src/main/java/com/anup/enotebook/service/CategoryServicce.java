package com.anup.enotebook.service;

import java.util.List;

import com.anup.enotebook.entity.Category;

public interface CategoryServicce {
	
	public Boolean saveCategory(Category category);
	
	public List<Category> getAllCategory();
	
	

}
