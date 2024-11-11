package com.anup.enotebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anup.enotebook.entity.Category;
import com.anup.enotebook.service.CategoryServicce;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryCantroller {

	@Autowired
	private CategoryServicce categoryServicce ;
	
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		
		Boolean saveCategories = categoryServicce.saveCategory(category);
		if(saveCategories) {
			return new ResponseEntity<>("saved" , HttpStatus.CREATED );
		}
		else {
			return new ResponseEntity<>("not saved" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/get-list")
	public ResponseEntity<?> getAllCategories(){
	 List<Category> getcategories =	categoryServicce.getAllCategory();
	 
	 if(CollectionUtils.isEmpty(getcategories)) {
		 return  ResponseEntity.noContent().build();
	 }
	 else {
		 return new ResponseEntity<>("All Categories" , HttpStatus.OK);
	 }
		
		
	}
}
