package com.mlooser.learn.recipeproject.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class RecipeServiceImpl implements RecipeService{

	private RecipeRepository recipeRepository;
	
	
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

}
