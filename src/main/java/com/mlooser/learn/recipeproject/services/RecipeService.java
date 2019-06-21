package com.mlooser.learn.recipeproject.services;

import java.util.Set;

import com.mlooser.learn.recipeproject.commands.RecipeCommand;
import com.mlooser.learn.recipeproject.model.Recipe;

public interface RecipeService {
	Set<Recipe> getAllRecipes();
	Recipe finById(Long id);	
	RecipeCommand saveRecipe(RecipeCommand recipeCommand);
}
