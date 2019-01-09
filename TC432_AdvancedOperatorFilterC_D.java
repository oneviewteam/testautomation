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

public class TC432_AdvancedOperatorFilterC_D {
	
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
XSSFSheet sheet1=wb.getSheet("TC432");
//XSSFSheet sheet2=wb.createSheet("results");


String baseUrl ;
String loginUrl; 
String logoutUrl; 
String testUsername;
String testPassword ;


String category;
String CF_License_Value;
String CFProgramLevelID;
String City;
String Country;
String CustomerSiteID;
String CustomerSiteName;
String CustomerType;
String Days_to_Expiration;
String Disposition;
String Disposition_Code;
String disposition_status;
String DistributorID;
String DistributorName;

//String ID;
//String ParentAgreementNumber;
//String Agreement_Type;
//String StartDate;
//String EndDate;
//String AgreementTypeID;
//String AgreementNumber;
//String Estimated_CF_Agreement_Value;
//String AnnualizedCFValue;
//String TAMFlag;
//String Brand;
//String ActiveFlag;
//String Address;
//String Address2;
//String StateProv;
//String PostalCode;
//String Region;
//String Program_Level;
//String AccountName;
//String agreementUrl;

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

category = sheet1.getRow(3).getCell(10).getStringCellValue();
CF_License_Value = sheet1.getRow(4).getCell(10).getStringCellValue();
CFProgramLevelID = sheet1.getRow(5).getCell(10).getStringCellValue();
City = sheet1.getRow(6).getCell(10).getStringCellValue();
Country = sheet1.getRow(7).getCell(10).getStringCellValue();
CustomerSiteID = sheet1.getRow(8).getCell(10).getStringCellValue();
CustomerSiteName = sheet1.getRow(9).getCell(10).getStringCellValue();
CustomerType = sheet1.getRow(10).getCell(10).getStringCellValue();
Days_to_Expiration = sheet1.getRow(11).getCell(10).getStringCellValue();
Disposition = sheet1.getRow(12).getCell(10).getStringCellValue();
Disposition_Code = sheet1.getRow(13).getCell(10).getStringCellValue();
disposition_status = sheet1.getRow(14).getCell(10).getStringCellValue();
DistributorID = sheet1.getRow(15).getCell(10).getStringCellValue();
DistributorName = sheet1.getRow(16).getCell(10).getStringCellValue();
//AccountName = sheet1.getRow(3).getCell(10).getStringCellValue();
//ActiveFlag = sheet1.getRow(4).getCell(10).getStringCellValue();
//Address = sheet1.getRow(5).getCell(10).getStringCellValue();
//Address2 = sheet1.getRow(6).getCell(10).getStringCellValue();
//Agreement_Type = sheet1.getRow(7).getCell(10).getStringCellValue();
//AgreementNumber = sheet1.getRow(8).getCell(10).getStringCellValue();
//AgreementTypeID = sheet1.getRow(9).getCell(10).getStringCellValue();
//AnnualizedCFValue = sheet1.getRow(10).getCell(10).getStringCellValue();
//Brand = sheet1.getRow(11).getCell(10).getStringCellValue();
//ID = sheet1.getRow(5).getCell(10).getStringCellValue();
//ParentAgreementNumber= sheet1.getRow(7).getCell(10).getStringCellValue();
//StartDate = sheet1.getRow(9).getCell(10).getStringCellValue();
//EndDate = sheet1.getRow(10).getCell(10).getStringCellValue();
//Estimated_CF_Agreement_Value = sheet1.getRow(15).getCell(10).getStringCellValue();
//TAMFlag = sheet1.getRow(18).getCell(10).getStringCellValue();
//StateProv = sheet1.getRow(30).getCell(10).getStringCellValue();
//PostalCode = sheet1.getRow(31).getCell(10).getStringCellValue();
//Region = sheet1.getRow(33).getCell(10).getStringCellValue();
//Program_Level = sheet1.getRow(35).getCell(10).getStringCellValue();



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

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(category));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(category))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ID
 Boolean categoryOperator = driver.findElements(By.linkText(String.valueOf(category))).size() >0;
	
if ( ! categoryOperator)
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

new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__category"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CF_License_Value));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CF_License_Value))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter CustomerSiteID
 Boolean CF_License_ValueOperator = driver.findElements(By.linkText(String.valueOf(CF_License_Value))).size() >0;
	
if ( ! CF_License_ValueOperator)
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

new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CF_License_Value"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CFProgramLevelID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CFProgramLevelID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter ParentAgreementNumber
 Boolean CFProgramLevelIDOperator = driver.findElements(By.linkText(String.valueOf(CFProgramLevelID))).size() >0;

if ( ! CFProgramLevelIDOperator)
{
	sheet1.getRow(15).createCell(9).setCellValue("FAILED");
	sheet1.getRow(15).createCell(8).setCellValue("CFProgramLevelID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(15).createCell(9).setCellValue("PASSED");
	sheet1.getRow(15).createCell(8).setCellValue("CFProgramLevelID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(2000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CFProgramLevelID"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(City));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(City))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Agreement_Type
 Boolean CityOperator = driver.findElements(By.linkText(String.valueOf(City))).size() >0;
		
if ( ! CityOperator)
{
	sheet1.getRow(16).createCell(9).setCellValue("FAILED");
	sheet1.getRow(16).createCell(8).setCellValue("City Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(16).createCell(9).setCellValue("PASSED");
	sheet1.getRow(16).createCell(8).setCellValue("City Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__City"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Country));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Country))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter StartDate
 Boolean CountryOperator = driver.findElements(By.linkText(String.valueOf(Country))).size() >0;
			
if ( ! CountryOperator)
{
	sheet1.getRow(17).createCell(9).setCellValue("FAILED");
	sheet1.getRow(17).createCell(8).setCellValue("Country Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(17).createCell(9).setCellValue("PASSED");
	sheet1.getRow(17).createCell(8).setCellValue("Country Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__Country"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerSiteID));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CustomerSiteID))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter EndDate
 Boolean CustomerSiteIDOperator = driver.findElements(By.linkText(String.valueOf(CustomerSiteID))).size() >0;
			
if ( ! CustomerSiteIDOperator)
{
	sheet1.getRow(18).createCell(9).setCellValue("FAILED");
	sheet1.getRow(18).createCell(8).setCellValue("CustomerSiteID Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(18).createCell(9).setCellValue("PASSED");
	sheet1.getRow(18).createCell(8).setCellValue("CustomerSiteID Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Greater Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Less Than (Strictly)");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Greater Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Less Than or Equal");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Not Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteID"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);


driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerSiteName));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CustomerSiteName))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter CustomerSiteName
 Boolean CustomerSiteNameOperator = driver.findElements(By.linkText(String.valueOf(CustomerSiteName))).size() >0;
			
if ( ! CustomerSiteNameOperator)
{
	sheet1.getRow(19).createCell(9).setCellValue("FAILED");
	sheet1.getRow(19).createCell(8).setCellValue("CustomerSiteName Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(19).createCell(9).setCellValue("PASSED");
	sheet1.getRow(19).createCell(8).setCellValue("CustomerSiteName Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerSiteName"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(CustomerType));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(CustomerType))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter AgreementNumber
 Boolean CustomerTypeOperator = driver.findElements(By.linkText(String.valueOf(CustomerType))).size() >0;
			
if ( ! CustomerTypeOperator)
{
	sheet1.getRow(20).createCell(9).setCellValue("FAILED");
	sheet1.getRow(20).createCell(8).setCellValue("CustomerType Operator filter was NOT found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(20).createCell(9).setCellValue("PASSED");
	sheet1.getRow(20).createCell(8).setCellValue("CustomerType Operator filter was found");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
}

new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Not Equal to");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Between");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Starts with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Ends by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Contains");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("In List");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Does not start with");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Does not end by");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Does not contain");
Thread.sleep(1000);
new Select(driver.findElement(By.id("agreement_view__CustomerType"))).selectByVisibleText("Not in List");
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).clear();
driver.findElement(By.id("drill_grid_agreement")).click();
Thread.sleep(1000);

driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Days_to_Expiration));
Thread.sleep(1000);
driver.findElement(By.linkText(String.valueOf(Days_to_Expiration))).click();
Thread.sleep(1000);

//Find the Advance search filter box and Enter Days_to_Expiration
	 Boolean Days_to_ExpirationOperator = driver.findElements(By.linkText(String.valueOf(Days_to_Expiration))).size() >0;
				
	if ( ! Days_to_ExpirationOperator)
	{
		sheet1.getRow(21).createCell(9).setCellValue("FAILED");
		sheet1.getRow(21).createCell(8).setCellValue("Days_to_Expiration Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(21).createCell(9).setCellValue("PASSED");
		sheet1.getRow(21).createCell(8).setCellValue("Days_to_Expiration Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
	
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Not Equal to");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Greater Than (Strictly)");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Less Than (Strictly)");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Greater Than or Equal");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Less Than or Equal");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Between");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Starts with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Ends by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Contains");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("In List");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Not Between");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Does not start with");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Does not end by");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Does not contain");
	Thread.sleep(1000);
	new Select(driver.findElement(By.id("agreement_view__Days_to_Expiration"))).selectByVisibleText("Not in List");
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).clear();
	driver.findElement(By.id("drill_grid_agreement")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Disposition));
	Thread.sleep(1000);
	driver.findElement(By.linkText(String.valueOf(Disposition))).click();
	Thread.sleep(1000);

	//Find the Advance search filter box and Enter disposition_description
		 Boolean DispositionOperator = driver.findElements(By.linkText(String.valueOf(Disposition))).size() >0;
					
		if ( ! DispositionOperator)
		{
			sheet1.getRow(22).createCell(9).setCellValue("FAILED");
			sheet1.getRow(22).createCell(8).setCellValue("Disposition Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(22).createCell(9).setCellValue("PASSED");
			sheet1.getRow(22).createCell(8).setCellValue("Disposition Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition__description"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(Disposition_Code));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(Disposition_Code))).click();
		Thread.sleep(1000);

//Find the Advance search filter box and Enter Disposition Code
	 Boolean DispositionCodeOperator = driver.findElements(By.linkText(String.valueOf(Disposition_Code))).size() >0;
				
	if ( ! DispositionCodeOperator)
	{
		sheet1.getRow(23).createCell(9).setCellValue("FAILED");
		sheet1.getRow(23).createCell(8).setCellValue("Disposition_Code Operator filter was NOT found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();	
		driver.quit();
	}
	else
	{
		sheet1.getRow(23).createCell(9).setCellValue("PASSED");
		sheet1.getRow(23).createCell(8).setCellValue("Disposition_Code Operator filter was found");
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
	}
			
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_code"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(disposition_status));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(disposition_status))).click();
		Thread.sleep(1000);

	//Find the Advance search filter box and Enter disposition_status
		 Boolean disposition_statusOperator = driver.findElements(By.linkText(String.valueOf(disposition_status))).size() >0;
					
		if ( ! disposition_statusOperator)
		{
			sheet1.getRow(24).createCell(9).setCellValue("FAILED");
			sheet1.getRow(24).createCell(8).setCellValue("disposition_status Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(24).createCell(9).setCellValue("PASSED");
			sheet1.getRow(24).createCell(8).setCellValue("disposition_status Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__disposition_status"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(DistributorID));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(DistributorID))).click();
		Thread.sleep(1000);

	//Find the Advance search filter box and Enter DistributorID
		 Boolean DistributorIDOperator = driver.findElements(By.linkText(String.valueOf(DistributorID))).size() >0;
					
		if ( ! DistributorIDOperator)
		{
			sheet1.getRow(25).createCell(9).setCellValue("FAILED");
			sheet1.getRow(25).createCell(8).setCellValue("DistributorID Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(25).createCell(9).setCellValue("PASSED");
			sheet1.getRow(25).createCell(8).setCellValue("DistributorID Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Greater Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Less Than (Strictly)");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Greater Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Less Than or Equal");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Not Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorID"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).sendKeys(String.valueOf(DistributorName));
		Thread.sleep(1000);
		driver.findElement(By.linkText(String.valueOf(DistributorName))).click();
		Thread.sleep(1000);

	//Find the Advance search filter box and Enter DistributorName
		 Boolean DistributorNameOperator = driver.findElements(By.linkText(String.valueOf(DistributorName))).size() >0;
					
		if ( ! DistributorNameOperator)
		{
			sheet1.getRow(26).createCell(9).setCellValue("FAILED");
			sheet1.getRow(26).createCell(8).setCellValue("DistributorName Operator filter was NOT found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
			wb.close();	
			driver.quit();
		}
		else
		{
			sheet1.getRow(26).createCell(9).setCellValue("PASSED");
			sheet1.getRow(26).createCell(8).setCellValue("DistributorName Operator filter was found");
			FileOutputStream fout=new FileOutputStream(src);
			wb.write(fout);
		}
		
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Not Equal to");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Between");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Starts with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Ends by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Contains");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("In List");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Does not start with");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Does not end by");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Does not contain");
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("agreement_view__DistributorName"))).selectByVisibleText("Not in List");
		Thread.sleep(1000);
		
		driver.findElement(By.id("drill_grid_agreement")).clear();
		driver.findElement(By.id("drill_grid_agreement")).click();
		Thread.sleep(1000);
		
						
	
	

//Click the "x" to close the Advanced Search
Boolean closeButton = driver.findElements(By.xpath("//html/body/div[12]/div[1]/button")).size() >0;


if ( ! closeButton)
{
	
	sheet1.getRow(27).createCell(9).setCellValue("FAILED");
	sheet1.getRow(27).createCell(8).setCellValue("Close Advanced Search was NOT Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(27).createCell(9).setCellValue("PASSED");
	sheet1.getRow(27).createCell(8).setCellValue("Close Advanced Search was Initiated");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	driver.findElement(By.xpath("//html/body/div[12]/div[1]/button")).click();
	Thread.sleep(3000);
}

//Click the Agreement ID link filter
Boolean refreshButton = driver.findElements(By.id("refresh_grid_agreement")).size() >0;


if ( ! refreshButton)
{
	
	sheet1.getRow(28).createCell(9).setCellValue("FAILED");
	sheet1.getRow(28).createCell(8).setCellValue("Grid was NOT Refreshed");
	FileOutputStream fout=new FileOutputStream(src);
	wb.write(fout);
	wb.close();	
	driver.quit();
}
else
{
	sheet1.getRow(28).createCell(9).setCellValue("PASSED");
	sheet1.getRow(28).createCell(8).setCellValue("Grid was Refreshed");
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
