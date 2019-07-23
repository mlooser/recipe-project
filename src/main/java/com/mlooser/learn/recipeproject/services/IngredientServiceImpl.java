package com.mlooser.learn.recipeproject.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;
import com.mlooser.learn.recipeproject.converters.IngredientCommandToIngredient;
import com.mlooser.learn.recipeproject.converters.IngredientToIngredientCommand;
import com.mlooser.learn.recipeproject.model.Ingredient;
import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;
import com.mlooser.learn.recipeproject.repositories.UnitOfMeasureRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

  private RecipeRepository recipeRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;

  private IngredientToIngredientCommand ingredientToIngredientCommand;
  private IngredientCommandToIngredient ingredientCommandToIngredient;

  public IngredientServiceImpl(RecipeRepository recipeRepository,
      IngredientToIngredientCommand ingredientToIngredientCommand,
      UnitOfMeasureRepository unitOfMeasureRepository,
      IngredientCommandToIngredient ingredientCommandToIngredient) {

    this.recipeRepository = recipeRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;

    this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    this.ingredientCommandToIngredient = ingredientCommandToIngredient;
  }

  @Override
  public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

    Recipe owner = recipeRepository
        .findById(recipeId)
        .orElseThrow(() -> new RuntimeException("No repository for id " + recipeId));

    Ingredient ingredient = owner
        .getIngredients()
        .stream()
        .filter(i -> i.getId().equals(ingredientId))
        .findFirst()
        .orElseThrow(() -> new RuntimeException(
            String.format("Ingredient %s not found for recipe %s!", ingredientId, recipeId)));

    return ingredientToIngredientCommand.convert(ingredient);
  }

  public IngredientCommand saveIngredientCommand(IngredientCommand command) {

    Recipe recipe = recipeRepository
        .findById(command.getRecipeId())
        .orElseThrow(() -> new RuntimeException("No repository for id " + command.getRecipeId()));

    Optional<Ingredient> ingredientOptional = recipe
        .getIngredients()
        .stream()
        .filter(i -> i.getId().equals(command.getId()))
        .findFirst();

    if (ingredientOptional.isPresent()) {
      Ingredient ingredient = ingredientOptional.get();
      ingredient.setAmount(command.getAmount());
      ingredient.setDescription(command.getDescription());
      ingredient.setUom(unitOfMeasureRepository.findById(command.getUom().getId()).get());
    } else {
      recipe.addIngredient(ingredientCommandToIngredient.convert(command));
    }

    recipe = recipeRepository.save(recipe);
    return recipe
        .getIngredients()
        .stream()
        .filter(i -> i.getId().equals(command.getId()))
        .map(ingredientToIngredientCommand::convert)
        .findFirst()
        .get();
  }

}
