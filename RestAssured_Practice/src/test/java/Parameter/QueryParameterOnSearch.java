package Parameter;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class QueryParameterOnSearch {
	/**
	 * execute api with query parameter
	 */
	@Test
	public void ParamTest() {
		/**
		 * https://api.github.com/search/repositories?q=JavaProgram_SDET-16
		 */
		
		Response resp = given()
		     .queryParam("q", "JavaProgram_SDET-16")
		.when()
		     .get("https://api.github.com/search/repositories");    //search repositories
		//resp.then().log().all();
		
		
		List<String> usn=new ArrayList<String>();
		usn.add("sima13570");
		usn.add("nvnsoni");
		usn.add("Aanchal2325ch");
		
		for (Object user : usn) {
			
		given()
		    .queryParam("q", user)
		.when()
		    .get("https://api.github.com/search/users")  //search users
		.then()
		    .log().all();
		
		}//for filtering purpose of sepecific querys
		
	}
	

}
