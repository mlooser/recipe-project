package com.mlooser.learn.recipeproject.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.services.RecipeService;

public class RecipeControllerTest {

  @Mock
  private RecipeService recipeService;

  private RecipeController recipeController;

  private MockMvc mockMvc;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    recipeController = new RecipeController(recipeService);
    mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
  }

  @Test
  public void showRecipeTest() throws Exception {

    Recipe recipe = new Recipe();
    recipe.setId(1l);

    Mockito.when(recipeService.findById(1l)).thenReturn(recipe);

    mockMvc
        .perform(get("/recipe/1/show"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/show"))
        .andExpect(model().attributeExists("recipe"));

  }

  @Test
  public void deleteActionTest() throws Exception {
    mockMvc.perform(get("/recipe/1/delete"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/"));

    verify(recipeService, times(1)).deleteById(anyLong());
  }
}
