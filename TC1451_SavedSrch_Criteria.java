package lenovoAutomation;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.log4testng.Logger;
import java.io.*;





@SuppressWarnings("serial")
public class TC1451_SavedSrch_Criteria extends WebDriverException { //1
	

//WebDriver driver;
	public Select selenium;
	public static WebDriver driver;
	private static final PrintStream originalSystemOut = System.out;
	
	static TC1441_AdvancedSrch_Criteria systemOutToLogger;


	

	static Logger logger = Logger.getLogger(TC1451_SavedSrch_Criteria.class);
	

	//@Test(priority=0)
	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException, UnexpectedTagNameException, ElementNotInteractableException { //2
	
	//@SuppressWarnings({ "resource", "deprecation" })
	//@Test(priority=1)
	//public static void AdvancedSrch_Criteria() throws InterruptedException, IOException, FileNotFoundException, UnexpectedTagNameException {
		//super(String.format("Element should have been \"select\" but was \"span\", expectedTagName, actualTagName));"
		
		// Creating a File object that represents the disk file.
	    PrintStream o = new PrintStream(new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Log Files\\Exception Log.txt"));

	    // Store current System.out before assigning a new value
	    //PrintStream console = System.out;

	    // Assign o to output stream
	   // System.setOut(o);

		logger.info("Entering application.");
	     
	     logger.info("Exiting application.");
	
	
	//System.setProperty("webdriver.gecko.driver", "C:\\mmi_automation\\mmi_Lenovo_ auto_testing\\bin\\geckodriver.exe");
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver=new FirefoxDriver();
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	//Maximize the browser window
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	/*FileOutputStream fos = new FileOutputStream(new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\exception.txt"), true);  
	PrintStream ps = new PrintStream(fos);  
	printstacktrace(ps);*/
	
	
	
//----------------------------------------------------------------------------------------------------------------------
				File dir = new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\");
					
				String[] extensions = new String[] { "xlsx" , "txt" , "csv" };
				System.setOut(o);
				System.out.println("Getting all files in " + dir.getCanonicalPath()
						+ " including those in subdirectories");
				List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
				for (File file : files) 
			{ //3
					System.setOut(o);
					System.out.println("The file path is: " + file.getCanonicalPath());
					System.setOut(o);
					System.out.println("The file name is: " + file.getName());
					
					  String extension = "";
					  
				        try {
				            if (file != null && file.exists()) {
				                String name = file.getName();
				                extension = name.substring(name.lastIndexOf("."));
				            }
				        } catch (Exception e1) {
				            extension = "";
				        }
				        
				        if(extension == "xlsx") 
				        {
				        System.setOut(o);
				        System.out.println("File Extension " + extension + " is not correct");
				        System.out.println("The Automation script has stopped. Please check the file!");
				        }
				        else
				        {
				        System.setOut(o);
					    System.out.println("File Extension " + extension + " is correct");
					           
				        }
				        
				        
				
				String Template = "Reports_Saved_Search.xlsx";
					
				File src = new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\"+ Template);
				
				
				/*String path =  "C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\Reports_Advanced_Search";
				java.io.File file1 = new java.io.File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\"+ Template +".xlsx");
				String ext = Files.getFileExtension(path);
				String filename = Files.getNameWithoutExtension(path);*/
				//String exists = Files.isReadable(src);
				
				FileInputStream fis = new FileInputStream(src);
				
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				
				XSSFSheet mySheet = wb.getSheet("TC1451");
				
				XSSFRow row = null;
			//-----------------------------------------------------------------------------------------------------------------------------------	
				
				//Print pop up message
				//CustomPrintStream printStream = new CustomPrintStream();  
			    //System.setOut(printStream);  
				
				/*BufferedReader br = new BufferedReader(new FileReader("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\data\\Report_Columns1.csv"));
				
				if (br.readLine() == null ) {
				    System.out.println("The file provided is empty");
				}*/
				
					
				//Check the file name and make sure it is the template path
				//if(Template == "Reports_Advanced_Search")     
				  if(file.getName() == Template)      
				//if(src.exists() && !src.isDirectory())
			        
				{
					mySheet.getRow(3).createCell(10).setCellValue("FAILED");
					mySheet.getRow(3).createCell(8).setCellValue("The File " + file.getName() + " is NOT the correct Template");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					System.setOut(o);
					System.out.println("File provided is not Correct");
					//wb.close();	
					driver.quit();
				}
			
				else 
				{
					
					mySheet.getRow(3).createCell(9).setCellValue("PASSED");
					mySheet.getRow(3).createCell(8).setCellValue("The File " + file.getName() + " is the CORRECT Template");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					System.setOut(o);
					System.out.println("The file name is: " + file.getName());
					Thread.sleep(1000);
				}
					
				
				//Check the file Extension and make sure it is XLSX
				if(extension == "xlsx")
			        
				{
					mySheet.getRow(4).createCell(10).setCellValue("FAILED");
					mySheet.getRow(4).createCell(8).setCellValue("The File extension is not: .XLSX");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					System.setOut(o);
					System.out.println("File Extension is not a valid .xlsx");
					//wb.close();	
					driver.quit();
				}
			
				else 
					
				{
					mySheet.getRow(4).createCell(9).setCellValue("PASSED");
					mySheet.getRow(4).createCell(8).setCellValue("The File extension is: " + extension);
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					System.setOut(o);
					System.out.println("File Extension is " + extension);
					Thread.sleep(1000);
				}
				
				//Check the file length and make sure it has data
				//if(src.length() == 0)
				int limit = 4000;
			    if(File.separatorChar < limit && FileUtils.readFileToString(src).trim().isEmpty())
				
			    
				{
					mySheet.getRow(5).createCell(10).setCellValue("FAILED");
					mySheet.getRow(5).createCell(8).setCellValue("The File provided is empty");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
			
				else 
				{
					mySheet.getRow(5).createCell(9).setCellValue("PASSED");
					mySheet.getRow(5).createCell(8).setCellValue("The File provided size is: " + file.length());
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(1000);
				}
				
				
				XSSFSheet sheet2 = wb.getSheet("TC1451_SavedSrch");
				row = sheet2.getRow(0);
				int colCount = row.getLastCellNum();
				
				//Check the file columns and obtain the file count
				if(colCount == 0)
			    
				{
					mySheet.getRow(6).createCell(10).setCellValue("FAILED");
					mySheet.getRow(6).createCell(8).setCellValue("The File provided has ZERO Columns");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
			
				else 
				{
					mySheet.getRow(6).createCell(9).setCellValue("PASSED");
					mySheet.getRow(6).createCell(8).setCellValue("Column Count: " + colCount);
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(2000);
				}
				
				
				int rowCount=sheet2.getLastRowNum();
				//Check the file columns and obtain the file count
				if(colCount == 0)
			    
				{
					mySheet.getRow(7).createCell(10).setCellValue("FAILED");
					mySheet.getRow(7).createCell(8).setCellValue("The File provided has ZERO Rows");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
			
				else 
				{
					mySheet.getRow(7).createCell(9).setCellValue("PASSED");
					mySheet.getRow(7).createCell(8).setCellValue("Row Count: " + rowCount);
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					Thread.sleep(2000);
				}
			
			
					
				
				String baseUrl ;
				String loginUrl; 
				String logoutUrl; 
				String testUsername;
				String testPassword;
				
					
				baseUrl = mySheet.getRow(1).getCell(0).getStringCellValue();
				logoutUrl = baseUrl + "/auth/logout"; 
				loginUrl = baseUrl + "/auth/login"; 
				testUsername = mySheet.getRow(1).getCell(1).getStringCellValue();
				testPassword = mySheet.getRow(1).getCell(2).getStringCellValue();
				
				
				
				driver.get(logoutUrl);
				Thread.sleep(2000);
				driver.get(loginUrl);
				Thread.sleep(2000);
				
				//Find the Language drop down and select English
				boolean languageResult = driver.findElements(By.id("language_select")).size()>0; 
				
				if(! languageResult)
			         
			    {
					mySheet.getRow(8).createCell(10).setCellValue("FAILED");
					mySheet.getRow(8).createCell(8).setCellValue("Language was NOT Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//wb.close();	
					driver.quit();
				}
			
				else 
				{
					mySheet.getRow(8).createCell(9).setCellValue("PASSED");
					mySheet.getRow(8).createCell(8).setCellValue("Language was Selected");
					FileOutputStream fout=new FileOutputStream(src);
					wb.write(fout);
					//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Español");
					//Thread.sleep(1000);
					//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Italiano");
					//Thread.sleep(1000);
					//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Indonesia");
					//Thread.sleep(1000);
					//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Deutsche");
					//Thread.sleep(1000);
					//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Português");
					//Thread.sleep(1000);
					//new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("Melayu");
					//Thread.sleep(1000);
					new Select(driver.findElement(By.id("language_select"))).selectByVisibleText("English");
					Thread.sleep(2000);
					
				}
			
					//find the email text box and send the email id
					boolean actualResult = driver.findElements(By.id("email")).size()>0; 
					
					if(! actualResult)
				         
			        {
						mySheet.getRow(9).createCell(10).setCellValue("FAILED");
						mySheet.getRow(9).createCell(8).setCellValue("Username was NOT Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
			
					else 
					{
						mySheet.getRow(9).createCell(9).setCellValue("PASSED");
						mySheet.getRow(9).createCell(8).setCellValue("Username was Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("email")).click();
						Thread.sleep(2000);
						driver.findElement(By.id("email")).sendKeys(testUsername);
						Thread.sleep(2000);
					}
			
					//Find the password text box and send the password id
					boolean actualResult1 = driver.findElements(By.id("password-text")).size()>0; 
					
					if(! actualResult1)
				          
			        {
						mySheet.getRow(10).createCell(10).setCellValue("FAILED");
						mySheet.getRow(10).createCell(8).setCellValue("Password was NOT Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
			
					else 
					{
						mySheet.getRow(10).createCell(9).setCellValue("PASSED");
						mySheet.getRow(10).createCell(8).setCellValue("Password was Input");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("password-text")).sendKeys(testPassword);
						Thread.sleep(2000);
					}
					
					//Click the Login button and wait for Login
					boolean actualResult2 = driver.findElements(By.id("Login")).size()>0; 
					
					if(! actualResult2)
				         
					{
						mySheet.getRow(11).createCell(10).setCellValue("FAILED");
						mySheet.getRow(11).createCell(8).setCellValue("Login button NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						driver.quit();
					}
			
					else 
					{
						mySheet.getRow(11).createCell(9).setCellValue("PASSED");
						mySheet.getRow(11).createCell(8).setCellValue("login button was found and clicked");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("Login")).click();
						Thread.sleep(20000);
					}
						
					//find the Reports Dash board tab
					boolean actualResult3 =  driver.findElements(By.id("cookie-bar")).size() >0;
					
					if(! actualResult3)
					{
						mySheet.getRow(12).createCell(10).setCellValue("FAILED");
						mySheet.getRow(12).createCell(8).setCellValue("Dashboard was not displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
						
					}
					else
					{
						mySheet.getRow(12).createCell(9).setCellValue("PASSED");
						mySheet.getRow(12).createCell(8).setCellValue("Dashboard was found and displayed");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						Thread.sleep(4000);
						
					}
					
					//Loop through all sheets in workbook
					for (int i = 1; i < wb.getNumberOfSheets(); i++) 
					{//4
						
						XSSFSheet dataSheet = wb.getSheetAt(i);
						System.setOut(o);
						System.out.println(dataSheet.getSheetName());
						Thread.sleep(1000);
						System.setOut(o);
						System.out.println("Number of sheets in this workbook: " + wb.getNumberOfSheets());
						String reportName;
						String reportSection;
						reportName = dataSheet.getRow(1).getCell(1).getStringCellValue();
						reportSection = dataSheet.getRow(1).getCell(0).getStringCellValue();
						
						
				{//5
							int rownum = 1;
							while(! reportName.equals(""))
						
				{//6
							
					
					//Click on the Reports Tab
					boolean reportsTab =  driver.findElements(By.id("topmenuitem_4")).size() >0;
					
					if( ! reportsTab)
					{
						mySheet.getRow(13).createCell(10).setCellValue("FAILED");
						mySheet.getRow(13).createCell(8).setCellValue("Reports Tab menu was NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
			
					}
					else
					{
						mySheet.getRow(13).createCell(9).setCellValue("PASSED");
						mySheet.getRow(13).createCell(8).setCellValue("Reports Tab menu was found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("topmenuitem_4")).click();
						Thread.sleep(4000);
					}
					
							
					//Click on the Reports Tab
					boolean reportsDashTab =  driver.findElements(By.linkText("Report Dashboard")).size() >0;
					
					if( ! reportsDashTab)
					{
						mySheet.getRow(14).createCell(10).setCellValue("FAILED");
						mySheet.getRow(14).createCell(8).setCellValue("Reports Dashboard link was NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
			
					}
					else
					{
						mySheet.getRow(14).createCell(9).setCellValue("PASSED");
						mySheet.getRow(14).createCell(8).setCellValue("Reports Dashboard link was found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.linkText("Report Dashboard")).click();
						Thread.sleep(10000);
						
					}
					
			
			       	//Find the Favorite Reports drop down and click
					if(driver.findElements(By.id("tabs_scroll_toggle")).size()>0) {
						
						driver.findElement(By.id("tabs_scroll_toggle")).click();
						 Thread.sleep(3000);
						 
						 driver.findElement(By.id("tabs_scroll_toggle")).click();
						 Thread.sleep(3000);}
					
					
					
						
					
					jse.executeScript("window.scrollBy(0,500)", "");
					Thread.sleep(4000);
					
					
					//Click on the Reports Tab
					boolean reportsSection =  driver.findElements(By.linkText(String.valueOf(reportSection))).size() >0;
					
					if( ! reportsSection)
					{
						mySheet.getRow(15).createCell(10).setCellValue("FAILED");
						mySheet.getRow(15).createCell(8).setCellValue("Reports Section '" + String.valueOf(reportSection) + "' was NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
			
					}
					else
					{
						mySheet.getRow(15).createCell(9).setCellValue("PASSED");
						mySheet.getRow(15).createCell(8).setCellValue("Reports Section '" + String.valueOf(reportSection) + "' was found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//driver.findElement(By.linkText(String.valueOf(reportSection))).click();
						Thread.sleep(8000);
					}
					
				
					EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
					eventFiringWebDriver.executeScript("document.getElementById('ui-id-6').scrollTop=600");
					Thread.sleep(4000);
					
								
					 //Find the Reports Section Drop down Menu
					 boolean selectedReport = driver.findElements(By.linkText(String.valueOf(reportName))).size() >0;
					
					if ( ! selectedReport)
					{
						mySheet.getRow(16).createCell(10).setCellValue("FAILED");
						mySheet.getRow(16).createCell(8).setCellValue("Report '" + String.valueOf(reportName) + "' was NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						mySheet.getRow(16).createCell(9).setCellValue("PASSED");
						mySheet.getRow(16).createCell(8).setCellValue("Report '" + String.valueOf(reportName) + "' was found and Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						driver.findElement(By.id("ui-id-6")).findElement(By.linkText(String.valueOf(reportName))).click();
						Thread.sleep(6000);	
						
						//driver.findElement(By.linkText(String.valueOf(reportName))).click();
						//((JavascriptExecutor)driver).executeScript("arguments[0].click();", String.valueOf(reportName));
						//WebElement element = driver.findElement(By.linkText(String.valueOf(reportName)));
						//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
						//driver.switch_to.frame(driver.findElement(By.id("frame_id")));
					}
					
					//String showReport = driver.findElement(By.linkText(String.valueOf(reportName))).getAttribute("id");
							String showReport = driver.findElement(By.id("ui-id-6")).findElement(By.linkText(String.valueOf(reportName))).getAttribute("id");
							String parts[] = showReport.split("showreport_");
							String reportParsed = parts[1];
							System.setOut(o);
							System.out.println(reportParsed);
						
					//Find the Advanced Filter search and find attributes
					boolean columnAsset = driver.findElements(By.linkText("Advanced Search")).size() >0;
					
					if ( ! columnAsset)
					{
						mySheet.getRow(17).createCell(10).setCellValue("FAILED");
						mySheet.getRow(17).createCell(8).setCellValue("Advanced Search Link was NOT Found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						mySheet.getRow(17).createCell(9).setCellValue("PASSED");
						mySheet.getRow(17).createCell(8).setCellValue("Advanced Search Link was Found and Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						WebElement element1 = driver.findElement(By.linkText("Advanced Search"));
				        Actions action1 = new Actions(driver);
				        action1.moveToElement(element1).build().perform();
						Thread.sleep(2000);
						driver.findElement(By.linkText("Advanced Search")).click();
						Thread.sleep(8000);
					} 
					
						
					String reportField = dataSheet.getRow(rownum).getCell(2).getStringCellValue();
					String reportOperator = dataSheet.getRow(rownum).getCell(3).getStringCellValue();
					//reportValue = dataSheet.getRow(rownum).getCell(4).getStringCellValue();
					
					 //Find the General Reports Drop down Menu
					 boolean fieldsInput = driver.findElements(By.id("accordion")).size() >0;
					 
					 
					if ( ! fieldsInput)
					{
						mySheet.getRow(18).createCell(10).setCellValue("FAILED");
						mySheet.getRow(18).createCell(8).setCellValue("Report Field '" + String.valueOf(reportField) + "' was NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						mySheet.getRow(18).createCell(9).setCellValue("PASSED");
						mySheet.getRow(18).createCell(8).setCellValue("Report Field '" + String.valueOf(reportField) + "' was found and Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						WebElement element1 = driver.findElement(By.linkText(String.valueOf(reportField)));
				        Actions action1 = new Actions(driver);
				        action1.moveToElement(element1).build().perform();
						Thread.sleep(2000);
						//driver.findElement(By.id("accordion")).findElement(By.linkText(String.valueOf(reportField))).click();
						driver.findElement(By.linkText(String.valueOf(reportField))).click();
						Thread.sleep(3000);	
					}
					
				
					 //Find the General Reports Operator Drop down Menu
					 boolean dropDown = driver.findElements(By.id("condition_builder_operatorreport-" + reportParsed)).size() >0;
					 //Boolean dropDown = driver.findElements(By.id("assetasset_id")).size() >0;
					 
					 
					if ( ! dropDown)
					{
						mySheet.getRow(19).createCell(10).setCellValue("FAILED");
						mySheet.getRow(19).createCell(8).setCellValue("Operator Dropdown " + reportOperator + " was NOT found");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						mySheet.getRow(19).createCell(9).setCellValue("PASSED");
						mySheet.getRow(19).createCell(8).setCellValue("Operator Dropdown " + reportOperator + " was found and Initiated");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						WebElement element1 = driver.findElement(By.id("condition_builder_operatorreport-" + reportParsed));
						//WebElement element1 = driver.findElement(By.id(String.valueOf(fieldDropDown)));
				        Actions action1 = new Actions(driver);
				        action1.moveToElement(element1).build().perform();
						Thread.sleep(2000);
						//((ISelect) driver.findElement(By.cssSelector("span > select"))).selectByVisibleText(String.valueOf(operator1));
						//driver.findElement(By.xpath("//span/select")).click();
						//Thread.sleep(2000);
						//new Select(driver.findElement(By.xpath("//span/select"))).selectByVisibleText(String.valueOf(operator1));
						//driver.findElement(By.id("condition_builder_operatorreport-" + reportParsed)).findElement(By.xpath("//select")).click();
						//Thread.sleep(2000);
						//new Select(driver.findElement(By.id("condition_builder_operatorreport-" + reportParsed))).selectByVisibleText(String.valueOf(operator1));
						//new Select(driver.findElement(By.id("condition_builder_operatorreport-" + reportParsed))).selectByValue(String.valueOf(operator1));
						//((Select) ((WebDriver) new Select(driver.findElement(By.id("condition_builder_operatorreport-" + reportParsed)))).findElement(By.xpath("//select"))).selectByVisibleText(String.valueOf(operator1));
						//driver.findElement(By.id("condition_builder_operatorreport-" + reportParsed)).sendKeys(String.valueOf(operator1));
						
					}
					
					String fieldDropDown = driver.findElement(By.id("condition_builderreport-" + reportParsed)).findElement(By.xpath("//span/select")).getAttribute("id");
					//String parts[] = showReport.split("showreport_");
					//String reportParsed = parts[1];
					System.setOut(o);
					System.out.println(fieldDropDown);
					
							
					 //Find the General Reports Drop down Menu
					 boolean fieldSelect = driver.findElements(By.xpath("//span/select")).size() >0;
					 
					 
					if ( ! fieldSelect)
					{
						mySheet.getRow(20).createCell(10).setCellValue("FAILED");
						mySheet.getRow(20).createCell(8).setCellValue("Report Field '" + String.valueOf(reportField) + "' was NOT Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						//wb.close();	
						//driver.quit();
					}
					else
					{
						mySheet.getRow(20).createCell(9).setCellValue("PASSED");
						mySheet.getRow(20).createCell(8).setCellValue("Report Field '" + String.valueOf(reportField) + "' was found and Selected");
						FileOutputStream fout=new FileOutputStream(src);
						wb.write(fout);
						new Select(driver.findElement(By.id(String.valueOf(fieldDropDown)))).selectByVisibleText(String.valueOf(reportOperator));
						Thread.sleep(3000);
					
					}
					
					// Locate all input tags on the page
					/*WebElement someElement = (WebElement) driver.findElements(By.cssSelector("input")); 
					String typeOfElement = someElement.getAttribute("type"); 
					System.out.println(typeOfElement);*/
			
					/*String inputBox1 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.cssSelector("input[type='text']")).getAttribute("id");
					System.setOut(o);
					System.out.println(inputBox1);
					
					String inputBox2 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.cssSelector("input[type='text']")).getAttribute("id");
					System.setOut(o);
					System.out.println(inputBox2);*/
					
							
					//String value1;
					//String value1 = dataSheet.getRow(rownum).getCell(4).getStringCellValue();
					//action.moveToElement(mnuElement).clickAndHold(submnuElement).click().build().perform();
					
					
					String list = dataSheet.getRow(rownum).getCell(4).toString();
					
					try {
					    list = dataSheet.getRow(rownum).getCell(4).getStringCellValue();
					} catch (NumberFormatException ex) {
						list = dataSheet.getRow(rownum).getCell(4).getNumericCellValue() + "";
					}
					
						
					//String[] items = list.split("\\p{Punct}");
					//String[] items = list.split("\\s");
					String [] items = list.split(", ");
					
				
					List<String> aList = Arrays.asList(items);
					System.out.println("aList = " + aList);
					//StringBuilder formatted = new StringBuilder();
					
					//new java.text.DecimalFormat("0").format(items.toString());
					
					/*for (String s : list.split(",")) {
					    selItemArrayList.add(s.trim());
					}*/
					
						/*{
						    formatted.append(items[L].trim());
						    if (L < items.length - 1) formatted.append(',');
						}*/
					
					//boolean dropdownMonth = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElements(By.className("searchElm")).size() >0;
					String dropdown1_1 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.className("searchElm")).getAttribute("id");
					String dropdown1_2[] = dropdown1_1.split("1_1");
					String dropdownParsed1 = dropdown1_2[0];
					System.out.println(dropdownParsed1 + "1_1");
					
					/*boolean inputBox111 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElements(By.cssSelector("input[type='text']")).size() >0;
					String inputBox1_2 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.cssSelector("input[type='text']")).getAttribute("id");
					String inputParts1[] = inputBox1_2.split("1_1");
					String inputParsed1 = inputParts1[0];
					System.out.println(inputParsed1);*/
			
			
			//-----------------------------------------------------------------------------------------------------------------------		
				
					//Find the Reports Value Input Box
					boolean inputBox = driver.findElements(By.id("condition_builder_valreport-" + reportParsed)).size() >0;
							
					
					for (int L = 0; L < items.length; L++) 
						
						
						
				{
						
						System.out.println(items[L].toString());
						//System.out.println(items[L]);
						
						boolean addPresence = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isDisplayed();
				        boolean addEnabled = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isEnabled();
				        //boolean addSize = driver.findElements(By.id("addConditionreport-" + reportParsed)).size() >0;
				        
				        boolean linkPresence = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isDisplayed();
					    boolean linkEnabled = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isEnabled();	
				        boolean linkSize = driver.findElements(By.id("auto_completereport-" + reportParsed)).size() >0;
							
						 
						 
						if ( ! inputBox )
						{
							mySheet.getRow(21).createCell(10).setCellValue("FAILED");
							mySheet.getRow(21).createCell(8).setCellValue("Value Input Box was NOT found");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//wb.close();	
							//driver.quit();
						}
							
						//Set<String> names2 = new HashSet<String>(Arrays.asList(new String[] {"1 Month", "2 Months", "3 Months", "4 Months", "5 Months", "6 Months", "7 Months", "8 Months", "9 Months", "10 Months", "11 Months", "12 Months", "24 Months", "36 Months"}));
						Set<String> names = new HashSet<String>(Arrays.asList(new String[] {"Within", "Within Last", "Prior To"}));
						/*names.add("Within");
						names.add("Within Last");
						names.add("Prior To");*/
						String reportOperator1 = dataSheet.getRow(rownum).getCell(3).getStringCellValue();
						
						if (names.contains(reportOperator1))
													
						{
							//String dropdownBox1_1 = driver.findElement(By.id("condition_builderreport-" + reportParsed)).findElement(By.cssSelector("span > span")).getAttribute("id");
							String dropdownBox1_1 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.className("searchElm")).getAttribute("id");
							String dropdownParts[] = dropdownBox1_1.split("1_1");
							String dropdownParsed0 = dropdownParts[0];
							
							System.setOut(o);
							System.out.println(dropdownBox1_1);
							System.out.println(dropdownParsed0);
							
							WebElement element2 = driver.findElement(By.id(String.valueOf(dropdownBox1_1)));
							//WebElement element2 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.xpath("//select[@label=" + items[L]));
					        Actions action1 = new Actions(driver);
					        action1.moveToElement(element2).build().perform();
							Thread.sleep(2000);
							element2.click();
							Thread.sleep(2000);
							new Select(driver.findElement(By.id(String.valueOf(dropdownBox1_1)))).selectByVisibleText(String.valueOf(items[L]));
							//new Select(driver.findElement(By.id(dropdownParsed0 + "1_1"))).selectByVisibleText(String.valueOf(reportOperator));
							Thread.sleep(2000);
							
							//verify that the “Add” is displayed/enabled and click
					 			
					        if(addPresence == true && addEnabled == true)
							{
					        	WebElement addButton1 = driver.findElement(By.id("addConditionreport-" + reportParsed));
					        	addButton1.click();
								 Thread.sleep(3000);
								 }
							
						}
						
				
						else
							//if(driver.findElement(By.id(inputParsed1 + "1_1"))
						{
							String inputBox1_1 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.cssSelector("input[type='text']")).getAttribute("id");
							String inputParts[] = inputBox1_1.split("1_1");
							String inputParsed0 = inputParts[0];
							//String inputParsed1 = inputParts[1];
							System.setOut(o);
							System.out.println(inputParsed0);
							
							//boolean secondBox = driver.findElements(By.id(inputParsed0 + "2_1")).size() >0;
							//boolean secondBox1 = ((WebElement) driver.findElement(By.id(inputParsed0 + "2_1"))).isEnabled();
							
							
							mySheet.getRow(21).createCell(9).setCellValue("PASSED");
							mySheet.getRow(21).createCell(8).setCellValue("Value Input/Dropdown Box was found and Selected");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//WebElement element1 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed));
							WebElement element1 = driver.findElement(By.id(inputParsed0 + "1_1"));
					        Actions action1 = new Actions(driver);
					        action1.moveToElement(element1).build().perform();
							Thread.sleep(4000);
							element1.click();
							Thread.sleep(2000);
							element1.sendKeys(String.valueOf(items[L]));
							Thread.sleep(8000);
							
											
	
							
				String regex = "((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])";
							
				Matcher matcher = Pattern.compile(regex).matcher(items[L]);
						
				if (matcher.matches() && driver.findElements(By.id(inputParsed0 + "2_1")).size() >0) 
						
				{
					String inputBox1_11 = driver.findElement(By.id("condition_builder_valreport-" + reportParsed)).findElement(By.cssSelector("input[type='text']")).getAttribute("id");
					String inputParts1[] = inputBox1_11.split("1_1");
					String inputParsed01 = inputParts1[0];
					
					
						System.setOut(o);
						System.out.println(matcher.group(1) + " - " + matcher.group(2) + " - " + matcher.group(3));
							  
					
						L++;
						
						WebElement Box2 = driver.findElement(By.id(inputParsed01 + "2_1"));
				     	Box2.click();
				     	Box2.sendKeys(String.valueOf(items[L]));
						Thread.sleep(3000);
						
						System.setOut(o);
						System.out.println("matcher 1");	
						//boolean linkPresence3 = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isDisplayed();
					   //boolean linkEnabled3 = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isEnabled();	
					    //boolean linkSize3 = driver.findElements(By.id("auto_completereport-" + reportParsed)).size() >0;
					    
						if(linkPresence == true && linkEnabled == true && linkSize == true) 
						{			
							WebElement linkButton1 = driver.findElement(By.id("auto_completereport-" + reportParsed)).findElement(By.linkText(String.valueOf(items[L])));
							linkButton1.click();
							Thread.sleep(3000);}	
						
						//verify that the “Add” is displayed/enabled and click
				        //boolean addPresence = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isDisplayed();
				        //boolean addEnabled = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isEnabled();
				       // boolean addPresence1 = driver.findElements(By.id("addConditionreport-" + reportParsed)).size() >0;
				        
						else
				        //if(addPresence == true && addEnabled == true && addSize == true)
						{
				        	WebElement addButton1 = driver.findElement(By.id("addConditionreport-" + reportParsed));
				        	Actions action2 = new Actions(driver);
				        	action2.moveToElement(addButton1).build().perform();
				        	Thread.sleep(2000);
				        	addButton1.click();
							Thread.sleep(3000);}
				     
				}
				
				 else 
					 
				{
				    	//Find the Search Result Link and click
						//boolean linkPresence1 = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isDisplayed();
					    //boolean linkEnabled1 = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isEnabled();	
					    //boolean linkSize = driver.findElements(By.id("auto_completereport-" + reportParsed)).size() >0;
					    
						//if(linkPresence == true || ! addEnabled || linkSize == true) 
						if(driver.findElement(By.id("auto_completereport-" + reportParsed)).findElements(By.linkText(String.valueOf(items[L]))).size() >0)	
						{			
							WebElement linkButton1 = driver.findElement(By.id("auto_completereport-" + reportParsed)).findElement(By.linkText(String.valueOf(items[L])));
							linkButton1.click();
							Thread.sleep(3000);
						
						System.setOut(o);
						System.out.println("click link");}
						
						//verify that the “Add” is displayed/enabled and click
				        //boolean addPresence1 = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isDisplayed();
				        //boolean addEnabled1 = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isEnabled();
				        //boolean addSize = driver.findElements(By.id("addConditionreport-" + reportParsed)).size() >0;
						else
				        //if(addPresence == true || addEnabled == true || addSize == true)
						{
				        	WebElement addButton1 = driver.findElement(By.id("addConditionreport-" + reportParsed));
				        	addButton1.click();
							Thread.sleep(3000);
							
				        System.setOut(o);
						System.out.println("click add button");}
				}
						
				
				
				
					//if(secondBox == true && secondBox1 == true)
						//if(secondBox == true)
							if(! matcher.matches() && driver.findElements(By.id(inputParsed0 + "2_1")).size() >0)
					
					{
						System.setOut(o);
						System.out.println("L++");
						
						L++;
						
						WebElement Box2 = driver.findElement(By.id(inputParsed0 + "2_1"));
						Actions action2 = new Actions(driver);
			        	action2.moveToElement(Box2).build().perform();
				     	Box2.click();
				     	Thread.sleep(1000);
				     	Box2.sendKeys(String.valueOf(items[L]));
						Thread.sleep(3000);
						//driver.findElement(By.id("runreport-" + reportParsed)).click();
						//Find the Search Result Link and click
						//boolean linkPresence11 = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isDisplayed();
					    //boolean linkEnabled11 = ((WebElement) driver.findElement(By.id("auto_completereport-" + reportParsed))).isEnabled();	
					    //boolean linkEnabled2 = driver.findElements(By.id("auto_completereport-" + reportParsed)).size() >0;
					    
						//if(linkPresence11 == true || linkEnabled11 == true && linkEnabled2 == true)
						if(driver.findElement(By.id("auto_completereport-" + reportParsed)).findElements(By.linkText(String.valueOf(items[L]))).size() >0)	
						{			
							WebElement linkButton1 = driver.findElement(By.id("auto_completereport-" + reportParsed)).findElement(By.linkText(String.valueOf(items[L])));
							linkButton1.click();
							Thread.sleep(3000);}
						
						//verify that the “Add” is displayed/enabled and click
				       // boolean addPresence4 = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isDisplayed();
				       //boolean addEnabled4 = ((WebElement) driver.findElement(By.id("addConditionreport-" + reportParsed))).isEnabled();
				        //boolean addSize4 = driver.findElements(By.id("addConditionreport-" + reportParsed)).size() >0;
						else
				        //if(addPresence == true || addEnabled == true || addSize == true)
						{
				        	WebElement addButton1 = driver.findElement(By.id("addConditionreport-" + reportParsed));
				        	addButton1.click();
							Thread.sleep(3000);}
					} 
							
			

				}
				}	
					
			
						
						//Find the Save Search box and click
						boolean saveSearch = driver.findElements(By.id("savereport-" + reportParsed)).size() >0;
						Thread.sleep(1000);
						 
						 
						if (! saveSearch)
						{
							mySheet.getRow(22).createCell(10).setCellValue("FAILED");
							mySheet.getRow(22).createCell(8).setCellValue("Save Search Button was NOT found");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(22).createCell(9).setCellValue("PASSED");
							mySheet.getRow(22).createCell(8).setCellValue("Save Search Button was found and Selected");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							WebElement element11 = driver.findElement(By.id("savereport-" + reportParsed));
					        Actions action11 = new Actions(driver);
					        jse.executeScript("arguments[0].scrollIntoView(true);", element11);
					        action11.moveToElement(element11).build().perform();
							Thread.sleep(2000);
							element11.click();
							Thread.sleep(5000);
							
						}
						
						//Find the Save Search box and send value
						String searchName = dataSheet.getRow(rownum).getCell(5).getStringCellValue();
						boolean saveSearchBox = driver.findElements(By.id("save_name_report-" + reportParsed)).size() >0;
						Thread.sleep(1000);
						 
						 
						if (! saveSearchBox)
						{
							mySheet.getRow(23).createCell(10).setCellValue("FAILED");
							mySheet.getRow(23).createCell(8).setCellValue("Save Search Box was NOT found");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(23).createCell(9).setCellValue("PASSED");
							mySheet.getRow(23).createCell(8).setCellValue("Save Search Box was found and Name Applied");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							WebElement element11 = driver.findElement(By.id("save_name_report-" + reportParsed));
					        Actions action11 = new Actions(driver);
					        jse.executeScript("arguments[0].scrollIntoView(true);", element11);
					        action11.moveToElement(element11).build().perform();
							Thread.sleep(2000);
							element11.click();
							Thread.sleep(1000);
							element11.sendKeys(String.valueOf(searchName));
							Thread.sleep(4000);
							
						}
						
						//Find the Save Search button and click
						boolean saveSearchButton = driver.findElements(By.id("save_button_report-" + reportParsed)).size() >0;
						Thread.sleep(1000);
						 
						 
						if (! saveSearchButton)
						{
							mySheet.getRow(24).createCell(10).setCellValue("FAILED");
							mySheet.getRow(24).createCell(8).setCellValue("Save Search Name Button was NOT found");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(24).createCell(9).setCellValue("PASSED");
							mySheet.getRow(24).createCell(8).setCellValue("Save Search Name Button was found and Selected");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							WebElement element11 = driver.findElement(By.id("save_button_report-" + reportParsed));
					        Actions action11 = new Actions(driver);
					        jse.executeScript("arguments[0].scrollIntoView(true);", element11);
					        action11.moveToElement(element11).build().perform();
							Thread.sleep(2000);
							element11.click();
							Thread.sleep(4000);
							
							
						}
						
						//Find the Save Search button and click
						boolean clearSearchButton = driver.findElements(By.id("cond_clear_report-" + reportParsed)).size() >0;
						Thread.sleep(1000);
						 
						 
						if (! clearSearchButton)
						{
							mySheet.getRow(25).createCell(10).setCellValue("FAILED");
							mySheet.getRow(25).createCell(8).setCellValue("Clear Search Button was NOT found");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(25).createCell(9).setCellValue("PASSED");
							mySheet.getRow(25).createCell(8).setCellValue("Clear Search Button was found and Selected");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							WebElement element11 = driver.findElement(By.id("cond_clear_report-" + reportParsed));
					        Actions action11 = new Actions(driver);
					        jse.executeScript("arguments[0].scrollIntoView(true);", element11);
					        action11.moveToElement(element11).build().perform();
							Thread.sleep(2000);
							element11.click();
							Thread.sleep(4000);
						}
						
						//Find the Quick Filter search and find attributes
						boolean advSrch2 = driver.findElements(By.linkText("Advanced Search")).size() >0;
						
						if ( ! advSrch2)
						{
							mySheet.getRow(26).createCell(10).setCellValue("FAILED");
							mySheet.getRow(26).createCell(8).setCellValue("Advanced Search Link was NOT Found");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(26).createCell(9).setCellValue("PASSED");
							mySheet.getRow(26).createCell(8).setCellValue("Advanced Search Link was Found and Selected");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							WebElement element1 = driver.findElement(By.linkText("Advanced Search"));
					        Actions action1 = new Actions(driver);
					        action1.moveToElement(element1).build().perform();
							Thread.sleep(3000);
							driver.findElement(By.linkText("Advanced Search")).click();
							Thread.sleep(8000);
						} 
						
						//Find the Quick Filter search and find attributes
						boolean viewSavedSrch = driver.findElements(By.cssSelector("#my_search_report-" + reportParsed)).size() >0;
						
						if ( ! viewSavedSrch)
						{
							mySheet.getRow(27).createCell(10).setCellValue("FAILED");
							mySheet.getRow(27).createCell(8).setCellValue("View Saved Search Link was NOT Found");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(27).createCell(9).setCellValue("PASSED");
							mySheet.getRow(27).createCell(8).setCellValue("View Saved Search Link was Found and Selected");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							WebElement element1 = driver.findElement(By.cssSelector("#my_search_report-" + reportParsed));
					        Actions action1 = new Actions(driver);
					        action1.moveToElement(element1).build().perform();
							Thread.sleep(2000);
							element1.click();
							//driver.findElement(By.id("my_search_report-" + reportParsed)).click();
							Thread.sleep(4000);
						}
						
						boolean savedName = driver.findElements(By.linkText(String.valueOf(searchName))).size () >0;
						
						if(! savedName)
						{
							mySheet.getRow(28).createCell(10).setCellValue("FAILED");
							mySheet.getRow(28).createCell(8).setCellValue("Saved Name Search Link was NOT Found");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//wb.close();	
							//driver.quit();
						}
						else
						{	
							
							mySheet.getRow(28).createCell(9).setCellValue("PASSED");
							mySheet.getRow(28).createCell(8).setCellValue("Saved Name Search Link was Found and Deleted");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//String delButton = driver.findElement(By.id("auto_completereport-" + reportParsed)).findElement(By.xpath("//span")).getAttribute("class");
							//element11.sendKeys(String.valueOf(searchName));
							String delete = driver.findElement(By.linkText(String.valueOf(searchName))).getAttribute("profile_id");
							System.setOut(o);
							System.out.println(delete);
							//String delete1 = driver.findElement(By.linkText(String.valueOf(searchName))).getAttribute("class");
							//System.out.println(delete1);
							WebElement delete2 = driver.findElement(By.id("row_saved_" + delete)).findElement(By.xpath("//span[@class='removeSavedSrch removeButton']"));
							Actions action1 = new Actions(driver);
					        action1.moveToElement(delete2).build().perform();
							Thread.sleep(3000);
							delete2.click();
							System.out.println("clear saved search");
							Thread.sleep(2000);
						}
						
						
						boolean screenShot =  driver.findElements(By.id("search_tips")).size() >0;
						 //Boolean screenShot = driver.findElements(By.id("grid-topcontainer").size() >0;
						 
						 
						if ( ! screenShot)
						{
							mySheet.getRow(29).createCell(10).setCellValue("FAILED");
							dataSheet.getRow(rownum).createCell(7).setCellValue("FAILED");
							mySheet.getRow(29).createCell(8).setCellValue("Deleted Results were not found");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							//wb.close();	
							//driver.quit();
						}
						else
						{
							mySheet.getRow(29).createCell(9).setCellValue("PASSED");
							dataSheet.getRow(rownum).createCell(6).setCellValue("PASSED");
							mySheet.getRow(29).createCell(8).setCellValue("Deleted Results were found and Screenshot was Taken");
							FileOutputStream fout1=new FileOutputStream(src);
							wb.write(fout1);
							File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						    File dest= new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Results\\"+timestamp()+".png");
						    FileUtils.copyFile(scr, dest);
							/*WebElement element1 = driver.findElement(By.id("runreport-" + reportParsed));
					        Actions action1 = new Actions(driver);
					        action1.moveToElement(element1).build().perform();
							Thread.sleep(2000);
							driver.findElement(By.id("runreport-" + reportParsed)).click();
							Thread.sleep(10000);*/
						    System.out.println("screenshot");
						}
					
						//String gridResults = driver.findElement(By.id("gridpager_report-" + reportParsed + "_right")).getAttribute("class");
					/*	String gridResults = driver.findElement(By.cssSelector(".ui-paging-info")).getText();
						String parts1[] = gridResults.split("of ");
						String gridParsed = parts1[1];
						System.setOut(o);
						System.out.println(gridParsed);
											
						System.out.println("3");
						
						List<String> gridList = Arrays.asList(gridResults);
						System.out.println("Grid Results = " + gridList);  */
						boolean closeAdvSrch = driver.findElements(By.id("close_report-" + reportParsed)).size () >0;
					
						if(! closeAdvSrch)
						{	
							mySheet.getRow(30).createCell(10).setCellValue("FAILED");
							mySheet.getRow(30).createCell(8).setCellValue("Close Advanced Search X was NOT Found");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							//wb.close();	
							//driver.quit();
							
						}
						else 
						{	
							
							mySheet.getRow(30).createCell(9).setCellValue("PASSED");
							mySheet.getRow(30).createCell(8).setCellValue("close Advanced Search X was Found and Selected");
							FileOutputStream fout=new FileOutputStream(src);
							wb.write(fout);
							WebElement closeSrch = driver.findElement(By.id("close_report-" + reportParsed));
					        Actions action11 = new Actions(driver);
					        action11.moveToElement(closeSrch).build().perform();
							Thread.sleep(2000);
							closeSrch.click();
							System.out.println("close");
							Thread.sleep(2000);
						}
				
							
					//Loop Row ++
					rownum++;
					
					
					
					//Try last cell, if not there then catch exception
					try {
						list = dataSheet.getRow(rownum).getCell(4).toString();
					reportName = dataSheet.getRow(rownum).getCell(1).getStringCellValue();
					}
					catch(Exception e) 
					
					{
						
						reportName = "";
					}
					
					
							
							
				}
				}
								
				}		
								
			    //wb.close();	
				driver.quit();
	
				}
		
					}
	
					
	
	
	

	public static void appendToFile(Exception e) {
	      try {
	         FileWriter fstream = new FileWriter("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\exception1.txt", true);
	         BufferedWriter out = new BufferedWriter(fstream);
	         PrintWriter pWriter = new PrintWriter(out, true);
	         e.printStackTrace(pWriter);
	      }
	      catch (Exception ie) {
	         throw new RuntimeException("Could not write Exception to file", ie);
	      }
	   }
	
	private static void printstacktrace(PrintStream ps) {}
		// TODO Auto-generated method stub
		
	
	
	public static void thrower(String message) throws Exception {
	      throw new RuntimeException(message);
	   }
	
	
	
	
	@AfterMethod
public void screenShot(ITestResult result) throws FileNotFoundException{
	PrintStream o = new PrintStream(new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Log Files\\Program Log File.txt"));
	 if(ITestResult.FAILURE==result.getStatus()){
		 try{
		
		 TakesScreenshot screenshot=(TakesScreenshot)driver;
		 File src=screenshot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("C:\\mmi_automation\\mmi_Lenovo_auto_testing\\output\\Screenshots\\"+ result.getName()+ timestamp()+".png"));
		 System.setOut(o);
		 System.out.println("Successfully captured a screenshot");
		 }
		 
		 catch (Exception e){
		 System.setOut(o);
		 System.out.println("Exception while taking screenshot "+e.getMessage());
		 } 
		 
		}
//driver.quit();
	}


private static String timestamp() {
	// TODO Auto-generated method stub
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

public static PrintStream getOriginalsystemout() {
	return originalSystemOut;
}

public static TC1441_AdvancedSrch_Criteria getSystemOutToLogger() {
	return systemOutToLogger;
}

public static void setSystemOutToLogger(TC1441_AdvancedSrch_Criteria systemOutToLogger) {
	TC1441_AdvancedSrch_Criteria.systemOutToLogger = systemOutToLogger;
}


}
