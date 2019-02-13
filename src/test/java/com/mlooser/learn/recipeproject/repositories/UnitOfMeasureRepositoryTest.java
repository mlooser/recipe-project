package com.mlooser.learn.recipeproject.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.mlooser.learn.recipeproject.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Test
	@DirtiesContext
	public void findByName() {
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByName("Teaspoon");	
		unitOfMeasureRepository.deleteAll();
		assertEquals("Teaspoon", uomOptional.get().getName());
	}
	
	@Test
	public void findByNameCup() {
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByName("Cup");		
		assertEquals("Cup", uomOptional.get().getName());
	}
}
