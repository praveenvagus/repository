package aaaa_Shipper;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import locators_Amil.Carrier_LoadBoardLocators;
import utility_Files.BaseClass;

public class Carrier_LoadBoard extends BaseClass
{
	public Carrier_LoadBoard(WebDriver driver) {
		super(driver);
		}

	@Test
	public static void Carrier_LoadBoard2()throws Exception
	{
		String ShipmentId="AFS19112100001";
		Carrier_LoadBoardLocators.Search_ShipmentId().sendKeys(ShipmentId);
		Thread.sleep(2000);
		Carrier_LoadBoardLocators.Click_Search().click();
		Thread.sleep(2000);
		Carrier_LoadBoardLocators.Click_Tab().click();
		Carrier_LoadBoardLocators.Click_EditShipment().click();
	   Thread.sleep(5000);
		String parentWinHandle = driver.getWindowHandle();
		System.out.println(parentWinHandle);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Carrier_LoadBoardLocators.Special_Instruction().sendKeys("I need a Biggggggggggggggggggggggggg Cakeeeeeeeeeeeeeeeeeeeeeeee");
		WebElement Hazardous=Carrier_LoadBoardLocators.Hazardous();
		Boolean HazardousCheckBox = Hazardous.isSelected();
		if (HazardousCheckBox == false)
		{
			Hazardous.click();
			System.out.println("Hazardous Meterial Checked");
		} 
		else 
		{
			System.out.println("Hazardous meterial not  Checked");
		}
		Carrier_LoadBoardLocators.Submit_Shipment().click();
		Carrier_LoadBoardLocators.Confirm_Shipment().click();
		Thread.sleep(1000);
		driver.switchTo().window(parentWinHandle);
		//-------------------------------------------------------Log Out Admin Login----------------------------
		Carrier_LoadBoardLocators.Toggle_LogOut().click();
		Carrier_LoadBoardLocators.LogOut().click();
		Thread.sleep(1000);
		Carrier_LoadBoardLocators.Confirm_logout().click();
		//-----------------------------------Login Carrier Login------------------------------------------------------
		driver.navigate().to("http://stage.amilfreight.com/signin");
		Carrier_LoadBoardLocators.Login_user_Id().sendKeys("katrina");
		Carrier_LoadBoardLocators.Login_Password().sendKeys("Admin@123");
		Carrier_LoadBoardLocators.Login().click();
		Thread.sleep(1000);
		Carrier_LoadBoardLocators.LoadShip_id().sendKeys(ShipmentId);
		Carrier_LoadBoardLocators.Search().click();
		Thread.sleep(3000);
		WebElement Hazardous1=driver.findElement(By.xpath("//span[@ng-show='shipment.HazardousMaterial']"));
		boolean HM=Hazardous1.isEnabled();
		if(HM==true)
		{
			System.out.println("Hazardous Material Checked");
		}
		else
		{
			System.out.println("Hazardous Material not  Checked");
		}
//		 WebElement Comments = driver.findElement(By.xpath("//*[@id='shipRpt ship']/div[1]/div[1]/span[1]/span[2]/a/i"));
//		 Actions act = new Actions(driver);
//	    act.moveToElement(Comments).perform();
//	    String tooltiptextreal = Comments.getAttribute("value"); 
//	    System.out.println(tooltiptextreal);
		String  tooltiptextreal="";
		tooltiptextreal=driver.findElement(By.xpath("//*[@id='shipRpt ship']/div[1]/div[1]/span[1]/span[2]/a/span[2]")).getAttribute("value");
		 System.out.println(tooltiptextreal);
	}
}
