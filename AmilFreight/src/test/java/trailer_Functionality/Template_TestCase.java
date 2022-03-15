package trailer_Functionality;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common_Operations.AmilFreight_Login;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;


public class Template_TestCase
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
public void LoggedIn_AmilFreight() throws Exception 
{

	AmilFreight_Login.Amil_UserLogin("Admin");
	
  	
}
  
@Test(priority=2)
public void LoggedOut_AmilFreight() throws Exception
{

SplitTrailerFunctionality.Task_Manager("LoadBoard");
	 
}	
			
}


