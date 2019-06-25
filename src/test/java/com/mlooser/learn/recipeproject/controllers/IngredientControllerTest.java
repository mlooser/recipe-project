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

import com.mlooser.learn.recipeproject.commands.RecipeCommand;
import com.mlooser.learn.recipeproject.services.RecipeService;

public class IngredientControllerTest {

  @Mock
  private RecipeService recipeService;

  private IngredientController ingredientController;
  private MockMvc mockMvc;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    ingredientController = new IngredientController(recipeService);
    mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
  }

  @Test
  public void listIngredientsTest() throws Exception {
    // given
    RecipeCommand recipeCommand = new RecipeCommand();
    when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

    // when
    mockMvc.perform(get("/recipe/1/ingredients"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/ingredient/list"))
        .andExpect(model().attributeExists("recipe"));

    // then
    verify(recipeService, times(1)).findCommandById(anyLong());
  }
}
