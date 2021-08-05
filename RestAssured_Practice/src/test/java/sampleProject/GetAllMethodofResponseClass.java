package sampleProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllMethodofResponseClass {

	@Test
	public void getProject() {

		Response resp = RestAssured.get("http://localhost:8084/projects");

		// System.out.println(resp.asString()); //get response in one line

		//resp.prettyPrint();// print the response body in proper manner
		resp.then().log().all();//print complete header, body,status code, status line etc.

		System.out.println("session ID: " + resp.getSessionId());
		System.err.println("Body: "+resp.getBody().asString());    //get body

		System.out.println("Headers"+resp.getHeaders());
		System.err.println("Status code: " + resp.getStatusCode()); //get status code
		System.out.println("status line: " + resp.getStatusLine()); //get status line 
		System.err.println(resp.getCookie("Cookies" + "spt"));

		System.err.println("Content type: " + resp.getContentType()); //get content type
		System.out.println("Time: " + resp.getTime());                //get time
	

	} 
}
