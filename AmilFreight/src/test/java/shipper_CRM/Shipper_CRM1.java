package shipper_CRM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class Shipper_CRM1 extends BaseClass{
	
	public Shipper_CRM1(WebDriver driver) {
		super(driver);
	}


@Test	
public static void CRM_Shipper(String sTestCaseName) throws Exception {
		
WebDriverWait wait = new WebDriverWait(driver, 20);
JavascriptExecutor js = (JavascriptExecutor)driver;	 	
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
Date date = new Date();
String date1= dateFormat.format(date);

driver.navigate().to("http://stage.amilfreight.com/crm/sales/shipper-opt");
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
	
driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[1]/a")).click(); //add lead
		
Utils.Instance_NewWindow(driver);


DOMConfigurator.configure("log4j.xml");
ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"ShipperAdd1");
int rowused = ExcelUtils.getRowUsed();
	
for (int i=1;i<=rowused;i++)
{
String TestCasename = sTestCaseName + "_"+i; 	
int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.ShipperAdd_TestCaseName);
Log.startTestCase(TestCasename);
iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
System.out.println("Rowused"+rowused);

String Shipper_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Shipper_Name);
String Address = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Address);
String City_State = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_City_State);
String Zip_Code = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Zip_Code);
String Contact_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Contact_Name);
String Contact_Email = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Contact_Email);
String Contact_Phone = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Contact_No);
String Complete_Address = (Address+City_State+Zip_Code).replaceAll("[^a-zA-Z0-9]", "");
String Sales_Rep = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Sales_Rep);

		
try {		
		
driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[1]/input")).sendKeys(Shipper_Name); //account name

driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[2]/input")).sendKeys(Address); //address

Thread.sleep(1200);		
driver.findElement(By.name("txtcitystate")).sendKeys(City_State); //City
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[3]/ul/li[1]/a")).click();
//driver.findElement(By.name("txtcitystate")).sendKeys(Keys.ENTER);
Thread.sleep(3500);
		
driver.findElement(By.id("zipcode")).sendKeys(Zip_Code); //zip code
		
driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[6]/input")).sendKeys(Contact_Name); //contact name

driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[7]/input")).sendKeys(Contact_Email); //contact email
		
WebElement myButton=driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[3]/button[1]")); //save the lead

myButton.click();
//driver.close();
/*Thread.sleep(1500);
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
WebElement AddLead=driver.findElement(By.xpath("//*[@title='Click here to Add Account']"));
if(AddLead.isDisplayed()) {
	
	System.out.println("PRaveenBEnikka");
}else {
	Utils.takeScreenshot(driver, sTestCaseName);
	driver.close();
}*/
Thread.sleep(4500);

Utils.Instance_NewWindow(driver);
Thread.sleep(3500);

WebElement filter = driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/a/i")); //filter click
js.executeScript("arguments[0].click()", filter);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/input")).sendKeys(Shipper_Name);
Thread.sleep(3500);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/div/a[2]")).click(); //search

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader"))); //wait till it loads

driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Utils.Instance_NewWindow(driver);	
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
driver.manage().window().maximize();

Thread.sleep(2500);

//basic information
String account_Name_Displayed = driver
		.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[1]/span")).getText();

String address_Displayed = driver
		.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[2]/span"))
		.getText().replaceAll("[^a-zA-Z0-9]", "");
System.out.println(address_Displayed);
String sales_Rep_Displayed = driver
		.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span/span[1]/span[1]"))
		.getText();
System.out.println(sales_Rep_Displayed);

String sales_Rep_Extention_Displayed = driver
		.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span/span[2]/span[1]/span"))
		.getText().replaceAll("[^0-9]", "");
System.out.println(sales_Rep_Extention_Displayed);

 js.executeScript("window.scrollBy(0,250)");
 Thread.sleep(1500);

String contact_Name_Displayed = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr/td[1]")).getAttribute("innerText");
System.out.println(contact_Name_Displayed);

String contact_Email_Displayed = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr/td[5]")).getText();

driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr/td[6]/a[2]/i")).isDisplayed();   //if the contact is primary, the test case will fail

System.out.println(Complete_Address+"...."+address_Displayed);
Assert.assertTrue(account_Name_Displayed.equalsIgnoreCase(account_Name_Displayed), "account name issue");
//Assert.assertTrue(address_Displayed.equalsIgnoreCase(Complete_Address), "address issue");
Assert.assertTrue(sales_Rep_Displayed.equalsIgnoreCase(Sales_Rep), "sales rep issue");
//Assert.assertTrue(sales_Rep_Mobile_Displayed.equalsIgnoreCase(Sales_Rep_Mobile), "sales rep mobile issue");
//Assert.assertTrue(sales_Rep_Extention_Displayed.equalsIgnoreCase(Sales_Rep_Extention), "sales rep extention issue");
Assert.assertTrue(contact_Name_Displayed.equalsIgnoreCase(Contact_Name), "contact name issue");
Assert.assertTrue(contact_Email_Displayed.equalsIgnoreCase(Contact_Email), "contact email issue");

System.out.println("**************************************************");

//Case 3: Moving to prospect by giving the necessary fields


driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[2]/a")).click(); //prospect
Thread.sleep(3000);

String move_To_Prospect_Errors = driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div/span/ul")).getText(); //errors

Assert.assertTrue(move_To_Prospect_Errors.contains("Primary Contact"), "Primary contact error issue");
Assert.assertTrue(move_To_Prospect_Errors.contains("Trailer Type"), "Trailer Type error issue");
Assert.assertTrue(move_To_Prospect_Errors.contains("Industry"), "Primary contact error issue");

driver.findElement(By.id("btnNotiFyOk")).click(); //close the error

//update the industry	
js.executeScript("window.scrollBy(0,-1000)", "");
Thread.sleep(2000);

//required:
String industry_Type = "books";

driver.findElement(By.xpath("//*[@id='divbasicinfo']/div[1]/a")).click(); //update button

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

Select industry = new Select(driver.findElement(By.id("SddlIndustry")));
industry.selectByVisibleText(industry_Type);//books
Thread.sleep(2000);

driver.findElement(By.xpath("//*[@id='Basicinfo']/div[3]/button")).click(); //save
Thread.sleep(2800);
		
//switch the control to the shipper profile
Utils.Instance_NewWindow(driver);

wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/span[1]")));

String industry_Type_Displayed = driver
		.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[3]/span"))
		.getText();

Assert.assertTrue(industry_Type_Displayed.equalsIgnoreCase(industry_Type), "Industry type issue");

//make the non-primary contact as a primary contact
String contact_Extention = "288640";
String contact_Phone_Type = "Office";

driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr/td[6]/a[1]/i")).click(); //edit contact

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

driver.findElement(By.id("PhoneNumber")).sendKeys(Contact_Phone); //phone number
driver.findElement(By.id("txtextension")).sendKeys(contact_Extention);
Select phone_Type = new Select(driver.findElement(By.id("phonetype")));
phone_Type.selectByVisibleText(contact_Phone_Type);
driver.findElement(By.xpath("//*[@id='contactinfo']/div/div[1]/div[1]/div[2]/div[2]/div[1]/span/a/i")).click(); //add phone
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

driver.findElement(By.xpath("//*[@id='contactinfo']/div/div[1]/div[1]/div[3]/div[2]/ul/li/label/span")).click(); //primary check box

WebElement submit = driver.findElement(By.xpath("//*[@ng-click='checkContactExists(contactinfo,1)']"));
js.executeScript("arguments[0].click()", submit);
Thread.sleep(1500);

//switch back to shipper profile
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

System.out.println("******************************1********************************");
driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr[1]/td[1]/a/i")).isDisplayed();

//add trailer
WebElement trailer_Finder = driver
		.findElement(By.id("documentup"));
js.executeScript("arguments[0].scrollIntoView()", trailer_Finder);


driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[4]/div[5]/div[4]/div[1]/a")).click(); //update button

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

WebElement select_Trailer = driver.findElement(By.id("trailer15"));//trailer15 is van conestoga
js.executeScript("arguments[0].click()", select_Trailer);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/div/form/div[3]/button[2]")).click(); //save
Thread.sleep(2000);

//switch to shipper profile
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

String trailer_Types = driver
		.findElement(By.xpath("//*[@id='trailerinfodiv']/div/div[1]/div[1]/div[1]/div/ul"))
		.getText();

Assert.assertTrue(trailer_Types.contains("Van Conestoga"), "trailer type not found");

driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[2]/a")).click();//prospect
wait.until(ExpectedConditions.elementToBeClickable(By.id("divConfirmbtn")));
driver.findElement(By.id("divConfirmbtn")).click(); //confirm


//to verify that shipper is in prospect
js.executeScript("window.scrollBy(0,-250)", "");
Thread.sleep(2000);

String stage_Displayed = driver
		.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/span[1]/span[2]"))
		.getText();

Assert.assertTrue(stage_Displayed.equalsIgnoreCase("Prospect"), "Shipper did not move to prospect");

driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div/div[2]/a")).click(); //close shipper profile

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a")).click(); //move to prospect section
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

String shipper_In_Prospect = driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).getText();
				
Assert.assertTrue(shipper_In_Prospect.equalsIgnoreCase(Shipper_Name), "Shipper did not move to prospect");

//CAse 4: moving shipper to contact stage


driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

//required
String lane_Origin = "Austin, Texas(TX), US";
String lane_Destination = "Antonia, Louisiana(LA), US";
String lane_Trailer_Type = "Van Conestoga";

Utils.Instance_NewWindow(driver);
Thread.sleep(3500);

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[3]/a")).click(); //move to contact
Thread.sleep(2000);

String move_To_Contact_Errors = driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div/span/ul")).getText(); //errors

Assert.assertTrue(move_To_Contact_Errors.contains("Lanes is Required"), "Lane not added issue");

driver.findElement(By.id("btnNotiFyOk")).click(); //close the error

js.executeScript("window.scrollBy(0,1000)", "");
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@id='offeredLaneSummary']/div[1]/a[1]")).click();

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

driver.findElement(By.id("txtorigincitystate")).sendKeys(lane_Origin);
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[1]/ul/li[1]/a")).click();
//driver.findElement(By.id("txtorigincitystate")).sendKeys(Keys.ENTER);
Thread.sleep(4500);
		
driver.findElement(By.id("txtdestinationcitystate")).sendKeys(lane_Destination);
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[2]/ul/li/a")).click();
//driver.findElement(By.id("txtorigincitystate")).sendKeys(Keys.ENTER);
Thread.sleep(4500);

Select lane_Trailer = new Select(driver.findElement(By.id("ddlTrailer")));
lane_Trailer.selectByVisibleText(lane_Trailer_Type);
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[15]/input")).click();
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[17]/button")).click(); //add the lane in bucket

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OfferedLaneAdd']/div[3]/div/div/table/tbody/tr/td[14]/span/i")));

String lane_Origin_Displayed = driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[3]/div/div/table/tbody/tr/td[1]"))
		.getText();

String lane_Destination_Displayed = driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[3]/div/div/table/tbody/tr/td[2]"))
		.getText();

String lane_Trailer_Displayed = driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[3]/div/div/table/tbody/tr/td[3]/span")).getText();

Assert.assertTrue(lane_Origin_Displayed.equalsIgnoreCase(lane_Origin), "lane origin issue");
Assert.assertTrue(lane_Destination_Displayed.equalsIgnoreCase(lane_Destination), "lane destination issue");
Assert.assertTrue(lane_Trailer_Displayed.equalsIgnoreCase(lane_Trailer_Type), "lane trailer issue");

driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[4]/button")).click();//save the lane

Thread.sleep(3900);

Utils.Instance_NewWindow(driver);
Thread.sleep(3900);

driver.findElement(By.xpath("//*[@id='collapsible-control-right-group6']/div/div/div[1]/table/tbody/tr/td[4]/a")).click(); //view all

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);
	
//String lane_Origin_Bucket = driver.findElement(By.xpath("//*[@id='LanesCollection']/table/tbody/tr[1]/td[1]")).getText();
//String lane_Destination_Bucket = driver.findElement(By.xpath("//*[@id='LanesCollection']/table/tbody/tr[1]/td[2]")).getText();
String lane_Trailer_Bucket = driver.findElement(By.xpath("//*[@id='LanesCollection']/table/tbody/tr[1]/td[3]/span")).getText();

//Assert.assertTrue(lane_Origin_Bucket.equalsIgnoreCase(lane_Origin), "lane origin issue");
//Assert.assertTrue(lane_Destination_Bucket.equalsIgnoreCase(lane_Destination), "lane destination issue");
Assert.assertTrue(lane_Trailer_Bucket.equalsIgnoreCase(lane_Trailer_Type), "lane trailer issue");

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/span[3]/a")).click(); //close

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[3]/a")).click(); 
wait.until(ExpectedConditions.elementToBeClickable(By.id("divConfirmbtn")));
driver.findElement(By.id("divConfirmbtn")).click(); //confirm

//verifying whether everything has moved to contact
js.executeScript("window.scrollBy(0,-1000)", "");
Thread.sleep(2000);

String stage_Displayed_In_Contact = driver
		.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/span[1]/span[2]"))
		.getText();

Assert.assertTrue(stage_Displayed_In_Contact.equalsIgnoreCase("Contact"), "Shipper did not move to contact");

driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div/div[2]/a")).click(); //close shipper profile

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

driver.findElement(By.xpath("//*[@id='Tabs']/li[3]/a")).click(); //move to contact section
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

String shipper_In_Contact = driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).getText();
				
Assert.assertTrue(shipper_In_Contact.equalsIgnoreCase(Shipper_Name), "Shipper did not move to contact");

//Case 5: Move to client	

driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Thread.sleep(3500);
Utils.Instance_NewWindow(driver);
Thread.sleep(3900);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[4]/a")).click(); //move to client
Thread.sleep(2000);

String move_To_Client_Errors = driver.findElement(By.xpath("html/body/div[3]/div/div[2]/div/span/ul")).getText(); //errors
driver.findElement(By.id("btnNotiFyOk")).click();

Assert.assertTrue(move_To_Client_Errors.contains("Contract Type"), "Contract type issue");
Assert.assertTrue(move_To_Client_Errors.contains("Accessorial Charges"), "Accessorial Charges doc issue");
Assert.assertTrue(move_To_Client_Errors.contains("Contract Sheet"), "Contract Sheet doc issue");
Assert.assertTrue(move_To_Client_Errors.contains("Fuel Surcharge"), "Fuel Surcharge doc issue");

//Required
String contract_Type = "Asset Based";
String accessorial_Charges_Sheet = (System.getProperty("user.dir") +"/Support_Docs/Accessorial charges sheet.pdf");
String contract_Sheet = (System.getProperty("user.dir") +"/Support_Docs/Contract sheet.doc");
String fuel_Surcharge_Sheet = (System.getProperty("user.dir") +"/Support_Docs/Fuel surcharge sheet.png");

List<String> document_Types = new ArrayList<>();
document_Types.add("Accessorial charges sheet.pdf");
document_Types.add("Contract sheet.doc");
document_Types.add("Fuel surcharge sheet.png");
Collections.sort(document_Types);
System.out.println(document_Types);

driver.findElement(By.xpath("//*[@id='divbasicinfo']/div[1]/a")).click(); //update button
Thread.sleep(2500);
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

Select contract= new Select(driver.findElement(By.id("contracttype")));
contract.selectByVisibleText("Asset Based");

driver.findElement(By.xpath("//*[@id='Basicinfo']/div[3]/button")).click(); //save
Thread.sleep(2000);
		
//switch the control to the shipper profile
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/span[1]")));

String contract_Type_Displayed = driver
		.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[6]/span"))
		.getText();

Assert.assertTrue(contract_Type_Displayed.equalsIgnoreCase(contract_Type),"contract type issue");

js.executeScript("window.scrollBy(0,300)");
Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id='documentsinfodiv']/div[1]/a")).click();

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

driver.findElement(By.id("fileInput34")).sendKeys(accessorial_Charges_Sheet);
Thread.sleep(4000);

driver.findElement(By.id("fileInput50")).sendKeys(contract_Sheet);
Thread.sleep(4000);

driver.findElement(By.id("fileInput33")).sendKeys(fuel_Surcharge_Sheet);
Thread.sleep(4000);

driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/div/form/div[3]/button[2]")).click();

Thread.sleep(2500);
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsible-control-right-group3']/div/div/div[1]/table/tbody/tr[1]/td[5]/a/i")));

List<String> document_In_CRM = new ArrayList<>();

//total documents available
List<WebElement> total_Documents = driver.findElements(By.xpath("//*[@id='collapsible-control-right-group3']/div/div/div[1]/table/tbody/tr"));
for(int t=1; t<=total_Documents.size(); t++)
{
	//get the document names and store it in a list
	String get_Document_Names = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group3']/div/div/div[1]/table/tbody/tr["+t+"]/td[1]/a")).getText();
	document_In_CRM.add(get_Document_Names);
}

//sorting the list for comparison
Collections.sort(document_In_CRM);
System.out.println(document_In_CRM);

Assert.assertTrue(document_In_CRM.equals(document_Types), "Document issue");

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[4]/a")).click(); //move to client

Thread.sleep(2700);
driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click(); //confirm

Thread.sleep(2300);

		
String stage_Displayed_In_Client = driver
		.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/span[1]/span[2]"))
		.getText();

Assert.assertTrue(stage_Displayed_In_Client.equalsIgnoreCase("Client"), "Shipper did not move to client");

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[2]/a")).click(); //close shipper profile

Thread.sleep(2500);
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

driver.findElement(By.xpath("//*[@id='Tabs']/li[4]/a")).click(); //move to client section
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

String shipper_In_Client = driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).getText();
				
Assert.assertTrue(shipper_In_Client.equalsIgnoreCase(Shipper_Name), "Shipper did not move to client");

ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.ShipperAdd_Result);
Reporter.log(" "+Shipper_Name+ "  Email receipents added & Verified - Unsuccessful");
Utils.takeScreenshot(driver, Shipper_Name+"Pass"+date1);
}
catch (Exception e) {
ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.ShipperAdd_Result);
Reporter.log(" "+Shipper_Name+ "  Email receipents added & Verified - Unsuccessful");
Utils.takeScreenshot(driver, Shipper_Name+"Fail"+date1);
throw (e);
}


	}
}	
}
