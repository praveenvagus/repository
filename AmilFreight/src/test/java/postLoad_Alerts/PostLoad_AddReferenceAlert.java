package postLoad_Alerts;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;

public class PostLoad_AddReferenceAlert extends BaseClass{

	public PostLoad_AddReferenceAlert(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



@Test
public static void PostLoad_AddReference() throws Exception {
		
	
	ShipDash_Post.Post_RefAddNew().click();

	Thread.sleep(1500);
	
	ShipDash_Post.Post_RefLoadSpec().click();

	ShipDash_Post.Post_RefShipperSpec().click();
	Thread.sleep(1500);
	ShipDash_Post.Post_RefAdd().click();
	
	String Alert1=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert1);
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(1500);

	
	ShipDash_Post.Post_RefField().sendKeys("BEN");
	Thread.sleep(1500);
	ShipDash_Post.Post_RefAdd().click();
	String Alert2=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert2);
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(1500);

	ShipDash_Post.Post_RefField().clear();
	ShipDash_Post.Post_RefValue().sendKeys("BEN");
	ShipDash_Post.Post_RefAdd().click();
	String Alert3=ShipDash_Post.GetAll_Alert_Message().getText();
	System.out.println(Alert3);
	ShipDash_Post.AlertOk_button().click();
	Thread.sleep(1500);
	ShipDash_Post.Post_RefField().sendKeys("BEN");
	ShipDash_Post.Post_RefAdd().click();
	
	Thread.sleep(1500);
	ShipDash_Post.Close_Button().click();
	Reporter.log(" Post Shipment Alerts - LOAD REFERENCE DETAILS alerts Success");
	}						
}						
