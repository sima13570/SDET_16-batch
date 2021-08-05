package sampleProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutMethod {
	
	@Test
	public void projectUpdate() {
		
		JSONObject jsObj=new JSONObject();
		jsObj.put("createdBy", "Deepa");
		jsObj.put("projectName", "SBO_123");
		jsObj.put("status", "incomplete");
		jsObj.put("teamSize", 20);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsObj);
		
		Response resp = reqSpec.put("http://localhost:8084/projects/TY_PROJ_2803");
		ValidatableResponse valResp = resp.then();
		valResp.log().all();
		valResp.assertThat().contentType(ContentType.JSON);
		valResp.assertThat().statusCode(200);
		
	}
}
