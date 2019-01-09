package maven1;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
	
	
public class TC429_Users_AdvancedFilterBySrch {
		
	//WebDriver driver;
public Select selenium;
public static WebDriver driver;


/*
 * Create a quote from agreement
 * 

*/
//@Test(priority=1)
public static void main(String[] args) throws IOException, InterruptedException { 
//public  void quoteFromAgreement() throws Throwable {
	
	
	//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver=new FirefoxDriver();
	//driver=new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	//File src=new File("C:\\mmi_auto_testing\\data\\AdvanceSearch_SEAutoTesting.xlsx");
	//File src=new File("SEAutoTesting.xlsx");
	//File src=new File("AdvancedSearch_SEAutoTesting.xlsx");
	//File src=new File("\\mmi_automation\\mmi_auto_testing_AdvencedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
	File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
	
	FileInputStream fis=new FileInputStream(src);
	
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	
	//get sheet at index
	//XSSFSheet sheet1=wb.getSheetAt(1);  
	
	// Get sheet by name
	XSSFSheet sheet1=wb.getSheet("TC429");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	String baseUrl ;
	String loginUrl; 
	String logoutUrl; 
	String testUsername;
	String testPassword ;
	
	

	String Address1;
	String Address2;
	String Cell;
	String City;
	String Companies_Id;
	String Companies_Name;
	String Country_Id;
	String Date_of_Birth;
	String Department;
	String Email;
	String Fax;
	String Firstname;
	String Is_Primary;
	String Lastname;
	String Phone;
	String Referral_Companies_Id;
	String Sex;
	String Signup_Companies_Name;
	String Status_Title;
	String Title;
	String Users_Id;
	String Zip;

	
	//String agreementUrl ;
	//int agreementId ;
	//int numRows ;
	//String numPages;
	//int pageCounter;
	//String gridTitle = "agreement";

	
	baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
	logoutUrl =baseUrl + "/auth/logout"; 
	loginUrl =baseUrl + "/auth/login"; 
	testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
	testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
	
	
	Address1 = sheet1.getRow(3).getCell(10).getStringCellValue();
	Address2 = sheet1.getRow(4).getCell(10).getStringCellValue();
	Cell = sheet1.getRow(5).getCell(10).getStringCellValue();
	City = sheet1.getRow(6).getCell(10).getStringCellValue();
	Companies_Id = sheet1.getRow(7).getCell(10).getStringCellValue();
	Companies_Name = sheet1.getRow(8).getCell(10).getStringCellValue();
	Country_Id = sheet1.getRow(9).getCell(10).getStringCellValue();
	Date_of_Birth = sheet1.getRow(10).getCell(10).getStringCellValue();
	Department = sheet1.getRow(11).getCell(10).getStringCellValue();
	Email = sheet1.getRow(12).getCell(10).getStringCellValue();
	Fax = sheet1.getRow(13).getCell(10).getStringCellValue();
	Firstname = sheet1.getRow(14).getCell(10).getStringCellValue();
	Is_Primary = sheet1.getRow(15).getCell(10).getStringCellValue();
	Lastname = sheet1.getRow(16).getCell(10).getStringCellValue();
	Phone = sheet1.getRow(17).getCell(10).getStringCellValue();
	Referral_Companies_Id = sheet1.getRow(18).getCell(10).getStringCellValue();
	Sex = sheet1.getRow(19).getCell(10).getStringCellValue();
	Signup_Companies_Name = sheet1.getRow(20).getCell(10).getStringCellValue();
	Status_Title = sheet1.getRow(21).getCell(10).getStringCellValue();
	Title = sheet1.getRow(22).getCell(10).getStringCellValue();
	Users_Id = sheet1.getRow(23).getCell(10).getStringCellValue();
	Zip = sheet1.getRow(24).getCell(10).getStringCellValue();


	
	// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
	
	
	driver.get(logoutUrl);
	Thread.sleep(2000);
	driver.get(loginUrl);
	Thread.sleep(2000);
	
	//find the email text box and send the email id
	Boolean actualResult = driver.findElements(By.id("email")).size()>0; 
	
	if(! actualResult)
	      //login.click();
	  //Main Event is logged If Passed
	  {
	
	
			sheet1.getRow(4).createCell(9).setCellValue("FAILED");
			sheet1.getRow(4).createCell(8).setCellValue("Username was NOT Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
	
	else 
			{
				sheet1.getRow(4).createCell(9).setCellValue("PASSED");
				sheet1.getRow(4).createCell(8).setCellValue("Username was Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("email")).sendKeys(testUsername);
				Thread.sleep(2000);
	}
	
	//find the password text box and send the password id
	Boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
	
		if(! actualResult1)
	      
	      {
				sheet1.getRow(5).createCell(9).setCellValue("FAILED");
				sheet1.getRow(5).createCell(8).setCellValue("Password was NOT Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
	
	else 
			{
				sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				sheet1.getRow(5).createCell(8).setCellValue("Password was Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("password-text")).sendKeys(testPassword);
				Thread.sleep(2000);
	}
	
	//If statement - will check if element is Displayed before clicking on login button.
	Boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
	
	if(! actualResult2)
	     
			{
				sheet1.getRow(6).createCell(9).setCellValue("FAILED");
				sheet1.getRow(6).createCell(8).setCellValue("Login button NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
	
	else 
			{
				sheet1.getRow(6).createCell(9).setCellValue("PASSED");
				sheet1.getRow(6).createCell(8).setCellValue("login button was found and clicked");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Login")).click();
				Thread.sleep(17000);
	}
	
	//find the dash board tab and click
	Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
	
	
	if(! actualResult3)
	{
		sheet1.getRow(7).createCell(9).setCellValue("FAILED");
		sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
		
	}
	else
	{
		sheet1.getRow(7).createCell(9).setCellValue("PASSED");
		sheet1.getRow(7).createCell(8).setCellValue("Dashboard was found and displayed");
		FileOutputStream fout=new FileOutputStream(src);
		driver.findElement(By.id("dashboard")).click();
		wb.write(fout);
		Thread.sleep(3000);
	}
	
	//Click on the Installed Base Tab
	Boolean installedBase =  driver.findElements(By.id("topmenuitem_1")).size() >0;
	
	if( ! installedBase)
	{
		//If the tab is not greater than "0", then show "failed"
		sheet1.getRow(8).createCell(9).setCellValue("FAILED");
		sheet1.getRow(8).createCell(8).setCellValue("Users Tab menu was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	
	}
	else
	{
		//If the tab is greater than "0", then show "passed"
		sheet1.getRow(8).createCell(9).setCellValue("PASSED");
		sheet1.getRow(8).createCell(8).setCellValue("Users Tab menu was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("topmenuitem_1")).click();
		Thread.sleep(5000);
	}
	
	
	 //Find the clear search button and click
	if(driver.findElements(By.id("cancelMainuserlist")).size()>0) {
	 
		driver.findElement(By.id("cancelMainuserlist")).click();
		 Thread.sleep(5000);}
	
	 //Find the Advance search link
	 Boolean advSrch = driver.findElements(By.id("advSrch_userlist")).size() >0;
	
	if ( ! advSrch)
	{
		sheet1.getRow(9).createCell(9).setCellValue("FAILED");
		sheet1.getRow(9).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(9).createCell(9).setCellValue("PASSED");
		sheet1.getRow(9).createCell(8).setCellValue("'Advance Search Link' was Displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	    driver.findElement(By.id("advSrch_userlist")).click();
	    Thread.sleep(3000);
	}
	
	//Find the Advance search link and click the link
	 Boolean advSrch1 = driver.findElements(By.id("drill_userlist")).size() >0;
	
	if ( ! advSrch1)
	{
		sheet1.getRow(10).createCell(9).setCellValue("FAILED");
		sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(10).createCell(9).setCellValue("PASSED");
		sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(4000);
	}
	
	
	//Find the Advance search link and click the link
	 Boolean advSrchFilter = driver.findElements(By.id("drill_userlist")).size() >0;
	
	if ( ! advSrchFilter)
	{
		sheet1.getRow(11).createCell(9).setCellValue("FAILED");
		sheet1.getRow(11).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(11).createCell(9).setCellValue("PASSED");
		sheet1.getRow(11).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(2000);
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Address1));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Address1))).click();
	Thread.sleep(2000);
	
	
	
	//Find the Advance search filter box and Enter ID
	 Boolean advSrchFilter1 = driver.findElements(By.linkText(String.valueOf(Address1))).size() >0;
		
	if ( ! advSrchFilter1)
	{
		sheet1.getRow(12).createCell(9).setCellValue("FAILED");
		sheet1.getRow(12).createCell(8).setCellValue("Address1 field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(12).createCell(9).setCellValue("PASSED");
		sheet1.getRow(12).createCell(8).setCellValue("Address1 field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Address2));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Address2))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter CustomerSiteID
	 Boolean advSrchFilter2 = driver.findElements(By.linkText(String.valueOf(Address2))).size() >0;
		
	if ( ! advSrchFilter2)
	{
		sheet1.getRow(13).createCell(9).setCellValue("FAILED");
		sheet1.getRow(13).createCell(8).setCellValue("Address2 field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(13).createCell(9).setCellValue("PASSED");
		sheet1.getRow(13).createCell(8).setCellValue("Address2 field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Cell));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Cell))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ParentAgreementNumber
	 Boolean advSrchFilter3 = driver.findElements(By.linkText(String.valueOf(Cell))).size() >0;
	
	if ( ! advSrchFilter3)
	{
		sheet1.getRow(14).createCell(9).setCellValue("FAILED");
		sheet1.getRow(14).createCell(8).setCellValue("Cell field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(14).createCell(9).setCellValue("PASSED");
		sheet1.getRow(14).createCell(8).setCellValue("Cell field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(City));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(City))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Agreement_Type
	 Boolean advSrchFilter4 = driver.findElements(By.linkText(String.valueOf(City))).size() >0;
			
	if ( ! advSrchFilter4)
	{
		sheet1.getRow(15).createCell(9).setCellValue("FAILED");
		sheet1.getRow(15).createCell(8).setCellValue("City field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(15).createCell(9).setCellValue("PASSED");
		sheet1.getRow(15).createCell(8).setCellValue("City field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Companies_Id));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Id))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter StartDate
	 Boolean advSrchFilter5 = driver.findElements(By.linkText(String.valueOf(Companies_Id))).size() >0;
				
	if ( ! advSrchFilter5)
	{
		sheet1.getRow(16).createCell(9).setCellValue("FAILED");
		sheet1.getRow(16).createCell(8).setCellValue("Companies_Id field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(16).createCell(9).setCellValue("PASSED");
		sheet1.getRow(16).createCell(8).setCellValue("Companies_Id field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Companies_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter EndDate
	 Boolean advSrchFilter6 = driver.findElements(By.linkText(String.valueOf(Companies_Name))).size() >0;
				
	if ( ! advSrchFilter6)
	{
		sheet1.getRow(17).createCell(9).setCellValue("FAILED");
		sheet1.getRow(17).createCell(8).setCellValue("Companies_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(17).createCell(9).setCellValue("PASSED");
		sheet1.getRow(17).createCell(8).setCellValue("Companies_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Country_Id));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Country_Id))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementTypeID
	 Boolean advSrchFilter7 = driver.findElements(By.linkText(String.valueOf(Country_Id))).size() >0;
				
	if ( ! advSrchFilter7)
	{
		sheet1.getRow(18).createCell(9).setCellValue("FAILED");
		sheet1.getRow(18).createCell(8).setCellValue("Country_Id field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(18).createCell(9).setCellValue("PASSED");
		sheet1.getRow(18).createCell(8).setCellValue("Country_Id field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Date_of_Birth));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Date_of_Birth))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter8 = driver.findElements(By.linkText(String.valueOf(Date_of_Birth))).size() >0;
				
	if ( ! advSrchFilter8)
	{
		sheet1.getRow(19).createCell(9).setCellValue("FAILED");
		sheet1.getRow(19).createCell(8).setCellValue("Date_of_Birth field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(19).createCell(9).setCellValue("PASSED");
		sheet1.getRow(19).createCell(8).setCellValue("Date_of_Birth field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_userlist")).clear();
		driver.findElement(By.id("drill_userlist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Department));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Department))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Days_to_Expiration
		 Boolean advSrchFilter9 = driver.findElements(By.linkText(String.valueOf(Department))).size() >0;
					
		if ( ! advSrchFilter9)
		{
			sheet1.getRow(20).createCell(9).setCellValue("FAILED");
			sheet1.getRow(20).createCell(8).setCellValue("Department field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(20).createCell(9).setCellValue("PASSED");
			sheet1.getRow(20).createCell(8).setCellValue("Department field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Email));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Email))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CF_License_Value
		 Boolean advSrchFilter10 = driver.findElements(By.linkText(String.valueOf(Email))).size() >0;
					
		if ( ! advSrchFilter10)
		{
			sheet1.getRow(21).createCell(9).setCellValue("FAILED");
			sheet1.getRow(21).createCell(8).setCellValue("Email field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(21).createCell(9).setCellValue("PASSED");
			sheet1.getRow(21).createCell(8).setCellValue("Email field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Fax));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Fax))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Estimated_CF_Agreement_Value
		 Boolean advSrchFilter11 = driver.findElements(By.linkText(String.valueOf(Fax))).size() >0;
					
		if ( ! advSrchFilter11)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("Fax field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("Fax field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Firstname));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Firstname))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Annualized_CF_Agreement_Value
		 Boolean advSrchFilter12 = driver.findElements(By.linkText(String.valueOf(Firstname))).size() >0;
					
		if ( ! advSrchFilter12)
		{
			sheet1.getRow(23).createCell(9).setCellValue("FAILED");
			sheet1.getRow(23).createCell(8).setCellValue("Firstname field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(23).createCell(9).setCellValue("PASSED");
			sheet1.getRow(23).createCell(8).setCellValue("Firstname field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Is_Primary));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Is_Primary))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CFProgramLevelID
		 Boolean advSrchFilter13 = driver.findElements(By.linkText(String.valueOf(Is_Primary))).size() >0;
					
		if ( ! advSrchFilter13)
		{
			sheet1.getRow(24).createCell(9).setCellValue("FAILED");
			sheet1.getRow(24).createCell(8).setCellValue("Is_Primary field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(24).createCell(9).setCellValue("PASSED");
			sheet1.getRow(24).createCell(8).setCellValue("Is_Primary field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Lastname));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Lastname))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter TAMFlag
		 Boolean advSrchFilter14 = driver.findElements(By.linkText(String.valueOf(Lastname))).size() >0;
					
		if ( ! advSrchFilter14)
		{
			sheet1.getRow(25).createCell(9).setCellValue("FAILED");
			sheet1.getRow(25).createCell(8).setCellValue("Lastname field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(25).createCell(9).setCellValue("PASSED");
			sheet1.getRow(25).createCell(8).setCellValue("Lastname field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Phone));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Phone))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Brand
		 Boolean advSrchFilter15 = driver.findElements(By.linkText(String.valueOf(Phone))).size() >0;
					
		if ( ! advSrchFilter15)
		{
			sheet1.getRow(26).createCell(9).setCellValue("FAILED");
			sheet1.getRow(26).createCell(8).setCellValue("Phone field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(26).createCell(9).setCellValue("PASSED");
			sheet1.getRow(26).createCell(8).setCellValue("Phone field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Referral_Companies_Id));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Referral_Companies_Id))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter ActiveFlag
		 Boolean advSrchFilter16 = driver.findElements(By.linkText(String.valueOf(Referral_Companies_Id))).size() >0;
					
		if ( ! advSrchFilter16)
		{
			sheet1.getRow(27).createCell(9).setCellValue("FAILED");
			sheet1.getRow(27).createCell(8).setCellValue("Referral_Companies_Id field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(27).createCell(9).setCellValue("PASSED");
			sheet1.getRow(27).createCell(8).setCellValue("Referral_Companies_Id field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Sex));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Sex))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter DistributorID
		 Boolean advSrchFilter17 = driver.findElements(By.linkText(String.valueOf(Sex))).size() >0;
					
		if ( ! advSrchFilter17)
		{
			sheet1.getRow(28).createCell(9).setCellValue("FAILED");
			sheet1.getRow(28).createCell(8).setCellValue("Sex field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(28).createCell(9).setCellValue("PASSED");
			sheet1.getRow(28).createCell(8).setCellValue("Sex field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Signup_Companies_Name));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Signup_Companies_Name))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition Code
		 Boolean advSrchFilter18 = driver.findElements(By.linkText(String.valueOf(Signup_Companies_Name))).size() >0;
					
		if ( ! advSrchFilter18)
		{
			sheet1.getRow(29).createCell(9).setCellValue("FAILED");
			sheet1.getRow(29).createCell(8).setCellValue("Signup_Companies_Name field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(29).createCell(9).setCellValue("PASSED");
			sheet1.getRow(29).createCell(8).setCellValue("Signup_Companies_Name field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Status_Title));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Status_Title))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition
		 Boolean advSrchFilter19 = driver.findElements(By.linkText(String.valueOf(Status_Title))).size() >0;
					
		if ( ! advSrchFilter19)
		{
			sheet1.getRow(30).createCell(9).setCellValue("FAILED");
			sheet1.getRow(30).createCell(8).setCellValue("Status_Title field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(30).createCell(9).setCellValue("PASSED");
			sheet1.getRow(30).createCell(8).setCellValue("Status_Title field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Title));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Title))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter category
		 Boolean advSrchFilter20 = driver.findElements(By.linkText(String.valueOf(Title))).size() >0;
					
		if ( ! advSrchFilter20)
		{
			sheet1.getRow(31).createCell(9).setCellValue("FAILED");
			sheet1.getRow(31).createCell(8).setCellValue("Title field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(31).createCell(9).setCellValue("PASSED");
			sheet1.getRow(31).createCell(8).setCellValue("Title field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Users_Id));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Users_Id))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition_status
		 Boolean advSrchFilter21 = driver.findElements(By.linkText(String.valueOf(Users_Id))).size() >0;
					
		if ( ! advSrchFilter21)
		{
			sheet1.getRow(32).createCell(9).setCellValue("FAILED");
			sheet1.getRow(32).createCell(8).setCellValue("Users_Id field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(32).createCell(9).setCellValue("PASSED");
			sheet1.getRow(32).createCell(8).setCellValue("Users_Id field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_userlist")).sendKeys(String.valueOf(Zip));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Zip))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CustomerType
		 Boolean advSrchFilter22 = driver.findElements(By.linkText(String.valueOf(Zip))).size() >0;
					
		if ( ! advSrchFilter22)
		{
			sheet1.getRow(33).createCell(9).setCellValue("FAILED");
			sheet1.getRow(33).createCell(8).setCellValue("Zip field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(33).createCell(9).setCellValue("PASSED");
			sheet1.getRow(33).createCell(8).setCellValue("Zip field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_userlist")).clear();
			driver.findElement(By.id("drill_userlist")).click();
			Thread.sleep(1000);
			
		}
	
		
	//Click the Agreement ID link filter
	Boolean closeButton = driver.findElements(By.xpath("//html/body/div[9]/div[1]/button")).size() >0;
	
	
	if ( ! closeButton)
	{
		
		sheet1.getRow(34).createCell(9).setCellValue("FAILED");
		sheet1.getRow(34).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(34).createCell(9).setCellValue("PASSED");
		sheet1.getRow(34).createCell(8).setCellValue("Close Advanced Search was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.xpath("//html/body/div[9]/div[1]/button")).click();
		Thread.sleep(3000);
	}
	
	//Click the Agreement ID link filter
	Boolean refreshButton = driver.findElements(By.id("refresh_userlist")).size() >0;
	
	
	if ( ! refreshButton)
	{
		
		sheet1.getRow(35).createCell(9).setCellValue("FAILED");
		sheet1.getRow(35).createCell(8).setCellValue("Grid was NOT Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(35).createCell(9).setCellValue("PASSED");
		sheet1.getRow(35).createCell(8).setCellValue("Grid was Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("refresh_userlist")).click();
		Thread.sleep(3000);
	}
			

		
	    wb.close();	
		driver.quit();
	}	
	public void quoteFromAgreementWithParent() throws Throwable	{
		
	}
	
	
//@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-" 
					+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
	   }        
	}
			//Utility.captureScreenshot(driver, result.getName());
			
			
			//driver.quit();
		}
	
	
	
