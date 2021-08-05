package genericUtilities;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassAPI_usingSpecBuilder {
	/**
	 * used to set some common preconditions 
	 */
	
	public RequestSpecification reqSpec;
	public ResponseSpecification respSpec;
	@Test
	public void reqSpec() {
		
		RequestSpecBuilder reqSpecBuild = new RequestSpecBuilder();
		reqSpecBuild.setBaseUri("http://localhost");
		reqSpecBuild.setPort(8084);
		reqSpecBuild.setContentType(ContentType.JSON);
		
		reqSpec = reqSpecBuild.build();//covert specBuilder to reqSpecification bcuz it can't access by main testclass directly
		
		ResponseSpecBuilder resSpecBuild=new ResponseSpecBuilder();
		resSpecBuild.expectResponseTime(Matchers.lessThanOrEqualTo(5000L));
		resSpecBuild.expectStatusCode(200);
		resSpecBuild.expectContentType(ContentType.JSON);
		
		respSpec = resSpecBuild.build();//covert specBuilder to reqSpecification bcuz it can't access by main testclass directly
		
		
	}
	
}
