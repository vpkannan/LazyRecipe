/*
 * Copyright (c) 2016, Vignesh Kannan. All rights reserved.
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
 * THE SOFTWARE.
 */
package com.lazyrecipe.entity;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipe")
public class Recipe {
	private String dishName;
	private Set<String> ingredients;
	private Set<String> baseIngredients;
	private Set<String> cookingAppliances;
	private List<String> recipeSteps;
	private String assumptions;
	private String bestFor;
	private String bestWith;
	private boolean testMode;

	public Recipe() {
	}

	/**
	 * Create a recipe with all options specified
	 * 
	 * @param dishName
	 *            Name of the dish
	 * @param ingredients
	 *            The ingredients required (mandatory)
	 * @param baseIngredients
	 *            The base ingredients required; example - water, cooking oil,
	 *            etc.
	 * @param cookingAppliances
	 *            Appliances required to make this dish
	 * @param recipeSteps
	 *            The steps to make the dish
	 * @param assumptions
	 *            Basic assumptions made before trying this recipe
	 * @param bestFor
	 *            When is this dish best for
	 * @param bestWith
	 *            How this dish should be eaten
	 */
	public Recipe(String dishName, Set<String> ingredients, Set<String> baseIngredients, Set<String> cookingAppliances,
			List<String> recipeSteps, String assumptions, String bestFor, String bestWith, boolean testMode) {
		this.dishName = dishName;
		this.ingredients = ingredients;
		this.baseIngredients = baseIngredients;
		this.cookingAppliances = cookingAppliances;
		this.recipeSteps = recipeSteps;
		this.assumptions = assumptions;
		this.bestFor = bestFor;
		this.bestWith = bestWith;
		this.testMode = testMode;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Set<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<String> getBaseIngredients() {
		return baseIngredients;
	}

	public void setBaseIngredients(Set<String> baseIngredients) {
		this.baseIngredients = baseIngredients;
	}

	public Set<String> getCookingAppliances() {
		return cookingAppliances;
	}

	public void setCookingAppliances(Set<String> cookingAppliances) {
		this.cookingAppliances = cookingAppliances;
	}

	public List<String> getRecipeSteps() {
		return recipeSteps;
	}

	public void setRecipeSteps(List<String> recipeSteps) {
		this.recipeSteps = recipeSteps;
	}

	public String getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(String assumptions) {
		this.assumptions = assumptions;
	}

	public String getBestFor() {
		return bestFor;
	}

	public void setBestFor(String bestFor) {
		this.bestFor = bestFor;
	}

	public String getBestWith() {
		return bestWith;
	}

	public void setBestWith(String bestWith) {
		this.bestWith = bestWith;
	}

	public boolean isTestMode() {
		return testMode;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}

	public String toString() {
		String stringObject = "";
		if (this.getDishName() != null) {

			stringObject += "Dish Name: " + this.getDishName();
		}
		if (this.getIngredients() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Ingredients: ";
			stringObject += this.getIngredients().toString();
		}
		if (this.getBaseIngredients() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Base Ingredients: ";
			stringObject += this.getBaseIngredients().toString();
		}
		if (this.getCookingAppliances() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Appliances required: ";
			stringObject += this.getCookingAppliances().toString();
		}
		if (this.getRecipeSteps() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Steps: ";
			stringObject += this.getRecipeSteps().toString();
		}
		if (this.getAssumptions() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Assumptions: ";
			stringObject += this.getAssumptions().toString();
		}
		if (this.getBestFor() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Best for: ";
			stringObject += this.getBestFor().toString();
		}
		if (this.getBestWith() != null) {
			stringObject += System.getProperty("line.separator");
			stringObject += "Best with: ";
			stringObject += this.getBestWith().toString();
		}
		return stringObject;

	}

}
