package createProject4ways;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClass.Project;
/**
 * Create Project using Pojo calss and random Number
 * @author SEEMA KUMARI
 *
 */
public class CreateProjectUsingPojoClassWithRandomNo {

	@Test
	public void createProject() {
		
		Random random = new Random();//use for random value
		int ranVal = random.nextInt(200);//bound the value or limit 200
		
		Project pojoObj = new Project("Raja","Google_"+ranVal, "Done", 452);
		
		given()
		    .body(pojoObj)
		    .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .log().all();
	}
}
