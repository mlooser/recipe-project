package com.mlooser.learn.recipeproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipes"})
@Entity
public class Category extends BaseEntity{
	private String name;
	
	@ManyToMany(mappedBy="categories")
	private Set<Recipe> recipes;	
	
	public void addRecipe(Recipe recipe) {
		if(recipes == null) {
			recipes = new HashSet<>();
		}
		recipes.add(recipe);
	}
	
}
