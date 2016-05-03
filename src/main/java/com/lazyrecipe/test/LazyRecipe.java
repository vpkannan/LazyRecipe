package com.lazyrecipe.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lazyrecipe.entity.Recipe;

public class LazyRecipe {

	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext("springBeans.xml");

		Recipe recipe = (Recipe) context.getBean("recipe");
		System.out.println("Tonight's dinner is " + recipe.getDishName());
		
	}
}
