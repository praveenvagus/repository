package QuoteMail_SelAllVerify;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common_Operations.AmilFreight_Loggedout;
import common_Operations.AmilFreight_Login;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;


public class Sel_MailQuote_TestCase
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

	  AmilFreight_Login.Amil_UserLogin("Admin");
	  Reporter.log("Login with Admin Username & password - Successful");
	    	
  }
  
 
@Test(priority = 2)
  public void PostLoad_toOpenStatus() throws Exception {

	Sel_Shipmnt_Post2Open.PostLoad_ShipmentGUID("QuoteSelMail");
	Reporter.log("Added new shipment & Moved to Open Status - Successful");
	
 }

@Test(priority = 2)
public void Open2_BookCarrier() throws Exception {

	//EDMS_WithMethod.MenuBar_Navigation("QuoteSelMail");
	Reporter.log("Added new shipment & Moved to Open Status - Successful");
	
}

@Test(priority = 3)
  public void EmailReceipent_List() throws Exception {
   
   Sel_AvailCar_MailRecp.Verification("QuoteSelMail");
   Reporter.log("Email Receipent List for selected carriers - Successful");

  }

@Test(priority = 4)
  public void MailQuote_AmountVerify() throws Exception {
	
	Sel_Quot_IntrestAmt.Verification("QuoteSelMail");
	Reporter.log("Quotation submission & quote amount verified - Successful");
	  
}

@Test(priority = 5)
  public void LoggedOut_AmilFreight() throws Exception
{

	AmilFreight_Loggedout.Loggedout();
	Reporter.log("Logged Out from Amilfreight - Successful");
						
}	

	}


