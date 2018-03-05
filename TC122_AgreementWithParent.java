package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;

//import org.apache.poi.xssf.usermodel.XSSFFont
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.Test;



public class TC122_AgreementWithParent {
	
WebDriver driver;
	
	/*
	 * Create a quote from agreement
	 * 
	*/
	@Test(priority=1)
	public  void quoteFromAgreement() throws Throwable {
		
		
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
		XSSFSheet sheet1=wb.getSheet("TC122");
		XSSFSheet sheet2=wb.getSheet("SC1_DATA");
		wb.createCellStyle();
		//XSSFCellStyle style = wb.createCellStyle();
		//style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		XSSFCellStyle cellStyle = wb.createCellStyle();        
	    XSSFFont font = wb.createFont();
	     font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
	     font.setFontHeightInPoints((short)10);
	     //font.setColor(IndexedColorMap.green.getIndex());
	     // #F0122D   = red
	     XSSFColor red = new XSSFColor(new java.awt.Color(240,18,45));  
	     cellStyle.setFillForegroundColor(red);
	     // #2DF10E = green
	     XSSFColor green =new XSSFColor(new java.awt.Color(45,241,14));
	     cellStyle.setFillForegroundColor(green);
		
		String baseUrl ;
		String loginUrl; 
		String logoutUrl; 
		String testUsername;
		String testPassword ;
		int agreementId ;
		//int agreementTypeId ;
		String numPages;
		String gridTitle = "agreement";
	
		sheet1.getLastRowNum();
		sheet2.getLastRowNum();

			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			logoutUrl =baseUrl + "/auth/logout"; 
			loginUrl =baseUrl + "/auth/login"; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			agreementId = (int) sheet1.getRow(1).getCell(3).getNumericCellValue();
			//agreementTypeId = (int) sheet1.getRow(1).getCell(4).getNumericCellValue();
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
			Thread.sleep(7000);
			
			//Click on the Agreements tab
			Boolean actualResult =  driver.findElements(By.id("submenulink_129")).size() >0;
			Thread.sleep(7000);
			
			//Assert.assertTrue(actualResult);
			if(! actualResult)
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
			 Thread.sleep(3000);
			 if(driver.findElements(By.id("cancelMaingrid_agreement")).size()>0) 
			 {	 
				 driver.findElement(By.id("cancelMaingrid_agreement")).click();
				 Thread.sleep(4000);
			 }
				 
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
				Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;
				
				
				if ( ! advSrch)
				{
					sheet1.getRow(6).createCell(9).setCellValue("FAILED");
					cellStyle.setFillForegroundColor(green);
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
					driver.findElement(By.id("advSrch_grid_agreement")).click();
					}
				
				//Find the ID filter button link and click that link
				Boolean idButton = driver.findElements(By.linkText("ID")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idButton)
				{
					
					sheet1.getRow(7).createCell(9).setCellValue("FAILED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(7).createCell(9).setCellValue("PASSED");
					sheet1.getRow(7).createCell(8).setCellValue("'ID Button' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText("ID")).click();
					}
				
				//Find the ID search filter box and click that in that box
				Boolean idSrch = driver.findElements(By.id("ignore_agreement_view_id_1_1")).size() >0;
				Thread.sleep(3000);
				
				if ( ! idSrch)
				{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was NOT Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
				}
				else
				{
					sheet1.getRow(8).createCell(9).setCellValue("PASSED");
					sheet1.getRow(8).createCell(8).setCellValue("'Agreement ID' was Entered");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.id("ignore_agreement_view_id_1_1")).click();
					}
		
				driver.findElement(By.id("ignore_agreement_view_id_1_1")).sendKeys(String.valueOf(agreementId));
				Thread.sleep(10000);
				
				Boolean idSrchResult = driver.findElement(By.linkText(String.valueOf(agreementId))).isDisplayed();
				
				if ( ! idSrchResult)
				{
				
					sheet1.getRow(9).createCell(9).setCellValue("FAILED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was NOT Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(9).createCell(9).setCellValue("PASSED");
					sheet1.getRow(9).createCell(8).setCellValue("'Agreement ID' was Found");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.linkText(String.valueOf(agreementId))).click();
					}
				
				Boolean idRunSrch = driver.findElement(By.id("rungrid_agreement")).isDisplayed();
				
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
					driver.findElement(By.id("rungrid_agreement")).click();
					Thread.sleep(3000);
					}
				
				//Select the check box and click [Create Quote] button
				driver.findElement(By.id("jqg_grid_agreement_" + String.valueOf(agreementId))).click();
				Thread.sleep(3000);
				
				Boolean CreateQuote = driver.findElements(By.id("create_quote")).size() >0;
			 
				if ( ! CreateQuote)
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
					driver.findElement(By.id("create_quote")).click();
					Thread.sleep(3000);
					}
				
				Boolean ParentAgreement = driver.findElements(By.cssSelector(".parent_checkbox")).size() >0;
			
				if ( ! ParentAgreement)
				{
					
					sheet1.getRow(12).createCell(9).setCellValue("FAILED");
					sheet1.getRow(12).createCell(8).setCellValue("'Parent Agreement' was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(12).createCell(9).setCellValue("PASSED");
					sheet1.getRow(12).createCell(8).setCellValue("'Parent Agreement' was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					driver.findElement(By.cssSelector(".parent_checkbox")).click();
					Thread.sleep(3000);
					}
				
				//Boolean for quote confirmation pop up must be true otherwise fail
				Boolean confirmation = driver.findElement(By.id("createDialogContinue")).isDisplayed();
				
				if ( ! confirmation)
				{
					
					sheet1.getRow(13).createCell(9).setCellValue("FAILED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(13).createCell(9).setCellValue("PASSED");
					sheet1.getRow(13).createCell(8).setCellValue("Confirmation page is Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(3000);
					
				}
				
				driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(3000);
				
				//Click the "OK" button on the email confirmation page
				Boolean continue1 = driver.findElements(By.id("ui-id-6")).size() >0;
				
				if ( ! continue1)
				{	driver.findElement(By.id("createDialogContinue")).click();
				Thread.sleep(2000);}
				
				//
				Boolean confirmation1 = driver.findElement(By.cssSelector("div.ui-dialog:nth-child(45) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)")).isDisplayed();
				
				if ( ! confirmation1)
				{
				
					sheet1.getRow(14).createCell(9).setCellValue("FAILED");
					sheet1.getRow(14).createCell(8).setCellValue("'Quote is being Processed' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(14).createCell(9).setCellValue("PASSED");
					sheet1.getRow(14).createCell(8).setCellValue("'Quote is being Processed' was Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					}
				
				driver.findElement(By.cssSelector("div.ui-dialog:nth-child(45) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1)")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("refresh_grid_agreement")).click();
				Thread.sleep(3000);
				
				//Refresh the agreement grid after quote creation
				Boolean confirmation2 = driver.findElement(By.id("content_pane")).isDisplayed();
				
				if ( ! confirmation2)
				{
			
					sheet1.getRow(15).createCell(9).setCellValue("FAILED");
					sheet1.getRow(15).createCell(8).setCellValue("'Agreements Grid' was NOT Displayed");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					wb.close();	
					driver.quit();
					
				}
				else
				{
					sheet1.getRow(15).createCell(9).setCellValue("PASSED");
					sheet1.getRow(15).createCell(8).setCellValue("'Agreements Grid' was Displayed");
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

