package com.lazyrecipe.test.functional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lazyrecipe.entity.Recipe;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class FunctionalTestCases extends AbstractTestNGSpringContextTests {

	Recipe recipe;

	String timeStamp;
	ApplicationContext ctx;
	MongoOperations mongoOperation;

	public FunctionalTestCases() {
		ctx = new GenericXmlApplicationContext("springBeans.xml");
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		this.timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// set dish name
		String dishName = "Plain Dosa" + "@" + timeStamp;

		// set ingredients
		Set<String> ingredients = new HashSet<String>();
		ingredients.add("Batter");

		// set base ingredients
		Set<String> baseIngredients = new HashSet<String>();
		baseIngredients.add("Oil");

		// set cooking appliances
		Set<String> cookingAppliances = new HashSet<String>();
		cookingAppliances.add("Cooking range");
		cookingAppliances.add("Flat pan");
		cookingAppliances.add("Ladle");

		// set recipe steps
		List<String> recipeSteps = new ArrayList<String>();
		recipeSteps.add("Pour batter on the flat pan");
		recipeSteps.add("Wait for 2 minutes");
		recipeSteps.add("Turn it around with ladle and wait for a minute");
		recipeSteps.add("Take off the pan using ladle and serve.");

		// set assumptions
		String assumptions = "You have appropriate sidedish. Example - chutney";

		// set best for
		String bestFor = "Breakfast, Dinner";

		// set best with
		String bestWith = "Chutney and/or Sambhar";

		this.recipe = new Recipe(dishName, ingredients, baseIngredients, cookingAppliances, recipeSteps, assumptions,
				bestFor, bestWith);

	}

	@Test()
	void testCreateAndReadForNewRecipe() {

		mongoOperation.save(this.recipe);

		Query searchUserQuery = new Query(Criteria.where("dishName").is("Plain Dosa" + "@" + this.timeStamp));
		Recipe savedRecipe = mongoOperation.findOne(searchUserQuery, Recipe.class);

		Assert.assertNotNull(savedRecipe);
		Assert.assertEquals(savedRecipe.getBestFor(), "Breakfast, Dinner");

	}

	@Test()
	void testReadForExistingRecipe() {

		Query searchUserQuery = new Query(Criteria.where("dishName").is("Plain Dosa" + "@" + this.timeStamp));
		Recipe savedRecipe = mongoOperation.findOne(searchUserQuery, Recipe.class);

		Assert.assertNotNull(savedRecipe);
		Assert.assertEquals(savedRecipe.getBestFor(), "Breakfast, Dinner");

	}

}
