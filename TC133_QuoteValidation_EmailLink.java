package maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.util.GreenMail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.apache.commons.io.FileUtils;

//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC133_QuoteValidation_EmailLink {
	
    //protected static Log log = LogFactory.getLog(GreenMailServer.class);
    private static GreenMail greenMail;
    private static GreenMailUser primaryUser;
    private static final String EMAIL_INBOX = "INBOX";
    private static final String EMAIL_TRASH = "Trash";
    private static final int WAIT_TIME_MS = 180 * 1000;
    private static final String USER_EMAIL = "wso2@localhost";
    private static final String USER_LOGIN = "wso2";
    private static final String USER_PW = "wso2";
    private static final String PROTOCOL_IMAP = "imap";
    private static final String PROTOCOL_POP3 = "pop3";
    private static final String BIND_ADDRESS = "127.0.0.1";
	
	public Select selenium;
	public static WebDriver driver;

	
	/*
	 * Create a quote from agreement
	 * 
	
	*/
@Test(priority=1)
    public static void main(String[] args) throws IOException, InterruptedException { 
    

		
		//System.setProperty("webdriver.chrome.driver", "C:\\mmi_auto_testing\\bin\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\mmi_auto_testing\\bin\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src=new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\data\\AdvancedSearch_SEAutoTesting.xlsx");
		//File src=new File("SEAutoTesting.xlsx");
	
		//FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\Screenshots"+System.currentTimeMillis()+".jpg"));  
		
		FileInputStream fis=new FileInputStream(src);
		
		//TC111_SELogin_Agreement.captureScreenShot(driver);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//get sheet at index
		//XSSFSheet sheet1=wb.getSheetAt(1);  
		
		// Get sheet by name
		XSSFSheet sheet1=wb.getSheet("TC133");
		//XSSFSheet sheet2=wb.createSheet("results");
		
		
		String baseUrl ;
		String loginUrl; 
		//String logoutUrl; 
		String testUsername;
		String testPassword ;
		//String agreementUrl ;
		//int agreementId ;
		//int numRows ;
		//String numPages;
		//int pageCounter;
		//String gridTitle = "agreement";
		
		
			baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
			//logoutUrl = baseUrl + "/common/oauth2/logout"; 
			loginUrl = baseUrl; 
			testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
			testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();
			//String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();
			
			
			//driver.get(logoutUrl);
			//Thread.sleep(2000);
			driver.get(loginUrl);
			Thread.sleep(2000);
			//driver.findElement(By.id("i0116")).clear();
			//driver.findElement(By.id("email")).sendKeys(testUsername);
			//Thread.sleep(2000);
			
			
			//Click on the "Use another account" button
			if(driver.findElements(By.id("otherTile")).size()>0) 
			{
				 driver.findElement(By.id("otherTile")).click();
				 Thread.sleep(3000); }
			
			//Find and enter the Sign in User name
			Boolean actualResult = driver.findElements(By.id("i0116")).size()>0; 
			Thread.sleep(2000);
			
			if(! actualResult)
		          
		          {
						sheet1.getRow(4).createCell(9).setCellValue("FAILED");
						sheet1.getRow(4).createCell(8).setCellValue("Email, phone, or Skype Field was NOT Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						
												
					}
			
			else 
					{
						sheet1.getRow(4).createCell(9).setCellValue("PASSED");
						sheet1.getRow(4).createCell(8).setCellValue("Email, phone, or Skype Field was Found, Username was Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("i0116")).clear();
						driver.findElement(By.id("i0116")).sendKeys(testUsername);
						Thread.sleep(3000);
					}
			
			//Find the NEXT button and click
			Boolean nextButton = driver.findElements(By.id("idSIButton9")).size()>0; 
			Thread.sleep(2000);
			
			if(! nextButton)
		          
		          {
						sheet1.getRow(5).createCell(9).setCellValue("FAILED");
						sheet1.getRow(5).createCell(8).setCellValue("'Next' button was NOT Identified");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						
						
						
					}
			
			else 
					{
						sheet1.getRow(5).createCell(9).setCellValue("PASSED");
						sheet1.getRow(5).createCell(8).setCellValue("'Next' button was Identified and Clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("idSIButton9")).click();
						Thread.sleep(2000);
						
					}
			

			//Enter sign in Password in the password field			
			Boolean actualResult1 = driver.findElements(By.id("i0118")).size()>0; 
			Thread.sleep(1000);
			if(! actualResult1)
		          
		          {
						sheet1.getRow(6).createCell(9).setCellValue("FAILED");
						sheet1.getRow(6).createCell(8).setCellValue("Password Field was NOT Identified");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						
						
						
					}
			
			else 
					{
						sheet1.getRow(6).createCell(9).setCellValue("PASSED");
						sheet1.getRow(6).createCell(8).setCellValue("Password Field was Identified and Entered");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("i0118")).sendKeys(testPassword);
						Thread.sleep(2000);
					}
			
			
			
			//If statement - will check if element is Displayed before clicking on login button.
			Boolean actualResult2 = driver.findElements(By.id("idSIButton9")).size()>0; 
			Thread.sleep(2000);
			
			if(! actualResult2)
		       
		          {
						sheet1.getRow(7).createCell(9).setCellValue("FAILED");
						sheet1.getRow(7).createCell(8).setCellValue("Signin button NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						
						
						
					}
			
			else 
					{
						sheet1.getRow(7).createCell(9).setCellValue("PASSED");
						sheet1.getRow(7).createCell(8).setCellValue("Signin button was found and clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("idSIButton9")).click();
						Thread.sleep(7000);
						
					}
			

			if(driver.findElements(By.id("KmsiCheckboxField")).size()>0) 
			{
				 driver.findElement(By.id("KmsiCheckboxField")).click();
				 Thread.sleep(2000); }
			
			if(driver.findElements(By.id("idBtn_Back")).size()>0) 
			{
				 driver.findElement(By.id("idBtn_Back")).click();
				 Thread.sleep(3000); }
			
			
			
			//Identify the the Dash board is present
			Boolean frontPage =  driver.findElements(By.id("hero-heading")).size() >0;
			
			if(! frontPage)
			{
				sheet1.getRow(8).createCell(9).setCellValue("FAILED");
				sheet1.getRow(8).createCell(8).setCellValue("OUTLOOK front page was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				
				
			}
			else
			{
				sheet1.getRow(8).createCell(9).setCellValue("PASSED");
				sheet1.getRow(8).createCell(8).setCellValue("OUTLOOK front page was found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				Thread.sleep(2000);
			}
			
			//Identify the the OUTLOOK icon is present
			Boolean actualResult3 =  driver.findElements(By.id("ShellMail_link_text")).size() >0;
			
			if(! actualResult3)
			{
				sheet1.getRow(9).createCell(9).setCellValue("FAILED");
				sheet1.getRow(9).createCell(8).setCellValue("OUTLOOK Email Icon was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				
				
			}
			else
			{
				sheet1.getRow(9).createCell(9).setCellValue("PASSED");
				sheet1.getRow(9).createCell(8).setCellValue("OUTLOOK Email Icon was found");
				FileOutputStream fout=new FileOutputStream(src);
				driver.findElement(By.id("ShellMail_link_text")).click();
				wb.write(fout);
				Thread.sleep(7000);
			}
			
			//Identify the the Automation email folder is present
			Boolean automationEmailFolder =  driver.findElements(By.linkText("Automation Quotes")).size() >0;
			
			if(! automationEmailFolder)
			{
				sheet1.getRow(10).createCell(9).setCellValue("FAILED");
				sheet1.getRow(10).createCell(8).setCellValue("Automation Quotes Folder was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				
				
			}
			else
			{
				sheet1.getRow(10).createCell(9).setCellValue("PASSED");
				sheet1.getRow(10).createCell(8).setCellValue("Automation Quotes Folder was found and Opened");
				FileOutputStream fout=new FileOutputStream(src);
				driver.findElement(By.linkText("Automation Quotes")).click();
				wb.write(fout);
				Thread.sleep(5000);
			}
			
			//Identify the the Dash board is present
			Boolean quoteEmail =  driver.findElements(By.cssSelector("span[aria-label='From Managed Maintenance Inc, Subject Your quote is complete!']")).size() >0;
			
			if(! quoteEmail)
			{
				sheet1.getRow(11).createCell(9).setCellValue("FAILED");
				sheet1.getRow(11).createCell(8).setCellValue("Quotes Email was NOT found");
				FileOutputStream fout=new FileOutputStream(src);
				wb.write(fout);
				
				
			}
			else
			{
				sheet1.getRow(11).createCell(9).setCellValue("PASSED");
				sheet1.getRow(11).createCell(8).setCellValue("Quotes Email was found");
				FileOutputStream fout=new FileOutputStream(src);
				driver.findElement(By.cssSelector("span[aria-label='From Managed Maintenance Inc, Subject Your quote is complete!']")).click();
				wb.write(fout);
				Thread.sleep(8000);
			}
			

	
	    wb.close();	
		driver.quit();
}
	
	


	@AfterMethod
		public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
			if (testResult.getStatus() == ITestResult.FAILURE) {
				System.out.println(testResult.getStatus());
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C:\\mmi_automation\\mmi_auto_testing_AdvancedSearch\\output\\" + testResult.getName() + "-" 
						+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
		   }        
		}

	

}

