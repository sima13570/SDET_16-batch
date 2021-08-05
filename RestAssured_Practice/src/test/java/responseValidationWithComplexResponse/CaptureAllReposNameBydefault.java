package responseValidationWithComplexResponse;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class CaptureAllReposNameBydefault {
	/**
	 * Capture list of Projects present there (approx 300 repos)
	 * by default -30 repos show as per mention in API documents
	 */
	@Test
	public void captureRepos() {
		
		Response resp = given()
		                    .pathParam("gitUser", "qspidersseleniumoar")
		                    .queryParam("sort", "")  //bydefault full_name sort if not given
		                    .queryParam("direction", "desc")//descending order otherwise bydefault ascend
		                .when()
		                    .get("https://api.github.com/users/{gitUser}/repos");
		resp.then().log().all();
		
		List<String> projectList = resp.jsonPath().get("name");//capture repos name 
		System.out.println(projectList.size());//bydefault 30 repos show
		
		for (String project : projectList) {
			System.out.println(project);
		}
		
		
	}

}
