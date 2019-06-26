package com.mlooser.learn.recipeproject.services;

import org.springframework.stereotype.Service;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;
import com.mlooser.learn.recipeproject.converters.IngredientToIngredientCommand;
import com.mlooser.learn.recipeproject.model.Ingredient;
import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

  private RecipeRepository recipeRepository;
  private IngredientToIngredientCommand ingredientToIngredientCommand;

  public IngredientServiceImpl(RecipeRepository recipeRepository,
      IngredientToIngredientCommand ingredientToIngredientCommand) {
    this.recipeRepository = recipeRepository;
    this.ingredientToIngredientCommand = ingredientToIngredientCommand;
  }

  @Override
  public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

    Recipe owner = recipeRepository
        .findById(recipeId)
        .orElseThrow(()->new RuntimeException("No repository for id " + recipeId));

    Ingredient ingredient = owner
        .getIngredients()
        .stream()
        .filter(i -> i.getId().equals(ingredientId))
        .findFirst()
        .orElseThrow(() -> new RuntimeException(
            String.format("Ingredient %s not found for recipe %s!", ingredientId, recipeId)));

    return ingredientToIngredientCommand.convert(ingredient);
  }

}
