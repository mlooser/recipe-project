package com.mlooser.learn.recipeproject.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mlooser.learn.recipeproject.model.Recipe;
import com.mlooser.learn.recipeproject.repositories.CategoryRepository;
import com.mlooser.learn.recipeproject.repositories.RecipeRepository;
import com.mlooser.learn.recipeproject.repositories.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

	private UnitOfMeasureRepository uomRepository;
	private CategoryRepository categoryRepository;
	private RecipeRepository recipeRepository;
	
	public DataLoader(UnitOfMeasureRepository uomRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
		super();
		this.uomRepository = uomRepository;
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		initData();		
//	}
	
	private void initData() {
		log.info("Loading init data");
		
		Recipe rep1 = new Recipe();
		rep1.setName("Spicy Grilled Chicken Tacos");
		rep1.addCategory(categoryRepository.findByName("dinner").get());
		rep1.addCategory(categoryRepository.findByName("grill").get());
		rep1.addCategory(categoryRepository.findByName("quick and easy").get());
		rep1.addCategory(categoryRepository.findByName("chicken").get());
		recipeRepository.save(rep1);
		
		
		Recipe rep2 = new Recipe();
		rep2.setName("Perfect Guacamole");
		rep2.addCategory(categoryRepository.findByName("dip").get());
		rep2.addCategory(categoryRepository.findByName("mexican").get());
		rep2.addCategory(categoryRepository.findByName("vegan").get());
		rep2.addCategory(categoryRepository.findByName("avocado").get());
		recipeRepository.save(rep2);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();		
	}
}

