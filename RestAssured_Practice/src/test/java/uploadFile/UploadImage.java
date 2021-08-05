package uploadFile;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UploadImage {
	
	@Test
	public void uploadImage() {
		
		//Step 1 : create a new Pet in store
		File petDetails=new File("./src/test/resources/petstore.json");
		
		Response resp = given()
					        .baseUri("https://petstore.swagger.io/v2")
					        .contentType(ContentType.JSON)
					        .body(petDetails)
					    .when()
					        .post("/pet");
				    resp.then()
				            .log().all();
				   
		int petId = resp.jsonPath().get("id");
		System.out.println(petId);
		
		//Step 2 : upload pet image
		File image=new File("./src/test/resources/dogPhoto.jpg");
		
		given()
		     .baseUri("https://petstore.swagger.io/v2")
		     .pathParam("petId", petId)
		     .multiPart(image)
		.when()
		     .post("/pet/{petId}/uploadImage")
		.then()
		     .log().all();
		    
	}
	
	@Test
	public void getPetDetails() {
		
		Response resp = given()
		     .baseUri("https://petstore.swagger.io/v2")
		     .queryParam("status", "available")
		     //.pathParam("petId", 123)
		.when()
		     .get("/pet/findByStatus");
		
		//resp.then().log().all();
		List<String> list=resp.jsonPath().get("name");
		
		int count=1;
		for (String name : list) {
			if (name.equals("doggie")) {
				count++;
			}else {
				System.out.println(name);
			}
			
		}
		System.err.println("string: "+count);
		System.err.println("=================");
		
		List<String> catList=resp.jsonPath().get("category.name");
		int count1=0;
		for (String category : catList) {
			if (category.equals("string")) {
				count1++;
			}else {
				System.out.println(category);
			}
		}
		System.err.println("doggie: "+count1);
	}
}
