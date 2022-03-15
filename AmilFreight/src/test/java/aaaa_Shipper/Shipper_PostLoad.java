package aaaa_Shipper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import locators_Amil.Locators;
import utility_Files.BaseClass;


public class Shipper_PostLoad extends BaseClass
{
	public Shipper_PostLoad(WebDriver driver) {
		super(driver);
		}

	@Test
	public static void shipperPostLoad(String sTestCaseName) throws Exception 
	{
		//-------------------------------------------------------Log Out Shipper Login----------------------------
		Locators.Toggle_LogOut().click();
		Locators.LogOut().click();
		Thread.sleep(1000);
		Locators.Confirm_logout().click();
		//-----------------------------------Login Admin Login------------------------------------------------------
		driver.navigate().to("http://stage.amilfreight.com/signin");
		Thread.sleep(2000);
		Locators.Login_user_Id().sendKeys("Stone");
		Locators.Login_Password().sendKeys("Admin@123");
		Locators.Login().click();
		Thread.sleep(1000);
		Locators.Click_PostLoad().click();
		String parentWinHandle = driver.getWindowHandle();
		System.out.println(parentWinHandle);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.manage().window().maximize();
		Locators.LoadRef_ID().sendKeys("Load2001");
		Locators.Rate().sendKeys("2000");
		Select Trailertype=new Select(Locators.Trailer_Type());
		Trailertype.selectByIndex(5);
		Select hazardous =new Select(Locators.Hazardous());
		hazardous.selectByVisibleText("Yes");
		Locators.Special_Instructions().sendKeys("hellooooooooooooooooooooooooooooooooooooooooooooooooooooooo Friends!!!!!!!!!!!!!!!!!!");
	//	----------------------------------------------PickUp Details----------------------------------------------------
		Thread.sleep(10000);
		Locators.PickUp_Location().sendKeys("San fr");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);	
		actions.moveToElement(Locators.PickUp_Location()).sendKeys(Keys.DOWN).perform();	
		actions.moveToElement(Locators.PickUp_Location()).sendKeys(Keys.ENTER).perform();	
		Locators.PickUp_Date().click();
		String xpath_Value="";
		xpath_Value="/html/body/div[4]/div[3]/table/tbody/tr";
		dateMethod(xpath_Value);
		Locators.PickUp_PackageType().sendKeys("kBox");
		Locators.PickUp_NoofPackage().sendKeys("12");
		Locators.PickUp_weight().sendKeys("200");
		Locators.PickUp_MaterialType().sendKeys("Books");
		//--------------------------------------------------Delivery Details---------------------------------
		Locators.Delivery_Location().sendKeys("Dall");
		Thread.sleep(5000);
		actions.moveToElement(Locators.Delivery_Location()).sendKeys(Keys.DOWN).perform();	
		actions.moveToElement(Locators.Delivery_Location()).sendKeys(Keys.ENTER).perform();	
		Locators.Delivery_Date().click();
		xpath_Value="/html/body/div[5]/div[3]/table/tbody/tr";
		dateMethod(xpath_Value);
		Locators.Delivery_PackageType().sendKeys("n12Box");
		Locators.Delivery_Noofpackage().sendKeys("12");
		Locators.Delivery_Weight().sendKeys("200");
		Locators.Delivery_MaterialType().sendKeys("Books");
		Thread.sleep(2000);
		Locators.Save_ShipperPostLoad().click();
		//-------------------------------------------------------Log Out Shipper Login----------------------------
		Locators.Toggle_LogOut().click();
		Locators.LogOut().click();
		Thread.sleep(1000);
		Locators.Confirm_logout().click();
		//-----------------------------------Login Admin Login------------------------------------------------------
		driver.navigate().to("http://stage.amilfreight.com/signin");
		Thread.sleep(2000);
		Locators.Login_user_Id().sendKeys("admin@ebintl.com");
		Locators.Login_Password().sendKeys("Admin@123");
		Locators.Login().click();
		Thread.sleep(1000);
		driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
		Locators.Search_ShipmentId().sendKeys("Load2001");
		Locators.Click_Tab().click();
	}

	public static void dateMethod(String xpath)
	{
	//System.out.println(xpath);
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        //Getting current date
	        Calendar cal = Calendar.getInstance();
	        String AvailableDate = sdf.format(cal.getTime());  
	        String[] arrSplit_Date = AvailableDate.split("/"); 
	        arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");
	        List<WebElement> dtRows=driver.findElements(By.xpath(xpath));  

	        for(int j=1;j<=dtRows.size();j++)
	        {
	        	for(int i=1;i <= 7;i++)
	        	{
	        	 String dateRowxpath= xpath;
	               String date_xpath ="["+j+"]";
	                     String dateRowxpath_first=dateRowxpath.concat(date_xpath);
	                     String date_td="/td";
	                     String date_tdvalue="["+i+"]";
	                     String date=date_td.concat(date_tdvalue);
	                     String datexpath_Complete=dateRowxpath_first.concat(date); 
	                     WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
	                     String date_text= dateElement.getText();
	                     if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
	                     {
	                            if((dateElement.getAttribute("class").contentEquals("day active"))||(dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
	                            {
	                                   dateElement.click();
	                                   i=8;
	                                   j=dtRows.size()+1;
	                                   
	                            }
	                            
	                     }
	        	}
	        }
	}
}

