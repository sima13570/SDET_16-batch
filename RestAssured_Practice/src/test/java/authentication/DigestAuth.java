package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestAuth {
	
	@Test
	public void authTest() {
		
		//restassured provide the credential before server is asking for it    
		given()
		     .auth().digest("rmgyantra", "rmgy@9999")
		.when()
		     .get("http://localhost:8084/projects")
		.then()
		      .log().all();
	}
}
//not more secure because not asking for credential and forcefully proceed to next procedure(whether ask or not)