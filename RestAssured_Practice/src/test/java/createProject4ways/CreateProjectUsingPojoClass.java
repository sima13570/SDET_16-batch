package createProject4ways;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.Project;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojoClass {
/**
 * Create Project using Pojo Class 
 */
	@Test
	public void createProject() {
		//create an object of pojo class
		Project pojoObj=new Project("Stephen", "Howrah", "on-going", 800);
		
		given()
		    .body(pojoObj)
		    .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .log().all();
	}
}
