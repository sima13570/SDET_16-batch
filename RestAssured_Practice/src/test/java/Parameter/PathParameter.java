package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class PathParameter {
/**
 * execute api with path parameter
 */
		@Test
		public void paramTest() {
			
			//execute same request with different data //setting the path of the UrL or endpoint
			
			List<String> usn=new ArrayList<String>();
			usn.add("nvnsoni");
			usn.add("sima13570");
			
			for (String user : usn) {
				given()
			     .pathParam("username", user)//no hardcoded needed here
			.when()
			     .get("https://api.github.com/users/{username}/repos") //get repos details
			.then()
			     .log().all();
				
				/**
				 * Note: Data Provider is best choice to get user's repos
				 */
			}
			
		}
		
}
