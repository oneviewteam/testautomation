package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC523_ColumnsGridSearch {
	
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;

	

//TC523
@Test(priority=1)
//public static void main(String[] args) throws IOException, InterruptedException { 
public  void TC523_ColumnsGridCount() throws Throwable {
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC523");
		//XSSFSheet sheet2=wb.getSheet("All_TC_Results");
		
		
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
		
		
			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			
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
				//driver.quit();
				
			}
			else
			{
				sheet1.getRow(7).createCell(9).setCellValue("PASSED");
				sheet1.getRow(7).createCell(8).setCellValue("Dashboard was found and displayed");
				FileOutputStream fout=new FileOutputStream(src);
				driver.findElement(By.id("dashboard")).click();
				Thread.sleep(5000);
				wb.write(fout);
			}
			
			//Click on the Installed Base Tab
			Boolean installedBase =  driver.findElements(By.id("topmenuitem_31")).size() >0;
			
			if( ! installedBase)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
				sheet1.getRow(8).createCell(8).setCellValue("Installed Base tab was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				//driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(8).createCell(9).setCellValue("PASSED");
				sheet1.getRow(8).createCell(8).setCellValue("Installed Base tab was found");
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
				//driver.quit();

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
				//driver.quit();
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
					//driver.quit();
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
						//driver.quit();
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
					
				//Find the Add All link and click
				 Boolean columnSrch3 = driver.findElements(By.cssSelector(".add-all")).size() >0;
						
					if ( ! columnSrch3)
						{
						sheet1.getRow(13).createCell(9).setCellValue("FAILED");
						sheet1.getRow(13).createCell(8).setCellValue("'Add All' Link was NOT Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						wb.close();	
						//driver.quit();
						}
					else
						{
						sheet1.getRow(13).createCell(9).setCellValue("PASSED");
						sheet1.getRow(13).createCell(8).setCellValue("'Add All' Link was Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.cssSelector(".add-all")).click();
						Thread.sleep(3000);
						}
						
												
				//Click the Agreement ID link filter
				Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;
				
				
				if ( ! closeButton)
				{
					
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("Close Column Search was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Close Column Search was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
					Thread.sleep(3000);
					}
		
				
				//Click the Agreement ID link filter
				Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				
				if ( ! refreshButton)
				{
					
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("Grid was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("Grid was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(4000);
					}
				
				//Find the ID column on the Agreement Grid
				Boolean IDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.id")).size() >0;
				
				
				if ( ! IDColumn)
				{
					
					sheet1.getRow(16).createCell(9).setCellValue("FAILED");
					sheet1.getRow(16).createCell(8).setCellValue("ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(16).createCell(9).setCellValue("PASSED");
					sheet1.getRow(16).createCell(8).setCellValue("ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.id")).click();
					Thread.sleep(2000);
					}
				
				//Find the Customer Site ID column on the Agreement Grid
				Boolean CustomerSiteIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteID")).size() >0;
				
				
				if ( ! CustomerSiteIDColumn)
				{
					
					sheet1.getRow(17).createCell(9).setCellValue("FAILED");
					sheet1.getRow(17).createCell(8).setCellValue("CustomerSiteID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(17).createCell(9).setCellValue("PASSED");
					sheet1.getRow(17).createCell(8).setCellValue("CustomerSiteID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteID")).click();
					Thread.sleep(2000);
					}
				
				//Find the Parent Agreement Number column on the Agreement Grid
				Boolean ParentAgreementNumberColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.ParentAgreementNumber")).size() >0;
				
				
				if ( ! ParentAgreementNumberColumn)
				{
					
					sheet1.getRow(18).createCell(9).setCellValue("FAILED");
					sheet1.getRow(18).createCell(8).setCellValue("Parent Agreement Number Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(18).createCell(9).setCellValue("PASSED");
					sheet1.getRow(18).createCell(8).setCellValue("Parent Agreement Number Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.ParentAgreementNumber")).click();
					Thread.sleep(2000);
					}
				
				//Find the Agreement Type column on the Agreement Grid
				Boolean AgreementTypeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.agreement_type__Description")).size() >0;
				
				
				if ( ! AgreementTypeColumn)
				{
					
					sheet1.getRow(19).createCell(9).setCellValue("FAILED");
					sheet1.getRow(19).createCell(8).setCellValue("Agreement Type Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(19).createCell(9).setCellValue("PASSED");
					sheet1.getRow(19).createCell(8).setCellValue("Agreement Type Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.agreement_type__Description")).click();
					Thread.sleep(2000);
					}
				
				//Find the Start Date ID column on the Agreement Grid
				Boolean StartDateColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.StartDate")).size() >0;
				
				
				if ( ! StartDateColumn)
				{
					
					sheet1.getRow(20).createCell(9).setCellValue("FAILED");
					sheet1.getRow(20).createCell(8).setCellValue("Start Date Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(20).createCell(9).setCellValue("PASSED");
					sheet1.getRow(20).createCell(8).setCellValue("Start Date Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.StartDate")).click();
					Thread.sleep(2000);
					}
				
				//Find the End Date ID column on the Agreement Grid
				Boolean EndDateColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.EndDate")).size() >0;
				
				
				if ( ! EndDateColumn)
				{
					
					sheet1.getRow(21).createCell(9).setCellValue("FAILED");
					sheet1.getRow(21).createCell(8).setCellValue("End Date Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(21).createCell(9).setCellValue("PASSED");
					sheet1.getRow(21).createCell(8).setCellValue("End Date Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.EndDate")).click();
					Thread.sleep(2000);
					}
				
				//Find the Agreement Type ID column on the Agreement Grid
				Boolean AgreementTypeIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.AgreementTypeID")).size() >0;
				
				
				if ( ! AgreementTypeIDColumn)
				{
					
					sheet1.getRow(22).createCell(9).setCellValue("FAILED");
					sheet1.getRow(22).createCell(8).setCellValue("Agreement Type ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(22).createCell(9).setCellValue("PASSED");
					sheet1.getRow(22).createCell(8).setCellValue("Agreement Type ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AgreementTypeID")).click();
					Thread.sleep(2000);
					}
				
				//Find the Agreement Number ID column on the Agreement Grid
				Boolean AgreementNumberColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.AgreementNumber")).size() >0;
				
				
				if ( ! AgreementNumberColumn)
				{
					
					sheet1.getRow(23).createCell(9).setCellValue("FAILED");
					sheet1.getRow(23).createCell(8).setCellValue("Agreement Number Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(23).createCell(9).setCellValue("PASSED");
					sheet1.getRow(23).createCell(8).setCellValue("Agreement Number Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AgreementNumber")).click();
					Thread.sleep(2000);
					}
				
				//Find the Days To Expire column on the Agreement Grid
				Boolean DaysToExpireColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Days_to_Expiration")).size() >0;
				
				
				if ( ! DaysToExpireColumn)
				{
					
					sheet1.getRow(24).createCell(9).setCellValue("FAILED");
					sheet1.getRow(24).createCell(8).setCellValue("Days To Expire Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(24).createCell(9).setCellValue("PASSED");
					sheet1.getRow(24).createCell(8).setCellValue("Days To Expire Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Days_to_Expiration")).click();
					Thread.sleep(2000);
					}
				
				//Find the CF License Value Column on the Agreement Grid
				Boolean CFLicenseValueColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CF_License_Value")).size() >0;
				
				
				if ( ! CFLicenseValueColumn)
				{
					
					sheet1.getRow(25).createCell(9).setCellValue("FAILED");
					sheet1.getRow(25).createCell(8).setCellValue("CF License Value Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(25).createCell(9).setCellValue("PASSED");
					sheet1.getRow(25).createCell(8).setCellValue("CF License Value Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CF_License_Value")).click();
					Thread.sleep(2000);
					}
				
				//Find the Estimated CF Agreement Value Column on the Agreement Grid
				Boolean EstimatedCFValueColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Estimated_CF_Agreement_Value")).size() >0;
				
				
				if ( ! EstimatedCFValueColumn)
				{
					
					sheet1.getRow(26).createCell(9).setCellValue("FAILED");
					sheet1.getRow(26).createCell(8).setCellValue("Estimated CF Agreement Value Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(26).createCell(9).setCellValue("PASSED");
					sheet1.getRow(26).createCell(8).setCellValue("Estimated CF Agreement Value Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Estimated_CF_Agreement_Value")).click();
					Thread.sleep(2000);
					}
				
				//Find the Annualized CF Agreement Value Column on the Agreement Grid
				Boolean AnnualizedCFValueColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Annualized_CF_Agreement_Value")).size() >0;
				
				
				if ( ! AnnualizedCFValueColumn)
				{
					
					sheet1.getRow(27).createCell(9).setCellValue("FAILED");
					sheet1.getRow(27).createCell(8).setCellValue("Annualized CF Agreement Value Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(27).createCell(9).setCellValue("PASSED");
					sheet1.getRow(27).createCell(8).setCellValue("Annualized CF Agreement Value Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Annualized_CF_Agreement_Value")).click();
					Thread.sleep(2000);
					}
				
				//Find the CF Program Level ID Column on the Agreement Grid
				Boolean CFProgramLevelIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CFProgramLevelID")).size() >0;
				
				
				if ( ! CFProgramLevelIDColumn)
				{
					
					sheet1.getRow(28).createCell(9).setCellValue("FAILED");
					sheet1.getRow(28).createCell(8).setCellValue("CF Program Level ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(28).createCell(9).setCellValue("PASSED");
					sheet1.getRow(28).createCell(8).setCellValue("CF Program Level ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CFProgramLevelID")).click();
					Thread.sleep(2000);
					}
				
				//Find the TAM flag Column on the Agreement Grid
				Boolean TAMflagColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.TAMFlag")).size() >0;
				
				
				if ( ! TAMflagColumn)
				{
					
					sheet1.getRow(29).createCell(9).setCellValue("FAILED");
					sheet1.getRow(29).createCell(8).setCellValue("TAM Flag Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(29).createCell(9).setCellValue("PASSED");
					sheet1.getRow(29).createCell(8).setCellValue("TAM Flag Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.TAMFlag")).click();
					Thread.sleep(2000);
					}
				
				//Find the Brand Column on the Agreement Grid
				Boolean BrandColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Source")).size() >0;
				
				
				if ( ! BrandColumn)
				{
					
					sheet1.getRow(30).createCell(9).setCellValue("FAILED");
					sheet1.getRow(30).createCell(8).setCellValue("Brand Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(30).createCell(9).setCellValue("PASSED");
					sheet1.getRow(30).createCell(8).setCellValue("Brand Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Source")).click();
					Thread.sleep(2000);
					}
				
				//Find the Active flag Column on the Agreement Grid
				Boolean ActiveflagColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.ActiveFlag")).size() >0;
				
				
				if ( ! ActiveflagColumn)
				{
					
					sheet1.getRow(31).createCell(9).setCellValue("FAILED");
					sheet1.getRow(31).createCell(8).setCellValue("Active Flag Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(31).createCell(9).setCellValue("PASSED");
					sheet1.getRow(31).createCell(8).setCellValue("Active Flag Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.ActiveFlag")).click();
					Thread.sleep(2000);
					}
				
				//Find the Distributor ID Column on the Agreement Grid
				Boolean DistributorIDColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.DistributorID")).size() >0;
				
				
				if ( ! DistributorIDColumn)
				{
					
					sheet1.getRow(32).createCell(9).setCellValue("FAILED");
					sheet1.getRow(32).createCell(8).setCellValue("Distributor ID Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(32).createCell(9).setCellValue("PASSED");
					sheet1.getRow(32).createCell(8).setCellValue("Distributor ID Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.DistributorID")).click();
					Thread.sleep(2000);
					}
				
						
				//Find the Disposition Code Column on the Agreement Grid
				Boolean DispositionCodeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.disposition_code")).size() >0;
				
				
				if ( ! DispositionCodeColumn)
				{
					
					sheet1.getRow(33).createCell(9).setCellValue("FAILED");
					sheet1.getRow(33).createCell(8).setCellValue("Disposition Code Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(33).createCell(9).setCellValue("PASSED");
					sheet1.getRow(33).createCell(8).setCellValue("Disposition Code Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_code")).click();
					Thread.sleep(2000);
					}
				
				//Find the Disposition Column on the Agreement Grid
				Boolean DispositionColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.disposition_description")).size() >0;
				
				
				if ( ! DispositionColumn)
				{
					
					sheet1.getRow(34).createCell(9).setCellValue("FAILED");
					sheet1.getRow(34).createCell(8).setCellValue("Disposition Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(34).createCell(9).setCellValue("PASSED");
					sheet1.getRow(34).createCell(8).setCellValue("Disposition Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_description")).click();
					Thread.sleep(2000);
					}
				
				//Find the Category Column on the Agreement Grid
				Boolean categoryColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.category")).size() >0;
				
				
				if ( ! categoryColumn)
				{
					
					sheet1.getRow(35).createCell(9).setCellValue("FAILED");
					sheet1.getRow(35).createCell(8).setCellValue("category Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(35).createCell(9).setCellValue("PASSED");
					sheet1.getRow(35).createCell(8).setCellValue("category Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.category")).click();
					Thread.sleep(2000);
					}
				
				//Find the disposition_status Column on the Agreement Grid
				Boolean disposition_statusColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.disposition_status")).size() >0;
				
				
				if ( ! disposition_statusColumn)
				{
					
					sheet1.getRow(36).createCell(9).setCellValue("FAILED");
					sheet1.getRow(36).createCell(8).setCellValue("disposition_status Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(36).createCell(9).setCellValue("PASSED");
					sheet1.getRow(36).createCell(8).setCellValue("disposition_status Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.disposition_status")).click();
					Thread.sleep(2000);
					}
				
				//Find the CustomerType Column on the Agreement Grid
				Boolean CustomerTypeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CustomerType")).size() >0;
				
				
				if ( ! CustomerTypeColumn)
				{
					
					sheet1.getRow(37).createCell(9).setCellValue("FAILED");
					sheet1.getRow(37).createCell(8).setCellValue("CustomerType Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(37).createCell(9).setCellValue("PASSED");
					sheet1.getRow(37).createCell(8).setCellValue("CustomerType Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerType")).click();
					Thread.sleep(2000);
					}
				
				//Find the Address Column on the Agreement Grid
				Boolean addressColumn1 = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Address")).size() >0;
				
				
				if ( ! addressColumn1)
				{
					
					sheet1.getRow(38).createCell(9).setCellValue("FAILED");
					sheet1.getRow(38).createCell(8).setCellValue("Address Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(38).createCell(9).setCellValue("PASSED");
					sheet1.getRow(38).createCell(8).setCellValue("Address Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Address")).click();
					Thread.sleep(2000);
					}
				
				//Find the Address2 Column on the Agreement Grid
				Boolean address2Column = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Address2")).size() >0;
				
				
				if ( ! address2Column)
				{
					
					sheet1.getRow(39).createCell(9).setCellValue("FAILED");
					sheet1.getRow(39).createCell(8).setCellValue("Address2 Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(39).createCell(9).setCellValue("PASSED");
					sheet1.getRow(39).createCell(8).setCellValue("Address2 Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Address2")).click();
					Thread.sleep(2000);
					}
				
				//Find the City Column on the Agreement Grid
				Boolean CityColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.City")).size() >0;
				
				
				if ( ! CityColumn)
				{
					
					sheet1.getRow(40).createCell(9).setCellValue("FAILED");
					sheet1.getRow(40).createCell(8).setCellValue("City Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(40).createCell(9).setCellValue("PASSED");
					sheet1.getRow(40).createCell(8).setCellValue("City Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.City")).click();
					Thread.sleep(2000);
					}
				
				//Find the StateProv Column on the Agreement Grid
				Boolean StateProvColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.StateProv")).size() >0;
				
				
				if ( ! StateProvColumn)
				{
					
					sheet1.getRow(41).createCell(9).setCellValue("FAILED");
					sheet1.getRow(41).createCell(8).setCellValue("StateProv Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(41).createCell(9).setCellValue("PASSED");
					sheet1.getRow(41).createCell(8).setCellValue("StateProv Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.StateProv")).click();
					Thread.sleep(2000);
					}
				
				//Find the PostalCode Column on the Agreement Grid
				Boolean PostalCodeColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.PostalCode")).size() >0;
				
				
				if ( ! PostalCodeColumn)
				{
					
					sheet1.getRow(42).createCell(9).setCellValue("FAILED");
					sheet1.getRow(42).createCell(8).setCellValue("PostalCode Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(42).createCell(9).setCellValue("PASSED");
					sheet1.getRow(42).createCell(8).setCellValue("PostalCode Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.PostalCode")).click();
					Thread.sleep(2000);
					}
				
				//Find the Country Column on the Agreement Grid
				Boolean CountryColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Country")).size() >0;
				
				
				if ( ! CountryColumn)
				{
					
					sheet1.getRow(43).createCell(9).setCellValue("FAILED");
					sheet1.getRow(43).createCell(8).setCellValue("Country Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(43).createCell(9).setCellValue("PASSED");
					sheet1.getRow(43).createCell(8).setCellValue("Country Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Country")).click();
					Thread.sleep(2000);
					}
				
				//Find the Region Column on the Agreement Grid
				Boolean RegionColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.Region")).size() >0;
				
				
				if ( ! RegionColumn)
				{
					
					sheet1.getRow(44).createCell(9).setCellValue("FAILED");
					sheet1.getRow(44).createCell(8).setCellValue("Region Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(44).createCell(9).setCellValue("PASSED");
					sheet1.getRow(44).createCell(8).setCellValue("Region Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.Region")).click();
					Thread.sleep(2000);
					}
				
				//Find the CustomerSiteName Column on the Agreement Grid
				Boolean CustomerSiteNameColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteName")).size() >0;
				
				
				if ( ! CustomerSiteNameColumn)
				{
					
					sheet1.getRow(45).createCell(9).setCellValue("FAILED");
					sheet1.getRow(45).createCell(8).setCellValue("CustomerSiteName Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(45).createCell(9).setCellValue("PASSED");
					sheet1.getRow(45).createCell(8).setCellValue("CustomerSiteName Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.CustomerSiteName")).click();
					Thread.sleep(2000);
					}
				
				//Find the Program_Level Column on the Agreement Grid
				Boolean Program_LevelColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.cf_program_level__Description")).size() >0;
				
				
				if ( ! Program_LevelColumn)
				{
					
					sheet1.getRow(46).createCell(9).setCellValue("FAILED");
					sheet1.getRow(46).createCell(8).setCellValue("Program_Level Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(46).createCell(9).setCellValue("PASSED");
					sheet1.getRow(46).createCell(8).setCellValue("Program_Level Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.cf_program_level__Description")).click();
					Thread.sleep(2000);
					}
				
				//Find the DistributorName Column on the Agreement Grid
				Boolean DistributorNameColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.DistributorName")).size() >0;
				
				
				if ( ! DistributorNameColumn)
				{
					
					sheet1.getRow(47).createCell(9).setCellValue("FAILED");
					sheet1.getRow(47).createCell(8).setCellValue("DistributorName Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(47).createCell(9).setCellValue("PASSED");
					sheet1.getRow(47).createCell(8).setCellValue("DistributorName Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.DistributorName")).click();
					Thread.sleep(2000);
					}
				
				//Find the AccountName Column on the Agreement Grid
				Boolean AccountNameColumn = driver.findElements(By.id("jqgh_grid_agreement_agreement_view.AccountName")).size() >0;
				
				
				if ( ! AccountNameColumn)
				{
					
					sheet1.getRow(48).createCell(9).setCellValue("FAILED");
					sheet1.getRow(48).createCell(8).setCellValue("AccountName Column was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(48).createCell(9).setCellValue("PASSED");
					sheet1.getRow(48).createCell(8).setCellValue("AccountName Column was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqgh_grid_agreement_agreement_view.AccountName")).click();
					Thread.sleep(2000);
					}
				
				
				
				//Click the Agreement ID link filter
				Boolean refreshButton2 = driver.findElements(By.id("refresh_grid_agreement")).size() >0;
				
				
				if ( ! refreshButton2)
				{
					
					sheet1.getRow(49).createCell(9).setCellValue("FAILED");
					sheet1.getRow(49).createCell(8).setCellValue("Grid was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(49).createCell(9).setCellValue("PASSED");
					sheet1.getRow(49).createCell(8).setCellValue("Grid was Refreshed");
					//sheet2.getRow(7).createCell(4).setCellValue("PASSED");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(4000);
					}
		
		
	    wb.close();	
		//driver.quit();
	}	




@AfterMethod
public void screenShot(ITestResult result){
	 
	 if(ITestResult.FAILURE==result.getStatus()){
	 try{
	
	 TakesScreenshot screenshot=(TakesScreenshot)driver;
	 File src=screenshot.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\"+ result.getName()+ timestamp()+".png"));
	 System.out.println("Successfully captured a screenshot");
	 }
	 
	 catch (Exception e){
	 System.out.println("Exception while taking screenshot" + e.getMessage());
	 } 
	 }
//driver.quit();
}


private String timestamp() {
	// TODO Auto-generated method stub
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}




}
