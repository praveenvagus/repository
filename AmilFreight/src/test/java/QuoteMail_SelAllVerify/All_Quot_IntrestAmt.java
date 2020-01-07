package QuoteMail_SelAllVerify;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class All_Quot_IntrestAmt extends BaseClass {
	
	public All_Quot_IntrestAmt(WebDriver driver) {
		super(driver);
		}

	@Test
	public static void Verification(String sTestCaseName) throws Exception {
		

		Thread.sleep(3700);
		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"QuoteAllMail");
		int rowused = ExcelUtils.getRowUsed();
		System.out.println("Rowused"+rowused);	
		
		for (int i=1;i<=rowused;i++)
		{
		String TestCasename = sTestCaseName + "_"+i; 	
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.AllMail_TestCaseName);
	  	Log.startTestCase(TestCasename);
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);


   		String Shipment_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_Shipment_GUID);						
   		//String Quote_Amount=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_QuoteAmount$);						
   		System.out.println("--------------------------------------------------");						
		String AllMail_CarByNear_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarByNear_Name);						
   		String AllMail_CarByNear_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarByNear_Mail);						
   		String AllMail_CarByNear_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarByNear_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarByFreq_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarByFreq_Name);						
   		String AllMail_CarByFreq_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarByFreq_Mail);						
   		String AllMail_CarByFreq_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarByFreq_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarPreLan_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreLan_Name);						
   		String AllMail_CarPreLan_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreLan_Mail);						
   		String AllMail_CarPreLan_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreLan_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarOrgHom_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarOrgHom_Name);						
   		String AllMail_CarOrgHom_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarOrgHom_Mail);						
   		String AllMail_CarOrgHom_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarOrgHom_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarDesHom_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarDesHom_Name);						
   		String AllMail_CarDesHom_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarDesHom_Mail);						
   		String AllMail_CarDesHom_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarDesHom_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarPreOrg_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreOrg_Name);						
   		String AllMail_CarPreOrg_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreOrg_Mail);						
   		String AllMail_CarPreOrg_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreOrg_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarPreDest_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreDest_Name);						
   		String AllMail_CarPreDest_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreDest_Mail);						
   		String AllMail_CarPreDest_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreDest_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String AllMail_CarPreState_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreState_Name);						
   		String AllMail_CarPreState_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreState_Mail);						
   		String AllMail_CarPreState_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.AllMail_CarPreState_GUID);						
 		
Thread.sleep(2500);
String CarByNear_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarByNear_GUID;
//System.out.println(CarByNear_URL);
driver.navigate().to(CarByNear_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
/*String CarByFreq_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarByFreq_GUID;
//System.out.println(CarByFreq_URL);
driver.navigate().to(CarByFreq_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
String CarPreLan_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarPreLan_GUID;
//System.out.println(CarPreLan_URL);
driver.navigate().to(CarPreLan_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
String CarOrgHom_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarOrgHom_GUID;
//System.out.println(CarOrgHom_URL);
driver.navigate().to(CarOrgHom_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
String CarDesHom_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarDesHom_GUID;
//System.out.println(CarDesHom_URL);
driver.navigate().to(CarDesHom_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
String CarPreOrg_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarPreOrg_GUID;
//System.out.println(CarPreOrg_URL);
driver.navigate().to(CarPreOrg_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
String CarPreDest_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarPreDest_GUID;
//System.out.println(CarPreDest_URL);
driver.navigate().to(CarPreDest_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
String CarPreState_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+AllMail_CarPreState_GUID;
//System.out.println(CarPreState_URL);
driver.navigate().to(CarPreState_URL);
Thread.sleep(2900);   
Utils.QuoteAmount_Submission(driver);
Thread.sleep(1000);
Check_Title();
System.out.println("--------------------------------------------------");
*/
driver.navigate().to("http://stage.amilfreight.com/shipment/details/"+Shipment_GUID);
Thread.sleep(8000);
List<WebElement> quote_Received = driver.findElements(By.xpath("//*[@id='onlineresponselist']/div[2]/div/div/div[3]/a"));   
List<String> email_Received = new ArrayList<>();
for(int j=1;j<=quote_Received.size();j++)
{
email_Received.add(driver.findElement(By.xpath("//*[@id='onlineresponselist']/div[2]/div/div["+j+"]/div[3]/a")).getText());
}
//System.out.println(quote_Received.size());
System.out.println(email_Received);


if(email_Received.contains(AllMail_CarByNear_Mail))
{
System.out.println("SelMail_CarByNear_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarByNear_Mail+"--Missing");
	System.out.println(AllMail_CarByNear_Mail+"--Missing"+"__Single Select mail not sent");
}
/*
if(email_Received.contains(AllMail_CarByFreq_Mail ))
{
System.out.println("SelMail_CarByFreq_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarByFreq_Mail+"--Missing");
	System.out.println(AllMail_CarByFreq_Mail+"--Missing"+"__Single Select mail not sent");
}

if(email_Received.contains(AllMail_CarPreLan_Mail))
{
System.out.println("SelMail_CarPreLan_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarPreLan_Mail+"--Missing");
	System.out.println(AllMail_CarPreLan_Mail+"--Missing"+"__Single Select mail not sent");
}

if(email_Received.contains(AllMail_CarOrgHom_Mail))
{
System.out.println("SelMail_CarOrgHom_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarOrgHom_Mail+"--Missing");
	System.out.println(AllMail_CarOrgHom_Mail+"--Missing"+"__Single Select mail not sent");
}

if(email_Received.contains(AllMail_CarDesHom_Mail))
{
System.out.println("SelMail_CarDesHom_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarDesHom_Mail+"--Missing");
	System.out.println(AllMail_CarDesHom_Mail+"--Missing"+"__Single Select mail not sent");
}

if(email_Received.contains(AllMail_CarPreOrg_Mail))
{
System.out.println("SelMail_CarPreOrg_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarPreOrg_Mail+"--Missing");
	System.out.println(AllMail_CarPreOrg_Mail+"--Missing"+"__Single Select mail not sent");
}

if(email_Received.contains(AllMail_CarPreDest_Mail))
{
System.out.println("SelMail_CarPreDest_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarPreDest_Mail+"--Missing");
	System.out.println(AllMail_CarPreDest_Mail+"--Missing"+"__Single Select mail not sent");
}

if(email_Received.contains(AllMail_CarPreState_Mail))
{
System.out.println("SelMail_CarPreState_Mail -- All success");
}
else {
	System.out.println("failure");
	Utils.takeScreenshot(driver, AllMail_CarPreState_Mail+"--Missing");
	System.out.println(AllMail_CarPreState_Mail+"--Missing"+"__Single Select mail not sent");
}
*/
		}

		}
	
	public static void Check_Title() throws InterruptedException 
	{
		String Register_Msg=",Please wait until we redirect you to sign up page.....";
		String Register_Msg1=driver.findElement(By.xpath("//*[@id='signupDiv']/div[2]/p")).getText();

		if(Register_Msg1.equals(Register_Msg1)) 
		{
			System.out.println(Register_Msg);
			assertTrue(Register_Msg.contains("sign up page"));
			System.out.println("Quote Amount Successful");
		}
		else 
		{
			System.out.println(Register_Msg);
			System.out.println(Register_Msg);
			String Success_Msg=driver.findElement(By.xpath("//*[@id='successDiv']/div[2]/p")).getText();
			System.out.println(Success_Msg);
			assertTrue(Success_Msg.contains("momentarily"));
			System.out.println("Quote Amount Successful2");
		}
	}
	
	
	}



