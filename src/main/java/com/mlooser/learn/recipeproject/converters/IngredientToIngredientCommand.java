package com.mlooser.learn.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.commands.IngredientCommand;
import com.mlooser.learn.recipeproject.model.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

  private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

  public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
      this.uomConverter = uomConverter;
  }

  @Nullable
  @Override
  public IngredientCommand convert(Ingredient ingredient) {
      if (ingredient == null) {
          return null;
      }

      IngredientCommand ingredientCommand = new IngredientCommand();
      ingredientCommand.setId(ingredient.getId());
      ingredientCommand.setAmount(ingredient.getAmount());
      ingredientCommand.setDescription(ingredient.getDescription());
      ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUom()));
      return ingredientCommand;
  }

}