package zUsed_Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import zUsed_Classes.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class Quote_EmailAmount extends BaseClass {
	
	public Quote_EmailAmount(WebDriver driver) {
		super(driver);
		}


	@Test
	public static void Verification(String sTestCaseName) throws Exception {
		

		Thread.sleep(5500);
		/*
		 * driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
		 * Thread.sleep(2300);
		 */
		driver.findElement(By.xpath("//*[@id='tabOpen']")).click();
		Thread.sleep(2500);
		
		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"MailReceipents");
		int rowused = ExcelUtils.getRowUsed();
		System.out.println("Rowused"+rowused);	
		
		for (int i=1;i<=rowused;i++)
		{
		String TestCasename = sTestCaseName + "_"+i; 	
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.MailRecep_TestCaseName);
	  	Log.startTestCase(TestCasename);
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);

   		String CarrierSel_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierAll_Name);
   		String CarrierSel_Mail = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierAll_Mail);
   		String CarrierSel_GUID = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierIDSel_GUID);
   		
   		String CarrierAll_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierSel_Name);
   		String CarrierAll_Mail = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierSel_Mail);
   		String CarrierAll_GUID = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_CarrierIDAll_GUID);
   		
		String Quote_Amount = ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_QuoteAmount$);
		String ShipMentID=ExcelUtils.getCellData(iTestCaseRow, Constant.MailRecep_ShipMentID);
		
			
try{

System.out.println(CarrierSel_Name);
System.out.println(CarrierSel_Mail);
System.out.println(CarrierSel_GUID);
System.out.println(CarrierAll_Name);
System.out.println(CarrierAll_Mail);
System.out.println(CarrierAll_GUID);


Thread.sleep(2500);
driver.findElement(By.xpath("//*[@id='textsearch']")).clear();
Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id='textsearch']")).sendKeys(ShipMentID);
driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[1]/div[1]/div[1]/div/i[3]")).click();
Thread.sleep(2500);

System.out.println("Penikkiya Joseph");
driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::div//parent::div//parent::div/span[@id='availablecarriers']")).click();

for (String Newly_Opened : driver.getWindowHandles()) {
	driver.switchTo().window(Newly_Opened); 
	}

String Shipper = driver.getCurrentUrl();
String[] Shipper_Part = Shipper.split("(/)");
String Shipper_GUID = Shipper_Part[5]; 
System.out.println(Shipper_GUID);

driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
WebElement ByPreferred_Lane=driver.findElement(By.xpath("//*[@id='preferredlanes']/a"));

JavascriptExecutor ex=(JavascriptExecutor)driver;//*[@id="preferredlanes"]/a
ex.executeScript("arguments[0].click()", ByPreferred_Lane);

ex.executeScript("arguments[0].click()", ByPreferred_Lane);
Thread.sleep(1500);
driver.close();

for (String Newly_Opened : driver.getWindowHandles()) {
	driver.switchTo().window(Newly_Opened); }

Thread.sleep(2500);

String quote_Url = "http://stage.amilfreight.com/external/Load/Quote/"+Shipper_GUID+"?con_id="+CarrierAll_GUID;
	         
driver.navigate().to(quote_Url);
Thread.sleep(5000);
		      
driver.findElement(By.id("txtAmount")).sendKeys(Quote_Amount);
		      
//click on the date field
driver.findElement(By.xpath("//*[@id='dtPickupTime']")).click();
		      
//clikc on the date
driver.findElement(By.xpath("html/body/div[3]/div[3]/table/tbody/tr[4]/td[6]")).click();
		      
//select the pikcup time
Select pickup_Hour = new Select(driver.findElement(By.id("PickupTimeHour")));
pickup_Hour.selectByIndex(10);
		      
//select the pickup minute
Select pickup_Minute = new Select(driver.findElement(By.id("PickupTimemin")));
pickup_Minute.selectByIndex(5);
		      
//select AM/PM
Select AM_PM = new Select(driver.findElement(By.id("PickupTimefor")));
AM_PM.selectByIndex(1);
		      
//select the drop date
driver.findElement(By.id("dtDropTime")).click();
driver.findElement(By.xpath("html/body/div[4]/div[3]/table/tbody/tr[6]/td[1]")).click();
		      
//select the drop hour
Select drop_hour = new Select(driver.findElement(By.id("DropoffTimeHour")));
drop_hour.selectByIndex(5);
		      
//select the drop minute
Select drop_Minute = new Select(driver.findElement(By.id("DropoffTimemin")));
drop_Minute.selectByIndex(5);
		      
//select AM/PM
Select AM_PM_Drop = new Select(driver.findElement(By.id("DropoffTimefor")));
AM_PM_Drop.selectByIndex(1);
		      
//give the contact name
driver.findElement(By.id("contactname")).sendKeys("Praveen Raja");
		      
//give phone number
driver.findElement(By.id("txtQuotePhoneNumber")).sendKeys("9159166877");
		      
//submit the quote
driver.findElement(By.xpath("//*[@id='divQuotation']/div/div/div[4]/div[3]/div[1]/div[4]/div")).click();
		      
Thread.sleep(2000);
		      
//go to the shipment details
driver.navigate().to("http://stage.amilfreight.com/shipment/details/"+Shipper_GUID);
Thread.sleep(8000);
		      
//quote received
List<WebElement> quote_Received = driver.findElements(By.xpath("//*[@id='onlineresponselist']/div[2]/div/div/div[3]/a"));
		      
List<String> email_Received = new ArrayList<>();
		      
//to add the email id in to the list
for(int j=1;j<=quote_Received.size();j++)
{
email_Received.add(driver.findElement(By.xpath("//*[@id='onlineresponselist']/div[2]/div/div["+j+"]/div[3]/a")).getText());

}

System.out.println(quote_Received.size());
System.out.println(email_Received);
		        
if(email_Received.contains(CarrierAll_Mail))
{
System.out.println(" All success");
}

if(email_Received.contains(CarrierSel_Mail))
{
System.out.println(" Sel success");
}

Thread.sleep(5000);

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.MailRecep_LoadResult);
Reporter.log(" "+CarrierAll_Name+ "  - Quotation submission & quote amount verified");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
		
catch (Exception e){
ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.MailRecep_LoadResult);
Utils.takeScreenshot(driver, CarrierAll_Name);
Reporter.log(" "+CarrierAll_Name+ "  - Quotation submission & quote amount verified - Unsuccessful");
Log.error(e.getMessage());
throw (e);
}

	}

		}}



