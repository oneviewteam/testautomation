# testautomation
In order to execute the executable JAR files, your computer would first need to be set up to run those files. 
**See: Automation files documentation.docx  in the selection.
This file/email will guide you on how to set up the Firefox browser. 
*Note your computer may need to have JAVA or JAVA JDK updated. 


The automation tests have been compiled into executable JAR files. These JAR files can be double clicked to run them. Upon execution of these files, Firefox will open as these scripts are geared toward that browser set up.

Once they are clicked, they will run automatically. You will see Firefox pop up and the webite indicated (lenovo or AVEVA) put into the URL bar. The scripts will show the front page, log in and move to the dashboard of the website. 
The scripts will run all the way through and update the data excel output sheets. 
*For example, TC1441_AdvancedSrch_Criteria JAR file will write to the Excel data file called "Reports_Advanced_Search."


**The Project fodlers are labled as:
1. mmi_auto_testing_AdvancedSearch for__AVEVA
2. mmi_Lenovo_auto_testing for__LENOVO

**Test Case Files: This folder contains the SE test suite & Test scenarios for AVEVA given by QA

Each one of the folders above contains 3 child folders called: bin, data & output.

Once in a specific folder, go to the bin folder and you will see the Executable Jar Files. These are the files that have the JAVA symbol in front with the tea cup icon.
Each file is label for the specific function it represents.
The data folder will contain the Excel spreadsheet where the results will be printed. Before double clicking and executable, you may want to clear the results in the data spreadsheet first. (see screenshot below) 
The previous data will be over written anyway but this will assure that the results on the sheet are from the latest test. 
If a script fails due to log in, try and try again until it actually logs into the portal.
If a script fails after the log in, note that executable name. It may require manual intervention for browser pop up alerts.

**Data Output file


The first tab in the data files would be the input information. For instance the URL: https://lenovodev.managedmaint.com
The User name for that URL
The Password for that URL

Then the data sheet will have columns with specific information pertaining to the function. Test Steps, Expected REsults, Actual Results & status columns for Pass or Fail. Those are usually columns J & K.

IF the function is for advacned search or columns search, then there will be additional tabs with input & output columns. Those files will also have expected results columns which should be filed out before running the scripts. 

*Actual Results
This is the column where a specific search will return a number value from the grid results found after criteria is enetered. 









