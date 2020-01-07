package postLoad_Alerts;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;
import utility_Files.Utils;

public class PostLoad_OverviewAlerts extends BaseClass{

public PostLoad_OverviewAlerts(WebDriver driver) {
		super(driver);
	}

@Test
public static void PostLoad_Overview() throws Exception {
	
	
	driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
    ShipDash_Post.Post_Shipement_Button().click();
	Thread.sleep(300);
		
		for (String Newly_Opened : driver.getWindowHandles()) {
			driver.switchTo().window(Newly_Opened); 
			}
		driver.manage().window().maximize();
		Thread.sleep(2500);
		
	String ShipperAlert_Text="Shipper Name is required";
	String TrailerTypeAlert_Text="Trailer Type field is required";
	String DispatchExecAlert_Text="Dispatch Executive field is required";

/*}public void All_Alerts () throws InterruptedException {*/	

	ShipDash_Post.Confirm_Button().click();
	Thread.sleep(300);
	String Alert_Message=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message);
	Thread.sleep(300);
	assertTrue(Alert_Message.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(Alert_Message.contains(DispatchExecAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(Alert_Message.contains(TrailerTypeAlert_Text));//Dispatch Exec. Shipper Empty Alert
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(500);
	//Reporter.log("Alert 1 - All alerts Success");
	System.out.println("Alert 1 - All alerts Success");
	
/*}public void Contains_ShipperAlert () throws InterruptedException {*/	
	Select Sale_drop=new Select(ShipDash_Post.Dispatch_Executive_DD());
	Sale_drop.selectByVisibleText("Thomas");
	Thread.sleep(300);
	Select Trailer_drop=new Select(ShipDash_Post.TrailerType_DD());
	Trailer_drop.selectByVisibleText("Reefer Drayage");
	Thread.sleep(300);
	ShipDash_Post.Confirm_Button().click();
	Thread.sleep(500);
	String Alert_Message1=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message1);
	Thread.sleep(300);
	assertTrue(Alert_Message1.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(!Alert_Message1.contains(TrailerTypeAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(!Alert_Message1.contains(DispatchExecAlert_Text));//Dispatch Exec. Shipper Empty Alert
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(500);
	//test.log(Status.PASS, "Alert 2 - Shipper alerts Success");
	System.out.println("Alert 2 - Shipper alerts Success");
	//extent.flush();
	
/*}public void Contains_TrailerType () throws InterruptedException {*/
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	WebElement Shipper_Name=driver.findElement(By.id("ShipperName"));
	Shipper_Name.sendKeys("BEN");
	ShipDash_Post.ShipperName_Selection().click();
	Thread.sleep(300);
	Trailer_drop.selectByVisibleText("Select Type");
	Thread.sleep(300);
	ShipDash_Post.Confirm_Button().click();
	Thread.sleep(300);
	String Alert_Message2=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message2);
	Thread.sleep(300);
	assertTrue(!Alert_Message2.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(Alert_Message2.contains(TrailerTypeAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(Alert_Message2.contains(DispatchExecAlert_Text));//Dispatch Exec. Shipper Empty Alert
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(300);
	//test.log(Status.PASS, "Alert 2 - Trailer alerts Success");
	System.out.println("Alert 2 - Trailer alerts Success");
	
/*}public void Contains_DispatchExecutive() throws InterruptedException {*/	
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	Sale_drop.selectByVisibleText("Select");
	Thread.sleep(300);
	Trailer_drop.selectByVisibleText("Reefer Drayage");
	Thread.sleep(300);
	ShipDash_Post.Confirm_Button().click();
	Thread.sleep(300);
	String Alert_Message3=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message3);
	Thread.sleep(300);
	assertTrue(!Alert_Message3.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(!Alert_Message3.contains(TrailerTypeAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(Alert_Message3.contains(DispatchExecAlert_Text));//Dispatch Exec. Shipper Empty Alert
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(300);
	//test.log(Status.PASS, "Alert 3 - Dispatch alerts Success");
	System.out.println("Alert 3 - Dispatch alerts Success");

/*	}public void Contains_DispatchExecutive_and_TrailerType() throws InterruptedException {*/	
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	Trailer_drop.selectByVisibleText("Select Type");
	Thread.sleep(300);	
	ShipDash_Post.Confirm_Button().click();	
	Thread.sleep(300);
	String Alert_Message4=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message4);	
	Thread.sleep(300);
	assertTrue(!Alert_Message4.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(Alert_Message4.contains(TrailerTypeAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(Alert_Message4.contains(DispatchExecAlert_Text));//Dispatch Exec. Shipper Empty Alert	
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(300);
	//test.log(Status.PASS, "Alert 4 - Dispatch & Trail alerts Success");
	System.out.println("Alert 4 - Dispatch & Trail alerts Success");
	
/*}public void Contains_ShipperName_and_DispatchExecutive() throws InterruptedException {*/	
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	ShipDash_Post.Shipper_Name().clear();
	Thread.sleep(300);	
	Trailer_drop.selectByVisibleText("Reefer Drayage");
	Thread.sleep(300);	
	ShipDash_Post.Confirm_Button().click();	
	Thread.sleep(300);
	String Alert_Message5=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message5);	
	Thread.sleep(300);
	assertTrue(Alert_Message5.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(!Alert_Message5.contains(TrailerTypeAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(Alert_Message5.contains(DispatchExecAlert_Text));//Dispatch Exec. Shipper Empty Alert	
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(500);
	//test.log(Status.PASS, "Alert 5 - Dispatch & Shipper alerts Success");
	System.out.println("Alert 5 - Dispatch & Shipper alerts Success");
	
/*}public void Contains_ShipperName_and_TrailerType() throws InterruptedException {*/
	Sale_drop.selectByVisibleText("Thomas");
	Thread.sleep(300);	
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	Trailer_drop.selectByVisibleText("Select Type");
	Thread.sleep(3000);	
	ShipDash_Post.Confirm_Button().click();	
	Thread.sleep(300);
	String Alert_Message6=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert_Message6);	
	Thread.sleep(300);
	assertTrue(Alert_Message6.contains(ShipperAlert_Text));//Checking Shipper Empty Alert
	assertTrue(Alert_Message6.contains(TrailerTypeAlert_Text));//Trailer Shipper Empty Alert
	assertTrue(!Alert_Message6.contains(DispatchExecAlert_Text));//Dispatch Exec. Shipper Empty Alert	
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(500);
	//test.log(Status.PASS, "Alert 6 - Trailer & Shipper alerts Success");
	System.out.println("Alert 6 - Trailer & Shipper alerts Success");
	Reporter.log(" Post Shipment Alerts - overview alerts Success");
	
	Shipper_Name.sendKeys("BEN");
	
	ShipDash_Post.ShipperName_Selection().click();
	Thread.sleep(500);
	
	Sale_drop.selectByVisibleText("Thomas");
	Thread.sleep(500);

	Trailer_drop.selectByVisibleText("Reefer Drayage");
	Thread.sleep(500);
	
	driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("7800");
	
	driver.findElement(By.xpath("//*[@id='truckrate']")).sendKeys("1850");

	driver.findElement(By.xpath("//*[@id='ShipmentSec']/div/div[2]/div[8]/textarea")).sendKeys("That interference with the passage");
	
	/*	WebElement Load_Schedule=driver.findElement(By.xpath("//*[@id='tempdrop']"));

	Select Load_Schd=new Select(Load_Schedule);

	Load_Schd.selectByIndex(2);*/

	driver.findElement(By.xpath("//*[@id='ShipmentSec']/div/div[3]/ul/li/input")).click();

	
	Thread.sleep(2500);

	Utils.takeScreenshot(driver, "Raaja");

}

}
