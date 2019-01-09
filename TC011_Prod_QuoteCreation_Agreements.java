package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;


public class TC011_Prod_QuoteCreation_Agreements {
	
	public Select selenium;
	public static WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/



//@Test(priority=0)
//public static void main1(String[] args) throws IOException, InterruptedException { 
	public static void captureScreenMethod() throws IOException, InterruptedException { }

//TC111
@SuppressWarnings("resource")
@Test(priority=1)
public  void TC111_SELogin_Agreement() throws Throwable {
	
	
	//public  void quoteFromAgreement() throws Throwable {
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC111");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
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
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			
			driver.get(logoutUrl);
			Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(2000);
			
			
			Boolean actualResult = driver.findElements(By.id("email")).size()>0; 
			
			if(! actualResult)
		          //login.click();
		          //Main Event is logged If Passed
		          {
				
				
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Username was NOT Input");
												
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
												
					}
			
			else 
					{
						sheet1.getRow(4).createCell(9).setCellValue("PASSED");
						sheet1.getRow(4).createCell(8).setCellValue("Username was Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("email")).clear();
						driver.findElement(By.id("email")).sendKeys(testUsername);
						Thread.sleep(2000);
					}

		//Actions actions = new Actions(driver);
		Boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
		if(! actualResult1)
	          //login.click();
	          //Main Event is logged If Passed
	          {
					sheet1.getRow(5).createCell(9).setCellValue("FAILED");
					sheet1.getRow(5).createCell(8).setCellValue("Password was NOT Input");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
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
		Thread.sleep(3000);
		if(! actualResult2)
	          //login.click();
	          //Main Event is logged If Passed
	          {
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("Login button NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
					
				}
		
		else 
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("login button was found and Clicked");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					
				}
			
			driver.findElement(By.id("Login")).click();
			Thread.sleep(20000);
			
			Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
				
			}
			else
			{
				sheet1.getRow(7).createCell(9).setCellValue("PASSED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was found");
				FileOutputStream fout=new FileOutputStream(src);
				driver.findElement(By.id("dashboard")).click();
				Thread.sleep(3000);
				wb.write(fout);
			}
			

					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
			
			
		
	   //wb.close();	
		driver.quit();
}   
	


//TC121
@SuppressWarnings("resource")
@Test(priority=2)

//public void main2(String[] args) throws IOException, InterruptedException { 
//public  void quoteFromAgreement() throws Throwable {
//public  void TC121_AgreementGiven() throws Throwable {
	public  void TC121_AgreementGiven() throws IOException, InterruptedException { 
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
	
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC121");
		//XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		//String agreementUrl ;
		int agreementId ;
		//int numRows ;
		String numPages;
		int pageCounter;
		
		String gridTitle = "agreement";

		
			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
	
//driver.findElement(By.id("password-text")).sendKeys(testPassword);
	
//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		  
			
			
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(5000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			
			//Assert.assertTrue(actualResult);
			if( ! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
				
			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(6000);
			 

			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			 //Check grid and identify page amount
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
			 
			 
			 //Clear Search
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(5000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				
				 
			 }
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
			 driver.findElement(By.id("advSrch_grid_agreement")).click();
			 Thread.sleep(4000);
			 driver.findElement(By.linkText("ID")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
			 Thread.sleep(3000);
		 
			//Click on search result for agreement ID
			Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementId))).size() >0;
			Thread.sleep(1000);
			
			if ( ! idSrchResult)
			{
			
				sheet1.getRow(6).createCell(9).setCellValue("FAILED");
				sheet1.getRow(6).createCell(8).setCellValue("'Agreement ID' was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
				
			}
			else
			{
				sheet1.getRow(6).createCell(9).setCellValue("PASSED");
				sheet1.getRow(6).createCell(8).setCellValue("'Agreement ID' was Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText(String.valueOf(agreementId))).click();
				Thread.sleep(2000);
				driver.findElement(By.id("rungrid_agreement")).click();
				Thread.sleep(2000);
			}
		 
			 
			  //Advanced search Simulation)
				Boolean findElementPage = false;
				pageCounter = 1;
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
				 {
					
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).size() >0;
					
					if(! findElementPage )
					{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
					}
				 }
				if ( ! findElementPage)
				{
				 
				   //Write in result file that element does not exists
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("No pages with AgreementID " + agreementId + " were not found in the system");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("Page with AgreementID " + agreementId + " found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
				}
				
				
				//Select the check box and click [Create Quote] button
				driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).click();
				Thread.sleep(3000);
				driver.findElement(By.id("create_quote")).click();
				Thread.sleep(3000);
				
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean IDSrch = driver.findElement(By.id("createDialogContinue")).isDisplayed();
				
				if ( ! IDSrch)
				{
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
					
				}
				
				driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(3000);
				
				Boolean continue1 = driver.findElement(By.id("ui-id-2")).isDisplayed();
				
				if (continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				
				Boolean confirmation1 = driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).isDisplayed();
				Thread.sleep(1000);
				if ( ! confirmation1)
				{
					
					
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("cancelMaingrid_agreement")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				Boolean confirmation2 = driver.findElement(By.id("content_pane")).isDisplayed();
				
				if ( ! confirmation2)
				{
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
	    //Refresh the grid and show all agreements
		Boolean confirmation3 = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
		
		if (!confirmation3)
		{
			sheet1.getRow(11).createCell(9).setCellValue("FAILED");
			sheet1.getRow(11).createCell(8).setCellValue("'Agreements Grid' was NOT Refreshed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
			
		}
		else
		{
			sheet1.getRow(11).createCell(9).setCellValue("PASSED");
			sheet1.getRow(11).createCell(8).setCellValue("'Agreements Grid' was Refreshed");
			FileOutputStream fout=new FileOutputStream(src);
			driver.findElement(By.id("refresh_grid_agreement")).click();
			Thread.sleep(3000);
			wb.write(fout);
			}
		
		//Click on the Installed Base tab
		Boolean InstallBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
		
		//Assert.assertTrue(actualResult);
		if( ! InstallBase)
		{
			//If the tab is not greater than "0", then show "failed"
			sheet1.getRow(14).createCell(9).setCellValue("FAILED");
			sheet1.getRow(14).createCell(8).setCellValue("Installed Base Tab Submenu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
						
		}
		else
		{
			//If the tab is greater than "0", then show "passed"
			sheet1.getRow(14).createCell(9).setCellValue("PASSED");
			sheet1.getRow(14).createCell(8).setCellValue("Installed Base lTab Submenu was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("topmenuitem_31")).click();
			Thread.sleep(7000);
		}
		
		//Click on the Quotes tab
		Boolean Quotes =  driver.findElements(By.id("submenulink_118")).size() >0;
		
		//Assert.assertTrue(actualResult);
		if( ! Quotes)
		{
			//If the tab is not greater than "0", then show "failed"
			sheet1.getRow(14).createCell(9).setCellValue("FAILED");
			sheet1.getRow(14).createCell(8).setCellValue("Quotes Tab Submenu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
						
		}
		else
		{
			//If the tab is greater than "0", then show "passed"
			sheet1.getRow(14).createCell(9).setCellValue("PASSED");
			sheet1.getRow(14).createCell(8).setCellValue("Quotes Tab Submenu was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("submenulink_118")).click();
			Thread.sleep(7000);
		}
		
		 //Find the Advance search link
		 Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
		
		if ( ! advSrch)
		{
			sheet1.getRow(15).createCell(9).setCellValue("FAILED");
			sheet1.getRow(15).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(15).createCell(9).setCellValue("PASSED");
			sheet1.getRow(15).createCell(8).setCellValue("'Advance Search Link' was Displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		    driver.findElement(By.id("advSrch_grid_agreement")).click();
		    Thread.sleep(3000);
		}
		
		//Find the Advance search link and click the link
		 Boolean advSrch1 = driver.findElements(By.id("drill_grid_agreement")).size() >0;
		
		if ( ! advSrch1)
		{
			sheet1.getRow(16).createCell(9).setCellValue("FAILED");
			sheet1.getRow(16).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(16).createCell(9).setCellValue("PASSED");
			sheet1.getRow(16).createCell(8).setCellValue("'Advance Search Link' was Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(4000);
		}
		

	
		 


















}
//TC122
@Test(priority=3)
public static void captureScreenMethod2() throws IOException, InterruptedException { }
@SuppressWarnings("resource")
public  void TC122_AgreementWithParent() throws Throwable {
//public void main3(String[] args) throws IOException, InterruptedException { 
			
			
			//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
	
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//driver=new FirefoxDriver();
			//driver=new ChromeDriver();
			//driver.manage().window().maximize();
//Thread.sleep(2000);
			
			//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
			File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
			//File src=new File("data\\SEAutoTesting.xlsx");
			
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//get sheet at index
			//XSSFSheet sheet1=wb.getSheetAt(1);  
			
			// Get sheet by name
			XSSFSheet sheet1=wb.getSheet("TC122");
			XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
			
			//String baseUrl ;
			//String loginUrl; 
			//String logoutUrl; 
			//String testUsername;
			//String testPassword ;
			int agreementId ;
			int pageCounter;
			//int agreementTypeId ;
			String numPages;
			String gridTitle = "agreement";
		
			sheet1.getLastRowNum();
			sheet2.getLastRowNum();

				//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
				//logoutUrl =baseUrl + "/auth/logout"; 
				//loginUrl =baseUrl + "/auth/login"; 
				//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
				//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				//agreementTypeId = (int) sheet1.getRow(1).getCell(4).getNumericCellValue();
				// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
				
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);
					//Actions actions = new Actions(driver);
//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

					//Click the Login button

//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
		
			   // agreementUrl = baseUrl + "/sf/" + gridTitle;
				// driver.get(agreementUrl);
			
				//Click on " Installed Base" tab 
				driver.findElement(By.id("topmenuitem_31")).click();  
				Thread.sleep(7000);
				
				//Click on the Agreements tab
				Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
				Thread.sleep(4000);
				
				//Assert.assertTrue(actualResult);
				if(! actualResult)
				{
					//If the tab is not greater than "0", then show "failed"
					sheet1.getRow(3).createCell(9).setCellValue("FAILED");
					sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();

				}
				else
				{
					//If the tab is greater than "0", then show "passed"
					sheet1.getRow(3).createCell(9).setCellValue("PASSED");
					sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("submenulink_129")).click();
					Thread.sleep(3000);
				}
				
				//Click on " Agreements" icon from sub-menu
				 
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
				 {	 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(4000);
				 }
					 
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 //Assert.assertNotEquals("0", numPages);
				 if(numPages.equals("0"))
					{
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(4).createCell(9).setCellValue("PASSED");
						sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
					}
						 
				 //Clear Search
					 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
					 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(4000);
					 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
					 FileOutputStream fout=new FileOutputStream(src);
					 wb.write(fout);
					 }
				else {
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
					 FileOutputStream fout=new FileOutputStream(src);
					 wb.write(fout);
					 
				 }
				 
				 //Find the Advance search link and click that link
					Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
					
					
					if ( ! advSrch)
					{
						sheet1.getRow(6).createCell(9).setCellValue("FAILED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(6).createCell(9).setCellValue("PASSED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("advSrch_grid_agreement")).click();
						Thread.sleep(2000);
						}
					
					//Find the ID filter button link and click that link
					Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
					
					
					if ( ! idButton)
					{
						
						sheet1.getRow(7).createCell(9).setCellValue("FAILED");
						sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(7).createCell(9).setCellValue("PASSED");
						sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText("ID")).click();
						Thread.sleep(3000);
						}
					
					//Find the ID search filter box and click that in that box
					Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
					Thread.sleep(3000);
					
					if ( ! idSrch)
					{
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
						sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(8).createCell(9).setCellValue("PASSED");
						sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
						}
			
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
					Thread.sleep(7000);
					
					Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementId))).size() >0;
					
					if ( ! idSrchResult)
					{
					
						sheet1.getRow(9).createCell(9).setCellValue("FAILED");
						sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(9).createCell(9).setCellValue("PASSED");
						sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText(String.valueOf(agreementId))).click();
						Thread.sleep(2000);
						}
					
					Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
					
					if ( ! idRunSrch)
					{
						
						sheet1.getRow(10).createCell(9).setCellValue("FAILED");
						sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					
					}
					else
					{
						sheet1.getRow(10).createCell(9).setCellValue("PASSED");
						sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("rungrid_agreement")).click();
						Thread.sleep(3000);
						}
					
					//Search agreement grid for agreement Id
					Boolean findElementPage = false;
					pageCounter = 1;
					
					agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
					while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
						
					{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).size() >0;
					
					
					if( ! findElementPage )
					{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
						pageCounter++;
						Thread.sleep(3000);
					}
					}
					if ( findElementPage ) {
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).click();
					Thread.sleep(3000);}
					
					//Click [Create Quote] button
					Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
				 
					if ( ! CreateQuote)
					{
						
						sheet1.getRow(11).createCell(9).setCellValue("FAILED");
						sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(11).createCell(9).setCellValue("PASSED");
						sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("create_quote")).click();
						Thread.sleep(3000);
						}
					
					Boolean ParentAgreement = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
					if ( ! ParentAgreement)
					{
						
						sheet1.getRow(12).createCell(9).setCellValue("FAILED");
						sheet1.getRow(12).createCell(8).setCellValue("'Parent Agreement' was NOT Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(12).createCell(9).setCellValue("PASSED");
						sheet1.getRow(12).createCell(8).setCellValue("'Parent Agreement' was Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".parent_checkbox")).click();
						Thread.sleep(3000);
						}
					
					//Boolean for quote confirmation pop up must be true otherwise fail
					Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
					
					if ( ! confirmation)
					{
						
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("Confirmation page is Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						Thread.sleep(3000);
						
					}
					
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
					
					//Click the "OK" button on the email confirmation page
					Boolean continue1 = driver.findElements(By.id("ui-id-6")).size() >0;
					
					if ( ! continue1)
					{	driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(2000);}
					
					//
					Boolean confirmation1 = driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).isDisplayed();
					Thread.sleep(1000);
					if ( ! confirmation1)
					{
					
						sheet1.getRow(14).createCell(9).setCellValue("FAILED");
						sheet1.getRow(14).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(14).createCell(9).setCellValue("PASSED");
						sheet1.getRow(14).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						}
					
					driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(3000);
					
					//Refresh the agreement grid after quote creation
					Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
					
					if ( ! confirmation2)
					{
				
						sheet1.getRow(15).createCell(9).setCellValue("FAILED");
						sheet1.getRow(15).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(15).createCell(9).setCellValue("PASSED");
						sheet1.getRow(15).createCell(8).setCellValue("'Agreements Grid' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						}
					
					//wb.close();	
					driver.quit();
	
		}	



//TC123
@SuppressWarnings("resource")
@Test(priority=4)
public  void TC123_AgreementWithTypeId12() throws Throwable {
			
		//public static void main4(String[] args) throws IOException, InterruptedException { 
			
			//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
			//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
			
			//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
			File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
			//File src=new File("data\\SEAutoTesting.xlsx");
			
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//get sheet at index
			//XSSFSheet sheet1=wb.getSheetAt(1);  
			
			// Get sheet by name
			XSSFSheet sheet1=wb.getSheet("TC123");
			XSSFSheet sheet2=wb.getSheet("SC1_DATA");
			
		
			
			//String baseUrl ;
			//String loginUrl; 
			//String logoutUrl; 
			//String testUsername;
			//String testPassword ;
			int agreementId ;
			int agreementTypeId ;
			int pageCounter;
			String numPages;
			String gridTitle = "agreement";
		
			sheet1.getLastRowNum();
			sheet2.getLastRowNum();

				//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
				//logoutUrl =baseUrl + "/auth/logout"; 
				//loginUrl =baseUrl + "/auth/login"; 
				//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
				//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				agreementTypeId = (int) sheet1.getRow(1).getCell(4).getNumericCellValue();
				// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();

//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);
					//Actions actions = new Actions(driver);
//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

				//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
						
			   // agreementUrl = baseUrl + "/sf/" + gridTitle;
				// driver.get(agreementUrl);
			
				//Click on " Installed Base" tab 
				driver.findElement(By.id("topmenuitem_31")).click();  
				Thread.sleep(7000);
				
				//Click on the Agreements tab
				Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
				Thread.sleep(5000);
				
				//Assert.assertTrue(actualResult);
				if(! actualResult)
				{
					//If the tab is not greater than "0", then show "failed"
					sheet1.getRow(3).createCell(9).setCellValue("FAILED");
					sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();

				}
				else
				{
					//If the tab is greater than "0", then show "passed"
					sheet1.getRow(3).createCell(9).setCellValue("PASSED");
					sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				//Click on " Agreements" icon from sub-menu
				 driver.findElement(By.id("submenulink_129")).click();
				 Thread.sleep(3000);
				 

				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
					 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(3000); }
				 
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 //Assert.assertNotEquals("0", numPages);
				 if(numPages.equals("0"))
					{
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
					}
					else
					{
						sheet1.getRow(4).createCell(9).setCellValue("PASSED");
						sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
					}
						 
				 //Clear any existing saved Searches
				 
					 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
					 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(3000);
					 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
					 FileOutputStream fout=new FileOutputStream(src);
					 wb.write(fout);
					 }
				else {
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
					 FileOutputStream fout=new FileOutputStream(src);
					 wb.write(fout);
					 
				 }
				 
					//Find the Advance search link and click that link
					Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
					
					if ( ! advSrch)
					{
						sheet1.getRow(6).createCell(9).setCellValue("FAILED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(6).createCell(9).setCellValue("PASSED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("advSrch_grid_agreement")).click();
						}
					
							//driver.findElement(By.id("drill_grid_agreement")).clear();
							//Thread.sleep(1000);
							//driver.findElement(By.id("drill_grid_agreement")).click();
							//Thread.sleep(1000);
							//driver.findElement(By.id("drill_grid_agreement")).sendKeys("ID");
							//Thread.sleep(2000);
							driver.findElement(By.linkText("ID")).click();
							Thread.sleep(1000);
								
					//Find the ID filter button link and click that link
					
					Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
					Thread.sleep(3000);
					
					if ( ! idButton)
					{
						
						sheet1.getRow(7).createCell(9).setCellValue("FAILED");
						sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(7).createCell(9).setCellValue("PASSED");
						sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText("ID")).click();
						Thread.sleep(2000);
						}
					
					//Find the ID search filter box and click that in that box
					Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
					Thread.sleep(3000);
					
					if ( ! idSrch)
					{
						sheet1.getRow(8).createCell(9).setCellValue("FAILED");
						sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(8).createCell(9).setCellValue("PASSED");
						sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
						}
			
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
					Thread.sleep(5000);
					
					driver.findElement(By.linkText(String.valueOf(agreementId))).click();
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
					Thread.sleep(2000);
					
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					Thread.sleep(2000);
					
					//Find the Agreement Type ID filter button link and click that link
					Boolean AgreeTypeIdButton = driver.findElements(By.linkText("AgreementTypeID")).size() >0;
					Thread.sleep(3000);
					
					if ( ! AgreeTypeIdButton)
					{
						
						sheet1.getRow(9).createCell(9).setCellValue("FAILED");
						sheet1.getRow(9).createCell(8).setCellValue("'AgreementType ID' Button was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(9).createCell(9).setCellValue("PASSED");
						sheet1.getRow(9).createCell(8).setCellValue("AgreementType ID' Button was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText("AgreementTypeID")).click();
						Thread.sleep(2000);
						}
					
					//Find the ID search filter box and click that in that box
					Boolean AgreeTypeIdSrch = driver.findElements(By.id("ignore_agreement_view_AgreementTypeID_1_1")).size() >0;
					Thread.sleep(2000);
					
					if ( ! AgreeTypeIdSrch)
					{
						sheet1.getRow(10).createCell(9).setCellValue("FAILED");
						sheet1.getRow(10).createCell(8).setCellValue("AgreementType ID was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(10).createCell(9).setCellValue("PASSED");
						sheet1.getRow(10).createCell(8).setCellValue("AgreementType ID was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ignore_agreement_view_AgreementTypeID_1_1")).click();
						Thread.sleep(2000);
						}
			
					driver.findElement(By.id("ignore_agreement_view_AgreementTypeID_1_1")).sendKeys(String.valueOf(agreementTypeId));
					Thread.sleep(4000);
					
					//Click on the agreement type ID search result
					Boolean AgreeTypeIdSrchResult = driver.findElements(By.linkText(String.valueOf(agreementTypeId))).size() >0;
					Thread.sleep(2000);
					
					if ( ! AgreeTypeIdSrchResult)
					{
					
						sheet1.getRow(11).createCell(9).setCellValue("FAILED");
						sheet1.getRow(11).createCell(8).setCellValue("'AgreementType ID' was NOT Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(11).createCell(9).setCellValue("PASSED");
						sheet1.getRow(11).createCell(8).setCellValue("'AgreementType ID' was Found and Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText(String.valueOf(agreementTypeId))).click();
						Thread.sleep(2000);
						}
				
					//Click the Run button
					Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
					
					if (!idRunSrch)
					{
						
						sheet1.getRow(12).createCell(9).setCellValue("FAILED");
						sheet1.getRow(12).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					
					}
					else
					{
						sheet1.getRow(12).createCell(9).setCellValue("PASSED");
						sheet1.getRow(12).createCell(8).setCellValue("'Run Search' was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("rungrid_agreement")).click();
						//driver.findElement(By.xpath("//*[@id='rungrid_agreement']")).click();
						Thread.sleep(3000);
						}
				
					
					//Find given agreement ID from results
					Boolean findElementPage = false;
					pageCounter = 1;
					
					agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
					while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
						
					{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).size() >0;
					
					
					if( ! findElementPage )
					{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
						pageCounter++;
						Thread.sleep(3000);
					}
					}
					if ( findElementPage ) {
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).click();
					Thread.sleep(3000);}
					
					//Click [Create Quote] button
					Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
				
					if ( ! CreateQuote)
					{
						
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("'Create Quote' was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("create_quote")).click();
						Thread.sleep(3000);
						}
					
					//Select the Parent checkbox for quote
					Boolean ParentAgreement = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
					if ( ! ParentAgreement)
					{
						
						sheet1.getRow(14).createCell(9).setCellValue("FAILED");
						sheet1.getRow(14).createCell(8).setCellValue("'Parent Agreement' was NOT Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(14).createCell(9).setCellValue("PASSED");
						sheet1.getRow(14).createCell(8).setCellValue("'Parent Agreement' was Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".parent_checkbox")).click();
						Thread.sleep(3000);
						driver.findElement(By.id("createDialogContinue")).click();
						Thread.sleep(3000);
						}
					
					//Boolean for quote confirmation pop up must be true otherwise fail
					//Find Cancel button and click. Agreement grid should be displayed
					Boolean confirmation = driver.findElements(By.cssSelector("p.alert")).size() >0;
					//confirmation = (driver.findElement(By.id("createDialogContinue")).isDisplayed());
					
					if ( ! confirmation)
					{					
						sheet1.getRow(15).createCell(9).setCellValue("FAILED");
						sheet1.getRow(15).createCell(8).setCellValue("Confirmation page with ERROR was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(15).createCell(9).setCellValue("PASSED");
						sheet1.getRow(15).createCell(8).setCellValue("Confirmation page with ERROR is Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.xpath("//html/body/div[9]/div[3]/div/button[1]")).click();
						Thread.sleep(3000);
					}
					
					//Clear search and refresh grid
						driver.findElement(By.id("cancelMaingrid_agreement")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("refresh_grid_agreement")).click();
						Thread.sleep(2000);
					
					//Find Agreement grid and display
					Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
					
					if ( ! confirmation2)
					{
				
						sheet1.getRow(16).createCell(9).setCellValue("FAILED");
						sheet1.getRow(16).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(16).createCell(9).setCellValue("PASSED");
						sheet1.getRow(16).createCell(8).setCellValue("'Agreements Grid' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						}
					
					//wb.close();	
driver.quit();
					}	

//TC124
@SuppressWarnings("resource")
@Test(priority=5)
public  void TC124_AgreementWithTerm() throws Throwable {
			
//public static void main(String[] args) throws IOException, InterruptedException { 
			
			//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
			//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
			
			//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
			File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
			//File src=new File("data\\SEAutoTesting.xlsx");
			
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//get sheet at index
			//XSSFSheet sheet1=wb.getSheetAt(1);  
			
			// Get sheet by name
			XSSFSheet sheet1=wb.getSheet("TC124");
			XSSFSheet sheet2=wb.getSheet("SC1_DATA");
			
					
			//String baseUrl ;
			//String loginUrl; 
			//String logoutUrl; 
			//String testUsername;
			//String testPassword ;
			int agreementId ;
			//int agreementTypeId ;
			//int agreementTermId;
			int daysToExpire;
			int pageCounter;
			String numPages;
			String gridTitle = "agreement";
		
			sheet1.getLastRowNum();
			sheet2.getLastRowNum();
			//sheet3.getLastRowNum();

				//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
				//logoutUrl =baseUrl + "/auth/logout"; 
				//loginUrl =baseUrl + "/auth/login"; 
				//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
				//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				//agreementTypeId = (int) sheet1.getRow(1).getCell(4).getNumericCellValue();
				//agreementTermId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				daysToExpire = (int) sheet1.getRow(1).getCell(5).getNumericCellValue();
				// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
				
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
						
			   // agreementUrl = baseUrl + "/sf/" + gridTitle;
				// driver.get(agreementUrl);
				
				//Click on " Installed Base" tab 
				driver.findElement(By.id("topmenuitem_31")).click();  
				Thread.sleep(6000);
				
				//Click on the Agreements tab
				Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
				Thread.sleep(5000);
				
				if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
					 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(3000); }
				
				//Assert.assertTrue(actualResult);
				if(! actualResult)
				{
					//If the tab is not greater than "0", then show "failed"
					sheet1.getRow(3).createCell(9).setCellValue("FAILED");
					sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					//If the tab is greater than "0", then show "passed"
					sheet1.getRow(3).createCell(9).setCellValue("PASSED");
					sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				//Click on " Agreements" icon from sub-menu
				 driver.findElement(By.id("submenulink_129")).click();
				 Thread.sleep(3000);
				 
				//Clear grid 
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
				 {				 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(3000);
				 }
				 
				 //Identify pages amount on grid
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 //Assert.assertNotEquals("0", numPages);
				 if(numPages.equals("0"))
					{
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
					}
					else
					{
						sheet1.getRow(4).createCell(9).setCellValue("PASSED");
						sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
					}
						 
				 //Clear any existing saved Searches
				 
					 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
					 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(3000);
					 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
					 FileOutputStream fout=new FileOutputStream(src);
					 wb.write(fout);
					 }
				else {
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
					 FileOutputStream fout=new FileOutputStream(src);
					 wb.write(fout);
					 
				 }
				 
					//Find the Advance search link and click that link
					Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
					
					if ( ! advSrch)
					{
						sheet1.getRow(6).createCell(9).setCellValue("FAILED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(6).createCell(9).setCellValue("PASSED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("advSrch_grid_agreement")).click();
						}
					
					//Find the Agreement Type ID filter button link and click that link
					Boolean DaysToExpireButton = driver.findElements(By.linkText("Days_to_Expiration")).size() >0;
					Thread.sleep(3000);
					
					if ( ! DaysToExpireButton)
					{
						
						sheet1.getRow(7).createCell(9).setCellValue("FAILED");
						sheet1.getRow(7).createCell(8).setCellValue("'Days to Expiration' Button was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(7).createCell(9).setCellValue("PASSED");
						sheet1.getRow(7).createCell(8).setCellValue("Days to Expiration' Button was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						
						}
					driver.findElement(By.linkText("Days_to_Expiration")).click();
					Thread.sleep(3000);
					
					new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Greater Than or Equal");
					
					//Find the ID search filter box and click that in that box
					Boolean DaysToExpireSrch = driver.findElements(By.id("agreement_view_Days_to_Expiration_1_1")).size() >0;
					Thread.sleep(3000);
					
					if ( ! DaysToExpireSrch)
					{
						sheet1.getRow(8).createCell(9).setCellValue("FAILED");
						sheet1.getRow(8).createCell(8).setCellValue("Days to Expire was not Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(8).createCell(9).setCellValue("PASSED");
						sheet1.getRow(8).createCell(8).setCellValue("Days to Expire was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("agreement_view_Days_to_Expiration_1_1")).click();
						}
					
					//Search for Agreement ID with term more than 1 year
					driver.findElement(By.id("agreement_view_Days_to_Expiration_1_1")).sendKeys(String.valueOf(daysToExpire));
					Thread.sleep(4000);
					driver.findElement(By.id("addConditiongrid_agreement")).click();
					Thread.sleep(3000);
					
					//Find search result and click
					Boolean AgreeTermIdSrchResult = driver.findElements(By.id("rungrid_agreement")).size() >0;
					
					if ( ! AgreeTermIdSrchResult)
					{
					
						sheet1.getRow(9).createCell(9).setCellValue("FAILED");
						sheet1.getRow(9).createCell(8).setCellValue("'Agreement search' was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(9).createCell(9).setCellValue("PASSED");
						sheet1.getRow(9).createCell(8).setCellValue("'Agreement search' was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("rungrid_agreement")).click();
						Thread.sleep(5000);
						}
					
					//Find given agreement ID from results of terms for 1 year
					Boolean findElementPage = true;
					pageCounter = 1;
					
					agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
					while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
						
					{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).size() >0;
					
					
					if( ! findElementPage )
					{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
						pageCounter++;
						Thread.sleep(3000);
					}
					}
					if ( ! findElementPage)
					{
					   //Write in result file that element does not exists
						sheet1.getRow(10).createCell(9).setCellValue("FAILED");
						sheet1.getRow(10).createCell(8).setCellValue("No pages with AgreementID " + agreementId + " were not found in the system");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout); 
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(10).createCell(9).setCellValue("PASSED");
						sheet1.getRow(10).createCell(8).setCellValue("Page with AgreementID " + agreementId + " found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout); 
						driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).click();
						Thread.sleep(3000);
					}
					
					
					//Select the check box and click [Create Quote] button
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
					
					
					//Click continue on the quote confirmation box
					Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
					
					if ( ! confirmation)
					{
						sheet1.getRow(11).createCell(9).setCellValue("FAILED");
						sheet1.getRow(11).createCell(8).setCellValue("Confirmation page was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(11).createCell(9).setCellValue("PASSED");
						sheet1.getRow(11).createCell(8).setCellValue("Confirmation page is Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("createDialogContinue")).click();
						Thread.sleep(3000);
						
					}
					
					
					//If "p.alert" warning is given, click continue again
					Boolean continue1 = driver.findElements(By.id("createDialogContinue")).size() >0;
					
					if (continue1)
					{	driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(2000);}
					
					//Click "OK" on the email confirmation pop up page
					Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[12]/div[3]/div/button")).size() >0;
					Thread.sleep(1000);
					if (!confirmation1)
					{
					
						sheet1.getRow(12).createCell(9).setCellValue("FAILED");
						sheet1.getRow(12).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					
					else
					{
						sheet1.getRow(12).createCell(9).setCellValue("PASSED");
						sheet1.getRow(12).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						}
					
					driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(3000);
					
					//Refresh the grid and show all agreements
					Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
					
					if (!confirmation2)
					{
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("'Agreements Grid' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						driver.findElement(By.id("refresh_grid_agreement")).click();
						Thread.sleep(3000);
						wb.write(fout);
						}
					
		    //wb.close();	
driver.quit();
		}	

//TC125
@SuppressWarnings("resource")
@Test(priority=6)
public  void TC125_AgreementFromDetailPage() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC125");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
				
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int agreementDetailsId ;
		//int agreementTypeId ;
		String numPages;
		int pageCounter;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementDetailsId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();

//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

			//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(7000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			{
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(3000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			 
			//Identify pages amount on grid
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 //Clear Search
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 }
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
			 //Find the Andvance search link and click that link
				Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
				
				if (!advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					}
				
				//Find the ID filter button link and click that link
				Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				Thread.sleep(3000);
				
				if (!idButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					}
				
				//Find the ID search filter box and click that in that box
				new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Contains");
				
				Boolean idSrch = driver.findElements(By.id("agreement_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if (!idSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("agreement_view_id_1_1")).click();
					}
		
				driver.findElement(By.id("agreement_view_id_1_1")).sendKeys(String.valueOf(agreementDetailsId));
				Thread.sleep(7000);
				
				//Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementDetailsId))).size() >0;
				Boolean idSrchResult = driver.findElements(By.id("addConditiongrid_agreement")).size() >0;
				
				if (!idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_agreement")).click();
					Thread.sleep(2000);
					}
				//Run the filtered search
				Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(3000);
					}
				
				//Select the check box and click [Create Quote] button
				Boolean findElementPage = false;
				pageCounter = 1;
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementDetailsId))).size() >0;
				
				
				if( ! findElementPage )
				{
					driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					pageCounter++;
					Thread.sleep(3000);
				}
				}
				if( findElementPage )
				{				
				//Select the check box 
				driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementDetailsId))).click();
				Thread.sleep(3000);
				}
							
				//Click one the view icon on the grid line
				Boolean QuoteDetailsButton = driver.findElements(By.id("view" + String.valueOf(agreementDetailsId))).size() >0;
				
				
				if ( ! QuoteDetailsButton)
				{
					
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Quote Details' were NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Quote Details' were Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("view" + String.valueOf(agreementDetailsId))).click();
					Thread.sleep(3000);
					}
				
				//Click the Create Quote button
				Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
			
				if ( ! CreateQuote)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
					}
				
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
				}
				
				driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(3000);
				
				//Click on the continue button on the Parent Agreement page
				Boolean continue1 = driver.findElement(By.id("createDialogContinue")).isDisplayed();
				
				if (continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				//Click the "OK" button on the confirmation page
				Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[13]/div[3]/div/button")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.xpath("//html/body/div[13]/div[3]/div/button")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("submenulink_129")).click();  
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
driver.quit();
		
		
	}	
	

//TC126
@SuppressWarnings("resource")
@Test(priority=7)
public  void TC126_AgreementDispositionLost() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC126");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
				
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int agreementDispositionId ;
		//int agreementTypeId ;
		int pageCounter;
		String numPages;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementDispositionId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

			//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(7000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(3000);
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 //Clear Search
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 }
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
			 //Find the Advance search link and click that link
				Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size()>0;
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					Thread.sleep(2000);
			
					}
				
				//Find the ID search filter box and click that in that box
				Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					Thread.sleep(2000);
					}
		
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementDispositionId));
				Thread.sleep(10000);
				
				//Locate the agreement id in the grid and click the check box
				Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementDispositionId))).size() >0;
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementDispositionId))).click();
					Thread.sleep(2000);
					}
				
				//Click on the Run button for the filtered condition
				Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(3000);
					}
				
				//Search the grid and find the agreement ID
				Boolean findElementPage = false;
				pageCounter = 1;
				
				agreementDispositionId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementDispositionId))).size() >0;
					
				
				if( ! findElementPage )
				{
				driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
			    pageCounter++;
				Thread.sleep(3000);
				}
				}
				
				if( findElementPage )
				{				
				//Select the check box 
				driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementDispositionId))).click();
				Thread.sleep(3000);
				}
				
				//Click [Create Quote] button
				Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
			
				if ( ! CreateQuote)
				{
					
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
					}
				
			
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
					
				}
				
				//If "p.alert" warning is given, click continue again
				Boolean continue1 = driver.findElement(By.id("createDialogContinue")).isDisplayed();
				
				if (continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				//Click "OK" on the email confirmation pop up page
				Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[12]/div[3]/div/button")).size() >0;
				Thread.sleep(1000);
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(2000);
					}
				
				//wb.close();	
driver.quit();
		}	

//TC127
@SuppressWarnings("resource")
@Test(priority=8)
public  void TC127_AgreementWithReFees() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC127");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
				
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int agreementReFeesId ;
		//int agreementTypeId ;
		int pageCounter;
		String numPages;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementReFeesId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

///driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

			//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(3000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			{
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(3000);
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			//Identify pages amount on grid
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 //Clear Search
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
				 
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 }
				 
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
			 //Find the Advance search link and click that link
				Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size()>0;
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID search filter box and click that in that box
				Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					Thread.sleep(2000);
					}
		
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementReFeesId));
				Thread.sleep(10000);
				
				//Locate the agreement id in the grid and click the check box
				Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementReFeesId))).size() >0;
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementReFeesId))).click();
					Thread.sleep(2000);
					}
				
				//Click on the Run button for the filtered condition
				Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(3000);
					}
				
				//Search the grid and find the agreement ID
				Boolean findElementPage = false;
				pageCounter = 1;
				
				agreementReFeesId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementReFeesId))).size() >0;
					
				
				if( ! findElementPage )
				{
				driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
			    pageCounter++;
				Thread.sleep(3000);
				}
				}
				
				if( findElementPage )
				{				
				//Select the check box 
				driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementReFeesId))).click();
				Thread.sleep(3000);
				}
				
				//Click [Create Quote] button
				Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
			
				if ( ! CreateQuote)
				{
					
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
					}
				
			
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
				}
				
				//If "p.alert" warning is given, click continue again
				Boolean continue1 = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if (continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				//Click "OK" on the email confirmation pop up page
				Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[12]/div[3]/div/button")).size() >0;
				Thread.sleep(1000);
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
					Thread.sleep(3000);
					}
			
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
driver.quit();
		}	

//TC128
@SuppressWarnings("resource")
@Test(priority=9)
public  void TC128_AgreementIsInactive() throws Throwable {
		//TO DO Auto-generated method stub
//public static void main(String[] args) throws IOException, InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC128");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
				
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int agreementInactiveId ;
		//int agreementTypeId ;
		int pageCounter;
		String numPages;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementInactiveId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();

//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

			//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(3000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			{
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(3000);
			 
			//Identify pages amount on grid
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 //Clear Search
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
				 
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 }
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
			 //Find the Advance search link and click that link
				Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size()>0;
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					}
				
				//Find the ID filter button link and click that link
				//Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
			
					driver.findElement(By.linkText("ID")).click();
					Thread.sleep(2000);
					
				
				//Find the ID search filter box and click that in that box
				Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idSrch)
				{
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					}
		
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementInactiveId));
				Thread.sleep(10000);
				
				//Search result for agreement Id will be selected
				Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementInactiveId))).size() >0;
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementInactiveId))).click();
					}
				
				//Run search selection
				Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(3000);
					}
				
				//Search the grid and find the agreement ID
				Boolean findElementPage = false;
				pageCounter = 1;
				
				agreementInactiveId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementInactiveId))).size() >0;
				
				
				if( ! findElementPage )
				{
				driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
			    pageCounter++;
				Thread.sleep(3000);
				}
				}
				
				if( findElementPage )
				{				
				//Select the check box and click [Create Quote] button
				driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementInactiveId))).click();
				Thread.sleep(3000);
				}
				
				//driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementInactiveId))).click();
				//Thread.sleep(3000);
				
				//Click on the create quote button to create the quote
				Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
			
				if ( ! CreateQuote)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
					}
				
			
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("Parent Agreement page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("Parent Agreement page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
					
				}
				
				//Select the "OK" button on the email confirmation pop up page
				Boolean confirmation1 = driver.findElements(By.cssSelector("p.alert > strong:nth-child(2)")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'Agreement is Inactive' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'Agreement is Inactive' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.xpath("//html/body/div[9]/div[3]/div/button[1]")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
driver.quit();
		}	

//TC129
@SuppressWarnings("resource")
@Test(priority=10)
public  void TC129_AgreementParentCurrent() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC129");
		XSSFSheet sheet2=wb.getSheet("All_TC_Results");
		
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int agreementParentCurrentId ;
		//int agreementTypeId ;
		String numPages;
		int pageCounter;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementParentCurrentId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(4000);
//driver.findElement(By.id("email")).clear();
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

			//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(7000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			{
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(3000);
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 //Clear Search
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 }
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
			 //Find the Andvance search link and click that link
				 
				
			Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
			Thread.sleep(1000);
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				Thread.sleep(1000);
				
				if ( ! idButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					Thread.sleep(2000);
					}
				
				//new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Starts with");
				
				//Find the ID search filter box and click that in that box
				Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size()>0;
				Thread.sleep(3000);
				
				if ( ! idSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					Thread.sleep(2000);
					}
		
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementParentCurrentId));
				Thread.sleep(6000);
				
				
				//Click on search result for agreement ID
				Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementParentCurrentId))).size() >0;
				Thread.sleep(1000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementParentCurrentId))).click();
					Thread.sleep(2000);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(4000);
				}
				
				
				
				//Run the filtered search
				Boolean idRunSrch = driver.findElements(By.id("content_pane")).size()>0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(2000);
					}
				
				//Select the check box and click [Create Quote] button
				//driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementParentCurrentId))).click();
				//Search and Find Agreement ID within the Grid
				Boolean findElementPage = false;
				pageCounter = 1;
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementParentCurrentId))).size() >0;
				
				if(! findElementPage )
				{
					driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					pageCounter++;
					Thread.sleep(3000);
				}
				}
				
				driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementParentCurrentId))).click();
				Thread.sleep(2000);
				driver.findElement(By.id("create_quote")).click();
				Thread.sleep(2000);
				
				//Click on the Create Quote button
				//Boolean CreateQuote = driver.findElements(By.id("create_quote")).size()>0;
				Boolean CreateQuote = driver.findElements(By.id("ui-id-2")).size()>0;
			
				if (!CreateQuote)
				{
					
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//driver.findElement(By.id("create_quote")).click();
					Thread.sleep(2000);
					}
				
				//driver.findElement(By.id("" + String.valueOf(agreementParentCurrentId))).click();
				driver.findElement(By.cssSelector(".parent_checkbox")).click();
				Thread.sleep(2000);
		
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElements(By.id("createDialogContinue")).size()>0;
				
				if (!confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Agreement page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Agreement page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
				}
				
				//Click on the continue button on the Parent Agreement page
				Boolean continue1 = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if (continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
		
				//Click the "OK" button on the email confirmation page
				Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[12]/div[3]/div/button")).size() >0;
				
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Email Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("'Email Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
				//driver.findElement(By.tagName("button")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					sheet2.getRow(3).createCell(4).setCellValue("PASSED");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
driver.quit();
		
}	
		
	
public void quoteFromAgreementWithParent() throws Throwable	{
	
}

@AfterMethod
public void screenShot(ITestResult result){
	 
	 if(ITestResult.FAILURE==result.getStatus()){
	 try{
	
	 TakesScreenshot screenshot=(TakesScreenshot)driver;
	 File src=screenshot.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\"+ result.getName()+ timestamp()+".png"));
	 System.out.println("Successfully captured a screenshot");
	 }
	 
	 catch (Exception e){
	 System.out.println("Exception while taking screenshot "+e.getMessage());
	 } 
	 }
driver.quit();
}


private String timestamp() {
	// TODO Auto-generated method stub
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}

}
