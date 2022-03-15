package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;

public class Locators extends BaseClass
{
	public Locators(WebDriver driver) {
		super(driver);
		}
	private static WebElement element = null;

	public static WebElement Click_PostLoad() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[2]/div/div[1]/div/div/i"));
        }
        catch (Exception e)
        {
            System.out.println("Click_PostLoad icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement LoadRef_ID() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id=\"SPluginRefernceId\"]"));
        }
        catch (Exception e)
        {
            System.out.println("LoadRef_ID icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Rate() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='SRate']"));
        }
        catch (Exception e)
        {
            System.out.println("Rate icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Trailer_Type() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='Strailertypeshipment']"));
        }
        catch (Exception e)
        {
            System.out.println("Trailer_Type icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Hazardous() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='SHazardous']"));
        }
        catch (Exception e)
        {
            System.out.println("Hazardous icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Special_Instructions() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='Sinstructions']"));
        }
        catch (Exception e)
        {
            System.out.println("Special_Instructions icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement PickUp_Location() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='origin0']"));
        }
        catch (Exception e)
        {
            System.out.println("PickUp_Location icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement PickUp_Date() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='pickupdate0']"));
        }
        catch (Exception e)
        {
            System.out.println("PickUp_Date icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement PickUp_PackageType() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='k0']/div[1]/div[6]/input"));
        }
        catch (Exception e)
        {
            System.out.println("PickUp_PackageType icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement PickUp_NoofPackage() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='numofpackages0']"));
        }
        catch (Exception e)
        {
            System.out.println("PickUp_NoofPackage icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement PickUp_MaterialType() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='PMaterialType0']"));
        }
        catch (Exception e)
        {
            System.out.println("PickUp_MaterialType icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement PickUp_weight() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='PickupWeight0']"));
        }
        catch (Exception e)
        {
            System.out.println("PickUp_weight icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Delivery_Location() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='destination0']"));
        }
        catch (Exception e)
        {
            System.out.println("Delivery_Location icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Delivery_Date() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='deliverydate0']"));
        }
        catch (Exception e)
        {
            System.out.println("Delivery_Date icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Delivery_PackageType() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='txtpackagingtype0']"));
        }
        catch (Exception e)
        {
            System.out.println("Delivery_PackageType icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Delivery_Noofpackage() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//input[@ng-model='destination.numofpackages']"));
        }
        catch (Exception e)
        {
            System.out.println("Delivery_Noofpackage icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Delivery_Weight() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='DeliveryWeight0']"));
        }
        catch (Exception e)
        {
            System.out.println("Delivery_Weight icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Delivery_MaterialType() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//input[@ng-model='destination.MaterialType']"));
        }
        catch (Exception e)
        {
            System.out.println("Delivery_MaterialType icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Save_ShipperPostLoad() throws Exception
	{
			try
        { 
            element = driver.findElement(By.xpath("//input[@ng-click='ValidateShipperPostLoad()']"));
        }
        catch (Exception e)
        {
            System.out.println("Save_ShipperPostLoad icon not available");
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
	public static WebElement LogOut()  throws Exception
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
	public static WebElement Confirm_logout()  throws Exception
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

}
