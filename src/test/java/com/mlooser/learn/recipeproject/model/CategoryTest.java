package com.mlooser.learn.recipeproject.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

	private Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() {
		Long idValue = 4l;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getName() {
		String nameValue = "test_cat";
		category.setName(nameValue);
		assertEquals(nameValue, category.getName());
	}	
}
