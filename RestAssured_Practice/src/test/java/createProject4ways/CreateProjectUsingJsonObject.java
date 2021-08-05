package createProject4ways;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
/**
 * Create Project Using JSON object which has jar file of JSon simple
 * @author SEEMA KUMARI
 *
 */
public class CreateProjectUsingJsonObject {
	
	@Test
	public void createProject() {
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Sapna");
		jObj.put("projectName", "NASA-15");
		jObj.put("status", "completed");
		jObj.put("teamSize", 500);
		
		given()
		    .contentType(ContentType.JSON)
		    .body(jObj)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .log().all();
	}
}
