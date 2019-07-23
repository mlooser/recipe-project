package com.mlooser.learn.recipeproject.services;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.mlooser.learn.recipeproject.commands.UnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.repositories.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

  private UnitOfMeasureRepository unitOfMeasureRepository;
  private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

  public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
      UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
  }

  @Override
  public Set<UnitOfMeasureCommand> getAllUoms() {
    return StreamSupport
        .stream(unitOfMeasureRepository.findAll().spliterator(), false)
        .map(unitOfMeasureToUnitOfMeasureCommand::convert)
        .collect(Collectors.toSet());
  }

}
