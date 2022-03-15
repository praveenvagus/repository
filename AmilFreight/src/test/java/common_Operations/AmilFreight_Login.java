package common_Operations;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import locators_Amil.Amil_Login_Page;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;

public class AmilFreight_Login extends BaseClass
{

	public AmilFreight_Login(WebDriver driver) {
		super(driver);
	}

	@Test
	public static void Amil_UserLogin(String sTestCaseName) throws Exception
	{

	DOMConfigurator.configure("log4j.xml");
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"AmilUsers");
	int iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.UserLogin_Testcase);
  	Log.startTestCase(sTestCaseName);
	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
	System.out.println("Entering Login Page");

	String Username = ExcelUtils.getCellData(iTestCaseRow, Constant.UserLogin_Username);
	String Password = ExcelUtils.getCellData(iTestCaseRow, Constant.UserLogin_Password);
	System.out.println(Username);
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	Amil_Login_Page.Signin_Navigator().click();

	Amil_Login_Page.UserName_text().sendKeys(Username);
	Amil_Login_Page.Password_text().sendKeys(Password);
	Thread.sleep(2200);
	Amil_Login_Page.Signin_Button().click();
	Thread.sleep(900);
	System.out.println("Login Successful");
	Thread.sleep(5000);
	

}
}

