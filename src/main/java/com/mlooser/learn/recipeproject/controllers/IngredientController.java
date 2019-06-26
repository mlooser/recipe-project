package com.mlooser.learn.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;
import com.mlooser.learn.recipeproject.services.IngredientService;
import com.mlooser.learn.recipeproject.services.RecipeService;

@Controller
public class IngredientController {

  private RecipeService recipeService;
  private IngredientService ingredientService;
  
  public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
    this.recipeService = recipeService;
    this.ingredientService = ingredientService;
  }

  @GetMapping("/recipe/{recipeId}/ingredients")
  public String listIngredients(@PathVariable Long recipeId, Model model) {
    model.addAttribute("recipe", recipeService.findCommandById(recipeId));
    return "recipe/ingredient/list";
  }
  
  @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
  public String showRecipeIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId, Model model) {
    IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId);
    model.addAttribute("ingredient", ingredientCommand);
    return "recipe/ingredient/show";
  }
}
