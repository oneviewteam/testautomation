package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

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

public class TC131_QuoteValidationLogin {
	
	public Select selenium;
	public static WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/
@Test(priority=1)
    public static void main(String[] args) throws IOException, InterruptedException { 
    

		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
	
		//FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\Screenshots"+System.currentTimeMillis()+".jpg"));  
		
		FileInputStream fis=new FileInputStream(src);
		
		//TC111_SELogin_Agreement.captureScreenShot(driver);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC131");
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
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(testUsername);
			Thread.sleep(2000);
			
			Boolean actualResult = driver.findElements(By.id("email")).size()>0; 
			
			if(! actualResult)
		          //login.click();
		          //Main Event is logged If Passed
		          {
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Username was NOT Input");
						//File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);						
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
					}

			//Actions actions = new Actions(driver);
			driver.findElement(By.id("password-text")).sendKeys(testPassword);
						
			Boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
			if(! actualResult1)
		          //login.click();
		          //Main Event is logged If Passed
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
					}
			
			
			
			//If statement - will check if element is Displayed before clicking on login button.
			Boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
			Thread.sleep(5000);
			if(! actualResult2)
		          //login.click();
		          //Main Event is logged If Passed
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
						sheet1.getRow(6).createCell(8).setCellValue("login button was found and Clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("Login")).click();
						Thread.sleep(15000);
						
					}
			
			
			
			//Identify the the Dash board is present
			Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
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
			
	
	    wb.close();	
		driver.quit();
}
	
	


	@AfterMethod
		public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
			if (testResult.getStatus() == ITestResult.FAILURE) {
				System.out.println(testResult.getStatus());
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\" + testResult.getName() + "-" 
						+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
		   }        
		}

	

}

