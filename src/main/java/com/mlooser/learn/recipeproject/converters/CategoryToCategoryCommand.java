package com.mlooser.learn.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.commands.CategoryCommand;
import com.mlooser.learn.recipeproject.model.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

  @Nullable
  @Override
  public CategoryCommand convert(Category source) {
    if (source == null) {
      return null;
    }

    final CategoryCommand categoryCommand = new CategoryCommand();

    categoryCommand.setId(source.getId());
    categoryCommand.setDescription(source.getDescription());

    return categoryCommand;
  }
}
