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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class TC004_AdvancedSearch_Filters_Operators {
	
	public Select selenium;
	public static WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/
	
//@Test(priority=0)
		public static void captureScreenMethod() throws IOException, InterruptedException { 
	}

	
//TC411
@SuppressWarnings("resource")
@Test(priority=1)
public static void main(String[] args) throws Throwable, IOException, InterruptedException { 
//public  void TC411_AdvancedSearchLink() throws Throwable {
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC411");
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
						//wb.close();	
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
			
			if(! actualResult2)
		         
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
						sheet1.getRow(6).createCell(8).setCellValue("login button was found and clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("Login")).click();
						Thread.sleep(15000);
					}
				
			//find the dash board tab and click
			Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
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
				//wb.close();	
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
			Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
					
			if( ! agreementTab)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(9).createCell(9).setCellValue("PASSED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("submenulink_129")).click();
				Thread.sleep(5000);
			}
			
			 //Find the clear search button and click
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);}
			
			 //Find the Advance search link
			 Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
			
			if ( ! advSrch)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("'Advanced Serarch Link' was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("'Advance Serach Link' was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//driver.findElement(By.id("advSrch_grid_agreement")).click();
				//Thread.sleep(4000);
				}
			
			//Find the Advance search link and click the link
			 Boolean advSrch1 = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
				
				if ( ! advSrch1)
				{
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					Thread.sleep(4000);
					}
				
				//Click the Agreement ID link filter
				Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;
				
				
				if ( ! closeButton)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Close Advanced Search was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
					Thread.sleep(3000);
					}
			
				//Click the Agreement ID link filter
				Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				
				if ( ! refreshButton)
				{
					
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("Grid was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Grid was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(3000);
					}
			
	
		
				//wb.close();	
				//driver.quit();
}


//TC421
@SuppressWarnings("resource")
@Test(priority=2)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC421_AgreementID_AdvancedSearch() throws Throwable {
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\AdvanceSearch_SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC421");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
		//String agreementUrl ;
		int agreementId ;
		//int numRows ;
		int pageCounter;
		String numPages;
		String gridTitle = "agreement";
		
		
		
		//numRows = sheet1.getLastRowNum();
		
		
			//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl =baseUrl + "/auth/logout"; 
			//loginUrl =baseUrl + "/auth/login"; 
			//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			
			
			//find the dash board tab and click
			Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
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
				sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(8).createCell(9).setCellValue("PASSED");
				sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("topmenuitem_31")).click();
				Thread.sleep(5000);
			}
			
			//Click on the Agreements tab
			Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
					
			if( ! agreementTab)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(9).createCell(9).setCellValue("PASSED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("submenulink_129")).click();
				Thread.sleep(5000);
			}
			
			 //Find the clear search button and click
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);}
			
			 //Find the Advance search link
			 Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
			
			if ( ! advSrch)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("'Advanced Serarch Link' was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("'Advance Serach Link' was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//driver.findElement(By.id("advSrch_grid_agreement")).click();
				//Thread.sleep(4000);
				}
			
			//Find the Advance search link and click the link
			 Boolean advSrch1 = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
				
				if ( ! advSrch1)
				{
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					Thread.sleep(4000);
					}
				
				//Click the Agreement ID link filter
				Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				
				
				if ( ! idButton)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					Thread.sleep(3000);
					}
			
				//Click the Agreement ID link filter
				Boolean AgreementView = driver.findElements(By.id("agreement_view__id")).size() >0;
				
				
				if ( ! AgreementView)
				{
					
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("Filter Dropdown was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Filter Dropdown was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("agreement_view__id")).click();
					Thread.sleep(3000);
					}
				
				//Click the Agreement ID text entry box
				Boolean AgreementTextBox = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
				
				
				if ( ! AgreementTextBox)
				{
					
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Enter ID' text box was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Enter ID' text box was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
					Thread.sleep(4000);
					}
			
				
				//Click on search result for agreement ID
				Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementId))).size() >0;
				Thread.sleep(1000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementId))).click();
					Thread.sleep(2000);
				}
				
				
				//Click on search result for agreement ID
				Boolean idSrchResultClick = driver.findElements(By.id("condition_wrap_grid_agreement")).size() >0;
				
				if ( ! idSrchResultClick)
				{
				
					sheet1.getRow(16).createCell(9).setCellValue("FAILED");
					sheet1.getRow(16).createCell(8).setCellValue("ID result link was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(16).createCell(9).setCellValue("PASSED");
					sheet1.getRow(16).createCell(8).setCellValue("ID result was Found and Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
				}
				
				//Click on Run Search for agreement ID
				Boolean idRunSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
				
				if ( ! idRunSrch)
				{
				
					sheet1.getRow(17).createCell(9).setCellValue("FAILED");
					sheet1.getRow(17).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(17).createCell(9).setCellValue("PASSED");
					sheet1.getRow(17).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(4000);
				}
				
				//Find given agreement ID from results of terms for 1 year
				Boolean findElementPage = true;
				pageCounter = 1;
				//agreementId = (int) sheet2.getRow(5).getCell(3).getNumericCellValue();
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
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
					sheet1.getRow(18).createCell(9).setCellValue("FAILED");
					sheet1.getRow(18).createCell(8).setCellValue("Pages with AgreementID " + agreementId + " were not found in the system");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(18).createCell(9).setCellValue("PASSED");
					sheet1.getRow(18).createCell(8).setCellValue("Page with AgreementID " + agreementId + " found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
					driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementId))).click();
					Thread.sleep(3000);
				}
				
				//Clear Search for agreement ID
				Boolean clearSrch = driver.findElements(By.id("cancelMaingrid_" + gridTitle)).size() >0;
				
				if ( ! clearSrch)
				{
				
					sheet1.getRow(19).createCell(9).setCellValue("FAILED");
					sheet1.getRow(19).createCell(8).setCellValue("'Clear All' button was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(19).createCell(9).setCellValue("PASSED");
					sheet1.getRow(19).createCell(8).setCellValue("'Clear All' button was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("cancelMaingrid_" + gridTitle)).click();
					Thread.sleep(3000);
				}
				
				//Clear Search for agreement ID
				Boolean refreshGrid = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				if ( ! refreshGrid)
				{
				
					sheet1.getRow(20).createCell(9).setCellValue("FAILED");
					sheet1.getRow(20).createCell(8).setCellValue("'Refresh Grid' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(20).createCell(9).setCellValue("PASSED");
					sheet1.getRow(20).createCell(8).setCellValue("'Refresh Grid' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(3000);
				}
		
		
				//wb.close();	
				//driver.quit();
}	

//TC422
@SuppressWarnings("resource")
@Test(priority=3)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC422_AdvancedFitlerBySrch() throws Throwable {
	
	
	//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
	//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);
	
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
	XSSFSheet sheet1=wb.getSheet("TC422");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	//String baseUrl ;
	//String loginUrl; 
	//String logoutUrl; 
	//String testUsername;
	//String testPassword ;
	
	String ID;
	String CustomerSiteID;
	String ParentAgreementNumber;
	String Agreement_Type;
	String StartDate;
	String EndDate;
	String AgreementTypeID;
	String AgreementNumber;
	String Days_to_Expiration;
	String CF_License_Value;
	String Estimated_CF_Agreement_Value;
	String Annualized_CF_Agreement_Value;
	String CFProgramLevelID;
	String TAMFlag;
	String Brand;
	String ActiveFlag;
	String DistributorID;
	String Disposition_Code;
	String Disposition;
	String category;
	String disposition_status;
	String CustomerType;
	String Address;
	String Address2;
	String City;
	String StateProv;
	String PostalCode;
	String Country;
	String Region;
	String CustomerSiteName;
	String Program_Level;
	String DistributorName;
	String AccountName;
	
	//String agreementUrl ;
	//int agreementId ;
	//int numRows ;
	//String numPages;
	//int pageCounter;
	//String gridTitle = "agreement";
	
	
	
	//numRows = sheet1.getLastRowNum();
	
	
	//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
	//logoutUrl =baseUrl + "/auth/logout"; 
	//loginUrl =baseUrl + "/auth/login"; 
	//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
	//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
	
	ID = sheet1.getRow(5).getCell(10).getStringCellValue();
	CustomerSiteID = sheet1.getRow(6).getCell(10).getStringCellValue();
	ParentAgreementNumber= sheet1.getRow(7).getCell(10).getStringCellValue();
	Agreement_Type = sheet1.getRow(8).getCell(10).getStringCellValue();
	StartDate = sheet1.getRow(9).getCell(10).getStringCellValue();
	EndDate = sheet1.getRow(10).getCell(10).getStringCellValue();
	AgreementTypeID = sheet1.getRow(11).getCell(10).getStringCellValue();
	AgreementNumber = sheet1.getRow(12).getCell(10).getStringCellValue();
	Days_to_Expiration = sheet1.getRow(13).getCell(10).getStringCellValue();
	CF_License_Value = sheet1.getRow(14).getCell(10).getStringCellValue();
	Estimated_CF_Agreement_Value = sheet1.getRow(15).getCell(10).getStringCellValue();
	Annualized_CF_Agreement_Value = sheet1.getRow(16).getCell(10).getStringCellValue();
	CFProgramLevelID = sheet1.getRow(17).getCell(10).getStringCellValue();
	TAMFlag = sheet1.getRow(18).getCell(10).getStringCellValue();
	Brand = sheet1.getRow(19).getCell(10).getStringCellValue();
	ActiveFlag = sheet1.getRow(20).getCell(10).getStringCellValue();
	DistributorID = sheet1.getRow(21).getCell(10).getStringCellValue();
	Disposition_Code = sheet1.getRow(22).getCell(10).getStringCellValue();
	Disposition = sheet1.getRow(23).getCell(10).getStringCellValue();
	category = sheet1.getRow(24).getCell(10).getStringCellValue();
	disposition_status = sheet1.getRow(25).getCell(10).getStringCellValue();
	CustomerType = sheet1.getRow(26).getCell(10).getStringCellValue();
	Address = sheet1.getRow(27).getCell(10).getStringCellValue();
	Address2 = sheet1.getRow(28).getCell(10).getStringCellValue();
	City = sheet1.getRow(29).getCell(10).getStringCellValue();
	StateProv = sheet1.getRow(30).getCell(10).getStringCellValue();
	PostalCode = sheet1.getRow(31).getCell(10).getStringCellValue();
	Country = sheet1.getRow(32).getCell(10).getStringCellValue();
	Region = sheet1.getRow(33).getCell(10).getStringCellValue();
	CustomerSiteName = sheet1.getRow(34).getCell(10).getStringCellValue();
	Program_Level = sheet1.getRow(35).getCell(10).getStringCellValue();
	DistributorName = sheet1.getRow(36).getCell(10).getStringCellValue();
	AccountName = sheet1.getRow(37).getCell(10).getStringCellValue();
	
	// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
	
	
//
//
	
	//find the dash board tab and click
	Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
	
	
	if(! actualResult3)
	{
		sheet1.getRow(7).createCell(9).setCellValue("FAILED");
		sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
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
		sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	
	}
	else
	{
		//If the tab is greater than "0", then show "passed"
		sheet1.getRow(8).createCell(9).setCellValue("PASSED");
		sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("topmenuitem_31")).click();
		Thread.sleep(5000);
	}
	
	//Click on the Agreements tab
	Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
			
	if( ! agreementTab)
	{
		//If the tab is not greater than "0", then show "failed"
		sheet1.getRow(9).createCell(9).setCellValue("FAILED");
		sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	
	}
	else
	{
		//If the tab is greater than "0", then show "passed"
		sheet1.getRow(9).createCell(9).setCellValue("PASSED");
		sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("submenulink_129")).click();
		Thread.sleep(5000);
	}
	
	 //Find the clear search button and click
	if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
	 
		driver.findElement(By.id("cancelMaingrid_agreement")).click();
		 Thread.sleep(4000);}
	
	 //Find the Advance search link
	 Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
	
	if ( ! advSrch)
	{
		sheet1.getRow(10).createCell(9).setCellValue("FAILED");
		sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(10).createCell(9).setCellValue("PASSED");
		sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Displayed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	    driver.findElement(By.id("advSrch_grid_agreement")).click();
	    Thread.sleep(3000);
	}
	
	//Find the Advance search link and click the link
	 Boolean advSrch1 = driver.findElements(By.id("drill_grid_agreement")).size() >0;
	
	if ( ! advSrch1)
	{
		sheet1.getRow(11).createCell(9).setCellValue("FAILED");
		sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(11).createCell(9).setCellValue("PASSED");
		sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(4000);
	}
	
	
	//Find the Advance search link and click the link
	 Boolean advSrchFilter = driver.findElements(By.id("drill_grid_agreement")).size() >0;
	
	if ( ! advSrchFilter)
	{
		sheet1.getRow(12).createCell(9).setCellValue("FAILED");
		sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(12).createCell(9).setCellValue("PASSED");
		sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(2000);
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ID));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(ID))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ID
	 Boolean advSrchFilter1 = driver.findElements(By.linkText(String.valueOf(ID))).size() >0;
		
	if ( ! advSrchFilter1)
	{
		sheet1.getRow(13).createCell(9).setCellValue("FAILED");
		sheet1.getRow(13).createCell(8).setCellValue("ID field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(13).createCell(9).setCellValue("PASSED");
		sheet1.getRow(13).createCell(8).setCellValue("ID field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerSiteID));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(CustomerSiteID))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter CustomerSiteID
	 Boolean advSrchFilter2 = driver.findElements(By.linkText(String.valueOf(CustomerSiteID))).size() >0;
		
	if ( ! advSrchFilter2)
	{
		sheet1.getRow(14).createCell(9).setCellValue("FAILED");
		sheet1.getRow(14).createCell(8).setCellValue("CustomerSiteID field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(14).createCell(9).setCellValue("PASSED");
		sheet1.getRow(14).createCell(8).setCellValue("CustomerSiteID field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ParentAgreementNumber));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(ParentAgreementNumber))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter ParentAgreementNumber
	 Boolean advSrchFilter3 = driver.findElements(By.linkText(String.valueOf(ParentAgreementNumber))).size() >0;
	
	if ( ! advSrchFilter3)
	{
		sheet1.getRow(15).createCell(9).setCellValue("FAILED");
		sheet1.getRow(15).createCell(8).setCellValue("ParentAgreementNumber field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(15).createCell(9).setCellValue("PASSED");
		sheet1.getRow(15).createCell(8).setCellValue("ParentAgreementNumber field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Agreement_Type));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Agreement_Type))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Agreement_Type
	 Boolean advSrchFilter4 = driver.findElements(By.linkText(String.valueOf(Agreement_Type))).size() >0;
			
	if ( ! advSrchFilter4)
	{
		sheet1.getRow(16).createCell(9).setCellValue("FAILED");
		sheet1.getRow(16).createCell(8).setCellValue("Agreement_Type field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(16).createCell(9).setCellValue("PASSED");
		sheet1.getRow(16).createCell(8).setCellValue("Agreement_Type field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(StartDate));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(StartDate))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter StartDate
	 Boolean advSrchFilter5 = driver.findElements(By.linkText(String.valueOf(StartDate))).size() >0;
				
	if ( ! advSrchFilter5)
	{
		sheet1.getRow(17).createCell(9).setCellValue("FAILED");
		sheet1.getRow(17).createCell(8).setCellValue("StartDate field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(17).createCell(9).setCellValue("PASSED");
		sheet1.getRow(17).createCell(8).setCellValue("StartDate field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(EndDate));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(EndDate))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter EndDate
	 Boolean advSrchFilter6 = driver.findElements(By.linkText(String.valueOf(EndDate))).size() >0;
				
	if ( ! advSrchFilter6)
	{
		sheet1.getRow(18).createCell(9).setCellValue("FAILED");
		sheet1.getRow(18).createCell(8).setCellValue("EndDate field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(18).createCell(9).setCellValue("PASSED");
		sheet1.getRow(18).createCell(8).setCellValue("EndDate field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AgreementTypeID));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(AgreementTypeID))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementTypeID
	 Boolean advSrchFilter7 = driver.findElements(By.linkText(String.valueOf(AgreementTypeID))).size() >0;
				
	if ( ! advSrchFilter7)
	{
		sheet1.getRow(19).createCell(9).setCellValue("FAILED");
		sheet1.getRow(19).createCell(8).setCellValue("AgreementTypeID field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(19).createCell(9).setCellValue("PASSED");
		sheet1.getRow(19).createCell(8).setCellValue("AgreementTypeID field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AgreementNumber));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(AgreementNumber))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter AgreementNumber
	 Boolean advSrchFilter8 = driver.findElements(By.linkText(String.valueOf(AgreementNumber))).size() >0;
				
	if ( ! advSrchFilter8)
	{
		sheet1.getRow(20).createCell(9).setCellValue("FAILED");
		sheet1.getRow(20).createCell(8).setCellValue("AgreementNumber field filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(20).createCell(9).setCellValue("PASSED");
		sheet1.getRow(20).createCell(8).setCellValue("AgreementNumber field filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
	}
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Days_to_Expiration));
	Thread.sleep(2000);
	driver.findElement(By.linkText(String.valueOf(Days_to_Expiration))).click();
	Thread.sleep(2000);
	
	//Find the Advance search filter box and Enter Days_to_Expiration
		 Boolean advSrchFilter9 = driver.findElements(By.linkText(String.valueOf(Days_to_Expiration))).size() >0;
					
		if ( ! advSrchFilter9)
		{
			sheet1.getRow(21).createCell(9).setCellValue("FAILED");
			sheet1.getRow(21).createCell(8).setCellValue("Days_to_Expiration field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(21).createCell(9).setCellValue("PASSED");
			sheet1.getRow(21).createCell(8).setCellValue("Days_to_Expiration field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CF_License_Value));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CF_License_Value))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CF_License_Value
		 Boolean advSrchFilter10 = driver.findElements(By.linkText(String.valueOf(CF_License_Value))).size() >0;
					
		if ( ! advSrchFilter10)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("CF_License_Value field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("CF_License_Value field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Estimated_CF_Agreement_Value));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Estimated_CF_Agreement_Value))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Estimated_CF_Agreement_Value
		 Boolean advSrchFilter11 = driver.findElements(By.linkText(String.valueOf(Estimated_CF_Agreement_Value))).size() >0;
					
		if ( ! advSrchFilter11)
		{
			sheet1.getRow(23).createCell(9).setCellValue("FAILED");
			sheet1.getRow(23).createCell(8).setCellValue("Estimated_CF_Agreement_Value field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(23).createCell(9).setCellValue("PASSED");
			sheet1.getRow(23).createCell(8).setCellValue("Estimated_CF_Agreement_Value field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Annualized_CF_Agreement_Value));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Annualized_CF_Agreement_Value))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Annualized_CF_Agreement_Value
		 Boolean advSrchFilter12 = driver.findElements(By.linkText(String.valueOf(Annualized_CF_Agreement_Value))).size() >0;
					
		if ( ! advSrchFilter12)
		{
			sheet1.getRow(24).createCell(9).setCellValue("FAILED");
			sheet1.getRow(24).createCell(8).setCellValue("Annualized_CF_Agreement_Value field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(24).createCell(9).setCellValue("PASSED");
			sheet1.getRow(24).createCell(8).setCellValue("Annualized_CF_Agreement_Value field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CFProgramLevelID));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CFProgramLevelID))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CFProgramLevelID
		 Boolean advSrchFilter13 = driver.findElements(By.linkText(String.valueOf(CFProgramLevelID))).size() >0;
					
		if ( ! advSrchFilter13)
		{
			sheet1.getRow(25).createCell(9).setCellValue("FAILED");
			sheet1.getRow(25).createCell(8).setCellValue("CFProgramLevelID field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(25).createCell(9).setCellValue("PASSED");
			sheet1.getRow(25).createCell(8).setCellValue("AgreementNumber field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(TAMFlag));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(TAMFlag))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter TAMFlag
		 Boolean advSrchFilter14 = driver.findElements(By.linkText(String.valueOf(TAMFlag))).size() >0;
					
		if ( ! advSrchFilter14)
		{
			sheet1.getRow(26).createCell(9).setCellValue("FAILED");
			sheet1.getRow(26).createCell(8).setCellValue("TAMFlag field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(26).createCell(9).setCellValue("PASSED");
			sheet1.getRow(26).createCell(8).setCellValue("TAMFlag field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Brand));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Brand))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Brand
		 Boolean advSrchFilter15 = driver.findElements(By.linkText(String.valueOf(Brand))).size() >0;
					
		if ( ! advSrchFilter15)
		{
			sheet1.getRow(27).createCell(9).setCellValue("FAILED");
			sheet1.getRow(27).createCell(8).setCellValue("Brand field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(27).createCell(9).setCellValue("PASSED");
			sheet1.getRow(27).createCell(8).setCellValue("Brand field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ActiveFlag));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(ActiveFlag))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter ActiveFlag
		 Boolean advSrchFilter16 = driver.findElements(By.linkText(String.valueOf(ActiveFlag))).size() >0;
					
		if ( ! advSrchFilter16)
		{
			sheet1.getRow(28).createCell(9).setCellValue("FAILED");
			sheet1.getRow(28).createCell(8).setCellValue("ActiveFlag field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(28).createCell(9).setCellValue("PASSED");
			sheet1.getRow(28).createCell(8).setCellValue("ActiveFlag field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(DistributorID));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(DistributorID))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter DistributorID
		 Boolean advSrchFilter17 = driver.findElements(By.linkText(String.valueOf(DistributorID))).size() >0;
					
		if ( ! advSrchFilter17)
		{
			sheet1.getRow(29).createCell(9).setCellValue("FAILED");
			sheet1.getRow(29).createCell(8).setCellValue("DistributorID field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(29).createCell(9).setCellValue("PASSED");
			sheet1.getRow(29).createCell(8).setCellValue("DistributorID field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Disposition_Code));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Disposition_Code))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition Code
		 Boolean advSrchFilter18 = driver.findElements(By.linkText(String.valueOf(Disposition_Code))).size() >0;
					
		if ( ! advSrchFilter18)
		{
			sheet1.getRow(30).createCell(9).setCellValue("FAILED");
			sheet1.getRow(30).createCell(8).setCellValue("Disposition Code field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(30).createCell(9).setCellValue("PASSED");
			sheet1.getRow(30).createCell(8).setCellValue("Disposition Code field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Disposition));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Disposition))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition
		 Boolean advSrchFilter19 = driver.findElements(By.linkText(String.valueOf(Disposition))).size() >0;
					
		if ( ! advSrchFilter19)
		{
			sheet1.getRow(31).createCell(9).setCellValue("FAILED");
			sheet1.getRow(31).createCell(8).setCellValue("Disposition field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(31).createCell(9).setCellValue("PASSED");
			sheet1.getRow(31).createCell(8).setCellValue("Disposition field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(category));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(category))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter category
		 Boolean advSrchFilter20 = driver.findElements(By.linkText(String.valueOf(category))).size() >0;
					
		if ( ! advSrchFilter20)
		{
			sheet1.getRow(32).createCell(9).setCellValue("FAILED");
			sheet1.getRow(32).createCell(8).setCellValue("Category field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(32).createCell(9).setCellValue("PASSED");
			sheet1.getRow(32).createCell(8).setCellValue("Category field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(disposition_status));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(disposition_status))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Disposition_status
		 Boolean advSrchFilter21 = driver.findElements(By.linkText(String.valueOf(disposition_status))).size() >0;
					
		if ( ! advSrchFilter21)
		{
			sheet1.getRow(33).createCell(9).setCellValue("FAILED");
			sheet1.getRow(33).createCell(8).setCellValue("Disposition_status field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(33).createCell(9).setCellValue("PASSED");
			sheet1.getRow(33).createCell(8).setCellValue("Disposition_status field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerType));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CustomerType))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CustomerType
		 Boolean advSrchFilter22 = driver.findElements(By.linkText(String.valueOf(CustomerType))).size() >0;
					
		if ( ! advSrchFilter22)
		{
			sheet1.getRow(34).createCell(9).setCellValue("FAILED");
			sheet1.getRow(34).createCell(8).setCellValue("CustomerType field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(34).createCell(9).setCellValue("PASSED");
			sheet1.getRow(34).createCell(8).setCellValue("CustomerType field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Address));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Address))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Address
		 Boolean advSrchFilter23 = driver.findElements(By.linkText(String.valueOf(Address))).size() >0;
					
		if ( ! advSrchFilter23)
		{
			sheet1.getRow(35).createCell(9).setCellValue("FAILED");
			sheet1.getRow(35).createCell(8).setCellValue("Address field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(35).createCell(9).setCellValue("PASSED");
			sheet1.getRow(35).createCell(8).setCellValue("Address field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Address2));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Address2))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Address2
		 Boolean advSrchFilter24 = driver.findElements(By.linkText(String.valueOf(Address2))).size() >0;
					
		if ( ! advSrchFilter24)
		{
			sheet1.getRow(36).createCell(9).setCellValue("FAILED");
			sheet1.getRow(36).createCell(8).setCellValue("Address2 field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(36).createCell(9).setCellValue("PASSED");
			sheet1.getRow(36).createCell(8).setCellValue("Address2 field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(City));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(City))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter City
		 Boolean advSrchFilter25 = driver.findElements(By.linkText(String.valueOf(City))).size() >0;
					
		if ( ! advSrchFilter25)
		{
			sheet1.getRow(37).createCell(9).setCellValue("FAILED");
			sheet1.getRow(37).createCell(8).setCellValue("City field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(37).createCell(9).setCellValue("PASSED");
			sheet1.getRow(37).createCell(8).setCellValue("City field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(StateProv));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(StateProv))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter StateProv
		 Boolean advSrchFilter26 = driver.findElements(By.linkText(String.valueOf(StateProv))).size() >0;
					
		if ( ! advSrchFilter26)
		{
			sheet1.getRow(38).createCell(9).setCellValue("FAILED");
			sheet1.getRow(38).createCell(8).setCellValue("StateProv field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(38).createCell(9).setCellValue("PASSED");
			sheet1.getRow(38).createCell(8).setCellValue("StateProv field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(PostalCode));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(PostalCode))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter PostalCode
		 Boolean advSrchFilter27 = driver.findElements(By.linkText(String.valueOf(PostalCode))).size() >0;
					
		if ( ! advSrchFilter27)
		{
			sheet1.getRow(39).createCell(9).setCellValue("FAILED");
			sheet1.getRow(39).createCell(8).setCellValue("PostalCode field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(39).createCell(9).setCellValue("PASSED");
			sheet1.getRow(39).createCell(8).setCellValue("PostalCode field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Country));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Country))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Country
		 Boolean advSrchFilter28 = driver.findElements(By.linkText(String.valueOf(Country))).size() >0;
					
		if ( ! advSrchFilter28)
		{
			sheet1.getRow(40).createCell(9).setCellValue("FAILED");
			sheet1.getRow(40).createCell(8).setCellValue("Country field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(40).createCell(9).setCellValue("PASSED");
			sheet1.getRow(40).createCell(8).setCellValue("Country field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Region));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Region))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Region
		 Boolean advSrchFilter29 = driver.findElements(By.linkText(String.valueOf(Region))).size() >0;
					
		if ( ! advSrchFilter29)
		{
			sheet1.getRow(41).createCell(9).setCellValue("FAILED");
			sheet1.getRow(41).createCell(8).setCellValue("Region field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(41).createCell(9).setCellValue("PASSED");
			sheet1.getRow(41).createCell(8).setCellValue("Region field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerSiteName));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(CustomerSiteName))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter CustomerSiteName
		 Boolean advSrchFilter30 = driver.findElements(By.linkText(String.valueOf(CustomerSiteName))).size() >0;
					
		if ( ! advSrchFilter30)
		{
			sheet1.getRow(42).createCell(9).setCellValue("FAILED");
			sheet1.getRow(42).createCell(8).setCellValue("CustomerSiteName field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(42).createCell(9).setCellValue("PASSED");
			sheet1.getRow(42).createCell(8).setCellValue("CustomerSiteName field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Program_Level));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(Program_Level))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter Program_Level
		 Boolean advSrchFilter31 = driver.findElements(By.linkText(String.valueOf(Program_Level))).size() >0;
					
		if ( ! advSrchFilter31)
		{
			sheet1.getRow(43).createCell(9).setCellValue("FAILED");
			sheet1.getRow(43).createCell(8).setCellValue("Program_Level field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(43).createCell(9).setCellValue("PASSED");
			sheet1.getRow(43).createCell(8).setCellValue("Program_Level field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(DistributorName));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(DistributorName))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter DistributorName
		 Boolean advSrchFilter32 = driver.findElements(By.linkText(String.valueOf(DistributorName))).size() >0;
					
		if ( ! advSrchFilter32)
		{
			sheet1.getRow(44).createCell(9).setCellValue("FAILED");
			sheet1.getRow(44).createCell(8).setCellValue("DistributorName field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(44).createCell(9).setCellValue("PASSED");
			sheet1.getRow(44).createCell(8).setCellValue("DistributorName field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AccountName));
		Thread.sleep(2000);
		driver.findElement(By.linkText(String.valueOf(AccountName))).click();
		Thread.sleep(2000);
		
		//Find the Advance search filter box and Enter AccountName
		 Boolean advSrchFilter33 = driver.findElements(By.linkText(String.valueOf(AccountName))).size() >0;
					
		if ( ! advSrchFilter33)
		{
			sheet1.getRow(45).createCell(9).setCellValue("FAILED");
			sheet1.getRow(45).createCell(8).setCellValue("AccountName field filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(45).createCell(9).setCellValue("PASSED");
			sheet1.getRow(45).createCell(8).setCellValue("AccountName field filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			
		}

	//Click the Agreement ID link filter
	Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;
	
	
	if ( ! closeButton)
	{
		
		sheet1.getRow(46).createCell(9).setCellValue("FAILED");
		sheet1.getRow(46).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(46).createCell(9).setCellValue("PASSED");
		sheet1.getRow(46).createCell(8).setCellValue("Close Advanced Search was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
		Thread.sleep(3000);
	}
	
	//Click the Agreement ID link filter
	Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
	
	
	if ( ! refreshButton)
	{
		
		sheet1.getRow(47).createCell(9).setCellValue("FAILED");
		sheet1.getRow(47).createCell(8).setCellValue("Grid was NOT Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(47).createCell(9).setCellValue("PASSED");
		sheet1.getRow(47).createCell(8).setCellValue("Grid was Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("refresh_grid_agreement")).click();
		Thread.sleep(3000);
	}
			
		
	    //wb.close();	
		//driver.quit();
	}	

//TC431
@SuppressWarnings("resource")
@Test(priority=4)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC431_AdvancedOperatorFilterA_B() throws Throwable {


		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);

//File src=new File("C:\\mmi_auto_testing\\data\\AdvanceSearch_SEAutoTesting.xlsx");
//File src=new File("SEAutoTesting.xlsx");
//File src=new File("AdvancedSearch_SEAutoTesting.xlsx");
//File src=new File("\\mmi_automation\\mmi_auto_testing_AdvencedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");

FileInputStream fis=new FileInputStream(src);

XSSFWorkbook wb=new XSSFWorkbook(fis);

//get sheet at index
//XSSFSheet sheet1=wb.getSheetAt(1);  

//Get sheet by name
XSSFSheet sheet1=wb.getSheet("TC431");
//XSSFSheet sheet2=wb.createSheet("results");


//String baseUrl ;
//String loginUrl; 
//String logoutUrl; 
//String testUsername;
//String testPassword ;

//String ID;
//String CustomerSiteID;
//String ParentAgreementNumber;
String Agreement_Type;
//String StartDate;
//String EndDate;
String AgreementTypeID;
String AgreementNumber;
//String Days_to_Expiration;
//String CF_License_Value;
//String Estimated_CF_Agreement_Value;
String AnnualizedCFValue;
//String CFProgramLevelID;
//String TAMFlag;
String Brand;
String ActiveFlag;
//String DistributorID;
//String Disposition_Code;
//String Disposition;
//String category;
//String disposition_status;
//String CustomerType;
String Address;
String Address2;
//String City;
//String StateProv;
//String PostalCode;
//String Country;
//String Region;
//String CustomerSiteName;
//String Program_Level;
//String DistributorName;
String AccountName;

//String agreementUrl ;
//int agreementId ;
//int numRows ;
//String numPages;
//int pageCounter;
//String gridTitle = "agreement";



//numRows = sheet1.getLastRowNum();


//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
//logoutUrl =baseUrl + "/auth/logout"; 
//loginUrl =baseUrl + "/auth/login"; 
//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();

AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
ActiveFlag = sheet1.getRow(4).getCell(10).getStringCellValue();
Address = sheet1.getRow(5).getCell(10).getStringCellValue();
Address2 = sheet1.getRow(6).getCell(10).getStringCellValue();
Agreement_Type = sheet1.getRow(7).getCell(10).getStringCellValue();
AgreementNumber = sheet1.getRow(8).getCell(10).getStringCellValue();
AgreementTypeID = sheet1.getRow(9).getCell(10).getStringCellValue();
AnnualizedCFValue = sheet1.getRow(10).getCell(10).getStringCellValue();
Brand = sheet1.getRow(11).getCell(10).getStringCellValue();
//ID = sheet1.getRow(5).getCell(10).getStringCellValue();
//CustomerSiteID = sheet1.getRow(6).getCell(10).getStringCellValue();
//ParentAgreementNumber= sheet1.getRow(7).getCell(10).getStringCellValue();

//StartDate = sheet1.getRow(9).getCell(10).getStringCellValue();
//EndDate = sheet1.getRow(10).getCell(10).getStringCellValue();


//Days_to_Expiration = sheet1.getRow(13).getCell(10).getStringCellValue();
//CF_License_Value = sheet1.getRow(14).getCell(10).getStringCellValue();
//Estimated_CF_Agreement_Value = sheet1.getRow(15).getCell(10).getStringCellValue();

//CFProgramLevelID = sheet1.getRow(17).getCell(10).getStringCellValue();
//TAMFlag = sheet1.getRow(18).getCell(10).getStringCellValue();


//DistributorID = sheet1.getRow(21).getCell(10).getStringCellValue();
//Disposition_Code = sheet1.getRow(22).getCell(10).getStringCellValue();
//Disposition = sheet1.getRow(23).getCell(10).getStringCellValue();
//category = sheet1.getRow(24).getCell(10).getStringCellValue();
//disposition_status = sheet1.getRow(25).getCell(10).getStringCellValue();
//CustomerType = sheet1.getRow(26).getCell(10).getStringCellValue();


//City = sheet1.getRow(29).getCell(10).getStringCellValue();
//StateProv = sheet1.getRow(30).getCell(10).getStringCellValue();
//PostalCode = sheet1.getRow(31).getCell(10).getStringCellValue();
//Country = sheet1.getRow(32).getCell(10).getStringCellValue();
//Region = sheet1.getRow(33).getCell(10).getStringCellValue();
//CustomerSiteName = sheet1.getRow(34).getCell(10).getStringCellValue();
//Program_Level = sheet1.getRow(35).getCell(10).getStringCellValue();
//DistributorName = sheet1.getRow(36).getCell(10).getStringCellValue();


//String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();




//find the dash board tab and click
Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;


if(! actualResult3)
{
	sheet1.getRow(7).createCell(9).setCellValue("FAILED");
	sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
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
	sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();

}
else
{
	//If the tab is greater than "0", then show "passed"
	sheet1.getRow(8).createCell(9).setCellValue("PASSED");
	sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("topmenuitem_31")).click();
	Thread.sleep(5000);
}

//Click on the Agreements tab
Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
		
if( ! agreementTab)
{
	//If the tab is not greater than "0", then show "failed"
	sheet1.getRow(9).createCell(9).setCellValue("FAILED");
	sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();

}
else
{
	//If the tab is greater than "0", then show "passed"
	sheet1.getRow(9).createCell(9).setCellValue("PASSED");
	sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("submenulink_129")).click();
	Thread.sleep(5000);
}

//Find the clear search button and click
if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {

	driver.findElement(By.id("cancelMaingrid_agreement")).click();
	 Thread.sleep(4000);}

//Find the Advance search link
Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;

if ( ! advSrch)
{
	sheet1.getRow(10).createCell(9).setCellValue("FAILED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(10).createCell(9).setCellValue("PASSED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
  driver.findElement(By.id("advSrch_grid_agreement")).click();
  Thread.sleep(2000);
}

//Find the Advance search link and click the link
Boolean advSrch1 = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrch1)
{
	sheet1.getRow(11).createCell(9).setCellValue("FAILED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(11).createCell(9).setCellValue("PASSED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(2000);
}


//Find the Advance search link and click the link
Boolean advSrchFilter = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrchFilter)
{
	sheet1.getRow(12).createCell(9).setCellValue("FAILED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(12).createCell(9).setCellValue("PASSED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
}

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AccountName));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AccountName))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ID
Boolean AccountNameOperator = driver.findElements(By.linkText(String.valueOf(AccountName))).size() >0;
	
if ( ! AccountNameOperator)
{
	sheet1.getRow(13).createCell(9).setCellValue("FAILED");
	sheet1.getRow(13).createCell(8).setCellValue("Account Name Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(13).createCell(9).setCellValue("PASSED");
	sheet1.getRow(13).createCell(8).setCellValue("Account Name Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ActiveFlag));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(ActiveFlag))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter CustomerSiteID
Boolean ActiveFlagOperator = driver.findElements(By.linkText(String.valueOf(ActiveFlag))).size() >0;
	
if ( ! ActiveFlagOperator)
{
	sheet1.getRow(14).createCell(9).setCellValue("FAILED");
	sheet1.getRow(14).createCell(8).setCellValue("Active Flag Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(14).createCell(9).setCellValue("PASSED");
	sheet1.getRow(14).createCell(8).setCellValue("Active Flag Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Address));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Address))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ParentAgreementNumber
Boolean AddressOperator = driver.findElements(By.linkText(String.valueOf(Address))).size() >0;

if ( ! AddressOperator)
{
	sheet1.getRow(15).createCell(9).setCellValue("FAILED");
	sheet1.getRow(15).createCell(8).setCellValue("Address Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(15).createCell(9).setCellValue("PASSED");
	sheet1.getRow(15).createCell(8).setCellValue("Address Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Address2));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Address2))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Agreement_Type
Boolean Address2Operator = driver.findElements(By.linkText(String.valueOf(Address2))).size() >0;
		
if ( ! Address2Operator)
{
	sheet1.getRow(16).createCell(9).setCellValue("FAILED");
	sheet1.getRow(16).createCell(8).setCellValue("Address2 Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(16).createCell(9).setCellValue("PASSED");
	sheet1.getRow(16).createCell(8).setCellValue("Address2 Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Agreement_Type));
Thread.sleep(2000);
driver.findElement(By.linkText(String.valueOf(Agreement_Type))).click();
Thread.sleep(2000);

//Find the Advance search filter box and Enter StartDate
Boolean AgreementTypeOperator = driver.findElements(By.linkText(String.valueOf(Agreement_Type))).size() >0;
			
if ( ! AgreementTypeOperator)
{
	sheet1.getRow(17).createCell(9).setCellValue("FAILED");
	sheet1.getRow(17).createCell(8).setCellValue("Agreement_Type Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(17).createCell(9).setCellValue("PASSED");
	sheet1.getRow(17).createCell(8).setCellValue("Agreement_Type Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AgreementNumber));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AgreementNumber))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter EndDate
Boolean AgreementNumberOperator = driver.findElements(By.linkText(String.valueOf(AgreementNumber))).size() >0;
			
if ( ! AgreementNumberOperator)
{
	sheet1.getRow(18).createCell(9).setCellValue("FAILED");
	sheet1.getRow(18).createCell(8).setCellValue("Agreement Number Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(18).createCell(9).setCellValue("PASSED");
	sheet1.getRow(18).createCell(8).setCellValue("Agreement Number Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AgreementTypeID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AgreementTypeID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter AgreementTypeID
Boolean AgreementTypeIDOperator = driver.findElements(By.linkText(String.valueOf(AgreementTypeID))).size() >0;
			
if ( ! AgreementTypeIDOperator)
{
	sheet1.getRow(19).createCell(9).setCellValue("FAILED");
	sheet1.getRow(19).createCell(8).setCellValue("AgreementTypeID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(19).createCell(9).setCellValue("PASSED");
	sheet1.getRow(19).createCell(8).setCellValue("AgreementTypeID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AnnualizedCFValue));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AnnualizedCFValue))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter AgreementNumber
Boolean AnnualizedCFAgreementValueOperator = driver.findElements(By.linkText(String.valueOf(AnnualizedCFValue))).size() >0;
			
if ( ! AnnualizedCFAgreementValueOperator)
{
	sheet1.getRow(20).createCell(9).setCellValue("FAILED");
	sheet1.getRow(20).createCell(8).setCellValue("Annualized_CF_Agreement_Value Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(20).createCell(9).setCellValue("PASSED");
	sheet1.getRow(20).createCell(8).setCellValue("Annualized_CF_Agreement_Value Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Brand));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Brand))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Days_to_Expiration
	 Boolean BrandOperator = driver.findElements(By.linkText(String.valueOf(Brand))).size() >0;
				
	if ( ! BrandOperator)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("Brand Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("Brand Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
	
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Equal to");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Not Equal to");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Between");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Starts with");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Ends by");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Contains");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("In List");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Does not start with");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Does not end by");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Does not contain");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Not in List");
	Thread.sleep(2000);
	
	driver.findElement(By.id("drill_grid_agreement")).clear();
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
	
	
	

//Click the "x" to close the Advanced Search
Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;


if ( ! closeButton)
{
	
	sheet1.getRow(22).createCell(9).setCellValue("FAILED");
	sheet1.getRow(22).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(22).createCell(9).setCellValue("PASSED");
	sheet1.getRow(22).createCell(8).setCellValue("Close Advanced Search was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
	Thread.sleep(3000);
}

//Click the Agreement ID link filter
Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;


if ( ! refreshButton)
{
	
	sheet1.getRow(23).createCell(9).setCellValue("FAILED");
	sheet1.getRow(23).createCell(8).setCellValue("Grid was NOT Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(23).createCell(9).setCellValue("PASSED");
	sheet1.getRow(23).createCell(8).setCellValue("Grid was Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("refresh_grid_agreement")).click();
	Thread.sleep(3000);
}
		

	//wb.close();	
	//driver.quit();
}	

//TC432
@SuppressWarnings("resource")
@Test(priority=5)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC432_AdvancedOperatorFilterC_D() throws Throwable {


		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);

//File src=new File("C:\\mmi_auto_testing\\data\\AdvanceSearch_SEAutoTesting.xlsx");
//File src=new File("SEAutoTesting.xlsx");
//File src=new File("AdvancedSearch_SEAutoTesting.xlsx");
//File src=new File("\\mmi_automation\\mmi_auto_testing_AdvencedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");

FileInputStream fis=new FileInputStream(src);

XSSFWorkbook wb=new XSSFWorkbook(fis);

//get sheet at index
//XSSFSheet sheet1=wb.getSheetAt(1);  

//Get sheet by name
XSSFSheet sheet1=wb.getSheet("TC432");
//XSSFSheet sheet2=wb.createSheet("results");


//String baseUrl ;
//String loginUrl; 
//String logoutUrl; 
//String testUsername;
//String testPassword ;


String category;
String CF_License_Value;
String CFProgramLevelID;
String City;
String Country;
String CustomerSiteID;
String CustomerSiteName;
String CustomerType;
String Days_to_Expiration;
String Disposition;
String Disposition_Code;
String disposition_status;
String DistributorID;
String DistributorName;

//String ID;
//String ParentAgreementNumber;
//String Agreement_Type;
//String StartDate;
//String EndDate;
//String AgreementTypeID;
//String AgreementNumber;
//String Estimated_CF_Agreement_Value;
//String AnnualizedCFValue;
//String TAMFlag;
//String Brand;
//String ActiveFlag;
//String Address;
//String Address2;
//String StateProv;
//String PostalCode;
//String Region;
//String Program_Level;
//String AccountName;
//String agreementUrl;

//int agreementId ;
//int numRows ;
//String numPages;
//int pageCounter;
//String gridTitle = "agreement";
//numRows = sheet1.getLastRowNum();


//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
//logoutUrl =baseUrl + "/auth/logout"; 
//loginUrl =baseUrl + "/auth/login"; 
//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();

category = sheet1.getRow(3).getCell(10).getStringCellValue();
CF_License_Value = sheet1.getRow(4).getCell(10).getStringCellValue();
CFProgramLevelID = sheet1.getRow(5).getCell(10).getStringCellValue();
City = sheet1.getRow(6).getCell(10).getStringCellValue();
Country = sheet1.getRow(7).getCell(10).getStringCellValue();
CustomerSiteID = sheet1.getRow(8).getCell(10).getStringCellValue();
CustomerSiteName = sheet1.getRow(9).getCell(10).getStringCellValue();
CustomerType = sheet1.getRow(10).getCell(10).getStringCellValue();
Days_to_Expiration = sheet1.getRow(11).getCell(10).getStringCellValue();
Disposition = sheet1.getRow(12).getCell(10).getStringCellValue();
Disposition_Code = sheet1.getRow(13).getCell(10).getStringCellValue();
disposition_status = sheet1.getRow(14).getCell(10).getStringCellValue();
DistributorID = sheet1.getRow(15).getCell(10).getStringCellValue();
DistributorName = sheet1.getRow(16).getCell(10).getStringCellValue();
//AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
//ActiveFlag = sheet1.getRow(4).getCell(10).getStringCellValue();
//Address = sheet1.getRow(5).getCell(10).getStringCellValue();
//Address2 = sheet1.getRow(6).getCell(10).getStringCellValue();
//Agreement_Type = sheet1.getRow(7).getCell(10).getStringCellValue();
//AgreementNumber = sheet1.getRow(8).getCell(10).getStringCellValue();
//AgreementTypeID = sheet1.getRow(9).getCell(10).getStringCellValue();
//AnnualizedCFValue = sheet1.getRow(10).getCell(10).getStringCellValue();
//Brand = sheet1.getRow(11).getCell(10).getStringCellValue();
//ID = sheet1.getRow(5).getCell(10).getStringCellValue();
//ParentAgreementNumber= sheet1.getRow(7).getCell(10).getStringCellValue();
//StartDate = sheet1.getRow(9).getCell(10).getStringCellValue();
//EndDate = sheet1.getRow(10).getCell(10).getStringCellValue();
//Estimated_CF_Agreement_Value = sheet1.getRow(15).getCell(10).getStringCellValue();
//TAMFlag = sheet1.getRow(18).getCell(10).getStringCellValue();
//StateProv = sheet1.getRow(30).getCell(10).getStringCellValue();
//PostalCode = sheet1.getRow(31).getCell(10).getStringCellValue();
//Region = sheet1.getRow(33).getCell(10).getStringCellValue();
//Program_Level = sheet1.getRow(35).getCell(10).getStringCellValue();


//find the dash board tab and click
Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;


if(! actualResult3)
{
	sheet1.getRow(7).createCell(9).setCellValue("FAILED");
	sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
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
	sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();

}
else
{
	//If the tab is greater than "0", then show "passed"
	sheet1.getRow(8).createCell(9).setCellValue("PASSED");
	sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("topmenuitem_31")).click();
	Thread.sleep(5000);
}

//Click on the Agreements tab
Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
		
if( ! agreementTab)
{
	//If the tab is not greater than "0", then show "failed"
	sheet1.getRow(9).createCell(9).setCellValue("FAILED");
	sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();

}
else
{
	//If the tab is greater than "0", then show "passed"
	sheet1.getRow(9).createCell(9).setCellValue("PASSED");
	sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("submenulink_129")).click();
	Thread.sleep(5000);
}

//Find the clear search button and click
if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {

	driver.findElement(By.id("cancelMaingrid_agreement")).click();
	 Thread.sleep(4000);}

//Find the Advance search link
Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;

if ( ! advSrch)
{
	sheet1.getRow(10).createCell(9).setCellValue("FAILED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(10).createCell(9).setCellValue("PASSED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
driver.findElement(By.id("advSrch_grid_agreement")).click();
Thread.sleep(2000);
}

//Find the Advance search link and click the link
Boolean advSrch1 = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrch1)
{
	sheet1.getRow(11).createCell(9).setCellValue("FAILED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(11).createCell(9).setCellValue("PASSED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(2000);
}


//Find the Advance search link and click the link
Boolean advSrchFilter = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrchFilter)
{
	sheet1.getRow(12).createCell(9).setCellValue("FAILED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(12).createCell(9).setCellValue("PASSED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
}

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(category));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(category))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ID
Boolean categoryOperator = driver.findElements(By.linkText(String.valueOf(category))).size() >0;
	
if ( ! categoryOperator)
{
	sheet1.getRow(13).createCell(9).setCellValue("FAILED");
	sheet1.getRow(13).createCell(8).setCellValue("Account Name Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(13).createCell(9).setCellValue("PASSED");
	sheet1.getRow(13).createCell(8).setCellValue("Account Name Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CF_License_Value));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CF_License_Value))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter CustomerSiteID
Boolean CF_License_ValueOperator = driver.findElements(By.linkText(String.valueOf(CF_License_Value))).size() >0;
	
if ( ! CF_License_ValueOperator)
{
	sheet1.getRow(14).createCell(9).setCellValue("FAILED");
	sheet1.getRow(14).createCell(8).setCellValue("Active Flag Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(14).createCell(9).setCellValue("PASSED");
	sheet1.getRow(14).createCell(8).setCellValue("Active Flag Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CFProgramLevelID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CFProgramLevelID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ParentAgreementNumber
Boolean CFProgramLevelIDOperator = driver.findElements(By.linkText(String.valueOf(CFProgramLevelID))).size() >0;

if ( ! CFProgramLevelIDOperator)
{
	sheet1.getRow(15).createCell(9).setCellValue("FAILED");
	sheet1.getRow(15).createCell(8).setCellValue("CFProgramLevelID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(15).createCell(9).setCellValue("PASSED");
	sheet1.getRow(15).createCell(8).setCellValue("CFProgramLevelID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(City));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(City))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Agreement_Type
Boolean CityOperator = driver.findElements(By.linkText(String.valueOf(City))).size() >0;
		
if ( ! CityOperator)
{
	sheet1.getRow(16).createCell(9).setCellValue("FAILED");
	sheet1.getRow(16).createCell(8).setCellValue("City Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(16).createCell(9).setCellValue("PASSED");
	sheet1.getRow(16).createCell(8).setCellValue("City Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Country));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Country))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter StartDate
Boolean CountryOperator = driver.findElements(By.linkText(String.valueOf(Country))).size() >0;
			
if ( ! CountryOperator)
{
	sheet1.getRow(17).createCell(9).setCellValue("FAILED");
	sheet1.getRow(17).createCell(8).setCellValue("Country Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(17).createCell(9).setCellValue("PASSED");
	sheet1.getRow(17).createCell(8).setCellValue("Country Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerSiteID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CustomerSiteID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter EndDate
Boolean CustomerSiteIDOperator = driver.findElements(By.linkText(String.valueOf(CustomerSiteID))).size() >0;
			
if ( ! CustomerSiteIDOperator)
{
	sheet1.getRow(18).createCell(9).setCellValue("FAILED");
	sheet1.getRow(18).createCell(8).setCellValue("CustomerSiteID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(18).createCell(9).setCellValue("PASSED");
	sheet1.getRow(18).createCell(8).setCellValue("CustomerSiteID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerSiteName));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CustomerSiteName))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter CustomerSiteName
Boolean CustomerSiteNameOperator = driver.findElements(By.linkText(String.valueOf(CustomerSiteName))).size() >0;
			
if ( ! CustomerSiteNameOperator)
{
	sheet1.getRow(19).createCell(9).setCellValue("FAILED");
	sheet1.getRow(19).createCell(8).setCellValue("CustomerSiteName Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(19).createCell(9).setCellValue("PASSED");
	sheet1.getRow(19).createCell(8).setCellValue("CustomerSiteName Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerType));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CustomerType))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter AgreementNumber
Boolean CustomerTypeOperator = driver.findElements(By.linkText(String.valueOf(CustomerType))).size() >0;
			
if ( ! CustomerTypeOperator)
{
	sheet1.getRow(20).createCell(9).setCellValue("FAILED");
	sheet1.getRow(20).createCell(8).setCellValue("CustomerType Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(20).createCell(9).setCellValue("PASSED");
	sheet1.getRow(20).createCell(8).setCellValue("CustomerType Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Days_to_Expiration));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Days_to_Expiration))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Days_to_Expiration
	 Boolean Days_to_ExpirationOperator = driver.findElements(By.linkText(String.valueOf(Days_to_Expiration))).size() >0;
				
	if ( ! Days_to_ExpirationOperator)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("Days_to_Expiration Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("Days_to_Expiration Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
	
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Not Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Greater Than (Strictly)");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Less Than (Strictly)");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Greater Than or Equal");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Less Than or Equal");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Between");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Starts with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Ends by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Contains");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("In List");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Not Between");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Does not start with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Does not end by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Does not contain");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Not in List");
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).clear();
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Disposition));
	Thread.sleep(1000);
	driver.findElement(By.linkText(String.valueOf(Disposition))).click();
	Thread.sleep(1000);

	//Find the Advance search filter box and Enter disposition_description
		 Boolean DispositionOperator = driver.findElements(By.linkText(String.valueOf(Disposition))).size() >0;
					
		if ( ! DispositionOperator)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("Disposition Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("Disposition Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Disposition_Code));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(Disposition_Code))).click();
		Thread.sleep(1000);

//Find the Advance search filter box and Enter Disposition Code
	 Boolean DispositionCodeOperator = driver.findElements(By.linkText(String.valueOf(Disposition_Code))).size() >0;
				
	if ( ! DispositionCodeOperator)
	{
		sheet1.getRow(23).createCell(9).setCellValue("FAILED");
		sheet1.getRow(23).createCell(8).setCellValue("Disposition_Code Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(23).createCell(9).setCellValue("PASSED");
		sheet1.getRow(23).createCell(8).setCellValue("Disposition_Code Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
			
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(disposition_status));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(disposition_status))).click();
		Thread.sleep(1000);

	//Find the Advance search filter box and Enter disposition_status
		 Boolean disposition_statusOperator = driver.findElements(By.linkText(String.valueOf(disposition_status))).size() >0;
					
		if ( ! disposition_statusOperator)
		{
			sheet1.getRow(24).createCell(9).setCellValue("FAILED");
			sheet1.getRow(24).createCell(8).setCellValue("disposition_status Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(24).createCell(9).setCellValue("PASSED");
			sheet1.getRow(24).createCell(8).setCellValue("disposition_status Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(DistributorID));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(DistributorID))).click();
		Thread.sleep(1000);

	//Find the Advance search filter box and Enter DistributorID
		 Boolean DistributorIDOperator = driver.findElements(By.linkText(String.valueOf(DistributorID))).size() >0;
					
		if ( ! DistributorIDOperator)
		{
			sheet1.getRow(25).createCell(9).setCellValue("FAILED");
			sheet1.getRow(25).createCell(8).setCellValue("DistributorID Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(25).createCell(9).setCellValue("PASSED");
			sheet1.getRow(25).createCell(8).setCellValue("DistributorID Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Greater Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Less Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Greater Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Less Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Not Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(DistributorName));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(DistributorName))).click();
		Thread.sleep(1000);

	//Find the Advance search filter box and Enter DistributorName
		 Boolean DistributorNameOperator = driver.findElements(By.linkText(String.valueOf(DistributorName))).size() >0;
					
		if ( ! DistributorNameOperator)
		{
			sheet1.getRow(26).createCell(9).setCellValue("FAILED");
			sheet1.getRow(26).createCell(8).setCellValue("DistributorName Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(26).createCell(9).setCellValue("PASSED");
			sheet1.getRow(26).createCell(8).setCellValue("DistributorName Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
						
	
	

//Click the "x" to close the Advanced Search
Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;


if ( ! closeButton)
{
	
	sheet1.getRow(27).createCell(9).setCellValue("FAILED");
	sheet1.getRow(27).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(27).createCell(9).setCellValue("PASSED");
	sheet1.getRow(27).createCell(8).setCellValue("Close Advanced Search was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
	Thread.sleep(3000);
}

//Click the Agreement ID link filter
Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;


if ( ! refreshButton)
{
	
	sheet1.getRow(28).createCell(9).setCellValue("FAILED");
	sheet1.getRow(28).createCell(8).setCellValue("Grid was NOT Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(28).createCell(9).setCellValue("PASSED");
	sheet1.getRow(28).createCell(8).setCellValue("Grid was Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("refresh_grid_agreement")).click();
	Thread.sleep(3000);
}
		

		//wb.close();	
		//driver.quit();
}	


//TC433
@SuppressWarnings("resource")
@Test(priority=6)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC433_AdvancedOperatorFilterE_T() throws Throwable {


		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
//driver.manage().window().maximize();
//Thread.sleep(2000);

//File src=new File("C:\\mmi_auto_testing\\data\\AdvanceSearch_SEAutoTesting.xlsx");
//File src=new File("SEAutoTesting.xlsx");
//File src=new File("AdvancedSearch_SEAutoTesting.xlsx");
//File src=new File("\\mmi_automation\\mmi_auto_testing_AdvencedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");

FileInputStream fis=new FileInputStream(src);

XSSFWorkbook wb=new XSSFWorkbook(fis);

//get sheet at index
//XSSFSheet sheet1=wb.getSheetAt(1);  

//Get sheet by name
XSSFSheet sheet1=wb.getSheet("TC433");
XSSFSheet sheet2=wb.getSheet("All_TC_Results");


//String baseUrl ;
//String loginUrl; 
//String logoutUrl; 
//String testUsername;
//String testPassword ;

String EndDate;
String Estimated_CF_Agreement_Value;
String ID;
String ParentAgreementNumber;
String PostalCode;
String Program_Level;
String Region;
String StartDate;
String StateProv;
String TAMFlag;
//String Agreement_Type;
//String AgreementTypeID;
//String AgreementNumber;
//String Days_to_Expiration;
//String CF_License_Value;
//String CustomerSiteID;
//String AnnualizedCFValue;
//String CFProgramLevelID;
//String ActiveFlag;
//String DistributorID;
//String Disposition_Code;
//String Disposition;
//String category;
//String disposition_status;
//String CustomerType;
//String Address;
//String Address2;
//String City;
//String Country;
//String CustomerSiteName;
//String DistributorName;
//String AccountName;
//String agreementUrl ;
//int agreementId ;
//int numRows ;
//String numPages;
//int pageCounter;
//String gridTitle = "agreement";
//numRows = sheet1.getLastRowNum();


//baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
//logoutUrl =baseUrl + "/auth/logout"; 
//loginUrl =baseUrl + "/auth/login"; 
//testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
//testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();

EndDate = sheet1.getRow(3).getCell(10).getStringCellValue();
Estimated_CF_Agreement_Value = sheet1.getRow(4).getCell(10).getStringCellValue();
ID = sheet1.getRow(5).getCell(10).getStringCellValue();
ParentAgreementNumber= sheet1.getRow(6).getCell(10).getStringCellValue();
PostalCode = sheet1.getRow(7).getCell(10).getStringCellValue();
Program_Level = sheet1.getRow(8).getCell(10).getStringCellValue();
Region = sheet1.getRow(9).getCell(10).getStringCellValue();
StartDate = sheet1.getRow(10).getCell(10).getStringCellValue();
StateProv = sheet1.getRow(11).getCell(10).getStringCellValue();
TAMFlag = sheet1.getRow(12).getCell(10).getStringCellValue();

//AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
//ActiveFlag = sheet1.getRow(4).getCell(10).getStringCellValue();
//Address = sheet1.getRow(5).getCell(10).getStringCellValue();
//Address2 = sheet1.getRow(6).getCell(10).getStringCellValue();
//Agreement_Type = sheet1.getRow(7).getCell(10).getStringCellValue();
//AgreementNumber = sheet1.getRow(8).getCell(10).getStringCellValue();
//AgreementTypeID = sheet1.getRow(9).getCell(10).getStringCellValue();
//AnnualizedCFValue = sheet1.getRow(10).getCell(10).getStringCellValue();
//Brand = sheet1.getRow(11).getCell(10).getStringCellValue();
//CustomerSiteID = sheet1.getRow(6).getCell(10).getStringCellValue();
//Days_to_Expiration = sheet1.getRow(13).getCell(10).getStringCellValue();
//CF_License_Value = sheet1.getRow(14).getCell(10).getStringCellValue();
//CFProgramLevelID = sheet1.getRow(17).getCell(10).getStringCellValue();
//DistributorID = sheet1.getRow(21).getCell(10).getStringCellValue();
//Disposition_Code = sheet1.getRow(22).getCell(10).getStringCellValue();
//Disposition = sheet1.getRow(23).getCell(10).getStringCellValue();
//category = sheet1.getRow(24).getCell(10).getStringCellValue();
//disposition_status = sheet1.getRow(25).getCell(10).getStringCellValue();
//CustomerType = sheet1.getRow(26).getCell(10).getStringCellValue();
//City = sheet1.getRow(29).getCell(10).getStringCellValue();
//Country = sheet1.getRow(32).getCell(10).getStringCellValue();
//CustomerSiteName = sheet1.getRow(34).getCell(10).getStringCellValue();
//DistributorName = sheet1.getRow(36).getCell(10).getStringCellValue();




//find the dash board tab and click
Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;


if(! actualResult3)
{
	sheet1.getRow(7).createCell(9).setCellValue("FAILED");
	sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
	
}
else
{
	sheet1.getRow(7).createCell(9).setCellValue("PASSED");
	sheet1.getRow(7).createCell(8).setCellValue("Dashboard was found and displayed");
	FileOutputStream fout=new FileOutputStream(src);
	driver.findElement(By.id("dashboard")).click();
	Thread.sleep(2000);
	wb.write(fout);
}

//Click on the Installed Base Tab
Boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;

if( ! installedBase)
{
	//If the tab is not greater than "0", then show "failed"
	sheet1.getRow(8).createCell(9).setCellValue("FAILED");
	sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();

}
else
{
	//If the tab is greater than "0", then show "passed"
	sheet1.getRow(8).createCell(9).setCellValue("PASSED");
	sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("topmenuitem_31")).click();
	Thread.sleep(5000);
}

//Click on the Agreements tab
Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
		
if( ! agreementTab)
{
	//If the tab is not greater than "0", then show "failed"
	sheet1.getRow(9).createCell(9).setCellValue("FAILED");
	sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();

}
else
{
	//If the tab is greater than "0", then show "passed"
	sheet1.getRow(9).createCell(9).setCellValue("PASSED");
	sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("submenulink_129")).click();
	Thread.sleep(5000);
}

//Find the clear search button and click
if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {

	driver.findElement(By.id("cancelMaingrid_agreement")).click();
	 Thread.sleep(4000);}

//Find the Advance search link
Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;

if ( ! advSrch)
{
	sheet1.getRow(10).createCell(9).setCellValue("FAILED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(10).createCell(9).setCellValue("PASSED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
driver.findElement(By.id("advSrch_grid_agreement")).click();
Thread.sleep(2000);
}

//Find the Advance search link and click the link
Boolean advSrch1 = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrch1)
{
	sheet1.getRow(11).createCell(9).setCellValue("FAILED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(11).createCell(9).setCellValue("PASSED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
}


//Find the Advance search link and click the link
Boolean advSrchFilter = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrchFilter)
{
	sheet1.getRow(12).createCell(9).setCellValue("FAILED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(12).createCell(9).setCellValue("PASSED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
}

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(EndDate));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(EndDate))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter End Date
Boolean EndDateOperator = driver.findElements(By.linkText(String.valueOf(EndDate))).size() >0;
	
if ( ! EndDateOperator)
{
	sheet1.getRow(13).createCell(9).setCellValue("FAILED");
	sheet1.getRow(13).createCell(8).setCellValue("End Date Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(13).createCell(9).setCellValue("PASSED");
	sheet1.getRow(13).createCell(8).setCellValue("End Date Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Within");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Within Last");
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Estimated_CF_Agreement_Value));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Estimated_CF_Agreement_Value))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Estimated_CF_Agreement_Value
Boolean Estimated_CF_Agreement_ValueOperator = driver.findElements(By.linkText(String.valueOf(Estimated_CF_Agreement_Value))).size() >0;
	
if ( ! Estimated_CF_Agreement_ValueOperator)
{
	sheet1.getRow(14).createCell(9).setCellValue("FAILED");
	sheet1.getRow(14).createCell(8).setCellValue("Estimated_CF_Agreement_Value Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(14).createCell(9).setCellValue("PASSED");
	sheet1.getRow(14).createCell(8).setCellValue("Estimated_CF_Agreement_Value Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(ID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ParentAgreementNumber
Boolean IDOperator = driver.findElements(By.linkText(String.valueOf(ID))).size() >0;

if ( ! IDOperator)
{
	sheet1.getRow(15).createCell(9).setCellValue("FAILED");
	sheet1.getRow(15).createCell(8).setCellValue("ID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(15).createCell(9).setCellValue("PASSED");
	sheet1.getRow(15).createCell(8).setCellValue("ID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ParentAgreementNumber));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(ParentAgreementNumber))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Parent Agreement Number
Boolean ParentAgreementNumberOperator = driver.findElements(By.linkText(String.valueOf(ParentAgreementNumber))).size() >0;
		
if ( ! ParentAgreementNumberOperator)
{
	sheet1.getRow(16).createCell(9).setCellValue("FAILED");
	sheet1.getRow(16).createCell(8).setCellValue("Parent Agreement Number Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(16).createCell(9).setCellValue("PASSED");
	sheet1.getRow(16).createCell(8).setCellValue("Parent Agreement Number Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(PostalCode));
Thread.sleep(2000);
driver.findElement(By.linkText(String.valueOf(PostalCode))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Postal Code
Boolean PostalCodeOperator = driver.findElements(By.linkText(String.valueOf(PostalCode))).size() >0;
			
if ( ! PostalCodeOperator)
{
	sheet1.getRow(17).createCell(9).setCellValue("FAILED");
	sheet1.getRow(17).createCell(8).setCellValue("PostalCode Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(17).createCell(9).setCellValue("PASSED");
	sheet1.getRow(17).createCell(8).setCellValue("PostalCode Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Program_Level));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Program_Level))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Program_Level
Boolean Program_LevelOperator = driver.findElements(By.linkText(String.valueOf(Program_Level))).size() >0;
			
if ( ! Program_LevelOperator)
{
	sheet1.getRow(18).createCell(9).setCellValue("FAILED");
	sheet1.getRow(18).createCell(8).setCellValue("Program_Level Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(18).createCell(9).setCellValue("PASSED");
	sheet1.getRow(18).createCell(8).setCellValue("Program_Level Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Region));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Region))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Region
Boolean RegionOperator = driver.findElements(By.linkText(String.valueOf(Region))).size() >0;
			
if ( ! RegionOperator)
{
	sheet1.getRow(19).createCell(9).setCellValue("FAILED");
	sheet1.getRow(19).createCell(8).setCellValue("Region Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(19).createCell(9).setCellValue("PASSED");
	sheet1.getRow(19).createCell(8).setCellValue("Region Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(StartDate));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(StartDate))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter StartDate
Boolean StartDateOperator = driver.findElements(By.linkText(String.valueOf(StartDate))).size() >0;
			
if ( ! StartDateOperator)
{
	sheet1.getRow(20).createCell(9).setCellValue("FAILED");
	sheet1.getRow(20).createCell(8).setCellValue("StartDate Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(20).createCell(9).setCellValue("PASSED");
	sheet1.getRow(20).createCell(8).setCellValue("StartDate Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}


new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Within");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Within Last");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(StateProv));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(StateProv))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter StateProv
	 Boolean StateProvOperator = driver.findElements(By.linkText(String.valueOf(StateProv))).size() >0;
				
	if ( ! StateProvOperator)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("StateProv Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("StateProv Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
	
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Not Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Between");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Starts with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Ends by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Contains");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("In List");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Does not start with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Does not end by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Does not contain");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Not in List");
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).clear();
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(TAMFlag));
	Thread.sleep(1000);
	driver.findElement(By.linkText(String.valueOf(TAMFlag))).click();
	Thread.sleep(1000);

	//Find the Advance search filter box and Enter TAMFlag
		 Boolean TAMFlagOperator = driver.findElements(By.linkText(String.valueOf(TAMFlag))).size() >0;
					
		if ( ! TAMFlagOperator)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("TAMFlag Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("TAMFlag Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Greater Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Less Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Greater Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Less Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Not Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
	

//Click the "x" to close the Advanced Search
Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;


if ( ! closeButton)
{
	
	sheet1.getRow(23).createCell(9).setCellValue("FAILED");
	sheet1.getRow(23).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(23).createCell(9).setCellValue("PASSED");
	sheet1.getRow(23).createCell(8).setCellValue("Close Advanced Search was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
	Thread.sleep(3000);
}

//Click the Agreement ID link filter
Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;


if ( ! refreshButton)
{
	
	sheet1.getRow(24).createCell(9).setCellValue("FAILED");
	sheet1.getRow(24).createCell(8).setCellValue("Grid was NOT Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	//wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(24).createCell(9).setCellValue("PASSED");
	sheet1.getRow(24).createCell(8).setCellValue("Grid was Refreshed");
	sheet2.getRow(6).createCell(4).setCellValue("PASSED");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("refresh_grid_agreement")).click();
	Thread.sleep(3000);
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
	 FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\"+ result.getName() + timestamp()+".png"));
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






