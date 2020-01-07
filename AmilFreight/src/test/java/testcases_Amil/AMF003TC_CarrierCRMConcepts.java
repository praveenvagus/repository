package testcases_Amil;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import carrier_CRM.Carrier_AMILvsCRM;
import carrier_CRM.Carrier_CRM;
import carrier_CRM.Carrier_SignUp;
import common_Operations.AmilCarrier_SignUp;
import common_Operations.AmilFreight_Login;
import postLoad_Alerts.PostLoad_AddDropAlert;
import postLoad_Alerts.PostLoad_AddPickUpAlert;
import postLoad_Alerts.PostLoad_AddPicturesAlert;
import postLoad_Alerts.PostLoad_AddReferenceAlert;
import postLoad_Alerts.PostLoad_OverviewAlerts;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;


public class AMF003TC_CarrierCRMConcepts
{
	public WebDriver driver;
	private String sTestCaseName;
	@SuppressWarnings("unused")
	private int iTestCaseRow;
	
@BeforeClass
public void Initializing_BrowserAmilFreight() throws Exception {
	  	DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		driver = Utils.Login_AmilFreight();
		new BaseClass(driver);  
}

@Test(priority=1)
public void LoggedIn_AmilFreight() throws Exception 
{
	// AmilCarrier_SignUp.Carrier_SignIn();
	 Thread.sleep(3300);
	// Carrier_SignUp.AddingNew_Carrier("CarrierSignUp");
}

@Test(priority=2)
public void Carrier_SignUp2() throws Exception 
{
	AmilFreight_Login.Amil_UserLogin();
	  Carrier_CRM.CarrierCRM_Verification("CarrierSignUp"); 
	  }

}



