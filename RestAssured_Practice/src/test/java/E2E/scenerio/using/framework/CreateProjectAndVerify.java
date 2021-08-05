package E2E.scenerio.using.framework;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClassAPI;
import genericUtilities.IEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.Project;

public class CreateProjectAndVerify extends BaseClassAPI {
	
	@Test
	public void verifyProject() throws Throwable {
		
		String projectName="Flashback-Pro"+javaUtil.random();
		Project pojo=new Project("Adarsh", projectName, "on-going", 52);
		
		//step 1: create the project
		given()
		     .contentType(ContentType.JSON) 
		     .body(pojo)
		.when()
		     .post(IEndPoints.EP_addProject);
		
		//step 2: get the all the project name from the response and store it in collection  
		Response resp=when()
		                .get(IEndPoints.EP_getProject);
		
		List<String> list = resp.jsonPath().get("projectName");
		
		//step 3: verify the data in response and get the value
		String actualResponse = javaUtil.verifyDataInList(list, projectName);
		
		//step 4 : verify the data in database and get the value 
		String query="select * from project;";
		String actualDBValue = db.executeQueryAndGetData(query, 4, projectName);
		
		//step 5 : verify the response and dB value
		Assert.assertEquals(actualResponse, actualDBValue);	
		
	}

}
