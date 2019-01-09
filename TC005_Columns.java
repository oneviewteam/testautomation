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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;





public class TC005_Columns {
	
	//WebDriver driver;
		public Select selenium;
		public static WebDriver driver;

		
		/*
		 * Create a quote from agreement
		 * 
		
		*/
		
//@Test(priority=0)
public static void captureScreenMethod() throws IOException, InterruptedException { 
}


@SuppressWarnings("resource")
@Test(priority=1)
public  void TC511_ColumnsLinkExists() throws Throwable {
			
			
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
			XSSFSheet sheet1=wb.getSheet("TC511");
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
			
				//find the email text box and send the email id
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
							//driver.quit();
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
				boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
				
				if(! actualResult1)
			          
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
				
				if(! actualResult2)
			         
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
							sheet1.getRow(6).createCell(8).setCellValue("login button was found and clicked");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							driver.findElement(By.id("Login")).click();
							Thread.sleep(15000);
						}
					
				//find the dash board tab and click
				boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
				//Assert.assertTrue(actualResult);
				if(! actualResult3)
				{
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
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
				boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
				
				if( ! installedBase)
				{
					//If the tab is not greater than "0", then show "failed"
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("Installed Base tab was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();

				}
				else
				{
					//If the tab is greater than "0", then show "passed"
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("Installed Base tab was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("topmenuitem_31")).click();
					Thread.sleep(5000);
				}
				
				//Click on the Agreements tab
				boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
						
				if( ! agreementTab)
				{
					//If the tab is not greater than "0", then show "failed"
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();

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
				
				 //Find the Columns link
				 boolean columnSrch = driver.findElements(By.id("columns_grid_agreement")).size() >0;
				
				if ( ! columnSrch)
				{
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//driver.findElement(By.id("advSrch_grid_agreement")).click();
					//Thread.sleep(4000);
					}
				
				//Find the Columns link and click the link
				 boolean columnSrch1 = driver.findElements(By.id("columns_grid_agreement")).size() >0;
					
					if ( ! columnSrch1)
					{
						sheet1.getRow(11).createCell(9).setCellValue("FAILED");
						sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						sheet1.getRow(11).createCell(9).setCellValue("PASSED");
						sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("columns_grid_agreement")).click();
						Thread.sleep(3000);
						}
					
					//Click the Columns cancel link
					boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[3]/div/button[2]")).size() >0;
					
					
					if ( ! closeButton)
					{
						
						sheet1.getRow(12).createCell(9).setCellValue("FAILED");
						sheet1.getRow(12).createCell(8).setCellValue("Close Column Search was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						sheet1.getRow(12).createCell(9).setCellValue("PASSED");
						sheet1.getRow(12).createCell(8).setCellValue("Close Column Search was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button[2]")).click();
						Thread.sleep(3000);
						}
				
					//Click the Agreement ID link filter
					boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
					
					
					if ( ! refreshButton)
					{
						
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("Grid was NOT Refreshed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						////driver.quit();
					}
					else
					{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("Grid was Refreshed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("refresh_grid_agreement")).click();
						Thread.sleep(4000);
						}
				
		
			
					//wb.close();	
					////driver.quit();
		}	

//TC521
@SuppressWarnings("resource")
@Test(priority=2)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC521_ColumnsAddRemove() throws Throwable {
	
	
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
	XSSFSheet sheet1=wb.getSheet("TC521");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	//String baseUrl ;
	//String loginUrl; 
	//String logoutUrl; 
	//String testUsername;
	//String testPassword ;
	//String agreementUrl ;
	//int agreementId ;
	//int numRows ;
	//String numPages;
	//int pageCounter;
	//String gridTitle = "agreement";
	
	
	
	//numRows = sheet1.getLastRowNum();
	
	
		//baseUrl = sheet1.getRow(1).getCell(0).getStringCellValue();
		//logoutUrl = baseUrl + "/auth/logout"; 
		//loginUrl = baseUrl + "/auth/login"; 
		//testUsername = sheet1.getRow(1).getCell(1).getStringCellValue();
		//testPassword = sheet1.getRow(1).getCell(2).getStringCellValue();
		

				
		//find the dash board tab and click
		boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
		//Assert.assertTrue(actualResult);
		if(! actualResult3)
		{
			sheet1.getRow(7).createCell(9).setCellValue("FAILED");
			sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
			
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
		boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
		
		if( ! installedBase)
		{
			//If the tab is not greater than "0", then show "failed"
			sheet1.getRow(8).createCell(9).setCellValue("FAILED");
			sheet1.getRow(8).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();

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
		boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
				
		if( ! agreementTab)
		{
			//If the tab is not greater than "0", then show "failed"
			sheet1.getRow(9).createCell(9).setCellValue("FAILED");
			sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();

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
		
		 //Find the Columns link
		 boolean columnSrch = driver.findElements(By.id("columns_grid_agreement")).size() >0;
		
		if ( ! columnSrch)
		{
			sheet1.getRow(10).createCell(9).setCellValue("FAILED");
			sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was NOT Displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(10).createCell(9).setCellValue("PASSED");
			sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was Displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//driver.findElement(By.id("advSrch_grid_agreement")).click();
			//Thread.sleep(4000);
			}
		
		//Find the Columns link and click the link
		 boolean columnSrch1 = driver.findElements(By.id("columns_grid_agreement")).size() >0;
			
			if ( ! columnSrch1)
			{
				sheet1.getRow(11).createCell(9).setCellValue("FAILED");
				sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was NOT Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(11).createCell(9).setCellValue("PASSED");
				sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("columns_grid_agreement")).click();
				Thread.sleep(3000);
				}
			
			//Find the Remove All link and click
			 boolean columnSrch2 = driver.findElements(By.cssSelector(".remove-all")).size() >0;
				
				if ( ! columnSrch2)
				{
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".remove-all")).click();
					Thread.sleep(3000);
					}
				
				//Find the Add All link and click
				 boolean columnSrch3 = driver.findElements(By.cssSelector(".add-all")).size() >0;
					
					if ( ! columnSrch3)
					{
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("'Add All' Link was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("'Add All' Link was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".add-all")).click();
						Thread.sleep(3000);
						}
			
			//Click the Agreement ID link filter
			//boolean closeButton = driver.findElements(By.xpath("//html/body/div[13]/div[1]/button")).size() >0;
			boolean closeButton = driver.findElements(By.xpath("//button[contains(.,'Ok')]")).size() >0;
			
			if ( ! closeButton)
			{
				
				sheet1.getRow(14).createCell(9).setCellValue("FAILED");
				sheet1.getRow(14).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(14).createCell(9).setCellValue("PASSED");
				sheet1.getRow(14).createCell(8).setCellValue("Close Advanced Search was Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//driver.findElement(By.xpath("//html/body/div[13]/div[1]/button")).click();
				driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
				Thread.sleep(3000);
				}
		
			//Click the Agreement ID link filter
			boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
			
			
			if ( ! refreshButton)
			{
				
				sheet1.getRow(15).createCell(9).setCellValue("FAILED");
				sheet1.getRow(15).createCell(8).setCellValue("Grid was NOT Refreshed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(15).createCell(9).setCellValue("PASSED");
				sheet1.getRow(15).createCell(8).setCellValue("Grid was Refreshed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(4000);
				}
		

	
			//wb.close();	
			////driver.quit();
}	

//TC522
@SuppressWarnings("resource")
@Test(priority=3)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC522_ColumnSearchFilter() throws Throwable {
	
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
		XSSFSheet sheet1=wb.getSheet("TC522");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword;
		
		String column1;
		String column2;
		String column3;
		String column4;
		String column5;
		String column6;
		String column7;
		String column8;
		String column9;
		String column10;
		String column11;
		String column12;
		String column13;
		String column14;
		String column15;
		String column16;
		String column17;
		String column18;
		String column19;
		String column20;
		String column21;
		String column22;
		String column23;
		String column24;
		String column25;
		String column26;
		String column27;
		String column28;
		String column29;
		String column30;
		String column31;
		String column32;
		String column33;
		
	

		//baseUrl = sheet1.getRow(1).getCell(0).getStringCellValue();
		//logoutUrl = baseUrl + "/auth/logout"; 
		//loginUrl = baseUrl + "/auth/login"; 
		//testUsername = sheet1.getRow(1).getCell(1).getStringCellValue();
		//testPassword = sheet1.getRow(1).getCell(2).getStringCellValue();
		
		column1 = sheet1.getRow(3).getCell(10).getStringCellValue();
	    column2 = sheet1.getRow(4).getCell(10).getStringCellValue();
	    column3 = sheet1.getRow(5).getCell(10).getStringCellValue();
		column4 = sheet1.getRow(6).getCell(10).getStringCellValue();
		column5 = sheet1.getRow(7).getCell(10).getStringCellValue();
		column6 = sheet1.getRow(8).getCell(10).getStringCellValue();
		column7 = sheet1.getRow(9).getCell(10).getStringCellValue();
		column8 = sheet1.getRow(10).getCell(10).getStringCellValue();
		column9 = sheet1.getRow(11).getCell(10).getStringCellValue();
		column10 = sheet1.getRow(12).getCell(10).getStringCellValue();
		column11 = sheet1.getRow(13).getCell(10).getStringCellValue();
		column12 = sheet1.getRow(14).getCell(10).getStringCellValue();
		column13 = sheet1.getRow(15).getCell(10).getStringCellValue();
		column14 = sheet1.getRow(16).getCell(10).getStringCellValue();
		column15 = sheet1.getRow(17).getCell(10).getStringCellValue();
		column16 = sheet1.getRow(18).getCell(10).getStringCellValue();
		column17 = sheet1.getRow(19).getCell(10).getStringCellValue();
		column18 = sheet1.getRow(20).getCell(10).getStringCellValue();
		column19 = sheet1.getRow(21).getCell(10).getStringCellValue();
		column20 = sheet1.getRow(22).getCell(10).getStringCellValue();
		column21 = sheet1.getRow(23).getCell(10).getStringCellValue();
		column22 = sheet1.getRow(24).getCell(10).getStringCellValue();
		column23 = sheet1.getRow(25).getCell(10).getStringCellValue();
		column24 = sheet1.getRow(26).getCell(10).getStringCellValue();
		column25 = sheet1.getRow(27).getCell(10).getStringCellValue();
		column26 = sheet1.getRow(28).getCell(10).getStringCellValue();
		column27 = sheet1.getRow(29).getCell(10).getStringCellValue();
		column28 = sheet1.getRow(30).getCell(10).getStringCellValue();
		column29 = sheet1.getRow(31).getCell(10).getStringCellValue();
		column30 = sheet1.getRow(32).getCell(10).getStringCellValue();
		column31 = sheet1.getRow(33).getCell(10).getStringCellValue();
		column32 = sheet1.getRow(34).getCell(10).getStringCellValue();
		column33 = sheet1.getRow(35).getCell(10).getStringCellValue();
		
		
		
//driver.get(logoutUrl);
//Thread.sleep(2000);
//driver.get(loginUrl);
//Thread.sleep(2000);
					
						
			//find the dash board tab and click
			boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
				
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
			boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
			
			if( ! installedBase)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
				sheet1.getRow(8).createCell(8).setCellValue("Installed Base Tab menu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();

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
			boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
					
			if( ! agreementTab)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();

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
			
			 //Find the Columns link
			 boolean columnSrch = driver.findElements(By.id("columns_grid_agreement")).size() >0;
			
			if ( ! columnSrch)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//driver.findElement(By.id("advSrch_grid_agreement")).click();
				//Thread.sleep(4000);
				}

	//Find the Columns link and click the link
	 boolean columnSrch1 = driver.findElements(By.id("columns_grid_agreement")).size() >0;
		
		if ( ! columnSrch1)
		{
			sheet1.getRow(11).createCell(9).setCellValue("FAILED");
			sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was NOT Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(11).createCell(9).setCellValue("PASSED");
			sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("columns_grid_agreement")).click();
			Thread.sleep(3000);
			}
	
	//Find the Remove All link and click
	 boolean columnSrch2 = driver.findElements(By.cssSelector(".remove-all")).size() >0;
		
		if ( ! columnSrch2)
		{
			sheet1.getRow(12).createCell(9).setCellValue("FAILED");
			sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was NOT Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(12).createCell(9).setCellValue("PASSED");
			sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.cssSelector(".remove-all")).click();
			Thread.sleep(3000);
			}

//Find the Column search box and click
 boolean ColumnFilterSrch = driver.findElements(By.cssSelector(".search")).size() >0;
			
	if ( ! ColumnFilterSrch)
	{
				sheet1.getRow(13).createCell(9).setCellValue("FAILED");
				sheet1.getRow(13).createCell(8).setCellValue("'Filter box' for columns was NOT selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
	}
	else
	{
				sheet1.getRow(13).createCell(9).setCellValue("PASSED");
				sheet1.getRow(13).createCell(8).setCellValue("'Filter box' for columns is selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".search")).clear();
				driver.findElement(By.cssSelector(".search")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
	
				
				driver.findElement(By.cssSelector(".search")).click();
			    driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column1));
				Thread.sleep(2000);
	
	//Click in search box and send the term "ID"
	boolean ColumnIDSrch1 = driver.findElements(By.id("ID_column_select")).size() >0;
				
		if ( ! ColumnIDSrch1)
		{
				sheet1.getRow(14).createCell(9).setCellValue("FAILED");
				sheet1.getRow(14).createCell(8).setCellValue("'ID' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
		}
		else
		{
				sheet1.getRow(14).createCell(9).setCellValue("PASSED");
				sheet1.getRow(14).createCell(8).setCellValue("'ID' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("ID_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
				
				
				driver.findElement(By.cssSelector(".search")).click();
			    driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column2));
				Thread.sleep(2000);
						
	//Click in search box and send the term "CustomerSiteID"
		boolean ColumnIDSrch2 = driver.findElements(By.id("CustomerSiteID_column_select")).size() >0;
								
			if ( ! ColumnIDSrch2)
			{
				sheet1.getRow(15).createCell(9).setCellValue("FAILED");
				sheet1.getRow(15).createCell(8).setCellValue("'CustomerSiteID' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(15).createCell(9).setCellValue("PASSED");
				sheet1.getRow(15).createCell(8).setCellValue("'CustomerSiteID' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("CustomerSiteID_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column3));
				Thread.sleep(2000);
				
	//Click in search box and send the term "ParentAgreementNumber"
			
		boolean ColumnIDSrch3 = driver.findElements(By.id("ParentAgreementNumber_column_select")).size()>0;
									
			if ( ! ColumnIDSrch3)
			{
				sheet1.getRow(16).createCell(9).setCellValue("FAILED");
				sheet1.getRow(16).createCell(8).setCellValue("'ParentAgreementNumber' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(16).createCell(9).setCellValue("PASSED");
				sheet1.getRow(16).createCell(8).setCellValue("'ParentAgreementNumber' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("ParentAgreementNumber_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column4));
				Thread.sleep(2000);
	
			
	//Click in search box and send the term "Agreement_Type"
	
	boolean ColumnIDSrch4 = driver.findElements(By.id("Agreement_Type_column_select")).size()>0;
								
		if ( ! ColumnIDSrch4)
		{
			sheet1.getRow(17).createCell(9).setCellValue("FAILED");
			sheet1.getRow(17).createCell(8).setCellValue("'Agreement_Type' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(17).createCell(9).setCellValue("PASSED");
			sheet1.getRow(17).createCell(8).setCellValue("'Agreement_Type' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Agreement_Type_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column5));
			Thread.sleep(2000);
					
	//Click in search box and send the term "StartDate"
	
	boolean ColumnIDSrch5 = driver.findElements(By.id("StartDate_column_select")).size()>0;
								
		if ( ! ColumnIDSrch5)
		{
			sheet1.getRow(18).createCell(9).setCellValue("FAILED");
			sheet1.getRow(18).createCell(8).setCellValue("'StartDate' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(18).createCell(9).setCellValue("PASSED");
			sheet1.getRow(18).createCell(8).setCellValue("'StartDate' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("StartDate_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column6));
			Thread.sleep(2000);
	
	//Click in search box and send the term "EndDate"
	
	boolean ColumnIDSrch6 = driver.findElements(By.id("EndDate_column_select")).size()>0;
								
		if ( ! ColumnIDSrch6)
		{
			sheet1.getRow(19).createCell(9).setCellValue("FAILED");
			sheet1.getRow(19).createCell(8).setCellValue("'EndDate' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(19).createCell(9).setCellValue("PASSED");
			sheet1.getRow(19).createCell(8).setCellValue("'EndDate' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("EndDate_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column7));
			Thread.sleep(2000);
		
	//Click in search box and send the term "AgreementTypeID"
	
	boolean ColumnIDSrch7 = driver.findElements(By.id("AgreementTypeID_column_select")).size()>0;
								
		if ( ! ColumnIDSrch7)
		{
			sheet1.getRow(20).createCell(9).setCellValue("FAILED");
			sheet1.getRow(20).createCell(8).setCellValue("'AgreementTypeID' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(20).createCell(9).setCellValue("PASSED");
			sheet1.getRow(20).createCell(8).setCellValue("'AgreementTypeID' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("AgreementTypeID_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column8));
			Thread.sleep(2000);
	
	//Click in search box and send the term "AgreementNumber"
	
	boolean ColumnIDSrch8 = driver.findElements(By.id("AgreementNumber_column_select")).size()>0;
								
		if ( ! ColumnIDSrch8)
		{
			sheet1.getRow(21).createCell(9).setCellValue("FAILED");
			sheet1.getRow(21).createCell(8).setCellValue("'AgreementNumber' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(21).createCell(9).setCellValue("PASSED");
			sheet1.getRow(21).createCell(8).setCellValue("'AgreementNumber' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("AgreementNumber_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column9));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Days_to_Expiration"
	
	boolean ColumnIDSrch9 = driver.findElements(By.id("Days_to_Expiration_column_select")).size()>0;
								
		if ( ! ColumnIDSrch9)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("'Days_to_Expiration' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("'Days_to_Expiration' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Days_to_Expiration_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column10));
			Thread.sleep(2000);
	//Click in search box and send the term "CF_License_Value"
	
	boolean ColumnIDSrch10 = driver.findElements(By.id("CF_License_Value_column_select")).size()>0;
								
		if ( ! ColumnIDSrch10)
		{
			sheet1.getRow(23).createCell(9).setCellValue("FAILED");
			sheet1.getRow(23).createCell(8).setCellValue("'CF_License_Value' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(23).createCell(9).setCellValue("PASSED");
			sheet1.getRow(23).createCell(8).setCellValue("'CF_License_Value' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("CF_License_Value_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column11));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Estimated_CF_Agreement_Value"
	
	boolean ColumnIDSrch11 = driver.findElements(By.id("Estimated_CF_Agreement_Value_column_select")).size()>0;
								
		if ( ! ColumnIDSrch11)
		{
			sheet1.getRow(24).createCell(9).setCellValue("FAILED");
			sheet1.getRow(24).createCell(8).setCellValue("'Estimated_CF_Agreement_Value' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(24).createCell(9).setCellValue("PASSED");
			sheet1.getRow(24).createCell(8).setCellValue("'Estimated_CF_Agreement_Value' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Estimated_CF_Agreement_Value_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column12));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Annualized_CF_Agreement_Value"
	
	boolean ColumnIDSrch12 = driver.findElements(By.id("Annualized_CF_Agreement_Value_column_select")).size()>0;
								
		if ( ! ColumnIDSrch12)
		{
			sheet1.getRow(25).createCell(9).setCellValue("FAILED");
			sheet1.getRow(25).createCell(8).setCellValue("'Annualized_CF_Agreement_Value' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(25).createCell(9).setCellValue("PASSED");
			sheet1.getRow(25).createCell(8).setCellValue("'Annualized_CF_Agreement_Value' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Annualized_CF_Agreement_Value_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column13));
			Thread.sleep(2000);
	//Click in search box and send the term "CFProgramLevelID"
	
	boolean ColumnIDSrch13 = driver.findElements(By.id("CFProgramLevelID_column_select")).size()>0;
								
		if ( ! ColumnIDSrch13)
		{
			sheet1.getRow(26).createCell(9).setCellValue("FAILED");
			sheet1.getRow(26).createCell(8).setCellValue("'CFProgramLevelID' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(26).createCell(9).setCellValue("PASSED");
			sheet1.getRow(26).createCell(8).setCellValue("'CFProgramLevelID' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("CFProgramLevelID_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column14));
			Thread.sleep(2000);
		
	//Click in search box and send the term "TAMFlag"
	
	boolean ColumnIDSrch14 = driver.findElements(By.id("TAMFlag_column_select")).size()>0;
								
		if ( ! ColumnIDSrch14)
		{
			sheet1.getRow(27).createCell(9).setCellValue("FAILED");
			sheet1.getRow(27).createCell(8).setCellValue("'CFProgramLevelID' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(27).createCell(9).setCellValue("PASSED");
			sheet1.getRow(27).createCell(8).setCellValue("'TAMFlag' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("TAMFlag_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column15));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Brand"
	
	boolean ColumnIDSrch15 = driver.findElements(By.id("Brand_column_select")).size()>0;
								
		if ( ! ColumnIDSrch15)
		{
			sheet1.getRow(28).createCell(9).setCellValue("FAILED");
			sheet1.getRow(28).createCell(8).setCellValue("'Brand' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(28).createCell(9).setCellValue("PASSED");
			sheet1.getRow(28).createCell(8).setCellValue("'Brand' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Brand_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column16));
			Thread.sleep(2000);
		
	//Click in search box and send the term "ActiveFlag"
	
	boolean ColumnIDSrch16 = driver.findElements(By.id("ActiveFlag_column_select")).size()>0;
								
		if ( ! ColumnIDSrch16)
		{
			sheet1.getRow(29).createCell(9).setCellValue("FAILED");
			sheet1.getRow(29).createCell(8).setCellValue("'ActiveFlag' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(29).createCell(9).setCellValue("PASSED");
			sheet1.getRow(29).createCell(8).setCellValue("'ActiveFlag' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("ActiveFlag_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column17));
			Thread.sleep(2000);
	//Click in search box and send the term "DistributorID"
	
	boolean ColumnIDSrch17 = driver.findElements(By.id("DistributorID_column_select")).size()>0;
								
		if ( ! ColumnIDSrch17)
		{
			sheet1.getRow(30).createCell(9).setCellValue("FAILED");
			sheet1.getRow(30).createCell(8).setCellValue("'DistributorID' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(30).createCell(9).setCellValue("PASSED");
			sheet1.getRow(30).createCell(8).setCellValue("'DistributorID' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("DistributorID_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column18));
			Thread.sleep(2000);
		//Click in search box and send the term "Disposition Code"
		
	boolean ColumnIDSrch18 = driver.findElements(By.id("Disposition_Code_column_select")).size()>0;
								
		if ( ! ColumnIDSrch18)
		{
			sheet1.getRow(31).createCell(9).setCellValue("FAILED");
			sheet1.getRow(31).createCell(8).setCellValue("'Disposition Code' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(31).createCell(9).setCellValue("PASSED");
			sheet1.getRow(31).createCell(8).setCellValue("'Disposition Code' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Disposition_Code_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column19));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Disposition"
	
	boolean ColumnIDSrch19 = driver.findElements(By.id("Disposition_column_select")).size()>0;
								
		if ( ! ColumnIDSrch19)
		{
			sheet1.getRow(32).createCell(9).setCellValue("FAILED");
			sheet1.getRow(32).createCell(8).setCellValue("'Disposition' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(32).createCell(9).setCellValue("PASSED");
			sheet1.getRow(32).createCell(8).setCellValue("'Disposition' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Disposition_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column20));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Category"
	
	boolean ColumnIDSrch20 = driver.findElements(By.id("category_column_select")).size()>0;
								
		if ( ! ColumnIDSrch20)
		{
			sheet1.getRow(33).createCell(9).setCellValue("FAILED");
			sheet1.getRow(33).createCell(8).setCellValue("'Category' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(33).createCell(9).setCellValue("PASSED");
			sheet1.getRow(33).createCell(8).setCellValue("'Category' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("category_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column21));
			Thread.sleep(2000);
	//Click in search box and send the term "Disposition_status"
	
	boolean ColumnIDSrch21 = driver.findElements(By.id("disposition_status_column_select")).size()>0;
								
		if ( ! ColumnIDSrch21)
		{
			sheet1.getRow(34).createCell(9).setCellValue("FAILED");
			sheet1.getRow(34).createCell(8).setCellValue("'Disposition_status' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(34).createCell(9).setCellValue("PASSED");
			sheet1.getRow(34).createCell(8).setCellValue("'Disposition_status' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("disposition_status_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column22));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Customer Type"
	
	boolean ColumnIDSrch22 = driver.findElements(By.id("CustomerType_column_select")).size()>0;
								
		if ( ! ColumnIDSrch22)
		{
			sheet1.getRow(35).createCell(9).setCellValue("FAILED");
			sheet1.getRow(35).createCell(8).setCellValue("'CustomerType' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(35).createCell(9).setCellValue("PASSED");
			sheet1.getRow(35).createCell(8).setCellValue("'CustomerType' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("CustomerType_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column23));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Address"
	
	boolean ColumnIDSrch23 = driver.findElements(By.id("Address_column_select")).size()>0;
								
		if ( ! ColumnIDSrch23)
		{
			sheet1.getRow(36).createCell(9).setCellValue("FAILED");
			sheet1.getRow(36).createCell(8).setCellValue("'Address' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(36).createCell(9).setCellValue("PASSED");
			sheet1.getRow(36).createCell(8).setCellValue("'Address' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Address_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column24));
			Thread.sleep(2000);
	//Click in search box and send the term "Address2"
	
	boolean ColumnIDSrch24 = driver.findElements(By.id("Address2_column_select")).size()>0;
								
		if ( ! ColumnIDSrch24)
		{
			sheet1.getRow(37).createCell(9).setCellValue("FAILED");
			sheet1.getRow(37).createCell(8).setCellValue("'Address2' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(37).createCell(9).setCellValue("PASSED");
			sheet1.getRow(37).createCell(8).setCellValue("'Address2' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Address2_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column25));
			Thread.sleep(2000);
	//Click in search box and send the term "City"
	
	boolean ColumnIDSrch25 = driver.findElements(By.id("City_column_select")).size()>0;
								
		if ( ! ColumnIDSrch25)
		{
			sheet1.getRow(38).createCell(9).setCellValue("FAILED");
			sheet1.getRow(38).createCell(8).setCellValue("'City' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(38).createCell(9).setCellValue("PASSED");
			sheet1.getRow(38).createCell(8).setCellValue("'City' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("City_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column26));
			Thread.sleep(2000);
		
	//Click in search box and send the term "StateProv"
	
	boolean ColumnIDSrch26 = driver.findElements(By.id("StateProv_column_select")).size()>0;
								
		if ( ! ColumnIDSrch26)
		{
			sheet1.getRow(39).createCell(9).setCellValue("FAILED");
			sheet1.getRow(39).createCell(8).setCellValue("'StateProv' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(39).createCell(9).setCellValue("PASSED");
			sheet1.getRow(39).createCell(8).setCellValue("'StateProv' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("StateProv_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column27));
			Thread.sleep(2000);
	//Click in search box and send the term "PostalCode"
	
	boolean ColumnIDSrch27 = driver.findElements(By.id("PostalCode_column_select")).size()>0;
								
		if ( ! ColumnIDSrch27)
		{
			sheet1.getRow(40).createCell(9).setCellValue("FAILED");
			sheet1.getRow(40).createCell(8).setCellValue("'PostalCode' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(40).createCell(9).setCellValue("PASSED");
			sheet1.getRow(40).createCell(8).setCellValue("'PostalCode' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("PostalCode_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column28));
			Thread.sleep(2000);
	//Click in search box and send the term "Country"
	
	boolean ColumnIDSrch28 = driver.findElements(By.id("Country_column_select")).size()>0;
								
		if ( ! ColumnIDSrch28)
		{
			sheet1.getRow(41).createCell(9).setCellValue("FAILED");
			sheet1.getRow(41).createCell(8).setCellValue("'Country' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(41).createCell(9).setCellValue("PASSED");
			sheet1.getRow(41).createCell(8).setCellValue("'Country' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Country_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column29));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Region"
	
	boolean ColumnIDSrch29 = driver.findElements(By.id("Region_column_select")).size()>0;
								
		if ( ! ColumnIDSrch29)
		{
			sheet1.getRow(42).createCell(9).setCellValue("FAILED");
			sheet1.getRow(42).createCell(8).setCellValue("'Region' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(42).createCell(9).setCellValue("PASSED");
			sheet1.getRow(42).createCell(8).setCellValue("'Region' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Region_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column30));
			Thread.sleep(2000);
		
	//Click in search box and send the term "CustomerSite Name"
	
	boolean ColumnIDSrch30 = driver.findElements(By.id("CustomerSiteName_column_select")).size()>0;
								
		if ( ! ColumnIDSrch30)
		{
			sheet1.getRow(43).createCell(9).setCellValue("FAILED");
			sheet1.getRow(43).createCell(8).setCellValue("'CustomerSiteName' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(43).createCell(9).setCellValue("PASSED");
			sheet1.getRow(43).createCell(8).setCellValue("'CustomerSiteName' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("CustomerSiteName_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column31));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Program_Level"
	
	boolean ColumnIDSrch31 = driver.findElements(By.id("Program_Level_column_select")).size()>0;
								
		if ( ! ColumnIDSrch31)
		{
			sheet1.getRow(44).createCell(9).setCellValue("FAILED");
			sheet1.getRow(44).createCell(8).setCellValue("'Program_Level' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(44).createCell(9).setCellValue("PASSED");
			sheet1.getRow(44).createCell(8).setCellValue("'Program_Level' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Program_Level_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column32));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Distributor Name"
	
	boolean ColumnIDSrch32 = driver.findElements(By.id("DistributorName_column_select")).size()>0;
								
		if ( ! ColumnIDSrch32)
		{
			sheet1.getRow(45).createCell(9).setCellValue("FAILED");
			sheet1.getRow(45).createCell(8).setCellValue("'Distributor Name' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(45).createCell(9).setCellValue("PASSED");
			sheet1.getRow(45).createCell(8).setCellValue("'Distributor Name' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("DistributorName_column_select")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".search")).clear();
			Thread.sleep(2000);
			}
		
			
			driver.findElement(By.cssSelector(".search")).click();
			driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column33));
			Thread.sleep(2000);
		
	//Click in search box and send the term "Account Name"

	
	boolean ColumnIDSrch33 = driver.findElements(By.id("AccountName_column_select")).size()>0;
								
		if ( ! ColumnIDSrch33)
		{
			sheet1.getRow(46).createCell(9).setCellValue("FAILED");
			sheet1.getRow(46).createCell(8).setCellValue("'Account Name' term was NOT Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(46).createCell(9).setCellValue("PASSED");
			sheet1.getRow(46).createCell(8).setCellValue("'Account Name' term was Entered");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("AccountName_column_select")).click();
			Thread.sleep(3000);
		}
			

//Find the Add All link and click
 boolean columnSrch3 = driver.findElements(By.cssSelector(".add-all")).size() >0;
	
		if ( ! columnSrch3)
		{
			sheet1.getRow(47).createCell(9).setCellValue("FAILED");
			sheet1.getRow(47).createCell(8).setCellValue("'Add All' Link was NOT Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet1.getRow(47).createCell(9).setCellValue("PASSED");
			sheet1.getRow(47).createCell(8).setCellValue("'Add All' Link was Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.cssSelector(".add-all")).click();
			Thread.sleep(3000);
			}

	//Click on the "X" to close the Column Filter
		
	boolean closeButton = driver.findElements(By.xpath("//button[contains(.,'Ok')]")).size() >0;
	
	if ( ! closeButton)
	{
		
		sheet1.getRow(48).createCell(9).setCellValue("FAILED");
		sheet1.getRow(48).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		//driver.quit();
	}
	else
	{
		sheet1.getRow(48).createCell(9).setCellValue("PASSED");
		sheet1.getRow(48).createCell(8).setCellValue("Close Advanced Search was Initiated");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
		Thread.sleep(3000);
		}

	//Click the Agreement Grid Refresh link
	boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
	
	
	if ( ! refreshButton)
	{
		
		sheet1.getRow(49).createCell(9).setCellValue("FAILED");
		sheet1.getRow(49).createCell(8).setCellValue("Grid was NOT Refreshed");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		//driver.quit();
	}
	else
	{
		sheet1.getRow(49).createCell(9).setCellValue("PASSED");
		sheet1.getRow(49).createCell(8).setCellValue("Grid was Refreshed");
		//sheet2.getRow(7).createCell(4).setCellValue("PASSED");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		driver.findElement(By.id("refresh_grid_agreement")).click();
		Thread.sleep(4000);
		}


	
		//wb.close();	
		////driver.quit();
}	

//TC523
@SuppressWarnings("resource")
@Test(priority=4)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC523_ColumnsGridCount() throws Throwable {
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC523");
		//XSSFSheet sheet2=wb.getSheet("All_TC_Results");
		
		
		//String baseUrl ;
		//String loginUrl; 
		//String logoutUrl; 
		//String testUsername;
		//String testPassword ;
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
	
				
			//find the dash board tab and click
			boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
				
			}
			else
			{
				sheet1.getRow(7).createCell(9).setCellValue("PASSED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was found and displayed");
				FileOutputStream fout=new FileOutputStream(src);
				driver.findElement(By.id("dashboard")).click();
				Thread.sleep(5000);
				wb.write(fout);
			}
			
			//Click on the Installed Base Tab
			boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
			
			if( ! installedBase)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
				sheet1.getRow(8).createCell(8).setCellValue("Installed Base tab was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(8).createCell(9).setCellValue("PASSED");
				sheet1.getRow(8).createCell(8).setCellValue("Installed Base tab was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("topmenuitem_31")).click();
				Thread.sleep(5000);
			}
			
			//Click on the Agreements tab
			boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
					
			if( ! agreementTab)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();

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
			
			 //Find the Columns link
			 boolean columnSrch = driver.findElements(By.id("columns_grid_agreement")).size() >0;
			
			if ( ! columnSrch)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//driver.findElement(By.id("advSrch_grid_agreement")).click();
				//Thread.sleep(4000);
				}
			
			//Find the Columns link and click the link
			 boolean columnSrch1 = driver.findElements(By.id("columns_grid_agreement")).size() >0;
				
				if ( ! columnSrch1)
				{
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("columns_grid_agreement")).click();
					Thread.sleep(3000);
					}
				
				//Find the Remove All link and click
				 boolean columnSrch2 = driver.findElements(By.cssSelector(".remove-all")).size() >0;
					
					if ( ! columnSrch2)
					{
						sheet1.getRow(12).createCell(9).setCellValue("FAILED");
						sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						sheet1.getRow(12).createCell(9).setCellValue("PASSED");
						sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".remove-all")).click();
						Thread.sleep(3000);
						}
					
				//Find the Add All link and click
				 boolean columnSrch3 = driver.findElements(By.cssSelector(".add-all")).size() >0;
						
					if ( ! columnSrch3)
						{
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("'Add All' Link was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
						}
					else
						{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("'Add All' Link was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".add-all")).click();
						Thread.sleep(3000);
						}
						
												
				//Click the Agreement ID link filter
				boolean closeButton = driver.findElements(By.xpath("//button[contains(.,'Ok')]")).size() >0;
				
				
				if ( ! closeButton)
				{
					
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Close Advanced Search was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'Ok')]")).click();
					Thread.sleep(3000);
					}
		
				
				//Click the Agreement ID link filter
				boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				
				if ( ! refreshButton)
				{
					
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("Grid was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("Grid was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(4000);
					}
				
				//Find the ID column on the Agreement Grid
				WebElement element = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.id"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				//boolean IDColumn = driver.findElements(By.id("pg_selbox_bottom_grid_" + gridTitle)).size() >0;
				boolean IDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.id")).size() >0;
				
				
				if ( ! IDColumn)
				{
					
					sheet1.getRow(16).createCell(9).setCellValue("FAILED");
					sheet1.getRow(16).createCell(8).setCellValue("ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(16).createCell(9).setCellValue("PASSED");
					sheet1.getRow(16).createCell(8).setCellValue("ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.id")).click();
					Thread.sleep(4000);
					
					}
				
				//Find the Customer Site ID column on the Agreement Grid
				WebElement element1 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteID"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
				Thread.sleep(4000);
				boolean CustomerSiteIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteID")).size() >0;
				
				
				if ( ! CustomerSiteIDColumn)
				{
					
					sheet1.getRow(17).createCell(9).setCellValue("FAILED");
					sheet1.getRow(17).createCell(8).setCellValue("CustomerSiteID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(17).createCell(9).setCellValue("PASSED");
					sheet1.getRow(17).createCell(8).setCellValue("CustomerSiteID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element1.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteID")).click();
					Thread.sleep(2000);
					}
				
				//Find the Parent Agreement Number column on the Agreement Grid
				WebElement element2 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.ParentAgreementNumber"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
				Thread.sleep(4000);
				boolean ParentAgreementNumberColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.ParentAgreementNumber")).size() >0;
				
				
				if ( ! ParentAgreementNumberColumn)
				{
					
					sheet1.getRow(18).createCell(9).setCellValue("FAILED");
					sheet1.getRow(18).createCell(8).setCellValue("Parent Agreement Number Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(18).createCell(9).setCellValue("PASSED");
					sheet1.getRow(18).createCell(8).setCellValue("Parent Agreement Number Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element2.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.ParentAgreementNumber")).click();
					Thread.sleep(2000);
					}
				
				//Find the Agreement Type column on the Agreement Grid
				WebElement element3 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.agreement_type__Description"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
				Thread.sleep(4000);
				boolean AgreementTypeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.agreement_type__Description")).size() >0;
				
				
				if ( ! AgreementTypeColumn)
				{
					
					sheet1.getRow(19).createCell(9).setCellValue("FAILED");
					sheet1.getRow(19).createCell(8).setCellValue("Agreement Type Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(19).createCell(9).setCellValue("PASSED");
					sheet1.getRow(19).createCell(8).setCellValue("Agreement Type Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element3.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.agreement_type__Description")).click();
					Thread.sleep(2000);
					}
				
				//Find the Start Date ID column on the Agreement Grid
				WebElement element4 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.StartDate"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
				Thread.sleep(4000);
				boolean StartDateColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.StartDate")).size() >0;
				
				
				if ( ! StartDateColumn)
				{
					
					sheet1.getRow(20).createCell(9).setCellValue("FAILED");
					sheet1.getRow(20).createCell(8).setCellValue("Start Date Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(20).createCell(9).setCellValue("PASSED");
					sheet1.getRow(20).createCell(8).setCellValue("Start Date Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element4.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.StartDate")).click();
					Thread.sleep(2000);
					}
				
				//Find the End Date ID column on the Agreement Grid
				WebElement element5 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.EndDate"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
				Thread.sleep(4000);
				boolean EndDateColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.EndDate")).size() >0;
				
				
				if ( ! EndDateColumn)
				{
					
					sheet1.getRow(21).createCell(9).setCellValue("FAILED");
					sheet1.getRow(21).createCell(8).setCellValue("End Date Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(21).createCell(9).setCellValue("PASSED");
					sheet1.getRow(21).createCell(8).setCellValue("End Date Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element5.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.EndDate")).click();
					Thread.sleep(2000);
					}
				
				//Find the Agreement Type ID column on the Agreement Grid
				WebElement element6 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AgreementTypeID"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element6);
				Thread.sleep(4000);
				boolean AgreementTypeIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.AgreementTypeID")).size() >0;
				
				
				if ( ! AgreementTypeIDColumn)
				{
					
					sheet1.getRow(22).createCell(9).setCellValue("FAILED");
					sheet1.getRow(22).createCell(8).setCellValue("Agreement Type ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(22).createCell(9).setCellValue("PASSED");
					sheet1.getRow(22).createCell(8).setCellValue("Agreement Type ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element6.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AgreementTypeID")).click();
					Thread.sleep(2000);
					}
				
				//Find the Agreement Number ID column on the Agreement Grid
				WebElement element7 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AgreementNumber"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element7);
				Thread.sleep(4000);
				boolean AgreementNumberColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.AgreementNumber")).size() >0;
				
				
				if ( ! AgreementNumberColumn)
				{
					
					sheet1.getRow(23).createCell(9).setCellValue("FAILED");
					sheet1.getRow(23).createCell(8).setCellValue("Agreement Number Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(23).createCell(9).setCellValue("PASSED");
					sheet1.getRow(23).createCell(8).setCellValue("Agreement Number Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element7.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AgreementNumber")).click();
					Thread.sleep(2000);
					}
				
				//Find the Days To Expire column on the Agreement Grid
				WebElement element8 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Days_to_Expiration"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element8);
				Thread.sleep(4000);
				boolean DaysToExpireColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Days_to_Expiration")).size() >0;
				
				
				if ( ! DaysToExpireColumn)
				{
					
					sheet1.getRow(24).createCell(9).setCellValue("FAILED");
					sheet1.getRow(24).createCell(8).setCellValue("Days To Expire Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(24).createCell(9).setCellValue("PASSED");
					sheet1.getRow(24).createCell(8).setCellValue("Days To Expire Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element8.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Days_to_Expiration")).click();
					Thread.sleep(2000);
					}
				
				//Find the CF License Value Column on the Agreement Grid
				WebElement element9 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CF_License_Value"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element9);
				Thread.sleep(4000);
				boolean CFLicenseValueColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CF_License_Value")).size() >0;
				
				
				if ( ! CFLicenseValueColumn)
				{
					
					sheet1.getRow(25).createCell(9).setCellValue("FAILED");
					sheet1.getRow(25).createCell(8).setCellValue("CF License Value Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(25).createCell(9).setCellValue("PASSED");
					sheet1.getRow(25).createCell(8).setCellValue("CF License Value Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element9.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CF_License_Value")).click();
					Thread.sleep(2000);
					}
				
				//Find the Estimated CF Agreement Value Column on the Agreement Grid
				WebElement element10 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Estimated_CF_Agreement_Value"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element10);
				Thread.sleep(4000);
				boolean EstimatedCFValueColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Estimated_CF_Agreement_Value")).size() >0;
				
				
				if ( ! EstimatedCFValueColumn)
				{
					
					sheet1.getRow(26).createCell(9).setCellValue("FAILED");
					sheet1.getRow(26).createCell(8).setCellValue("Estimated CF Agreement Value Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(26).createCell(9).setCellValue("PASSED");
					sheet1.getRow(26).createCell(8).setCellValue("Estimated CF Agreement Value Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element10.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Estimated_CF_Agreement_Value")).click();
					Thread.sleep(2000);
					}
				
				//Find the Annualized CF Agreement Value Column on the Agreement Grid
				WebElement element11 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Annualized_CF_Agreement_Value"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element11);
				Thread.sleep(4000);
				boolean AnnualizedCFValueColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Annualized_CF_Agreement_Value")).size() >0;
				
				
				if ( ! AnnualizedCFValueColumn)
				{
					
					sheet1.getRow(27).createCell(9).setCellValue("FAILED");
					sheet1.getRow(27).createCell(8).setCellValue("Annualized CF Agreement Value Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(27).createCell(9).setCellValue("PASSED");
					sheet1.getRow(27).createCell(8).setCellValue("Annualized CF Agreement Value Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element11.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Annualized_CF_Agreement_Value")).click();
					Thread.sleep(2000);
					}
				
				//Find the CF Program Level ID Column on the Agreement Grid
				WebElement element12 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CFProgramLevelID"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element12);
				Thread.sleep(4000);
				boolean CFProgramLevelIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CFProgramLevelID")).size() >0;
				
				
				if ( ! CFProgramLevelIDColumn)
				{
					
					sheet1.getRow(28).createCell(9).setCellValue("FAILED");
					sheet1.getRow(28).createCell(8).setCellValue("CF Program Level ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(28).createCell(9).setCellValue("PASSED");
					sheet1.getRow(28).createCell(8).setCellValue("CF Program Level ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element12.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CFProgramLevelID")).click();
					Thread.sleep(2000);
					}
				
				//Find the TAM flag Column on the Agreement Grid
				WebElement element13 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.TAMFlag"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element13);
				Thread.sleep(4000);
				boolean TAMflagColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.TAMFlag")).size() >0;
				
				
				if ( ! TAMflagColumn)
				{
					
					sheet1.getRow(29).createCell(9).setCellValue("FAILED");
					sheet1.getRow(29).createCell(8).setCellValue("TAM flag Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(29).createCell(9).setCellValue("PASSED");
					sheet1.getRow(29).createCell(8).setCellValue("TAM flag Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element13.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.TAMFlag")).click();
					Thread.sleep(2000);
					}
				
				//Find the Brand Column on the Agreement Grid
				WebElement element14 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Source"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element14);
				Thread.sleep(4000);
				boolean BrandColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Source")).size() >0;
				
				
				if ( ! BrandColumn)
				{
					
					sheet1.getRow(30).createCell(9).setCellValue("FAILED");
					sheet1.getRow(30).createCell(8).setCellValue("Brand Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(30).createCell(9).setCellValue("PASSED");
					sheet1.getRow(30).createCell(8).setCellValue("Brand Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element14.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Source")).click();
					Thread.sleep(2000);
					}
				
				//Find the Active flag Column on the Agreement Grid
				WebElement element15 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.ActiveFlag"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element15);
				Thread.sleep(4000);
				boolean ActiveflagColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.ActiveFlag")).size() >0;
				
				
				if ( ! ActiveflagColumn)
				{
					
					sheet1.getRow(31).createCell(9).setCellValue("FAILED");
					sheet1.getRow(31).createCell(8).setCellValue("Active flag Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(31).createCell(9).setCellValue("PASSED");
					sheet1.getRow(31).createCell(8).setCellValue("Active flag Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element15.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.ActiveFlag")).click();
					Thread.sleep(2000);
					}
				
				//Find the Distributor ID Column on the Agreement Grid
				WebElement element16 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.DistributorID"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element16);
				Thread.sleep(4000);
				boolean DistributorIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.DistributorID")).size() >0;
				
				
				if ( ! DistributorIDColumn)
				{
					
					sheet1.getRow(32).createCell(9).setCellValue("FAILED");
					sheet1.getRow(32).createCell(8).setCellValue("Distributor ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(32).createCell(9).setCellValue("PASSED");
					sheet1.getRow(32).createCell(8).setCellValue("Distributor ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element16.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.DistributorID")).click();
					Thread.sleep(2000);
					}
				
						
				//Find the Disposition Code Column on the Agreement Grid
				WebElement element17 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_code"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element17);
				Thread.sleep(4000);
				boolean DispositionCodeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.disposition_code")).size() >0;
				
				
				if ( ! DispositionCodeColumn)
				{
					
					sheet1.getRow(33).createCell(9).setCellValue("FAILED");
					sheet1.getRow(33).createCell(8).setCellValue("Disposition Code Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(33).createCell(9).setCellValue("PASSED");
					sheet1.getRow(33).createCell(8).setCellValue("Disposition Code Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element17.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_code")).click();
					Thread.sleep(2000);
					}
				
				//Find the Disposition Column on the Agreement Grid
				WebElement element18 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition__description"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element18);
				Thread.sleep(4000);
				boolean DispositionColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.disposition__description")).size() >0;
				
				
				if ( ! DispositionColumn)
				{
					
					sheet1.getRow(34).createCell(9).setCellValue("FAILED");
					sheet1.getRow(34).createCell(8).setCellValue("Disposition Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(34).createCell(9).setCellValue("PASSED");
					sheet1.getRow(34).createCell(8).setCellValue("Disposition Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element18.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_description")).click();
					Thread.sleep(2000);
					}
				
				//Find the Category Column on the Agreement Grid
				WebElement element19 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.category"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element19);
				Thread.sleep(4000);
				boolean categoryColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.category")).size() >0;
				
				
				if ( ! categoryColumn)
				{
					
					sheet1.getRow(35).createCell(9).setCellValue("FAILED");
					sheet1.getRow(35).createCell(8).setCellValue("category Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(35).createCell(9).setCellValue("PASSED");
					sheet1.getRow(35).createCell(8).setCellValue("category Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element19.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.category")).click();
					Thread.sleep(2000);
					}
				
				//Find the disposition_status Column on the Agreement Grid
				WebElement element20 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_status"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element20);
				Thread.sleep(4000);
				boolean disposition_statusColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.disposition_status")).size() >0;
				
				
				if ( ! disposition_statusColumn)
				{
					
					sheet1.getRow(36).createCell(9).setCellValue("FAILED");
					sheet1.getRow(36).createCell(8).setCellValue("disposition_status Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(36).createCell(9).setCellValue("PASSED");
					sheet1.getRow(36).createCell(8).setCellValue("disposition_status Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element20.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_status")).click();
					Thread.sleep(2000);
					}
				
				//Find the CustomerType Column on the Agreement Grid
				WebElement element21 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerType"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element21);
				Thread.sleep(4000);
				boolean CustomerTypeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CustomerType")).size() >0;
				
				
				if ( ! CustomerTypeColumn)
				{
					
					sheet1.getRow(37).createCell(9).setCellValue("FAILED");
					sheet1.getRow(37).createCell(8).setCellValue("CustomerType Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(37).createCell(9).setCellValue("PASSED");
					sheet1.getRow(37).createCell(8).setCellValue("CustomerType Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element21.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerType")).click();
					Thread.sleep(2000);
					}
				
				//Find the Address Column on the Agreement Grid
				WebElement element22 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Address"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element22);
				Thread.sleep(4000);
				boolean addressColumn1 = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Address")).size() >0;
				
				
				if ( ! addressColumn1)
				{
					
					sheet1.getRow(38).createCell(9).setCellValue("FAILED");
					sheet1.getRow(38).createCell(8).setCellValue("Address Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(38).createCell(9).setCellValue("PASSED");
					sheet1.getRow(38).createCell(8).setCellValue("Address Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element22.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Address")).click();
					Thread.sleep(2000);
					}
				
				//Find the Address2 Column on the Agreement Grid
				WebElement element23 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Address2"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element23);
				Thread.sleep(4000);
				boolean address2Column = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Address2")).size() >0;
				
				
				if ( ! address2Column)
				{
					
					sheet1.getRow(39).createCell(9).setCellValue("FAILED");
					sheet1.getRow(39).createCell(8).setCellValue("Address2 Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(39).createCell(9).setCellValue("PASSED");
					sheet1.getRow(39).createCell(8).setCellValue("Address2 Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element23.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Address2")).click();
					Thread.sleep(2000);
					}
				
				//Find the City Column on the Agreement Grid
				WebElement element24 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.City"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element24);
				Thread.sleep(4000);
				boolean CityColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.City")).size() >0;
				
				
				if ( ! CityColumn)
				{
					
					sheet1.getRow(40).createCell(9).setCellValue("FAILED");
					sheet1.getRow(40).createCell(8).setCellValue("City Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(40).createCell(9).setCellValue("PASSED");
					sheet1.getRow(40).createCell(8).setCellValue("City Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element24.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.City")).click();
					Thread.sleep(2000);
					}
				
				//Find the StateProv Column on the Agreement Grid
				WebElement element25 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.StateProv"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element25);
				Thread.sleep(4000);
				boolean StateProvColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.StateProv")).size() >0;
				
				
				if ( ! StateProvColumn)
				{
					
					sheet1.getRow(41).createCell(9).setCellValue("FAILED");
					sheet1.getRow(41).createCell(8).setCellValue("StateProv Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(41).createCell(9).setCellValue("PASSED");
					sheet1.getRow(41).createCell(8).setCellValue("StateProv Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element25.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.StateProv")).click();
					Thread.sleep(2000);
					}
				
				//Find the PostalCode Column on the Agreement Grid
				WebElement element26 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.PostalCode"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element26);
				Thread.sleep(4000);
				boolean PostalCodeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.PostalCode")).size() >0;
				
				
				if ( ! PostalCodeColumn)
				{
					
					sheet1.getRow(42).createCell(9).setCellValue("FAILED");
					sheet1.getRow(42).createCell(8).setCellValue("PostalCode Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(42).createCell(9).setCellValue("PASSED");
					sheet1.getRow(42).createCell(8).setCellValue("PostalCode Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element26.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.PostalCode")).click();
					Thread.sleep(2000);
					}
				
				//Find the Country Column on the Agreement Grid
				WebElement element27 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Country"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element27);
				Thread.sleep(4000);
				boolean CountryColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Country")).size() >0;
				
				
				if ( ! CountryColumn)
				{
					
					sheet1.getRow(43).createCell(9).setCellValue("FAILED");
					sheet1.getRow(43).createCell(8).setCellValue("Country Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(43).createCell(9).setCellValue("PASSED");
					sheet1.getRow(43).createCell(8).setCellValue("Country Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element27.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Country")).click();
					Thread.sleep(2000);
					}
				
				//Find the Region Column on the Agreement Grid
				WebElement element28 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Region"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element28);
				Thread.sleep(4000);
				boolean RegionColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Region")).size() >0;
				
				
				if ( ! RegionColumn)
				{
					
					sheet1.getRow(44).createCell(9).setCellValue("FAILED");
					sheet1.getRow(44).createCell(8).setCellValue("Region Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(44).createCell(9).setCellValue("PASSED");
					sheet1.getRow(44).createCell(8).setCellValue("Region Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element28.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Region")).click();
					Thread.sleep(2000);
					}
				
				//Find the CustomerSiteName Column on the Agreement Grid
				WebElement element29 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteName"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element29);
				Thread.sleep(4000);
				boolean CustomerSiteNameColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteName")).size() >0;
				
				
				if ( ! CustomerSiteNameColumn)
				{
					
					sheet1.getRow(45).createCell(9).setCellValue("FAILED");
					sheet1.getRow(45).createCell(8).setCellValue("CustomerSiteName Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(45).createCell(9).setCellValue("PASSED");
					sheet1.getRow(45).createCell(8).setCellValue("CustomerSiteName Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element29.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteName")).click();
					Thread.sleep(2000);
					}
				
				//Find the Program_Level Column on the Agreement Grid
				WebElement element30 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.cf_program_level__Description"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element30);
				Thread.sleep(4000);
				boolean Program_LevelColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.cf_program_level__Description")).size() >0;
				
				
				if ( ! Program_LevelColumn)
				{
					
					sheet1.getRow(46).createCell(9).setCellValue("FAILED");
					sheet1.getRow(46).createCell(8).setCellValue("Program_Level Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(46).createCell(9).setCellValue("PASSED");
					sheet1.getRow(46).createCell(8).setCellValue("Program_Level Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element30.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.cf_program_level__Description")).click();
					Thread.sleep(2000);
					}
				
				//Find the DistributorName Column on the Agreement Grid
				WebElement element31 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.DistributorName"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element31);
				Thread.sleep(4000);
				boolean DistributorNameColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.DistributorName")).size() >0;
				
				
				if ( ! DistributorNameColumn)
				{
					
					sheet1.getRow(47).createCell(9).setCellValue("FAILED");
					sheet1.getRow(47).createCell(8).setCellValue("DistributorName Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(47).createCell(9).setCellValue("PASSED");
					sheet1.getRow(47).createCell(8).setCellValue("DistributorName Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element31.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.DistributorName")).click();
					Thread.sleep(2000);
					}
				
				//Find the AccountName Column on the Agreement Grid
				WebElement element32 = driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AccountName"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element32);
				Thread.sleep(4000);
				boolean AccountNameColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.AccountName")).size() >0;
				
				
				if ( ! AccountNameColumn)
				{
					
					sheet1.getRow(48).createCell(9).setCellValue("FAILED");
					sheet1.getRow(48).createCell(8).setCellValue("AccountName Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(48).createCell(9).setCellValue("PASSED");
					sheet1.getRow(48).createCell(8).setCellValue("AccountName Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					element31.click();
					//driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AccountName")).click();
					Thread.sleep(2000);
					}
				
				
				
				//Click the Agreement ID link filter
				/*boolean refreshButton2 = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				
				if ( ! refreshButton2)
				{
					
					sheet1.getRow(49).createCell(9).setCellValue("FAILED");
					sheet1.getRow(49).createCell(8).setCellValue("Grid was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(49).createCell(9).setCellValue("PASSED");
					sheet1.getRow(49).createCell(8).setCellValue("Grid was Refreshed");
					sheet2.getRow(7).createCell(4).setCellValue("PASSED");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(4000);
					}*/
		
		
	    wb.close();	
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
	 System.out.println("Exception while taking screenshot" + e.getMessage());
	 } 
	 }
////driver.quit();
}


private String timestamp() {
	// TODO Auto-generated method stub
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}




}

	



