package testScripts;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
 
 
 
 
 
 
 
public class LoginTestSample {
	
	WebDriver driver;
	Properties prop;
	//@Parameters ("browser") //parameters should be imported from test ng
	
	@BeforeMethod
	public void setup() throws IOException {
		String path = System.getProperty("user.dir")+
				"//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop = new Properties();
		prop.load(fin);
		String strBrowser1 = prop.getProperty("browser");
		
		System.out.println("Browser name...."+strBrowser1);
		if(strBrowser1.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else
			if(strBrowser1.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
			
	}
  @Test (dataProvider = "loginData")
  public void validLogin(String strUser, String strPwd) {
	  driver.get(prop.getProperty("url"));
	  
		//WebDriver driver = new ChromeDriver();	//launch Chrome browser		
	//	driver..manage().window().maximize();
	//	driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id(readObjPath("user_name"))).sendKeys(strUser);
		driver.findElement(By.name(readObjPath("user_pwd"))).sendKeys(strPwd);;
		driver.findElement(By.tagName(readObjPath("loginBtn"))).click();
		
		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isUserValid);
 
  }
  
@DataProvider (name="loginData")
 
public Object[][] getData() throws CsvValidationException, IOException{
	String path = System.getProperty("user.dir")+
			"//src//test//resources//testData//loginData.csv";
	CSVReader reader = new CSVReader(new FileReader(path)); // filepath is store in csv reader
	String cols[];  //the logindata Data's are stored in single string cols
	ArrayList<Object> dataList = new ArrayList<Object>();  //creating new array list
	while((cols =reader.readNext()) != null) //readnext is an func is an reader
	{
		Object record[] = { cols[0], cols[1] }; //single array....then in object we are storing it is an 2d array
		dataList.add(record); //adding to datalist
	}
	reader.close();
	return dataList.toArray(new Object[dataList.size()][]); //toarray is an func.....to call the 2d array and find the size
	
}
 
 
 
 
public String readObjPath(String objName) {
	
	String objPath = "";
	String path = System.getProperty("user.dir")+
			"//src//test//resources//testData/loginPage.xlsx";
	
	//HSSF -> .XLS
	//XSSF -> .xlsx
	
	FileInputStream fin;
	XSSFWorkbook workbook =null;
	
	try {
		fin = new FileInputStream(path);
		workbook = new XSSFWorkbook(fin);
		
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	XSSFSheet loginSheet = workbook.getSheet("loginPage");
	int numRows = loginSheet.getLastRowNum();
	for(int i=1;i<=numRows;i++) {
		XSSFRow row = loginSheet.getRow(i);
		
		if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
			objPath = row.getCell(1).getStringCellValue();
		}
		
	}
	
	
	return objPath;
	
}
 
@AfterMethod
public void teardown() {
	driver.close();
}
  
  
  
  
// public Object[][] getData()
  
}
 
