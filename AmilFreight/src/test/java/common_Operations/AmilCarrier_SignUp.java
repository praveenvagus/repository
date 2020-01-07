package common_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utility_Files.BaseClass;
import utility_Files.Utils;

public class AmilCarrier_SignUp extends BaseClass {
	
	public AmilCarrier_SignUp(WebDriver driver) {
		super(driver);
	}

	@Test
	public static void Carrier_SignIn() throws Exception
	{
	
		Thread.sleep(2500);
		WebElement SignUp_Free=driver.findElement(By.xpath("//*[@class='dropdown-toggle nav-manual']"));
		Actions sign=new Actions(driver);
		sign.moveToElement(SignUp_Free).build().perform();
		Thread.sleep(2500);

		driver.findElement(By.xpath("//a[contains(@href,'/carriers/signup')]")).click();
		Utils.Instance_NewWindow(driver);
		Thread.sleep(2500);
}
}
