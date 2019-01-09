package lenovoAutomation;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.annotations.Test;
import java.io.*;  
import javax.swing.*;  

//import com.google.common.io.Files;

//import javafx.scene.control.Alert.AlertType;


public class TC1431_Column_Identification {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;


	
	

	//@Test(priority=0)
	public static void main(String[] args) throws Throwable, IOException, InterruptedException { 
	
	//@SuppressWarnings("resource")
	//@Test(priority=1)
	//public void Column_Identification() throws Throwable {
		
		
	
	
	//System.setProperty("webdriver.gecko.driver", "C:\\mmi_automation\\mmi_Lenovo_ auto_testing\\bin\\geckodriver.exe");
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver=new FirefoxDriver();
	
	
	
	//Maximize the browser window
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	File src=new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\Report_Columns.xlsx");
	//File src=new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\Book1.xlsx");
	//File src=new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\Book2.xlsx");
	
	FileInputStream fis = new FileInputStream(src);
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
		
	//ArrayList<String> ls=new ArrayList<String>();
	
	//k = sheet number
	//for(int k=2; k<=100;k++)
	
	
	//Get sheet by name
	XSSFSheet mySheet = wb.getSheet("TC1431");
	//XSSFSheet sheet2 = wb.getSheet("TC1431_data_reportColumns");
	//for (int i = 1; i < wb.getNumberOfSheets(); i++) {
	//XSSFSheet sheet2 = wb.getSheetAt(i);
	//XSSFSheet mySheet = wb.getSheetAt(k);
	
	//while ()
	
	String baseUrl ;
	String loginUrl; 
	String logoutUrl; 
	String testUsername;
	String testPassword;
	
	
	
	baseUrl = mySheet.getRow(1).getCell(0).getStringCellValue();
	logoutUrl = baseUrl + "/auth/logout"; 
	loginUrl = baseUrl + "/auth/login"; 
	testUsername = mySheet.getRow(1).getCell(1).getStringCellValue();
	testPassword = mySheet.getRow(1).getCell(2).getStringCellValue();
	
	
	driver.get(logoutUrl);
	Thread.sleep(2000);
	driver.get(loginUrl);
	Thread.sleep(2000);
	
	//Find the Language drop down and select English
	boolean languageResult = driver.findElements(By.id("language_select")).size()>0; 
	
	if(! languageResult)
         
    {
		mySheet.getRow(4).createCell(9).setCellValue("FAILED");
		mySheet.getRow(4).createCell(8).setCellValue("Language was NOT Selected");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		//wb.close();	
		driver.quit();
	}

	else 
	{
		mySheet.getRow(4).createCell(9).setCellValue("PASSED");
		mySheet.getRow(4).createCell(8).setCellValue("Language was Selected");
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
		boolean actualResult = driver.findElements(By.id("email")).size()>0; 
		
		if(! actualResult)
	         
      {
			mySheet.getRow(5).createCell(9).setCellValue("FAILED");
			mySheet.getRow(5).createCell(8).setCellValue("Username was NOT Input");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}

		else 
		{
			mySheet.getRow(5).createCell(9).setCellValue("PASSED");
			mySheet.getRow(5).createCell(8).setCellValue("Username was Input");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("email")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("email")).sendKeys(testUsername);
			Thread.sleep(2000);
		}

		//Find the password text box and send the password id
		boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
		
		if(! actualResult1)
	          
      {
			mySheet.getRow(6).createCell(9).setCellValue("FAILED");
			mySheet.getRow(6).createCell(8).setCellValue("Password was NOT Input");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}

		else 
		{
			mySheet.getRow(6).createCell(9).setCellValue("PASSED");
			mySheet.getRow(6).createCell(8).setCellValue("Password was Input");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("password-text")).sendKeys(testPassword);
			Thread.sleep(2000);
		}
		
		//Click the Login button and wait for Login
		boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
		
		if(! actualResult2)
	         
		{
			mySheet.getRow(7).createCell(9).setCellValue("FAILED");
			mySheet.getRow(7).createCell(8).setCellValue("Login button NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}

		else 
		{
			mySheet.getRow(7).createCell(9).setCellValue("PASSED");
			mySheet.getRow(7).createCell(8).setCellValue("login button was found and clicked");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("Login")).click();
			Thread.sleep(20000);
		}
			
		//find the Reports Dash board tab
		boolean actualResult3 =  driver.findElements(By.id("content_pane")).size() >0;
		
		if(! actualResult3)
		{
			mySheet.getRow(8).createCell(9).setCellValue("FAILED");
			mySheet.getRow(8).createCell(8).setCellValue("Dashboard was not displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
			
		}
		else
		{
			mySheet.getRow(8).createCell(9).setCellValue("PASSED");
			mySheet.getRow(8).createCell(8).setCellValue("Dashboard was found and displayed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			Thread.sleep(4000);
		}
		
		
		
		//Loop through all sheets in workbook
		for (int i = 1; i < wb.getNumberOfSheets(); i++) {
		XSSFSheet sheet2 = wb.getSheetAt(i);
		System.out.println(sheet2.getSheetName());
		Thread.sleep(1000);
		System.out.println("Number of sheets in this workbook: " + wb.getNumberOfSheets());
		String reportName;
		String reportSection;
		reportName = sheet2.getRow(1).getCell(1).getStringCellValue();
		reportSection = sheet2.getRow(1).getCell(0).getStringCellValue();
		
		
		//Click on the Reports Tab
		boolean reportsTab =  driver.findElements(By.id("topmenuitem_4")).size() >0;
		
		if( ! reportsTab)
		{
			mySheet.getRow(9).createCell(9).setCellValue("FAILED");
			mySheet.getRow(9).createCell(8).setCellValue("Reports Tab menu was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();

		}
		else
		{
			mySheet.getRow(9).createCell(9).setCellValue("PASSED");
			mySheet.getRow(9).createCell(8).setCellValue("Reports Tab menu was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("topmenuitem_4")).click();
			Thread.sleep(6000);
		}
		
				
		//Click on the Reports Tab
		boolean reportsDashTab =  driver.findElements(By.linkText("Report Dashboard")).size() >0;
		
		if( ! reportsDashTab)
		{
			mySheet.getRow(10).createCell(9).setCellValue("FAILED");
			mySheet.getRow(10).createCell(8).setCellValue("Reports Dashboard link was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();

		}
		else
		{
			mySheet.getRow(10).createCell(9).setCellValue("PASSED");
			mySheet.getRow(10).createCell(8).setCellValue("Reports Dashboard link was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.linkText("Report Dashboard")).click();
			Thread.sleep(12000);
			
		}
		

       	//Find the Favorite Reports drop down and click
		if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
			
			driver.findElement(By.id("tabs_scroll_toggle")).click();
			 Thread.sleep(3000);
			 
			 driver.findElement(By.id("tabs_scroll_toggle")).click();
			 Thread.sleep(3000);}
		
		jse.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		
		
		//Click on the Reports Tab
		boolean reportsSection =  driver.findElements(By.linkText(String.valueOf(reportSection))).size() >0;
		
		if( ! reportsSection)
		{
			mySheet.getRow(11).createCell(9).setCellValue("FAILED");
			mySheet.getRow(11).createCell(8).setCellValue("Reports Section '" + String.valueOf(reportSection) + "' was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();

		}
		else
		{
			mySheet.getRow(11).createCell(9).setCellValue("PASSED");
			mySheet.getRow(11).createCell(8).setCellValue("Reports Section '" + String.valueOf(reportSection) + "' was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//driver.findElement(By.linkText(String.valueOf(reportSection))).click();
			Thread.sleep(6000);
		}
		
	
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.executeScript("document.getElementById('ui-id-6').scrollTop=600");
		Thread.sleep(2000);
		
		//WebElement element = driver.findElement(By.linkText(String.valueOf(reportSection)));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		//By locator = null;
		//jse.executeScript("window.scrollBy(0,150)", "");
		//WebElement element = driver.findElement(By.id(String.valueOf(reportName)));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//jse.executeScript("arguments[0].scrollIntoView(true);",String.valueOf(reportName));
		//jse.executeScript("window.scrollBy(0,-250)", "");
		//WebElement element = driver.findElement(By.id("id"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
					
		 //Find the General Reports Drop down Menu
		 boolean selectedReport = driver.findElements(By.linkText(String.valueOf(reportName))).size() >0;
		
		if ( ! selectedReport)
		{
			mySheet.getRow(12).createCell(9).setCellValue("FAILED");
			mySheet.getRow(12).createCell(8).setCellValue("Report '" + String.valueOf(reportName) + "' was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			mySheet.getRow(12).createCell(9).setCellValue("PASSED");
			mySheet.getRow(12).createCell(8).setCellValue("Report '" + String.valueOf(reportName) + "' was found and Selected");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("ui-id-6")).findElement(By.linkText(String.valueOf(reportName))).click();
			Thread.sleep(3000);	
			
			//driver.findElement(By.linkText(String.valueOf(reportName))).click();
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();", String.valueOf(reportName));
			//WebElement element = driver.findElement(By.linkText(String.valueOf(reportName)));
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			//driver.switch_to.frame(driver.findElement(By.id("frame_id")));
		}
			
		//Find the Quick Filter search and find attributes
		boolean columnAsset = driver.findElements(By.id("clone_report")).size() >0;
		
		if ( ! columnAsset)
		{
			mySheet.getRow(13).createCell(9).setCellValue("FAILED");
			mySheet.getRow(13).createCell(8).setCellValue("Clone Report button was NOT Found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			mySheet.getRow(13).createCell(9).setCellValue("PASSED");
			mySheet.getRow(13).createCell(8).setCellValue("Clone Report button was Found and Selected");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			WebElement element1 = driver.findElement(By.id("clone_report"));
	        Actions action1 = new Actions(driver);
	        action1.moveToElement(element1).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.id("clone_report")).click();
			Thread.sleep(40000);
			
		}
		
		//(new WebDriverWait(driver, 10))
				 // .until(ExpectedConditions.presenceOfElementLocated(By.id("report_condition_fields")));
		
		/*WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content_pane")));}
		catch (TimeoutException|NoSuchElementException e) {
            System.out.print(e);
        }*/
		
				
		//Scroll window down 150 pix
		jse.executeScript("window.scrollBy(0,150)", "");
		Thread.sleep(2000);
		
		
		//Declare the Column Name and Row number
		String columnName;
		columnName = sheet2.getRow(1).getCell(3).getStringCellValue();
		int rownum = 1;
		while(! columnName.equals(""))
		//for (int i = 1; i < wb.getNumberOfSheets(); i++)
			//XSSFSheet sheet2 = wb.getSheetAt(i);
		
			
		{
			
		//Find the Column
		boolean columnSerach1 = driver.findElements(By.name(String.valueOf(columnName))).size() >0;
		
		if ( ! columnSerach1)
		{
			sheet2.getRow(rownum).createCell(6).setCellValue("FAILED");
			sheet2.getRow(rownum).createCell(4).setCellValue("Report Column '" + String.valueOf(columnName) + "' was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			//driver.quit();
		}
		else
		{
			sheet2.getRow(rownum).createCell(5).setCellValue("PASSED");
			sheet2.getRow(rownum).createCell(4).setCellValue("Report Column '" + String.valueOf(columnName) + "' was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			WebElement element1 = driver.findElement(By.name(String.valueOf(columnName)));
	        Actions action1 = new Actions(driver);
	        jse.executeScript("arguments[0].scrollIntoView(true);", element1);
	        action1.moveToElement(element1).build().perform();
			Thread.sleep(3000);
		}
			//Loop Row ++
			rownum++;
			
			
			//Try last cell, if not there then catch exception
			try {
			columnName = sheet2.getRow(rownum).getCell(3).getStringCellValue();
			}
			catch(Exception e)
			{
				columnName = "";
			}
			
		}
	}
		

			
		//Scroll window down 1000 pix
		jse.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		
		//Find the Condition Fields 
		boolean conditionFields = driver.findElements(By.id("report_condition_fields")).size() >0;
					
		if ( ! conditionFields)
		{
			mySheet.getRow(14).createCell(9).setCellValue("FAILED");
			mySheet.getRow(14).createCell(8).setCellValue("Condition Fields section was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			mySheet.getRow(14).createCell(9).setCellValue("PASSED");
			mySheet.getRow(14).createCell(8).setCellValue("Condition Fields section was found and Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			WebElement element1 = driver.findElement(By.id("report_condition_fields"));
	        Actions action1 = new Actions(driver);
	        action1.moveToElement(element1).build().perform();
			Thread.sleep(2000);
			EventFiringWebDriver conFields = new EventFiringWebDriver(driver);
			conFields.executeScript("document.getElementById('report_condition_fields').scrollTop=200");
			Thread.sleep(2000);
		}
			
		//Find the Save Report button
		boolean saveReport = driver.findElements(By.id("save-report")).size() >0;
					
		if ( ! saveReport)
		{
			mySheet.getRow(15).createCell(9).setCellValue("FAILED");
			mySheet.getRow(15).createCell(8).setCellValue("Save Report button was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			mySheet.getRow(15).createCell(9).setCellValue("PASSED");
			mySheet.getRow(15).createCell(8).setCellValue("Save Report button was found and Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("save-report")).click();
			Thread.sleep(5000);
		}
		
		//Find the Save Report Dialog box
		boolean saveDialog = driver.findElements(By.id("report-save-dialog")).size() >0;
					
		if ( ! saveDialog)
		{
			mySheet.getRow(16).createCell(9).setCellValue("FAILED");
			mySheet.getRow(16).createCell(8).setCellValue("Report Save Dialog box was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			mySheet.getRow(16).createCell(9).setCellValue("PASSED");
			mySheet.getRow(16).createCell(8).setCellValue("Report Save Dialog box was found and Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("report-save-dialog")).click();
			Thread.sleep(2000);
		}
		
		//Find the Save Report Name box
		boolean saveReportName = driver.findElements(By.id("save-report-name")).size() >0;
					
		if ( ! saveReportName)
		{
			mySheet.getRow(17).createCell(9).setCellValue("FAILED");
			mySheet.getRow(17).createCell(8).setCellValue("Save Report Name box was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			mySheet.getRow(17).createCell(9).setCellValue("PASSED");
			mySheet.getRow(17).createCell(8).setCellValue("Save Report Name box was found and Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("save-report-name")).click();
			Thread.sleep(2000);
		}
		
		//Find the Save Report Description box
		boolean saveReportDesc = driver.findElements(By.id("save-report-desc")).size() >0;
					
		if ( ! saveReportDesc)
		{
			mySheet.getRow(18).createCell(9).setCellValue("FAILED");
			mySheet.getRow(18).createCell(8).setCellValue("Save Report Description box was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			mySheet.getRow(18).createCell(9).setCellValue("PASSED");
			mySheet.getRow(18).createCell(8).setCellValue("Save Report Description box was found and Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("save-report-desc")).click();
			Thread.sleep(2000);
		}
		
		//Click the Cancel button
		boolean cancelButton = driver.findElements(By.xpath("//html/body/div[6]/div[3]/div/button[2]")).size() >0;
					
		if ( ! cancelButton)
		{
			mySheet.getRow(19).createCell(9).setCellValue("FAILED");
			mySheet.getRow(19).createCell(8).setCellValue("Save Report Canel button was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			//wb.close();	
			driver.quit();
		}
		else
		{
			mySheet.getRow(19).createCell(9).setCellValue("PASSED");
			mySheet.getRow(19).createCell(8).setCellValue("Save Report Cancel button was found and Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.xpath("//html/body/div[6]/div[3]/div/button[2]")).click();
			Thread.sleep(2000);
		}
		
		if(driver.findElements(By.id("topmenuitem_4")).size()>0) {
			
			driver.findElement(By.id("topmenuitem_4")).click();
			Thread.sleep(7000);}
			 
		if(driver.findElements(By.linkText("Report Dashboard")).size()>0) {
					
			driver.findElement(By.linkText("Report Dashboard")).click();
			Thread.sleep(8000);}	 
			 
							
    //wb.close();	
	driver.quit();
}	
	
	
	class CustomPrintStream extends PrintStream {  
	    public CustomPrintStream() {  
	        super(new ByteArrayOutputStream());  
	    }  
	  
	    public void println(String msg) {  
	        JOptionPane.showMessageDialog(null, msg);  
	    }  
	}


	public static void thrower(String message) throws Exception {
	      throw new RuntimeException(message);
	   }
	
	
	
	
	@AfterMethod
public void screenShot(ITestResult result) throws FileNotFoundException{
	PrintStream o = new PrintStream(new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Log Files\\Program Log File.txt"));
	 if(ITestResult.FAILURE==result.getStatus()){
		 try{
		
		 TakesScreenshot screenshot=(TakesScreenshot)driver;
		 File src=screenshot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Screenshots\\"+ result.getName()+ timestamp()+".png"));
		 System.setOut(o);
		 System.out.println("Successfully captured a screenshot");
		 }
		 
		 catch (Exception e){
		 System.setOut(o);
		 System.out.println("Exception while taking screenshot "+e.getMessage());
		 } 
		 
		}
//driver.quit();
	}


private static String timestamp() {
	// TODO Auto-generated method stub
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

public static PrintStream getOriginalsystemout() {
	return getOriginalsystemout();
}

public static TC1441_AdvancedSrch_Criteria getSystemOutToLogger() {
	return getSystemOutToLogger();
}

public static void setSystemOutToLogger(TC1441_AdvancedSrch_Criteria systemOutToLogger) {
	TC1441_AdvancedSrch_Criteria.setSystemOutToLogger(systemOutToLogger);
}


}
