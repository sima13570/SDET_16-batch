package hamcrestMatcher;

import static io.restassured.RestAssured.when;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtilities.BaseClassAPI;
import genericUtilities.IEndPoints;

public class VerifyResponseBody extends BaseClassAPI {
	
	@Test
	public void responseBody() {
		
		when()
		    .get(IEndPoints.EP_getProject)
		.then()
			.statusCode(200)
			.and()
		    .assertThat().body("projectName[0]" ,Matchers.equalTo( "sample"))
		    .and()
		    .assertThat().time(Matchers.lessThan(5000L))
		    .log().all();

	
	}

}
