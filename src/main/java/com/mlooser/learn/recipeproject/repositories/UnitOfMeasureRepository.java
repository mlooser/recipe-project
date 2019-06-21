package com.mlooser.learn.recipeproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mlooser.learn.recipeproject.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	Optional<UnitOfMeasure> findByDescription(String name);
}
