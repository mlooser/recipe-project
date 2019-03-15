package com.mlooser.learn.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlooser.learn.recipeproject.services.RecipeService;

@Controller
public class RecipeController {
	private RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping("/recipe/show/{id}")
	public String showById(@PathVariable("id") String id, Model model) {
		model.addAttribute("recipe", recipeService.finById(Long.valueOf(id)));
		return "recipe/show";		
	}
}
