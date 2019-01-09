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
//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class TC1421_LenovoCR_ReportFunctionsTest {
	
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
		File src=new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\Lenovo_AutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC1421");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword;
		String testReport;
		String reportSection;
		String columnName1;
		String columnName2;
		String userName;
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
		testReport = sheet1.getRow(1).getCell(6).getStringCellValue();
		reportSection = sheet1.getRow(1).getCell(5).getStringCellValue();
		userName = sheet1.getRow(1).getCell(7).getStringCellValue();
		columnName1 = sheet1.getRow(3).getCell(10).getStringCellValue();
		columnName2 = sheet1.getRow(4).getCell(10).getStringCellValue();
		
		
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
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Español");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Italiano");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Indonesia");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Deutsche");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Português");
				Thread.sleep(1000);
				new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Melayu");
				Thread.sleep(1000);
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
			
			//Click on the Reports Tab
			Boolean reportsDashTab =  driver.findElements(By.linkText("Report Dashboard")).size() >0;
			
			if( ! reportsDashTab)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("Reports Dashboard link was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();

			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("Reports Dashboard link was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText("Report Dashboard")).click();
				Thread.sleep(7000);
			}
			

	       	//Find the Favorite Reports drop down and click
			if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
				
				driver.findElement(By.id("tabs_scroll_toggle")).click();
				 Thread.sleep(3000);
				 
				 driver.findElement(By.id("tabs_scroll_toggle")).click();
				 Thread.sleep(3000);}
			
			jse.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(2000);
			
			//Click on the Reports Tab
			Boolean reportsSection =  driver.findElements(By.linkText(String.valueOf(reportSection))).size() >0;
			
			if( ! reportsSection)
			{
				sheet1.getRow(11).createCell(9).setCellValue("FAILED");
				sheet1.getRow(11).createCell(8).setCellValue("Reports Section '" + String.valueOf(reportSection) + "' was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();

			}
			else
			{
				sheet1.getRow(11).createCell(9).setCellValue("PASSED");
				sheet1.getRow(11).createCell(8).setCellValue("Reports Section '" + String.valueOf(reportSection) + "' was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText(String.valueOf(reportSection))).click();
				Thread.sleep(6000);
			}
			
			//if(driver.findElements(By.linkText(String.valueOf(reportSection))).size()>0) {
				 
				//driver.findElement(By.linkText(String.valueOf(reportSection))).click();
				//Thread.sleep(3000);}
			
			EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
			eventFiringWebDriver.executeScript("document.getElementById('ui-id-12').scrollTop=400");
			
			
			//By locator = null;
			//jse.executeScript("window.scrollBy(0,150)", "");
			//WebElement element = driver.findElement(By.id(String.valueOf(testReport)));
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			//jse.executeScript("arguments[0].scrollIntoView(true);",String.valueOf(testReport));
			Thread.sleep(2000);
			//jse.executeScript("window.scrollBy(0,-250)", "");
			
			//WebElement element = driver.findElement(By.id("id"));
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
						
			  //Find the General Reports Drop down Menu
			 Boolean selectedReport = driver.findElements(By.linkText(String.valueOf(testReport))).size() >0;
			
			if ( ! selectedReport)
			{
				sheet1.getRow(12).createCell(9).setCellValue("FAILED");
				sheet1.getRow(12).createCell(8).setCellValue("Report '" + String.valueOf(testReport) + "' was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(12).createCell(9).setCellValue("PASSED");
				sheet1.getRow(12).createCell(8).setCellValue("Report '" + String.valueOf(testReport) + "' was found and Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//driver.findElement(By.linkText(String.valueOf(reportSection)).findElement((SearchContext) By.linkText(String.valueOf(testReport))).click());
				driver.findElement(By.id("ui-id-12")).findElement(By.linkText(String.valueOf(testReport))).click();
				Thread.sleep(3000);				
				//driver.findElement(By.linkText(String.valueOf(testReport))).click();
				//((JavascriptExecutor)driver).executeScript("arguments[0].click();", String.valueOf(testReport));
								
				//driver.findElement(By.linkText(String.valueOf(testReport))).click();
				//((JavascriptExecutor)driver).executeScript("arguments[0].click();", String.valueOf(testReport));
								
				//WebElement element = driver.findElement(By.linkText(String.valueOf(testReport)));
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				//driver.switch_to.frame(driver.findElement(By.id("frame_id")));
				
			}
			
			//Find the Quick Filter search and find attributes
			Boolean columnAsset = driver.findElements(By.id("quickFilterSearch")).size() >0;
			
			if ( ! columnAsset)
			{
				sheet1.getRow(13).createCell(9).setCellValue("FAILED");
				sheet1.getRow(13).createCell(8).setCellValue("Quick Filter Search Box was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(13).createCell(9).setCellValue("PASSED");
				sheet1.getRow(13).createCell(8).setCellValue("Quick Filter Search Box was Found and Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("quickFilterSearch")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("quickFilterSearch")).sendKeys("Last Name");
				Thread.sleep(1000);
				driver.findElement(By.id("quickFilterSearch")).sendKeys("Company Name");
				Thread.sleep(1000);
				driver.findElement(By.id("quickFilterSearch")).sendKeys("Email Address");
				Thread.sleep(2000);
				driver.findElement(By.id("quickFilterSearch")).click();
				Thread.sleep(1000);
				
				}
			
			//Find the Quick Search Text box and send value
			Boolean quickSerach = driver.findElements(By.id("quicksearchtext")).size() >0;
			
			if ( ! quickSerach)
			{
				sheet1.getRow(14).createCell(9).setCellValue("FAILED");
				sheet1.getRow(14).createCell(8).setCellValue("Quick Search Text Box was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(14).createCell(9).setCellValue("PASSED");
				sheet1.getRow(14).createCell(8).setCellValue("Quick Search Text Box was Found and Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("quicksearchtext")).sendKeys(userName);
				Thread.sleep(2000);
				
			}
			
			//Find the Quick Search text button and click
			Boolean quickSerachButton = driver.findElements(By.id("quicksearchbutton")).size() >0;
			
			if ( ! quickSerachButton)
			{
				sheet1.getRow(15).createCell(9).setCellValue("FAILED");
				sheet1.getRow(15).createCell(8).setCellValue("Quick Search Text Button was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(15).createCell(9).setCellValue("PASSED");
				sheet1.getRow(15).createCell(8).setCellValue("Quick Search Text Button was Found and Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("quicksearchbutton")).click();
				Thread.sleep(4000);
			}
			
			//Find the Quick Search text button and click
			Boolean quickSerachReset = driver.findElements(By.id("quicksearchreset")).size() >0;
			
			if ( ! quickSerachReset)
			{
				sheet1.getRow(16).createCell(9).setCellValue("FAILED");
				sheet1.getRow(16).createCell(8).setCellValue("Quick Search Reset Button was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(16).createCell(9).setCellValue("PASSED");
				sheet1.getRow(16).createCell(8).setCellValue("Quick Search Reset Button was Found and Selected");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("quicksearchreset")).click();
				Thread.sleep(3000);
			}
			
			
			//Find the Excel Export button and Identify
			Boolean excelExport = driver.findElements(By.id("export_report")).size() >0;
						
			if ( ! excelExport)
			{
				sheet1.getRow(17).createCell(9).setCellValue("FAILED");
				sheet1.getRow(17).createCell(8).setCellValue("Excel Export button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(17).createCell(9).setCellValue("PASSED");
				sheet1.getRow(17).createCell(8).setCellValue("Excel Export button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element0 = driver.findElement(By.id("export_report"));
		        Actions action0 = new Actions(driver);
		        action0.moveToElement(element0).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the PDF Export button and Identify
			Boolean pdfExport = driver.findElements(By.id("pdf_export_report")).size() >0;
						
			if ( ! pdfExport)
			{
				sheet1.getRow(18).createCell(9).setCellValue("FAILED");
				sheet1.getRow(18).createCell(8).setCellValue("PDF Export button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(18).createCell(9).setCellValue("PASSED");
				sheet1.getRow(18).createCell(8).setCellValue("PDF Export button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element1 = driver.findElement(By.id("pdf_export_report"));
		        Actions action1 = new Actions(driver);
		        action1.moveToElement(element1).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Email Export button and Identify
			Boolean emailExport = driver.findElements(By.id("email_report")).size() >0;
						
			if ( ! emailExport)
			{
				sheet1.getRow(19).createCell(9).setCellValue("FAILED");
				sheet1.getRow(19).createCell(8).setCellValue("Email Export button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(19).createCell(9).setCellValue("PASSED");
				sheet1.getRow(19).createCell(8).setCellValue("Email Export button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element2 = driver.findElement(By.id("email_report"));
		        Actions action2 = new Actions(driver);
		        action2.moveToElement(element2).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Print Export button and Identify
			Boolean printExport = driver.findElements(By.id("print_report")).size() >0;
						
			if ( ! printExport)
			{
				sheet1.getRow(20).createCell(9).setCellValue("FAILED");
				sheet1.getRow(20).createCell(8).setCellValue("Print Export button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(20).createCell(9).setCellValue("PASSED");
				sheet1.getRow(20).createCell(8).setCellValue("Print Export button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element3 = driver.findElement(By.id("print_report"));
		        Actions action3 = new Actions(driver);
		        action3.moveToElement(element3).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Add to Favorite Report button and identify
			Boolean addFavReport = driver.findElements(By.id("add_to_favorites")).size() >0;
						
			if ( ! addFavReport)
			{
				sheet1.getRow(21).createCell(9).setCellValue("FAILED");
				sheet1.getRow(21).createCell(8).setCellValue("Add to Favorites button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(21).createCell(9).setCellValue("PASSED");
				sheet1.getRow(21).createCell(8).setCellValue("Add to Favorites was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element4 = driver.findElement(By.id("add_to_favorites"));
		        Actions action4 = new Actions(driver);
		        action4.moveToElement(element4).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Remove from Favorite Report button and identify
			Boolean removeFavReport = driver.findElements(By.id("remove_from_favorites")).size() >0;
						
			if ( ! removeFavReport)
			{
				sheet1.getRow(22).createCell(9).setCellValue("FAILED");
				sheet1.getRow(22).createCell(8).setCellValue("Remove from Favorites button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				sheet1.getRow(22).createCell(9).setCellValue("PASSED");
				sheet1.getRow(22).createCell(8).setCellValue("Remove from Favorites button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element4 = driver.findElement(By.id("remove_from_favorites"));
		        Actions action4 = new Actions(driver);
		        action4.moveToElement(element4).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Share Report button and Identify
			Boolean shareReport = driver.findElements(By.id("share_report")).size() >0;
						
			if ( ! shareReport)
			{
				sheet1.getRow(23).createCell(9).setCellValue("FAILED");
				sheet1.getRow(23).createCell(8).setCellValue("Share Report button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(23).createCell(9).setCellValue("PASSED");
				sheet1.getRow(23).createCell(8).setCellValue("Share Report button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element5 = driver.findElement(By.id("share_report"));
		        Actions action5 = new Actions(driver);
		        action5.moveToElement(element5).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Remove Share button and Identify
			Boolean removeShareReport = driver.findElements(By.id("unshare_report")).size() >0;
						
			if ( ! removeShareReport)
			{
				sheet1.getRow(24).createCell(9).setCellValue("FAILED");
				sheet1.getRow(24).createCell(8).setCellValue("Remove Shared Report button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(24).createCell(9).setCellValue("PASSED");
				sheet1.getRow(24).createCell(8).setCellValue("Remove Shared button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element6 = driver.findElement(By.id("unshare_report"));
		        Actions action6 = new Actions(driver);
		        action6.moveToElement(element6).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Clone Report button and Identify
			Boolean cloneReport = driver.findElements(By.id("clone_report")).size() >0;
						
			if ( ! cloneReport)
			{
				sheet1.getRow(25).createCell(9).setCellValue("FAILED");
				sheet1.getRow(25).createCell(8).setCellValue("Clone Report button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(25).createCell(9).setCellValue("PASSED");
				sheet1.getRow(25).createCell(8).setCellValue("clone Report button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element7 = driver.findElement(By.id("clone_report"));
		        Actions action7 = new Actions(driver);
		        action7.moveToElement(element7).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Notification button and Identify
			Boolean notificationReport = driver.findElements(By.id("notification")).size() >0;
						
			if ( ! notificationReport)
			{
				sheet1.getRow(26).createCell(9).setCellValue("FAILED");
				sheet1.getRow(26).createCell(8).setCellValue("Notification button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(26).createCell(9).setCellValue("PASSED");
				sheet1.getRow(26).createCell(8).setCellValue("Notification button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element8 = driver.findElement(By.id("notification"));
		        Actions action8 = new Actions(driver);
		        action8.moveToElement(element8).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the View Graphs and Charts button and Identify
			Boolean graphCharts = driver.findElements(By.id("show_graph_icon")).size() >0;
						
			if ( ! graphCharts)
			{
				sheet1.getRow(27).createCell(9).setCellValue("FAILED");
				sheet1.getRow(27).createCell(8).setCellValue("Graphs and Charts button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(27).createCell(9).setCellValue("PASSED");
				sheet1.getRow(27).createCell(8).setCellValue("Graphs and Charts button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element9 = driver.findElement(By.id("show_graph_icon"));
		        Actions action9 = new Actions(driver);
		        action9.moveToElement(element9).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Report Sorting button and Identify
			Boolean sortReport = driver.findElements(By.id("report_sorting")).size() >0;
						
			if ( ! sortReport)
			{
				sheet1.getRow(28).createCell(9).setCellValue("FAILED");
				sheet1.getRow(28).createCell(8).setCellValue("Sort Report button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(28).createCell(9).setCellValue("PASSED");
				sheet1.getRow(28).createCell(8).setCellValue("Sort Report button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element10 = driver.findElement(By.id("report_sorting"));
		        Actions action10 = new Actions(driver);
		        action10.moveToElement(element10).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Report Grouping button and Identify
			Boolean groupReport = driver.findElements(By.id("report_grouping")).size() >0;
						
			if ( ! groupReport)
			{
				sheet1.getRow(29).createCell(9).setCellValue("FAILED");
				sheet1.getRow(29).createCell(8).setCellValue("Group Report button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(29).createCell(9).setCellValue("PASSED");
				sheet1.getRow(29).createCell(8).setCellValue("Group Report button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element11 = driver.findElement(By.id("report_grouping"));
		        Actions action11 = new Actions(driver);
		        action11.moveToElement(element11).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Refresh Grid button and Identify
			Boolean gridRefresh = driver.findElements(By.id("refresh_grid")).size() >0;
						
			if ( ! gridRefresh)
			{
				sheet1.getRow(30).createCell(9).setCellValue("FAILED");
				sheet1.getRow(30).createCell(8).setCellValue("Refresh Grid button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(30).createCell(9).setCellValue("PASSED");
				sheet1.getRow(30).createCell(8).setCellValue("Refresh Grid button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element12 = driver.findElement(By.id("refresh_grid"));
		        Actions action12 = new Actions(driver);
		        action12.moveToElement(element12).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Grid Save Column Layout  button to open the Column Grid Selector
			Boolean gridSave = driver.findElements(By.id("grid_save")).size() >0;
						
			if ( ! gridSave)
			{
				sheet1.getRow(31).createCell(9).setCellValue("FAILED");
				sheet1.getRow(31).createCell(8).setCellValue("Save Column Layout button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(31).createCell(9).setCellValue("PASSED");
				sheet1.getRow(31).createCell(8).setCellValue("Save Column Layout button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element14 = driver.findElement(By.id("grid_save"));
		        Actions action14 = new Actions(driver);
		        action14.moveToElement(element14).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Reset Grid Columns button to open the Column Grid Selector
			Boolean gridReset = driver.findElements(By.id("grid_reset")).size() >0;
						
			if ( ! gridReset)
			{
				sheet1.getRow(32).createCell(9).setCellValue("FAILED");
				sheet1.getRow(32).createCell(8).setCellValue("Reset Grid Columns button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(32).createCell(9).setCellValue("PASSED");
				sheet1.getRow(32).createCell(8).setCellValue("Reset Grid Columns button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				WebElement element15 = driver.findElement(By.id("grid_reset"));
		        Actions action15 = new Actions(driver);
		        action15.moveToElement(element15).build().perform();
				Thread.sleep(2000);
			}
			
			//Find the Add & Remove Columns button to open the Column Grid Selector
			Boolean gridColumns = driver.findElements(By.id("grid_columns")).size() >0;
						
			if ( ! gridColumns)
			{
				sheet1.getRow(33).createCell(9).setCellValue("FAILED");
				sheet1.getRow(33).createCell(8).setCellValue("Add & Remove Columns button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(33).createCell(9).setCellValue("PASSED");
				sheet1.getRow(33).createCell(8).setCellValue("Add & Remove Columns button was found and Identified");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("grid_columns")).click();
		       	Thread.sleep(3000);
			}
			
			//Find the Remove All button to remove all the grid columns
			Boolean RemoveAll = driver.findElements(By.cssSelector(".remove-all")).size() >0;
						
			if ( ! RemoveAll)
			{
				sheet1.getRow(34).createCell(9).setCellValue("FAILED");
				sheet1.getRow(34).createCell(8).setCellValue("Remove All button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(34).createCell(9).setCellValue("PASSED");
				sheet1.getRow(34).createCell(8).setCellValue("Remove All button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".remove-all")).click();
				Thread.sleep(2000);
			}
			
			//Find the Column Search Box and Select it
			Boolean ColumnSrch = driver.findElements(By.cssSelector(".search")).size() >0;
						
			if ( ! ColumnSrch)
			{
				sheet1.getRow(35).createCell(9).setCellValue("FAILED");
				sheet1.getRow(35).createCell(8).setCellValue("Column Search Box was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(35).createCell(9).setCellValue("PASSED");
				sheet1.getRow(35).createCell(8).setCellValue("Column Search Box was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".search")).clear();
				driver.findElement(By.cssSelector(".search")).click();
				Thread.sleep(2000);
			}
			
			//Find the Column Search Box and send Column Search Name
			Boolean ColumnSrch1 = driver.findElements(By.cssSelector(".search")).size() >0;
						
			if ( ! ColumnSrch1)
			{
				sheet1.getRow(36).createCell(9).setCellValue("FAILED");
				sheet1.getRow(36).createCell(8).setCellValue("Column '" + String.valueOf(columnName1) + "' was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(36).createCell(9).setCellValue("PASSED");
				sheet1.getRow(36).createCell(8).setCellValue("Column '" + String.valueOf(columnName1) + "' was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".search")).clear();
				driver.findElement(By.cssSelector(".search")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(columnName1));
				Thread.sleep(2000);
			}
			
			//Find the Column Search Box and send Column Search Name
			Boolean ColumnSrch2 = driver.findElements(By.cssSelector(".search")).size() >0;
						
			if ( ! ColumnSrch2)
			{
				sheet1.getRow(37).createCell(9).setCellValue("FAILED");
				sheet1.getRow(37).createCell(8).setCellValue("Column '" + String.valueOf(columnName2) + "' was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(37).createCell(9).setCellValue("PASSED");
				sheet1.getRow(37).createCell(8).setCellValue("Column '" + String.valueOf(columnName2) + "' was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".search")).clear();
				driver.findElement(By.cssSelector(".search")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(columnName2));
				Thread.sleep(2000);
			}
			
			driver.findElement(By.cssSelector(".search")).clear();
			driver.findElement(By.cssSelector(".search")).click();
			Thread.sleep(1000);
			
			//Find the Add All button to Add all the grid columns
			Boolean AddAll = driver.findElements(By.cssSelector(".add-all")).size() >0;
						
			if ( ! AddAll)
			{
				sheet1.getRow(38).createCell(9).setCellValue("FAILED");
				sheet1.getRow(38).createCell(8).setCellValue("Add All button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(38).createCell(9).setCellValue("PASSED");
				sheet1.getRow(38).createCell(8).setCellValue("Add All button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".add-all")).click();
				Thread.sleep(2000);
			}
			
			//Find the Close button to close the grid columns
			Boolean closeColumns = driver.findElements(By.xpath("//html/body/div[10]/div[3]/div/button[2]")).size() >0;
						
			if ( ! closeColumns)
			{
				sheet1.getRow(39).createCell(9).setCellValue("FAILED");
				sheet1.getRow(39).createCell(8).setCellValue("Cancel button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(39).createCell(9).setCellValue("PASSED");
				sheet1.getRow(39).createCell(8).setCellValue("Cancel button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.xpath("//html/body/div[10]/div[3]/div/button[2]")).click();
				Thread.sleep(2000);
			}
			
				
			//Click the Advanced Search Link
			Boolean advsrchButton = driver.findElements(By.linkText("Advanced Search")).size() >0;
			
			
			if ( ! advsrchButton)
			{
				
				sheet1.getRow(40).createCell(9).setCellValue("FAILED");
				sheet1.getRow(40).createCell(8).setCellValue("Advanced Search was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(40).createCell(9).setCellValue("PASSED");
				sheet1.getRow(40).createCell(8).setCellValue("Advanced Search was Found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText("Advanced Search")).click();
				Thread.sleep(3000);
				}
			
					
			//Click the Advanced search link filter
			Boolean filterBy = driver.findElements(By.id("drill_report-87")).size() >0;
			
			
			if ( ! filterBy)
			{
				
				sheet1.getRow(41).createCell(9).setCellValue("FAILED");
				sheet1.getRow(41).createCell(8).setCellValue("'Filter by' serach box was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(41).createCell(9).setCellValue("PASSED");
				sheet1.getRow(41).createCell(8).setCellValue("'Filter by' serach box was Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("drill_report-87")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("drill_report-87")).click();
				Thread.sleep(1000);
				driver.findElement(By.linkText(String.valueOf(columnName1))).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText(String.valueOf(columnName2))).click();
				Thread.sleep(2000);
				}
				
			
			//Find the Advance search filter box and Click the "X" to close 
			Boolean AdvsrchClose = driver.findElements(By.xpath("//html/body/div[10]/div[1]/button")).size() >0;
						
			if ( ! AdvsrchClose)
			{
				sheet1.getRow(42).createCell(9).setCellValue("FAILED");
				sheet1.getRow(42).createCell(8).setCellValue("Advance Search Close button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(42).createCell(9).setCellValue("PASSED");
				sheet1.getRow(42).createCell(8).setCellValue("Advance Search Close button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.xpath("//html/body/div[10]/div[1]/button")).click();
				Thread.sleep(2000);
			}
			
				
			//Find the Refresh button to refresh the report grid
			Boolean GridRefresh = driver.findElements(By.id("refresh_grid")).size() >0;
						
			if ( ! GridRefresh)
			{
				sheet1.getRow(43).createCell(9).setCellValue("FAILED");
				sheet1.getRow(43).createCell(8).setCellValue("Refresh Grid button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(43).createCell(9).setCellValue("PASSED");
				sheet1.getRow(43).createCell(8).setCellValue("Refresh Grid button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("refresh_grid")).click();
				Thread.sleep(5000);
			}
			
			//Find the Collapse Reports button to collapse the report grid
			Boolean collapseGrid = driver.findElements(By.id("tree_close")).size() >0;
						
			if ( ! collapseGrid)
			{
				sheet1.getRow(44).createCell(9).setCellValue("FAILED");
				sheet1.getRow(44).createCell(8).setCellValue("Collapse Report Tree button was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(44).createCell(9).setCellValue("PASSED");
				sheet1.getRow(44).createCell(8).setCellValue("Collapse Report Tree button was found and Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("tree_close")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("tree_close")).click();
				Thread.sleep(1000);
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
