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

public class TC522_ColumnSearchFilter {
	
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
	XSSFSheet sheet1=wb.getSheet("TC522");
	//XSSFSheet sheet2=wb.createSheet("results");
	
	
	String baseUrl ;
	String loginUrl; 
	String logoutUrl; 
	String testUsername;
	String testPassword ;
	String column1;
	String column2;
	String column3;
	String column4;
	String column5;
	String column6;
	String column7;
	String column8;
	String column9;
	String column10;
	String column11;
	String column12;
	String column13;
	String column14;
	String column15;
	String column16;
	String column17;
	String column18;
	String column19;
	String column20;
	String column21;
	String column22;
	String column23;
	String column24;
	String column25;
	String column26;
	String column27;
	String column28;
	String column29;
	String column30;
	String column31;
	String column32;
	String column33;
	
	
	
//String gridTitle = "agreement";
//numRows = sheet1.getLastRowNum();
		
					baseUrl = sheet1.getRow(1).getCell(0).getStringCellValue();
					logoutUrl = baseUrl + "/auth/logout"; 
					loginUrl = baseUrl + "/auth/login"; 
					testUsername = sheet1.getRow(1).getCell(1).getStringCellValue();
					testPassword = sheet1.getRow(1).getCell(2).getStringCellValue();
					
					column1 = sheet1.getRow(3).getCell(10).getStringCellValue();
				    column2 = sheet1.getRow(4).getCell(10).getStringCellValue();
				    column3 = sheet1.getRow(5).getCell(10).getStringCellValue();
					column4 = sheet1.getRow(6).getCell(10).getStringCellValue();
					column5 = sheet1.getRow(7).getCell(10).getStringCellValue();
					column6 = sheet1.getRow(8).getCell(10).getStringCellValue();
					column7 = sheet1.getRow(9).getCell(10).getStringCellValue();
					column8 = sheet1.getRow(10).getCell(10).getStringCellValue();
					column9 = sheet1.getRow(11).getCell(10).getStringCellValue();
					column10 = sheet1.getRow(12).getCell(10).getStringCellValue();
					column11 = sheet1.getRow(13).getCell(10).getStringCellValue();
					column12 = sheet1.getRow(14).getCell(10).getStringCellValue();
					column13 = sheet1.getRow(15).getCell(10).getStringCellValue();
					column14 = sheet1.getRow(16).getCell(10).getStringCellValue();
					column15 = sheet1.getRow(17).getCell(10).getStringCellValue();
					column16 = sheet1.getRow(18).getCell(10).getStringCellValue();
					column17 = sheet1.getRow(19).getCell(10).getStringCellValue();
					column18 = sheet1.getRow(20).getCell(10).getStringCellValue();
					column19 = sheet1.getRow(21).getCell(10).getStringCellValue();
					column20 = sheet1.getRow(22).getCell(10).getStringCellValue();
					column21 = sheet1.getRow(23).getCell(10).getStringCellValue();
					column22 = sheet1.getRow(24).getCell(10).getStringCellValue();
					column23 = sheet1.getRow(25).getCell(10).getStringCellValue();
					column24 = sheet1.getRow(26).getCell(10).getStringCellValue();
					column25 = sheet1.getRow(27).getCell(10).getStringCellValue();
					column26 = sheet1.getRow(28).getCell(10).getStringCellValue();
					column27 = sheet1.getRow(29).getCell(10).getStringCellValue();
					column28 = sheet1.getRow(30).getCell(10).getStringCellValue();
					column29 = sheet1.getRow(31).getCell(10).getStringCellValue();
					column30 = sheet1.getRow(32).getCell(10).getStringCellValue();
					column31 = sheet1.getRow(33).getCell(10).getStringCellValue();
					column32 = sheet1.getRow(34).getCell(10).getStringCellValue();
					column33 = sheet1.getRow(35).getCell(10).getStringCellValue();
					
					
					
					
					
					
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
					
					 //Find the Columns link
					 Boolean columnSrch = driver.findElements(By.id("columns_grid_agreement")).size() >0;
					
					if ( ! columnSrch)
					{
						sheet1.getRow(10).createCell(9).setCellValue("FAILED");
						sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was NOT Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(10).createCell(9).setCellValue("PASSED");
						sheet1.getRow(10).createCell(8).setCellValue("'Columns' Link was Displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//driver.findElement(By.id("advSrch_grid_agreement")).click();
						//Thread.sleep(4000);
						}
			
			//Find the Columns link and click the link
			 Boolean columnSrch1 = driver.findElements(By.id("columns_grid_agreement")).size() >0;
				
				if ( ! columnSrch1)
				{
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Columns' Link was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("columns_grid_agreement")).click();
					Thread.sleep(3000);
					}
			
			//Find the Remove All link and click
			 Boolean columnSrch2 = driver.findElements(By.cssSelector(".remove-all")).size() >0;
				
				if ( ! columnSrch2)
				{
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'Remove All' Link was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".remove-all")).click();
					Thread.sleep(3000);
					}
	
		//Find the Column search box and click
		 Boolean ColumnFilterSrch = driver.findElements(By.cssSelector(".search")).size() >0;
					
			if ( ! ColumnFilterSrch)
			{
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("'Filter box' for columns was NOT selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
			}
			else
			{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("'Filter box' for columns is selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".search")).clear();
						driver.findElement(By.cssSelector(".search")).click();
						Thread.sleep(2000);
						driver.findElement(By.cssSelector(".search")).clear();
						Thread.sleep(2000);
						}
			
						
						driver.findElement(By.cssSelector(".search")).click();
					    driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column1));
						Thread.sleep(2000);
			
			//Click in search box and send the term "ID"
			Boolean ColumnIDSrch1 = driver.findElements(By.id("ID_column_select")).size() >0;
						
				if ( ! ColumnIDSrch1)
				{
						sheet1.getRow(14).createCell(9).setCellValue("FAILED");
						sheet1.getRow(14).createCell(8).setCellValue("'ID' term was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
				}
				else
				{
						sheet1.getRow(14).createCell(9).setCellValue("PASSED");
						sheet1.getRow(14).createCell(8).setCellValue("'ID' term was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ID_column_select")).click();
						Thread.sleep(2000);
						driver.findElement(By.cssSelector(".search")).clear();
						Thread.sleep(2000);
						}
						
						
						driver.findElement(By.cssSelector(".search")).click();
					    driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column2));
						Thread.sleep(2000);
								
			//Click in search box and send the term "CustomerSiteID"
				Boolean ColumnIDSrch2 = driver.findElements(By.id("CustomerSiteID_column_select")).size() >0;
										
					if ( ! ColumnIDSrch2)
					{
						sheet1.getRow(15).createCell(9).setCellValue("FAILED");
						sheet1.getRow(15).createCell(8).setCellValue("'CustomerSiteID' term was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(15).createCell(9).setCellValue("PASSED");
						sheet1.getRow(15).createCell(8).setCellValue("'CustomerSiteID' term was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("CustomerSiteID_column_select")).click();
						Thread.sleep(2000);
						driver.findElement(By.cssSelector(".search")).clear();
						Thread.sleep(2000);
						}
					
						
						driver.findElement(By.cssSelector(".search")).click();
						driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column3));
						Thread.sleep(2000);
						
			//Click in search box and send the term "ParentAgreementNumber"
					
				Boolean ColumnIDSrch3 = driver.findElements(By.id("ParentAgreementNumber_column_select")).size()>0;
											
					if ( ! ColumnIDSrch3)
					{
						sheet1.getRow(16).createCell(9).setCellValue("FAILED");
						sheet1.getRow(16).createCell(8).setCellValue("'ParentAgreementNumber' term was NOT Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						driver.quit();
					}
					else
					{
						sheet1.getRow(16).createCell(9).setCellValue("PASSED");
						sheet1.getRow(16).createCell(8).setCellValue("'ParentAgreementNumber' term was Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ParentAgreementNumber_column_select")).click();
						Thread.sleep(2000);
						driver.findElement(By.cssSelector(".search")).clear();
						Thread.sleep(2000);
						}
					
						
						driver.findElement(By.cssSelector(".search")).click();
						driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column4));
						Thread.sleep(2000);
			
					
			//Click in search box and send the term "Agreement_Type"
			
			Boolean ColumnIDSrch4 = driver.findElements(By.id("Agreement_Type_column_select")).size()>0;
										
				if ( ! ColumnIDSrch4)
				{
					sheet1.getRow(17).createCell(9).setCellValue("FAILED");
					sheet1.getRow(17).createCell(8).setCellValue("'Agreement_Type' term was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(17).createCell(9).setCellValue("PASSED");
					sheet1.getRow(17).createCell(8).setCellValue("'Agreement_Type' term was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("Agreement_Type_column_select")).click();
					Thread.sleep(2000);
					driver.findElement(By.cssSelector(".search")).clear();
					Thread.sleep(2000);
					}
				
					
					driver.findElement(By.cssSelector(".search")).click();
					driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column5));
					Thread.sleep(2000);
				
		//Click in search box and send the term "StartDate"
		
		Boolean ColumnIDSrch5 = driver.findElements(By.id("StartDate_column_select")).size()>0;
									
			if ( ! ColumnIDSrch5)
			{
				sheet1.getRow(18).createCell(9).setCellValue("FAILED");
				sheet1.getRow(18).createCell(8).setCellValue("'StartDate' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(18).createCell(9).setCellValue("PASSED");
				sheet1.getRow(18).createCell(8).setCellValue("'StartDate' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("StartDate_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column6));
				Thread.sleep(2000);
		
		//Click in search box and send the term "EndDate"
		
		Boolean ColumnIDSrch6 = driver.findElements(By.id("EndDate_column_select")).size()>0;
									
			if ( ! ColumnIDSrch6)
			{
				sheet1.getRow(19).createCell(9).setCellValue("FAILED");
				sheet1.getRow(19).createCell(8).setCellValue("'EndDate' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(19).createCell(9).setCellValue("PASSED");
				sheet1.getRow(19).createCell(8).setCellValue("'EndDate' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("EndDate_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column7));
				Thread.sleep(2000);
			
		//Click in search box and send the term "AgreementTypeID"
		
		Boolean ColumnIDSrch7 = driver.findElements(By.id("AgreementTypeID_column_select")).size()>0;
									
			if ( ! ColumnIDSrch7)
			{
				sheet1.getRow(20).createCell(9).setCellValue("FAILED");
				sheet1.getRow(20).createCell(8).setCellValue("'AgreementTypeID' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(20).createCell(9).setCellValue("PASSED");
				sheet1.getRow(20).createCell(8).setCellValue("'AgreementTypeID' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("AgreementTypeID_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column8));
				Thread.sleep(2000);
		
		//Click in search box and send the term "AgreementNumber"
		
		Boolean ColumnIDSrch8 = driver.findElements(By.id("AgreementNumber_column_select")).size()>0;
									
			if ( ! ColumnIDSrch8)
			{
				sheet1.getRow(21).createCell(9).setCellValue("FAILED");
				sheet1.getRow(21).createCell(8).setCellValue("'AgreementNumber' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(21).createCell(9).setCellValue("PASSED");
				sheet1.getRow(21).createCell(8).setCellValue("'AgreementNumber' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("AgreementNumber_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column9));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Days_to_Expiration"
		
		Boolean ColumnIDSrch9 = driver.findElements(By.id("Days_to_Expiration_column_select")).size()>0;
									
			if ( ! ColumnIDSrch9)
			{
				sheet1.getRow(22).createCell(9).setCellValue("FAILED");
				sheet1.getRow(22).createCell(8).setCellValue("'Days_to_Expiration' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(22).createCell(9).setCellValue("PASSED");
				sheet1.getRow(22).createCell(8).setCellValue("'Days_to_Expiration' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Days_to_Expiration_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column10));
				Thread.sleep(2000);
		//Click in search box and send the term "CF_License_Value"
		
		Boolean ColumnIDSrch10 = driver.findElements(By.id("CF_License_Value_column_select")).size()>0;
									
			if ( ! ColumnIDSrch10)
			{
				sheet1.getRow(23).createCell(9).setCellValue("FAILED");
				sheet1.getRow(23).createCell(8).setCellValue("'CF_License_Value' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(23).createCell(9).setCellValue("PASSED");
				sheet1.getRow(23).createCell(8).setCellValue("'CF_License_Value' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("CF_License_Value_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column11));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Estimated_CF_Agreement_Value"
		
		Boolean ColumnIDSrch11 = driver.findElements(By.id("Estimated_CF_Agreement_Value_column_select")).size()>0;
									
			if ( ! ColumnIDSrch11)
			{
				sheet1.getRow(24).createCell(9).setCellValue("FAILED");
				sheet1.getRow(24).createCell(8).setCellValue("'Estimated_CF_Agreement_Value' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(24).createCell(9).setCellValue("PASSED");
				sheet1.getRow(24).createCell(8).setCellValue("'Estimated_CF_Agreement_Value' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Estimated_CF_Agreement_Value_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column12));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Annualized_CF_Agreement_Value"
		
		Boolean ColumnIDSrch12 = driver.findElements(By.id("Annualized_CF_Agreement_Value_column_select")).size()>0;
									
			if ( ! ColumnIDSrch12)
			{
				sheet1.getRow(25).createCell(9).setCellValue("FAILED");
				sheet1.getRow(25).createCell(8).setCellValue("'Annualized_CF_Agreement_Value' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(25).createCell(9).setCellValue("PASSED");
				sheet1.getRow(25).createCell(8).setCellValue("'Annualized_CF_Agreement_Value' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Annualized_CF_Agreement_Value_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column13));
				Thread.sleep(2000);
		//Click in search box and send the term "CFProgramLevelID"
		
		Boolean ColumnIDSrch13 = driver.findElements(By.id("CFProgramLevelID_column_select")).size()>0;
									
			if ( ! ColumnIDSrch13)
			{
				sheet1.getRow(26).createCell(9).setCellValue("FAILED");
				sheet1.getRow(26).createCell(8).setCellValue("'CFProgramLevelID' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(26).createCell(9).setCellValue("PASSED");
				sheet1.getRow(26).createCell(8).setCellValue("'CFProgramLevelID' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("CFProgramLevelID_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column14));
				Thread.sleep(2000);
			
		//Click in search box and send the term "TAMFlag"
		
		Boolean ColumnIDSrch14 = driver.findElements(By.id("TAMFlag_column_select")).size()>0;
									
			if ( ! ColumnIDSrch14)
			{
				sheet1.getRow(27).createCell(9).setCellValue("FAILED");
				sheet1.getRow(27).createCell(8).setCellValue("'CFProgramLevelID' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(27).createCell(9).setCellValue("PASSED");
				sheet1.getRow(27).createCell(8).setCellValue("'TAMFlag' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("TAMFlag_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column15));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Brand"
		
		Boolean ColumnIDSrch15 = driver.findElements(By.id("Brand_column_select")).size()>0;
									
			if ( ! ColumnIDSrch15)
			{
				sheet1.getRow(28).createCell(9).setCellValue("FAILED");
				sheet1.getRow(28).createCell(8).setCellValue("'Brand' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(28).createCell(9).setCellValue("PASSED");
				sheet1.getRow(28).createCell(8).setCellValue("'Brand' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Brand_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column16));
				Thread.sleep(2000);
			
		//Click in search box and send the term "ActiveFlag"
		
		Boolean ColumnIDSrch16 = driver.findElements(By.id("ActiveFlag_column_select")).size()>0;
									
			if ( ! ColumnIDSrch16)
			{
				sheet1.getRow(29).createCell(9).setCellValue("FAILED");
				sheet1.getRow(29).createCell(8).setCellValue("'ActiveFlag' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(29).createCell(9).setCellValue("PASSED");
				sheet1.getRow(29).createCell(8).setCellValue("'ActiveFlag' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("ActiveFlag_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column17));
				Thread.sleep(2000);
		//Click in search box and send the term "DistributorID"
		
		Boolean ColumnIDSrch17 = driver.findElements(By.id("DistributorID_column_select")).size()>0;
									
			if ( ! ColumnIDSrch17)
			{
				sheet1.getRow(30).createCell(9).setCellValue("FAILED");
				sheet1.getRow(30).createCell(8).setCellValue("'DistributorID' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(30).createCell(9).setCellValue("PASSED");
				sheet1.getRow(30).createCell(8).setCellValue("'DistributorID' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("DistributorID_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column18));
				Thread.sleep(2000);
			//Click in search box and send the term "Disposition Code"
			
		Boolean ColumnIDSrch18 = driver.findElements(By.id("Disposition_Code_column_select")).size()>0;
									
			if ( ! ColumnIDSrch18)
			{
				sheet1.getRow(31).createCell(9).setCellValue("FAILED");
				sheet1.getRow(31).createCell(8).setCellValue("'Disposition Code' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(31).createCell(9).setCellValue("PASSED");
				sheet1.getRow(31).createCell(8).setCellValue("'Disposition Code' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Disposition_Code_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column19));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Disposition"
		
		Boolean ColumnIDSrch19 = driver.findElements(By.id("Disposition_column_select")).size()>0;
									
			if ( ! ColumnIDSrch19)
			{
				sheet1.getRow(32).createCell(9).setCellValue("FAILED");
				sheet1.getRow(32).createCell(8).setCellValue("'Disposition' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(32).createCell(9).setCellValue("PASSED");
				sheet1.getRow(32).createCell(8).setCellValue("'Disposition' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Disposition_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column20));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Category"
		
		Boolean ColumnIDSrch20 = driver.findElements(By.id("category_select")).size()>0;
									
			if ( ! ColumnIDSrch20)
			{
				sheet1.getRow(33).createCell(9).setCellValue("FAILED");
				sheet1.getRow(33).createCell(8).setCellValue("'Category' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(33).createCell(9).setCellValue("PASSED");
				sheet1.getRow(33).createCell(8).setCellValue("'Category' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("category_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column21));
				Thread.sleep(2000);
		//Click in search box and send the term "Disposition_status"
		
		Boolean ColumnIDSrch21 = driver.findElements(By.id("disposition_status_select")).size()>0;
									
			if ( ! ColumnIDSrch21)
			{
				sheet1.getRow(34).createCell(9).setCellValue("FAILED");
				sheet1.getRow(34).createCell(8).setCellValue("'Disposition_status' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(34).createCell(9).setCellValue("PASSED");
				sheet1.getRow(34).createCell(8).setCellValue("'Disposition_status' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("disposition_status_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column22));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Customer Type"
		
		Boolean ColumnIDSrch22 = driver.findElements(By.id("CustomerType_status_select")).size()>0;
									
			if ( ! ColumnIDSrch22)
			{
				sheet1.getRow(35).createCell(9).setCellValue("FAILED");
				sheet1.getRow(35).createCell(8).setCellValue("'CustomerType' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(35).createCell(9).setCellValue("PASSED");
				sheet1.getRow(35).createCell(8).setCellValue("'CustomerType' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("CustomerType_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column23));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Address"
		
		Boolean ColumnIDSrch23 = driver.findElements(By.id("Address_status_select")).size()>0;
									
			if ( ! ColumnIDSrch23)
			{
				sheet1.getRow(36).createCell(9).setCellValue("FAILED");
				sheet1.getRow(36).createCell(8).setCellValue("'Address' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(36).createCell(9).setCellValue("PASSED");
				sheet1.getRow(36).createCell(8).setCellValue("'Address' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Address_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column24));
				Thread.sleep(2000);
		//Click in search box and send the term "Address2"
		
		Boolean ColumnIDSrch24 = driver.findElements(By.id("Address2_status_select")).size()>0;
									
			if ( ! ColumnIDSrch24)
			{
				sheet1.getRow(37).createCell(9).setCellValue("FAILED");
				sheet1.getRow(37).createCell(8).setCellValue("'Address2' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(37).createCell(9).setCellValue("PASSED");
				sheet1.getRow(37).createCell(8).setCellValue("'Address2' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Address2_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column25));
				Thread.sleep(2000);
		//Click in search box and send the term "City"
		
		Boolean ColumnIDSrch25 = driver.findElements(By.id("City_status_select")).size()>0;
									
			if ( ! ColumnIDSrch25)
			{
				sheet1.getRow(38).createCell(9).setCellValue("FAILED");
				sheet1.getRow(38).createCell(8).setCellValue("'City' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(38).createCell(9).setCellValue("PASSED");
				sheet1.getRow(38).createCell(8).setCellValue("'City' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("City_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column26));
				Thread.sleep(2000);
			
		//Click in search box and send the term "StateProv"
		
		Boolean ColumnIDSrch26 = driver.findElements(By.id("StateProv_status_select")).size()>0;
									
			if ( ! ColumnIDSrch26)
			{
				sheet1.getRow(39).createCell(9).setCellValue("FAILED");
				sheet1.getRow(39).createCell(8).setCellValue("'StateProv' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(39).createCell(9).setCellValue("PASSED");
				sheet1.getRow(39).createCell(8).setCellValue("'StateProv' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("StateProv_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column27));
				Thread.sleep(2000);
		//Click in search box and send the term "PostalCode"
		
		Boolean ColumnIDSrch27 = driver.findElements(By.id("PostalCode_status_select")).size()>0;
									
			if ( ! ColumnIDSrch27)
			{
				sheet1.getRow(40).createCell(9).setCellValue("FAILED");
				sheet1.getRow(40).createCell(8).setCellValue("'PostalCode' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(40).createCell(9).setCellValue("PASSED");
				sheet1.getRow(40).createCell(8).setCellValue("'PostalCode' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("PostalCode_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column28));
				Thread.sleep(2000);
		//Click in search box and send the term "Country"
		
		Boolean ColumnIDSrch28 = driver.findElements(By.id("Country_status_select")).size()>0;
									
			if ( ! ColumnIDSrch28)
			{
				sheet1.getRow(41).createCell(9).setCellValue("FAILED");
				sheet1.getRow(41).createCell(8).setCellValue("'Country' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(41).createCell(9).setCellValue("PASSED");
				sheet1.getRow(41).createCell(8).setCellValue("'Country' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Country_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column29));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Region"
		
		Boolean ColumnIDSrch29 = driver.findElements(By.id("Region_status_select")).size()>0;
									
			if ( ! ColumnIDSrch29)
			{
				sheet1.getRow(42).createCell(9).setCellValue("FAILED");
				sheet1.getRow(42).createCell(8).setCellValue("'Region' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(42).createCell(9).setCellValue("PASSED");
				sheet1.getRow(42).createCell(8).setCellValue("'Region' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Region_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column30));
				Thread.sleep(2000);
			
		//Click in search box and send the term "CustomerSite Name"
		
		Boolean ColumnIDSrch30 = driver.findElements(By.id("CustomerSiteName_status_select")).size()>0;
									
			if ( ! ColumnIDSrch30)
			{
				sheet1.getRow(43).createCell(9).setCellValue("FAILED");
				sheet1.getRow(43).createCell(8).setCellValue("'CustomerSiteName' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(43).createCell(9).setCellValue("PASSED");
				sheet1.getRow(43).createCell(8).setCellValue("'CustomerSiteName' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("CustomerSiteName_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column31));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Program_Level"
		
		Boolean ColumnIDSrch31 = driver.findElements(By.id("Program_Level_status_select")).size()>0;
									
			if ( ! ColumnIDSrch31)
			{
				sheet1.getRow(44).createCell(9).setCellValue("FAILED");
				sheet1.getRow(44).createCell(8).setCellValue("'Program_Level' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(44).createCell(9).setCellValue("PASSED");
				sheet1.getRow(44).createCell(8).setCellValue("'Program_Level' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("Program_Level_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column32));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Distributor Name"
		
		Boolean ColumnIDSrch32 = driver.findElements(By.id("DistributorName_status_select")).size()>0;
									
			if ( ! ColumnIDSrch32)
			{
				sheet1.getRow(45).createCell(9).setCellValue("FAILED");
				sheet1.getRow(45).createCell(8).setCellValue("'Distributor Name' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(45).createCell(9).setCellValue("PASSED");
				sheet1.getRow(45).createCell(8).setCellValue("'Distributor Name' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("DistributorName_column_select")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".search")).clear();
				Thread.sleep(2000);
				}
			
				
				driver.findElement(By.cssSelector(".search")).click();
				driver.findElement(By.cssSelector(".search")).sendKeys(String.valueOf(column33));
				Thread.sleep(2000);
			
		//Click in search box and send the term "Account Name"

		
		Boolean ColumnIDSrch33 = driver.findElements(By.id("AccountName_status_select")).size()>0;
									
			if ( ! ColumnIDSrch33)
			{
				sheet1.getRow(46).createCell(9).setCellValue("FAILED");
				sheet1.getRow(46).createCell(8).setCellValue("'Account Name' term was NOT Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(46).createCell(9).setCellValue("PASSED");
				sheet1.getRow(46).createCell(8).setCellValue("'Account Name' term was Entered");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.id("AccountName_column_select")).click();
				Thread.sleep(3000);
			}
				

	//Find the Add All link and click
	 Boolean columnSrch3 = driver.findElements(By.cssSelector(".add-all")).size() >0;
		
			if ( ! columnSrch3)
			{
				sheet1.getRow(47).createCell(9).setCellValue("FAILED");
				sheet1.getRow(47).createCell(8).setCellValue("'Add All' Link was NOT Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
			}
			else
			{
				sheet1.getRow(47).createCell(9).setCellValue("PASSED");
				sheet1.getRow(47).createCell(8).setCellValue("'Add All' Link was Initiated");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				driver.findElement(By.cssSelector(".add-all")).click();
				Thread.sleep(3000);
				}
	
		//Click on the "X" to close the Column Filter
		
		Boolean closeButton = driver.findElements(By.xpath("//html/body/div[13]/div[3]/div/button[2]")).size() >0;
		
		if ( ! closeButton)
		{
			
			sheet1.getRow(48).createCell(9).setCellValue("FAILED");
			sheet1.getRow(48).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(48).createCell(9).setCellValue("PASSED");
			sheet1.getRow(48).createCell(8).setCellValue("Close Advanced Search was Initiated");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.xpath("//html/body/div[13]/div[3]/div/button[2]")).click();
			Thread.sleep(3000);
			}
	
		//Click the Agreement Grid Refresh link
		Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
		
		
		if ( ! refreshButton)
		{
			
			sheet1.getRow(49).createCell(9).setCellValue("FAILED");
			sheet1.getRow(49).createCell(8).setCellValue("Grid was NOT Refreshed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(49).createCell(9).setCellValue("PASSED");
			sheet1.getRow(49).createCell(8).setCellValue("Grid was Refreshed");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			driver.findElement(By.id("refresh_grid_agreement")).click();
			Thread.sleep(4000);
			}
	

		
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
