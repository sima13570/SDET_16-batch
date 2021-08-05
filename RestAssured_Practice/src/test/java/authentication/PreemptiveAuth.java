package authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PreemptiveAuth {
	
	@Test
	public void AuthTest() {
		
		//before sending the request to server should ask for credential, then restassured provide the data //Example Visual SVN Server,Gmail 

		given()
		     .contentType(ContentType.JSON)
		     .auth().preemptive().basic("rmgyantra", "rmgy@9999") 
		.when()
		     .get("http://localhost:8084/login")
		.then()
		     .log().all();
	}
}
//more secure because server asking explicitly for the credential then only proceed to next