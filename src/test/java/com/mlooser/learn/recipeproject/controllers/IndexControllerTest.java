package com.mlooser.learn.recipeproject.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.services.RecipeService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashSet;
import java.util.Set;

public class IndexControllerTest {

	@Mock
	private RecipeService recipeService = null;
	
	@Mock
	private Model model = null;
	
	private IndexController indexController = null;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(get("/"))
		 .andExpect(status().isOk())
		 .andExpect(view().name("index"));
		
	}
	
	@Test
	public void index() {
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe("r1"));
		recipes.add(new Recipe("r2"));		
		
		
		
		when(recipeService.getAllRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> captor = ArgumentCaptor.forClass(Set.class);
		
		
		
		
		
		String viewName = indexController.index(model);
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getAllRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), captor.capture());
		assertEquals(2, captor.getValue().size());		
	}
		
	
}
