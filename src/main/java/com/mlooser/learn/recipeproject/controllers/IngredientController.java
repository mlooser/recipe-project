package com.mlooser.learn.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mlooser.learn.recipeproject.services.RecipeService;

@Controller
public class IngredientController {

  private RecipeService recipeService;

  public IngredientController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/recipe/{recipeId}/ingredients")
  public String listIngredients(@PathVariable Long recipeId, Model model) {
    model.addAttribute("recipe", recipeService.findCommandById(recipeId));
    return "recipe/ingredient/list";
  }
}
