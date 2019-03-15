package com.mlooser.learn.recipeproject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.services.RecipeService;

public class RecipeControllerTest {

	@Mock
	private RecipeService recipeService;

	private RecipeController recipeController;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService);
	}

	@Test
	public void showRecipeTest() throws Exception {

		Recipe recipe = new Recipe();
		recipe.setId(1l);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

		Mockito.when(recipeService.finById(1l)).thenReturn(recipe);

		mockMvc
				.perform(get("/recipe/show/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/show"))
				.andExpect(model().attributeExists("recipe"));

	}
}
