package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllUsersRepo {
/**
 * Parameterization: In order to execute same API with different type of data
 * @param param1
 * @param param2
 */
	@Test(dataProvider = "provideUserData")                //take data from data provider
	public void getRepo(String param1, String param2) {

		System.out.println("execute===" + param1);
		
		 given() 
		     .pathParam("gitUser", param1) 
		     .queryParam("sort", param2)
		 .when()
	         .get("https://api.github.com/users/{gitUser}/repos")
	     .then() 
	         .log().all();
		
	}

	@DataProvider
	public Object[][] provideUserData() {             //provide data 

		Object[][] objArr = new Object[3][2];         //data in excel sheet we use

		objArr[0][0] = "sima13570";
		objArr[0][1] = "created";

		objArr[1][0] = "MitaRani";
		objArr[1][1] = "created";

		objArr[2][0] = "nvnsoni";
		objArr[2][1] = "created";

		return objArr;

	}
}
/**
 * advantage: Every iteration considered as one test case , result is accurate in data provider show result for each user 
 *          : if any test case failed then it will not stop the iteration as like for loop
 *  
**/