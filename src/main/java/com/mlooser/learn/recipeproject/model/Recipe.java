package com.mlooser.learn.recipeproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude= {"notes","ingredients","categories"}, callSuper = true)
@NoArgsConstructor
@Entity
public class Recipe extends BaseEntity {
		
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	@Lob
	private String directions;
	
	@Lob
	private Byte[] image;	
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="recipe_category", 
		joinColumns=@JoinColumn(name = "recipe_id"), 
		inverseJoinColumns=@JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	public Recipe(String description) {
		this.description = description;
	}
	
	public void addIngredient(Ingredient ingredient) {
		if(ingredients == null)
			ingredients = new HashSet<>();
		
		ingredients.add(ingredient);
		ingredient.setRecipe(this);
	}
	
	public void addCategory(Category category) {
		if(categories == null) {
			categories = new HashSet<>();
		}
		categories.add(category);
		//category.addRecipe(this);
	}
	
}
