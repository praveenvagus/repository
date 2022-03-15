package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;

public class Carrier_LoadBoardLocators extends BaseClass
{
	public Carrier_LoadBoardLocators(WebDriver driver) {
		super(driver);
	}
	private static WebElement element = null;

	public static WebElement Search_ShipmentId() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='textsearch']"));
        }
        catch (Exception e)
        {
            System.out.println("Search_ShipmentId icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Click_Search() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//i[@ng-click='basicSearch($event)']"));
        }
        catch (Exception e)
        {
            System.out.println("Click_Search icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Click_Tab() throws Exception
	{
			try
        { 
            element =driver.findElement(By.xpath("//a[@ng-click='getTabShipmetList(null,0,11)']"));
        }
        catch (Exception e)
        {
            System.out.println("Click_Tab icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Click_EditShipment() throws Exception
	{
			try
        { 
            element =driver.findElement(By.xpath("//span[@ng-click='showLoadWindow(shipment.ShipmentGuid,3)']"));
        }
        catch (Exception e)
        {
            System.out.println("Click_EditShipment icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Special_Instruction() throws Exception
	{
			try
        { 
            element =driver.findElement(By.xpath("//textarea[@ng-model='shipment.SpecificInstructions']"));
        }
        catch (Exception e)
        {
            System.out.println("Special_Instruction icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Hazardous() throws Exception
	{
			try
        { 
            element =driver.findElement(By.xpath("//input[@ng-checked='shipment.IsHazardousMaterial']"));
        }
        catch (Exception e)
        {
            System.out.println("Hazardous icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Submit_Shipment() throws Exception
	{
			try
        { 
            element =driver.findElement(By.xpath("//button[@ng-click='confirmShipmentdetails(shipment)']"));
        }
        catch (Exception e)
        {
            System.out.println("Submit_Shipment icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Confirm_Shipment() throws Exception
	{
			try
        { 
            element =driver.findElement(By.xpath("//button[@ng-click='saveShipmentdetails(shipment)']"));
        }
        catch (Exception e)
        {
            System.out.println("Confirm_Shipment icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Toggle_LogOut() throws Exception
	{
        try
        { 
            element = driver.findElement(By.xpath("//*[@id='navbar-mobile']/div/ul/li/a/i"));
        }
        catch (Exception e)
        {
            System.out.println("Toggle_LogOut icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement LogOut() throws Exception
	{
        try
        { 
            element = driver.findElement(By.xpath("//*[@id='navbar-mobile']/div/ul/li/ul/li/div/div[2]/span[2]/a"));
        }
        catch (Exception e)
        {
            System.out.println("LogOut icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Confirm_logout() throws Exception
	{
        try
        { 
            element = driver.findElement(By.xpath("//*[@id='divConfirmbtn']"));
        }
        catch (Exception e)
        {
            System.out.println("Confirm_logout icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Login_user_Id() throws Exception
	{
        try
        { 
            element = driver.findElement(By.id("txtusername"));
        }
        catch (Exception e)
        {
            System.out.println("Login_user_Id icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Login_Password() throws Exception
	{
        try
        { 
            element =driver.findElement(By.id("txtpassword"));
        }
        catch (Exception e)
        {
            System.out.println("Login_Password icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Login() throws Exception
	{
        try
        { 
            element =driver.findElement(By.id("btnSignIn"));
        }
        catch (Exception e)
        {
            System.out.println("Login icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement LoadShip_id() throws Exception
	{
        try
        { 
            element =driver.findElement(By.xpath("//*[@id='searchshipmentid']"));
        }
        catch (Exception e)
        {
            System.out.println("LoadShip_id icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Search() throws Exception
	{
        try
        { 
            element =driver.findElement(By.xpath("//a[@ng-click='applyAdvSearch()']"));
        }
        catch (Exception e)
        {
            System.out.println("Search icon not available");
            throw(e);
        }
		return element;
	}
}
