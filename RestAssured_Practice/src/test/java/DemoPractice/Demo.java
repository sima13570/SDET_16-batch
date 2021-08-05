package DemoPractice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Demo {

	@Test
	public void getUsername() {
		
		given()
		    .auth().basic("admin", "pwd")
		    .queryParam("id", "user123")
		    .contentType(ContentType.JSON)
	    .when()
	        .get("http://getmail.com/mail/id")
	    .then()
	        .log().all()
	        .and()
	        .assertThat().statusCode(200);
	        
		
		
	}

}
