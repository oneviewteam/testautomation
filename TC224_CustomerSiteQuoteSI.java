package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TC224_CustomerSiteQuoteSI {

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
		XSSFSheet sheet1=wb.getSheet("TC224");
		XSSFSheet sheet2=wb.getSheet("SC2_DATA");
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		int customerSiteQuoteId;
		String agreementType;
		String cFProgramLevel;
		String startDate;
		String endDate;
		int pageCounter;
		
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "customer";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			customerSiteQuoteId  = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			
			agreementType =sheet1.getRow(1).getCell(4).getStringCellValue();
			cFProgramLevel =sheet1.getRow(1).getCell(5).getStringCellValue();
			startDate = sheet1.getRow(1).getCell(6).getStringCellValue();
			endDate = sheet1.getRow(1).getCell(7).getStringCellValue();
			//agreementTypeId = (int) sheet2.getRow(4).getCell(4).getNumericCellValue();
			// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			driver.get(logoutUrl);
			Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(2000);
			driver.findElement(By.id("email")).sendKeys(testUsername);
			Thread.sleep(2000);
			//Actions actions = new Actions(driver);
			driver.findElement(By.id("password-text")).sendKeys(testPassword);
			Thread.sleep(2000);
			
			//Click the Login button
			driver.findElement(By.id("Login")).click();
			Thread.sleep(12000);
					
		   // agreementUrl = baseUrl + "/sf/" + gridTitle;
			// driver.get(agreementUrl);
		
			//Click on " Installed Base" tab 
			driver.findElement(By.id("topmenuitem_31")).click();  
			Thread.sleep(4000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_137")).size() >0;
			Thread.sleep(4000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
			{
				//If the tab is not greater than "0", then show "failed"
				sheet1.getRow(3).createCell(9).setCellValue("FAILED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				wb.close();	
				driver.quit();

			}
			else
			{
				//If the tab is greater than "0", then show "passed"
				sheet1.getRow(3).createCell(9).setCellValue("PASSED");
				sheet1.getRow(3).createCell(8).setCellValue("Customer Sites Tab Submenu was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
			}
			
			//Click on " Agreements" icon from sub-menu
			 driver.findElement(By.id("submenulink_137")).click();
			 Thread.sleep(6000);
			 
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {				 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(3000); }
			 
			//Search grid for amount of pages displayed
			 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
			 //Assert.assertNotEquals("0", numPages);
			 if(numPages.equals("0"))
				{
					sheet1.getRow(4).createCell(9).setCellValue("FAILED");
					sheet1.getRow(4).createCell(8).setCellValue("Empty Grid");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
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
			 
				 if(driver.findElements(By.id("cancelMaingrid_customer")).size()>0) {
				 
				 driver.findElement(By.id("cancelMaingrid_customer")).click();
				 Thread.sleep(4000);
				 numPages = driver.findElement(By.id("sp_1_grid_" + gridTitle + "-gridpager")).getText();
				 sheet1.getRow(5).createCell(9).setCellValue("PASSED");
				 sheet1.getRow(5).createCell(8).setCellValue("Customer Site Grid reloaded with "+numPages+" pages");
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
				Boolean advSrch = driver.findElements(By.id("advSrch_grid_customer")).size() >0;
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advanced Serarch' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(6).createCell(9).setCellValue("PASSED");
					sheet1.getRow(6).createCell(8).setCellValue("'Advance Serach' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("advSrch_grid_customer")).click();
					Thread.sleep(2000);
					}
				
				//Find the ID filter button link and click that link
				Boolean CSidButton = driver.findElements(By.linkText("CustomerSiteID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! CSidButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'Customer Site ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("CustomerSiteID")).click();
					Thread.sleep(3000);
					}
				
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				new Select(driver.findElement(By.id("customer_view__id"))).selectByVisibleText("Contains");
				Thread.sleep(3000);
				
				
				//Find the ID search filter box and click that in that box
				Boolean CustomerSiteidSrch = false;
				//agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				
				CustomerSiteidSrch = (driver.findElement(By.id("customer_view_id_1_1")).isDisplayed());
				Thread.sleep(3000);
				
				if ( ! CustomerSiteidSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Customer Site ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("customer_view_id_1_1")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("customer_view_id_1_1")).sendKeys(String.valueOf(customerSiteQuoteId));
					Thread.sleep(3000);
					
					}
		
				//Select the Customer Site ID from the list
				Boolean idSrchResult = driver.findElements(By.id("addConditiongrid_customer")).size() >0;
				Thread.sleep(4000);
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Customer Site ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("addConditiongrid_customer")).click();
					Thread.sleep(2000);
					
					}
				//new Select(driver.findElement(By.id("customer_id"))).selectByVisibleText("Contains");
				//Select oSelect = new Select(driver.findElement(By.id("auto_completegrid_customer")));
				//oSelect.selectByValue(String.valueOf(customerSiteQuoteId));
				//driver.findElement(By.id("auto_completegrid_customer"))).selectByVisibleText(String.valueOf(customerSiteQuoteId));
				//Thread.sleep(4000);
				
				//Select 
				Boolean idRunSrch = driver.findElements(By.id("rungrid_customer")).size() >0;
				
				if ( ! idRunSrch)
				{
					
					sheet1.getRow(10).createCell(9).setCellValue("FAILED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Serach' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				
				}
				else
				{
					sheet1.getRow(10).createCell(9).setCellValue("PASSED");
					sheet1.getRow(10).createCell(8).setCellValue("'Run Search' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("rungrid_customer")).click();
					Thread.sleep(3000);
					}
				
				//Select the check box and click [Create Quote] button
					
				Boolean findElementPage = false;
				pageCounter = 1;
				//sp_1_grid_agreement-gridpager  //Total pages
				//pg_input_bottom_grid_agreement //Actual page number
				customerSiteQuoteId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
				while( !findElementPage  &&  !String.valueOf(pageCounter).equals(numPages))
					
				{
					findElementPage = driver.findElements(By.id("jqg_grid_" + gridTitle + "_" + String.valueOf(customerSiteQuoteId))).size() >0;
					
				if(! findElementPage )
				{
						driver.findElement(By.id("next_grid_" + gridTitle + "-gridpager")).click();
					    pageCounter++;
						Thread.sleep(3000);
				}
				}
				if (!findElementPage)
				{
					sheet1.getRow(11).createCell(9).setCellValue("FAILED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was NOT Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(11).createCell(9).setCellValue("PASSED");
					sheet1.getRow(11).createCell(8).setCellValue("'Create Quote' was Initiated");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("jqg_grid_customer_" + String.valueOf(customerSiteQuoteId))).click();
					Thread.sleep(3000);
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
				}
				
			//Parent Checkbox should be displayed and selected
				
				Boolean confirmation = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("Parent Checkbox was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(3000);
					new Select(driver.findElement(By.name("agreementType"))).selectByVisibleText(String.valueOf(agreementType));
					Thread.sleep(3000);
					new Select(driver.findElement(By.name("cfProgramLevel"))).selectByVisibleText(String.valueOf(cFProgramLevel));
					Thread.sleep(3000);
					WebElement fromDateBox= driver.findElement(By.name("StartDate"));
					//WebElement fromDateBox= driver.findElement(By.cssSelector(".datepicker_start"));
					//WebElement fromDateBox= driver.findElement(By.xpath("//html/body/div[10]/div[2]/form/table/tbody/tr/td[7]/input"));
					fromDateBox.clear();
					fromDateBox.sendKeys(String.valueOf(startDate));
					Thread.sleep(3000);
					WebElement fromDateBox1= driver.findElement(By.name("EndDate"));
					//WebElement fromDateBox1= driver.findElement(By.cssSelector(".datepicker_end"));
					//WebElement fromDateBox1= driver.findElement(By.xpath("//html/body/div[10]/div[2]/form/table/tbody/tr/td[8]/input"));
					fromDateBox1.clear();
					fromDateBox1.sendKeys(String.valueOf(endDate));
					Thread.sleep(3000);
				}
			
				//Continue button should be displayed and selected
				Boolean confirmation1 = driver.findElements(By.xpath("//html/body/div[10]/div[3]/div/button[2]")).size() >0;
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("'Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					driver.findElement(By.xpath("//html/body/div[10]/div[3]/div/button[2]")).click();
					Thread.sleep(3000);
					wb.write(fout);
					}
				
				//Email confirmation page will pop up and "OK" button is selected
				Boolean confirmationEmail = driver.findElements(By.xpath("//html/body/div[12]/div[3]/div/button")).size() >0;
				
				if (!confirmationEmail)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Customer Site Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("Customer Site Grid' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.xpath("//html/body/div[12]/div[3]/div/button")).click();
					Thread.sleep(3000);
					//Clear search conditions and refresh the customer site grid
					driver.findElement(By.id("cancelMaingrid_customer")).click();
					Thread.sleep(4000);
					driver.findElement(By.id("refresh_grid_customer")).click();
					Thread.sleep(3000);
				}
				
	
				//Check to see if the content pane is displayed with refreshed Customer sites
				Boolean confirmation2 = driver.findElements(By.id("content_pane")).size() >0;
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was NOT Refreshed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Customer Site Grid' was Refreshed");
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

