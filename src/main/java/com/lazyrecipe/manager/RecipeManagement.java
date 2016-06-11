package com.lazyrecipe.manager;

import java.util.List;

import com.lazyrecipe.entity.Recipe;

/**
 * Interface for Recipe Manager class
 * 
 * @author Vignesh
 *
 */
public interface RecipeManagement {

	/**
	 * Method to retrieve recipe by dish name
	 * 
	 * @param dishName
	 *            Name of the dish
	 * @return Complete recipe for the dish
	 */
	public Recipe retrieveRecipeByDishName(String dishName);

	/**
	 * Method to retrieve list of dish names by ingredients. Dish names that
	 * require only the set or a subset of ingredients will be returned
	 * 
	 * @param ingredients
	 *            List of ingredients
	 * @return A list of dish names
	 */
	public List<String> retrieveDishNamesByIngredients(List<String> ingredients);

}