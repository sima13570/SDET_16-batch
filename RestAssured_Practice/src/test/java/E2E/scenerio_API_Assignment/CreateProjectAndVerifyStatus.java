package E2E.scenerio_API_Assignment;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.DatabaseUtilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

public class CreateProjectAndVerifyStatus {

	/**
	 * Create Project and Verify the status
	 * @throws Throwable 
	 */
	@Test
	public void createProjectAndVerifyStatus() throws Throwable {
		
		Random random=new Random();
		int value = random.nextInt(200);
		String status="completed";
		String statusResponse=null;
		
		Project pojoObj=new Project("Bhanu", "HDFC_"+value, status, 80);
		
		//step 1: create Project 
		given()
		     .contentType(ContentType.JSON)
		     .body(pojoObj)
		.when()
		     .post("http://localhost:8084/addProject");
		
		//step 2: get the API response
		Response resp = when()
		                   .get("http://localhost:8084/projects");
		
		List<String> statusList = resp.jsonPath().get("status");
		
		//step 3: verify the API response
		for (String getStatus : statusList) {
			
			statusResponse=getStatus;
			if (getStatus.equalsIgnoreCase(status)) {
				
				System.out.println("status of API response "+status);
				break;
			}
		}
		
		//step 4: verify the status in the database
		DatabaseUtilities db=new DatabaseUtilities();
		db.connectDB();
		String query="select * from project;";
		String dbValue = db.executeQueryAndGetData(query, 5, status);
		db.closeDB();
		
		//step 5: validate the data(status) in API response and database
		Assert.assertEquals(status, statusResponse, dbValue);
	}

}
