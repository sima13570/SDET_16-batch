package crudOperationUsingBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProject {
	
	@Test
	public void getAllProject() {
		
		Response resp = RestAssured.get("http://localhost:8084/projects");// get project
		ValidatableResponse valResp = resp.then();                        
		valResp.log().all();     //show all project
	}
}
