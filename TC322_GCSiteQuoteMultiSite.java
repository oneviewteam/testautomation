package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import java.util.Date;
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
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
//import org.testng.annotations.Test;

public class TC322_GCSiteQuoteMultiSite{

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
		
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("\\mmi_auto_testing\\data\\SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC322");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		int globalCustomerSiteQuoteId;
		int globalCustomerSiteQuoteId2;
		int globalCustomerSiteQuoteId3;
		
		//String agreementType;
		//String cFProgramLevel;
		//String startDate;
		//String endDate;
		int pageCounter;
		
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer_all";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			
			
			globalCustomerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			globalCustomerSiteQuoteId2  = (int) sheet1.getRow(1).getCell(4).getNumericCellValue();
			globalCustomerSiteQuoteId3  = (int) sheet1.getRow(1).getCell(5).getNumericCellValue();
			//agreementType =sheet2.getRow(2).getCell(8).getStringCellValue();
			//cFProgramLevel =sheet2.getRow(2).getCell(9).getStringCellValue();
			//startDate = sheet2.getRow(1).getCell(10).getStringCellValue();
			//endDate = sheet2.getRow(1).getCell(11).getStringCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
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
			Thread.sleep(10000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(8000);
			
			//Click on the Agreements tab
			Boolean actualResult =  false;
			actualResult =  driver.findElements(By.id("submenulink_157")).size() >0;
			Thread.sleep(6000);
			
			//Assert.assertTrue(actualResult);
			if( ! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Grid were NOT displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Agreements Grid were displayed");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_157")).click();
			 Thread.sleep(8000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					//System.out.println("Page search for: " + driver.getTitle() + "needs to be cleared");
				}
				else
				{
					sheet1.getRow(4).createCell(9).setCellValue("PASSED");
					sheet1.getRow(4).createCell(8).setCellValue("Grid with "+ numPages +" pages found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
				}
					 
			 	//Clear Search
			 
				 
			 if(driver.findElements(By.id("cancelMaingrid_customer_all")).size()>0)
				 
			 { 	driver.findElement(By.id("cancelMaingrid_customer_all")).click();
			 	Thread.sleep(6000);}
			
				driver.findElement(By.id("advSrch_grid_customer_all")).click();
				Thread.sleep(6000);
	
				driver.findElement(By.linkText("CustomerSiteID")).click();
				Thread.sleep(4000);
			
				
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Between");
				Thread.sleep(4000);
				
				
				//Find the ID search filter box and click that in that box
				driver.findElement(By.id("customer_view_id_1_1")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(globalCustomerSiteQuoteId));
				Thread.sleep(3000);
				
				driver.findElement(By.id("customer_view_id_2_1")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.id("customer_view_id_2_1")).sendKeys(String.valueOf(globalCustomerSiteQuoteId3));
				Thread.sleep(3000);
					
						
				//Select the Customer Site ID from the list
				driver.findElement(By.id("addConditiongrid_customer_all")).click();
				Thread.sleep(3000);
					
				//Select 
				driver.findElement(By.id("rungrid_customer_all")).click();
				Thread.sleep(5000);
					
				
				//Select the check box and click [Create Quote] button
				
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
					
				Boolean findElementPage = true;
				pageCounter = 1;
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(globalCustomerSiteQuoteId))).size() >0;
					
				if(! findElementPage )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
				}
				}
				if ( ! findElementPage)
				{
					sheet1.getRow(5).createCell(9).setCellValue("FAILED");
					sheet1.getRow(5).createCell(8).setCellValue("'Global Customer Site Id was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					sheet1.getRow(5).createCell(8).setCellValue("'Global Customer Site Id was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(globalCustomerSiteQuoteId))).click();
					Thread.sleep(3000);
				}
				//
				Boolean findElementPage2 = true;
				pageCounter = 1;
				while( !findElementPage2  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage2 = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(globalCustomerSiteQuoteId2))).size() >0;
					
				if(! findElementPage2 )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(4000);
				}
				}
				if (!findElementPage2)
				{
					sheet1.getRow(5).createCell(9).setCellValue("FAILED");
					sheet1.getRow(5).createCell(8).setCellValue("'Global Customer Site Id was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					sheet1.getRow(5).createCell(8).setCellValue("'Global Customer Site Id was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(globalCustomerSiteQuoteId2))).click();
					Thread.sleep(3000);
				}
				//
				Boolean findElementPage3 = true;
				pageCounter = 1;
				while( !findElementPage3  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage3 = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(globalCustomerSiteQuoteId3))).size() >0;
					
				if(! findElementPage3 )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(4000);
				}
				}
				if (!findElementPage3)
				{
					sheet1.getRow(5).createCell(9).setCellValue("FAILED");
					sheet1.getRow(5).createCell(8).setCellValue("'Global Customer Site Id was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(5).createCell(9).setCellValue("PASSED");
					sheet1.getRow(5).createCell(8).setCellValue("'Global Customer Site Id was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(globalCustomerSiteQuoteId3))).click();
					Thread.sleep(3000);
				}
			
				
				driver.findElement(By.id("create_quote")).click();
				Thread.sleep(4000);
	
				//Parent Checkbox should be displayed and selected
				
				Boolean confirmation = driver.findElements(By.id("ui-id-2")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("Parent Checkbox Page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("Parent Checkbox Page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
					driver.findElement(By.xpath("//html/body/div[9]/div[2]/form/table/tbody/tr[1]/td[1]/input")).click();
					//driver.findElement(By.name("parent")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//html/body/div[9]/div[2]/form/table/tbody/tr[2]/td[1]/input")).click();
					//driver.findElement(By.name("parent")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//html/body/div[9]/div[2]/form/table/tbody/tr[3]/td[1]/input")).click();
					//driver.findElement(By.name("parent")).click();
					Thread.sleep(3000);
				}
				
			
				//new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
				//Thread.sleep(4000);
				//new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
				//Thread.sleep(4000);
				//WebElement fromDateBox= driver.findElement(By.xpath("//html/body/div[10]/div[2]/form/table/tbody/tr/td[7]/input"));
				//fromDateBox.clear();
				//fromDateBox.sendKeys(String.valueOf(startDate));
				//Thread.sleep(3000);
				//WebElement fromDateBox1= driver.findElement(By.xpath("//html/body/div[10]/div[2]/form/table/tbody/tr/td[8]/input"));
				//fromDateBox1.clear();
				//fromDateBox1.sendKeys(String.valueOf(endDate));
				//Thread.sleep(3000);
				
				//Continue button should be displayed and selected
				Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[9]/div[3]/div/button[2]")).size() >0;
				
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					driver.findElement(By.xpath("//html/body/div[9]/div[3]/div/button[2]")).click();
					Thread.sleep(3000);
					wb.write(fout);
					}
				
				//Email confirmation page will pop up and "OK" button is selected
				Boolean confirmationEmail = driver.findElements(By.xpath("//html/body/div[11]/div[3]/div/button")).size() >0;
				
				
				if ( ! confirmationEmail)
				{
				
					sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Global Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("Global Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[11]/div[3]/div/button")).click();
					Thread.sleep(3000);
					//Clear search conditions and refresh the customer site grid
					driver.findElement(By.id("cancelMaingrid_customer_all")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("refresh_grid_customer_all")).click();
					Thread.sleep(3000);
					
					}
				
				
				
				//Check to see if the content pane is displayed with refreshed Customer sites
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Global Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Global Customer Site Grid' was Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
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

