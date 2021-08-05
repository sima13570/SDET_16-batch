package mavenParameter;

import org.testng.annotations.Test;

public class ParameterDemo {
	
	 @Test
	 public void runParameter() {
		 
		 String uri = System.getProperty("uri");//get the property of uri from system
		 System.out.println(uri);
		 String endPoint = System.getProperty("endpoint");
		 System.out.println(endPoint);
	 }
	
}
