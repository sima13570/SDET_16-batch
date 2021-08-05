package genericUtilities;

import java.util.List;
import java.util.Random;

public class JavaUtility {
	
	public String verifyDataInList(List<String> list, String expectedData) {
		
		String returnData = null;
		for (String actualData : list) {
			
			if (actualData.equals(expectedData)) {
				
				System.out.println("expected Data : "+expectedData);
				returnData=expectedData;
			}
		}
		
		return returnData;
	}
	
	public String verifyDataInList(List<String> list, int expectedData) {
		
		String returnData = null;
		for (String actualData : list) {
			
			if (actualData.equals(list.get(expectedData))) {
				
				System.out.println("expected Data : "+actualData);
				returnData=actualData;
				break;
			}
		}
		return returnData;
	}
	
	public int random() {
		
		Random ran=new Random();
		int randomValue = ran.nextInt(1000);	
	
		return randomValue;
	}

}
