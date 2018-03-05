package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TC311_GCSiteLogin {
	
WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/
	@Test(priority=1)
	public  void quoteFromAgreement() throws Throwable {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC311");
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
			driver.get(loginUrl);
			driver.findElement(By.id("email")).sendKeys(testUsername);
			Thread.sleep(3000);
			
			Boolean actualResult = driver.findElements(By.id("email")).size()>0; 
			
			if(! actualResult)
		          //login.click();
		          //Main Event is logged If Passed
		          {
				
				
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Username was NOT Input");
												
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
			Thread.sleep(4000);
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
						
					}
			
			driver.findElement(By.id("Login")).click();
			Thread.sleep(12000);
			
			Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
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
			
			
		
	    wb.close();	
		driver.quit();
	}	
	public void quoteFromAgreementWithParent() throws Throwable	{
		
	}


	//@AfterMethod
	public void tearDown(ITestResult result)
	
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			//Utility.captureScreenshot(driver, result.getName());
		}
		
		driver.quit();
	}


}
