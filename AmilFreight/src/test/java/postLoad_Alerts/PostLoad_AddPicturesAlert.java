package postLoad_Alerts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;

public class PostLoad_AddPicturesAlert extends BaseClass{

	public PostLoad_AddPicturesAlert(WebDriver driver) {
		super(driver);
		
	}

	@Test
	public static void PostLoad_AddImage() throws Exception {
		
				Thread.sleep(1500);
				String Image_ALert="Invalid File";
				ShipDash_Post.Post_AddPictures().sendKeys("D:\\password.txt");
				Thread.sleep(2500);
				String Invalid_File=ShipDash_Post.GetAll_Alert_Message().getText();
				System.out.println(Invalid_File);
				ShipDash_Post.AlertOk_button().click();
	     		Assert.assertTrue(Invalid_File.contains(Image_ALert),"Invalid File msg is Displayed");
	     		Reporter.log(" Post Shipment Alerts - LOAD PICTURES alerts Success");
				Thread.sleep(1000);
	}
}
