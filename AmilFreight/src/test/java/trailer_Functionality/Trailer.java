package trailer_Functionality;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility_Files.BaseClass;

public class Trailer extends BaseClass {
	
public Trailer(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
String TrailerType="Van";
String TrailerNo="";
String TrailerVinNo="";
String trailerValue="";	
String Amil_Profile="http://stage.amilfreight.com/carrier/profileView/a57fde80-c3f8-411f-b12d-be7929ed255a";//URL of Amil Profile 
String BookNow="http://stage.amilfreight.com/shipment/book/cac08957-adb6-432c-baae-73954cf8fd2f";//URL of Open Shipment
String EDMS="http://stage.amilfreight.com/shipment/details/0151263f-e6b4-446d-a73d-abee7e1bdb54";//URL of EDMS 
String CRM_Profile="http://stage.amilfreight.com/crm/carrier/profile/a57fde80-c3f8-411f-b12d-be7929ed255a";//URL of CRM Profile
String today_testtrailer="Jan1809";
		
@Test(priority=1)
public void Login() throws InterruptedException
{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\repository\\AmilFreight\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1900);
		driver.navigate().to("http://stage.amilfreight.com/signin");//Need To Change
		Thread.sleep(1900);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("admin@ebintl.com");
		driver.findElement(By.cssSelector("input[name='txtpassword']")).sendKeys("Admin@123");
		driver.findElement(By.cssSelector("input[id='btnSignIn']")).click();	
		Thread.sleep(6000);
		
}

//Add Trailer in CRM and Check With Amil, EDMS and Booking Page
	@Test(priority=2)
	public void AddTrailerInCRM() throws Exception
	{
		TrailerNo="CRM_trailer".concat(today_testtrailer);
		TrailerVinNo="CRM_trailerVin".concat(today_testtrailer);
		driver.navigate().to(CRM_Profile);
		String carrier_CRM_Dashboard = driver.getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id='trailerinfodiv']/div[1]")));
		Thread.sleep(1000);
		
		SplitTrailer_Locators.SplitTrailer_TrailerAdd().click();
		Thread.sleep(2000);
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(tabs1.get(1));
		
		Select trailerSelect_pp= new Select(SplitTrailer_Locators.SplitTrailer_IN_TrailerType_DD());		
		trailerSelect_pp.selectByVisibleText(TrailerType);
		Thread.sleep(1000);	
		SplitTrailer_Locators.SplitTrailer_IN_TrailerNO().sendKeys(TrailerNo);
		SplitTrailer_Locators.SplitTrailer_IN_TrailerVinNO().sendKeys(TrailerVinNo);
		SplitTrailer_Locators.SplitTrailer_IN_TrailerSubmit().click();
		Thread.sleep(2000);
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tabs2.get(0));
		System.out.println("Title---"+driver.getTitle());
		List<WebElement> TrailersList_CRM=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
		String trailerValue="";
		for(int i =0; i<TrailersList_CRM.size();i++)
		{

			TrailersList_CRM.get(i).getText().toLowerCase();
			trailerValue+=TrailersList_CRM.get(i).getText().toLowerCase().concat(",");	

		}	
		
		if(trailerValue.toLowerCase().contains(TrailerNo.toLowerCase()))
		{
			assertTrue(trailerValue.toLowerCase().contains(TrailerNo.toLowerCase()));
		}
		else
		{
			assertTrue(!trailerValue.toLowerCase().contains(TrailerNo.toLowerCase()));
		}
		
		Set<String> all = driver.getWindowHandles();
		for(String winHandle :all)
		{
		    if(!winHandle.equals(carrier_CRM_Dashboard))
		    {
		        driver.switchTo().window(winHandle);
			    driver.close();

			 }
		 }
		    
		driver.switchTo().window(carrier_CRM_Dashboard);
		Thread.sleep(1000);		
		driver.navigate().to(Amil_Profile);
		Thread.sleep(2000);
		SplitTrailer_Locators.SplitTrailer_AmilTrailerTab().click();
		List<WebElement> TrailersList=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
		trailerValue="";
		for(int i =0; i<TrailersList.size();i++)
		{
			TrailersList.get(i).getText().toLowerCase();
			trailerValue+=TrailersList.get(i).getText().toLowerCase().concat(",");	
		}	
		if(trailerValue.toLowerCase().contains(TrailerNo.toLowerCase()))
		{
			assertTrue(trailerValue.toLowerCase().contains(TrailerNo.toLowerCase()));
		}
		else
		{
			assertTrue(!trailerValue.toLowerCase().contains(TrailerNo.toLowerCase()));
		}
			
		
		//*******EDMS
		Thread.sleep(2000);		
		driver.navigate().to(EDMS);
		Thread.sleep(2000);
	
		//Add
		WebElement Add_Trailer_BTN= driver.findElement(By.xpath("//span[@ng-click='ShowAddTrailerToggle()']"));		
		//Edit
		WebElement Edit_Trailer_BTN= driver.findElement(By.xpath("//a[@ng-click='editTrailerName()']"));
		WebElement we_trailerOptionsPP=driver.findElement(By.xpath("//*[@id='ddlCarrierTrailerId']"));
		
		if(Add_Trailer_BTN.isDisplayed()==true)
		{
			we_trailerOptionsPP.click();
		}
		
		if(Edit_Trailer_BTN.isDisplayed()==true)
		{
			Edit_Trailer_BTN.click();
			we_trailerOptionsPP.click();
		}
		Select trailer= new Select(we_trailerOptionsPP);
				
      List<WebElement> options = trailer.getOptions();  
      for(WebElement we:options)  
      {  
       for (int i=0; i<options.size(); i++){
           if (we.getText().equalsIgnoreCase(TrailerNo)){
       			assertTrue(we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
     		}
       		else
       		{
       			assertTrue(!we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
       		}
       }
      }		
    
		
		
		//************BOOK NOW SCREEN
      driver.navigate().to(BookNow);
      Thread.sleep(2000);
      SplitTrailer_Locators.BookNow_CarrierName().sendKeys("SHASWANK REDEMPTION");
      Thread.sleep(1000);
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
	    new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
      Thread.sleep(2000);
      SplitTrailer_Locators.BookNow_Trailer().click();		
		
		WebElement we_trailerOptionsBook=driver.findElement(By.xpath("//*[@id='ddltrailerid']"));
		Select trailerBook= new Select(we_trailerOptionsBook);
			
      List<WebElement> optionsBook = trailerBook.getOptions();  
      for(WebElement weBook:optionsBook)  
      {  
       for (int i=0; i<optionsBook.size(); i++){   
           if (weBook.getAttribute("textContent").equalsIgnoreCase(TrailerNo)){
          	assertTrue(weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));
           } 
           else
           {
          	assertTrue(!weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));

           }
           
         }
      } 
    
      Thread.sleep(3000);
	}
	
	
}
