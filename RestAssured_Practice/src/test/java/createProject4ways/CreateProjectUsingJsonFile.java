package createProject4ways;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonFile {
	
	@Test
	public void createProject() {
		File file = new File("./src/test/resources/data1.json");
		
		given()
		    .body(file)
		    .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .log().all();
		
		
	}
}
