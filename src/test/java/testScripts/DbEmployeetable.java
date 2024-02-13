package testScripts;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class DbEmployeetable {
	//connection object
  static Connection con = null;
//statement object
  private static Statement stmt;
  //Database url sqlite
  public static String DB_URL ="jdbc:sqlite:D://Sqlite/TestTrgDB.db";
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
  
  @Test
  public void test() {
	  try {
		  
	  String query1="SELECT e.emp_name FROM Employee e JOIN Emp_Dept ed ON e.emp_id = ed.employee_id JOIN Department d ON ed.department_id = d.dept_id WHERE d.dept_name = 'HR';";
	  ResultSet res=stmt.executeQuery(query1);
	  while(res.next())
	  {
	  System.out.print(res.getString(1));
	  }
  }catch(Exception e) {
	  e.printStackTrace();
  }
  }

  
  @AfterTest
  public void tearDown() throws Exception
  {
	  if(con!=null)
	  {
		  con.close();
	  }
  }
}
  
  
  


