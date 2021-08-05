package sampleProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class UseDeleteMethodofAllClass {

	@Test
	public void getProject() {
		
		
		int start=3604;
		int end=3620;
		
		for (int i =start ; i <= end; i++) {

			Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_" + i);
			System.err.println(i + "=" + resp.statusCode());
			System.out.println(resp.statusLine());
		}
		
		RequestSpecification reqSpec = RestAssured.given();
		Response resp1 = reqSpec.delete();//html resp
		Response resp2 = reqSpec.delete("http://localhost:8084/projects/TY_PROJ_1605");
		
		RequestSender reqSend = RestAssured.when();
		Response resp3 = reqSend.delete("http://localhost:8084/projects/TY_PROJ_1803");
		
		System.err.println("============================");
		System.out.println(resp1.getContentType());//text/html resp 
		System.err.println(resp1.getStatusCode());//forbidden 403
		System.out.println(resp2.contentType());
		System.err.println(resp2.getStatusCode());
		System.out.println(resp3.getStatusCode());
		
	}
}
