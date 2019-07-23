package com.mlooser.learn.recipeproject.services;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;
import com.mlooser.learn.recipeproject.converters.IngredientCommandToIngredient;
import com.mlooser.learn.recipeproject.converters.IngredientToIngredientCommand;
import com.mlooser.learn.recipeproject.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.mlooser.learn.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.model.Ingredient;
import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;
import com.mlooser.learn.recipeproject.repositories.UnitOfMeasureRepository;

public class IngredientServiceImplTest {

  @Mock
  private RecipeRepository recipeRepository;

  @Mock
  private UnitOfMeasureRepository unitOfMeasureRepository;

  private IngredientToIngredientCommand ingredientToIngredientCommand = new IngredientToIngredientCommand(
      new UnitOfMeasureToUnitOfMeasureCommand());

  private IngredientCommandToIngredient ingredientCommandToIngredient = new IngredientCommandToIngredient(
      new UnitOfMeasureCommandToUnitOfMeasure());

  private IngredientService ingredientService;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);

    ingredientService = new IngredientServiceImpl(
        recipeRepository,
        ingredientToIngredientCommand,
        unitOfMeasureRepository,
        ingredientCommandToIngredient);
  }

  @Test
  public void findByRecipeIdAndIngredientId() {
    // given
    Recipe recipe = new Recipe();
    recipe.setId(1l);

    Ingredient ingredient1 = new Ingredient();
    ingredient1.setId(1l);

    Ingredient ingredient2 = new Ingredient();
    ingredient2.setId(2l);

    recipe.addIngredient(ingredient1);
    recipe.addIngredient(ingredient2);

    Optional<Recipe> recipeOptional = Optional.of(recipe);

    // when
    when(recipeRepository.findById(1l)).thenReturn(recipeOptional);

    // then
    IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1l, 1l);

    // verify
    assertEquals(Long.valueOf(1l), ingredientCommand.getId());
    assertEquals(Long.valueOf(1l), ingredientCommand.getRecipeId());
  }
  
  @Test
  public void saveIngredientCommand() {
    
    
  }
}
