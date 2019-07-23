package com.mlooser.learn.recipeproject.services;

import java.util.Set;

import com.mlooser.learn.recipeproject.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
  Set<UnitOfMeasureCommand> getAllUoms();
}
