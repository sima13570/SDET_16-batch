package crudOperationUsingBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectUsingBDD {
	
	@Test
	public void updateProject() {
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Wasu");
		jObj.put("projectName", "Whirpool");
		jObj.put("status", "begin");
		jObj.put("teamSize", 80);
		
		given()                                //precondition 
		    .contentType(ContentType.JSON)
		    .body(jObj)
		.when()                               //action : actual http request
		    .put("http://localhost:8084/projects/TY_PROJ_1604")
		.then()                              //post condition 
		    .log().all();
	}
}
/*  No need to remember the class name
 *  Code complexity reduce
 *  more readable
 */
