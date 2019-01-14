package com.mlooser.learn.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mlooser.learn.recipeproject.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
