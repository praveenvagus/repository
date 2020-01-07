package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;

public class BlackList_Locators extends BaseClass
{
	public BlackList_Locators(WebDriver driver) {
		super(driver);
		}
	private static WebElement element = null;

	public static WebElement Search_carrierName()
	{
			try
        { 
            element = driver.findElement(By.xpath("//*[@id='txtsrchCompname']"));
        }
        catch (Exception e)
        {
            System.out.println("Search_carrierName icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Click_Search()
	{
			try
        { 
            element =	driver.findElement(By.xpath("//a[@onclick='objCarrier.searchcarrierlist();']"));
        }
        catch (Exception e)
        {
            System.out.println("Click_Search icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Click_BlackList()
	{
			try
        { 
            element =	driver.findElement(By.xpath("//a[@ng-click='ShowMoveToBlackList(companydetail.CompanyGuid,1,companydetail.IsCarrierInProgress,companydetail.CompanyName);']"));
        }
        catch (Exception e)
        {
            System.out.println("Click_BlackList icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Black_List_reason()
	{
			try
        { 
            element =	driver.findElement(By.xpath("//*[@id='ddlBlackListReason']"));
        }
        catch (Exception e)
        {
            System.out.println("Black_List_reason icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement Comments()
	{
			try
        { 
            element =driver.findElement(By.xpath("//*[@id='DivMoveToBlackListNew']/div[2]/textarea"));
        }
        catch (Exception e)
        {
            System.out.println("Comments icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement movetoBlacklist()
	{
			try
        { 
            element =driver.findElement(By.xpath("//a[@ng-click='MoveToBlackList();']"));
        }
        catch (Exception e)
        {
            System.out.println("movetoBlacklist icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement CRM_filter()
	{
			try
        { 
            element =	 driver.findElement(By.xpath("//i[@ng-click=\"PlaceFocus('divCompanyName')\"]"));
        }
        catch (Exception e)
        {
            System.out.println("CRM_filter icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement CRM_Search_CompanyNAme()
	{
			try
        { 
            element =		 driver.findElement(By.xpath("//input[@ng-model='AccountFilter.AccountName']"));
        }
        catch (Exception e)
        {
            System.out.println("Search_CompanyNAme icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement CRM_Click_Filter()
	{
			try
        { 
            element =	 driver.findElement(By.xpath("//a[@ng-click='searchCarrierAccountList(0); IsLoadingCarrier = true;']"));
        }
        catch (Exception e)
        {
            System.out.println("Click_Filter icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement CRM_move_Tab()
	{
			try
        { 
            element = driver.findElement(By.xpath("//a[@ng-click='ChangeCollection(2)']"));
        }
        catch (Exception e)
        {
            System.out.println("move_Tab icon not available");
            throw(e);
        }
		return element;
	}
	public static WebElement profile()
	{
			try
        { 
            element = 	driver.findElement(By.xpath("//a[@href='http://stage.amilfreight.com/carrier/profileView/7c23ce11-e6a3-4797-910b-53a1a963838e']"));
        }
        catch (Exception e)
        {
            System.out.println("profile icon not available");
            throw(e);
        }
		return element;
	}
	//*[@id="dmslist"]/div[2]/table/tbody/tr/td[3]
}

