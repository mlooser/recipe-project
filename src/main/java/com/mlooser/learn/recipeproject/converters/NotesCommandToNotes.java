package com.mlooser.learn.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.commands.NotesCommand;
import com.mlooser.learn.recipeproject.model.Notes;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

  @Nullable
  @Override
  public Notes convert(NotesCommand source) {
    if (source == null) {
      return null;
    }

    final Notes notes = new Notes();
    notes.setId(source.getId());
    notes.setRecipeNotes(source.getRecipeNotes());
    return notes;
  }
}
