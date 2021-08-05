package sampleProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UseValidatableResponse {  

	@Test
	public void ValidResp() {

		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		/*
		 * String actualResult = resp.getContentType(); //validate both actual and
		 * String expectedResult= "application/json"; Assert.assertEquals(actualResult ,
		 * expectedResult);
		 */
		 
	 
		  ValidatableResponse valiResp = resp.then();          //actual result get from response only validate expectedResult
		  valiResp.assertThat().contentType(ContentType.JSON);
		  valiResp.assertThat().statusCode(200);
		  valiResp.assertThat().statusLine("HTTP/1.1 200 ");

	}
}
