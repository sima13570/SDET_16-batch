package crudOperationUsingBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProject {
	
	@Test
	public void deleteProject() {
		
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1805");
		
		ValidatableResponse valResp = resp.then();
		valResp.assertThat().statusCode(204);
		valResp.contentType("application/json");
	}
}
