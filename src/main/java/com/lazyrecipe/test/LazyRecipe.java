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

package com.lazyrecipe.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.lazyrecipe.entity.Recipe;

public class LazyRecipe {

	static void writeRecipe(MongoOperations mongoOperation) {

		List<String> omletIngredients = new ArrayList<String>();
		omletIngredients.add("Flour");
		omletIngredients.add("Sugar");
		omletIngredients.add("Egg");
		Recipe breakfastRecipe = new Recipe("Pancake", omletIngredients);

		mongoOperation.save(breakfastRecipe);

		System.out.println(breakfastRecipe);
	}

	static void retrieveRecipe(MongoOperations mongoOperation) {

		Query searchUserQuery = new Query(Criteria.where("dishName").is("Pancake"));
		Recipe savedRecipe = mongoOperation.findOne(searchUserQuery, Recipe.class);
		System.out.println("Recipe: ");
		System.out.println(savedRecipe);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("springBeans.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		// test function
		retrieveRecipe(mongoOperation);

	}
}
