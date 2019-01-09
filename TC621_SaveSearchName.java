package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
//import org.testng.annotations.Test;

public class TC621_SaveSearchName {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/
	//@Test(priority=1)
	public static void main(String[] args) throws IOException, InterruptedException { 
	//public  void quoteFromAgreement() throws Throwable {
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC621");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		int agreementId;
		String saveName;
	
		
		
			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementId = (int) sheet1.getRow(1).getCell(5).getNumericCellValue();
			saveName = sheet1.getRow(1).getCell(6).getStringCellValue();
			
			
			
			driver.get(logoutUrl);
			Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(2000);
		
			//find the email text box and send the email id
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
						driver.findElement(By.id("email")).sendKeys(testUsername);
						Thread.sleep(2000);
					}

			//find the password text box and send the password id
			Boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
			
			if(! actualResult1)
		          
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
						driver.findElement(By.id("password-text")).sendKeys(testPassword);
						Thread.sleep(2000);
					}
			
			//If statement - will check if element is Displayed before clicking on login button.
			Boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
			
			if(! actualResult2)
		         
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
						sheet1.getRow(6).createCell(8).setCellValue("login button was found and clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("Login")).click();
						Thread.sleep(15000);
					}
				
			//find the dash board tab and click
			Boolean actualResult3 =  driver.findElements(By.id("dashboard")).size() >0;
			//Assert.assertTrue(actualResult);
			if(! actualResult3)
			{
				sheet1.getRow(7).createCell(9).setCellValue("FAILED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was not displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
				
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
			Boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
			
			if( ! installedBase)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
				sheet1.getRow(8).createCell(8).setCellValue("Installed Base Tab menu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();

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
			Boolean agreementTab =  driver.findElements(By.id("submenulink_129")).size() >0;
					
			if( ! agreementTab)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();

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
			
			//Find the Advance search link and click that link
			Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size()>0;
			
			if ( ! advSrch)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("'Advance Serach' was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("advSrch_grid_agreement")).click();
				Thread.sleep(2000);
				}
			
			driver.findElement(By.id("drill_grid_agreement")).clear();
			driver.findElement(By.id("drill_grid_agreement")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("drill_grid_agreement")).sendKeys("ID");
			Thread.sleep(1000);
			
			//Find the ID filter button link and click that link
			Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
			Thread.sleep(2000);
			
			if ( ! idButton)
			{
				
				sheet1.getRow(11).createCell(9).setCellValue("FAILED");
				sheet1.getRow(11).createCell(8).setCellValue("'ID' Column Link was NOT Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(11).createCell(9).setCellValue("PASSED");
				sheet1.getRow(11).createCell(8).setCellValue("'ID' Column Link was Displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText("ID")).click();
				Thread.sleep(2000);
				}
			
			//Find the ID search filter box and click that in that box
			Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
			Thread.sleep(1000);
			
			if ( ! idSrch)
			{
				sheet1.getRow(12).createCell(9).setCellValue("FAILED");
				sheet1.getRow(12).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(12).createCell(9).setCellValue("PASSED");
				sheet1.getRow(12).createCell(8).setCellValue("'Agreement ID' was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
				Thread.sleep(2000);
				}
			
			driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
			Thread.sleep(4000);
			
			//Locate the agreement id in the grid and click the check box
			Boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementId))).size() >0;
			
			if ( ! idSrchResult)
			{
			
				sheet1.getRow(13).createCell(9).setCellValue("FAILED");
				sheet1.getRow(13).createCell(8).setCellValue("'Agreement ID' was NOT Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
				
			}
			else
			{
				sheet1.getRow(13).createCell(9).setCellValue("PASSED");
				sheet1.getRow(13).createCell(8).setCellValue("'Agreement ID' was Found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.linkText(String.valueOf(agreementId))).click();
				Thread.sleep(2000);
				}
			
			
			//Click on the Save search button
			 Boolean saveSrch = driver.findElements(By.id("savegrid_agreement")).size() >0;
				
				if ( ! saveSrch)
				{
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Save' Button was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Save' Button was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("savegrid_agreement")).click();
					Thread.sleep(2000);
					}
				
				//Click on the Save search button and identify the save search name box
				 Boolean saveSrch1 = driver.findElements(By.id("save_name_grid_agreement")).size() >0;
					
					if ( ! saveSrch1)
					{
						sheet1.getRow(15).createCell(9).setCellValue("FAILED");
						sheet1.getRow(15).createCell(8).setCellValue("'Save' Button was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(15).createCell(9).setCellValue("PASSED");
						sheet1.getRow(15).createCell(8).setCellValue("'Save' Button was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("save_name_grid_agreement")).click();
						Thread.sleep(2000);
						}
					
			//Click on the Save search name box and enter a search name
			 Boolean saveSrch2 = driver.findElements(By.id("save_name_grid_agreement")).size() >0;
						
					if ( ! saveSrch2)
					{
						sheet1.getRow(16).createCell(9).setCellValue("FAILED");
						sheet1.getRow(16).createCell(8).setCellValue("Search was NOT given a name");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(16).createCell(9).setCellValue("PASSED");
						sheet1.getRow(16).createCell(8).setCellValue("Search was given a name");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("save_name_grid_agreement")).sendKeys(String.valueOf(saveName));
						Thread.sleep(2000);
					}
	
			//Click on the Save search button for the search name box
			 Boolean saveSrch3 = driver.findElements(By.id("save_button_grid_agreement")).size() >0;
						
					if ( ! saveSrch3)
					{
						sheet1.getRow(17).createCell(9).setCellValue("FAILED");
						sheet1.getRow(17).createCell(8).setCellValue("Search was NOT saved");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(17).createCell(9).setCellValue("PASSED");
						sheet1.getRow(17).createCell(8).setCellValue("Search was saved Successfully");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("save_button_grid_agreement")).click();
						Thread.sleep(2000);
					}
					
					 //Find the clear search button and click
					if(driver.findElements(By.xpath("//html/body/div[13]/div[2]/div/ul/li[2]/div[6]/div/div/div[1]/ul/li[1]/a")).size()>0) {
							 
					 driver.findElement(By.xpath("//html/body/div[13]/div[2]/div/ul/li[2]/div[6]/div/div/div[1]/ul/li[1]/a")).click();
					 Thread.sleep(3000);}
					
			//Click on the View Saved searches link to view the saved search
			 Boolean saveSrchView = driver.findElements(By.id("my_search_grid_agreement")).size() >0;
								
					if ( ! saveSrchView)
					{
						sheet1.getRow(18).createCell(9).setCellValue("FAILED");
						sheet1.getRow(18).createCell(8).setCellValue("View Saved Searches was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(18).createCell(9).setCellValue("PASSED");
						sheet1.getRow(18).createCell(8).setCellValue("View Saved Searches was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("my_search_grid_agreement")).click();
						Thread.sleep(2000);
					}			
					
			//Click on the View Saved searches link to view the saved search
			 Boolean saveSrchView1 = driver.findElements(By.id("auto_completegrid_agreement")).size() >0;
								
					if ( ! saveSrchView1)
					{
						sheet1.getRow(19).createCell(9).setCellValue("FAILED");
						sheet1.getRow(19).createCell(8).setCellValue("Saved Search grid was NOT Present");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(19).createCell(9).setCellValue("PASSED");
						sheet1.getRow(19).createCell(8).setCellValue("Saved Search grid was Present");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//driver.findElement(By.id("auto_completegrid_agreement")).click();
						Thread.sleep(2000);
					}
					
					//Click on the View Saved searches link to view the saved search
					 Boolean saveSrchView2 = driver.findElements(By.linkText(String.valueOf(saveName))).size() >0;
										
							if ( ! saveSrchView2)
							{
								sheet1.getRow(20).createCell(9).setCellValue("FAILED");
								sheet1.getRow(20).createCell(8).setCellValue("Saved Search was NOT Found");
								FileOutputStream fout=new FileOutputStream(src);
								wb.write(fout);
								wb.close();	
								driver.quit();
							}
							else
							{
								sheet1.getRow(20).createCell(9).setCellValue("PASSED");
								sheet1.getRow(20).createCell(8).setCellValue("Saved Search was Found");
								FileOutputStream fout=new FileOutputStream(src);
								wb.write(fout);
								driver.findElement(By.linkText(String.valueOf(saveName))).click();
								Thread.sleep(2000);
							}
					//Click on the View Saved searches link to view the saved search
					 Boolean runSaveSrch = driver.findElements(By.id("rungrid_agreement")).size() >0;
										
							if ( ! runSaveSrch)
							{
								sheet1.getRow(21).createCell(9).setCellValue("FAILED");
								sheet1.getRow(21).createCell(8).setCellValue("Saved Search was NOT Initiated");
								FileOutputStream fout=new FileOutputStream(src);
								wb.write(fout);
								wb.close();	
								driver.quit();
							}
							else
							{
								sheet1.getRow(21).createCell(9).setCellValue("PASSED");
								sheet1.getRow(21).createCell(8).setCellValue("Saved Search was Initiated");
								FileOutputStream fout=new FileOutputStream(src);
								wb.write(fout);
								driver.findElement(By.id("rungrid_agreement")).click();
								Thread.sleep(2000);
							}	
						
	
				 //Find the clear search button and click
				if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
						 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);}
				
			
				//Click the Agreement ID link filter
				Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				
				if ( ! refreshButton)
				{
					
					sheet1.getRow(22).createCell(9).setCellValue("FAILED");
					sheet1.getRow(22).createCell(8).setCellValue("Grid was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(22).createCell(9).setCellValue("PASSED");
					sheet1.getRow(22).createCell(8).setCellValue("Grid was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(2000);
					}
			
	
		
	    wb.close();	
		//driver.quit();
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
