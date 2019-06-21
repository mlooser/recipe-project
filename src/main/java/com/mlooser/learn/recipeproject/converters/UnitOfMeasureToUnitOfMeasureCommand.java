package com.mlooser.learn.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.commands.UnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.model.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

  @Nullable
  @Override
  public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

      if (unitOfMeasure != null) {
          final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
          uomc.setId(unitOfMeasure.getId());
          uomc.setDescription(unitOfMeasure.getDescription());
          return uomc;
      }
      return null;
  }

}
