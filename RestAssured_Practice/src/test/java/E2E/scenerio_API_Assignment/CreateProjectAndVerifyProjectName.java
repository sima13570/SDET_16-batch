package E2E.scenerio_API_Assignment;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.DatabaseUtilities;
import io.restassured.response.Response;
import pojoClass.Project;

public class CreateProjectAndVerifyProjectName {
	/**
	 * Create Project and Verify Project name (in database and response)
	 * @throws Throwable 
	 */
	@Test
	public void createProjectAndVerify () throws Throwable {
		
		String expectProjectName="SBI_Banglore";
		String actualProject=null;
		
		Project pojo=new Project("pooja", expectProjectName , "done", 15);
		
        //Step:1 create Project via API 
		/**given()
		     .contentType(ContentType.JSON)
		     .body(pojo)
		.when()
		     .post("http://localhost:8084/addProject");
		**/
		//step: 2 get the API response
		Response resp = when()
		    .get("http://localhost:8084/projects");
		
		List<String> projectList = resp.jsonPath().get("projectName");
		
		//step:3 verify the data in response 
		for (String actualData : projectList) {
			
			actualProject=actualData;
			if (actualData.equalsIgnoreCase(expectProjectName)) {
				
				System.out.println("Get the Project Name '"+expectProjectName+"' via API");
				break;
			}
		}
		
		//step:4 verify the data from database
		DatabaseUtilities db = new DatabaseUtilities();
		db.connectDB();
		String query="select * from project;";
		String dbValue = db.executeQueryAndGetData(query, 4, expectProjectName);
		db.closeDB();
		
		//step:5 verify the data from database and response 
		Assert.assertEquals(actualProject,expectProjectName);
		Assert.assertEquals(dbValue, expectProjectName);
			     
		
	}
}
