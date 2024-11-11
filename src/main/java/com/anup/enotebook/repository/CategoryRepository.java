package com.anup.enotebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anup.enotebook.entity.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer> {

}
