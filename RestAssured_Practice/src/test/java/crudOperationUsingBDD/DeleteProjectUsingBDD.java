package crudOperationUsingBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectUsingBDD {

	@Test
	public void deleteProject() {
		
		when()            //Action : actual http  request
		   .delete("http://localhost:8084/projects/TY_PROJ_1602")
	    .then()          //post condition: validation
	       .assertThat().contentType(ContentType.JSON)
	       .and()
	       .assertThat().statusCode(204)
	       .log().all();
	}
}
/*  No need to remember the class name
 *  Code complexity reduce
 *  more readable
 */