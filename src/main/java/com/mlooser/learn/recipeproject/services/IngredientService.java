package com.mlooser.learn.recipeproject.services;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;

public interface IngredientService {
  IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
