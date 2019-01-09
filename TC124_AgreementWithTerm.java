package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
//import org.testng.annotations.Test;

public class TC124_AgreementWithTerm {
//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;
	
	/*Create a quote from agreement
	 * 
	*/

	//@Test(priority=1)
	//public  void quoteFromAgreement() throws Throwable {
		
@SuppressWarnings("resource")
public static void main(String[] args) throws IOException, InterruptedException { 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//File src=new File("C:\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("data\\SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC124");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		int agreementId ;
		//int agreementTypeId ;
		//int agreementTermId;
		int daysToExpire;
		int pageCounter;
		String numPages;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();
		//sheet3.getLastRowNum();

			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet1.getRow(1).getCell(4).getNumericCellValue();
			//agreementTermId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			daysToExpire = (int) sheet1.getRow(1).getCell(5).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			driver.get(logoutUrl);
			Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(testUsername);
			Thread.sleep(2000);
			
			driver.findElement(By.id("password-text")).sendKeys(testPassword);
			Thread.sleep(2000);
			
			//Click the Login button
			driver.findElement(By.id("Login")).click();
			Thread.sleep(16000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
			
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(6000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(5000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				//wb.close();	
				//driver.quit();
			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_129")).click();
			 Thread.sleep(3000);
			 
			//Clear grid 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000);
			 }
			 
			 //Identify pages amount on grid
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 //Clear any existing saved Searches
			 
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Agreement Grid reloaded with "+numPages+" pages");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 }
			else {
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("No Search to clear");
				 FileOutputStream fout=new FileOutputStream(src);
				 wb.write(fout);
				 
			 }
			 
				//Find the Advance search link and click that link
				boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					}
				
				//Find the Agreement Type ID filter button link and click that link
				boolean DaysToExpireButton = driver.findElements(By.linkText("Days_to_Expiration")).size() >0;
				Thread.sleep(3000);
				
				if ( ! DaysToExpireButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Days to Expiration' Button was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("Days to Expiration' Button was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					
					}
				driver.findElement(By.linkText("Days_to_Expiration")).click();
				Thread.sleep(3000);
				
				new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Greater Than or Equal");
				
				//Find the ID search filter box and click that in that box
				boolean DaysToExpireSrch = driver.findElements(By.id("agreement_view_Days_to_Expiration_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! DaysToExpireSrch)
				{
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("Days to Expire was not Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("Days to Expire was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("agreement_view_Days_to_Expiration_1_1")).click();
					}
				
				//Search for Agreement ID with term more than 1 year
				driver.findElement(By.id("agreement_view_Days_to_Expiration_1_1")).sendKeys(String.valueOf(daysToExpire));
				Thread.sleep(4000);
				driver.findElement(By.id("addConditiongrid_agreement")).click();
				Thread.sleep(3000);
				
				//Find search result and click
				boolean AgreeTermIdSrchResult = driver.findElements(By.id("rungrid_agreement")).size() >0;
				
				if ( ! AgreeTermIdSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement search' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(5000);
					}
				
				//Find given agreement ID from results of terms for 1 year
				boolean findElementPage = true;
				pageCounter = 1;
				
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).size() >0;
				
				
				if( ! findElementPage )
				{
					driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					pageCounter++;
					Thread.sleep(3000);
				}
				}
				if ( ! findElementPage)
				{
				   //Write in result file that element does not exists
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("No pages with AgreementID " + agreementId + " were not found in the system");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("Page with AgreementID " + agreementId + " found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).click();
					Thread.sleep(3000);
				}
				
				
				//Select the check box and click [Create Quote] button
				driver.findElement(By.id("create_quote")).click();
				Thread.sleep(3000);
				
				
				//Click continue on the quote confirmation box
				boolean confirmation = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if ( ! confirmation)
				{
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
					
				}
				
				
				//If "Validation Errors" warning is given, click continue again
				boolean continue1 = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if (continue1 == true)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				//Click "OK" on the email confirmation pop up page
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				Thread.sleep(1000);
				if (!confirmation1)
				{
				
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					}
				
				
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if (!confirmation2)
				{
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					driver.findElement(By.id("refresh_grid_agreement")).click();
					Thread.sleep(3000);
					wb.write(fout);
					}
				
					//wb.close();	
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

