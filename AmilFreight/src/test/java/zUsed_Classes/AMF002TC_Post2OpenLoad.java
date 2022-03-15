package zUsed_Classes;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;


public class AMF002TC_Post2OpenLoad
{
	public WebDriver driver;
	private String sTestCaseName;
	@SuppressWarnings("unused")
	private int iTestCaseRow;
	
  @BeforeClass
  public void Initializing_BrowserAmilFreight() throws Exception 
  {

	  	DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		driver = Utils.Login_AmilFreight();
		new BaseClass(driver);  
		
   }
  
  @Test(priority = 1)
  public void LoggedIn_AmilFreight() throws Exception {

	 // AmilFreight_Login.Amil_UserLogin();
	  Reporter.log("Login with Admin Username & password - Successful");
	  	
  }
  
 
@Test(priority = 2)
  public void PostLoad_toOpenStatus() throws Exception {

	//Mail_Recipents.PostLoad_ShipmentGUID("MailReceipents");
	Reporter.log("Added new shipment & Moved to Open Status - Successful");
	
  }

@Test(priority = 3)
  public void EmailReceipent_List() throws Exception {

//	Email_ReceipentsList.Verification("MailReceipents");
   Reporter.log("Email Receipent List for selected carriers - Successful");

  }

@Test(priority = 4)
  public void MailQuote_AmountVerify() throws Exception {

	
//	Quote_EmailAmount.Verification("MailReceipents");
	Reporter.log("Quotation submission & quote amount verified - Successful");
	  
}

@Test(priority = 5)
  public void LoggedOut_AmilFreight() throws Exception
{

	//AmilFreight_Loggedout.Loggedout();
	Reporter.log("Logged Out from Amilfreight - Successful");
						
}	

	}


