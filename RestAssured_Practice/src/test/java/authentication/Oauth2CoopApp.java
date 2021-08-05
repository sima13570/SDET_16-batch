package authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Oauth2CoopApp {

	@Test
	public void OauthTest() {

		Response resp = given()                                                 // pre-condition : give client id and secret
				           .formParam("client_id", "SDET-16")
				           .formParam("client_secret", "e8089fdeb03eabec60e388ec43590583")
				           .formParam("grant_type", "client_credentials")
				           .formParam("redirect_uri", "http://testing.com")
				        .when()
				           .post("http://coop.apps.symfonycasts.com/token");     // action : actual http request we pass client id and secret

		              // resp.then().log().all();                                //then get the token so access it

		String token = resp.jsonPath().get("access_token");
		//System.err.println(token);

		        resp = given()          
		                   .contentType(ContentType.JSON)
		                   .auth().oauth2(token)
		               .when()
		                   .get("http://coop.apps.symfonycasts.com/api/me");          //Retrieves user that's tied to the access token
		
		            // resp.then().log().all();                                       //user details
		
		Object userId = resp.jsonPath().get("id");
		//System.err.println(userId);
		
		//1			
	    				given()
						    .contentType(ContentType.JSON)
						    .auth().oauth2(token)
						.when()
						    .post("http://coop.apps.symfonycasts.com/api/"+userId+"/barn-unlock")            //Unlock the Barn
						.then()
						    .log().all();
					 
		
		//2			
						given()
						    .auth().oauth2(token)
						.when()
						    .post("http://coop.apps.symfonycasts.com/api/"+userId+"/eggs-collect")       //Collect Eggs from Your Chickens
						.then()
						    .log().all();
					
		
		//3		
						given()
						    .auth().oauth2(token)
						.when()
						     .post("http://coop.apps.symfonycasts.com/api/"+userId+"/eggs-count")       //Get the Number of Eggs Collected Today
						.then()
						     .log().all();
				
		
	}
}
