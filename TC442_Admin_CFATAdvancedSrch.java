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
	
	
public class TC442_Admin_CFATAdvancedSrch {
		
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
	XSSFSheet sheet1=wb.getSheet("TC442");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	String baseUrl ;
	String loginUrl; 
	String logoutUrl; 
	String testUsername;
	String testPassword ;
	
	
	String AccountName;
	String CFLevel;
	String CFParentID;
	String CFRate;
	String CommercialInformation;
	String MMI_Created_At_Date;
	String MMI_Updated_At_Date;
	String VPANumber;



	
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
	
	
	
	AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
	CFLevel = sheet1.getRow(4).getCell(10).getStringCellValue();
	CFParentID = sheet1.getRow(5).getCell(10).getStringCellValue();
	CFRate = sheet1.getRow(6).getCell(10).getStringCellValue();
	CommercialInformation = sheet1.getRow(7).getCell(10).getStringCellValue();
	MMI_Created_At_Date = sheet1.getRow(8).getCell(10).getStringCellValue();
	MMI_Updated_At_Date = sheet1.getRow(9).getCell(10).getStringCellValue();
	VPANumber = sheet1.getRow(10).getCell(10).getStringCellValue();


	
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
		Boolean agreementTab =  driver.findElements(By.id("submenulink_162")).size() >0;
				
		if( ! agreementTab)
		{
			//If the tab is not greater than "0", then show "failed"
			sheet1.getRow(9).createCell(9).setCellValue("FAILED");
			sheet1.getRow(9).createCell(8).setCellValue("Customer FIRST Account Tracking Tab Submenu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		
		}
		else
		{
			//If the tab is greater than "0", then show "passed"
			sheet1.getRow(9).createCell(9).setCellValue("PASSED");
			sheet1.getRow(9).createCell(8).setCellValue("Customer FIRST Account Tracking Tab Submenu was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("submenulink_162")).click();
			Thread.sleep(5000);
		}
	
	
	 //Find the clear search button and click
	if(driver.findElements(By.id("cancelMaingrid_cf_account_tracking_all")).size()>0) {
	 
		driver.findElement(By.id("cancelMaingrid_cf_account_tracking_all")).click();
		 Thread.sleep(5000);}
	
	 //Find the Advance search link
	 Boolean advSrch = driver.findElements(By.id("advSrch_grid_cf_account_tracking_all")).size() >0;
	
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
	    driver.findElement(By.id("advSrch_grid_cf_account_tracking_all")).click();
	    Thread.sleep(3000);
	}
	
	//Find the Advance search link and click the link
	 Boolean advSrch1 = driver.findElements(By.id("drill_grid_cf_account_tracking_all")).size() >0;
	
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
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(4000);
	}
	
	
	//Find the Advance search link and click the link
	 Boolean advSrchFilter = driver.findElements(By.id("drill_grid_cf_account_tracking_all")).size() >0;
	
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
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(2000);
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(AccountName));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(AccountName))).click();
	Thread.sleep(2000);
	
	
	
	//Find the Advance search filter box and Enter ID
	 Boolean advSrchFilter1 = driver.findElements(By.linkText(String.valueOf(AccountName))).size() >0;
		
	if ( ! advSrchFilter1)
	{
		sheet1.getRow(13).createCell(9).setCellValue("FAILED");
		sheet1.getRow(13).createCell(8).setCellValue("AccountName field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(13).createCell(9).setCellValue("PASSED");
		sheet1.getRow(13).createCell(8).setCellValue("AccountName field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(CFLevel));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(CFLevel))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter CustomerSiteID
	 Boolean advSrchFilter2 = driver.findElements(By.linkText(String.valueOf(CFLevel))).size() >0;
		
	if ( ! advSrchFilter2)
	{
		sheet1.getRow(14).createCell(9).setCellValue("FAILED");
		sheet1.getRow(14).createCell(8).setCellValue("CFLevel field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(14).createCell(9).setCellValue("PASSED");
		sheet1.getRow(14).createCell(8).setCellValue("CFLevel field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(CFParentID));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(CFParentID))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ParentAgreementNumber
	 Boolean advSrchFilter3 = driver.findElements(By.linkText(String.valueOf(CFParentID))).size() >0;
	
	if ( ! advSrchFilter3)
	{
		sheet1.getRow(15).createCell(9).setCellValue("FAILED");
		sheet1.getRow(15).createCell(8).setCellValue("CFParentID field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(15).createCell(9).setCellValue("PASSED");
		sheet1.getRow(15).createCell(8).setCellValue("CFParentID field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(CFRate));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(CFRate))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Agreement_Type
	 Boolean advSrchFilter4 = driver.findElements(By.linkText(String.valueOf(CFRate))).size() >0;
			
	if ( ! advSrchFilter4)
	{
		sheet1.getRow(16).createCell(9).setCellValue("FAILED");
		sheet1.getRow(16).createCell(8).setCellValue("CFRate field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(16).createCell(9).setCellValue("PASSED");
		sheet1.getRow(16).createCell(8).setCellValue("CFRate field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(CommercialInformation));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(CommercialInformation))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter StartDate
	 Boolean advSrchFilter5 = driver.findElements(By.linkText(String.valueOf(CommercialInformation))).size() >0;
				
	if ( ! advSrchFilter5)
	{
		sheet1.getRow(17).createCell(9).setCellValue("FAILED");
		sheet1.getRow(17).createCell(8).setCellValue("Commercial Information field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(17).createCell(9).setCellValue("PASSED");
		sheet1.getRow(17).createCell(8).setCellValue("Commercial Information field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(MMI_Created_At_Date));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(MMI_Created_At_Date))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter EndDate
	 Boolean advSrchFilter6 = driver.findElements(By.linkText(String.valueOf(MMI_Created_At_Date))).size() >0;
				
	if ( ! advSrchFilter6)
	{
		sheet1.getRow(18).createCell(9).setCellValue("FAILED");
		sheet1.getRow(18).createCell(8).setCellValue("MMI Created At Date field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(18).createCell(9).setCellValue("PASSED");
		sheet1.getRow(18).createCell(8).setCellValue("MMI Created At Date field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(MMI_Updated_At_Date));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(MMI_Updated_At_Date))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementTypeID
	 Boolean advSrchFilter7 = driver.findElements(By.linkText(String.valueOf(MMI_Updated_At_Date))).size() >0;
				
	if ( ! advSrchFilter7)
	{
		sheet1.getRow(19).createCell(9).setCellValue("FAILED");
		sheet1.getRow(19).createCell(8).setCellValue("MMI Updated At Date field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(19).createCell(9).setCellValue("PASSED");
		sheet1.getRow(19).createCell(8).setCellValue("MMI Updated At Date field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_cf_account_tracking_all")).sendKeys(String.valueOf(VPANumber));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(VPANumber))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter8 = driver.findElements(By.linkText(String.valueOf(VPANumber))).size() >0;
				
	if ( ! advSrchFilter8)
	{
		sheet1.getRow(20).createCell(9).setCellValue("FAILED");
		sheet1.getRow(20).createCell(8).setCellValue("VPA Number field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(20).createCell(9).setCellValue("PASSED");
		sheet1.getRow(20).createCell(8).setCellValue("VPA Number field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).clear();
		driver.findElement(By.id("drill_grid_cf_account_tracking_all")).click();
		Thread.sleep(1000);
		
	}
	
			
				
	//Click the Agreement ID link filter
	Boolean closeButton = driver.findElements(By.xpath("//html/body/div[10]/div[1]/button")).size() >0;
	
	
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
		driver.findElement(By.xpath("//html/body/div[10]/div[1]/button")).click();
		Thread.sleep(3000);
	}
	
	//Click the Agreement ID link filter
	Boolean refreshButton = driver.findElements(By.id("refresh_grid_cf_account_tracking_all")).size() >0;
	
	
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
		driver.findElement(By.id("refresh_grid_cf_account_tracking_all")).click();
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
	
	
	
