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

public class Shipper_CRM2 extends BaseClass{
	
	public Shipper_CRM2(WebDriver driver) {
		super(driver);
	}


@SuppressWarnings("unused")
@Test	
public static void CRM_Shipper(String sTestCaseName) throws Exception {

WebDriverWait wait = new WebDriverWait(driver, 20);
JavascriptExecutor js = (JavascriptExecutor)driver;	
driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div/div/div/h4/span"));
driver.navigate().to("http://stage.amilfreight.com/crm/sales/shipper-opt");
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
Date date = new Date();
String date1= dateFormat.format(date);

DOMConfigurator.configure("log4j.xml");
ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"ShipperAdd2");
int rowused = ExcelUtils.getRowUsed();
		
for (int i=1;i<=rowused;i++)
{
String TestCasename = sTestCaseName + "_"+i; 	
int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.ShipperAdd_TestCaseName);
Log.startTestCase(TestCasename);
iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
System.out.println(iTestCaseRow);

String Shipper_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Shipper_Name);
String Address = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Address);
String City_State = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_City_State);
String Zip_Code = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Zip_Code);
String Contact_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Contact_Name);
String Contact_Email = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Contact_Email);
String Contact_Phone = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Contact_No);
String Complete_Address = (Address+City_State+Zip_Code).replaceAll("[^a-zA-Z0-9]", "");
String Sales_Rep = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Sales_Rep);
String Sales_Rep_Mobile = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Sales_Rep_Mobile);
String Sales_Rep_Extention = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Sales_Rep_Extention);
String contact_Extention = "288640";
String contact_Phone_Type = "Office";
		 
try {

driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[1]/a")).click(); //add lead
		
Utils.Instance_NewWindow(driver);
driver.manage().window().maximize();
		
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

driver.findElement(By.id("PhoneNumber")).sendKeys(Contact_Phone); //phone number
driver.findElement(By.id("txtextension")).sendKeys(contact_Extention);
Select phone_Type = new Select(driver.findElement(By.id("PhoneType")));
phone_Type.selectByVisibleText(contact_Phone_Type);

String industry_Type = "books";
Select industry = new Select(driver.findElement(By.id("SddlIndustry")));
Thread.sleep(2000);
industry.selectByVisibleText(industry_Type);//books

driver.findElement(By.xpath("//*[@id='product']")).sendKeys("Glasses");

List<WebElement> Trailer=driver.findElements(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[12]/ul/li"));
for(int i1=0;i1<Trailer.size();i1++) {
	
	if(i1%3==0) {
		Trailer.get(i1).click();
	}
}

WebElement AddLeadButton=driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[3]/button[1]")); //save the lead
AddLeadButton.click();
//driver.close();
Thread.sleep(4500);
Utils.Instance_NewWindow(driver);

System.out.println("*********************************00000*************************************");
Thread.sleep(3500);
WebElement filter = driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/a/i")); //filter click
js.executeScript("arguments[0].click()", filter);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/input")).sendKeys(Shipper_Name);
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/div/a[2]")).click(); //search

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader"))); //wait till it loads
Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Utils.Instance_NewWindow(driver);	
driver.manage().window().maximize();
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
Thread.sleep(2300);
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[2]/a")).click();//prospect
Thread.sleep(2500);
driver.findElement(By.id("divConfirmbtn")).click();

Thread.sleep(2500);
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[2]/a")).click();

Thread.sleep(2500);
Utils.Instance_NewWindow(driver);

System.out.println(driver.getCurrentUrl());

System.out.println("*********************************Prospect2Client*************************************");

driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a")).click();

Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Utils.Instance_NewWindow(driver);
Thread.sleep(3500);

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[4]/a")).click();

Thread.sleep(1900);
String Alert_MsgPros_Client=driver.findElement(By.xpath("//*[@class='msgul'][2]")).getText();

System.out.println(Alert_MsgPros_Client);

String Contract_Text="Contract Type";
String Lanes_Text="Lanes";
String AccessCharge_Text="Accessorial";
String ContractSheet_Text="Contract Sheet";
String FuelCharge_Text="Fuel Surcharge Sheet";

Assert.assertTrue(Alert_MsgPros_Client.contains(Contract_Text), "Contract Type doesn't match");
Assert.assertTrue(Alert_MsgPros_Client.contains(Lanes_Text), "Lanes doesn't match");
Assert.assertTrue(Alert_MsgPros_Client.contains(AccessCharge_Text), "Accessorial Charges doesn't match");
Assert.assertTrue(Alert_MsgPros_Client.contains(ContractSheet_Text), "Contract Sheet doesn't match");
Assert.assertTrue(Alert_MsgPros_Client.contains(FuelCharge_Text), "Fuel Surcharge Sheet doesn't match");

driver.findElement(By.xpath("//*[@id='btnNotiFyOk']")).click();
Thread.sleep(1900);

// Click Basic info Update

//Slect Contract Type

driver.findElement(By.xpath("//*[@ng-click='OpenUpdateBasicInfo()']")).click();//Update BasicInfo
Utils.Instance_NewWindow(driver);	
Thread.sleep(1250);

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
driver.manage().window().maximize();
Thread.sleep(2500);
Select contract= new Select(driver.findElement(By.id("contracttype")));
contract.selectByVisibleText("Asset Based");
driver.findElement(By.xpath("//*[@ng-click='saveBasicinfo()']")).click(); //Update Button
Thread.sleep(1250);

Utils.Instance_NewWindow(driver);
System.out.println(driver.getCurrentUrl());
Thread.sleep(1250);

//Required
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

driver.findElement(By.xpath("//*[@id='documentsinfodiv']/div[1]/a")).click();

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

driver.findElement(By.id("fileInput34")).sendKeys(accessorial_Charges_Sheet);
Thread.sleep(2900);

driver.findElement(By.id("fileInput50")).sendKeys(contract_Sheet);
Thread.sleep(2900);

driver.findElement(By.id("fileInput33")).sendKeys(fuel_Surcharge_Sheet);
Thread.sleep(2900);

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div/form/div[3]/button[2]")).click();

Thread.sleep(2300);
Utils.Instance_NewWindow(driver);

driver.findElement(By.xpath("//*[@id='offeredLaneSummary']/div[1]/a[1]")).click();

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

String lane_Origin = "Austin, Texas(TX), US";
String lane_Destination = "Antonia, Louisiana(LA), US";
String lane_Trailer_Type = "Car Hauler";

driver.findElement(By.id("txtorigincitystate")).sendKeys(lane_Origin);
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[1]/ul/li[1]/a")).click();
//driver.findElement(By.id("txtorigincitystate")).sendKeys(Keys.ENTER);
Thread.sleep(3500);
		
driver.findElement(By.id("txtdestinationcitystate")).sendKeys(lane_Destination);
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[2]/ul/li/a")).click();
//driver.findElement(By.id("txtorigincitystate")).sendKeys(Keys.ENTER);
Thread.sleep(3500);

Select lane_Trailer = new Select(driver.findElement(By.id("ddlTrailer")));
lane_Trailer.selectByVisibleText(lane_Trailer_Type);
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[15]/input")).click();
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@ng-click='AddOfferedLanes(addLane)']")).click(); //add the lane in bucket
Thread.sleep(800);

driver.findElement(By.xpath("//*[@ng-click='SaveOfferedLanes()']")).click(); //add the lane in bucket
Thread.sleep(2500);

Utils.Instance_NewWindow(driver);

driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[4]/a")).click(); //move to client
Thread.sleep(2000);

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
ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.ShipperAdd3_Result);
Utils.takeScreenshot(driver, Shipper_Name+"Pass"+date1);
Thread.sleep(2500);

}
catch (Exception e){
ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.ShipperAdd3_Result);
Reporter.log(" "+Shipper_Name+ "  Email receipents added & Verified - Unsuccessful");
Utils.takeScreenshot(driver, Shipper_Name+"Fail"+date1);
Log.error(e.getMessage());
throw (e);
}

}	
}
}
