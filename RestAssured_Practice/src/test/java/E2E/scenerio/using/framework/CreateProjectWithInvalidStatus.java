package E2E.scenerio.using.framework;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClassAPI;
import genericUtilities.IEndPoints;
import io.restassured.http.ContentType;

public class CreateProjectWithInvalidStatus extends BaseClassAPI {
	
	@Test
	public void invalidStatus() throws Throwable {
		/**
		 * Invalid status(OOOAAAA) and expected 500 status code so it is bug
		 */
		
		String status = "OOOOAAAABBB";
		
		JSONObject jsObj=new JSONObject();
		jsObj.put("createdBy", "Yuvraj");
		jsObj.put("projectName", "Delta"); 
		jsObj.put("status", status);
		jsObj.put("teamSize", 50);
		
		given()
		     .contentType(ContentType.JSON)
		     .body(jsObj)
		.when()
		     .post(IEndPoints.EP_addProject)
		.then()
		     .log().all()
		     .and()
		     .assertThat().statusCode(500);
		
		String query="select * from project;";
		String returnDbValue=db.executeQueryAndGetData(query, 5, status);
		
		Assert.assertEquals(returnDbValue, null);
	
	}

}
