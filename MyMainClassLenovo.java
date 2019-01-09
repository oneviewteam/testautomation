package lenovoAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.openqa.selenium.JavascriptExecutor;

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


public class MyMainClassLenovo {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;

		
	//@Test(priority=0)
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException { 
	
	//@SuppressWarnings("resource")
	//@Test(priority=1)
	//public  void quoteFromAgreement() throws Throwable {
		
		
		
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_automation\\mmi_Lenovo_ auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		
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
		/*String Asset_Asset_Id;
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
		String Hardware_Reseller_Companies_Number;*/

		
		
		
		
		baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
		logoutUrl =baseUrl + "/auth/logout"; 
		loginUrl =baseUrl + "/auth/login"; 
		testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
		testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
		
		/*Asset_Asset_Id = sheet1.getRow(3).getCell(10).getStringCellValue();
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
		Hardware_Reseller_Companies_Number = sheet1.getRow(22).getCell(10).getStringCellValue();*/
		
		
			
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
				/*new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Español");
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
				Thread.sleep(1000);*/
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
			
			
		    //wb.close();	
			driver.quit();
		}	
		


		//@AfterMethod
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
