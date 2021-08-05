package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class EmployeeParserJava {
	/**
	 * De-serilization convert json obj to java obj
	 * @param args
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		File file = new File("./emp.json");
		
		ObjectMapper objIn = new ObjectMapper();
		
		Employee emp = objIn.readValue(file, Employee.class);//convert json to java
		
		System.out.println(emp.name);
		System.out.println(emp.id);
		System.out.println(emp.sal);
		System.out.println(emp.gender);
		
	}

}
