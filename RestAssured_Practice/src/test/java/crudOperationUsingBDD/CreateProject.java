package crudOperationUsingBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject() {
		
		JSONObject jsObj=new JSONObject();
		jsObj.put("createdBy", "Dilip");
		jsObj.put("projectName", "Amazon_ebook");
		jsObj.put("status", "started");
		jsObj.put("teamSize", 50);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsObj);
		
		Response resp = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse valResp = resp.then();
		valResp.assertThat().statusCode(201);
		valResp.log().all();
		
	}
}
