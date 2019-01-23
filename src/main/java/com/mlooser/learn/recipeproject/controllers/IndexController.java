package com.mlooser.learn.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.services.RecipeService;

@Controller
public class IndexController {

	private RecipeService recipeService;	

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}



	@RequestMapping({"","/","index"})
	public String index(Model model) {
		Iterable<Recipe> recipes = recipeService.getAllRecipes();
		
		model.addAttribute("recipes", recipes);
		
		return "index";
	}
}
