package ztried_Sofar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility_Files.Utils;

public class AvailableTruck2 {

static WebDriver driver;
@Test(priority=1)
public void available_PostTruck() throws Exception {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\jenkins\\workspace\\AmilFreight\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		Thread.sleep(2500);
		driver.navigate().to("http://stage.amilfreight.com/external/Load/Quote/335f8abd-371e-4d27-97f0-52a33c71f427?con_id=d790d53d-01c4-48ba-8d37-f5ac519e8096");
		Thread.sleep(1900);
		
		Utils.QuoteAmount_Submission(driver);
		Thread.sleep(3500);
		String Text1=",Please wait until we redirect you to sign up page.....";
		String Text2=driver.findElement(By.xpath("//*[@id='signupDiv']/div[2]/p")).getText();
		System.out.println(Text1);
		System.out.println(Text2);
		Assert.assertTrue(Text1.equalsIgnoreCase(Text2),"Need to Login");

		Thread.sleep(3500);
		String Text3="Thank you for your interest on this load! We will get back to you momentarily.";
		String Text5=driver.findElement(By.xpath("//*[@id='successDiv']/div[2]/p")).getText();
		System.out.println(Text3);
		System.out.println(Text5);
		Assert.assertTrue(Text3.equalsIgnoreCase(Text5),"Success Page");

 		
	}
	
}

