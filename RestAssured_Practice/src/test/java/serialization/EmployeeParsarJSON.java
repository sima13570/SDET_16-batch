package serialization;

import java.io.FileOutputStream;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class EmployeeParsarJSON {
	/**
	 * Serilization code for java to Jason
	 * @param args
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		Employee emp = new Employee("Bhanu", 10, 15000, 'M');
		
		FileOutputStream file = new FileOutputStream("./emp.json");
		
		ObjectMapper objOut = new ObjectMapper();//parsing //converting java obj to JSOn obj
		objOut.writeValue(file, emp);
		
		System.out.println("=====serialization done====");
		
		
		
		
	}
}
