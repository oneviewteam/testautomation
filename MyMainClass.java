package maven1;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.Assert;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.*;

public class MyMainClass {
	
	//public Select selenium;
	//public static WebDriver driver;

	//@SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public static void main(String[] args)  { 
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		//testng.setTestClasses(new Class[] {TC001_QuoteCreation_Agreements.class});
		//testng.setTestClasses(new Class[] {TC002_QuoteCreation_CustomerSites.class});
				//testng.setTestClasses(new Class[] {TC003_QuoteCreation_GlobalCustomerSites.class});
						//testng.setTestClasses(new Class[] {TC004_AdvancedSearch_Filters_Operators.class});
		testng.setTestClasses(new Class[] {TC005_Columns.class});
								//testng.setTestClasses(new Class[] {TC006_SaveSearch.class});
										
		
		
		
		
		
		
		
		testng.addListener(tla);
		testng.run();
			
	
			/*//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "bin\\geckodriver.exe");
			driver=new FirefoxDriver();
			//driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\SEAutoTesting.xlsx");
			//File src=new File("SEAutoTesting.xlsx");
			
			FileInputStream fis=new FileInputStream(src);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			//get sheet at index
			//XSSFSheet sheet1=wb.getSheetAt(1);  
			
			// Get sheet by name
			XSSFSheet sheet1=wb.getSheet("TC111");
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
		}*/

	}
	}

