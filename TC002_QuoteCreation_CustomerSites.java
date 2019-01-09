package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class TC002_QuoteCreation_CustomerSites {
	
	public Select selenium;
	public static WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/
//@Test(priority=0)
	public static void captureScreenMethod() throws IOException, InterruptedException { 
}
	
//TC211	
@SuppressWarnings("resource")
@Test(priority=1)
	public  void TC211_CSiteLogin_CustomerSite() throws Throwable {
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC211");
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
		//String gridTitle = "customer";
		
		
		
		//numRows = sheet1.getLastRowNum();
		
		
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
			
		
			
			boolean actualResult = driver.findElements(By.id("email")).size()>0; 
			
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
			
						
			boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
			if(! actualResult1)
		          //login.click();
		          //Main Event is logged If Passed
		          {
						sheet1.getRow(5).createCell(9).setCellValue("FAILED");
						sheet1.getRow(5).createCell(8).setCellValue("Password was NOT Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
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
			boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
			Thread.sleep(2000);
			if(! actualResult2)
		          //login.click();
		          //Main Event is logged If Passed
		          {
						sheet1.getRow(6).createCell(9).setCellValue("FAILED");
						sheet1.getRow(6).createCell(8).setCellValue("Login button NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
						
						
					}
			
			else 
					{
						sheet1.getRow(6).createCell(9).setCellValue("PASSED");
						sheet1.getRow(6).createCell(8).setCellValue("login button was found and Clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						
					}
			
			driver.findElement(By.id("Login")).click();
			Thread.sleep(15000);
			
			boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
				
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
			

		 //wb.close();	
//driver.quit();
	}	


//TC221	
@SuppressWarnings("resource")
@Test(priority=2)
public  void TC221_CustomerSite_EndUserQuote() throws Throwable {
	//public static void main(String[] args) throws IOException, InterruptedException { 
			
			
			//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
			//driver=new ChromeDriver();
//driver.manage().window().maximize();
			Thread.sleep(2000);
			
			//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
			File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
			//File src=new File("data\\SEAutoTesting.xlsx");
			
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//get sheet at index
			//XSSFSheet sheet1=wb.getSheetAt(1);  
			
			// Get sheet by name
			XSSFSheet sheet1=wb.getSheet("TC221");
			XSSFSheet sheet2=wb.getSheet("SC2_DATA");
			
			//String baseUrl ;
			//String loginUrl; 
			//String logoutUrl; 
			//String testUsername;
			//String testPassword ;
			int customerSiteQuoteId;
			String agreementType;
			String cFProgramLevel;
			String startDate;
			String endDate;
			int pageCounter;
			//int agreementTypeId ;
			String numPages;
			String gridTitle = "customer";
		
			sheet1.getLastRowNum();
			sheet2.getLastRowNum();

				//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
				//logoutUrl =baseUrl + "/auth/logout"; 
				//loginUrl =baseUrl + "/auth/login"; 
				//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
				//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
				customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				agreementType =sheet1.getRow(1).getCell(4).getStringCellValue();
				cFProgramLevel =sheet1.getRow(1).getCell(5).getStringCellValue();
				startDate = sheet1.getRow(1).getCell(6).getStringCellValue();
				endDate = sheet1.getRow(1).getCell(7).getStringCellValue();
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
				boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
				Thread.sleep(5000);
				
				//Assert.assertTrue(actualResult);
				if(! actualResult)
				{
					//If the tab is not greater than "0", then show "failed"
					sheet1.getRow(3).createCell(9).setCellValue("FAILED");
					sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();

				}
				else
				{
					//If the tab is greater than "0", then show "passed"
					sheet1.getRow(3).createCell(9).setCellValue("PASSED");
					sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				//Click on " Agreements" icon from sub-menu
				 driver.findElement(By.id("submenulink_137")).click();
				 Thread.sleep(7000);
				 
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
				 {				 
					 driver.findElement(By.id("cancelMaingrid_agreement")).click();
					 Thread.sleep(3000); }

				 //Search grid for amount of pages displayed
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
				 
					 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
					 
					 driver.findElement(By.id("cancelMaingrid_customer")).click();
					 Thread.sleep(4000);
					 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
					 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
					boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
					
					if ( ! advSrch)
					{
						sheet1.getRow(6).createCell(9).setCellValue("FAILED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						sheet1.getRow(6).createCell(9).setCellValue("PASSED");
						sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("advSrch_grid_customer")).click();
						Thread.sleep(2000);
						}
					
					//Find the ID filter button link and click that link
					boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
					Thread.sleep(3000);
					
					if ( ! CSidButton)
					{
						
						sheet1.getRow(7).createCell(9).setCellValue("FAILED");
						sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(7).createCell(9).setCellValue("PASSED");
						sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText("CustomerSiteID")).click();
						Thread.sleep(2000);
						}
					
					//Find the ID search filter box and click that in that box
					boolean idSrch = driver.findElements(By.id("ignore_customer_view_id_1_1")).size() >0;
					Thread.sleep(3000);
					
					if ( ! idSrch)
					{
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
						sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(8).createCell(9).setCellValue("PASSED");
						sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ignore_customer_view_id_1_1")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("ignore_customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
						Thread.sleep(7000);
						}
					
					//Click on the result for the ID filter search
					boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(customerSiteQuoteId))).size() >0;
					
					if ( ! idSrchResult)
					{
					
						sheet1.getRow(9).createCell(9).setCellValue("FAILED");
						sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(9).createCell(9).setCellValue("PASSED");
						sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText(String.valueOf(customerSiteQuoteId))).click();
						Thread.sleep(2000);
						}
					
					//Run the filter search for the specific ID
					boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
					
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
						driver.findElement(By.id("rungrid_customer")).click();
						Thread.sleep(4000);
						}
					
					//Select the check box and click [Create Quote] button
					//driver.findElement(By.id("jqg_grid_customer_" + String.valueOf(customerSiteQuoteId))).click();
					//Thread.sleep(3000);
					
					//Find the Customer ID by searching through the grid
					boolean findElementPage = false;
					pageCounter = 1;
					
					customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
					while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
						
					{
						findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
					
					if( ! findElementPage )
					{
					driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
				    pageCounter++;
					Thread.sleep(3000);
					}
					}
					if( findElementPage )
					{				
					//driver.findElement(By.id("jqg_grid_customer_" + String.valueOf(customerSiteQuoteId))).click();
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).click();
					Thread.sleep(3000);
					}
					
					//click on the create Quote button
					boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
				
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
					
					//Select Agreement Type from drop down menu
					boolean agreementTypeSelect = driver.findElements(By.id("ui-id-2")).size() >0;
					
					if ( ! agreementTypeSelect)
					{
						sheet1.getRow(12).createCell(9).setCellValue("FAILED");
						sheet1.getRow(12).createCell(8).setCellValue("Agreement Type was NOT Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(12).createCell(9).setCellValue("PASSED");
						sheet1.getRow(12).createCell(8).setCellValue("Agreement Type was Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
						Thread.sleep(3000);
						
					}
					
					//Select select = new Select(driver.findElement(By.xpath("//html/body/div[10]/div[2]/form/table/tbody/tr/td[4]/select")));
					//select.selectByVisibleText("Customer FIRST Lite");
					//driver.findElement(By.name("agreementType")).click();
					//selectByVisibleText("Customer FIRST Lite");
					//new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText("Customer FIRST Lite");
					
					
					//Select CF Program Level from drop down menu
					boolean CFProgramLevelSelect = driver.findElements((By.name("cfProgramLevel"))).size() >0;
					
					if ( ! CFProgramLevelSelect)
					{
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("CF Program Level was NOT Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("CF Program Level was Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
						Thread.sleep(3000);
					}
		
					//Start & End dates are selected from options
					boolean StartEndDateSelect = driver.findElements(By.name("StartDate")).size() >0;
					
					if ( ! StartEndDateSelect )
					{
						sheet1.getRow(14).createCell(9).setCellValue("FAILED");
						sheet1.getRow(14).createCell(8).setCellValue("Start & End Dates were NOT Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(14).createCell(9).setCellValue("PASSED");
						sheet1.getRow(14).createCell(8).setCellValue("Start & End Dates were Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						WebElement fromDateBox= driver.findElement(By.name("StartDate"));
						fromDateBox.clear();
						fromDateBox.sendKeys(String.valueOf(startDate));
						Thread.sleep(3000);
						WebElement fromDateBox1= driver.findElement(By.name("EndDate"));
						fromDateBox1.clear();
						fromDateBox1.sendKeys(String.valueOf(endDate));
						Thread.sleep(3000);
						
					}
					
					//new Select(driver.findElement(By.name("StartDate"))).selectByVisibleText("Standard");
					//boolean for quote confirmation pop up must be true otherwise fail
					boolean confirmation = driver.findElements(By.xpath("/html/body/div[9]/div[3]/div/button[2]")).size() >0;
					
					if ( ! confirmation)
					{
						
						sheet1.getRow(15).createCell(9).setCellValue("FAILED");
						sheet1.getRow(15).createCell(8).setCellValue("Confirmation page was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(15).createCell(9).setCellValue("PASSED");
						sheet1.getRow(15).createCell(8).setCellValue("Confirmation page is Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[2]")).click();
						Thread.sleep(3000);
					}
					
					//Click the "OK" button on the email confirmation page
					boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
					
					if ( ! confirmation1)
					{
					
						sheet1.getRow(16).createCell(9).setCellValue("FAILED");
						sheet1.getRow(16).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(16).createCell(9).setCellValue("PASSED");
						sheet1.getRow(16).createCell(8).setCellValue("Customer Site Grid' was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
						Thread.sleep(3000);
						}
					
					
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(4000);
					
					//Check for Customer Grid visibility
					boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
					
					if (!confirmation2)
					{
				
						sheet1.getRow(17).createCell(9).setCellValue("FAILED");
						sheet1.getRow(17).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
						
					}
					else
					{
						sheet1.getRow(17).createCell(9).setCellValue("PASSED");
						sheet1.getRow(17).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("refresh_grid_customer")).click();
						Thread.sleep(3000);
						}
					
					//wb.close();	
					//driver.quit();			
		}	

//TC222
@SuppressWarnings("resource")
@Test(priority=3)
public  void TC222_CustomerSite_QuoteOEM() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC222");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int customerSiteQuoteId;
		//String agreementType;
		//String cFProgramLevel;
		//String startDate;
		//String endDate;
		int pageCounter;
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementType =sheet2.getRow(2).getCell(8).getStringCellValue();
			//cFProgramLevel =sheet2.getRow(2).getCell(9).getStringCellValue();
			//startDate = sheet2.getRow(1).getCell(10).getStringCellValue();
			//endDate = sheet2.getRow(1).getCell(11).getStringCellValue();
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
			Thread.sleep(5000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
			Thread.sleep(5000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_137")).click();
			 Thread.sleep(7000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Search grid for amount of pages displayed
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
			 
				 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_customer")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
				boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
				
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
					driver.findElement(By.id("advSrch_grid_customer")).click();
					}
				
				//Find the ID filter button link and click that link
				boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CSidButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("CustomerSiteID")).click();
					Thread.sleep(3000);
					}
				
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Contains");
				Thread.sleep(3000);
				
				
				//Find the ID search filter box and click that in that box
				boolean CustomerSiteidSrch = driver.findElements(By.id("customer_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CustomerSiteidSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("customer_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
					Thread.sleep(3000);
					
					}
		
				//Select the Customer Site ID from the list
				boolean idSrchResult = driver.findElements(By.id("addConditiongrid_customer")).size() >0;
				Thread.sleep(4000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_customer")).click();
					Thread.sleep(2000);
					
					}
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				//Select oSelect = new Select(driver.findElement(By.id("auto_completegrid_customer")));
				//oSelect.selectByValue(String.valueOf(customerSiteQuoteId));
				//driver.findElement(By.id("auto_completegrid_customer"))).selectByVisibleText(String.valueOf(customerSiteQuoteId));
				//Thread.sleep(4000);
				
				//Select 
				boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
				
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
					driver.findElement(By.id("rungrid_customer")).click();
					Thread.sleep(4000);
					}
				
				//Select the check box and click [Create Quote] button
				//Find the Customer ID by searching through the grid
				boolean findElementPage = false;
				pageCounter = 1;
				
				customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
				
				 
				if( ! findElementPage )
				{
				driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
			    pageCounter++;
				Thread.sleep(3000);
				}
				}
				if( findElementPage )
				{				
				//driver.findElement(By.id("jqg_grid_customer_" + String.valueOf(customerSiteQuoteId))).click();
				driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).click();
				Thread.sleep(3000);
				}
				
				//Select the check box and click [Create Quote] button
				boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
			
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

				//Parent Checkbox should be displayed and selected
				
				boolean confirmation = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(3000);
				}
				
												
				//Continue button should be displayed and selected
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'Continue')]")).size() >0;
				
				if (!confirmation1)
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
					sheet1.getRow(13).createCell(8).setCellValue("Email Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
					Thread.sleep(3000);
					wb.write(fout);
					}
				//Email confirmation page will pop up and "OK" button is selected
				boolean confirmationEmail = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				
				if ( ! confirmationEmail)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					//Clear search conditions and refresh the customer site grid
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("refresh_grid_customer")).click();
					Thread.sleep(3000);
					
					}
			
				//Check to see if the content pane is displayed with refreshed Customer sites
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
				//driver.quit();
	}	

//TC223
@SuppressWarnings("resource")
@Test(priority=4)
public  void TC223_CustomerSite_QuoteOEM2() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
Thread.sleep(2000);
		
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("\\mmi_autotesting\\data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC223");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int customerSiteQuoteId;
		String agreementType;
		String cFProgramLevel;
		String startDate;
		String endDate;
		int pageCounter;
		
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			agreementType =sheet2.getRow(2).getCell(8).getStringCellValue();
			cFProgramLevel =sheet2.getRow(2).getCell(9).getStringCellValue();
			startDate = sheet2.getRow(1).getCell(10).getStringCellValue();
			endDate = sheet2.getRow(1).getCell(11).getStringCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(4000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(4000);

				//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(5000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
			Thread.sleep(5000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_137")).click();
			 Thread.sleep(7000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			//Search grid for amount of pages displayed
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
			 
				 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_customer")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
				boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
				
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
					driver.findElement(By.id("advSrch_grid_customer")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CSidButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("CustomerSiteID")).click();
					Thread.sleep(3000);
					}
				
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Contains");
				Thread.sleep(3000);
				
				
				//Find the ID search filter box and click that in that box
				boolean CustomerSiteidSrch = driver.findElements(By.id("customer_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CustomerSiteidSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("customer_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
					Thread.sleep(3000);
					
					}
		
				//Select the Customer Site ID from the list
				boolean idSrchResult = driver.findElements(By.id("addConditiongrid_customer")).size() >0;
				Thread.sleep(4000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_customer")).click();
					Thread.sleep(2000);
					
					}
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				//Select oSelect = new Select(driver.findElement(By.id("auto_completegrid_customer")));
				//oSelect.selectByValue(String.valueOf(customerSiteQuoteId));
				//driver.findElement(By.id("auto_completegrid_customer"))).selectByVisibleText(String.valueOf(customerSiteQuoteId));
				//Thread.sleep(4000);
				
				//Select 
				boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
				
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
					driver.findElement(By.id("rungrid_customer")).click();
					Thread.sleep(3000);
					}
				
				//Select the check box and click [Create Quote] button
					
				boolean findElementPage = false;
				pageCounter = 1;
				
				customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
					
				if( ! findElementPage )
				{
				driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
			    pageCounter++;
				Thread.sleep(3000);
				}
				}
				if (  ! findElementPage)
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
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).click();
					Thread.sleep(2000);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(2000);
				}
				
				
	
				//Parent Check box should be displayed and selected
				
				boolean confirmation = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
					Thread.sleep(2000);
					WebElement fromDateBox= driver.findElement(By.name("StartDate"));
					//WebElement fromDateBox= driver.findElement(By.cssSelector(".datepicker_start"));
					driver.findElement(By.name("StartDate")).click();
					fromDateBox.clear();
					fromDateBox.sendKeys(String.valueOf(startDate));
					Thread.sleep(2000);
					WebElement fromDateBox1= driver.findElement(By.name("EndDate"));
					//WebElement fromDateBox1= driver.findElement(By.cssSelector(".datepicker_end"));
					driver.findElement(By.name("EndDate")).click();
					fromDateBox1.clear();
					fromDateBox1.sendKeys(String.valueOf(endDate));
					Thread.sleep(2000);
				}
				
				//Continue button should be displayed and selected
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'Continue')]")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
					Thread.sleep(3000);
					
					}
				
				//Email confirmation page will pop up and "OK" button is selected
				boolean confirmationEmail = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				
				if ( ! confirmationEmail)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					//Clear search conditions and refresh the customer site grid
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("refresh_grid_customer")).click();
					Thread.sleep(3000);
					
					}
				
		
				//Check to see if the content pane is displayed with refreshed Customer sites
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
				//driver.quit();
		
	}		

//TC224
@SuppressWarnings("resource")
@Test(priority=5)
public  void TC224_CustomerSite_QuoteSI() throws Throwable {
		
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC224");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int customerSiteQuoteId;
		String agreementType;
		String cFProgramLevel;
		String startDate;
		String endDate;
		int pageCounter;
		
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			
			agreementType =sheet1.getRow(1).getCell(4).getStringCellValue();
			cFProgramLevel =sheet1.getRow(1).getCell(5).getStringCellValue();
			startDate = sheet1.getRow(1).getCell(6).getStringCellValue();
			endDate = sheet1.getRow(1).getCell(7).getStringCellValue();
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
			Thread.sleep(6000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
			Thread.sleep(4000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_137")).click();
			 Thread.sleep(6000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			//Search grid for amount of pages displayed
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
			 
				 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_customer")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
				boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
				
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
					driver.findElement(By.id("advSrch_grid_customer")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CSidButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("CustomerSiteID")).click();
					Thread.sleep(3000);
					}
				
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Contains");
				Thread.sleep(3000);
				
				
				//Find the ID search filter box and click that in that box
				boolean CustomerSiteidSrch = false;
				//agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				
				CustomerSiteidSrch = (driver.findElement(By.id("customer_view_id_1_1")).isDisplayed());
				Thread.sleep(3000);
				
				if ( ! CustomerSiteidSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("customer_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
					Thread.sleep(3000);
					
					}
		
				//Select the Customer Site ID from the list
				boolean idSrchResult = driver.findElements(By.id("addConditiongrid_customer")).size() >0;
				Thread.sleep(4000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_customer")).click();
					Thread.sleep(2000);
					
					}
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				//Select oSelect = new Select(driver.findElement(By.id("auto_completegrid_customer")));
				//oSelect.selectByValue(String.valueOf(customerSiteQuoteId));
				//driver.findElement(By.id("auto_completegrid_customer"))).selectByVisibleText(String.valueOf(customerSiteQuoteId));
				//Thread.sleep(4000);
				
				//Select 
				boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
				
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
					driver.findElement(By.id("rungrid_customer")).click();
					Thread.sleep(3000);
					}
				
				//Select the check box and click [Create Quote] button
					
				boolean findElementPage = false;
				pageCounter = 1;
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
				customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
					
				if(! findElementPage )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
				}
				}
				if (!findElementPage)
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
					//driver.findElement(By.id("jqg_grid_customer_" + String.valueOf(customerSiteQuoteId))).click();
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).click();
					Thread.sleep(3000);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
				}
				
			//Parent Checkbox should be displayed and selected
				
				boolean confirmation = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(2000);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
					Thread.sleep(2000);
					WebElement fromDateBox= driver.findElement(By.name("StartDate"));
					driver.findElement(By.name("StartDate")).click();
					fromDateBox.clear();
					fromDateBox.sendKeys(String.valueOf(startDate));
					Thread.sleep(2000);
					WebElement fromDateBox1= driver.findElement(By.name("EndDate"));
					driver.findElement(By.name("EndDate")).click();
					fromDateBox1.clear();
					fromDateBox1.sendKeys(String.valueOf(endDate));
					Thread.sleep(2000);
				}
			
				//Continue button should be displayed and selected
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'Continue')]")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
					Thread.sleep(3000);
					wb.write(fout);
					}
				
				//Email confirmation page will pop up and "OK" button is selected
				boolean confirmationEmail = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				
				if ( ! confirmationEmail)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					//Clear search conditions and refresh the customer site grid
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("refresh_grid_customer")).click();
					Thread.sleep(3000);
				}
				
	
				//Check to see if the content pane is displayed with refreshed Customer sites
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
				//driver.quit();
	}		

//TC225
@SuppressWarnings("resource")
@Test(priority=6)
public  void TC225_CustomerSite_QuoteWWInt() throws Throwable {
//public static void main(String[] args) throws IOException, InterruptedException { 
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC225");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int customerSiteQuoteId;
		String agreementType;
		String cFProgramLevel;
		String startDate;
		String endDate;
		int pageCounter;
		
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			
			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			
			agreementType =sheet1.getRow(1).getCell(4).getStringCellValue();
			cFProgramLevel =sheet1.getRow(1).getCell(5).getStringCellValue();
			startDate = sheet1.getRow(1).getCell(6).getStringCellValue();
			endDate = sheet1.getRow(1).getCell(7).getStringCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(4000);
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
//Thread.sleep(2000);

				//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(8000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(6000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
			Thread.sleep(4000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_137")).click();
			 Thread.sleep(6000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			//Search grid for amount of pages displayed
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
			 
				 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_customer")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
				boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
				
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
					driver.findElement(By.id("advSrch_grid_customer")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CSidButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("CustomerSiteID")).click();
					Thread.sleep(3000);
					}
				
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Contains");
				Thread.sleep(3000);
				
				
				//Find the ID search filter box and click that in that box
				boolean CustomerSiteidSrch = driver.findElements(By.id("customer_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CustomerSiteidSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("customer_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
					Thread.sleep(2000);
					
					}
		
				//Select the Customer Site ID from the list
				boolean idSrchResult = driver.findElements(By.id("addConditiongrid_customer")).size() >0;
				//Thread.sleep(4000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_customer")).click();
					Thread.sleep(3000);
					
					}
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				//Select oSelect = new Select(driver.findElement(By.id("auto_completegrid_customer")));
				//oSelect.selectByValue(String.valueOf(customerSiteQuoteId));
				//driver.findElement(By.id("auto_completegrid_customer"))).selectByVisibleText(String.valueOf(customerSiteQuoteId));
				//Thread.sleep(4000);
				
				//Select 
				boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
				
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
					driver.findElement(By.id("rungrid_customer")).click();
					Thread.sleep(3000);
					}
				
				//Select the check box and click [Create Quote] button
					
				boolean findElementPage = false;
				pageCounter = 1;
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
				customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
					
				if(! findElementPage )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
				}
				}
				if (!findElementPage)
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
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).click();
					Thread.sleep(2000);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(2000);
				}
				
				//Parent Check box should be displayed and selected
				boolean confirmation = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
					Thread.sleep(2000);
					WebElement fromDateBox= driver.findElement(By.name("StartDate"));
					driver.findElement(By.name("StartDate")).click();
					Thread.sleep(1000);
					fromDateBox.clear();
					fromDateBox.sendKeys(String.valueOf(startDate));
					Thread.sleep(2000);
					WebElement fromDateBox1= driver.findElement(By.name("EndDate"));
					driver.findElement(By.name("EndDate")).click();
					Thread.sleep(1000);
					fromDateBox1.clear();
					fromDateBox1.sendKeys(String.valueOf(endDate));
					Thread.sleep(2000);
					
				}
				
				//Continue button should be displayed and selected
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'Continue')]")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
					Thread.sleep(3000);
				}
				
				//Email confirmation page will pop up and "OK" button is selected
				boolean confirmationEmail = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				
				if (!confirmationEmail)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					//Clear search conditions and refresh the customer site grid
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("refresh_grid_customer")).click();
					Thread.sleep(4000);
					}
		
				//Check to see if the content pane is displayed with refreshed Customer sites
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if (!confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(2000);
					}
				
				//wb.close();	
				//driver.quit();
	}

//TC226
@SuppressWarnings("resource")
@Test(priority=7)
public  void TC226_CustomerSite_QuoteDISTLT() throws Throwable, IOException, InterruptedException {
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
		XSSFSheet sheet1=wb.getSheet("TC226");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		int customerSiteQuoteId;
		String agreementType;
		String cFProgramLevel;
		String startDate;
		String endDate;
		int pageCounter;
		
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			agreementType =sheet1.getRow(1).getCell(4).getStringCellValue();
			cFProgramLevel =sheet1.getRow(1).getCell(5).getStringCellValue();
			startDate = sheet1.getRow(1).getCell(6).getStringCellValue();
			endDate = sheet1.getRow(1).getCell(7).getStringCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
//driver.findElement(By.id("email")).sendKeys(testUsername);
//Thread.sleep(2000);

//driver.findElement(By.id("password-text")).sendKeys(testPassword);
Thread.sleep(2000);

				//Click the Login button
//driver.findElement(By.id("Login")).click();
//Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(6000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
			Thread.sleep(5000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_137")).click();
			 Thread.sleep(6000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Search grid for amount of pages displayed
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
			 
				 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_customer")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
				boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
				
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
					driver.findElement(By.id("advSrch_grid_customer")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CSidButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("CustomerSiteID")).click();
					Thread.sleep(3000);
					//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
					new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Contains");
					Thread.sleep(3000);
					}
				
	
				//Find the ID search filter box and click that in that box
				boolean CustomerSiteidSrch = driver.findElements(By.id("customer_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CustomerSiteidSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("customer_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
					Thread.sleep(3000);
					
					}
		
				//Select the Customer Site ID from the list
				boolean idSrchResult = driver.findElements(By.id("addConditiongrid_customer")).size() >0;
				Thread.sleep(4000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_customer")).click();
					Thread.sleep(2000);
					
					}
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				//Select oSelect = new Select(driver.findElement(By.id("auto_completegrid_customer")));
				//oSelect.selectByValue(String.valueOf(customerSiteQuoteId));
				//driver.findElement(By.id("auto_completegrid_customer"))).selectByVisibleText(String.valueOf(customerSiteQuoteId));
				//Thread.sleep(4000);
				
				//Select 
				boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
				
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
					driver.findElement(By.id("rungrid_customer")).click();
					Thread.sleep(5000);
					}
				
				//Select the check box and click [Create Quote] button
					
				boolean findElementPage = false;
				pageCounter = 1;
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
				customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
					
				if(! findElementPage )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
				}
				}
				if (!findElementPage)
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
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).click();
					Thread.sleep(3000);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
				}
	
				//Parent Checkbox should be displayed and selected
				boolean confirmation = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(3000);
					new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
					Thread.sleep(4000);
					new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
					Thread.sleep(4000);
					WebElement fromDateBox= driver.findElement(By.name("StartDate"));
					driver.findElement(By.name("StartDate")).click();
					Thread.sleep(1000);
					fromDateBox.clear();
					fromDateBox.sendKeys(String.valueOf(startDate));
					Thread.sleep(3000);
					WebElement fromDateBox1= driver.findElement(By.name("EndDate"));
					driver.findElement(By.name("EndDate")).click();
					Thread.sleep(1000);
					fromDateBox1.clear();
					fromDateBox1.sendKeys(String.valueOf(endDate));
					Thread.sleep(3000);
					
				}
			
				//Continue button should be displayed and selected
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'Continue')]")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
					Thread.sleep(3000);
					wb.write(fout);
					}
				
				//Email confirmation page will pop up and "OK" button is selected
				boolean confirmationEmail = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				
				if ( ! confirmationEmail)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("refresh_grid_customer")).click();
					Thread.sleep(4000);
					
					}
				
				//Clear search conditions and refresh the customer site grid
				
				
				
				//Check to see if the content pane is displayed with refreshed Customer sites
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
					sheet2.getRow(4).createCell(4).setCellValue("PASSED");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				//wb.close();	
				driver.quit();
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
//driver.quit();
}


private String timestamp() {
	// TODO Auto-generated method stub
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}


		
	}





