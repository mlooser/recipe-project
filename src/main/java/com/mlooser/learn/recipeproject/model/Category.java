package com.mlooser.learn.recipeproject.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Category extends BaseEntity{
	private String name;
	
	@ManyToMany(mappedBy="categories")
	private Set<Recipe> recipes;
}
