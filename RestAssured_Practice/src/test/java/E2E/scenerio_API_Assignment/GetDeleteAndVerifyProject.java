package E2E.scenerio_API_Assignment;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.DatabaseUtilities;
import io.restassured.response.Response;

public class GetDeleteAndVerifyProject {

	/**
	 * Get the project, delete and verify in the database
	 * @throws Throwable 
	 */
	@Test
	public void verifyTest() throws Throwable {
		
		String actualProjectId=null;
		String url="http://localhost:8084/projects";
		//step :1 get the project
		Response resp = when()
		                   .get(url);
	
		resp.then().log().all();
		
		//step :2 capture the projects
		List<String> projectIdList=resp.jsonPath().get("projectId");
		int total = projectIdList.size()-1;
		
		for (String projectId : projectIdList) {
	
			if (projectId.equals(projectIdList.get(total))) {
				actualProjectId=projectId;
				
				//step:3 delete one project
				when()
				    .delete(url+"/"+projectId);
				break;
			}
		}
		
		//step :4 verify the project in the database 
		DatabaseUtilities db=new DatabaseUtilities();
		db.connectDB();
		String query="select * from project;";
		String dbValue = db.executeQueryAndGetData(query, 1, actualProjectId);
		db.closeDB();
		
		//step:5 validate the project whether available or not
		Assert.assertNotSame(actualProjectId, dbValue);
		System.out.println("It's means data is not available or permanently deleted from DB table");
	}
}
