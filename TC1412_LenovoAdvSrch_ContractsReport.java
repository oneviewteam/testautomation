package lenovoAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;

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
//import org.testng.annotations.Test;


public class TC1412_LenovoAdvSrch_ContractsReport {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;


	
	
	
	//@Test(priority=0)
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException { 
	
	//@SuppressWarnings("resource")
	//@Test(priority=1)
	//public  void quoteFromAgreement() throws Throwable {
		//public  void LenovoAdvSrch_ContractsReport() throws Throwable {
		
		
		
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_automation\\mmi_Lenovo_ auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\AdvanceSearch_SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
		//File src=new File("AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("\\mmi_automation\\mmi_auto_testing_AdvencedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Files\\Lenovo_AutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC1412");
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
			
		String Companies_Companies_Name;
		String Contracts_Addendum_Customer_Price;
		String Contracts_Contract_Billing_Frequency;
		String Contracts_Contract_Description;
		String Contracts_Contract_End_Date;
		String Contracts_Contract_Number;
		String Contracts_Contract_Start_Date;
		String Contracts_Contract_Term_Date;
		String Contracts_Contract_Type;
		String Contracts_Contracts_Id;
		String Contracts_Created_Date;
		String Contracts_Customer_Type;
		String Contracts_Denial_Date;
		String Contracts_Denial_Service;
		String Contracts_Invoice_Format;
		String Contracts_Line_Item_Active_Count;
		String Contracts_Line_Item_Gross_Profit;
		String Contracts_Line_Item_Total_Price;
		String Contracts_Po_By_Id;
		String Contracts_Provider_Contract_Number;
		String Contracts_Provider_Customer_Number;
		String Contracts_Region;
		String Contracts_Reinstatement_Date;
		String Contracts_Service_Provider_Name;
		String Tcv_Addendum_DTCV;
		String Tcv_Addendum_TCV;


		
		
		
		
		baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
		logoutUrl =baseUrl + "/auth/logout"; 
		loginUrl =baseUrl + "/auth/login"; 
		testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
		testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
		
		Companies_Companies_Name = sheet1.getRow(3).getCell(10).getStringCellValue();
		Contracts_Addendum_Customer_Price = sheet1.getRow(4).getCell(10).getStringCellValue();
		Contracts_Contract_Billing_Frequency = sheet1.getRow(5).getCell(10).getStringCellValue();
		Contracts_Contract_Description = sheet1.getRow(6).getCell(10).getStringCellValue();
		Contracts_Contract_End_Date = sheet1.getRow(7).getCell(10).getStringCellValue();
		Contracts_Contract_Number = sheet1.getRow(8).getCell(10).getStringCellValue();
		Contracts_Contract_Start_Date = sheet1.getRow(9).getCell(10).getStringCellValue();
		Contracts_Contract_Term_Date = sheet1.getRow(10).getCell(10).getStringCellValue();
		Contracts_Contract_Type = sheet1.getRow(11).getCell(10).getStringCellValue();
		Contracts_Contracts_Id = sheet1.getRow(12).getCell(10).getStringCellValue();
		Contracts_Created_Date = sheet1.getRow(13).getCell(10).getStringCellValue();
		Contracts_Customer_Type = sheet1.getRow(14).getCell(10).getStringCellValue();
		Contracts_Denial_Date = sheet1.getRow(15).getCell(10).getStringCellValue();
		Contracts_Denial_Service = sheet1.getRow(16).getCell(10).getStringCellValue();
		Contracts_Invoice_Format = sheet1.getRow(17).getCell(10).getStringCellValue();
		Contracts_Line_Item_Active_Count = sheet1.getRow(18).getCell(10).getStringCellValue();
		Contracts_Line_Item_Gross_Profit = sheet1.getRow(19).getCell(10).getStringCellValue();
		Contracts_Line_Item_Total_Price = sheet1.getRow(20).getCell(10).getStringCellValue();
		Contracts_Po_By_Id = sheet1.getRow(21).getCell(10).getStringCellValue();
		Contracts_Provider_Contract_Number = sheet1.getRow(22).getCell(10).getStringCellValue();
		Contracts_Provider_Customer_Number = sheet1.getRow(23).getCell(10).getStringCellValue();
		Contracts_Region = sheet1.getRow(24).getCell(10).getStringCellValue();
		Contracts_Reinstatement_Date = sheet1.getRow(25).getCell(10).getStringCellValue();
		Contracts_Service_Provider_Name = sheet1.getRow(26).getCell(10).getStringCellValue();
		Tcv_Addendum_DTCV = sheet1.getRow(27).getCell(10).getStringCellValue();
		Tcv_Addendum_TCV = sheet1.getRow(28).getCell(10).getStringCellValue();
		
		
		
		
			
			driver.get(logoutUrl);
			Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(2000);
			
			//Find the Language drop down and select English
			Boolean languageResult = driver.findElements(By.id("language_select")).size()>0; 
			
			if(! languageResult)
		         
          {
				sheet1.getRow(4).createCell(9).setCellValue("FAILED");
				sheet1.getRow(4).createCell(8).setCellValue("Language was NOT Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
	
			else 
			{
				sheet1.getRow(4).createCell(9).setCellValue("PASSED");
				sheet1.getRow(4).createCell(8).setCellValue("Language was Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Español");
				//Thread.sleep(1000);
				//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Italiano");
				//Thread.sleep(1000);
				//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Indonesia");
				//Thread.sleep(1000);
				//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Deutsche");
				//Thread.sleep(1000);
				//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Português");
				//Thread.sleep(1000);
				//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Melayu");
				//Thread.sleep(1000);
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("English");
				Thread.sleep(2000);
				
			}
		
			//find the email text box and send the email id
			Boolean actualResult = driver.findElements(By.id("email")).size()>0; 
			
			if(! actualResult)
		         
          {
				sheet1.getRow(5).createCell(9).setCellValue("FAILED");
				sheet1.getRow(5).createCell(8).setCellValue("Username was NOT Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
	
			else 
			{
				sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				sheet1.getRow(5).createCell(8).setCellValue("Username was Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("email")).sendKeys(testUsername);
				Thread.sleep(2000);
			}

			//Find the password text box and send the password id
			Boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
			
			if(! actualResult1)
		          
          {
				sheet1.getRow(6).createCell(9).setCellValue("FAILED");
				sheet1.getRow(6).createCell(8).setCellValue("Password was NOT Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
	
			else 
			{
				sheet1.getRow(6).createCell(9).setCellValue("PASSED");
				sheet1.getRow(6).createCell(8).setCellValue("Password was Input");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("password-text")).sendKeys(testPassword);
				Thread.sleep(2000);
			}
			
			//Click the Login button and wait for Login
			Boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
			
			if(! actualResult2)
		         
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Login button NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
	
			else 
			{
				sheet1.getRow(7).createCell(9).setCellValue("PASSED");
				sheet1.getRow(7).createCell(8).setCellValue("login button was found and clicked");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Login")).click();
				Thread.sleep(15000);
			}
				
			//find the Reports Dash board tab
			Boolean actualResult3 =  driver.findElements(By.id("content_pane")).size() >0;
			
			if(! actualResult3)
			{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
				sheet1.getRow(8).createCell(8).setCellValue("Dashboard was not displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
				
			}
			else
			{
				sheet1.getRow(8).createCell(9).setCellValue("PASSED");
				sheet1.getRow(8).createCell(8).setCellValue("Dashboard was found and displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				Thread.sleep(2000);
			}
			
			//Click on the Reports Tab
			Boolean reportsTab =  driver.findElements(By.id("topmenuitem_4")).size() >0;
			
			if( ! reportsTab)
			{
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("Reports Tab menu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				sheet1.getRow(9).createCell(9).setCellValue("PASSED");
				sheet1.getRow(9).createCell(8).setCellValue("Reports Tab menu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("topmenuitem_4")).click();
				Thread.sleep(7000);
			}
			
			//Click on the Reports Dash board tab
			Boolean reportsDashboard =  driver.findElements(By.id("dropdown_topmenuitem_4")).size() >0;
					
			if( ! reportsDashboard)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("Reports Tab Dashboard was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("Reports Tab Dashboard was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText("Report Dashboard")).click();
				Thread.sleep(4000);
			}
			
			//Find the Favorite Reports drop down and click
			if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
				 
				 driver.findElement(By.id("tabs_scroll_toggle")).click();
				 Thread.sleep(3000);}
			
			
			//jse.executeScript("window.scrollBy(0,650)", "");
			//Thread.sleep(1000);
			//jse.executeScript("window.scrollBy(0,-250)", "");
			
			if(driver.findElements(By.linkText("Shared Reports")).size()>0) {
				 
				 driver.findElement(By.linkText("Shared Reports")).click();
				 Thread.sleep(4000);}
			
			  //Find the General Reports Drop down Menu
			 Boolean hwReport = driver.findElements(By.linkText("Contract")).size() >0;
			
			if ( ! hwReport)
			{
				sheet1.getRow(11).createCell(9).setCellValue("FAILED");
				sheet1.getRow(11).createCell(8).setCellValue("'Contract' Report was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(11).createCell(9).setCellValue("PASSED");
				sheet1.getRow(11).createCell(8).setCellValue("'Contract' Report was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText("Contract")).click();
				Thread.sleep(6000);
				}
			
			jse.executeScript("window.scrollBy(0,-450)", "");
			Thread.sleep(1000);
			
			//Find the Columns button to open the Column Grid Selector
			Boolean ColumnsGrid = driver.findElements(By.id("grid_columns")).size() >0;
						
			if ( ! ColumnsGrid)
			{
				sheet1.getRow(12).createCell(9).setCellValue("FAILED");
				sheet1.getRow(12).createCell(8).setCellValue("Columns Grid button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(12).createCell(9).setCellValue("PASSED");
				sheet1.getRow(12).createCell(8).setCellValue("Columns Grid button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("grid_columns")).click();
				Thread.sleep(4000);
			}
			
			//Find the Remove All button to remove all the grid columns
			Boolean RemoveAll = driver.findElements(By.cssSelector(".remove-all")).size() >0;
						
			if ( ! RemoveAll)
			{
				sheet1.getRow(13).createCell(9).setCellValue("FAILED");
				sheet1.getRow(13).createCell(8).setCellValue("Remove All button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(13).createCell(9).setCellValue("PASSED");
				sheet1.getRow(13).createCell(8).setCellValue("Remove All button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".remove-all")).click();
				Thread.sleep(2000);
			}
			
			//Find the Column Search Box and Select it
			Boolean ColumnSrch = driver.findElements(By.cssSelector(".search")).size() >0;
						
			if ( ! ColumnSrch)
			{
				sheet1.getRow(14).createCell(9).setCellValue("FAILED");
				sheet1.getRow(14).createCell(8).setCellValue("Column Search Box was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(14).createCell(9).setCellValue("PASSED");
				sheet1.getRow(14).createCell(8).setCellValue("Column Search Box was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".search")).click();
				Thread.sleep(2000);
			}
			
			//Find the Add All button to Add all the grid columns
			Boolean AddAll = driver.findElements(By.cssSelector(".add-all")).size() >0;
						
			if ( ! AddAll)
			{
				sheet1.getRow(15).createCell(9).setCellValue("FAILED");
				sheet1.getRow(15).createCell(8).setCellValue("Add All button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(15).createCell(9).setCellValue("PASSED");
				sheet1.getRow(15).createCell(8).setCellValue("Add All button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".add-all")).click();
				Thread.sleep(2000);
			}
			
			//Find the Close button to close the grid columns
			Boolean closeColumns = driver.findElements(By.xpath("//html/body/div[10]/div[3]/div/button[2]")).size() >0;
						
			if ( ! closeColumns)
			{
				sheet1.getRow(16).createCell(9).setCellValue("FAILED");
				sheet1.getRow(16).createCell(8).setCellValue("Cancel button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(16).createCell(9).setCellValue("PASSED");
				sheet1.getRow(16).createCell(8).setCellValue("Cancel button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.xpath("//html/body/div[10]/div[3]/div/button[2]")).click();
				Thread.sleep(2000);
			}
			
			jse.executeScript("window.scrollBy(0,-150)", "");
			Thread.sleep(1000);
			
			//Find the Reports "Show all Tabs" and click
			if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
				 
				 driver.findElement(By.id("tabs_scroll_toggle")).click();
				 Thread.sleep(3000);}
			
			//Find the Asset Asset ID column and sort by clicking
			Boolean columnAsset = driver.findElements(By.id("jqgh_report-2_contracts-provider_contract_number")).size() >0;
			
			if ( ! columnAsset)
			{
				sheet1.getRow(17).createCell(9).setCellValue("FAILED");
				sheet1.getRow(17).createCell(8).setCellValue("Contract Provider Contract Number column was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(17).createCell(9).setCellValue("PASSED");
				sheet1.getRow(17).createCell(8).setCellValue("Contract Provider Contract Number column was Found and Sorted");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("jqgh_report-2_contracts-provider_contract_number")).click();
				Thread.sleep(4000);
				}
			
			//Find the Sorting dialog box and click the "x"
			if(driver.findElements(By.id("message_dialog")).size()>0) {
				 
				 driver.findElement(By.xpath("//html/body/div[8]/div[1]/button")).click();
				 Thread.sleep(3000);}
			
			//Click the Advanced Search Link
			Boolean advsrchButton = driver.findElements(By.partialLinkText("Advanced Search")).size() >0;
			
			
			if ( ! advsrchButton)
			{
				
				sheet1.getRow(18).createCell(9).setCellValue("FAILED");
				sheet1.getRow(18).createCell(8).setCellValue("Advanced Search was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(18).createCell(9).setCellValue("PASSED");
				sheet1.getRow(18).createCell(8).setCellValue("Advanced Search was Found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.partialLinkText("Advanced Search")).click();
				Thread.sleep(3000);
				}
			
					
			//Click the Advanced search link filter
			Boolean filterBy = driver.findElements(By.id("drill_report-2")).size() >0;
			
			
			if ( ! filterBy)
			{
				
				sheet1.getRow(19).createCell(9).setCellValue("FAILED");
				sheet1.getRow(19).createCell(8).setCellValue("'Filter by' serach box was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(19).createCell(9).setCellValue("PASSED");
				sheet1.getRow(19).createCell(8).setCellValue("'Filter by' serach box was Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				}
				
			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Companies_Companies_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Companies_Companies_Name))).click();
			Thread.sleep(1000);
		
			//Find the Advance search filter box and Enter Asset_Asset_Id
			 Boolean companiesNameOperator = driver.findElements(By.linkText(String.valueOf(Companies_Companies_Name))).size() >0;
				
			if ( ! companiesNameOperator)
			{
				sheet1.getRow(20).createCell(9).setCellValue("FAILED");
				sheet1.getRow(20).createCell(8).setCellValue("Companies Companies Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(20).createCell(9).setCellValue("PASSED");
				sheet1.getRow(20).createCell(8).setCellValue("Companies Companies Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("companiescompanies_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Addendum_Customer_Price));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Customer_Price))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset Name
			 Boolean customerPriceOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Customer_Price))).size() >0;
				
			if ( ! customerPriceOperator)
			{
				sheet1.getRow(21).createCell(9).setCellValue("FAILED");
				sheet1.getRow(21).createCell(8).setCellValue("Contracts Addendum Customer Price Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(21).createCell(9).setCellValue("PASSED");
				sheet1.getRow(21).createCell(8).setCellValue("Contracts Addendum Customer Price Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Not Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Greater Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Less Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Not Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contracts_addendumcustomer_price"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_Billing_Frequency));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_Billing_Frequency))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Categories_Asset_Categories_Name
			 Boolean contractBillingFreqOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_Billing_Frequency))).size() >0;

			if ( ! contractBillingFreqOperator)
			{
				sheet1.getRow(22).createCell(9).setCellValue("FAILED");
				sheet1.getRow(22).createCell(8).setCellValue("Contracts Contract Billing Frequency Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(22).createCell(9).setCellValue("PASSED");
				sheet1.getRow(22).createCell(8).setCellValue("Contracts Contract Billing Frequency Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_billing_frequency"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_Description));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_Description))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Description
			 Boolean contractDescriptionOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_Description))).size() >0;
					
			if ( ! contractDescriptionOperator)
			{
				sheet1.getRow(23).createCell(9).setCellValue("FAILED");
				sheet1.getRow(23).createCell(8).setCellValue("Contracts Contract Description Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(23).createCell(9).setCellValue("PASSED");
				sheet1.getRow(23).createCell(8).setCellValue("Contracts Contract Description Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_description"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_End_Date));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_End_Date))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Install_Date
			 Boolean contractEndDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_End_Date))).size() >0;
						
			if ( ! contractEndDateOperator)
			{
				sheet1.getRow(24).createCell(9).setCellValue("FAILED");
				sheet1.getRow(24).createCell(8).setCellValue("Contracts Contract End Date Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(24).createCell(9).setCellValue("PASSED");
				sheet1.getRow(24).createCell(8).setCellValue("Contracts Contract End Date Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Not Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Greater Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Less Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Greater Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Less Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Not Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Within");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Within Last");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_end_date"))).selectByVisibleText("Prior To");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Locations_Asset_Locations_Name
			 Boolean contractsNumberOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_Number))).size() >0;
						
			if ( ! contractsNumberOperator)
			{
				sheet1.getRow(25).createCell(9).setCellValue("FAILED");
				sheet1.getRow(25).createCell(8).setCellValue("Contracts Contract Number Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(25).createCell(9).setCellValue("PASSED");
				sheet1.getRow(25).createCell(8).setCellValue("Contracts Contract Number Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_number"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);


			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_Start_Date));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_Start_Date))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Manufacturer
			 Boolean contractStartDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_Start_Date))).size() >0;
						
			if ( ! contractStartDateOperator)
			{
				sheet1.getRow(26).createCell(9).setCellValue("FAILED");
				sheet1.getRow(26).createCell(8).setCellValue("Contracts Contract Start Date Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(26).createCell(9).setCellValue("PASSED");
				sheet1.getRow(26).createCell(8).setCellValue("Contracts Contract Start Date Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Not Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Greater Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Less Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Greater Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Less Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Not Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Within");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Within Last");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_start_date"))).selectByVisibleText("Prior To");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_Term_Date));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_Term_Date))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Model_Number
			 Boolean contractsTermDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_Term_Date))).size() >0;
						
			if ( ! contractsTermDateOperator)
			{
				sheet1.getRow(27).createCell(9).setCellValue("FAILED");
				sheet1.getRow(27).createCell(8).setCellValue("Contracts Contract Term Date Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(27).createCell(9).setCellValue("PASSED");
				sheet1.getRow(27).createCell(8).setCellValue("Contracts Contract Term Date Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

						
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Not Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Greater Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Less Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Greater Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Less Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Not Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Within");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Within Last");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contractscontract_term_date"))).selectByVisibleText("Prior To");
			Thread.sleep(1000);
			
		
			driver.findElement(By.id("drill_report-2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-2")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contract_Type));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contracts_Contract_Type))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Serial_Number
				 Boolean contractTypeOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contract_Type))).size() >0;
							
				if ( ! contractTypeOperator)
				{
					sheet1.getRow(28).createCell(9).setCellValue("FAILED");
					sheet1.getRow(28).createCell(8).setCellValue("Contracts Contract Type Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(28).createCell(9).setCellValue("PASSED");
					sheet1.getRow(28).createCell(8).setCellValue("Contracts Contract Type Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontract_type"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Contracts_Id));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Contracts_Id))).click();
				Thread.sleep(1000);
			
				//Find the Advance search filter box and Enter Asset_Warranty_End_Date
				 Boolean contractIDOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contracts_Id))).size() >0;
					
				if ( ! contractIDOperator)
				{
					sheet1.getRow(29).createCell(9).setCellValue("FAILED");
					sheet1.getRow(29).createCell(8).setCellValue("Contracts Contracts Id Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(29).createCell(9).setCellValue("PASSED");
					sheet1.getRow(29).createCell(8).setCellValue("Contracts Contracts Id Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscontracts_id"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Created_Date));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Created_Date))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Companies_Companies_Name
				 Boolean contractCreatedDAteOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Created_Date))).size() >0;
					
				if ( ! contractCreatedDAteOperator)
				{
					sheet1.getRow(30).createCell(9).setCellValue("FAILED");
					sheet1.getRow(30).createCell(8).setCellValue("Contracts Created Date Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(30).createCell(9).setCellValue("PASSED");
					sheet1.getRow(30).createCell(8).setCellValue("Contracts Created Date Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Greater Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Less Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Within");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Within Last");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscreated_date"))).selectByVisibleText("Prior To");
				Thread.sleep(1000);

				

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Customer_Type));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Customer_Type))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Component
				 Boolean customerTypeOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Customer_Type))).size() >0;

				if ( ! customerTypeOperator)
				{
					sheet1.getRow(31).createCell(9).setCellValue("FAILED");
					sheet1.getRow(31).createCell(8).setCellValue("Contracts Customer Type Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(31).createCell(9).setCellValue("PASSED");
					sheet1.getRow(31).createCell(8).setCellValue("Contracts Customer Type Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractscustomer_type"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Denial_Date));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Denial_Date))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Status
				 Boolean contractDenialDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Denial_Date))).size() >0;
						
				if ( ! contractDenialDateOperator)
				{
					sheet1.getRow(32).createCell(9).setCellValue("FAILED");
					sheet1.getRow(32).createCell(8).setCellValue("Contracts Denial Date Operator Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(32).createCell(9).setCellValue("PASSED");
					sheet1.getRow(32).createCell(8).setCellValue("Contracts Denial Date Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Greater Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Less Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Within");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Within Last");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_date"))).selectByVisibleText("Prior To");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Denial_Service));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Denial_Service))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Status_Description
				 Boolean contractDenialServiceOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Denial_Service))).size() >0;
							
				if ( ! contractDenialServiceOperator)
				{
					sheet1.getRow(33).createCell(9).setCellValue("FAILED");
					sheet1.getRow(33).createCell(8).setCellValue("Contracts Denial Service Operator Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(33).createCell(9).setCellValue("PASSED");
					sheet1.getRow(33).createCell(8).setCellValue("Contracts Denial Service Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsdenial_service"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Invoice_Format));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Invoice_Format))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Distributor_Companies_Name
				Boolean contractsInvoiceOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Invoice_Format))).size() >0;
							
				if ( ! contractsInvoiceOperator)
				{
					sheet1.getRow(34).createCell(9).setCellValue("FAILED");
					sheet1.getRow(34).createCell(8).setCellValue("Contracts Invoice Format Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(34).createCell(9).setCellValue("PASSED");
					sheet1.getRow(34).createCell(8).setCellValue("Contracts Invoice Format Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsinvoice_format"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);


				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Line_Item_Active_Count));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Line_Item_Active_Count))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Distributor_Companies_Number
				 Boolean lineItemActiveCountOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Line_Item_Active_Count))).size() >0;
							
				if ( ! lineItemActiveCountOperator)
				{
					sheet1.getRow(35).createCell(9).setCellValue("FAILED");
					sheet1.getRow(35).createCell(8).setCellValue("Contracts Line Item Active Count Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(35).createCell(9).setCellValue("PASSED");
					sheet1.getRow(35).createCell(8).setCellValue("Contracts Line Item Active Count Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_active_count"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Line_Item_Gross_Profit));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Line_Item_Gross_Profit))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Manufacturer_Companies_Name
				 Boolean itemGrossProfitOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Line_Item_Gross_Profit))).size() >0;
							
				if ( ! itemGrossProfitOperator)
				{
					sheet1.getRow(36).createCell(9).setCellValue("FAILED");
					sheet1.getRow(36).createCell(8).setCellValue("Contracts Line Item Gross Profit Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(36).createCell(9).setCellValue("PASSED");
					sheet1.getRow(36).createCell(8).setCellValue("Contracts Line Item Gross Profit Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_gross_profit"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
			
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Line_Item_Total_Price));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Line_Item_Total_Price))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Manufacturer_Companies_Number
				Boolean itemTotalProfitOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Line_Item_Total_Price))).size() >0;
							
				if ( ! itemTotalProfitOperator)
				{
					sheet1.getRow(37).createCell(9).setCellValue("FAILED");
					sheet1.getRow(37).createCell(8).setCellValue("Contracts Line Item Total Price Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(37).createCell(9).setCellValue("PASSED");
					sheet1.getRow(37).createCell(8).setCellValue("Contracts Line Item Total Price Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsline_item_total_price"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Po_By_Id));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Po_By_Id))).click();
				Thread.sleep(1000);
				
				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Name
				Boolean contractsPoByIdOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Po_By_Id))).size() >0;
							
				if ( ! contractsPoByIdOperator)
				{
					sheet1.getRow(38).createCell(9).setCellValue("FAILED");
					sheet1.getRow(38).createCell(8).setCellValue("Contracts Po By Id Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(38).createCell(9).setCellValue("PASSED");
					sheet1.getRow(38).createCell(8).setCellValue("Contracts Po By Id Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractspo_by_id"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Provider_Contract_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Provider_Contract_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean providerContractNumberOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Provider_Contract_Number))).size() >0;
							
				if ( ! providerContractNumberOperator)
				{
					sheet1.getRow(39).createCell(9).setCellValue("FAILED");
					sheet1.getRow(39).createCell(8).setCellValue("Contracts Provider Contract Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(39).createCell(9).setCellValue("PASSED");
					sheet1.getRow(39).createCell(8).setCellValue("Contracts Provider Contract Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_contract_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Provider_Customer_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Provider_Customer_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean providerCustomerNumberOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Provider_Customer_Number))).size() >0;
							
				if ( ! providerCustomerNumberOperator)
				{
					sheet1.getRow(40).createCell(9).setCellValue("FAILED");
					sheet1.getRow(40).createCell(8).setCellValue("Contracts Provider Customer Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(40).createCell(9).setCellValue("PASSED");
					sheet1.getRow(40).createCell(8).setCellValue("Contracts Provider Customert Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsprovider_customer_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Region));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Region))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean contractsRegionOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Region))).size() >0;
							
				if ( ! contractsRegionOperator)
				{
					sheet1.getRow(41).createCell(9).setCellValue("FAILED");
					sheet1.getRow(41).createCell(8).setCellValue("Contracts Region Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(41).createCell(9).setCellValue("PASSED");
					sheet1.getRow(41).createCell(8).setCellValue("Contracts Region Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsregion"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Reinstatement_Date));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Reinstatement_Date))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean contractReinstatementDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Reinstatement_Date))).size() >0;
							
				if ( ! contractReinstatementDateOperator)
				{
					sheet1.getRow(42).createCell(9).setCellValue("FAILED");
					sheet1.getRow(42).createCell(8).setCellValue("Contracts Reinstatement Date Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(42).createCell(9).setCellValue("PASSED");
					sheet1.getRow(42).createCell(8).setCellValue("Contracts Reinstatement Date Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Greater Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Less Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Within");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Within Last");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsreinstatement_date"))).selectByVisibleText("Prior To");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Contracts_Service_Provider_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Service_Provider_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean serviceProviderNameOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Service_Provider_Name))).size() >0;
							
				if ( ! serviceProviderNameOperator)
				{
					sheet1.getRow(43).createCell(9).setCellValue("FAILED");
					sheet1.getRow(43).createCell(8).setCellValue("Contracts Service Provider Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(43).createCell(9).setCellValue("PASSED");
					sheet1.getRow(43).createCell(8).setCellValue("Contracts Service Provider Name Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contractsservice_provider_name"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Tcv_Addendum_DTCV));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Tcv_Addendum_DTCV))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean tcvAddendumDTCVOperator = driver.findElements(By.linkText(String.valueOf(Tcv_Addendum_DTCV))).size() >0;
							
				if ( ! tcvAddendumDTCVOperator)
				{
					sheet1.getRow(44).createCell(9).setCellValue("FAILED");
					sheet1.getRow(44).createCell(8).setCellValue("Tcv Addendum DTCV Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(44).createCell(9).setCellValue("PASSED");
					sheet1.getRow(44).createCell(8).setCellValue("Tcv Addendum DTCV Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumDTCV"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).sendKeys(String.valueOf(Tcv_Addendum_TCV));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Tcv_Addendum_TCV))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean tcvAddendumTCVOperator = driver.findElements(By.linkText(String.valueOf(Tcv_Addendum_TCV))).size() >0;
							
				if ( ! tcvAddendumTCVOperator)
				{
					sheet1.getRow(45).createCell(9).setCellValue("FAILED");
					sheet1.getRow(45).createCell(8).setCellValue("Tcv Addendum TCV Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(45).createCell(9).setCellValue("PASSED");
					sheet1.getRow(45).createCell(8).setCellValue("Tcv Addendum TCV Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("tcv_addendumTCV"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-2")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-2")).click();
				Thread.sleep(1000);
				
				
				//Find the Advance search filter box and Click the "X" to close 
				Boolean AdvsrchClose = driver.findElements(By.xpath("//html/body/div[10]/div[1]/button")).size() >0;
							
				if ( ! AdvsrchClose)
				{
					sheet1.getRow(46).createCell(9).setCellValue("FAILED");
					sheet1.getRow(46).createCell(8).setCellValue("Advance Search Close button was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(46).createCell(9).setCellValue("PASSED");
					sheet1.getRow(46).createCell(8).setCellValue("Advance Search Close button was found and Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[10]/div[1]/button")).click();
					Thread.sleep(2000);
				}
				
				
				//Find the Refresh button to refresh the report grid
				Boolean GridRefresh = driver.findElements(By.id("refresh_grid")).size() >0;
							
				if ( ! GridRefresh)
				{
					sheet1.getRow(47).createCell(9).setCellValue("FAILED");
					sheet1.getRow(47).createCell(8).setCellValue("Refresh Grid button was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(47).createCell(9).setCellValue("PASSED");
					sheet1.getRow(47).createCell(8).setCellValue("Refresh Grid button was found and Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid")).click();
					Thread.sleep(2000);
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
		 FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\"+ result.getName()+ timestamp()+".png"));
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
