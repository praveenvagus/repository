package common_Operations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import locators_Amil.Amil_Login_Page;
import utility_Files.BaseClass;
import utility_Files.Constant;

public class AmilFreight_Login extends BaseClass
{

	public AmilFreight_Login(WebDriver driver) {
		super(driver);
	}

	@Test
	public static void Amil_UserLogin() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Amil_Login_Page.Signin_Navigator().click();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Amil_Login_Page.UserName_text().sendKeys(Constant.Amil_UserName);
		Amil_Login_Page.Password_text().sendKeys(Constant.Amil_Password);
		Amil_Login_Page.Signin_Button().click();
		Thread.sleep(900);
		System.out.println("Login Successful");
		
	}
}

