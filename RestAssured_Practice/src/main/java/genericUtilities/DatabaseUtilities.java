package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtilities {
	
	Driver driver;
	Connection connection;
	ResultSet result;
	Boolean flag=false;
	String returnData;
	
	/**
	 * Use to establish the connection to mysql database
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException {
		
		try { 
			//step:1 load/register mysql jdbc driver
			driver = new Driver();
			DriverManager.registerDriver(driver); //register driver
			
			//step:2 connect to database
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","root");
		
		} catch (Exception e) {
			
			e.printStackTrace(); 
		}
		
	}
	
	/**
	 * User for execute query only
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws Throwable {
		try {
			result = connection.createStatement().executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * Use for execute the query based on parameters(specific parameter)
	 * @param query
	 * @param columnNo
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnNo, String expectedData) throws Throwable {
		
		//step: 3 issue/write on database query and execute query
		result = connection.createStatement().executeQuery(query);
	
		//step: 4 process and verify the result
		while (result.next()) {
			
			if (result.getString(columnNo).equalsIgnoreCase(expectedData)) {
				returnData=result.getString(columnNo);
				flag=true;
				break;
				
			}
		}
		if (flag) {
			
			System.out.println("\n"+expectedData+" ===> data is verified in the database table");
		
		}
		else {
			System.out.println("\n"+expectedData+" ===> data is not verified in the database table");
	
		}
		return returnData;
	}
	
	/**
	 * This method is used for disconnect from database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		
		//step: 5 close the connection
		connection.close();
	}
	

}
