package Parameter;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class QueryParameterOnSort {
	/**
	 * execute api with query parameter //exceute same api with different type of data
	 */
	@Test
	public void ParamTest() {
		/**
		 * https://api.github.com/users/{username}/repos?sort=full_name
		 * user repos with sorting 
		 */
		
		Response resp = given()	
		                    .pathParam("username", "sima13570")
		                .when()                                                                     //hardcoded in Url
		                    .get("https://api.github.com/users/{username}/repos?sort=full_name");  // sorted in ascend order
		               //resp.then().log().all();
		
		given()
		     .pathParam("username", "sima13570")
		     .queryParam("sort", "created")   //attached at the end automatically in Url
		.when()                                                     //no hard coded in url
		     .get("https://api.github.com/users/{username}/repos") // sorted with recent created date
		.then()
		     .log().all();
		
			
		
	}
		
}
//for filtering purpose of specific queries