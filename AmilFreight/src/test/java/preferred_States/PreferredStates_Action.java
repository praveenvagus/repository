package preferred_States;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility_Files.BaseClass;

public class PreferredStates_Action extends BaseClass {
	
	public PreferredStates_Action(WebDriver driver) {
		super(driver);
		}

	static String PickupAddress_Full="";
	static String pickupadd_partial="";
	static String pickupState="";
	static String DeliveryAddress_Full="";
	static String Deliveryadd_partial="";
	static String deliveryState="";
	static String Shipment_EDMS_GUID="http://stage.amilfreight.com/shipment/details/006c15cb-c2af-4b85-a763-474a69dd3219";
	static String Carrier_Profile="http://stage.amilfreight.com/carrier/profileView/8e907267-6ec9-42a2-b175-5fc50a04d0e4";
	
	@Test
	public static void state(String sTestCaseName) throws InterruptedException
	{
		driver.navigate().to(Shipment_EDMS_GUID);
		Thread.sleep(3200);
		driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a")).click();
		Thread.sleep(1500);
		PickupAddress_Full=driver.findElement(By.xpath("//*[@id='fade-tab2']/div/div/div[1]/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/span[2]")).getText();
		pickupadd_partial=PickupAddress_Full.substring(0,PickupAddress_Full.indexOf("US"));
		String[] pickupState_split=pickupadd_partial.split(",");
		pickupState=pickupState_split[pickupState_split.length-2];

		DeliveryAddress_Full=driver.findElement(By.xpath("//*[@id='fade-tab2']/div/div/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/span[2]")).getText();
		Deliveryadd_partial=DeliveryAddress_Full.substring(0,DeliveryAddress_Full.indexOf("US"));
		String[] deliveryState_split=Deliveryadd_partial.split(",");
		deliveryState=deliveryState_split[deliveryState_split.length-2];

		driver.navigate().to(Carrier_Profile);
		StateValue_Exist(0);
		Thread.sleep(2000);
		
		driver.navigate().to(Shipment_EDMS_GUID);
		EDMS edms=new EDMS(driver);
		edms.edms_Complete(Carrier_Profile);
		
		Thread.sleep(2000);
		driver.navigate().to(Carrier_Profile);
		StateValue_Exist(1);
	}
	
public static void StateValue_Exist(int status) throws InterruptedException
	{
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@ng-click='ShowNewPreferredStates(companydetail)']")).click();
		Thread.sleep(1000);
		List<WebElement> StateList_Amil=driver.findElements(By.xpath("//*[@id='amilpreferredstatediv']/div[1]/div[1]/table/tbody/tr"));
		String StateListValue="";
		
		for(int i =0; i<StateList_Amil.size();i++)
		{
			System.out.println("kejse");
			StateList_Amil.get(i).getText().toLowerCase();
			StateListValue=StateList_Amil.get(i).getText().toLowerCase();
			String[] StateAlone=StateListValue.split(",");
			String plpickupstate = StateAlone[0].substring(StateAlone[0].indexOf("(")+1,StateAlone[0].indexOf(")"));			
			String pldeliverystate = StateAlone[1].substring(StateAlone[1].indexOf("(")+1,StateAlone[1].indexOf(")"));
			if(status==0) {
			if((!plpickupstate.equalsIgnoreCase(pickupState.trim()))&&(!pldeliverystate.equalsIgnoreCase(deliveryState.trim()))||((plpickupstate.equalsIgnoreCase(pickupState.trim()))&&(pldeliverystate.equalsIgnoreCase(deliveryState.trim()))))
			{
				Assert.assertTrue((!plpickupstate.equalsIgnoreCase(pickupState.trim()))&&(!pldeliverystate.equalsIgnoreCase(deliveryState.trim()))||((plpickupstate.equalsIgnoreCase(pickupState.trim()))&&(pldeliverystate.equalsIgnoreCase(deliveryState.trim()))));
			}
			
			}
			else if(status==1) {
				if((plpickupstate.equalsIgnoreCase(pickupState.trim()))&&(pldeliverystate.equalsIgnoreCase(deliveryState.trim())))
				{
					Assert.assertTrue((plpickupstate.equalsIgnoreCase(pickupState.trim()))&&(pldeliverystate.equalsIgnoreCase(deliveryState.trim())));
				}				
			}						
		}		
	}
}
