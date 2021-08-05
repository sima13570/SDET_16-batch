package SpecificationBuilder;

import org.testng.annotations.Test;

import genericUtilities.BaseClassAPI_usingSpecBuilder;
import genericUtilities.IEndPoints;

import static io.restassured.RestAssured.*;

public class SetPreconditionUsingRequestSpecification extends BaseClassAPI_usingSpecBuilder {

	@Test
	public void validateRequest() {
		
		given()
		     .spec(reqSpec) //call build() where common precondition given 
		.when()
		     .get(IEndPoints.EP_getProject)
		.then()
		     .log().all();
		     
	}
}
//reduce  to small reqest