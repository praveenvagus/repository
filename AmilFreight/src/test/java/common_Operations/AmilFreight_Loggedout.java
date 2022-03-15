package common_Operations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import locators_Amil.Amil_Login_Page;
import utility_Files.BaseClass;
import utility_Files.Utils;

public class AmilFreight_Loggedout extends BaseClass {

	public AmilFreight_Loggedout(WebDriver driver) {
		super(driver);
	}

	@Test
	public static void Loggedout() throws Exception
	{
	
		System.out.println(driver.getCurrentUrl());
	Thread.sleep(1800);
	Utils.Instance_NewWindow(driver);
	System.out.println(driver.getCurrentUrl());
	JavascriptExecutor ex=(JavascriptExecutor)driver;//
	ex.executeScript("arguments[0].click()", Amil_Login_Page.Loggedout_Icon());
	Thread.sleep(2500);
	ex.executeScript("arguments[0].click()", Amil_Login_Page.LoggedOut_BUtton());   	
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	ex.executeScript("arguments[0].click()",  Amil_Login_Page.LoggedOut_Confirm());
	Reporter.log("Alert 6 - Loggedout with Amilfreight Success");
	//driver.close();
	Thread.sleep(3000);
	
}
	
}