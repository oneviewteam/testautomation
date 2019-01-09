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
	
	
	public class TC423_CS_AdvancedFilterBySrch {
		
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
	XSSFSheet sheet1=wb.getSheet("TC423");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	String baseUrl ;
	String loginUrl; 
	String logoutUrl; 
	String testUsername;
	String testPassword ;
	
	
	String Account_Name;
	String AccountID;
	String ActiveFlag;
	String Address;
	String Address2;
	String Agreement_End_Date;
	String Agreement_Start_Date;
	String Agreement_Type;
	String AgreementNumber;
	String AgreementTypeID;
	String Brand;
	String CFProgramLevelID;
	String City;
	String Country;
	String CustomerSiteID;
	String CustomerSiteName;
	String CustomerType;
	String Days_to_Expiration;
	String DistributorID;
	String DistributorName;
	String MMI_Created_At_Date;
	String MMI_Updated_At_Date;
	String ParentAgreementNumber;
	String PostalCode;
	String Program_Level;
	String Region_of_Customer_Site;
	String StateProv;

	
	
	//String agreementUrl ;
	//int agreementId ;
	//int numRows ;
	//String numPages;
	//int pageCounter;
	//String gridTitle = "agreement";
	
	
	
	//numRows = sheet1.getLastRowNum();
	
	
	baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
	logoutUrl =baseUrl + "/auth/logout"; 
	loginUrl =baseUrl + "/auth/login"; 
	testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
	testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
	
		
	Account_Name = sheet1.getRow(3).getCell(10).getStringCellValue();
	AccountID = sheet1.getRow(4).getCell(10).getStringCellValue();
	ActiveFlag = sheet1.getRow(5).getCell(10).getStringCellValue();
	Address = sheet1.getRow(6).getCell(10).getStringCellValue();
	Address2 = sheet1.getRow(7).getCell(10).getStringCellValue();
	Agreement_End_Date = sheet1.getRow(8).getCell(10).getStringCellValue();
	Agreement_Start_Date = sheet1.getRow(9).getCell(10).getStringCellValue();
	Agreement_Type = sheet1.getRow(10).getCell(10).getStringCellValue();
	AgreementNumber = sheet1.getRow(11).getCell(10).getStringCellValue();
	AgreementTypeID = sheet1.getRow(12).getCell(10).getStringCellValue();
	Brand = sheet1.getRow(13).getCell(10).getStringCellValue();
	CFProgramLevelID = sheet1.getRow(14).getCell(10).getStringCellValue();
	City = sheet1.getRow(15).getCell(10).getStringCellValue();
	Country = sheet1.getRow(16).getCell(10).getStringCellValue();
	CustomerSiteID = sheet1.getRow(17).getCell(10).getStringCellValue();
	CustomerSiteName = sheet1.getRow(18).getCell(10).getStringCellValue();
	CustomerType = sheet1.getRow(19).getCell(10).getStringCellValue();
	Days_to_Expiration = sheet1.getRow(20).getCell(10).getStringCellValue();
	DistributorID = sheet1.getRow(21).getCell(10).getStringCellValue();
	DistributorName = sheet1.getRow(22).getCell(10).getStringCellValue();
	MMI_Created_At_Date = sheet1.getRow(23).getCell(10).getStringCellValue();
	MMI_Updated_At_Date = sheet1.getRow(24).getCell(10).getStringCellValue();
	ParentAgreementNumber= sheet1.getRow(25).getCell(10).getStringCellValue();
	PostalCode = sheet1.getRow(26).getCell(10).getStringCellValue();
	Program_Level = sheet1.getRow(27).getCell(10).getStringCellValue();
	Region_of_Customer_Site = sheet1.getRow(28).getCell(10).getStringCellValue();
	StateProv = sheet1.getRow(29).getCell(10).getStringCellValue();

	
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
				Thread.sleep(15000);
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
		Thread.sleep(3000);
		wb.write(fout);
	}
	
	//Click on the Installed Base Tab
	Boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
	
	if( ! installedBase)
	{
		//If the tab is not greater than "0", then show "failed"
		sheet1.getRow(8).createCell(9).setCellValue("FAILED");
		sheet1.getRow(8).createCell(8).setCellValue("Installed Base Tab menu was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	
	}
	else
	{
		//If the tab is greater than "0", then show "passed"
		sheet1.getRow(8).createCell(9).setCellValue("PASSED");
		sheet1.getRow(8).createCell(8).setCellValue("Installed Base Tab menu was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("topmenuitem_31")).click();
		Thread.sleep(5000);
	}
	
	//Click on the Agreements tab
	Boolean agreementTab =  driver.findElements(By.id("submenulink_137")).size() >0;
			
	if( ! agreementTab)
	{
		//If the tab is not greater than "0", then show "failed"
		sheet1.getRow(9).createCell(9).setCellValue("FAILED");
		sheet1.getRow(9).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	
	}
	else
	{
		//If the tab is greater than "0", then show "passed"
		sheet1.getRow(9).createCell(9).setCellValue("PASSED");
		sheet1.getRow(9).createCell(8).setCellValue("Customer Sites  Tab Submenu was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("submenulink_137")).click();
		Thread.sleep(5000);
	}
	
	 //Find the clear search button and click
	if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
	 
		driver.findElement(By.id("cancelMaingrid_customer")).click();
		 Thread.sleep(4000);}
	
	 //Find the Advance search link
	 Boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
	
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
	    driver.findElement(By.id("advSrch_grid_customer")).click();
	    Thread.sleep(3000);
	}
	
	//Find the Advance search link and click the link
	 Boolean advSrch1 = driver.findElements(By.id("drill_grid_customer")).size() >0;
	
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
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(4000);
	}
	
	
	//Find the Advance search link and click the link
	 Boolean advSrchFilter = driver.findElements(By.id("drill_grid_customer")).size() >0;
	
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
		driver.findElement(By.id("drill_grid_customer")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(2000);
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Account_Name));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Account_Name))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ID
	 Boolean advSrchFilter1 = driver.findElements(By.linkText(String.valueOf(Account_Name))).size() >0;
		
	if ( ! advSrchFilter1)
	{
		sheet1.getRow(13).createCell(9).setCellValue("FAILED");
		sheet1.getRow(13).createCell(8).setCellValue("Account_Name field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(13).createCell(9).setCellValue("PASSED");
		sheet1.getRow(13).createCell(8).setCellValue("Account_Name field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(AccountID));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(AccountID))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter CustomerSiteID
	 Boolean advSrchFilter2 = driver.findElements(By.linkText(String.valueOf(AccountID))).size() >0;
		
	if ( ! advSrchFilter2)
	{
		sheet1.getRow(14).createCell(9).setCellValue("FAILED");
		sheet1.getRow(14).createCell(8).setCellValue("AccountID field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(14).createCell(9).setCellValue("PASSED");
		sheet1.getRow(14).createCell(8).setCellValue("AccountID field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(ActiveFlag));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(ActiveFlag))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ParentAgreementNumber
	 Boolean advSrchFilter3 = driver.findElements(By.linkText(String.valueOf(ActiveFlag))).size() >0;
	
	if ( ! advSrchFilter3)
	{
		sheet1.getRow(15).createCell(9).setCellValue("FAILED");
		sheet1.getRow(15).createCell(8).setCellValue("ActiveFlag field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(15).createCell(9).setCellValue("PASSED");
		sheet1.getRow(15).createCell(8).setCellValue("ActiveFlag field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Address));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Address))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Agreement_Type
	 Boolean advSrchFilter4 = driver.findElements(By.linkText(String.valueOf(Address))).size() >0;
			
	if ( ! advSrchFilter4)
	{
		sheet1.getRow(16).createCell(9).setCellValue("FAILED");
		sheet1.getRow(16).createCell(8).setCellValue("Address field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(16).createCell(9).setCellValue("PASSED");
		sheet1.getRow(16).createCell(8).setCellValue("Address field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Address2));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Address2))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter StartDate
	 Boolean advSrchFilter5 = driver.findElements(By.linkText(String.valueOf(Address2))).size() >0;
				
	if ( ! advSrchFilter5)
	{
		sheet1.getRow(17).createCell(9).setCellValue("FAILED");
		sheet1.getRow(17).createCell(8).setCellValue("Address2 field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(17).createCell(9).setCellValue("PASSED");
		sheet1.getRow(17).createCell(8).setCellValue("Address2 field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Agreement_End_Date));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Agreement_End_Date))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter EndDate
	 Boolean advSrchFilter6 = driver.findElements(By.linkText(String.valueOf(Agreement_End_Date))).size() >0;
				
	if ( ! advSrchFilter6)
	{
		sheet1.getRow(18).createCell(9).setCellValue("FAILED");
		sheet1.getRow(18).createCell(8).setCellValue("Agreement_End_Date field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(18).createCell(9).setCellValue("PASSED");
		sheet1.getRow(18).createCell(8).setCellValue("Agreement_End_Date field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Agreement_Start_Date));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Agreement_Start_Date))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementTypeID
	 Boolean advSrchFilter7 = driver.findElements(By.linkText(String.valueOf(Agreement_Start_Date))).size() >0;
				
	if ( ! advSrchFilter7)
	{
		sheet1.getRow(19).createCell(9).setCellValue("FAILED");
		sheet1.getRow(19).createCell(8).setCellValue("Agreement_Start_Date field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(19).createCell(9).setCellValue("PASSED");
		sheet1.getRow(19).createCell(8).setCellValue("Agreement_Start_Date field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Agreement_Type));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Agreement_Type))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter8 = driver.findElements(By.linkText(String.valueOf(Agreement_Type))).size() >0;
				
	if ( ! advSrchFilter8)
	{
		sheet1.getRow(20).createCell(9).setCellValue("FAILED");
		sheet1.getRow(20).createCell(8).setCellValue("Agreement_Type field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(20).createCell(9).setCellValue("PASSED");
		sheet1.getRow(20).createCell(8).setCellValue("Agreement_Type field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_customer")).clear();
		driver.findElement(By.id("drill_grid_customer")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(AgreementNumber));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(AgreementNumber))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Days_to_Expiration
		 Boolean advSrchFilter9 = driver.findElements(By.linkText(String.valueOf(AgreementNumber))).size() >0;
					
		if ( ! advSrchFilter9)
		{
			sheet1.getRow(21).createCell(9).setCellValue("FAILED");
			sheet1.getRow(21).createCell(8).setCellValue("AgreementNumber field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(21).createCell(9).setCellValue("PASSED");
			sheet1.getRow(21).createCell(8).setCellValue("AgreementNumber field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(AgreementTypeID));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(AgreementTypeID))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CF_License_Value
		 Boolean advSrchFilter10 = driver.findElements(By.linkText(String.valueOf(AgreementTypeID))).size() >0;
					
		if ( ! advSrchFilter10)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("AgreementTypeID field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("AgreementTypeID field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Brand));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Brand))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Estimated_CF_Agreement_Value
		 Boolean advSrchFilter11 = driver.findElements(By.linkText(String.valueOf(Brand))).size() >0;
					
		if ( ! advSrchFilter11)
		{
			sheet1.getRow(23).createCell(9).setCellValue("FAILED");
			sheet1.getRow(23).createCell(8).setCellValue("Brand field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(23).createCell(9).setCellValue("PASSED");
			sheet1.getRow(23).createCell(8).setCellValue("Brand field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(CFProgramLevelID));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CFProgramLevelID))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Annualized_CF_Agreement_Value
		 Boolean advSrchFilter12 = driver.findElements(By.linkText(String.valueOf(CFProgramLevelID))).size() >0;
					
		if ( ! advSrchFilter12)
		{
			sheet1.getRow(24).createCell(9).setCellValue("FAILED");
			sheet1.getRow(24).createCell(8).setCellValue("CFProgramLevelID field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(24).createCell(9).setCellValue("PASSED");
			sheet1.getRow(24).createCell(8).setCellValue("CFProgramLevelID field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(City));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(City))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CFProgramLevelID
		 Boolean advSrchFilter13 = driver.findElements(By.linkText(String.valueOf(City))).size() >0;
					
		if ( ! advSrchFilter13)
		{
			sheet1.getRow(25).createCell(9).setCellValue("FAILED");
			sheet1.getRow(25).createCell(8).setCellValue("City field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(25).createCell(9).setCellValue("PASSED");
			sheet1.getRow(25).createCell(8).setCellValue("City field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Country));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Country))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter TAMFlag
		 Boolean advSrchFilter14 = driver.findElements(By.linkText(String.valueOf(Country))).size() >0;
					
		if ( ! advSrchFilter14)
		{
			sheet1.getRow(26).createCell(9).setCellValue("FAILED");
			sheet1.getRow(26).createCell(8).setCellValue("Country field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(26).createCell(9).setCellValue("PASSED");
			sheet1.getRow(26).createCell(8).setCellValue("Country field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(CustomerSiteID));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CustomerSiteID))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Brand
		 Boolean advSrchFilter15 = driver.findElements(By.linkText(String.valueOf(CustomerSiteID))).size() >0;
					
		if ( ! advSrchFilter15)
		{
			sheet1.getRow(27).createCell(9).setCellValue("FAILED");
			sheet1.getRow(27).createCell(8).setCellValue("CustomerSiteID field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(27).createCell(9).setCellValue("PASSED");
			sheet1.getRow(27).createCell(8).setCellValue("CustomerSiteID field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(CustomerSiteName));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CustomerSiteName))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter ActiveFlag
		 Boolean advSrchFilter16 = driver.findElements(By.linkText(String.valueOf(CustomerSiteName))).size() >0;
					
		if ( ! advSrchFilter16)
		{
			sheet1.getRow(28).createCell(9).setCellValue("FAILED");
			sheet1.getRow(28).createCell(8).setCellValue("CustomerSiteName field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(28).createCell(9).setCellValue("PASSED");
			sheet1.getRow(28).createCell(8).setCellValue("CustomerSiteName field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(CustomerType));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CustomerType))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter DistributorID
		 Boolean advSrchFilter17 = driver.findElements(By.linkText(String.valueOf(CustomerType))).size() >0;
					
		if ( ! advSrchFilter17)
		{
			sheet1.getRow(29).createCell(9).setCellValue("FAILED");
			sheet1.getRow(29).createCell(8).setCellValue("CustomerType field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(29).createCell(9).setCellValue("PASSED");
			sheet1.getRow(29).createCell(8).setCellValue("CustomerType field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Days_to_Expiration));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Days_to_Expiration))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition Code
		 Boolean advSrchFilter18 = driver.findElements(By.linkText(String.valueOf(Days_to_Expiration))).size() >0;
					
		if ( ! advSrchFilter18)
		{
			sheet1.getRow(30).createCell(9).setCellValue("FAILED");
			sheet1.getRow(30).createCell(8).setCellValue("Days_to_Expiration field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(30).createCell(9).setCellValue("PASSED");
			sheet1.getRow(30).createCell(8).setCellValue("Days_to_Expiration field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(DistributorID));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(DistributorID))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition
		 Boolean advSrchFilter19 = driver.findElements(By.linkText(String.valueOf(DistributorID))).size() >0;
					
		if ( ! advSrchFilter19)
		{
			sheet1.getRow(31).createCell(9).setCellValue("FAILED");
			sheet1.getRow(31).createCell(8).setCellValue("DistributorID field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(31).createCell(9).setCellValue("PASSED");
			sheet1.getRow(31).createCell(8).setCellValue("DistributorID field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(DistributorName));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(DistributorName))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter category
		 Boolean advSrchFilter20 = driver.findElements(By.linkText(String.valueOf(DistributorName))).size() >0;
					
		if ( ! advSrchFilter20)
		{
			sheet1.getRow(32).createCell(9).setCellValue("FAILED");
			sheet1.getRow(32).createCell(8).setCellValue("DistributorName field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(32).createCell(9).setCellValue("PASSED");
			sheet1.getRow(32).createCell(8).setCellValue("DistributorName field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(MMI_Created_At_Date));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(MMI_Created_At_Date))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition_status
		 Boolean advSrchFilter21 = driver.findElements(By.linkText(String.valueOf(MMI_Created_At_Date))).size() >0;
					
		if ( ! advSrchFilter21)
		{
			sheet1.getRow(33).createCell(9).setCellValue("FAILED");
			sheet1.getRow(33).createCell(8).setCellValue("MMI_Created_At_Date field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(33).createCell(9).setCellValue("PASSED");
			sheet1.getRow(33).createCell(8).setCellValue("MMI_Created_At_Date field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(MMI_Updated_At_Date));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(MMI_Updated_At_Date))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CustomerType
		 Boolean advSrchFilter22 = driver.findElements(By.linkText(String.valueOf(MMI_Updated_At_Date))).size() >0;
					
		if ( ! advSrchFilter22)
		{
			sheet1.getRow(34).createCell(9).setCellValue("FAILED");
			sheet1.getRow(34).createCell(8).setCellValue("MMI_Updated_At_Date field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(34).createCell(9).setCellValue("PASSED");
			sheet1.getRow(34).createCell(8).setCellValue("MMI_Updated_At_Date field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(ParentAgreementNumber));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(ParentAgreementNumber))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Address
		 Boolean advSrchFilter23 = driver.findElements(By.linkText(String.valueOf(ParentAgreementNumber))).size() >0;
					
		if ( ! advSrchFilter23)
		{
			sheet1.getRow(35).createCell(9).setCellValue("FAILED");
			sheet1.getRow(35).createCell(8).setCellValue("ParentAgreementNumber field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(35).createCell(9).setCellValue("PASSED");
			sheet1.getRow(35).createCell(8).setCellValue("ParentAgreementNumber field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(PostalCode));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(PostalCode))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Address2
		 Boolean advSrchFilter24 = driver.findElements(By.linkText(String.valueOf(PostalCode))).size() >0;
					
		if ( ! advSrchFilter24)
		{
			sheet1.getRow(36).createCell(9).setCellValue("FAILED");
			sheet1.getRow(36).createCell(8).setCellValue("PostalCode field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(36).createCell(9).setCellValue("PASSED");
			sheet1.getRow(36).createCell(8).setCellValue("PostalCode field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Program_Level));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Program_Level))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter City
		 Boolean advSrchFilter25 = driver.findElements(By.linkText(String.valueOf(Program_Level))).size() >0;
					
		if ( ! advSrchFilter25)
		{
			sheet1.getRow(37).createCell(9).setCellValue("FAILED");
			sheet1.getRow(37).createCell(8).setCellValue("Program_Level field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(37).createCell(9).setCellValue("PASSED");
			sheet1.getRow(37).createCell(8).setCellValue("Program_Level field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(Region_of_Customer_Site));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Region_of_Customer_Site))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter StateProv
		 Boolean advSrchFilter26 = driver.findElements(By.linkText(String.valueOf(Region_of_Customer_Site))).size() >0;
					
		if ( ! advSrchFilter26)
		{
			sheet1.getRow(38).createCell(9).setCellValue("FAILED");
			sheet1.getRow(38).createCell(8).setCellValue("Region_of_Customer_Site field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(38).createCell(9).setCellValue("PASSED");
			sheet1.getRow(38).createCell(8).setCellValue("Region_of_Customer_Site field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_customer")).sendKeys(String.valueOf(StateProv));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(StateProv))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter PostalCode
		 Boolean advSrchFilter27 = driver.findElements(By.linkText(String.valueOf(StateProv))).size() >0;
					
		if ( ! advSrchFilter27)
		{
			sheet1.getRow(39).createCell(9).setCellValue("FAILED");
			sheet1.getRow(39).createCell(8).setCellValue("StateProv field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(39).createCell(9).setCellValue("PASSED");
			sheet1.getRow(39).createCell(8).setCellValue("StateProv field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_customer")).clear();
			driver.findElement(By.id("drill_grid_customer")).click();
			Thread.sleep(1000);
			
		}
		
		
	//Click the Agreement ID link filter
	Boolean closeButton = driver.findElements(By.xpath("//html/body/div[11]/div[1]/button")).size() >0;
	
	
	if ( ! closeButton)
	{
		
		sheet1.getRow(40).createCell(9).setCellValue("FAILED");
		sheet1.getRow(40).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(40).createCell(9).setCellValue("PASSED");
		sheet1.getRow(40).createCell(8).setCellValue("Close Advanced Search was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.xpath("//html/body/div[11]/div[1]/button")).click();
		Thread.sleep(3000);
	}
	
	//Click the Agreement ID link filter
	Boolean refreshButton = driver.findElements(By.id("refresh_grid_customer")).size() >0;
	
	
	if ( ! refreshButton)
	{
		
		sheet1.getRow(41).createCell(9).setCellValue("FAILED");
		sheet1.getRow(41).createCell(8).setCellValue("Grid was NOT Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(41).createCell(9).setCellValue("PASSED");
		sheet1.getRow(41).createCell(8).setCellValue("Grid was Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("refresh_grid_customer")).click();
		Thread.sleep(3000);
	}
			

		
	    wb.close();	
		//driver.quit();
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
	
	
	
