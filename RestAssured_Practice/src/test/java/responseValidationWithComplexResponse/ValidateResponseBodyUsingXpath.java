package responseValidationWithComplexResponse;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateResponseBodyUsingXpath {
	
	@Test
	public void getSingleProject() {
		
		/**
		 * Validate the first projectName(sample) is available in the Static response
		 */
		
		String expectedProjectName="sample";
		Response resp = when()
		                    .get("http://localhost:8084/projects");
		
		//resp.then().log().all();
		
		String actualProjectName=resp.jsonPath().getString("[0].projectName");
		System.out.println("Project Name: "+actualProjectName);
		Assert.assertEquals(actualProjectName, expectedProjectName);	
	}
	
	 @Test
	 public void getAllProject() {
		 
		 /**
		   * Validate any project name is available in the Dynamic response
		   */
		  
		String expectedProjectName="Kingfisher";	
		boolean flag=false;
		
		Response resp =when()
			         .get("http://localhost:8084/projects");
		
		//resp.then().log().all();
			 
		List<String> projectList=resp.jsonPath().get("projectName");
		//System.out.println(projectList);
		System.err.println("Project List: "+projectList.size());
		
		for (String actualProject : projectList) {
			
			if (expectedProjectName.equals(actualProject)) {
				System.out.println("ProjectName---> "+actualProject+" Passed");
				flag=true;
				break;
			}
	    } 
		
		Assert.assertEquals(flag, true);
	}

}
