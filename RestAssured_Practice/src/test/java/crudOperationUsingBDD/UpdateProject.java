package crudOperationUsingBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Daya");
		jObj.put("projectName", "Laptop_Dell");
		jObj.put("status", "Finish");
		jObj.put("teamSize", 120);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jObj);
		
	    Response resp = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1603");
		ValidatableResponse valResp = resp.then();
		valResp.log().all();
		valResp.assertThat().statusCode(200);
		
		
	
	}
}

