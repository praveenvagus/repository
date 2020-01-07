package postLoad_Alerts;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import common_Operations.AmilFreight_Loggedout;
import common_Operations.AmilFreight_Login;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;


public class AMF001TC_PostLoad_Alerts
{
	public WebDriver driver;
	private String sTestCaseName;
	@SuppressWarnings("unused")
	private int iTestCaseRow;
	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
	
  @BeforeClass
  public void Initializing_BrowserAmilFreight() throws Exception 
  {

	  	DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		driver = Utils.Login_AmilFreight();
		new BaseClass(driver); 
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
        
   }
  

  @Test(priority = 1)
  public void LoggedIn_AmilFreight() throws Exception {

	  AmilFreight_Login.Amil_UserLogin();
	  	
  }
  
  @Test(priority = 2)
  public void PostLoad_OverviewAlerts() throws Exception {

PostLoad_OverviewAlerts.PostLoad_Overview();
	
  }
  
  @Test(priority = 3)
  public void PostLoad_AddPickUpAlert() throws Exception {

	PostLoad_AddPickUpAlert.PostLoad_AddPickUp();

  }
  
  @Test(priority = 4)
  public void PostLoad_AddDropAlert() throws Exception {
	
	PostLoad_AddDropAlert.PostLoad_AddDrop();
	
  }
  
@Test(priority = 5)
  public void PostLoad_AddImageAlert() throws Exception {
		
  //PostLoad_AddPicturesAlert.PostLoad_AddImage();

  }
  
  @Test(priority = 6)
  public void PostLoad_AddReferenceAlert() throws Exception {
		
	//PostLoad_AddReferenceAlert.PostLoad_AddReference();
	  
  }

  @Test(priority = 7)
	public void LoggedOut_AmilFreight() throws Exception
 {

	//AmilFreight_Loggedout.Loggedout();
						
}	

 

	}


