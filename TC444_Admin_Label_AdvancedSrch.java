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
	
	
public class TC444_Admin_Label_AdvancedSrch {
		
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
	XSSFSheet sheet1=wb.getSheet("TC444");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	String baseUrl ;
	String loginUrl; 
	String logoutUrl; 
	String testUsername;
	String testPassword ;
	
	
	String Asset_Locations_ID;
	String Companies_Address1;
	String Companies_Address2;
	String Companies_City;
	String Companies_Country_Name;
	String Companies_Id;
	String Companies_Location_Name;
	String Companies_Name;
	String Companies_Number;
	String Companies_State_Abbr;
	String Companies_State_Name;
	String Companies_Url;
	String Companies_Zip;
	String Created_At;
	String Expired_Date;
	String Fax;
	String Host_Companies_Id;
	String Internal_Name;
	String Internal_Number;
	String Location_Number;
	String Parent_Companies_Id;
	String Phone;
	String Status_Title;
	String Statuses_Id;
	String Updated_At;


	
	baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
	logoutUrl =baseUrl + "/auth/logout"; 
	loginUrl =baseUrl + "/auth/login"; 
	testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
	testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
	

	
	Asset_Locations_ID = sheet1.getRow(3).getCell(10).getStringCellValue();
	Companies_Address1 = sheet1.getRow(4).getCell(10).getStringCellValue();
	Companies_Address2 = sheet1.getRow(4).getCell(10).getStringCellValue();
	Companies_City = sheet1.getRow(6).getCell(10).getStringCellValue();
	Companies_Country_Name = sheet1.getRow(7).getCell(10).getStringCellValue();
	Companies_Id = sheet1.getRow(8).getCell(10).getStringCellValue();
	Companies_Location_Name = sheet1.getRow(9).getCell(10).getStringCellValue();
	Companies_Name = sheet1.getRow(10).getCell(10).getStringCellValue();
	Companies_Number = sheet1.getRow(11).getCell(10).getStringCellValue();
	Companies_State_Abbr = sheet1.getRow(12).getCell(10).getStringCellValue();
	Companies_State_Name = sheet1.getRow(13).getCell(10).getStringCellValue();
	Companies_Url = sheet1.getRow(14).getCell(10).getStringCellValue();
	Companies_Zip = sheet1.getRow(15).getCell(10).getStringCellValue();
	Created_At = sheet1.getRow(16).getCell(10).getStringCellValue();
	Expired_Date = sheet1.getRow(17).getCell(10).getStringCellValue();
	Fax = sheet1.getRow(18).getCell(10).getStringCellValue();
	Host_Companies_Id = sheet1.getRow(19).getCell(10).getStringCellValue();
	Internal_Name = sheet1.getRow(20).getCell(10).getStringCellValue();
	Internal_Number = sheet1.getRow(21).getCell(10).getStringCellValue();
	Location_Number = sheet1.getRow(22).getCell(10).getStringCellValue();
	Parent_Companies_Id = sheet1.getRow(23).getCell(10).getStringCellValue();
	Phone = sheet1.getRow(24).getCell(10).getStringCellValue();
	Status_Title = sheet1.getRow(25).getCell(10).getStringCellValue();
	Statuses_Id = sheet1.getRow(26).getCell(10).getStringCellValue();
	Updated_At = sheet1.getRow(27).getCell(10).getStringCellValue();


	
	driver.get(logoutUrl);
	Thread.sleep(2000);
	driver.get(loginUrl);
	Thread.sleep(2000);
	
	//find the email text box and send the email id
	Boolean actualResult = driver.findElements(By.id("email")).size()>0; 
	
	if(! actualResult)
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
	Boolean installedBase =  driver.findElements(By.id("topmenuitem_32")).size() >0;
	
	if( ! installedBase)
	{
		//If the tab is not greater than "0", then show "failed"
		sheet1.getRow(8).createCell(9).setCellValue("FAILED");
		sheet1.getRow(8).createCell(8).setCellValue("Admin Tab menu was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	
	}
	else
	{
		//If the tab is greater than "0", then show "passed"
		sheet1.getRow(8).createCell(9).setCellValue("PASSED");
		sheet1.getRow(8).createCell(8).setCellValue("Admin Tab menu was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("topmenuitem_32")).click();
		Thread.sleep(5000);
	}
	
	//Click on the Agreements tab
		Boolean agreementTab =  driver.findElements(By.id("submenulink_58")).size() >0;
				
		if( ! agreementTab)
		{
			//If the tab is not greater than "0", then show "failed"
			sheet1.getRow(9).createCell(9).setCellValue("FAILED");
			sheet1.getRow(9).createCell(8).setCellValue("Label Tab Submenu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		
		}
		else
		{
			//If the tab is greater than "0", then show "passed"
			sheet1.getRow(9).createCell(9).setCellValue("PASSED");
			sheet1.getRow(9).createCell(8).setCellValue("Label Tab Submenu was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("submenulink_58")).click();
			Thread.sleep(5000);
		}
	
	
	 //Find the clear search button and click
	if(driver.findElements(By.id("cancelMaincompanylabellist")).size()>0) {
	 
		driver.findElement(By.id("cancelMaincompanylabellist")).click();
		 Thread.sleep(5000);}
	
	 //Find the Advance search link
	 Boolean advSrch = driver.findElements(By.id("advSrch_companylabellist")).size() >0;
	
	if ( ! advSrch)
	{
		sheet1.getRow(10).createCell(9).setCellValue("FAILED");
		sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(10).createCell(9).setCellValue("PASSED");
		sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	    driver.findElement(By.id("advSrch_companylabellist")).click();
	    Thread.sleep(3000);
	}
	
	//Find the Advance search link and click the link
	 Boolean advSrch1 = driver.findElements(By.id("drill_companylabellist")).size() >0;
	
	if ( ! advSrch1)
	{
		sheet1.getRow(11).createCell(9).setCellValue("FAILED");
		sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(11).createCell(9).setCellValue("PASSED");
		sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(4000);
	}
	
	
	//Find the Advance search link and click the link
	 Boolean advSrchFilter = driver.findElements(By.id("drill_companylabellist")).size() >0;
	
	if ( ! advSrchFilter)
	{
		sheet1.getRow(12).createCell(9).setCellValue("FAILED");
		sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(12).createCell(9).setCellValue("PASSED");
		sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(2000);
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Asset_Locations_ID));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Asset_Locations_ID))).click();
	Thread.sleep(2000);
	
	
	
	//Find the Advance search filter box and Enter ID
	 Boolean advSrchFilter1 = driver.findElements(By.linkText(String.valueOf(Asset_Locations_ID))).size() >0;
		
	if ( ! advSrchFilter1)
	{
		sheet1.getRow(13).createCell(9).setCellValue("FAILED");
		sheet1.getRow(13).createCell(8).setCellValue("Asset_Locations_ID field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(13).createCell(9).setCellValue("PASSED");
		sheet1.getRow(13).createCell(8).setCellValue("Asset_Locations_ID field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Address1));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Address1))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter CustomerSiteID
	 Boolean advSrchFilter2 = driver.findElements(By.linkText(String.valueOf(Companies_Address1))).size() >0;
		
	if ( ! advSrchFilter2)
	{
		sheet1.getRow(14).createCell(9).setCellValue("FAILED");
		sheet1.getRow(14).createCell(8).setCellValue("Companies_Address1 field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(14).createCell(9).setCellValue("PASSED");
		sheet1.getRow(14).createCell(8).setCellValue("Companies_Address1 field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Address2));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Address2))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ParentAgreementNumber
	 Boolean advSrchFilter3 = driver.findElements(By.linkText(String.valueOf(Companies_Address2))).size() >0;
	
	if ( ! advSrchFilter3)
	{
		sheet1.getRow(15).createCell(9).setCellValue("FAILED");
		sheet1.getRow(15).createCell(8).setCellValue("Companies_Address2 field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(15).createCell(9).setCellValue("PASSED");
		sheet1.getRow(15).createCell(8).setCellValue("Companies_Address2 field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_City));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_City))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Agreement_Type
	 Boolean advSrchFilter4 = driver.findElements(By.linkText(String.valueOf(Companies_City))).size() >0;
			
	if ( ! advSrchFilter4)
	{
		sheet1.getRow(16).createCell(9).setCellValue("FAILED");
		sheet1.getRow(16).createCell(8).setCellValue("Companies City field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(16).createCell(9).setCellValue("PASSED");
		sheet1.getRow(16).createCell(8).setCellValue("Companies City field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Country_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Country_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter StartDate
	 Boolean advSrchFilter5 = driver.findElements(By.linkText(String.valueOf(Companies_Country_Name))).size() >0;
				
	if ( ! advSrchFilter5)
	{
		sheet1.getRow(17).createCell(9).setCellValue("FAILED");
		sheet1.getRow(17).createCell(8).setCellValue("Companies_Country_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(17).createCell(9).setCellValue("PASSED");
		sheet1.getRow(17).createCell(8).setCellValue("Companies_Country_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Id));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Id))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter EndDate
	 Boolean advSrchFilter6 = driver.findElements(By.linkText(String.valueOf(Companies_Id))).size() >0;
				
	if ( ! advSrchFilter6)
	{
		sheet1.getRow(18).createCell(9).setCellValue("FAILED");
		sheet1.getRow(18).createCell(8).setCellValue("Companies_Id field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(18).createCell(9).setCellValue("PASSED");
		sheet1.getRow(18).createCell(8).setCellValue("Companies_Id field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Location_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Location_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementTypeID
	 Boolean advSrchFilter7 = driver.findElements(By.linkText(String.valueOf(Companies_Location_Name))).size() >0;
				
	if ( ! advSrchFilter7)
	{
		sheet1.getRow(19).createCell(9).setCellValue("FAILED");
		sheet1.getRow(19).createCell(8).setCellValue("Companies_Location_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(19).createCell(9).setCellValue("PASSED");
		sheet1.getRow(19).createCell(8).setCellValue("Companies_Location_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter8 = driver.findElements(By.linkText(String.valueOf(Companies_Name))).size() >0;
				
	if ( ! advSrchFilter8)
	{
		sheet1.getRow(20).createCell(9).setCellValue("FAILED");
		sheet1.getRow(20).createCell(8).setCellValue("Companies_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(20).createCell(9).setCellValue("PASSED");
		sheet1.getRow(20).createCell(8).setCellValue("Companies_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Number));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Number))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter9 = driver.findElements(By.linkText(String.valueOf(Companies_Number))).size() >0;
				
	if ( ! advSrchFilter9)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("Companies_Number field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("Companies_Number field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_State_Abbr));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_State_Abbr))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter10 = driver.findElements(By.linkText(String.valueOf(Companies_State_Abbr))).size() >0;
				
	if ( ! advSrchFilter10)
	{
		sheet1.getRow(22).createCell(9).setCellValue("FAILED");
		sheet1.getRow(22).createCell(8).setCellValue("Companies_State_Abbr field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(22).createCell(9).setCellValue("PASSED");
		sheet1.getRow(22).createCell(8).setCellValue("Companies_State_Abbr field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_State_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_State_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter11 = driver.findElements(By.linkText(String.valueOf(Companies_State_Name))).size() >0;
				
	if ( ! advSrchFilter11)
	{
		sheet1.getRow(23).createCell(9).setCellValue("FAILED");
		sheet1.getRow(23).createCell(8).setCellValue("Companies_State_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(23).createCell(9).setCellValue("PASSED");
		sheet1.getRow(23).createCell(8).setCellValue("Companies_State_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Url));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Url))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter12 = driver.findElements(By.linkText(String.valueOf(Companies_Url))).size() >0;
				
	if ( ! advSrchFilter12)
	{
		sheet1.getRow(24).createCell(9).setCellValue("FAILED");
		sheet1.getRow(24).createCell(8).setCellValue("Companies_Url field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(24).createCell(9).setCellValue("PASSED");
		sheet1.getRow(24).createCell(8).setCellValue("Companies_Url field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Companies_Zip));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Companies_Zip))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter13 = driver.findElements(By.linkText(String.valueOf(Companies_Zip))).size() >0;
				
	if ( ! advSrchFilter13)
	{
		sheet1.getRow(25).createCell(9).setCellValue("FAILED");
		sheet1.getRow(25).createCell(8).setCellValue("Companies_Zip field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(25).createCell(9).setCellValue("PASSED");
		sheet1.getRow(25).createCell(8).setCellValue("Companies_Zip field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Created_At));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Created_At))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter14 = driver.findElements(By.linkText(String.valueOf(Created_At))).size() >0;
				
	if ( ! advSrchFilter14)
	{
		sheet1.getRow(26).createCell(9).setCellValue("FAILED");
		sheet1.getRow(26).createCell(8).setCellValue("Created_At field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(26).createCell(9).setCellValue("PASSED");
		sheet1.getRow(26).createCell(8).setCellValue("Created_At field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Expired_Date));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Expired_Date))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter15 = driver.findElements(By.linkText(String.valueOf(Expired_Date))).size() >0;
				
	if ( ! advSrchFilter15)
	{
		sheet1.getRow(27).createCell(9).setCellValue("FAILED");
		sheet1.getRow(27).createCell(8).setCellValue("Expired_Date field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(27).createCell(9).setCellValue("PASSED");
		sheet1.getRow(27).createCell(8).setCellValue("Expired_Date field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Fax));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Fax))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter16 = driver.findElements(By.linkText(String.valueOf(Fax))).size() >0;
				
	if ( ! advSrchFilter16)
	{
		sheet1.getRow(28).createCell(9).setCellValue("FAILED");
		sheet1.getRow(28).createCell(8).setCellValue("Fax field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(28).createCell(9).setCellValue("PASSED");
		sheet1.getRow(28).createCell(8).setCellValue("Fax field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Host_Companies_Id));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Host_Companies_Id))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter17 = driver.findElements(By.linkText(String.valueOf(Host_Companies_Id))).size() >0;
				
	if ( ! advSrchFilter17)
	{
		sheet1.getRow(29).createCell(9).setCellValue("FAILED");
		sheet1.getRow(29).createCell(8).setCellValue("Host_Companies_Id field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(29).createCell(9).setCellValue("PASSED");
		sheet1.getRow(29).createCell(8).setCellValue("Host_Companies_Id field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Internal_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Internal_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter18 = driver.findElements(By.linkText(String.valueOf(Internal_Name))).size() >0;
				
	if ( ! advSrchFilter18)
	{
		sheet1.getRow(30).createCell(9).setCellValue("FAILED");
		sheet1.getRow(30).createCell(8).setCellValue("Internal_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(30).createCell(9).setCellValue("PASSED");
		sheet1.getRow(30).createCell(8).setCellValue("Internal_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Internal_Number));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Internal_Number))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter19 = driver.findElements(By.linkText(String.valueOf(Internal_Number))).size() >0;
				
	if ( ! advSrchFilter19)
	{
		sheet1.getRow(31).createCell(9).setCellValue("FAILED");
		sheet1.getRow(31).createCell(8).setCellValue("Internal_Number field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(31).createCell(9).setCellValue("PASSED");
		sheet1.getRow(31).createCell(8).setCellValue("Internal_Number field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Location_Number));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Location_Number))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter20 = driver.findElements(By.linkText(String.valueOf(Location_Number))).size() >0;
				
	if ( ! advSrchFilter20)
	{
		sheet1.getRow(32).createCell(9).setCellValue("FAILED");
		sheet1.getRow(32).createCell(8).setCellValue("Location_Number field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(32).createCell(9).setCellValue("PASSED");
		sheet1.getRow(32).createCell(8).setCellValue("Location_Number field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Parent_Companies_Id));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Parent_Companies_Id))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter21 = driver.findElements(By.linkText(String.valueOf(Parent_Companies_Id))).size() >0;
				
	if ( ! advSrchFilter21)
	{
		sheet1.getRow(33).createCell(9).setCellValue("FAILED");
		sheet1.getRow(33).createCell(8).setCellValue("Parent_Companies_Id field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(33).createCell(9).setCellValue("PASSED");
		sheet1.getRow(33).createCell(8).setCellValue("Parent_Companies_Id field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Phone));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Phone))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter22 = driver.findElements(By.linkText(String.valueOf(Phone))).size() >0;
				
	if ( ! advSrchFilter22)
	{
		sheet1.getRow(34).createCell(9).setCellValue("FAILED");
		sheet1.getRow(34).createCell(8).setCellValue("Phone field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(34).createCell(9).setCellValue("PASSED");
		sheet1.getRow(34).createCell(8).setCellValue("Phone field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Status_Title));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Status_Title))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter23 = driver.findElements(By.linkText(String.valueOf(Status_Title))).size() >0;
				
	if ( ! advSrchFilter23)
	{
		sheet1.getRow(35).createCell(9).setCellValue("FAILED");
		sheet1.getRow(35).createCell(8).setCellValue("Status_Title field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(35).createCell(9).setCellValue("PASSED");
		sheet1.getRow(35).createCell(8).setCellValue("Status_Title field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Statuses_Id));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Statuses_Id))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter24 = driver.findElements(By.linkText(String.valueOf(Statuses_Id))).size() >0;
				
	if ( ! advSrchFilter24)
	{
		sheet1.getRow(36).createCell(9).setCellValue("FAILED");
		sheet1.getRow(36).createCell(8).setCellValue("Statuses_Id field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(36).createCell(9).setCellValue("PASSED");
		sheet1.getRow(36).createCell(8).setCellValue("Statuses_Id field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_companylabellist")).sendKeys(String.valueOf(Updated_At));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Updated_At))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter25 = driver.findElements(By.linkText(String.valueOf(Updated_At))).size() >0;
				
	if ( ! advSrchFilter25)
	{
		sheet1.getRow(37).createCell(9).setCellValue("FAILED");
		sheet1.getRow(37).createCell(8).setCellValue("Updated_At field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(37).createCell(9).setCellValue("PASSED");
		sheet1.getRow(37).createCell(8).setCellValue("Updated_At field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_companylabellist")).clear();
		driver.findElement(By.id("drill_companylabellist")).click();
		Thread.sleep(1000);
		
	}
	
			
				
	//Click the Agreement ID link filter
	Boolean closeButton = driver.findElements(By.xpath("//html/body/div[11]/div[1]/button")).size() >0;
	
	
	if ( ! closeButton)
	{
		
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("Close Advanced Search was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.xpath("//html/body/div[11]/div[1]/button")).click();
		Thread.sleep(3000);
	}
	
	//Click the Agreement ID link filter
	Boolean refreshButton = driver.findElements(By.id("refresh_companylabellist")).size() >0;
	
	
	if ( ! refreshButton)
	{
		
		sheet1.getRow(22).createCell(9).setCellValue("FAILED");
		sheet1.getRow(22).createCell(8).setCellValue("Grid was NOT Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(22).createCell(9).setCellValue("PASSED");
		sheet1.getRow(22).createCell(8).setCellValue("Grid was Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("refresh_companylabellist")).click();
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
	
	
	
