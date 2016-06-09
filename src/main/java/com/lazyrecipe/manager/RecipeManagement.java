package com.lazyrecipe.manager;

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

}