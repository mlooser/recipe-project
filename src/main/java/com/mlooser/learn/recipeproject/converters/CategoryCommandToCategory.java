package com.mlooser.learn.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.commands.CategoryCommand;
import com.mlooser.learn.recipeproject.model.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

  @Nullable
  @Override
  public Category convert(CategoryCommand source) {
    if (source == null) {
      return null;
    }

    final Category category = new Category();
    category.setId(source.getId());
    category.setDescription(source.getDescription());
    return category;
  }
}
