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

public class TC431_AdvancedOperatorFilterA_B {
	
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
XSSFSheet sheet1=wb.getSheet("TC431");
//XSSFSheet sheet2=wb.createSheet("results");


String baseUrl ;
String loginUrl; 
String logoutUrl; 
String testUsername;
String testPassword ;

//String ID;
//String CustomerSiteID;
//String ParentAgreementNumber;
String Agreement_Type;
//String StartDate;
//String EndDate;
String AgreementTypeID;
String AgreementNumber;
//String Days_to_Expiration;
//String CF_License_Value;
//String Estimated_CF_Agreement_Value;
String AnnualizedCFValue;
//String CFProgramLevelID;
//String TAMFlag;
String Brand;
String ActiveFlag;
//String DistributorID;
//String Disposition_Code;
//String Disposition;
//String category;
//String disposition_status;
//String CustomerType;
String Address;
String Address2;
//String City;
//String StateProv;
//String PostalCode;
//String Country;
//String Region;
//String CustomerSiteName;
//String Program_Level;
//String DistributorName;
String AccountName;

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

AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
ActiveFlag = sheet1.getRow(4).getCell(10).getStringCellValue();
Address = sheet1.getRow(5).getCell(10).getStringCellValue();
Address2 = sheet1.getRow(6).getCell(10).getStringCellValue();
Agreement_Type = sheet1.getRow(7).getCell(10).getStringCellValue();
AgreementNumber = sheet1.getRow(8).getCell(10).getStringCellValue();
AgreementTypeID = sheet1.getRow(9).getCell(10).getStringCellValue();
AnnualizedCFValue = sheet1.getRow(10).getCell(10).getStringCellValue();
Brand = sheet1.getRow(11).getCell(10).getStringCellValue();
//ID = sheet1.getRow(5).getCell(10).getStringCellValue();
//CustomerSiteID = sheet1.getRow(6).getCell(10).getStringCellValue();
//ParentAgreementNumber= sheet1.getRow(7).getCell(10).getStringCellValue();

//StartDate = sheet1.getRow(9).getCell(10).getStringCellValue();
//EndDate = sheet1.getRow(10).getCell(10).getStringCellValue();


//Days_to_Expiration = sheet1.getRow(13).getCell(10).getStringCellValue();
//CF_License_Value = sheet1.getRow(14).getCell(10).getStringCellValue();
//Estimated_CF_Agreement_Value = sheet1.getRow(15).getCell(10).getStringCellValue();

//CFProgramLevelID = sheet1.getRow(17).getCell(10).getStringCellValue();
//TAMFlag = sheet1.getRow(18).getCell(10).getStringCellValue();


//DistributorID = sheet1.getRow(21).getCell(10).getStringCellValue();
//Disposition_Code = sheet1.getRow(22).getCell(10).getStringCellValue();
//Disposition = sheet1.getRow(23).getCell(10).getStringCellValue();
//category = sheet1.getRow(24).getCell(10).getStringCellValue();
//disposition_status = sheet1.getRow(25).getCell(10).getStringCellValue();
//CustomerType = sheet1.getRow(26).getCell(10).getStringCellValue();


//City = sheet1.getRow(29).getCell(10).getStringCellValue();
//StateProv = sheet1.getRow(30).getCell(10).getStringCellValue();
//PostalCode = sheet1.getRow(31).getCell(10).getStringCellValue();
//Country = sheet1.getRow(32).getCell(10).getStringCellValue();
//Region = sheet1.getRow(33).getCell(10).getStringCellValue();
//CustomerSiteName = sheet1.getRow(34).getCell(10).getStringCellValue();
//Program_Level = sheet1.getRow(35).getCell(10).getStringCellValue();
//DistributorName = sheet1.getRow(36).getCell(10).getStringCellValue();


// String testQuoteUrl =sheet1.getRow(1).getCell(3).getStringCellValue();


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
	Thread.sleep(2000);
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

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AccountName));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AccountName))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ID
 Boolean AccountNameOperator = driver.findElements(By.linkText(String.valueOf(AccountName))).size() >0;
	
if ( ! AccountNameOperator)
{
	sheet1.getRow(13).createCell(9).setCellValue("FAILED");
	sheet1.getRow(13).createCell(8).setCellValue("Account Name Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(13).createCell(9).setCellValue("PASSED");
	sheet1.getRow(13).createCell(8).setCellValue("Account Name Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AccountName"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(ActiveFlag));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(ActiveFlag))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter CustomerSiteID
 Boolean ActiveFlagOperator = driver.findElements(By.linkText(String.valueOf(ActiveFlag))).size() >0;
	
if ( ! ActiveFlagOperator)
{
	sheet1.getRow(14).createCell(9).setCellValue("FAILED");
	sheet1.getRow(14).createCell(8).setCellValue("Active Flag Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(14).createCell(9).setCellValue("PASSED");
	sheet1.getRow(14).createCell(8).setCellValue("Active Flag Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__ActiveFlag"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Address));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Address))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ParentAgreementNumber
 Boolean AddressOperator = driver.findElements(By.linkText(String.valueOf(Address))).size() >0;

if ( ! AddressOperator)
{
	sheet1.getRow(15).createCell(9).setCellValue("FAILED");
	sheet1.getRow(15).createCell(8).setCellValue("Address Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(15).createCell(9).setCellValue("PASSED");
	sheet1.getRow(15).createCell(8).setCellValue("Address Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Address2));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Address2))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Agreement_Type
 Boolean Address2Operator = driver.findElements(By.linkText(String.valueOf(Address2))).size() >0;
		
if ( ! Address2Operator)
{
	sheet1.getRow(16).createCell(9).setCellValue("FAILED");
	sheet1.getRow(16).createCell(8).setCellValue("Address2 Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(16).createCell(9).setCellValue("PASSED");
	sheet1.getRow(16).createCell(8).setCellValue("Address2 Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Address2"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Agreement_Type));
Thread.sleep(2000);
driver.findElement(By.linkText(String.valueOf(Agreement_Type))).click();
Thread.sleep(2000);

//Find the Advance search filter box and Enter StartDate
 Boolean AgreementTypeOperator = driver.findElements(By.linkText(String.valueOf(Agreement_Type))).size() >0;
			
if ( ! AgreementTypeOperator)
{
	sheet1.getRow(17).createCell(9).setCellValue("FAILED");
	sheet1.getRow(17).createCell(8).setCellValue("Agreement_Type Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(17).createCell(9).setCellValue("PASSED");
	sheet1.getRow(17).createCell(8).setCellValue("Agreement_Type Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__agreement_type__Description"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AgreementNumber));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AgreementNumber))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter EndDate
 Boolean AgreementNumberOperator = driver.findElements(By.linkText(String.valueOf(AgreementNumber))).size() >0;
			
if ( ! AgreementNumberOperator)
{
	sheet1.getRow(18).createCell(9).setCellValue("FAILED");
	sheet1.getRow(18).createCell(8).setCellValue("Agreement Number Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(18).createCell(9).setCellValue("PASSED");
	sheet1.getRow(18).createCell(8).setCellValue("Agreement Number Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementNumber"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AgreementTypeID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AgreementTypeID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter AgreementTypeID
 Boolean AgreementTypeIDOperator = driver.findElements(By.linkText(String.valueOf(AgreementTypeID))).size() >0;
			
if ( ! AgreementTypeIDOperator)
{
	sheet1.getRow(19).createCell(9).setCellValue("FAILED");
	sheet1.getRow(19).createCell(8).setCellValue("AgreementTypeID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(19).createCell(9).setCellValue("PASSED");
	sheet1.getRow(19).createCell(8).setCellValue("AgreementTypeID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__AgreementTypeID"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(AnnualizedCFValue));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(AnnualizedCFValue))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter AgreementNumber
 Boolean AnnualizedCFAgreementValueOperator = driver.findElements(By.linkText(String.valueOf(AnnualizedCFValue))).size() >0;
			
if ( ! AnnualizedCFAgreementValueOperator)
{
	sheet1.getRow(20).createCell(9).setCellValue("FAILED");
	sheet1.getRow(20).createCell(8).setCellValue("Annualized_CF_Agreement_Value Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(20).createCell(9).setCellValue("PASSED");
	sheet1.getRow(20).createCell(8).setCellValue("Annualized_CF_Agreement_Value Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Not Equal to");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Starts with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Ends by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Contains");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("In List");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Not Between");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Does not start with");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Does not end by");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Does not contain");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__Annualized_CF_Agreement_Value"))).selectByVisibleText("Not in List");
Thread.sleep(2000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Brand));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Brand))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Days_to_Expiration
	 Boolean BrandOperator = driver.findElements(By.linkText(String.valueOf(Brand))).size() >0;
				
	if ( ! BrandOperator)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("Brand Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("Brand Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
	
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Equal to");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Not Equal to");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Between");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Starts with");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Ends by");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Contains");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("In List");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Does not start with");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Does not end by");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Does not contain");
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("agreement_view__Source"))).selectByVisibleText("Not in List");
	Thread.sleep(2000);
	
	driver.findElement(By.id("drill_grid_agreement")).clear();
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
	
	
	

//Click the "x" to close the Advanced Search
Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;


if ( ! closeButton)
{
	
	sheet1.getRow(22).createCell(9).setCellValue("FAILED");
	sheet1.getRow(22).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(22).createCell(9).setCellValue("PASSED");
	sheet1.getRow(22).createCell(8).setCellValue("Close Advanced Search was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
	Thread.sleep(3000);
}

//Click the Agreement ID link filter
Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;


if ( ! refreshButton)
{
	
	sheet1.getRow(23).createCell(9).setCellValue("FAILED");
	sheet1.getRow(23).createCell(8).setCellValue("Grid was NOT Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(23).createCell(9).setCellValue("PASSED");
	sheet1.getRow(23).createCell(8).setCellValue("Grid was Refreshed");
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
