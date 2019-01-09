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


public class TC1411_LenovoAdvSrch_HwAssetReport {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;


	
	
	
	//@Test(priority=0)
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException { 
	//@SuppressWarnings("resource")
	//@Test(priority=1)
	//public  void LenovoAdvSrch_HwAssetReport() throws Throwable {
		
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC1411");
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
		String Asset_Asset_Id;
		String Asset_Asset_Name;
		String Asset_Categories_Asset_Categories_Name;
		String Asset_Description;
		String Asset_Install_Date;
		String Asset_Locations_Asset_Locations_Name;
		String Asset_Manufacturer;
		String Asset_Model_Number;
		String Asset_Serial_Number;
		String Asset_Warranty_End_Date;
		String Companies_Companies_Name;
		String Coverage_Status_Coverage_Component;
		String Coverage_Status_Coverage_Status;
		String Coverage_Status_Coverage_Status_Description;
		String Hardware_Distributor_Companies_Name;
		String Hardware_Distributor_Companies_Number;
		String Hardware_Manufacturer_Companies_Name;
		String Hardware_Manufacturer_Companies_Number;
		String Hardware_Reseller_Companies_Name;
		String Hardware_Reseller_Companies_Number;

		
		
		
		
		baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
		logoutUrl =baseUrl + "/auth/logout"; 
		loginUrl =baseUrl + "/auth/login"; 
		testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
		testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
		
		Asset_Asset_Id = sheet1.getRow(3).getCell(10).getStringCellValue();
		Asset_Asset_Name = sheet1.getRow(4).getCell(10).getStringCellValue();
		Asset_Categories_Asset_Categories_Name = sheet1.getRow(5).getCell(10).getStringCellValue();
		Asset_Description = sheet1.getRow(6).getCell(10).getStringCellValue();
		Asset_Install_Date = sheet1.getRow(7).getCell(10).getStringCellValue();
		Asset_Locations_Asset_Locations_Name = sheet1.getRow(8).getCell(10).getStringCellValue();
		Asset_Manufacturer = sheet1.getRow(9).getCell(10).getStringCellValue();
		Asset_Model_Number = sheet1.getRow(10).getCell(10).getStringCellValue();
		Asset_Serial_Number = sheet1.getRow(11).getCell(10).getStringCellValue();
		Asset_Warranty_End_Date = sheet1.getRow(12).getCell(10).getStringCellValue();
		Companies_Companies_Name = sheet1.getRow(13).getCell(10).getStringCellValue();
		Coverage_Status_Coverage_Component = sheet1.getRow(14).getCell(10).getStringCellValue();
		Coverage_Status_Coverage_Status = sheet1.getRow(15).getCell(10).getStringCellValue();
		Coverage_Status_Coverage_Status_Description = sheet1.getRow(16).getCell(10).getStringCellValue();
		Hardware_Distributor_Companies_Name = sheet1.getRow(17).getCell(10).getStringCellValue();
		Hardware_Distributor_Companies_Number = sheet1.getRow(18).getCell(10).getStringCellValue();
		Hardware_Manufacturer_Companies_Name = sheet1.getRow(19).getCell(10).getStringCellValue();
		Hardware_Manufacturer_Companies_Number = sheet1.getRow(20).getCell(10).getStringCellValue();
		Hardware_Reseller_Companies_Name = sheet1.getRow(21).getCell(10).getStringCellValue();
		Hardware_Reseller_Companies_Number = sheet1.getRow(22).getCell(10).getStringCellValue();
		
		
			
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
				Thread.sleep(4000);
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
			
			
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(1000);
			//jse.executeScript("window.scrollBy(0,-250)", "");
			
						
			  //Find the General Reports Drop down Menu
			 Boolean hwReport = driver.findElements(By.linkText("Hardware Asset")).size() >0;
			
			if ( ! hwReport)
			{
				sheet1.getRow(11).createCell(9).setCellValue("FAILED");
				sheet1.getRow(11).createCell(8).setCellValue("'Hardware Assets' Report was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(11).createCell(9).setCellValue("PASSED");
				sheet1.getRow(11).createCell(8).setCellValue("'Hardware Assets' Report was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText("Hardware Asset")).click();
				Thread.sleep(4000);
				}
			
			jse.executeScript("window.scrollBy(0,250)", "");
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
				Thread.sleep(2000);
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
			
			//Find the Reports "Show all Tabs" and click
			if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
				 
				 driver.findElement(By.id("tabs_scroll_toggle")).click();
				 Thread.sleep(3000);}
			
			//Find the Asset Asset ID column and sort by clicking
			Boolean columnAsset = driver.findElements(By.id("jqgh_report-1_asset-asset_id")).size() >0;
			
			if ( ! columnAsset)
			{
				sheet1.getRow(17).createCell(9).setCellValue("FAILED");
				sheet1.getRow(17).createCell(8).setCellValue("Asset Asset ID column was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(17).createCell(9).setCellValue("PASSED");
				sheet1.getRow(17).createCell(8).setCellValue("Asset Asset ID column was Found and Sorted");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("jqgh_report-1_asset-asset_id")).click();
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
			Boolean filterBy = driver.findElements(By.id("drill_report-1")).size() >0;
			
			
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
				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);
				}
				
			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Asset_Id));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Asset_Id))).click();
			Thread.sleep(1000);
		
			//Find the Advance search filter box and Enter Asset_Asset_Id
			 Boolean assetIdOperator = driver.findElements(By.linkText(String.valueOf(Asset_Asset_Id))).size() >0;
				
			if ( ! assetIdOperator)
			{
				sheet1.getRow(20).createCell(9).setCellValue("FAILED");
				sheet1.getRow(20).createCell(8).setCellValue("Asset Asset ID Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(20).createCell(9).setCellValue("PASSED");
				sheet1.getRow(20).createCell(8).setCellValue("Asset Asset ID Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Not Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Greater Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Less Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Not Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetasset_id"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Asset_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Asset_Name))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset Name
			 Boolean assetNameOperator = driver.findElements(By.linkText(String.valueOf(Asset_Asset_Name))).size() >0;
				
			if ( ! assetNameOperator)
			{
				sheet1.getRow(21).createCell(9).setCellValue("FAILED");
				sheet1.getRow(21).createCell(8).setCellValue("Asset Asset Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(21).createCell(9).setCellValue("PASSED");
				sheet1.getRow(21).createCell(8).setCellValue("Asset Asset Name Operator filter was found");
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

			

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Categories_Asset_Categories_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Categories_Asset_Categories_Name))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Categories_Asset_Categories_Name
			 Boolean assetCategoriesOperator = driver.findElements(By.linkText(String.valueOf(Asset_Categories_Asset_Categories_Name))).size() >0;

			if ( ! assetCategoriesOperator)
			{
				sheet1.getRow(22).createCell(9).setCellValue("FAILED");
				sheet1.getRow(22).createCell(8).setCellValue("Asset Categories Asset Categories Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(22).createCell(9).setCellValue("PASSED");
				sheet1.getRow(22).createCell(8).setCellValue("Asset Categories Asset Categories Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_categoriesasset_categories_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Description));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Description))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Description
			 Boolean assetDescriptionperator = driver.findElements(By.linkText(String.valueOf(Asset_Description))).size() >0;
					
			if ( ! assetDescriptionperator)
			{
				sheet1.getRow(23).createCell(9).setCellValue("FAILED");
				sheet1.getRow(23).createCell(8).setCellValue("Asset Description Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(23).createCell(9).setCellValue("PASSED");
				sheet1.getRow(23).createCell(8).setCellValue("Asset Description Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetdescription"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Install_Date));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Install_Date))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Install_Date
			 Boolean assetInstallDateOperator = driver.findElements(By.linkText(String.valueOf(Asset_Install_Date))).size() >0;
						
			if ( ! assetInstallDateOperator)
			{
				sheet1.getRow(24).createCell(9).setCellValue("FAILED");
				sheet1.getRow(24).createCell(8).setCellValue("Asset Install Date Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(24).createCell(9).setCellValue("PASSED");
				sheet1.getRow(24).createCell(8).setCellValue("Asset Install Date Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Not Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Greater Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Less Than (Strictly)");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Greater Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Less Than or Equal");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Not Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Within");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Within Last");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetinstall_date"))).selectByVisibleText("Prior To");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Locations_Asset_Locations_Name));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Locations_Asset_Locations_Name))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Locations_Asset_Locations_Name
			 Boolean assetLocationsNameOperator = driver.findElements(By.linkText(String.valueOf(Asset_Locations_Asset_Locations_Name))).size() >0;
						
			if ( ! assetLocationsNameOperator)
			{
				sheet1.getRow(25).createCell(9).setCellValue("FAILED");
				sheet1.getRow(25).createCell(8).setCellValue("Asset Locations Name Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(25).createCell(9).setCellValue("PASSED");
				sheet1.getRow(25).createCell(8).setCellValue("Asset Locations Name Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("asset_locationsasset_locations_name"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);


			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Manufacturer));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Manufacturer))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Manufacturer
			 Boolean assetManufacturerOperator = driver.findElements(By.linkText(String.valueOf(Asset_Manufacturer))).size() >0;
						
			if ( ! assetManufacturerOperator)
			{
				sheet1.getRow(26).createCell(9).setCellValue("FAILED");
				sheet1.getRow(26).createCell(8).setCellValue("Asset Manufacturer Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(26).createCell(9).setCellValue("PASSED");
				sheet1.getRow(26).createCell(8).setCellValue("Asset Manufacturer Operator filter was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}

			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Equal to");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Between");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Starts with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Ends by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Contains");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("In List");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Does not start with");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Does not end by");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Does not contain");
			Thread.sleep(1000);
			new Select(driver.findElement(By.id("assetmanufacturer"))).selectByVisibleText("Not in List");
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Model_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Model_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Model_Number
			 Boolean assetModelNumberOperator = driver.findElements(By.linkText(String.valueOf(Asset_Model_Number))).size() >0;
						
			if ( ! assetModelNumberOperator)
			{
				sheet1.getRow(27).createCell(9).setCellValue("FAILED");
				sheet1.getRow(27).createCell(8).setCellValue("Asset Model Number Operator filter was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(27).createCell(9).setCellValue("PASSED");
				sheet1.getRow(27).createCell(8).setCellValue("Asset Model Number Operator filter was found");
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
			
		
			driver.findElement(By.id("drill_report-1")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_report-1")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Serial_Number));
			Thread.sleep(1000);
			driver.findElement(By.linkText(String.valueOf(Asset_Serial_Number))).click();
			Thread.sleep(1000);

			//Find the Advance search filter box and Enter Asset_Serial_Number
				 Boolean assetSerialNumberOperator = driver.findElements(By.linkText(String.valueOf(Asset_Serial_Number))).size() >0;
							
				if ( ! assetSerialNumberOperator)
				{
					sheet1.getRow(28).createCell(9).setCellValue("FAILED");
					sheet1.getRow(28).createCell(8).setCellValue("Asset Serial Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(28).createCell(9).setCellValue("PASSED");
					sheet1.getRow(28).createCell(8).setCellValue("Asset Serial Number Operator filter was found");
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
				
				
				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Asset_Warranty_End_Date));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Asset_Warranty_End_Date))).click();
				Thread.sleep(1000);
			
				//Find the Advance search filter box and Enter Asset_Warranty_End_Date
				 Boolean assetWarrantyEndDateOperator = driver.findElements(By.linkText(String.valueOf(Asset_Warranty_End_Date))).size() >0;
					
				if ( ! assetWarrantyEndDateOperator)
				{
					sheet1.getRow(29).createCell(9).setCellValue("FAILED");
					sheet1.getRow(29).createCell(8).setCellValue("Asset Warranty End Date Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(29).createCell(9).setCellValue("PASSED");
					sheet1.getRow(29).createCell(8).setCellValue("Asset Warranty End Date Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Not Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Greater Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Less Than (Strictly)");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Greater Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Less Than or Equal");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Not Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Within");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Within Last");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("assetwarranty_end_date"))).selectByVisibleText("Prior To");
				Thread.sleep(1000);
				

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Companies_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Companies_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Companies_Companies_Name
				 Boolean companiesCompaniesNameOperator = driver.findElements(By.linkText(String.valueOf(Companies_Companies_Name))).size() >0;
					
				if ( ! companiesCompaniesNameOperator)
				{
					sheet1.getRow(30).createCell(9).setCellValue("FAILED");
					sheet1.getRow(30).createCell(8).setCellValue("Companies Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(30).createCell(9).setCellValue("PASSED");
					sheet1.getRow(30).createCell(8).setCellValue("Companies Companies Name Operator filter was found");
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

				

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Coverage_Status_Coverage_Component));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Coverage_Status_Coverage_Component))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Component
				 Boolean CoverageComponentStatusOperator = driver.findElements(By.linkText(String.valueOf(Coverage_Status_Coverage_Component))).size() >0;

				if ( ! CoverageComponentStatusOperator)
				{
					sheet1.getRow(31).createCell(9).setCellValue("FAILED");
					sheet1.getRow(31).createCell(8).setCellValue("Coverage Status Coverage Component Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(31).createCell(9).setCellValue("PASSED");
					sheet1.getRow(31).createCell(8).setCellValue("Coverage Status Coverage Component Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_component"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Coverage_Status_Coverage_Status));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Coverage_Status_Coverage_Status))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Status
				 Boolean CoverageStatusOperator = driver.findElements(By.linkText(String.valueOf(Coverage_Status_Coverage_Status))).size() >0;
						
				if ( ! CoverageStatusOperator)
				{
					sheet1.getRow(32).createCell(9).setCellValue("FAILED");
					sheet1.getRow(32).createCell(8).setCellValue("Coverage Status Coverage Status Operator Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(32).createCell(9).setCellValue("PASSED");
					sheet1.getRow(32).createCell(8).setCellValue("Coverage Status Coverage Status Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				//new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Between");
				//Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Coverage_Status_Coverage_Status_Description));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Coverage_Status_Coverage_Status_Description))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Coverage_Status_Coverage_Status_Description
				 Boolean CoverageStatusDescriptionOperator = driver.findElements(By.linkText(String.valueOf(Coverage_Status_Coverage_Status_Description))).size() >0;
							
				if ( ! CoverageStatusDescriptionOperator)
				{
					sheet1.getRow(33).createCell(9).setCellValue("FAILED");
					sheet1.getRow(33).createCell(8).setCellValue("Coverage Status Description Operator Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(33).createCell(9).setCellValue("PASSED");
					sheet1.getRow(33).createCell(8).setCellValue("Coverage Status Description Operator filter was found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}

				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Equal to");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Between");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Starts with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Ends by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Contains");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("In List");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Does not start with");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Does not end by");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Does not contain");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("coverage_statuscoverage_status_description"))).selectByVisibleText("Not in List");
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Hardware_Distributor_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Distributor_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Distributor_Companies_Name
				Boolean HWDistCompaniesNameOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Distributor_Companies_Name))).size() >0;
							
				if ( ! HWDistCompaniesNameOperator)
				{
					sheet1.getRow(34).createCell(9).setCellValue("FAILED");
					sheet1.getRow(34).createCell(8).setCellValue("Hardware Distributor Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(34).createCell(9).setCellValue("PASSED");
					sheet1.getRow(34).createCell(8).setCellValue("Hardware Distributor Companies Name Operator filter was found");
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

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);


				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Hardware_Distributor_Companies_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Distributor_Companies_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Distributor_Companies_Number
				 Boolean HWDistCompaniesNumberOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Distributor_Companies_Number))).size() >0;
							
				if ( ! HWDistCompaniesNumberOperator)
				{
					sheet1.getRow(35).createCell(9).setCellValue("FAILED");
					sheet1.getRow(35).createCell(8).setCellValue("Hardware Distributor Companies Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(35).createCell(9).setCellValue("PASSED");
					sheet1.getRow(35).createCell(8).setCellValue("Hardware Distributor Companies Number Operator filter was found");
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

				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Hardware_Manufacturer_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Name))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Manufacturer_Companies_Name
				 Boolean HWManufacturerCompaniesNameOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Name))).size() >0;
							
				if ( ! HWManufacturerCompaniesNameOperator)
				{
					sheet1.getRow(36).createCell(9).setCellValue("FAILED");
					sheet1.getRow(36).createCell(8).setCellValue("Hardware Manufacturer Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(36).createCell(9).setCellValue("PASSED");
					sheet1.getRow(36).createCell(8).setCellValue("Hardware Manufacturer Companies Name Operator filter was found");
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
				
			
				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Hardware_Manufacturer_Companies_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Manufacturer_Companies_Number
				Boolean HWManufacturerCompaniesNumberOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Manufacturer_Companies_Number))).size() >0;
							
				if ( ! HWManufacturerCompaniesNumberOperator)
				{
					sheet1.getRow(37).createCell(9).setCellValue("FAILED");
					sheet1.getRow(37).createCell(8).setCellValue("Hardware Manufacturer Companies Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(37).createCell(9).setCellValue("PASSED");
					sheet1.getRow(37).createCell(8).setCellValue("Hardware Manufacturer Companies Number Operator filter was found");
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
				
				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);

				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Hardware_Reseller_Companies_Name));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Reseller_Companies_Name))).click();
				Thread.sleep(1000);
				
				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Name
				Boolean HWResellerCompaniesNameOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Reseller_Companies_Name))).size() >0;
							
				if ( ! HWResellerCompaniesNameOperator)
				{
					sheet1.getRow(38).createCell(9).setCellValue("FAILED");
					sheet1.getRow(38).createCell(8).setCellValue("Hardware Reseller Companies Name Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(38).createCell(9).setCellValue("PASSED");
					sheet1.getRow(38).createCell(8).setCellValue("Hardware Reseller Companies Name Operator filter was found");
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
				
				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.id("drill_report-1")).sendKeys(String.valueOf(Hardware_Reseller_Companies_Number));
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(Hardware_Reseller_Companies_Number))).click();
				Thread.sleep(1000);

				//Find the Advance search filter box and Enter Hardware_Reseller_Companies_Number
				Boolean HWResellerCompaniesNumberOperator = driver.findElements(By.linkText(String.valueOf(Hardware_Reseller_Companies_Number))).size() >0;
							
				if ( ! HWResellerCompaniesNumberOperator)
				{
					sheet1.getRow(39).createCell(9).setCellValue("FAILED");
					sheet1.getRow(39).createCell(8).setCellValue("Hardware Reseller Companies Number Operator filter was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(39).createCell(9).setCellValue("PASSED");
					sheet1.getRow(39).createCell(8).setCellValue("Hardware Reseller Companies Number Operator filter was found");
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
				
				driver.findElement(By.id("drill_report-1")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-1")).click();
				Thread.sleep(1000);
				
				
				//Find the Advance search filter box and Click the "X" to close 
				Boolean AdvsrchClose = driver.findElements(By.xpath("//html/body/div[10]/div[1]/button")).size() >0;
							
				if ( ! AdvsrchClose)
				{
					sheet1.getRow(40).createCell(9).setCellValue("FAILED");
					sheet1.getRow(40).createCell(8).setCellValue("Advance Search Close button was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(40).createCell(9).setCellValue("PASSED");
					sheet1.getRow(40).createCell(8).setCellValue("Advance Search Close button was found and Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[10]/div[1]/button")).click();
					Thread.sleep(2000);
				}
				
				
				//Find the Refresh button to refresh the report grid
				Boolean GridRefresh = driver.findElements(By.id("refresh_grid")).size() >0;
							
				if ( ! GridRefresh)
				{
					sheet1.getRow(41).createCell(9).setCellValue("FAILED");
					sheet1.getRow(41).createCell(8).setCellValue("Refresh Grid button was NOT found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(41).createCell(9).setCellValue("PASSED");
					sheet1.getRow(41).createCell(8).setCellValue("Refresh Grid button was found and Initiated");
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
