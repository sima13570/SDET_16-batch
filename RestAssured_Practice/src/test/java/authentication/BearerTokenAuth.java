package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BearerTokenAuth {
	
	@Test
	public void AuthTest () {
		//bearer token authentication looks like oauth2 
		
		given()
			 .pathParam("username", "sima13570") //
		     .auth().oauth2("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")
		.when()
		     .get("https://api.github.com/users/{username}/repos")
		.then()
		     .log().all();
	}

}
//Oauth2 where we give client Id and client secret and excecute then capture it soit is purely oauth2 which is dynamic 
//but bearer fixed token we have to give 