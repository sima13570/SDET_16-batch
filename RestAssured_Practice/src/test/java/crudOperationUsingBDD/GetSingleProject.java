package crudOperationUsingBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetSingleProject {
	
	@Test
	public void getSingleProject() {
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1802");
		ValidatableResponse resVal = resp.then();
		resVal.log().all();
		
	}
}
