package genericUtilities;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassAPI {
	
	public JavaUtility javaUtil=new JavaUtility();
	public DatabaseUtilities db=new DatabaseUtilities();
	
	@BeforeSuite
	public void configBeforeSuite() throws SQLException {
		
		System.out.println("========= S T A R T ==========");
		System.out.println("======== CONNECT TO DB =========");
		db.connectDB();
		baseURI="http://localhost:8084";
	}
	
	@AfterSuite
	public void configAfterSuite() throws SQLException {
		
		System.out.println("======= DISCONNECT TO DB =======");
		System.out.println("=========== E N D ============");
		db.closeDB();
	}
	
	@BeforeMethod
	public void division() {
		System.err.println("======= S T A R T   E X E C U T E ========");
	}
	
}
