package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;

//import org.apache.poi.xssf.usermodel.XSSFFont
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
//import org.testng.annotations.Test;

public class TC129_AgreementParentCurrent {

//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;
	
	/*
	 * Create a quote from agreement
	 * 
	*/
	//@Test(priority=1)
	//public  void quoteFromAgreement() throws Throwable {
		
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
		XSSFSheet sheet1=wb.getSheet("TC129");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		int agreementParentCurrentId ;
		//int agreementTypeId ;
		String numPages;
		int pageCounter;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementParentCurrentId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			driver.get(logoutUrl);
			Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(4000);
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(testUsername);
			Thread.sleep(2000);
			
			driver.findElement(By.id("password-text")).sendKeys(testPassword);
			Thread.sleep(2000);
			
			//Click the Login button
			driver.findElement(By.id("Login")).click();
			Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(7000);
			
			if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			{
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
					 
			 //Clear Search
				 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
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
			 
			 //Find the Andvance search link and click that link
				 
				
			boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
			Thread.sleep(1000);
				
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
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				Thread.sleep(1000);
				
				if ( ! idButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					Thread.sleep(2000);
					}
				
				//new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Starts with");
				
				//Find the ID search filter box and click that in that box
				boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size()>0;
				Thread.sleep(3000);
				
				if ( ! idSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					Thread.sleep(2000);
					}
		
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementParentCurrentId));
				Thread.sleep(6000);
				
				
				//Click on search result for agreement ID
				boolean idSrchResult = driver.findElements(By.linkText(String.valueOf(agreementParentCurrentId))).size() >0;
				Thread.sleep(1000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementParentCurrentId))).click();
					Thread.sleep(2000);
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(4000);
				}
				
				
				
				//Run the filtered search
				boolean idRunSrch = driver.findElements(By.id("content_pane")).size()>0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(2000);
					}
				
				//Select the check box and click [Create Quote] button
				//driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementParentCurrentId))).click();
				//Search and Find Agreement ID within the Grid
				boolean findElementPage = false;
				pageCounter = 1;
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(agreementParentCurrentId))).size() >0;
				
				if(! findElementPage )
				{
					driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					pageCounter++;
					Thread.sleep(3000);
				}
				}
				
				driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementParentCurrentId))).click();
				Thread.sleep(2000);
				driver.findElement(By.id("create_quote")).click();
				Thread.sleep(2000);
				
				//Click on the Create Quote button
				//boolean CreateQuote = driver.findElements(By.id("create_quote")).size()>0;
				boolean CreateQuote = driver.findElements(By.id("ui-id-2")).size()>0;
			
				if (!CreateQuote)
				{
					
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//driver.findElement(By.id("create_quote")).click();
					Thread.sleep(2000);
					}
				
				//driver.findElement(By.id("" + String.valueOf(agreementParentCurrentId))).click();
				driver.findElement(By.cssSelector(".parent_checkbox")).click();
				Thread.sleep(2000);
		
				//boolean for quote confirmation pop up must be true otherwise fail
				boolean confirmation = driver.findElements(By.id("createDialogContinue")).size()>0;
				
				if (!confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Agreement page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Agreement page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("createDialogContinue")).click();
					Thread.sleep(3000);
				}
				
				//Click on the continue button on the Parent Agreement page
				boolean continue1 = driver.findElements(By.id("createDialogContinue")).size() >0;
				
				if (continue1 == true)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
		
				//Click the "OK" button on the email confirmation page
				boolean confirmation1 = driver.findElements(By.xpath("//button[contains(.,'OK')]")).size() >0;
				
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Email Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("'Email Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
					Thread.sleep(3000);
					}
				
				
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the grid and show all agreements
				boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					//driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Agreements Grid' was Displayed");
					sheet2.getRow(3).createCell(4).setCellValue("PASSED");
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

