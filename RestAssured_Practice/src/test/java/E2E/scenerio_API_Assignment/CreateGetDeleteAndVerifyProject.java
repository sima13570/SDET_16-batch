package E2E.scenerio_API_Assignment;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.DatabaseUtilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateGetDeleteAndVerifyProject {
	
	/**
	 * Create, get,delete and verify the project in the database
	 * @throws Throwable 
	 */
	@Test
	public void  verifyTest() throws Throwable {
		
		File file=new File("./src/test/resources/data2.json");
		String baseUri="http://localhost:8084/";
		
		//step:1 create project
		Response resp = given()
		                     .contentType(ContentType.JSON)
		                     .body(file)
		                .when()
		                      .post(baseUri+"addProject");
		String captureId = resp.jsonPath().get("projectId");
		
		//Step:2 get all the projects
		resp=when()
		        .get(baseUri+"projects");
		resp.then().log().all();
		
	    List<String>projectList=resp.jsonPath().get("projectId");
		
	    //step:3 delete the project 
	    for (String projectId : projectList) { 
			
	    	if (projectId.equals(captureId)) {
				
				when()
			    .delete(baseUri+"projects/"+projectId);
			}
		}
		
		//step:3 verify the project in the database whether deleted or not
		DatabaseUtilities db=new DatabaseUtilities();
		db.connectDB();
		String query="select * from project;";
		String dbValue = db.executeQueryAndGetData(query, 1, captureId);
		db.closeDB();
		
		//step:4 validate the project 
		Assert.assertNotEquals(captureId, dbValue);
		System.out.println("It's means created data is deleted from database and not available");
		
	}
}
