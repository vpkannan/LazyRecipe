/**
 * 
 */

var button = document.getElementById("getRecipeSubmit"), value = button.form.dishName.value;
button.onclick = function() {
	getRecipeByName(value);
}

function getRecipeByName(dishName) {
	$.ajax({
		url : "http://ec2-52-39-75-111.us-west-2.compute.amazonaws.com:8080/lazyrecipe/rest/recipe/get",
		type : "get",
		data : {
			dishname : "Omlet"
		}
	}).then(function(data) {
		$('.dish-name').append(data.dishName);
		$('.dish-bestfor').append(data.bestFor);
	});
}