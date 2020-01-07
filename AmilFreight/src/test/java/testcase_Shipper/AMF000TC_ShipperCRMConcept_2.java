package testcase_Shipper;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common_Operations.AmilFreight_Loggedout;
import common_Operations.AmilFreight_Login;
import shipper_CRM.Shipper_CRM2;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;


public class AMF000TC_ShipperCRMConcept_2
{
	public WebDriver driver;
	private String sTestCaseName;
	
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

	AmilFreight_Login.Amil_UserLogin();
	Reporter.log("Login with Admin Username & password - Successful");	  	
}
  
@Test(priority=2)
public void ShipperCRM_Prospect2Client() throws Exception
{

	Shipper_CRM2.CRM_Shipper("ShipperAdd2");	
	Reporter.log("ShipperCRM_Prospect2Client Section - Successful"); 
}	

@Test(priority = 3)
public void LoggedOut_AmilFreight() throws Exception {

	AmilFreight_Loggedout.Loggedout();
	Reporter.log("Logged Out from Amilfreight - Successful");	

	
}

	}



