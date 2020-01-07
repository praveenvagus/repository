package QuoteMail_SelAllVerify;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import locators_Amil.QuoteMail_Page;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class Sel_AvailCar_MailRecp extends BaseClass {
	
	public Sel_AvailCar_MailRecp(WebDriver driver) {
		super(driver);
		
	}

@Test
public static void Verification(String sTestCaseName) throws Exception {
		
	driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");				
	Thread.sleep(5500);				
	Utils.Instance_NewWindow(driver);				
	driver.findElement(By.xpath("//*[@id='tabOpen']")).click();				
	JavascriptExecutor ex=(JavascriptExecutor)driver;				
		    			
	DOMConfigurator.configure("log4j.xml");				
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"QuoteSelMail");				
	int rowused = ExcelUtils.getRowUsed();				
					
	for (int i=1;i<=rowused;i++)				
	{				
	String TestCasename = sTestCaseName + "_"+i; 				
	int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.SelMail_TestCaseName);				
	Log.startTestCase(TestCasename);				
	iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);				
	   				
	String ShipMentID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_ShipMentID);				
	String SelMail_Shipment_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_Shipment_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarByNear_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByNear_Name);				
	String SelMail_CarByNear_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByNear_Mail);				
	String SelMail_CarByNear_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByNear_GUID);				
	System.out.println(SelMail_CarByNear_Name);				
	System.out.println(SelMail_CarByNear_Mail);				
	System.out.println(SelMail_CarByNear_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarByFreq_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByFreq_Name);				
	String SelMail_CarByFreq_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByFreq_Mail);				
	String SelMail_CarByFreq_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByFreq_GUID);				
	System.out.println(SelMail_CarByFreq_Name);				
	System.out.println(SelMail_CarByFreq_Mail);				
	System.out.println(SelMail_CarByFreq_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarPreLan_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreLan_Name);				
	String SelMail_CarPreLan_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreLan_Mail);				
	String SelMail_CarPreLan_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreLan_GUID);				
	System.out.println(SelMail_CarPreLan_Name);				
	System.out.println(SelMail_CarPreLan_Mail);				
	System.out.println(SelMail_CarPreLan_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarOrgHom_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarOrgHom_Name);				
	String SelMail_CarOrgHom_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarOrgHom_Mail);				
	String SelMail_CarOrgHom_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarOrgHom_GUID);				
	System.out.println(SelMail_CarOrgHom_Name);				
	System.out.println(SelMail_CarOrgHom_Mail);				
	System.out.println(SelMail_CarOrgHom_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarDesHom_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarDesHom_Name);				
	String SelMail_CarDesHom_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarDesHom_Mail);				
	String SelMail_CarDesHom_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarDesHom_GUID);				
	System.out.println(SelMail_CarDesHom_Name);				
	System.out.println(SelMail_CarDesHom_Mail);				
	System.out.println(SelMail_CarDesHom_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarPreOrg_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreOrg_Name);				
	String SelMail_CarPreOrg_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreOrg_Mail);				
	String SelMail_CarPreOrg_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreOrg_GUID);				
	System.out.println(SelMail_CarPreOrg_Name);				
	System.out.println(SelMail_CarPreOrg_Mail);				
	System.out.println(SelMail_CarPreOrg_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarPreDest_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreDest_Name);				
	String SelMail_CarPreDest_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreDest_Mail);				
	String SelMail_CarPreDest_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreDest_GUID);				
	System.out.println(SelMail_CarPreDest_Name);				
	System.out.println(SelMail_CarPreDest_Mail);				
	System.out.println(SelMail_CarPreDest_GUID);				
	System.out.println("--------------------------------------------------");				
	String SelMail_CarPreState_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreState_Name);				
	String SelMail_CarPreState_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreState_Mail);				
	String SelMail_CarPreState_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreState_GUID);				
	System.out.println(SelMail_CarPreState_Name);				
	System.out.println(SelMail_CarPreState_Mail);				
	System.out.println(SelMail_CarPreState_GUID);				
					
					
	try{				
					
	Thread.sleep(1500);				
	driver.findElement(By.xpath("//*[@id='textsearch']")).clear();				
	driver.findElement(By.xpath("//*[@id='textsearch']")).sendKeys(ShipMentID);				
	driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[1]/div[1]/div[1]/div/i[3]")).click();				
	driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::div//parent::div//parent::div/span[@id='availablecarriers']")).click();				
	Utils.Instance_NewWindow(driver);				
	Thread.sleep(3500);				
					
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);				
					
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_NearBy_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarPreLan_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
					
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_FREQUENCY_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarByNear_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
					
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_PREFERRED_LANE_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarPreLan_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_ORIGIN_BASEDHOME_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarOrgHom_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_DESTINATION_BASEDHOME_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarOrgHom_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_PREFERRED_ORIGIN_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarPreOrg_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_PREFERRED_DESTINATION_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarPreDest_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
	/********************************************************************************************************/				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.BY_PREFERRED_STATE_Button());				
	Thread.sleep(3600);				
					
	//ex.executeScript("arguments[0].click()", QuoteMail_Page.Select_CheckBox(SelMail_CarPreState_Name));				
	Utils.QuoteMail_2_AllCarriers(driver);				
	/********************************************************************************************************/				
	//AvailCarrier_Close Icon				
	ex.executeScript("arguments[0].click()", QuoteMail_Page.AvailCarrier_Close());				
					
	Thread.sleep(2900);				
	Utils.Instance_NewWindow(driver);				
					
	Thread.sleep(3000);				
					
	WebElement ShipMent2ID= driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::a//parent::div//parent::div//parent::div[1]/div[3]/div[1]/span/span/a"));				
	ex.executeScript("arguments[0].click()", ShipMent2ID);	   			
	Utils.Instance_NewWindow(driver);				
	 				
	List<String> email_Sent = Utils.Email_ReceipentList(SelMail_Shipment_GUID);				
					
	for(i=0;i<email_Sent.size();i++) 				
	{				
		System.out.println(email_Sent.get(i));			
	}				
					
	System.out.println(email_Sent);				
	//System.out.println(email_Sent_Count);				
					
	if(email_Sent.contains(SelMail_CarByNear_Mail))				
	{				
		System.out.println("SelMail_CarByNear_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarByNear_Mail+"--Missing");			
		System.out.println(SelMail_CarByNear_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarByFreq_Mail))				
	{				
		System.out.println("SelMail_CarByFreq_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarByFreq_Mail+"--Missing");			
		System.out.println(SelMail_CarByFreq_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarPreLan_Mail))				
	{				
		System.out.println("SelMail_CarPreLan_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarPreLan_Mail+"--Missing");			
		System.out.println(SelMail_CarPreLan_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarOrgHom_Mail))				
	{				
		System.out.println("SelMail_CarOrgHom_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarOrgHom_Mail+"--Missing");			
		System.out.println(SelMail_CarOrgHom_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarDesHom_Mail))				
	{				
		System.out.println("SelMail_CarDesHom_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarDesHom_Mail+"--Missing");			
		System.out.println(SelMail_CarDesHom_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarPreOrg_Mail))				
	{				
		System.out.println("SelMail_CarPreOrg_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarPreOrg_Mail+"--Missing");			
		System.out.println(SelMail_CarPreOrg_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarPreDest_Mail))				
	{				
		System.out.println("SelMail_CarPreDest_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarPreDest_Mail+"--Missing");			
		System.out.println(SelMail_CarPreDest_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
	if(email_Sent.contains(SelMail_CarPreState_Mail))				
	{				
		System.out.println("SelMail_CarPreState_Mail success");			
	}				
	else {				
		System.out.println("failure");			
		Utils.takeScreenshot(driver, SelMail_CarPreState_Mail+"--Missing");			
		System.out.println(SelMail_CarPreState_Mail+"--Missing"+"__Single Select mail not sent");			
	}				
	/********************************************************************************************************/				
					
					
	Thread.sleep(1600);				
	driver.findElement(By.xpath("//*[@ng-click='CloseRecipientcontent();']")).click();				
	Thread.sleep(2800);				
	Utils.Instance_NewWindow(driver);				
					
					
					
	}				
	catch (Exception e){				
	throw (e);				
					   }
					
	}				
					
	}				
					
	}				
					
					
					
