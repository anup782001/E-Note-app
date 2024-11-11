package com.anup.enotebook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.anup.enotebook.entity.Category;
import com.anup.enotebook.repository.CategoryRepository;
import com.anup.enotebook.service.CategoryServicce;

@Service
public class CategoryServiceImpl  implements CategoryServicce {
	
	@Autowired
	private CategoryRepository categoryRepository ;

	@Override
	public Boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
	Category saveCategory =	categoryRepository.save(category);
	
	
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false ;
		}
		return true ;
	}

	@Override
	public List<Category> getAllCategory() {
		
		List<Category> categories = categoryRepository.findAll();
		return categories ;
	}

}
