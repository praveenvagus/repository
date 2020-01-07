package loginPage_Validations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Pasword_Validation {
	
	@Test(priority=1)
	public void Check_Alerts_LoginPage() throws Exception {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\AmilFreight\\drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://stage.amilfreight.com/signin");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			
			//*******************************************************************************	
	   /*	String Username="Email Address / User Id is required.";
			String Password="Password is required.";
			driver.findElement(By.id("txtusername")).sendKeys("admin@ebintl.com");
			driver.findElement(By.id("btnSignIn")).click();
			Thread.sleep(600);
			String Password_Alert_Msg=driver.findElement(By.xpath("//*[@class='msgul'][2]")).getText();
			System.out.println(Password_Alert_Msg);
			Thread.sleep(500);
			Assert.assertTrue(Password_Alert_Msg.contains(Password),"Password error message is displayed");
			driver.findElement(By.id("btnNotiFyOk")).click();
		*/	//*******************************************************************************//	
		/*	driver.findElement(By.id("txtusername")).clear();
			driver.findElement(By.id("txtpassword")).clear();
			Thread.sleep(800);
			driver.findElement(By.id("txtpassword")).sendKeys("Admin@123");
			driver.findElement(By.id("btnSignIn")).click();
			Thread.sleep(600);
			String Username_Alert_Msg=driver.findElement(By.xpath("//*[@class='msgul'][2]")).getText();
			System.out.println(Username_Alert_Msg);
			Thread.sleep(500);
			Assert.assertTrue(Username_Alert_Msg.contains(Username),"Username error message is displayed");
			driver.findElement(By.id("btnNotiFyOk")).click();
		*/	//*******************************************************************************//	
		/*	driver.findElement(By.id("txtusername")).clear();
			driver.findElement(By.id("txtpassword")).clear();
			Thread.sleep(800);
			driver.findElement(By.id("btnSignIn")).click();
			Thread.sleep(600);
			String Username_Pass_Msg=driver.findElement(By.xpath("//*[@class='msgul'][2]")).getText();
			System.out.println(Username_Pass_Msg);
			Thread.sleep(500);
			Assert.assertTrue(Username_Pass_Msg.contains(Username),"Username error message is displayed");
			Assert.assertTrue(Username_Pass_Msg.contains(Password),"Password error message is displayed");
			driver.findElement(By.id("btnNotiFyOk")).click();
			
			String Password_Text="Admin@123";
			if(Password_Text.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
				
				System.out.println("Password macthed with Requirement Criteria");
			}
		 */
			driver.findElement(By.id("txtusername")).sendKeys("admin@ebintl.com");
			driver.findElement(By.id("txtpassword")).sendKeys("Admin@123");
			Thread.sleep(1500);
			driver.findElement(By.id("btnSignIn")).click();
			Thread.sleep(4500);

			driver.findElement(By.xpath("//*[@class='icon-arrow-down12']")).click();
			
			driver.findElement(By.xpath("//*[@onclick='objResetPassword.showResetPassword();']")).click();
			
			for (String winHandle : driver.getWindowHandles()) {
				 driver.switchTo().window(winHandle); }
			
			Thread.sleep(1800);
			driver.findElement(By.xpath("//*[@ng-click='UpdateCredentials(Credentials)']")).click();
			Thread.sleep(1800);
			String Username_Pass_Msg=driver.findElement(By.xpath("//*[@class='msgul'][2]")).getText();
			System.out.println(Username_Pass_Msg);
			driver.findElement(By.id("btnNotiFyOk")).click();
			
			driver.findElement(By.xpath("//*[@ng-model='Credentials.CurrentPassword']")).sendKeys("TN57PF2411");
			driver.findElement(By.xpath("//*[@ng-model='Credentials.NewPassword']")).sendKeys("TN57PF2411");
			driver.findElement(By.xpath("//*[@ng-model='Credentials.ConfirmPassword']")).sendKeys("TN57PF2411");
			
			Thread.sleep(1200);
			driver.findElement(By.xpath("//*[@ng-click='UpdateCredentials(Credentials)']")).click();
			Thread.sleep(800);
		
			
			driver.findElement(By.xpath("//*[@onclick='Message.ConfirmOk();']")).click();
			
			driver.close();
	}

}
