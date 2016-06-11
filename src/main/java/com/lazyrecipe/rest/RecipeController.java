/**
 * 
 */
package com.lazyrecipe.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe getRecipeByName(@QueryParam("dishname") String dishName) {

		Recipe recipe = recipeManager.retrieveRecipeByDishName(dishName);

		return recipe;
	}

	@GET
	@Path("/get/dishnames")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getDishNamesByIngredients(@QueryParam("ingredients") String ingredientsString) {

		String[] ingredientsArray = ingredientsString.split(",");

		List<String> ingredients = Arrays.asList(ingredientsArray);

		List<String> dishNames = recipeManager.retrieveDishNamesByIngredients(ingredients);

		return dishNames;
	}
}
