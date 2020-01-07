package zUsed_Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import zUsed_Classes.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class Email_ReceipentsList extends BaseClass {
	
	public Email_ReceipentsList(WebDriver driver) {
		super(driver);
		
	}

	@Test
	public static void Verification(String sTestCaseName) throws Exception {
		
	
Thread.sleep(5500);
Utils.Instance_NewWindow(driver);
driver.findElement(By.xpath("//*[@id='tabOpen']")).click();
JavascriptExecutor ex=(JavascriptExecutor)driver;
	    
DOMConfigurator.configure("log4j.xml");
ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"MailReceipents");
int rowused = ExcelUtils.getRowUsed();
			
for (int i=1;i<=rowused;i++)
{
String TestCasename = sTestCaseName + "_"+i; 	
int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.MailRecep_TestCaseName);
Log.startTestCase(TestCasename);
iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
   		
String CarrierSel_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierAll_Name);
String CarrierSel_Mail = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierAll_Mail);
String CarrierAll_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierSel_Name);
String CarrierAll_Mail = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierSel_Mail);
String ShipMentID=ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_ShipMentID);
/*System.out.println(CarrierAll_Name);
System.out.println(CarrierAll_Mail);
System.out.println(ShipMentID);
System.out.println(CarrierSel_Name);
System.out.println(CarrierSel_Mail);*/
	
try{
		
Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id='textsearch']")).clear();
driver.findElement(By.xpath("//*[@id='textsearch']")).sendKeys(ShipMentID);
driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[1]/div[1]/div[1]/div/i[3]")).click();
			
driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::div//parent::div//parent::div/span[@id='availablecarriers']")).click();
Utils.Instance_NewWindow(driver);
Thread.sleep(3500);

driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
WebElement BY_NEARBY=driver.findElement(By.xpath("//*[@id='carriersnearby']/a"));
WebElement BY_FREQUENCY=driver.findElement(By.xpath("//*[@id='loadfrequency']/a"));

WebElement BY_ORIGIN_BASEDHOME=driver.findElement(By.xpath("//*[@id='homebase']/a"));
WebElement BY_DESTINATION_BASEDHOME=driver.findElement(By.xpath("//*[@id='homebaseDestination']/a"));
WebElement BY_PREFERRED_ORIGIN=driver.findElement(By.xpath("//*[@id='PreferredOrigin']/a"));
WebElement BY_PREFERRED_DESTINATION=driver.findElement(By.xpath("//*[@id='PreferredDestination']/a"));
WebElement BY_PREFERRED_STATE=driver.findElement(By.xpath("//*[@id='preferredstates']/a"));


//BY_PREFERRED_LANE
WebElement BY_PREFERRED_LANE=driver.findElement(By.xpath("//*[@id='preferredlanes']/a"));
ex.executeScript("arguments[0].click()", BY_PREFERRED_LANE);
Thread.sleep(3600);

//SendQuote_Mail Drop Down
WebElement SendQuote_MailDrop=driver.findElement(By.xpath("//*[@id='matchingcarrierdiv']/div[1]/div/a"));
ex.executeScript("arguments[0].click()", SendQuote_MailDrop);

//SendQuote_2 All Carriers
WebElement SendQuote_2All=driver.findElement(By.xpath("//*[contains(text(),' To All')]//parent::a[@ng-click='showmail()']"));
ex.executeScript("arguments[0].click()", SendQuote_2All);

//SendQuote_2Selected Carriers
WebElement SendQuote_2Select=driver.findElement(By.xpath("//*[contains(text(),' To Selected ')]//parent::a[@ng-click='showsendmail();']"));
ex.executeScript("arguments[0].click()", SendQuote_2Select);

//Select_Specific Carrier CheckBox
WebElement Select_CheckBox=driver.findElement(By.xpath("//*[contains(text(), '"+CarrierAll_Name+"')]//parent::div/span[1]/input"));
ex.executeScript("arguments[0].click()", Select_CheckBox);

//Mail Preview_Send Button
WebElement Mail_SendButton=driver.findElement(By.xpath("//*[contains(text(), 'Send') and @ng-click='SENDSPOTLOADMAIL()']"));
ex.executeScript("arguments[0].click()", Mail_SendButton);

//Mail Preview_Close Icon
WebElement Mail_CloseIcon=driver.findElement(By.xpath("//*[@ng-click='Closemodal()']/i"));
ex.executeScript("arguments[0].click()", Mail_CloseIcon);

//AvailCarrier_Close Icon
WebElement AvailCarrier_Close=driver.findElement(By.xpath("//*[@ng-click='close();' and @title='Close']"));
ex.executeScript("arguments[0].click()", AvailCarrier_Close);









	



driver.findElement(By.xpath("//*[@id='tabOpen']")).click();	

Thread.sleep(3000);
    
Thread.sleep(2500);
    
WebElement ShipMent2ID= driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::a//parent::div//parent::div//parent::div[1]/div[3]/div[1]/span/span/a"));
ex.executeScript("arguments[0].click()", ShipMent2ID);	   
Utils.Instance_NewWindow(driver);
 
List<WebElement> email_Sent_Count = driver.findElements(By.xpath("//*[@id='Recipientlist']/div/table/tbody/tr"));
    
List<String> email_Sent = new ArrayList<>();
   
for(int j=1;j<=email_Sent_Count.size();j++)
{
email_Sent.add(driver.findElement(By.xpath("//*[@id='Recipientlist']/div/table/tbody/tr["+j+"]/td[1]/span/a")).getText());
}

System.out.println(email_Sent);
System.out.println(email_Sent_Count);

if(email_Sent.contains(CarrierSel_Mail))
{
	System.out.println("success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, CarrierSel_Mail+"--Missing");
	System.out.println(CarrierSel_Mail+"--Missing"+"*__Single Select mail not sent");
}
    
if(email_Sent.contains(CarrierAll_Mail))
{
	System.out.println("success");
} 
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, CarrierAll_Mail+"--Missing");	
	System.out.println(CarrierAll_Mail+"--Missing"+"__All mail not sent");
}
    
Thread.sleep(1600);
driver.findElement(By.xpath("//*[@ng-click='CloseRecipientcontent();']")).click();
Thread.sleep(2800);
Utils.Instance_NewWindow(driver);
   
ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.MailRecep_LoadResult);
//Reporter.log(" "+Carrier_Name+ "  Email receipents added & Verified - Successful");
Thread.sleep(2500);
		
	}
catch (Exception e){
ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.MailRecep_LoadResult);
//Utils.takeScreenshot(driver, CarrierAll_Name);
Reporter.log(" "+CarrierAll_Name+ "  Email receipents added & Verified - Unsuccessful");
Log.error(e.getMessage());
throw (e);
					}
		
	}

		}}



