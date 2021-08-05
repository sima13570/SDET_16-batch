package sampleProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostMethod {

	@Test
	public void postProject() {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "bhanu");
		jsonObj.put("projectName", "SBI_manglore");
		jsonObj.put("status", "done");
		jsonObj.put("teamSize", 20);

		RequestSpecification reqSpec = RestAssured.given(); //content type and body given i.e. precondition
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonObj);
		
		Response resp = reqSpec.post("http://localhost:8084/addProject"); //for perform action 
		System.out.println(resp.asString());

		ValidatableResponse valResp = resp.then();                      
		valResp.assertThat().contentType(ContentType.JSON); //for validation
		valResp.assertThat().statusCode(201);
		valResp.log().all();

	}
}
