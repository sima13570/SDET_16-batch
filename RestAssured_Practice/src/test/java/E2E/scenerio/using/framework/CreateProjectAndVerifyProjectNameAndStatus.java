package E2E.scenerio.using.framework;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClassAPI;
import genericUtilities.IEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

public class CreateProjectAndVerifyProjectNameAndStatus extends BaseClassAPI{
	/**
	 * Verify the Project Name and status in response and database layer
	 * @throws Throwable
	 */
	@Test
	public void verifyProject() throws Throwable {
		
		String projectName="Iphone";
		String status="completed";
		
		Project pojo=new Project("Sapna", projectName, status, 42);
		
		//step 1: create the project
		Response resp = given()
		                    .contentType(ContentType.JSON)
		                    .body(pojo)
		                 .when()
		                    .post(IEndPoints.EP_addProject);
		resp.then().log().all();
		
		//step 2: capture the data from the response
		String actProjectResp = resp.jsonPath().get("projectName");
		String actStatusResp = resp.jsonPath().get("status");
		
		//step 3  : verify the data in database and get the value 
		String query="select * from project;";
		
		String actualDbProjectName = db.executeQueryAndGetData(query, 4, projectName);
		String actualDbStatus=db.executeQueryAndGetData(query, 5, status);
		
		//step 4 : verify the response and dB value
		Assert.assertEquals(actProjectResp, actualDbProjectName);
		Assert.assertEquals(actStatusResp, actualDbStatus);	
	}

}
