package com.mlooser.learn.recipeproject.services;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.mlooser.learn.recipeproject.commands.UnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.mlooser.learn.recipeproject.model.UnitOfMeasure;
import com.mlooser.learn.recipeproject.repositories.UnitOfMeasureRepository;

public class UnitOfMeasureServiceImplTest {

  private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
  private UnitOfMeasureService unitOfMeasureService;

  @Mock
  private UnitOfMeasureRepository unitOfMeasureRepository;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);

    unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository,
        unitOfMeasureToUnitOfMeasureCommand);
  }

  @Test
  public void getAllUomsTest() {
    // given
    UnitOfMeasure uom1 = new UnitOfMeasure();
    uom1.setId(1l);

    UnitOfMeasure uom2 = new UnitOfMeasure();
    uom2.setId(2l);

    Set<UnitOfMeasure> uoms = new HashSet<>();
    uoms.add(uom1);
    uoms.add(uom2);

    when(unitOfMeasureRepository.findAll())
        .thenReturn(uoms);
    
    //when
    Set<UnitOfMeasureCommand> uomCommands = unitOfMeasureService.getAllUoms();
    
    //verify
    assertEquals(2, uomCommands.size());
    verify(unitOfMeasureRepository, times(1)).findAll();
  }
}
