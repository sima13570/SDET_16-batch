package mavenParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;	

public class ReqresApp {
	//Set the uri (https://reqres.in) in system (run conf>method>arg)
	String baseURI=System.getProperty("uri");
	
	@Test
	public void paramTest() {
		
		given()
		     .baseUri(baseURI)
		     .get("/api/users?page=2")
		.then()
		      .log().all();
	}
}
