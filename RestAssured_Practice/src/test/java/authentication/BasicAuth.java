package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	@Test
	public void basicAuthTest() {
		
		/*
		 * when() 
		 *     .get("http://localhost:8084/login") //directly can't use
		 * .then()
		 *     .log().all();  //401-Unauthorized, 403-forbidden
		 */
		
		given()
		    .auth().basic("rmgyantra", "rmgy@9999")
		.when()
		    .get("http://localhost:8084/login")
		 .then()
		     .log().all();  //202 authorized
		
	}
}
