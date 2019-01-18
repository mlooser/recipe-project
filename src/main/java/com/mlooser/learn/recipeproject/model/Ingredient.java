package com.mlooser.learn.recipeproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"uom","recipe"})
@Entity
public class Ingredient extends BaseEntity{
	private String description;
	private Integer amount;	
	
	@OneToOne(fetch=FetchType.EAGER)
	private UnitOfMeasure uom;
	
	@ManyToOne
	private Recipe recipe;
	
}
