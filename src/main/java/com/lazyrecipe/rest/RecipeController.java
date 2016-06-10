/**
 * 
 */
package com.lazyrecipe.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.lazyrecipe.entity.Recipe;
import com.lazyrecipe.manager.RecipeManagement;
import com.lazyrecipe.manager.impl.RecipeManager;

/**
 * @author Vignesh
 * 
 *         Recipe REST controller. REST API for Recipe
 */

@Path("/recipe")
public class RecipeController {

	RecipeManagement recipeManager;

	public RecipeController() {
		recipeManager = new RecipeManager();
	}

	@GET
	@Path("/get")
	public Recipe getRecipeByName(@QueryParam("dishname") String dishName) {

		Recipe recipe = recipeManager.retrieveRecipeByDishName(dishName);

		return recipe;
	}
}
