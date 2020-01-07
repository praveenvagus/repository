package postLoad_Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;

public class PostLoad_AddDropAlert extends BaseClass{

	public PostLoad_AddDropAlert(WebDriver driver) {
		super(driver);
		
	}

@Test
public static void PostLoad_AddDrop() throws Exception {
		

			Thread.sleep(2500);

			ShipDash_Post.Del_AddDelievery().click();
			for (String Newly_Opened : driver.getWindowHandles()) {
				driver.switchTo().window(Newly_Opened); 
				}
				
			ShipDash_Post.Del_CancelButton().click();				
			
			ShipDash_Post.Del_AddDelievery().click();				
					
			for (String Newly_Opened : driver.getWindowHandles()) {
				driver.switchTo().window(Newly_Opened); 
				}
			ShipDash_Post.Del_PackageType().clear();				
			
			ShipDash_Post.Del_MaterialType().clear();				
		
			ShipDash_Post.Del_Weight().clear();				
		

			ShipDash_Post.Del_DelLocation().sendKeys("Seattle Tx USA");				
			Thread.sleep(1000);				
			ShipDash_Post.Del_DelLocation().sendKeys(Keys.ARROW_DOWN);				
			ShipDash_Post.Del_DelLocation().sendKeys(Keys.ENTER);				
							
			Thread.sleep(300);							
			
			ShipDash_Post.Del_SubmitButton().click();				
			Thread.sleep(900);				
							
			String destination_Address_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
				
			Thread.sleep(500);				
			ShipDash_Post.AlertOk_button().click();				
							
			Thread.sleep(300);				
			System.out.println("1");			
			Assert.assertTrue(!destination_Address_Filled.contains("Destination Address"),"Destination address error message is displayed");				
			Assert.assertTrue(!destination_Address_Filled.contains("Delivery City / State"),"Delivery City / State error message is displayed");				
			Assert.assertTrue(destination_Address_Filled.contains("Date of Delivery"),"Date of Delivery error message is displayed");				
			Assert.assertTrue(destination_Address_Filled.contains("Packaging Type"),"Packaging Type error message is displayed");				
			Assert.assertTrue(destination_Address_Filled.contains("Weight"),"Weight error message is displayed");				
			Assert.assertTrue(destination_Address_Filled.contains("Material Type"),"Material Type error message is displayed");				
						
	
			ShipDash_Post.Del_DateDelivery().click();				
		
			driver.findElement(By.xpath("html/body/div[4]/div[3]/table/tbody/tr[5]/td[5]")).click();				
							
			Thread.sleep(300);				
						
			ShipDash_Post.Del_SubmitButton().click();				
			Thread.sleep(300);				
			String delivery_Date_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
					
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
			System.out.println("2");		
			Assert.assertTrue(!delivery_Date_Filled.contains("Pickup Address"),"Pickup address error message is displayed");				
			Assert.assertTrue(!delivery_Date_Filled.contains("PickUp City / State"),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!delivery_Date_Filled.contains("Date of Delivery"),"Date of Delivery error message is displayed");				
			Assert.assertTrue(delivery_Date_Filled.contains("Packaging Type"),"Packaging Type error message is displayed");				
			Assert.assertTrue(delivery_Date_Filled.contains("Weight"),"Weight error message is displayed");				
			Assert.assertTrue(delivery_Date_Filled.contains("Material Type"),"Material Type error message is displayed");				
			//Assert.assertTrue(delivery_Date_Filled.contains("Delivery From Time"),"Delivery From Time error message is displayed");				
			//Assert.assertTrue(delivery_Date_Filled.contains("Delivery To Time"),"Delivery To Time error message is displayed");				
						
			ShipDash_Post.Del_PackageType().sendKeys("boxes");				
			Thread.sleep(1500);				
			ShipDash_Post.Del_PackageType().sendKeys(Keys.ARROW_DOWN);				
			ShipDash_Post.Del_PackageType().sendKeys(Keys.ENTER);											
			Thread.sleep(300);				
		
			ShipDash_Post.Del_SubmitButton().click();				
			Thread.sleep(300);				
			String destination_Pacakage_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
					
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
			System.out.println("3");						
			Assert.assertTrue(!destination_Pacakage_Filled.contains("Pickup Address"),"Pickup address error message is displayed");				
			Assert.assertTrue(!destination_Pacakage_Filled.contains("PickUp City / State"),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!destination_Pacakage_Filled.contains("Date of Delivery"),"Date of Delivery error message is displayed");				
			Assert.assertTrue(!destination_Pacakage_Filled.contains("Packaging Type"),"Packaging Type error message is displayed");				
			Assert.assertTrue(destination_Pacakage_Filled.contains("Weight"),"Weight error message is displayed");				
			Assert.assertTrue(destination_Pacakage_Filled.contains("Material Type"),"Material Type error message is displayed");				
			//Assert.assertTrue(destination_Pacakage_Filled.contains("Delivery From Time"),"Delivery From Time error message is displayed");				
			//Assert.assertTrue(destination_Pacakage_Filled.contains("Delivery To Time"),"Delivery To Time error message is displayed");				
				
			ShipDash_Post.Del_MaterialType().sendKeys("glasses");				
							
			Thread.sleep(300);				
			
			ShipDash_Post.Del_SubmitButton().click();				
			Thread.sleep(300);				
			String destination_Material_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
					
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
			System.out.println("4");			
			Assert.assertTrue(!destination_Material_Filled.contains("Pickup Address"),"Pickup address error message is displayed");				
			Assert.assertTrue(!destination_Material_Filled.contains("PickUp City / State"),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!destination_Material_Filled.contains("Date of Delivery"),"Date of Delivery error message is displayed");				
			Assert.assertTrue(!destination_Material_Filled.contains("Packaging Type"),"Packaging Type error message is displayed");				
			Assert.assertTrue(destination_Material_Filled.contains("Weight"),"Weight error message is displayed");				
			Assert.assertTrue(!destination_Material_Filled.contains("Material Type"),"Material Type error message is displayed");				
			/*Assert.assertTrue(destination_Material_Filled.contains("Delivery From Time"),"Delivery From Time error message is displayed");				
			Assert.assertTrue(destination_Material_Filled.contains("Delivery To Time"),"Delivery To Time error message is displayed");		*/		

			ShipDash_Post.Del_FromDel().click();				
			driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a")).click();				
			driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a")).click();							
			Thread.sleep(300);				
			
			
			ShipDash_Post.Del_SubmitButton().click();				
			Thread.sleep(300);				
			String delivery_Time_Filled=ShipDash_Post.GetAll_Alert_Message().getText();				
						
			Thread.sleep(300);				
			ShipDash_Post.AlertOk_button().click();				
			System.out.println("9");	
			Assert.assertTrue(!delivery_Time_Filled.contains("Pickup Address"),"Pickup address error message is displayed");				
			Assert.assertTrue(!delivery_Time_Filled.contains("PickUp City / State"),"PickUp City / State error message is displayed");				
			Assert.assertTrue(!delivery_Time_Filled.contains("Date of Delivery"),"Date of Delivery error message is displayed");				
			Assert.assertTrue(!delivery_Time_Filled.contains("Packaging Type"),"Packaging Type error message is displayed");				
			Assert.assertTrue(delivery_Time_Filled.contains("Weight"),"Weight error message is displayed");				
			Assert.assertTrue(!delivery_Time_Filled.contains("Material Type"),"Material Type error message is displayed");				
			/*Assert.assertTrue(!delivery_Time_Filled.contains("Delivery From Time"),"Delivery From Time error message is displayed");				
			Assert.assertTrue(!delivery_Time_Filled.contains("Delivery To Time"),"Delivery To Time error message is displayed");	*/			

			ShipDash_Post.Del_Weight().sendKeys("1000");				
			Thread.sleep(300);	
			
			ShipDash_Post.Del_BusinessName().sendKeys("Jeffrin Powders");
			ShipDash_Post.Del_ContactName().sendKeys("Ravindira Jadeja");
			ShipDash_Post.Del_ContactNumber().sendKeys("9191919191");
			ShipDash_Post.Del_ContactEmail().sendKeys("ps4@gmail.com");
			
						
		
			ShipDash_Post.Del_SubmitButton().click();				
		 
		 Reporter.log(" Post Shipment Alerts - LOAD REFERENCE DETAILS alerts Success");
							
							
	}						
	}						
