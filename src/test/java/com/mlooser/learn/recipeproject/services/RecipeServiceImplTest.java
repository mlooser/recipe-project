package com.mlooser.learn.recipeproject.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import com.mlooser.learn.recipeproject.converters.RecipeCommandToRecipe;
import com.mlooser.learn.recipeproject.converters.RecipeToRecipeCommand;
import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	private RecipeServiceImpl reciperService;

	@Mock
	private RecipeRepository recipeRepository;

	@Mock
  private RecipeCommandToRecipe recipeCommandToRecipe;
	
	@Mock
  private RecipeToRecipeCommand recipeToRecipeCommand;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		reciperService = new RecipeServiceImpl(recipeRepository, 
		    recipeCommandToRecipe, 
		    recipeToRecipeCommand);
	}

	@Test
	public void getRecipes() {
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(new Recipe());

		when(recipeRepository.findAll()).thenReturn(recipesData);

		Set<Recipe> recipes = reciperService.getAllRecipes();
		assertEquals(1, recipes.size());
		verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void getRecipeById() {
		Recipe recipe = new Recipe();
		recipe.setId(1l);

		Optional<Recipe> recipeOptional = Optional.of(recipe);

		Mockito
				.when(recipeRepository.findById(recipe.getId()))
				.thenReturn(recipeOptional);

		Recipe retRecipe = reciperService.findById(recipe.getId());
		assertNotNull(retRecipe);
	}
}
