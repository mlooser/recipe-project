package com.mlooser.learn.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mlooser.learn.recipeproject.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
