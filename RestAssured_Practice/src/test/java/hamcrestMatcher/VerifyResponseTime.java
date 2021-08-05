package hamcrestMatcher;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import genericUtilities.IEndPoints;

public class VerifyResponseTime {
	/**
	 * Verify the response time using hamcrest matcher 
	 */
	@Test
	public void responseTime() {
		
		given()
		    .baseUri("https://api.github.com")
		    .pathParam("username", "sambhav2426")
		.when()
		    .get(IEndPoints.EP_getUserRepo)
		.then()
		    .assertThat().time(lessThan(3000L),TimeUnit.MILLISECONDS) //static Matchers so directly can use
			//.assertThat().time(Matchers.greaterThan(300L))          //Matchers is not static
		    .log().all();
		
	}
}
