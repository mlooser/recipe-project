package com.mlooser.learn.recipeproject.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipe"})
@Entity
public class Notes extends BaseEntity{
	
	@Lob
	private String recipeNotes;
	
	@OneToOne
	private Recipe recipe;
		
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}		
}
