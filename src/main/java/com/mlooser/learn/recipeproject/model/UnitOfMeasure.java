package com.mlooser.learn.recipeproject.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class UnitOfMeasure extends BaseEntity {
  private String description;

  public UnitOfMeasure(Long id, String name) {
    this.description = name;
    setId(id);
  }

  public UnitOfMeasure() {
  }

}
