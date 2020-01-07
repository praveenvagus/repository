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

public class ShipperCRMAccounts extends BaseClass{

	public ShipperCRMAccounts(WebDriver driver) {
		super(driver);
		}

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
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"ShipperAdd3");
	int rowused = ExcelUtils.getRowUsed();
			
	for (int i=1;i<=rowused;i++)
	{
	String TestCasename = sTestCaseName + "_"+i; 	
	int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.ShipCRMAcc_TestCaseName);
	Log.startTestCase(TestCasename);
	iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
	//System.out.println(iTestCaseRow);

	String Shipper_Company = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ShipperName);
	String Shipper_Address = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Address);
	String Shipper_CityState = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_CityState);
	String Shipper_Industry = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Industry);
	String Shipper_Product = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Product);
	String Shipper_AvgLoad = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_AvgLoad);
	String Shipper_Trailer = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Trailer);
	String Shipper_Sales1Rep = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Sales1Rep);
	String Shipper_Sales2Rep = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Sales2Rep);
	String Shipper_ContraType = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ContrType);
	String Shipper_Origin = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Origin);
	String Shipper_Destination = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Destination);
	String Shipper_TrailerType = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_TypeTrailer);
	String Shipper_ContactName = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ContactName);
	String Shipper_ContJobTitle = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_JobTitle);
	String Shipper_ContacNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_MobileNo);
	String Shipper_ContExtense = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Extension);
	String Shipper_MobileType = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_MobileType);
	String Shipper_ContactEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ContEmail);
			 
try {

driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[1]/a")).click(); //add lead
Utils.Instance_NewWindow(driver);
driver.manage().window().maximize();
			
driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[1]/input")).sendKeys(Shipper_Company); //account name

driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[2]/input")).sendKeys(Shipper_Address); //address
Thread.sleep(1200);	

driver.findElement(By.name("txtcitystate")).sendKeys(Shipper_CityState); //City
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[3]/ul/li[1]/a")).click();
Thread.sleep(3500);
String Zip_Code ="624705";			
driver.findElement(By.id("zipcode")).sendKeys(Zip_Code); //zip code
			
driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[6]/input")).sendKeys(Shipper_ContactName); //contact name

driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[1]/div/div[7]/input")).sendKeys(Shipper_ContactEmail); //contact email

driver.findElement(By.id("PhoneNumber")).sendKeys(Shipper_ContacNumber); //phone number
driver.findElement(By.id("txtextension")).sendKeys(Shipper_ContExtense);
Select phone_Type = new Select(driver.findElement(By.id("PhoneType")));
phone_Type.selectByVisibleText(Shipper_MobileType);

driver.findElement(By.xpath("//*[contains(text(),'"+Shipper_Trailer+"')]//parent::li/input")).click();
Thread.sleep(1500);

Select Contract = new Select(driver.findElement(By.id("contracttype")));
Thread.sleep(1500);
Contract.selectByVisibleText(Shipper_ContraType);

Select industry = new Select(driver.findElement(By.id("SddlIndustry")));
Thread.sleep(1500);
industry.selectByVisibleText(Shipper_Industry);

driver.findElement(By.xpath("//*[@id='product']")).sendKeys(Shipper_Product);
//System.out.println(Shipper_Trailer);

WebElement AddLeadButton=driver.findElement(By.xpath("//*[@id='addlead']/div[3]/div/div[3]/button[1]")); //save the lead
AddLeadButton.click();
//driver.close();
Thread.sleep(2800);
Utils.Instance_NewWindow(driver);

System.out.println("*********************************00000*************************************");

Thread.sleep(3500);
WebElement filter = driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/a/i")); //filter click
js.executeScript("arguments[0].click()", filter);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/input")).sendKeys(Shipper_Company);
Thread.sleep(1500);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/div/a[2]")).click(); //search

wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader"))); //wait till it loads

driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Utils.Instance_NewWindow(driver);	
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
Thread.sleep(1250);
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[2]/a")).click();//prospect
Thread.sleep(2500);
driver.findElement(By.id("divConfirmbtn")).click();

Thread.sleep(2500);
driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[2]/a")).click();

Thread.sleep(2500);
Utils.Instance_NewWindow(driver);

//System.out.println(driver.getCurrentUrl());

//System.out.println("*********************************Prospect2Client*************************************");

driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a")).click();

Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Utils.Instance_NewWindow(driver);
Thread.sleep(3500);

driver.findElement(By.xpath("//*[@id='divbasicinfo']/div[1]/a")).click(); //update button
Utils.Instance_NewWindow(driver);
Thread.sleep(2300);


driver.findElement(By.xpath("//*[@id='txtAverageLoad']")).sendKeys(Shipper_AvgLoad);

Select Sales1rep = new Select(driver.findElement(By.xpath("//*[@ng-model='BasicInfo.SalesRepId']")));
Thread.sleep(1500);
Sales1rep.selectByVisibleText(Shipper_Sales1Rep);

Select Sales2rep = new Select(driver.findElement(By.xpath("//*[@ng-model='BasicInfo.SecSalesRepId']")));
Thread.sleep(1500);
Sales2rep.selectByVisibleText(Shipper_Sales2Rep);

driver.findElement(By.xpath("//*[@id='Basicinfo']/div[3]/button")).click(); //save
Thread.sleep(2800);
		
//switch the control to the shipper profile
Utils.Instance_NewWindow(driver);

driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr/td[6]/a[1]/i")).click(); //edit contact

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

driver.findElement(By.xpath("//*[@ng-model='contactinfo.JobTitle']")).sendKeys(Shipper_ContJobTitle);
Thread.sleep(1900);

driver.findElement(By.xpath("//*[@class='cp-successbtn']")).click(); //update button

Thread.sleep(2500);
Utils.Instance_NewWindow(driver);
Thread.sleep(2500);


//Required
String accessorial_Charges_Sheet = (System.getProperty("user.dir") +"/Support_Docs/Accessorial charges sheet.pdf");
String contract_Sheet = (System.getProperty("user.dir") +"/Support_Docs/Contract sheet.doc");
String fuel_Surcharge_Sheet = (System.getProperty("user.dir") +"/Support_Docs/Fuel surcharge sheet.png");

List<String> document_Types = new ArrayList<>();
document_Types.add("Accessorial charges sheet.pdf");
document_Types.add("Contract sheet.doc");
document_Types.add("Fuel surcharge sheet.png");
Collections.sort(document_Types);
//System.out.println(document_Types);

driver.findElement(By.xpath("//*[@id='divbasicinfo']/div[1]/a")).click(); //update button

driver.findElement(By.xpath("//*[@id='documentsinfodiv']/div[1]/a")).click();

Utils.Instance_NewWindow(driver);
Thread.sleep(2500);

	driver.findElement(By.id("fileInput34")).sendKeys(accessorial_Charges_Sheet);
	Thread.sleep(4000);

	driver.findElement(By.id("fileInput50")).sendKeys(contract_Sheet);
	Thread.sleep(4000);

	driver.findElement(By.id("fileInput33")).sendKeys(fuel_Surcharge_Sheet);
	Thread.sleep(4000);

	driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div/form/div[3]/button[2]")).click();

	Thread.sleep(1500);
	Utils.Instance_NewWindow(driver);

	js.executeScript("window.scrollBy(0,1000)", "");
	Thread.sleep(1500);

	driver.findElement(By.xpath("//*[@id='offeredLaneSummary']/div[1]/a[1]")).click();

	Utils.Instance_NewWindow(driver);
	Thread.sleep(2500);

	driver.findElement(By.id("txtorigincitystate")).sendKeys(Shipper_Origin);
	Thread.sleep(4500);
	driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[1]/ul/li[1]/a")).click();
	//driver.findElement(By.id("txtorigincitystate")).sendKeys(Keys.ENTER);
	Thread.sleep(3500);
			
	driver.findElement(By.id("txtdestinationcitystate")).sendKeys(Shipper_Destination);
	Thread.sleep(4500);
	driver.findElement(By.xpath("//*[@id='OfferedLaneAdd']/div[1]/div/div[2]/ul/li/a")).click();
	//driver.findElement(By.id("txtorigincitystate")).sendKeys(Keys.ENTER);
	Thread.sleep(3500);

	Select lane_Trailer = new Select(driver.findElement(By.id("ddlTrailer")));
	lane_Trailer.selectByVisibleText(Shipper_TrailerType);;

	driver.findElement(By.xpath("//*[@ng-click='AddOfferedLanes(addLane)']")).click(); //add the lane in bucket
	Thread.sleep(800);

	driver.findElement(By.xpath("//*[@ng-click='SaveOfferedLanes()']")).click(); //add the lane in bucket
	Thread.sleep(3500);

	Utils.Instance_NewWindow(driver);

	driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click(); //move to action
	driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[4]/a")).click(); //move to client
	Thread.sleep(2000);

	Thread.sleep(2700);
	driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click(); //confirm

	Thread.sleep(2300);
		
	String stage_Displayed_In_Client = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/span[1]/span[2]"))
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
	Assert.assertTrue(shipper_In_Client.equalsIgnoreCase(Shipper_Company), "Shipper Moved to client");

	
	//*****************************************************************************************************************************//
	ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.ShipCRMAcc_Result);
	Utils.takeScreenshot(driver, Shipper_Company+"Pass"+date1);
	Thread.sleep(2500);

	}
	catch (Exception e){
	ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.ShipCRMAcc_Result);
	Reporter.log(" "+Shipper_Company+ "  Email receipents added & Verified - Unsuccessful");
	//Utils.takeScreenshot(driver, Shipper_Name+"Fail"+date1);
	Log.error(e.getMessage());
	throw (e);
	}

	}	
	}
	}

