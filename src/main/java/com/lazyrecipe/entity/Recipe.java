package com.lazyrecipe.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipe")
public class Recipe {
	private String dishName;
	private List<String> ingredients;

	public Recipe() {
	}

	public Recipe(String dishName, List<String> ingredients) {
		this.dishName = dishName;
		this.ingredients = ingredients;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String toString() {
		String stringObject = "";
		stringObject += "Dish Name: " + this.getDishName();
		stringObject += System.getProperty("line.separator");
		stringObject += this.getIngredients().toString();
		return stringObject;

	}

}
