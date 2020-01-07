package postLoad_Alerts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;

@SuppressWarnings("unused")
public class PostLoad_AddPickUpAlert extends BaseClass{

	public PostLoad_AddPickUpAlert(WebDriver driver) {
		super(driver);
	}

@Test
public static void PostLoad_AddPickUp() throws Exception {
	

	String PickUp_Address="Pickup Address";
	String PickUp_CityState="PickUp City / State";
	String PickUp_Date="Date of Pickup";
	String PickUp_TimeZone="PickUp Time Zone";
	String PickUp_PackType="Packaging Type";
	String PickUp_Weight="Weight";
	String PickUp_MaterialType="Material Type";


			ShipDash_Post.AddNew_Pickup().click();
			Thread.sleep(1500);


		
			ShipDash_Post.Post_Submit_Button().click();
			Thread.sleep(1500);
			
			String appointment_Error_Messages=ShipDash_Post.GetAll_Alert_Message().getText();
			//System.out.println(appointment_Error_Messages);
			Thread.sleep(1000);
			
			ShipDash_Post.AlertOk_button().click();
     		Assert.assertTrue(appointment_Error_Messages.contains(PickUp_Address),"Pickup address error message is displayed");
			Assert.assertTrue(appointment_Error_Messages.contains(PickUp_CityState),"PickUp City / State error message is displayed");
			Assert.assertTrue(appointment_Error_Messages.contains(PickUp_Date),"Date of Pickup error message is displayed");
			Assert.assertTrue(appointment_Error_Messages.contains(PickUp_PackType),"Packaging Type error message is displayed");
			Assert.assertTrue(appointment_Error_Messages.contains(PickUp_Weight),"Weight error message is displayed");
			Assert.assertTrue(appointment_Error_Messages.contains(PickUp_MaterialType),"Material Type error message is displayed");
			Assert.assertTrue(!appointment_Error_Messages.contains(PickUp_TimeZone),"TimeZone error message is displayed");
			//test.log(Status.PASS, "Alert 1 - All appointment_Error_Messages Displayed");
			Thread.sleep(1500);

			
			
			// fill the address
			ShipDash_Post.Pick_Picklocation().sendKeys("austin");
			//driver.findElement(By.id("originMainlocation")).sendKeys("austin");
			Thread.sleep(300);
			ShipDash_Post.Pick_Picklocation().sendKeys(Keys.ARROW_DOWN);							
			ShipDash_Post.Pick_Picklocation().sendKeys(Keys.ENTER);				
			Thread.sleep(300);				
							
		    //click the submit button					
			ShipDash_Post.Post_Submit_Button().click();				
			Thread.sleep(300);				
			String pickup_Address_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
			//System.out.println(pickup_Address_Filled);				
							
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
							
			Assert.assertTrue(!pickup_Address_Filled.contains(PickUp_Address),"Pickup address error message is displayed");				
			Assert.assertTrue(!pickup_Address_Filled.contains(PickUp_CityState),"PickUp City / State error message is displayed");				
			Assert.assertTrue(pickup_Address_Filled.contains(PickUp_Date),"Date of Pickup error message is displayed");	
			Assert.assertTrue(!pickup_Address_Filled.contains(PickUp_TimeZone),"TimeZone error message is displayed");
			Assert.assertTrue(pickup_Address_Filled.contains(PickUp_PackType),"Packaging Type error message is displayed");				
			Assert.assertTrue(pickup_Address_Filled.contains(PickUp_Weight),"Weight error message is displayed");				
			Assert.assertTrue(pickup_Address_Filled.contains(PickUp_MaterialType),"Material Type error message is displayed");				
			//test.log(Status.PASS, "Alert 3 - Pickup_Address_Filled Error_Messages Displayed");				
			//SDdtpickupdate				
			//driver.findElement(By.id("SDdtpickupdate")).click();				
			ShipDash_Post.Pick_PickUpDate().click();				
			driver.findElement(By.xpath("html/body/div[3]/div[3]/table/tbody/tr[5]/td[5]")).click();				
			Thread.sleep(300);				
							
			//click on the submit button				
			ShipDash_Post.Post_Submit_Button().click();				
			Thread.sleep(300);				
			String pickup_Date_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
			//System.out.println(pickup_Date_Filled);				
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
							
							
			Assert.assertTrue(!pickup_Date_Filled.contains(PickUp_Address),"Pickup address error message is displayed");				
			Assert.assertTrue(!pickup_Date_Filled.contains(PickUp_CityState),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!pickup_Date_Filled.contains(PickUp_Date),"Date of Pickup error message is displayed");
			Assert.assertTrue(!pickup_Date_Filled.contains(PickUp_TimeZone),"TimeZone error message is displayed");
			Assert.assertTrue(pickup_Date_Filled.contains(PickUp_PackType),"Packaging Type error message is displayed");				
			Assert.assertTrue(pickup_Date_Filled.contains(PickUp_Weight),"Weight error message is displayed");				
			Assert.assertTrue(pickup_Date_Filled.contains(PickUp_MaterialType),"Material Type error message is displayed");				
			//test.log(Status.PASS, "Alert 4 - Pickup_Date_Filled Error_Messages Displayed");				
			//fill the package type txtpackagingtype				
			ShipDash_Post.Pick_Package_Type().sendKeys("boxes");				
			Thread.sleep(1500);				
			ShipDash_Post.Pick_Package_Type().sendKeys(Keys.ARROW_DOWN);				
			ShipDash_Post.Pick_Package_Type().sendKeys(Keys.ENTER);				
			Thread.sleep(300);				
							
			ShipDash_Post.Post_Submit_Button().click();				
			Thread.sleep(300);				
			String pickup_Package_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
			//System.out.println(pickup_Package_Filled);				
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
			Assert.assertTrue(!pickup_Package_Filled.contains(PickUp_Address),"Pickup address error message is displayed");				
			Assert.assertTrue(!pickup_Package_Filled.contains(PickUp_CityState),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!pickup_Package_Filled.contains(PickUp_Date),"Date of Pickup error message is displayed");
			Assert.assertTrue(!pickup_Package_Filled.contains(PickUp_PackType),"Packaging Type error message is displayed");
			Assert.assertTrue(!pickup_Package_Filled.contains(PickUp_TimeZone),"TimeZone error message is displayed");
			Assert.assertTrue(pickup_Package_Filled.contains(PickUp_Weight),"Weight error message is displayed");				
			Assert.assertTrue(pickup_Package_Filled.contains(PickUp_MaterialType),"Material Type error message is displayed");				
			//test.log(Status.PASS, "Alert 5 - Pickup_Package_Filled Error_Messages Displayed");					
							
							
			//fill the material type 				
			//driver.findElement(By.id("PMaterialType")).sendKeys("glasses");				
			ShipDash_Post.Pick_Material_Type().sendKeys("glasses");				
							
			Thread.sleep(300);					
			ShipDash_Post.Post_Submit_Button().click();				
			Thread.sleep(300);				
			String pickup_Material_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
			//System.out.println(pickup_Material_Filled);				
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();							
			Assert.assertTrue(!pickup_Material_Filled.contains(PickUp_Address),"Pickup address error message is displayed");				
			Assert.assertTrue(!pickup_Material_Filled.contains(PickUp_CityState),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!pickup_Material_Filled.contains(PickUp_Date),"Date of Pickup error message is displayed");				
			Assert.assertTrue(!pickup_Material_Filled.contains(PickUp_PackType),"Packaging Type error message is displayed");
			Assert.assertTrue(!pickup_Material_Filled.contains(PickUp_MaterialType),"Material Type error message is displayed");
			Assert.assertTrue(!pickup_Material_Filled.contains(PickUp_TimeZone),"TimeZone error message is displayed");
			Assert.assertTrue(pickup_Material_Filled.contains(PickUp_Weight),"Weight error message is displayed");				
			//test.log(Status.PASS, "Alert 6 - Pickup_Material_Filled Error_Messages Displayed");	
			
			ShipDash_Post.Pick_Weight().sendKeys("1000");				
				
			ShipDash_Post.Post_Submit_Button().click();	
						
			Thread.sleep(1000);				
			
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//*[@id='EditPickUp']")).click();
			Thread.sleep(300);
	
			ShipDash_Post.Pick_Street().sendKeys("Losliya Eanjal");
			ShipDash_Post.Pick_ZipCode().sendKeys("3656878");
			
			Select Pic_TimeZ=new Select(ShipDash_Post.Pick_Post_TimeZone());
			Pic_TimeZ.selectByIndex(3);
			driver.findElement(By.xpath("//*[@id='ddlpickupfrom']")).click();
			driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[4]/td[6]/a")).click();
			driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[4]/td[3]/a")).click();
			
			ShipDash_Post.Pick_Business_Name().sendKeys("Paragon office");
			ShipDash_Post.Pick_Contact_Name().sendKeys("Thiruthuvaraj Robin");
			ShipDash_Post.Pick_Contact_Number().sendKeys("8787878778");
			ShipDash_Post.Pick_Contact_Email().sendKeys("ps2@gmail.com");

			ShipDash_Post.Pick_Package_Count().sendKeys("750");
			
			
			Thread.sleep(300);	
			ShipDash_Post.Post_Submit_Button().click();		
			Reporter.log(" Post Shipment Alerts - PICK-UP DETAILS alerts Success");
			//driver.close();
		
						
		
							
	}						
	}						
