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

public class TC433_AdvancedOperatorFilterE_T {
	
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
XSSFSheet sheet1=wb.getSheet("TC433");
//XSSFSheet sheet2=wb.createSheet("results");


String baseUrl ;
String loginUrl; 
String logoutUrl; 
String testUsername;
String testPassword ;

String EndDate;
String Estimated_CF_Agreement_Value;
String ID;
String ParentAgreementNumber;
String PostalCode;
String Program_Level;
String Region;
String StartDate;
String StateProv;
String TAMFlag;
//String Agreement_Type;
//String AgreementTypeID;
//String AgreementNumber;
//String Days_to_Expiration;
//String CF_License_Value;
//String CustomerSiteID;
//String AnnualizedCFValue;
//String CFProgramLevelID;
//String ActiveFlag;
//String DistributorID;
//String Disposition_Code;
//String Disposition;
//String category;
//String disposition_status;
//String CustomerType;
//String Address;
//String Address2;
//String City;
//String Country;
//String CustomerSiteName;
//String DistributorName;
//String AccountName;
//String agreementUrl ;
//int agreementId ;
//int numRows ;
//String numPages;
//int pageCounter;
//String gridTitle = "agreement";
//numRows = sheet1.getLastRowNum();


baseUrl =sheet1.getRow(1).getCell(0).getStringCellValue();
logoutUrl =baseUrl + "/auth/logout"; 
loginUrl =baseUrl + "/auth/login"; 
testUsername =sheet1.getRow(1).getCell(1).getStringCellValue();
testPassword =sheet1.getRow(1).getCell(2).getStringCellValue();

EndDate = sheet1.getRow(3).getCell(10).getStringCellValue();
Estimated_CF_Agreement_Value = sheet1.getRow(4).getCell(10).getStringCellValue();
ID = sheet1.getRow(5).getCell(10).getStringCellValue();
ParentAgreementNumber= sheet1.getRow(6).getCell(10).getStringCellValue();
PostalCode = sheet1.getRow(7).getCell(10).getStringCellValue();
Program_Level = sheet1.getRow(8).getCell(10).getStringCellValue();
Region = sheet1.getRow(9).getCell(10).getStringCellValue();
StartDate = sheet1.getRow(10).getCell(10).getStringCellValue();
StateProv = sheet1.getRow(11).getCell(10).getStringCellValue();
TAMFlag = sheet1.getRow(12).getCell(10).getStringCellValue();

//AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
//ActiveFlag = sheet1.getRow(4).getCell(10).getStringCellValue();
//Address = sheet1.getRow(5).getCell(10).getStringCellValue();
//Address2 = sheet1.getRow(6).getCell(10).getStringCellValue();
//Agreement_Type = sheet1.getRow(7).getCell(10).getStringCellValue();
//AgreementNumber = sheet1.getRow(8).getCell(10).getStringCellValue();
//AgreementTypeID = sheet1.getRow(9).getCell(10).getStringCellValue();
//AnnualizedCFValue = sheet1.getRow(10).getCell(10).getStringCellValue();
//Brand = sheet1.getRow(11).getCell(10).getStringCellValue();
//CustomerSiteID = sheet1.getRow(6).getCell(10).getStringCellValue();
//Days_to_Expiration = sheet1.getRow(13).getCell(10).getStringCellValue();
//CF_License_Value = sheet1.getRow(14).getCell(10).getStringCellValue();
//CFProgramLevelID = sheet1.getRow(17).getCell(10).getStringCellValue();
//DistributorID = sheet1.getRow(21).getCell(10).getStringCellValue();
//Disposition_Code = sheet1.getRow(22).getCell(10).getStringCellValue();
//Disposition = sheet1.getRow(23).getCell(10).getStringCellValue();
//category = sheet1.getRow(24).getCell(10).getStringCellValue();
//disposition_status = sheet1.getRow(25).getCell(10).getStringCellValue();
//CustomerType = sheet1.getRow(26).getCell(10).getStringCellValue();
//City = sheet1.getRow(29).getCell(10).getStringCellValue();
//Country = sheet1.getRow(32).getCell(10).getStringCellValue();
//CustomerSiteName = sheet1.getRow(34).getCell(10).getStringCellValue();
//DistributorName = sheet1.getRow(36).getCell(10).getStringCellValue();



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
	Thread.sleep(2000);
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

 //Find the Advance search link
 Boolean advSrch = driver.findElements(By.id("advSrch_grid_agreement")).size() >0;

if ( ! advSrch)
{
	sheet1.getRow(10).createCell(9).setCellValue("FAILED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advanced Search Link' was NOT Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(10).createCell(9).setCellValue("PASSED");
	sheet1.getRow(10).createCell(8).setCellValue("'Advance Search Link' was Displayed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
    driver.findElement(By.id("advSrch_grid_agreement")).click();
    Thread.sleep(2000);
}

//Find the Advance search link and click the link
 Boolean advSrch1 = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrch1)
{
	sheet1.getRow(11).createCell(9).setCellValue("FAILED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advanced Search Link' was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(11).createCell(9).setCellValue("PASSED");
	sheet1.getRow(11).createCell(8).setCellValue("'Advance Search Link' was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
}


//Find the Advance search link and click the link
 Boolean advSrchFilter = driver.findElements(By.id("drill_grid_agreement")).size() >0;

if ( ! advSrchFilter)
{
	sheet1.getRow(12).createCell(9).setCellValue("FAILED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(12).createCell(9).setCellValue("PASSED");
	sheet1.getRow(12).createCell(8).setCellValue("Advanced Search 'Filter By' was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("drill_grid_agreement")).clear();
	Thread.sleep(1000);
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
}

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(EndDate));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(EndDate))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter End Date
 Boolean EndDateOperator = driver.findElements(By.linkText(String.valueOf(EndDate))).size() >0;
	
if ( ! EndDateOperator)
{
	sheet1.getRow(13).createCell(9).setCellValue("FAILED");
	sheet1.getRow(13).createCell(8).setCellValue("End Date Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(13).createCell(9).setCellValue("PASSED");
	sheet1.getRow(13).createCell(8).setCellValue("End Date Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Within");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__EndDate"))).selectByVisibleText("Within Last");
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Estimated_CF_Agreement_Value));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Estimated_CF_Agreement_Value))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Estimated_CF_Agreement_Value
 Boolean Estimated_CF_Agreement_ValueOperator = driver.findElements(By.linkText(String.valueOf(Estimated_CF_Agreement_Value))).size() >0;
	
if ( ! Estimated_CF_Agreement_ValueOperator)
{
	sheet1.getRow(14).createCell(9).setCellValue("FAILED");
	sheet1.getRow(14).createCell(8).setCellValue("Estimated_CF_Agreement_Value Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(14).createCell(9).setCellValue("PASSED");
	sheet1.getRow(14).createCell(8).setCellValue("Estimated_CF_Agreement_Value Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Estimated_CF_Agreement_Value"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(ID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ParentAgreementNumber
 Boolean IDOperator = driver.findElements(By.linkText(String.valueOf(ID))).size() >0;

if ( ! IDOperator)
{
	sheet1.getRow(15).createCell(9).setCellValue("FAILED");
	sheet1.getRow(15).createCell(8).setCellValue("ID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(15).createCell(9).setCellValue("PASSED");
	sheet1.getRow(15).createCell(8).setCellValue("ID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__id"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ParentAgreementNumber));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(ParentAgreementNumber))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Parent Agreement Number
 Boolean ParentAgreementNumberOperator = driver.findElements(By.linkText(String.valueOf(ParentAgreementNumber))).size() >0;
		
if ( ! ParentAgreementNumberOperator)
{
	sheet1.getRow(16).createCell(9).setCellValue("FAILED");
	sheet1.getRow(16).createCell(8).setCellValue("Parent Agreement Number Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(16).createCell(9).setCellValue("PASSED");
	sheet1.getRow(16).createCell(8).setCellValue("Parent Agreement Number Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__ParentAgreementNumber"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(PostalCode));
Thread.sleep(2000);
driver.findElement(By.linkText(String.valueOf(PostalCode))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Postal Code
 Boolean PostalCodeOperator = driver.findElements(By.linkText(String.valueOf(PostalCode))).size() >0;
			
if ( ! PostalCodeOperator)
{
	sheet1.getRow(17).createCell(9).setCellValue("FAILED");
	sheet1.getRow(17).createCell(8).setCellValue("PostalCode Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(17).createCell(9).setCellValue("PASSED");
	sheet1.getRow(17).createCell(8).setCellValue("PostalCode Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__PostalCode"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Program_Level));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Program_Level))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Program_Level
 Boolean Program_LevelOperator = driver.findElements(By.linkText(String.valueOf(Program_Level))).size() >0;
			
if ( ! Program_LevelOperator)
{
	sheet1.getRow(18).createCell(9).setCellValue("FAILED");
	sheet1.getRow(18).createCell(8).setCellValue("Program_Level Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(18).createCell(9).setCellValue("PASSED");
	sheet1.getRow(18).createCell(8).setCellValue("Program_Level Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__cf_program_level__Description"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Region));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Region))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Region
 Boolean RegionOperator = driver.findElements(By.linkText(String.valueOf(Region))).size() >0;
			
if ( ! RegionOperator)
{
	sheet1.getRow(19).createCell(9).setCellValue("FAILED");
	sheet1.getRow(19).createCell(8).setCellValue("Region Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(19).createCell(9).setCellValue("PASSED");
	sheet1.getRow(19).createCell(8).setCellValue("Region Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Region"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(StartDate));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(StartDate))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter StartDate
 Boolean StartDateOperator = driver.findElements(By.linkText(String.valueOf(StartDate))).size() >0;
			
if ( ! StartDateOperator)
{
	sheet1.getRow(20).createCell(9).setCellValue("FAILED");
	sheet1.getRow(20).createCell(8).setCellValue("StartDate Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(20).createCell(9).setCellValue("PASSED");
	sheet1.getRow(20).createCell(8).setCellValue("StartDate Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}


new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Within");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__StartDate"))).selectByVisibleText("Within Last");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(StateProv));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(StateProv))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter StateProv
	 Boolean StateProvOperator = driver.findElements(By.linkText(String.valueOf(StateProv))).size() >0;
				
	if ( ! StateProvOperator)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("StateProv Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("StateProv Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
	
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Not Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Between");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Starts with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Ends by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Contains");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("In List");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Does not start with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Does not end by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Does not contain");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__StateProv"))).selectByVisibleText("Not in List");
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).clear();
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(TAMFlag));
	Thread.sleep(1000);
	driver.findElement(By.linkText(String.valueOf(TAMFlag))).click();
	Thread.sleep(1000);

	//Find the Advance search filter box and Enter TAMFlag
		 Boolean TAMFlagOperator = driver.findElements(By.linkText(String.valueOf(TAMFlag))).size() >0;
					
		if ( ! TAMFlagOperator)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("TAMFlag Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("TAMFlag Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Greater Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Less Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Greater Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Less Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Not Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__TAMFlag"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
	

//Click the "x" to close the Advanced Search
Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;


if ( ! closeButton)
{
	
	sheet1.getRow(23).createCell(9).setCellValue("FAILED");
	sheet1.getRow(23).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(23).createCell(9).setCellValue("PASSED");
	sheet1.getRow(23).createCell(8).setCellValue("Close Advanced Search was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
	Thread.sleep(3000);
}

//Click the Agreement ID link filter
Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;


if ( ! refreshButton)
{
	
	sheet1.getRow(24).createCell(9).setCellValue("FAILED");
	sheet1.getRow(24).createCell(8).setCellValue("Grid was NOT Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(24).createCell(9).setCellValue("PASSED");
	sheet1.getRow(24).createCell(8).setCellValue("Grid was Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.id("refresh_grid_agreement")).click();
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
