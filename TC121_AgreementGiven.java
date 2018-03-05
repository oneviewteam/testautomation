package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TC121_AgreementGiven {
	
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
		XSSFSheet sheet1=wb.getSheet("TC121");
		//XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		//String agreementUrl ;
		int agreementId ;
		//int numRows ;
		String numPages;
		int pageCounter;
		
		
		String gridTitle = "agreement";
		
		
		
		//numRows = sheet1.getLastRowNum();
		
		
			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			
			driver.get(logoutUrl);
			driver.get(loginUrl);
			driver.findElement(By.id("email")).sendKeys(testUsername);
			//Actions actions = new Actions(driver);
			driver.findElement(By.id("password-text")).sendKeys(testPassword);
			
			//Click the Login button
			driver.findElement(By.id("Login")).click();
			Thread.sleep(12000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
			
			
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(5000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			
			//Assert.assertTrue(actualResult);
			if( ! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();
				
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
			 Thread.sleep(12000);
			 

			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			 //Check grid and identify page amount
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
			 
			 
			 //Clear Search
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(5000);
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
			 
			 driver.findElement(By.id("advSrch_grid_agreement")).click();
			 Thread.sleep(4000);
			 driver.findElement(By.linkText("ID")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
			 Thread.sleep(3000);
			 driver.findElement(By.linkText(String.valueOf(agreementId))).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("rungrid_agreement")).click();
			 Thread.sleep(3000);
			 
			 
			  //Advanced search Simulation)
				Boolean findElementPage = false;
				pageCounter = 1;
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
				agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( ! findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
				 {
					
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementId))).size() >0;
					
					if(! findElementPage )
					{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
					}
				 }
				if ( ! findElementPage)
				{
				 
				   //Write in result file that element does not exists
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("No pages with AgreementID " + agreementId + " were not found in the system");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("Page with AgreementID " + agreementId + " found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout); 
				}
				
				
				//Select the check box and click [Create Quote] button
				driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementId))).click();
				Thread.sleep(3000);
				driver.findElement(By.id("create_quote")).click();
				Thread.sleep(3000);
				
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElement(By.id("createDialogContinue")).isDisplayed();
				
				if ( ! confirmation)
				{
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
					
				}
				
				driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(3000);
				
				Boolean continue1 = driver.findElement(By.id("ui-id-2")).isDisplayed();
				
				if (continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				
				Boolean confirmation1 = driver.findElement(By.cssSelector("div.ui-dialog:nth-child(45) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)")).isDisplayed();
				
				if ( ! confirmation1)
				{
					
					
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.cssSelector("div.ui-dialog:nth-child(45) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("cancelMaingrid_agreement")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				Boolean confirmation2 = driver.findElement(By.id("content_pane")).isDisplayed();
				
				if ( ! confirmation2)
				{
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
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

