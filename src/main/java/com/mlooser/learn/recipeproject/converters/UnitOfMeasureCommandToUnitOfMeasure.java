package com.mlooser.learn.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.commands.UnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.model.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

  @Nullable
  @Override
  public UnitOfMeasure convert(UnitOfMeasureCommand source) {
      if (source == null) {
          return null;
      }

      final UnitOfMeasure uom = new UnitOfMeasure();
      uom.setId(source.getId());
      uom.setDescription(source.getDescription());
      return uom;
  }

}
