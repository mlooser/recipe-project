package com.mlooser.learn.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlooser.learn.recipeproject.commands.RecipeCommand;
import com.mlooser.learn.recipeproject.services.RecipeService;

@Controller
public class RecipeController {
  private RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping("/recipe/{id}/show")
  public String showById(@PathVariable("id") String id, Model model) {
    model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
    return "recipe/show";
  }

  @RequestMapping("/recipe/new")
  public String newRecipe(Model model) {
    model.addAttribute("recipe", new RecipeCommand());
    return "recipe/recipeform";
  }

  @GetMapping("/recipe/{id}/update")
  public String updateRecipe(@PathVariable Long id, Model model) {
    model.addAttribute("recipe", recipeService.findCommandById(id));
    return "recipe/recipeform";
  }
  
  @PostMapping("/recipe")
  public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand command) {
    RecipeCommand savedCommand = recipeService.saveRecipe(command);
    return "redirect:/recipe/"+savedCommand.getId()+"/show/";
  }
  
  @GetMapping("/recipe/{id}/delete")
  public String deleteRecipe(@PathVariable Long id) {
    recipeService.deleteById(id);
    return "redirect:/";
  }
}
