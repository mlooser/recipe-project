package com.mlooser.learn.recipeproject.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;
import com.mlooser.learn.recipeproject.commands.RecipeCommand;
import com.mlooser.learn.recipeproject.services.IngredientService;
import com.mlooser.learn.recipeproject.services.RecipeService;
import com.mlooser.learn.recipeproject.services.UnitOfMeasureService;

public class IngredientControllerTest {

  @Mock
  private RecipeService recipeService;

  @Mock
  private IngredientService ingredientService;

  @Mock
  private UnitOfMeasureService unitOfMeasureService;
  
  private IngredientController ingredientController;
  private MockMvc mockMvc;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    ingredientController = new IngredientController(
        recipeService, 
        ingredientService, 
        unitOfMeasureService);
    
    mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
  }

  @Test
  public void listIngredientsTest() throws Exception {
    // given
    RecipeCommand recipeCommand = new RecipeCommand();
    
    // when
    when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

    // then
    mockMvc.perform(get("/recipe/1/ingredients"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/ingredient/list"))
        .andExpect(model().attributeExists("recipe"));

    // verify
    verify(recipeService, times(1)).findCommandById(anyLong());
  }

  @Test
  public void showIngredientTest() throws Exception {
    // given
    IngredientCommand ingredientCommand = new IngredientCommand();

    // when
    when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);

    // then
    mockMvc.perform(get("/recipe/1/ingredient/2/show"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/ingredient/show"))
        .andExpect(model().attributeExists("ingredient"));
  }
}
