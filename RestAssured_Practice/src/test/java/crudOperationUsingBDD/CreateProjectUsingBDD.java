package crudOperationUsingBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingBDD {
	
	@Test
	public void createProject() {
		
		JSONObject jsObj=new JSONObject();
		jsObj.put("createdBy", "Deepu");
		jsObj.put("projectName", "Syska_led");
		jsObj.put("status", "done");
		jsObj.put("teamSize", 50);
		
		given()                                 //precondition : body and content type
		    .contentType(ContentType.JSON)
		    .body(jsObj)
		.when()                                  //action : actual http request 
		    .post("http://localhost:8084/addProject")
		.then()                                 //post condition
		    .assertThat().contentType(ContentType.JSON)
		    .assertThat().statusCode(201)
		    .log().all();
	}
}
/*  No need to remember the class name
 *  Code complexity reduce
 *  more readable
 */