package users_Login;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common_Operations.AmilFreight_Loggedout;
import common_Operations.AmilFreight_Login;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;

public class TaskMgmt_TestCase {

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
public void LoggedIn_AmilFreight1() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Account_Head");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 2)
public void LoggedIn_AmilFreight2() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Account_Lead");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 3)
public void LoggedIn_AmilFreight3() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Accounts_Executive");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 4)
public void LoggedIn_AmilFreight4() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Sales_Manager");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 5)
public void LoggedIn_AmilFreight5() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Sales_Rep");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 6)
public void LoggedIn_AmilFreight6() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Sales_Head");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 7)
public void LoggedIn_AmilFreight7() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Carrier_Executive");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 8)
public void LoggedIn_AmilFreight8() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Shipper");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 9)
public void LoggedIn_AmilFreight9() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Driver");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 10)
public void LoggedIn_AmilFreight10() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Dispatcher");
AmilFreight_Loggedout.Loggedout();
}
@Test(priority = 11)
public void LoggedIn_AmilFreight11() throws Exception 
{
AmilFreight_Login.Amil_UserLogin("Admin");
AmilFreight_Loggedout.Loggedout();
}

 

}



