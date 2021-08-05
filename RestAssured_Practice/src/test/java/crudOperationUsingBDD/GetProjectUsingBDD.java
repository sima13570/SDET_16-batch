package crudOperationUsingBDD;

import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class GetProjectUsingBDD {
	
	@Test
	public void getAllProject() {
		
		when()                               //Action: Actual http request
		   .get("http://localhost:8084/projects")
	    .then()                              //post condition : for validation
	       .assertThat().contentType("application/json")
	       .and()
	       .assertThat().statusCode(200)
	       .and()
	       .log().all();
	}
}
/*  No need to remember the class name
 *  Code complexity reduce
 *  more readable
 */
