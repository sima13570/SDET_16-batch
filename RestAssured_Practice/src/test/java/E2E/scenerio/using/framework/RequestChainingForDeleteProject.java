package E2E.scenerio.using.framework;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClassAPI;
import genericUtilities.IEndPoints;
import io.restassured.response.Response;

public class RequestChainingForDeleteProject extends BaseClassAPI {

	/**
	 * Get the project, delete and verify in the database
	 * @throws Throwable 
	 */
	@Test
	public void verifyTest() throws Throwable {
		
		//step :1 get the project
		Response resp = when()
		                   .get(IEndPoints.EP_getProject);
	
		//resp.then().log().all();
		
		//step :2 capture the projects
		List<String> projectIdList=resp.jsonPath().get("projectId");
		int total = projectIdList.size()-1;
		
		String actualProjectId=javaUtil.verifyDataInList(projectIdList, total);
				
		//step:3 delete one project
		when()
		    .delete(IEndPoints.EP_getProject+"/"+actualProjectId)
		.then()
		     .assertThat().statusCode(204);		
		
		//step :4 verify the project in the database 
		String query="select * from project;";
		String dbValue = db.executeQueryAndGetData(query, 1, actualProjectId);
		
		//step:5 validate the project whether available or not
		Assert.assertNotSame(actualProjectId, dbValue);
		System.out.println("It's means data is not available or permanently deleted from DB table");
	}
}
