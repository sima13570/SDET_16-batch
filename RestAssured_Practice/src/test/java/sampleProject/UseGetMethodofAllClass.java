package sampleProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class UseGetMethodofAllClass {
	
	@Test
	public void getAllClass() {
		 Response resp1 = RestAssured.get();
		 Response resp2 = RestAssured.get("http://localhost:8084/projects");//uri
		 Response resp3 = RestAssured.get("http://localhost:8084/projects");//url
		 
		 RequestSpecification reqSpec = RestAssured.given();
		 Response resp4 = reqSpec.get("http://localhost:8084/projects");
		 
		 RequestSender reqSend = RestAssured.when();
		 Response resp5 = reqSend.get("http://localhost:8084/projects");
		 
		 
		 System.err.println(resp1.asString());
		 System.out.println(resp2.asString());
		 System.err.println(resp3.asString());
		 System.out.println(resp4.asString());
	     System.err.println(resp5.asString());
		 
	}
}
