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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class TC1413_LenovoAdvSrch_HwContractAddendumReport {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;


	
	
	
	//@Test(priority=0)
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException { 
	
	//@SuppressWarnings("resource")
	//@Test(priority=1)
	//public  void LenovoAdvSrch_HwContractAddendumReport() throws Throwable {
		
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC1413");
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
			
			
		String Asset_Asset_Name;
		String Asset_Model_Number;
		String Asset_Serial_Number;
		String Contract_Distributor_Companies_Name;
		String Contract_Distributor_Companies_Number;
		String Contract_Reseller_Companies_Name;
		String Contract_Reseller_Companies_Number;
		String Contract_Serviceprovider_Companies_Name;
		String Contract_Serviceprovider_Companies_Number;
		String Contracts_Addendum_Addendum_Description;
		String Contracts_Addendum_Begin_Charge_Date;
		String Contracts_Addendum_Charge_Type;
		String Contracts_Addendum_Contracts_Addendum_Id;
		String Contracts_Addendum_Contracts_Po;
		String Contracts_Addendum_Line_Item_Code;
		String Contracts_Addendum_Line_Po_Expire_Date;
		String Contracts_Addendum_Maint_Svc_Level;
		String Contracts_Addendum_Price;
		String Contracts_Addendum_Reference_Number;
		String Contracts_Addendum_Retention_Flag;
		String Contracts_Addendum_Uplift;
		String Contracts_Contracts_Id;
		String Contracts_Provider_Contract_Number;
		String Hardware_Distributor_Companies_Name;
		String Hardware_Distributor_Companies_Number;
		String Hardware_Manufacturer_Companies_Name;
		String Hardware_Manufacturer_Companies_Number;
		String Hardware_Reseller_Companies_Name;
		String Hardware_Reseller_Companies_Number;
		String Service_Packs_Reseller_Companies_Id;
		String Service_Packs_Reseller_Companies_Name;
		//String Service_Packs_Reseller_Location_Name;
		String Service_Packs_Reseller_Location_Number;


		
		baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
		logoutUrl =baseUrl + "/auth/logout"; 
		loginUrl =baseUrl + "/auth/login"; 
		testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
		testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
		
			
		 Asset_Asset_Name = sheet1.getRow(3).getCell(10).getStringCellValue();
		 Asset_Model_Number = sheet1.getRow(4).getCell(10).getStringCellValue();
		 Asset_Serial_Number = sheet1.getRow(5).getCell(10).getStringCellValue();
		 Contract_Distributor_Companies_Name = sheet1.getRow(6).getCell(10).getStringCellValue();
		 Contract_Distributor_Companies_Number = sheet1.getRow(7).getCell(10).getStringCellValue();
		 Contract_Reseller_Companies_Name = sheet1.getRow(8).getCell(10).getStringCellValue();
		 Contract_Reseller_Companies_Number = sheet1.getRow(9).getCell(10).getStringCellValue();
		 Contract_Serviceprovider_Companies_Name = sheet1.getRow(10).getCell(10).getStringCellValue();
		 Contract_Serviceprovider_Companies_Number = sheet1.getRow(11).getCell(10).getStringCellValue();
		 Contracts_Addendum_Addendum_Description = sheet1.getRow(12).getCell(10).getStringCellValue();
		 Contracts_Addendum_Begin_Charge_Date = sheet1.getRow(13).getCell(10).getStringCellValue();
		 Contracts_Addendum_Charge_Type = sheet1.getRow(14).getCell(10).getStringCellValue();
		 Contracts_Addendum_Contracts_Addendum_Id = sheet1.getRow(15).getCell(10).getStringCellValue();
		 Contracts_Addendum_Contracts_Po = sheet1.getRow(16).getCell(10).getStringCellValue();
		 Contracts_Addendum_Line_Item_Code = sheet1.getRow(17).getCell(10).getStringCellValue();
		 Contracts_Addendum_Line_Po_Expire_Date = sheet1.getRow(18).getCell(10).getStringCellValue();
		 Contracts_Addendum_Maint_Svc_Level = sheet1.getRow(19).getCell(10).getStringCellValue();
		 Contracts_Addendum_Price = sheet1.getRow(20).getCell(10).getStringCellValue();
		 Contracts_Addendum_Reference_Number = sheet1.getRow(21).getCell(10).getStringCellValue();
		 Contracts_Addendum_Retention_Flag = sheet1.getRow(22).getCell(10).getStringCellValue();
		 Contracts_Addendum_Uplift = sheet1.getRow(23).getCell(10).getStringCellValue();
		 Contracts_Contracts_Id = sheet1.getRow(24).getCell(10).getStringCellValue();
		 Contracts_Provider_Contract_Number = sheet1.getRow(25).getCell(10).getStringCellValue();
		 Hardware_Distributor_Companies_Name = sheet1.getRow(26).getCell(10).getStringCellValue();
		 Hardware_Distributor_Companies_Number = sheet1.getRow(27).getCell(10).getStringCellValue();
		 Hardware_Manufacturer_Companies_Name = sheet1.getRow(28).getCell(10).getStringCellValue();
		 Hardware_Manufacturer_Companies_Number = sheet1.getRow(29).getCell(10).getStringCellValue();
		 Hardware_Reseller_Companies_Name = sheet1.getRow(30).getCell(10).getStringCellValue();
		 Hardware_Reseller_Companies_Number = sheet1.getRow(31).getCell(10).getStringCellValue();
		 Service_Packs_Reseller_Companies_Id = sheet1.getRow(32).getCell(10).getStringCellValue();
		 Service_Packs_Reseller_Companies_Name = sheet1.getRow(33).getCell(10).getStringCellValue();
		 Service_Packs_Reseller_Location_Number = sheet1.getRow(34).getCell(10).getStringCellValue();
		
		
		
		
			
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
				//new Select(driver.findElement(By.id("dropdown_topmenuitem_4"))).selectByVisibleText("Report Dashboard");
				Thread.sleep(4000);
			}
			
			//Find the Reports "Show all Tabs" and click
			if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
				
				driver.findElement(By.id("tabs_scroll_toggle")).click();
				Thread.sleep(2000);
				 driver.findElement(By.id("tabs_scroll_toggle")).click();
				 Thread.sleep(2000);}
			
			
			//jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1000);
			//jse.executeScript("window.scrollBy(0,-250)", "");
			
			
			WebElement element1 = driver.findElement(By.linkText("General Reports"));
	        Actions action1 = new Actions(driver);
	        jse.executeScript("arguments[0].scrollIntoView(true);", element1);
	        action1.moveToElement(element1).build().perform();
			Thread.sleep(2000);
			//if(driver.findElements(By.linkText("General Reports")).size()>0) {
				 
			driver.findElement(By.linkText("General Reports")).click();
				 Thread.sleep(3000);
			
			
			  //Find the General Reports Drop down Menu
			 Boolean hwReport = driver.findElements(By.linkText("Hardware Contract Addendums")).size() >0;
			
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
				driver.findElement(By.linkText("Hardware Contract Addendums")).click();
				Thread.sleep(4000);
				}
			
			//jse.executeScript("window.scrollBy(0,-450)", "");
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
				WebElement element2 = driver.findElement(By.id("grid_columns"));
		        Actions action2 = new Actions(driver);
		        jse.executeScript("arguments[0].scrollIntoView(true);", element2);
		        action2.moveToElement(element2).build().perform();
				Thread.sleep(2000);
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
			
			//jse.executeScript("window.scrollBy(0,-150)", "");
			Thread.sleep(1000);
			
						
			/*Find the Asset Asset ID column and sort by clicking
			Boolean columnAsset = driver.findElements(By.id("jqgh_report-53_contracts_addendum-contracts_addendum_id")).size() >0;
			
			if ( ! columnAsset)
			{
				sheet1.getRow(17).createCell(9).setCellValue("FAILED");
				sheet1.getRow(17).createCell(8).setCellValue("Contract Addendum Contracts Addendum Id column was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(17).createCell(9).setCellValue("PASSED");
				sheet1.getRow(17).createCell(8).setCellValue("Contract Addendum Contracts Addendum column was Found and Sorted");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("jqgh_report-53_contracts_addendum-contracts_addendum_id")).click();
				Thread.sleep(4000);
				}*/
			
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
			Boolean filterBy = driver.findElements(By.id("drill_report-53")).size() >0;
			
			
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
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				}
				
			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Asset_Asset_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Asset_Name))).click();
			Thread.sleep(1000);
		
			//Find the Advance search filter box and Enter Asset_Asset_Id
			 Boolean AssetNameOperator = driver.findElements(By.linkText(String.valueOf(Asset_Asset_Name))).size() >0;
				
			if ( ! AssetNameOperator)
			{
				sheet1.getRow(20).createCell(9).setCellValue("FAILED");
				sheet1.getRow(20).createCell(8).setCellValue("Asset Asset Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(20).createCell(9).setCellValue("PASSED");
				sheet1.getRow(20).createCell(8).setCellValue("Asset Asset Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Asset_Model_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Model_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset Name
			 Boolean assetModelNumberOperator = driver.findElements(By.linkText(String.valueOf(Asset_Model_Number))).size() >0;
				
			if ( ! assetModelNumberOperator)
			{
				sheet1.getRow(21).createCell(9).setCellValue("FAILED");
				sheet1.getRow(21).createCell(8).setCellValue("Asset Model Number Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(21).createCell(9).setCellValue("PASSED");
				sheet1.getRow(21).createCell(8).setCellValue("Asset Model Number Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmodel_number"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);
			

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Asset_Serial_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Serial_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Categories_Asset_Categories_Name
			 Boolean assetSerialNumberOperator = driver.findElements(By.linkText(String.valueOf(Asset_Serial_Number))).size() >0;

			if ( ! assetSerialNumberOperator)
			{
				sheet1.getRow(22).createCell(9).setCellValue("FAILED");
				sheet1.getRow(22).createCell(8).setCellValue("Asset Serial Number Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(22).createCell(9).setCellValue("PASSED");
				sheet1.getRow(22).createCell(8).setCellValue("Asset Serial Number Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetserial_number"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contract_Distributor_Companies_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contract_Distributor_Companies_Name))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Description
			 Boolean contractDistNameOperator = driver.findElements(By.linkText(String.valueOf(Contract_Distributor_Companies_Name))).size() >0;
					
			if ( ! contractDistNameOperator)
			{
				sheet1.getRow(23).createCell(9).setCellValue("FAILED");
				sheet1.getRow(23).createCell(8).setCellValue("Contract Distributor Companies Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(23).createCell(9).setCellValue("PASSED");
				sheet1.getRow(23).createCell(8).setCellValue("Contract Distributor Companies Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contract_Distributor_Companies_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contract_Distributor_Companies_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Install_Date
			 Boolean contractDistNumberOperator = driver.findElements(By.linkText(String.valueOf(Contract_Distributor_Companies_Number))).size() >0;
						
			if ( ! contractDistNumberOperator)
			{
				sheet1.getRow(24).createCell(9).setCellValue("FAILED");
				sheet1.getRow(24).createCell(8).setCellValue("Contract Distributor Companies Number Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(24).createCell(9).setCellValue("PASSED");
				sheet1.getRow(24).createCell(8).setCellValue("Contract Distributor Companies Number Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_distributorcompanies_number"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contract_Reseller_Companies_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contract_Reseller_Companies_Name))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Locations_Asset_Locations_Name
			 Boolean contractsResellerNameOperator = driver.findElements(By.linkText(String.valueOf(Contract_Reseller_Companies_Name))).size() >0;
						
			if ( ! contractsResellerNameOperator)
			{
				sheet1.getRow(25).createCell(9).setCellValue("FAILED");
				sheet1.getRow(25).createCell(8).setCellValue("Contract Reseller Companies Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(25).createCell(9).setCellValue("PASSED");
				sheet1.getRow(25).createCell(8).setCellValue("Contract Reseller Companies Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);


			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contract_Reseller_Companies_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contract_Reseller_Companies_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Manufacturer
			 Boolean contractResellerNumberOperator = driver.findElements(By.linkText(String.valueOf(Contract_Reseller_Companies_Number))).size() >0;
						
			if ( ! contractResellerNumberOperator)
			{
				sheet1.getRow(26).createCell(9).setCellValue("FAILED");
				sheet1.getRow(26).createCell(8).setCellValue("Contract Reseller Companies Number Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(26).createCell(9).setCellValue("PASSED");
				sheet1.getRow(26).createCell(8).setCellValue("Contract Reseller Companies Number Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_resellercompanies_number"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contract_Serviceprovider_Companies_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contract_Serviceprovider_Companies_Name))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Model_Number
			 Boolean serviceProviderNameOperator = driver.findElements(By.linkText(String.valueOf(Contract_Serviceprovider_Companies_Name))).size() >0;
						
			if ( ! serviceProviderNameOperator)
			{
				sheet1.getRow(27).createCell(9).setCellValue("FAILED");
				sheet1.getRow(27).createCell(8).setCellValue("Contract Serviceprovider Companies Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(27).createCell(9).setCellValue("PASSED");
				sheet1.getRow(27).createCell(8).setCellValue("Contract Serviceprovider Companies Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

						
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("contract_serviceprovidercompanies_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);
			
		
			driver.findElement(By.id("drill_report-53")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-53")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contract_Serviceprovider_Companies_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Contract_Serviceprovider_Companies_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Serial_Number
				 Boolean serviceProviderNumberOperator = driver.findElements(By.linkText(String.valueOf(Contract_Serviceprovider_Companies_Number))).size() >0;
							
				if ( ! serviceProviderNumberOperator)
				{
					sheet1.getRow(28).createCell(9).setCellValue("FAILED");
					sheet1.getRow(28).createCell(8).setCellValue("Contract Serviceprovider Companies Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(28).createCell(9).setCellValue("PASSED");
					sheet1.getRow(28).createCell(8).setCellValue("Contract Serviceprovider Companies Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contract_serviceprovidercompanies_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Addendum_Description));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Addendum_Description))).click();
				Thread.sleep(1000);
			
				//Find the Advance search filter box and Enter Asset_Warranty_End_Date
				 Boolean contractAddendumDescOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Addendum_Description))).size() >0;
					
				if ( ! contractAddendumDescOperator)
				{
					sheet1.getRow(29).createCell(9).setCellValue("FAILED");
					sheet1.getRow(29).createCell(8).setCellValue("Contracts Addendum Addendum Description Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(29).createCell(9).setCellValue("PASSED");
					sheet1.getRow(29).createCell(8).setCellValue("Contracts Addendum Addendum Description Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumaddendum_description"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Begin_Charge_Date));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Begin_Charge_Date))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Companies_Companies_Name
				 Boolean contractAddBeginDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Begin_Charge_Date))).size() >0;
					
				if ( ! contractAddBeginDateOperator)
				{
					sheet1.getRow(30).createCell(9).setCellValue("FAILED");
					sheet1.getRow(30).createCell(8).setCellValue("Contracts Addendum Begin Charge Date Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(30).createCell(9).setCellValue("PASSED");
					sheet1.getRow(30).createCell(8).setCellValue("Contracts Addendum Begin Charge Date Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Greater Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Less Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Within");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Within Last");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumbegin_charge_date"))).selectByVisibleText("Prior To");
				Thread.sleep(1000);

				

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Charge_Type));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Charge_Type))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Component
				 Boolean contractAddTypeOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Charge_Type))).size() >0;

				if ( ! contractAddTypeOperator)
				{
					sheet1.getRow(31).createCell(9).setCellValue("FAILED");
					sheet1.getRow(31).createCell(8).setCellValue("Contracts Addendum Charge Type Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(31).createCell(9).setCellValue("PASSED");
					sheet1.getRow(31).createCell(8).setCellValue("Contracts Addendum Charge Type Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcharge_type"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Contracts_Addendum_Id));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Contracts_Addendum_Id))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Status
				 Boolean contractAddendumIdOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Contracts_Addendum_Id))).size() >0;
						
				if ( ! contractAddendumIdOperator)
				{
					sheet1.getRow(32).createCell(9).setCellValue("FAILED");
					sheet1.getRow(32).createCell(8).setCellValue("Contracts Addendum Contracts Addendum Id Operator Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(32).createCell(9).setCellValue("PASSED");
					sheet1.getRow(32).createCell(8).setCellValue("Contracts Addendum Contracts Addendum Id Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_addendum_id"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Contracts_Po));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Contracts_Po))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Status_Description
				 Boolean contractAddendumPoOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Contracts_Po))).size() >0;
							
				if ( ! contractAddendumPoOperator)
				{
					sheet1.getRow(33).createCell(9).setCellValue("FAILED");
					sheet1.getRow(33).createCell(8).setCellValue("Contracts Addendum Contracts Po Operator Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(33).createCell(9).setCellValue("PASSED");
					sheet1.getRow(33).createCell(8).setCellValue("Contracts Addendum Contracts Po Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumcontracts_po"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Line_Item_Code));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Line_Item_Code))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Distributor_Companies_Name
				Boolean contractsAddLineItemCodeOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Line_Item_Code))).size() >0;
							
				if ( ! contractsAddLineItemCodeOperator)
				{
					sheet1.getRow(34).createCell(9).setCellValue("FAILED");
					sheet1.getRow(34).createCell(8).setCellValue("Contracts Addendum Line Item Code Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(34).createCell(9).setCellValue("PASSED");
					sheet1.getRow(34).createCell(8).setCellValue("Contracts Addendum Line Item Code Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_item_code"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);


				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Line_Po_Expire_Date));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Line_Po_Expire_Date))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Distributor_Companies_Number
				 Boolean contractsLinePoExDateOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Line_Po_Expire_Date))).size() >0;
							
				if ( ! contractsLinePoExDateOperator)
				{
					sheet1.getRow(35).createCell(9).setCellValue("FAILED");
					sheet1.getRow(35).createCell(8).setCellValue("Contracts Addendum Line Po Expire Date Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(35).createCell(9).setCellValue("PASSED");
					sheet1.getRow(35).createCell(8).setCellValue("Contracts Addendum Line Po Expire Date Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Greater Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Less Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Within");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Within Last");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumline_po_expire_date"))).selectByVisibleText("Prior To");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Maint_Svc_Level));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Maint_Svc_Level))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Manufacturer_Companies_Name
				 Boolean maintSvcLevelOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Maint_Svc_Level))).size() >0;
							
				if ( ! maintSvcLevelOperator)
				{
					sheet1.getRow(36).createCell(9).setCellValue("FAILED");
					sheet1.getRow(36).createCell(8).setCellValue("Contracts Addendum Maint Svc Level Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(36).createCell(9).setCellValue("PASSED");
					sheet1.getRow(36).createCell(8).setCellValue("Contracts Addendum Maint Svc Level Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendummaint_svc_level"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
			
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Price));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Price))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Manufacturer_Companies_Number
				Boolean contractAddendumPriceOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Price))).size() >0;
							
				if ( ! contractAddendumPriceOperator)
				{
					sheet1.getRow(37).createCell(9).setCellValue("FAILED");
					sheet1.getRow(37).createCell(8).setCellValue("Contracts Addendum Price Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(37).createCell(9).setCellValue("PASSED");
					sheet1.getRow(37).createCell(8).setCellValue("Contracts Addendum Price Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumprice"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Reference_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Reference_Number))).click();
				Thread.sleep(1000);
				
				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Name
				Boolean contractsRefNumberOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Reference_Number))).size() >0;
							
				if ( ! contractsRefNumberOperator)
				{
					sheet1.getRow(38).createCell(9).setCellValue("FAILED");
					sheet1.getRow(38).createCell(8).setCellValue("Contracts Addendum Reference Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(38).createCell(9).setCellValue("PASSED");
					sheet1.getRow(38).createCell(8).setCellValue("Contracts Addendum Reference Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumreference_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Retention_Flag));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Retention_Flag))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean contractRetFlagOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Retention_Flag))).size() >0;
							
				if ( ! contractRetFlagOperator)
				{
					sheet1.getRow(39).createCell(9).setCellValue("FAILED");
					sheet1.getRow(39).createCell(8).setCellValue("Contracts Addendum Retention Flag Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(39).createCell(9).setCellValue("PASSED");
					sheet1.getRow(39).createCell(8).setCellValue("Contracts Addendum Retention Flag Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				//new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Between");
				//Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumretention_flag"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Addendum_Uplift));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Addendum_Uplift))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean contractAddUpliftOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Addendum_Uplift))).size() >0;
							
				if ( ! contractAddUpliftOperator)
				{
					sheet1.getRow(40).createCell(9).setCellValue("FAILED");
					sheet1.getRow(40).createCell(8).setCellValue("Contracts Addendum Uplift Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(40).createCell(9).setCellValue("PASSED");
					sheet1.getRow(40).createCell(8).setCellValue("Contracts Addendum Uplift Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("contracts_addendumuplift"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Contracts_Id));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Contracts_Id))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean contractsIdOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Contracts_Id))).size() >0;
							
				if ( ! contractsIdOperator)
				{
					sheet1.getRow(41).createCell(9).setCellValue("FAILED");
					sheet1.getRow(41).createCell(8).setCellValue("Contracts Contracts Id Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(41).createCell(9).setCellValue("PASSED");
					sheet1.getRow(41).createCell(8).setCellValue("Contracts Contracts Id Operator filter was found");
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
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Contracts_Provider_Contract_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Contracts_Provider_Contract_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean contractProviderNumberOperator = driver.findElements(By.linkText(String.valueOf(Contracts_Provider_Contract_Number))).size() >0;
							
				if ( ! contractProviderNumberOperator)
				{
					sheet1.getRow(42).createCell(9).setCellValue("FAILED");
					sheet1.getRow(42).createCell(8).setCellValue("Contracts Provider Contract Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(42).createCell(9).setCellValue("PASSED");
					sheet1.getRow(42).createCell(8).setCellValue("Contracts Provider Contract Number Operator filter was found");
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
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Hardware_Distributor_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Distributor_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean HWDistCompNameOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Distributor_Companies_Name))).size() >0;
							
				if ( ! HWDistCompNameOperator)
				{
					sheet1.getRow(43).createCell(9).setCellValue("FAILED");
					sheet1.getRow(43).createCell(8).setCellValue("Hardware Distributor Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(43).createCell(9).setCellValue("PASSED");
					sheet1.getRow(43).createCell(8).setCellValue("Hardware Distributor Companies Name Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_name"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Hardware_Distributor_Companies_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Distributor_Companies_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean tcvAddendumDTCVOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Distributor_Companies_Number))).size() >0;
							
				if ( ! tcvAddendumDTCVOperator)
				{
					sheet1.getRow(44).createCell(9).setCellValue("FAILED");
					sheet1.getRow(44).createCell(8).setCellValue("Hardware Distributor Companies Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(44).createCell(9).setCellValue("PASSED");
					sheet1.getRow(44).createCell(8).setCellValue("Hardware Distributor Companies Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_distributorcompanies_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Hardware_Manufacturer_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean HWManCompNameOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Name))).size() >0;
							
				if ( ! HWManCompNameOperator)
				{
					sheet1.getRow(45).createCell(9).setCellValue("FAILED");
					sheet1.getRow(45).createCell(8).setCellValue("Hardware Manufacturer Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(45).createCell(9).setCellValue("PASSED");
					sheet1.getRow(45).createCell(8).setCellValue("Hardware Manufacturer Companies Name Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_name"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Hardware_Manufacturer_Companies_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean HWManCompNumberOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Number))).size() >0;
							
				if ( ! HWManCompNumberOperator)
				{
					sheet1.getRow(46).createCell(9).setCellValue("FAILED");
					sheet1.getRow(46).createCell(8).setCellValue("Hardware Manufacturer Companies Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(46).createCell(9).setCellValue("PASSED");
					sheet1.getRow(46).createCell(8).setCellValue("Hardware Manufacturer Companies Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_manufacturercompanies_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Hardware_Reseller_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Reseller_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean HWResellCompNameOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Reseller_Companies_Name))).size() >0;
							
				if ( ! HWResellCompNameOperator)
				{
					sheet1.getRow(47).createCell(9).setCellValue("FAILED");
					sheet1.getRow(47).createCell(8).setCellValue("Hardware Reseller Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(47).createCell(9).setCellValue("PASSED");
					sheet1.getRow(47).createCell(8).setCellValue("Hardware Reseller Companies Name Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_name"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Hardware_Reseller_Companies_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Reseller_Companies_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean HWResellCompNumberOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Reseller_Companies_Number))).size() >0;
							
				if ( ! HWResellCompNumberOperator)
				{
					sheet1.getRow(48).createCell(9).setCellValue("FAILED");
					sheet1.getRow(48).createCell(8).setCellValue("Hardware Manufacturer Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(48).createCell(9).setCellValue("PASSED");
					sheet1.getRow(48).createCell(8).setCellValue("Hardware Manufacturer Companies Name Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("hardware_resellercompanies_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Service_Packs_Reseller_Companies_Id));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Service_Packs_Reseller_Companies_Id))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean ServPakResellCompIdOperator = driver.findElements(By.linkText(String.valueOf(Service_Packs_Reseller_Companies_Id))).size() >0;
							
				if ( ! ServPakResellCompIdOperator)
				{
					sheet1.getRow(49).createCell(9).setCellValue("FAILED");
					sheet1.getRow(49).createCell(8).setCellValue("Service Packs Reseller Companies Id Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(49).createCell(9).setCellValue("PASSED");
					sheet1.getRow(49).createCell(8).setCellValue("Service Packs Reseller Companies Id Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_id"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Service_Packs_Reseller_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Service_Packs_Reseller_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean servPakResellCompNameOperator = driver.findElements(By.linkText(String.valueOf(Service_Packs_Reseller_Companies_Name))).size() >0;
							
				if ( ! servPakResellCompNameOperator)
				{
					sheet1.getRow(50).createCell(9).setCellValue("FAILED");
					sheet1.getRow(50).createCell(8).setCellValue("Service Packs Reseller Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(50).createCell(9).setCellValue("PASSED");
					sheet1.getRow(50).createCell(8).setCellValue("Service Packs Reseller Companies Name Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_companies_name"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).sendKeys(String.valueOf(Service_Packs_Reseller_Location_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Service_Packs_Reseller_Location_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean servPakResellCompNumberOperator = driver.findElements(By.linkText(String.valueOf(Service_Packs_Reseller_Location_Number))).size() >0;
							
				if ( ! servPakResellCompNumberOperator)
				{
					sheet1.getRow(51).createCell(9).setCellValue("FAILED");
					sheet1.getRow(51).createCell(8).setCellValue("Service Packs Reseller Location Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(51).createCell(9).setCellValue("PASSED");
					sheet1.getRow(51).createCell(8).setCellValue("Service Packs Reseller Location Number Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
				
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("service_packsreseller_location_number"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-53")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-53")).click();
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
