package createProject4ways;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
	/**
	 * Create Project with HashMap class
	 */
	@Test
	public void createProject() {
		
		HashMap map = new HashMap();
		map.put("createdBy", "Deepa");
		map.put("projectName", "Philips");
		map.put("status", "going-on");
		map.put("teamSize", 60);
		
		given()
		    .contentType(ContentType.JSON)
		    .body(map)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .log().all();
	}
}
