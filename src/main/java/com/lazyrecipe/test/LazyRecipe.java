package com.lazyrecipe.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.lazyrecipe.entity.Recipe;

public class LazyRecipe {

	public static void main(String[] args) {

		// ApplicationContext context = new
		// FileSystemXmlApplicationContext("springBeans.xml");

		// Recipe recipe = (Recipe) context.getBean("recipe");
		// System.out.println("Tonight's dinner is " + recipe.getDishName());

		ApplicationContext ctx = new GenericXmlApplicationContext("springBeans.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		List<String> omletIngredients = new ArrayList<String>();
		omletIngredients.add("Flour");
		omletIngredients.add("Sugar");
		omletIngredients.add("Egg");
		Recipe breakfastRecipe = new Recipe("Cake", omletIngredients);

		mongoOperation.save(breakfastRecipe);

		System.out.println(breakfastRecipe);

	}
}
