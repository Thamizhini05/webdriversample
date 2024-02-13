//package testScripts;
//
//import java.sql.DriverManager;
//
//import org.testng.annotations.Test;
//
//public class DBTesting {
//  //connection object
//	static Connection con=null;
//	//statement object
//	private static Statement stmt;
//	//constant for database url - mysql
//	//public static String DB_URL ="jdbc:mysql://D:/Sqlite";
////	Database url sqlite
//	public static String DB_URL="jdbc:sqlite:";
//	//database username
//	public static String DB_USER ="";
//	//database password,
//	public static String DB_PASSWORD ="";
//	
//	@BeforeTest
//	public void setUp() throws Exception{
//		try {		
//			Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
//			stmt =con.createStatement();		
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//}

package testScripts;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class SampleDBTest {
  static Connection con = null;
  private static Statement stmt;
  public static String DB_URL ="jdbc:sqlite:D://Sqlite/testTrgDB";
  public static String DB_USER = "";
  public static String DB_PASSWORD = "";
  
  @BeforeTest
  public void setUp() throws Exception{
	  try {
		  Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		  stmt = con.createStatement();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
  
  public void test() {
	  try {
	  String query="select * from Students";
	  //get the contents of userinfo table from db
	  ResultSet res=stmt.executeQuery(query);
	  //print result until all the records are printed
	  //res.net() returns true if there is any next record else returns false
	  while(res.next()) {
		  System.out.print(res.getString(1));
		  System.out.print(" " + res.getString(2));
		  System.out.print(" " + res.getString(3));
		  System.out.println(" " + res.getString(4));
		  System.out.println(" " + res.getString(5));
	  }
  }catch(Exception e) {
	  e.printStackTrace();
  }
  }
// @AfterTest
// public void tearDown throws Exception{
//	 //close db connection
//	 if(con!=null) {
//		 con.close();
//	 }
// }
  
  @AfterTest
  public void tearDown() throws Exception
  {
	  if(con!=null)
	  {
		  con.close();
	  }
  }
}
  
  
  


