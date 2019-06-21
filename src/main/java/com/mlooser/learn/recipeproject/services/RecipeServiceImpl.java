package com.mlooser.learn.recipeproject.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mlooser.learn.recipeproject.commands.RecipeCommand;
import com.mlooser.learn.recipeproject.converters.RecipeCommandToRecipe;
import com.mlooser.learn.recipeproject.converters.RecipeToRecipeCommand;
import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class RecipeServiceImpl implements RecipeService{

	private RecipeRepository recipeRepository;
	private RecipeCommandToRecipe recipeCommandToRecipe;
	private RecipeToRecipeCommand recipeToRecipeCommand;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}


	@Override
	public Set<Recipe> getAllRecipes() { 		
		Set<Recipe> retSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(retSet::add);
		return retSet;
	}
	
	@Override
	public Recipe finById(Long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		return recipe.orElseThrow(()->new RuntimeException("Recipe not found!"));
	}

	@Override
	public RecipeCommand saveRecipe(RecipeCommand recipeCommand) {
	  Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
	  Recipe savedRecipe = recipeRepository.save(recipe);
	  return recipeToRecipeCommand.convert(savedRecipe);
	}
}
