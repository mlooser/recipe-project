package com.mlooser.learn.recipeproject.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class UnitOfMeasure extends BaseEntity{
	private String name;	
}