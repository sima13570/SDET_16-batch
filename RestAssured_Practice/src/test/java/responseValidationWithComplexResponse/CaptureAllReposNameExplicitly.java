package responseValidationWithComplexResponse;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CaptureAllReposNameExplicitly {
	/**
	 * Capture list of Projects present there (approx 300 repos)
	 * by default -30 repos show as per mention in API documents
	 */
	@Test
	public void captureRepos() {
		
	 int count=0;
     for (int i = 1; i < 5; i++) {
		  
		Response resp = given()
		                    .pathParam("gitUser", "qspidersseleniumoar")
		                    .queryParam("sort", "full_name")
		                    .queryParam("per_page", 100)
		                    .queryParam("direction", "asc")
		                    .queryParam("page", i )
		                .when()
		                    .get("https://api.github.com/users/{gitUser}/repos");
		//resp.then().log().all();
		
		List<String> ReposList = resp.jsonPath().get("name");//capture repos name 
		//System.err.println("Repos List: "+ReposList.size());//bydefault 30 repos show
		
		for (String project : ReposList) {
			System.out.println(project);
		}
		count=count+ReposList.size();
		
     }
     System.err.println("Total Repos List: "+count);
		

	}

}
