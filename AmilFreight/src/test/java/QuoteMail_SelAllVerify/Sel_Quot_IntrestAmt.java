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

public class Sel_Quot_IntrestAmt extends BaseClass {
	
	public Sel_Quot_IntrestAmt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unused")
	@Test
	public static void Verification(String sTestCaseName) throws Exception {
		

		Thread.sleep(3700);								
		DOMConfigurator.configure("log4j.xml");						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"QuoteSelMail");						
		int rowused = ExcelUtils.getRowUsed();						
		System.out.println("Rowused"+rowused);						
								
		for (int i=1;i<=rowused;i++)						
		{						
		String TestCasename = sTestCaseName + "_"+i; 						
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.SelMail_TestCaseName);						
	  	Log.startTestCase(TestCasename);						
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);						
								
								
   		String Shipment_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_Shipment_GUID);						
   		String Quote_Amount=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_QuoteAmount$);						
   		System.out.println("--------------------------------------------------");						
		String SelMail_CarByNear_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByNear_Name);						
   		String SelMail_CarByNear_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByNear_Mail);						
   		String SelMail_CarByNear_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByNear_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarByFreq_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByFreq_Name);						
   		String SelMail_CarByFreq_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByFreq_Mail);						
   		String SelMail_CarByFreq_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarByFreq_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarPreLan_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreLan_Name);						
   		String SelMail_CarPreLan_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreLan_Mail);						
   		String SelMail_CarPreLan_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreLan_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarOrgHom_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarOrgHom_Name);						
   		String SelMail_CarOrgHom_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarOrgHom_Mail);						
   		String SelMail_CarOrgHom_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarOrgHom_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarDesHom_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarDesHom_Name);						
   		String SelMail_CarDesHom_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarDesHom_Mail);						
   		String SelMail_CarDesHom_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarDesHom_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarPreOrg_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreOrg_Name);						
   		String SelMail_CarPreOrg_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreOrg_Mail);						
   		String SelMail_CarPreOrg_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreOrg_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarPreDest_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreDest_Name);						
   		String SelMail_CarPreDest_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreDest_Mail);						
   		String SelMail_CarPreDest_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreDest_GUID);						
   		System.out.println("--------------------------------------------------");						
   		String SelMail_CarPreState_Name=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreState_Name);						
   		String SelMail_CarPreState_Mail=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreState_Mail);						
   		String SelMail_CarPreState_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_CarPreState_GUID);						
								
 								
Thread.sleep(2500);								
								
String CarByNear_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarByNear_GUID;								
System.out.println(CarByNear_URL);								
driver.navigate().to(CarByNear_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarByFreq_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarByFreq_GUID;								
System.out.println(CarByFreq_URL);								
driver.navigate().to(CarByFreq_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarPreLan_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarPreLan_GUID;								
System.out.println(CarPreLan_URL);								
driver.navigate().to(CarPreLan_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarOrgHom_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarOrgHom_GUID;								
System.out.println(CarOrgHom_URL);								
driver.navigate().to(CarOrgHom_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarDesHom_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarDesHom_GUID;								
System.out.println(CarDesHom_URL);								
driver.navigate().to(CarDesHom_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarPreOrg_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarPreOrg_GUID;								
System.out.println(CarPreOrg_URL);								
driver.navigate().to(CarPreOrg_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarPreDest_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarPreDest_GUID;								
System.out.println(CarPreDest_URL);								
driver.navigate().to(CarPreDest_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
String CarPreState_URL = "http://stage.amilfreight.com/external/Load/Quote/"+Shipment_GUID+"?con_id="+SelMail_CarPreState_GUID;								
System.out.println(CarPreState_URL);								
driver.navigate().to(CarPreState_URL);								
Thread.sleep(2900);   								
Utils.QuoteAmount_Submission(driver);								
System.out.println("--------------------------------------------------");								
								
								
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
								
								
if(email_Received.contains(SelMail_CarByNear_Mail))								
{								
System.out.println("SelMail_CarByNear_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarByNear_Mail+"--Missing");							
	System.out.println(SelMail_CarByNear_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarByFreq_Mail ))								
{								
System.out.println("SelMail_CarByFreq_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarByFreq_Mail+"--Missing");							
	System.out.println(SelMail_CarByFreq_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarPreLan_Mail))								
{								
System.out.println("SelMail_CarPreLan_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarPreLan_Mail+"--Missing");							
	System.out.println(SelMail_CarPreLan_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarOrgHom_Mail))								
{								
System.out.println("SelMail_CarOrgHom_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarOrgHom_Mail+"--Missing");							
	System.out.println(SelMail_CarOrgHom_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarDesHom_Mail))								
{								
System.out.println("SelMail_CarDesHom_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarDesHom_Mail+"--Missing");							
	System.out.println(SelMail_CarDesHom_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarPreOrg_Mail))								
{								
System.out.println("SelMail_CarPreOrg_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarPreOrg_Mail+"--Missing");							
	System.out.println(SelMail_CarPreOrg_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarPreDest_Mail))								
{								
System.out.println("SelMail_CarPreDest_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarPreDest_Mail+"--Missing");							
	System.out.println(SelMail_CarPreDest_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
if(email_Received.contains(SelMail_CarPreState_Mail))								
{								
System.out.println("SelMail_CarPreState_Mail -- All success");								
Check_Title();								
}								
else {								
	System.out.println("failure");							
	Utils.takeScreenshot(driver, SelMail_CarPreState_Mail+"--Missing");							
	System.out.println(SelMail_CarPreState_Mail+"--Missing"+"__Single Select mail not sent");							
}								
								
		}						
								
		}						
								
	public static void Check_Title() throws InterruptedException 							
	{							
		String Register_Msg=",Please wait until we redirect you to sign up page.....";						
		String Register_Msg1=driver.findElement(By.xpath("//*[@id='signupDiv']/div[2]/p")).getText();						
		if(Register_Msg1.equals(Register_Msg)) 						
		{						
			System.out.println(Register_Msg1);					
			assertTrue(Register_Msg.contains("sign up page"));					
		}						
		else 						
		{						
			String Success_Msg=driver.findElement(By.xpath("//*[@id='successDiv']/div[2]/p")).getText();					
			System.out.println(Success_Msg);					
			assertTrue(Success_Msg.contains("momentarily"));					
		}						
	}							
								
								
	}							
								
								

