/**
 * 
 */

$(document)
		.ready(
				function() {
					$
							.ajax(
									{
										url : "http://ec2-52-39-75-111.us-west-2.compute.amazonaws.com:8080/lazyrecipe/rest/recipe/get?dishname=Plain%20Dosa"
									}).then(function(data) {
								$('.dish-name').append(data.dishName);
								$('.dish-bestfor').append(data.bestFor);
							});
				});