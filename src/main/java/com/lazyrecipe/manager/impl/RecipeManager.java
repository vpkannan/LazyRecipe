/**
 * 
 */
package com.lazyrecipe.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.lazyrecipe.entity.Recipe;
import com.lazyrecipe.manager.RecipeManagement;

/**
 * @author Vignesh
 *
 *         Recipe Manager. Contains the methods to manage Recipe entity.
 */
public class RecipeManager implements RecipeManagement {

	ApplicationContext ctx;
	MongoOperations mongoOperation;

	/**
	 * Initialize stuff
	 */
	public RecipeManager() {
		// TODO Auto-generated constructor stub
		ctx = new GenericXmlApplicationContext("springBeans.xml");
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lazyrecipe.manager.RecipeManagement#retrieveRecipeByDishName(
	 * java.lang.String)
	 */
	public Recipe retrieveRecipeByDishName(String dishName) {

		Query searchUserQuery = new Query(Criteria.where("dishName").is(dishName));
		Recipe recipe = mongoOperation.findOne(searchUserQuery, Recipe.class);

		return recipe;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lazyrecipe.manager.RecipeManagement#retrieveDishNamesByIngredients(
	 * java.util.List<String>)
	 */
	public List<String> retrieveDishNamesByIngredients(List<String> ingredients) {

		List<String> dishNames = new ArrayList<String>();

		Query searchUserQuery = new Query(Criteria.where("ingredients").in(ingredients));
		List<Recipe> recipes = mongoOperation.find(searchUserQuery, Recipe.class);

		for (Recipe recipe : recipes) {
			if (ingredients.containsAll(recipe.getIngredients())) {
				dishNames.add(recipe.getDishName());
			}
		}

		return dishNames;

	}

}
