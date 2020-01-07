package praveen_Developing;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarrierSignupActions_Test extends BaseClass_OpenBrowser{
	
	String dot_Number ="45676";
	String account_Name = "Cello Caprika";
	
	public void Login() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='main-nav']/div/div[2]/div[3]/div/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("txtusername")).sendKeys("admin@ebintl.com");
		driver.findElement(By.id("txtpassword")).sendKeys("Admin@123");
		driver.findElement(By.id("btnSignIn")).click();	
		Thread.sleep(5000);
	}
	
	//To navigate to the Sign up section
	public void CarrierSignup() throws Exception
	{
				//store the window
				String sing_In = driver.getWindowHandle();
				
				//go to sign up section and select the carrier
//				Locators_CarrieSignup.SignupSections().click();
				driver.navigate().to("http://stage.amilfreight.com/carriers/signup");
				
				//click on the carrier
				//Locators_CarrieSignup.Signup_Carrier().click();
				
				//give the control to the sign up section
				Set<String> all_Windows;
				all_Windows = driver.getWindowHandles();
				
				for(String Winhandle : all_Windows)
				{
					if(!Winhandle.equals(sing_In))
					{
						driver.switchTo().window(Winhandle);
						Thread.sleep(2000);
						
					}
					else
					{
						driver.close();
					}
					
				}
				driver.manage().window().maximize();
		
	}
	
	
	//To navigate to the CRM section
	public void CRM_Navigation() throws InterruptedException
	{
		driver.navigate().to("http://stage.amilfreight.com/");
		Login();
		driver.navigate().to("http://stage.amilfreight.com/crm/sales/carrier-opt-v2");
	}
	
	//Check For lead stage - Submitted till Company Details
	@Test(priority=1)
	public void carrier_LeadStage() throws Exception
	{	

		CarrierSignup();
		JavascriptExecutor js = (JavascriptExecutor)driver;	

		String mc_Number = "892342";
		String street_Address = "15th North Street";
		String CityState="Austin, Texas(TX), US";
		String zipCode = "75667";
		String registration_Status = "In-Progress";

		//contact details required
		String contact_Name = "bond";
		String contact_Role = "Dispatcher";
		String contact_Phone = "9985667709";
		String extention = "289374";
		String contact_Email = "bondmovie@carrier.com";
		String tractor_Count = "4";
		String driver_Count = "4";
		
		//To enter DOT Number
		Locators_CarrieSignup.DotNumber().sendKeys(dot_Number);
		
		//To submit Dot
		Locators_CarrieSignup.SubmitDotNumber().click();
		Thread.sleep(5000);		
		
		//Navigate to the Profile Page
		Locators_CarrieSignup.creationLink().click();
		
		//*****************************Company Details*************************************
		//Company Profile
		Thread.sleep(5000);
		Locators_CarrieSignup.accountName().sendKeys(account_Name);
		
		//MC Number
		Locators_CarrieSignup.mcNumber().sendKeys(mc_Number);
		
		//Street Name
		Locators_CarrieSignup.streetName().sendKeys(street_Address);
		
		//City Name
		Locators_CarrieSignup.cityName().sendKeys(CityState);			
		Thread.sleep(5000);
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();

		//Zipcode		
		Locators_CarrieSignup.zip_Code().sendKeys(zipCode);		
		

		//**************************Contact Details***************************
		//Contact Name
		Locators_CarrieSignup.Contact_Name().sendKeys(contact_Name);
		
		//Contact Role
		Select role = new Select(Locators_CarrieSignup.contactRoles());
		role.selectByVisibleText(contact_Role);

		//Contact Number
		Locators_CarrieSignup.contactNumber().sendKeys(contact_Phone);

		//Extension
		Locators_CarrieSignup.extension().sendKeys(extention);

		//Eamil
		Locators_CarrieSignup.email().sendKeys(contact_Email);
		
		//************************Trailer Details**********************************
		//No.of Tractors
		Locators_CarrieSignup.no_Tractors().clear();
		Locators_CarrieSignup.no_Tractors().sendKeys(tractor_Count);

		//No.of Drivers
		Locators_CarrieSignup.no_Drivers().clear();
		Locators_CarrieSignup.no_Drivers().sendKeys(driver_Count);		
		
		//Trailer Selection
		for(int i=1 ; i<=4 ; i++)
		{
			WebElement trailer = driver.findElement(By.xpath("//*[@id='trailerType"+i+"']"));
			js.executeScript("arguments[0].click();", trailer);
		}
		
		//Submit
		Locators_CarrieSignup.submitDetails().click();
		Thread.sleep(5000);
		
//		driver.navigate().to("http://stage.amilfreight.com/");		
		CRM_Navigation();
		String carrier_CRM_Dashboard = driver.getWindowHandle();

		Thread.sleep(8000);
//		String carrier_CRM_Dashboard = driver.getWindowHandle();

		//filter the carrier who was added using the dot number
		js.executeScript("arguments[0].scrollIntoView()", Locators_CarrierCRM.dot_Find());

		//click on the filter
		Locators_CarrierCRM.Dot_Filter().click();
		Thread.sleep(3000);

		//send the filter criteria
		Locators_CarrierCRM.Dot_No_Text().sendKeys(dot_Number);

		//search
		Locators_CarrierCRM.Dot_No_Submit().click();
		Thread.sleep(3000);

		//go to Lead section
		Locators_CarrierCRM.Lead_Tab().click();
		Thread.sleep(5000);

		//scroll to the left in order to view the carrier profile
		//WebElement profile_Find = driver.findElement(By.id("carrierprofileview1"));
		js.executeScript("arguments[0].scrollIntoView()",Locators_CarrierCRM.profile_Find());
		Thread.sleep(5000);


		String Account_Name=Locators_CarrierCRM.profile_Find().getText();
		Assert.assertTrue(account_Name.equalsIgnoreCase(Account_Name), "account_Name");	
		
		Locators_CarrierCRM.profile_Find().click();
		
		driver.findElement(By.id("carrierprofileview1")).click();
		Thread.sleep(3000);

		//switch to the profile
		Set<String> allWindows;
		allWindows = driver.getWindowHandles();

		for(String winHandle : allWindows)
		{
			if(!winHandle.contentEquals(carrier_CRM_Dashboard))
			{
				driver.switchTo().window(winHandle);
				Thread.sleep(1000);
				
			}

		}
				
		String status_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[2]")).getText();
//		System.out.println("status" +status_Displayed);
		Assert.assertTrue(registration_Status.equalsIgnoreCase(status_Displayed), "status");
		driver.close();
		driver.switchTo().window(carrier_CRM_Dashboard);
		Logout();
		
	}
	
	//Check For lead stage - Submitted till Preferred Lanes Details
	@Test(priority=2)
	public void carrier_LeadStage_Lanes() throws Exception
	{
		CarrierSignup();
		JavascriptExecutor js = (JavascriptExecutor)driver;			
		String registration_Status = "In-Progress";



		//To enter DOT Number
		Locators_CarrieSignup.DotNumber().sendKeys(dot_Number);
				
		//To submit Dot
		Locators_CarrieSignup.SubmitDotNumber().click();
		Thread.sleep(5000);					

					
		//***************************lane Preferences*********************************
		Thread.sleep(5000);
					
		String origin_State="Saskatchewan (SK), CA";
		String destination_State="San Luis Potosí (SL), MX";
		String origin_City="Portland, Connecticut(CT), US";
		String destination_City="Dallas, Texas(TX), US";
		
		//Zone and State Details
		Locators_CarrieSignup.LaneZone().click();				
		
		//Origin State Details
		Locators_CarrieSignup.State_Origin().sendKeys(origin_State);	
		Thread.sleep(5000);
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);
			    
		//Destination State Details
		Locators_CarrieSignup.State_Destination().sendKeys(destination_State);	
		Thread.sleep(5000);
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);

		Locators_CarrieSignup.State_Submit().click();
			    
		//City Details
		//Origin City
		Thread.sleep(5000);

		Locators_CarrieSignup.City_Origin().sendKeys(origin_City);			
		Thread.sleep(5000);
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);
			    
		//Destination City
		Locators_CarrieSignup.City_Destination().sendKeys(destination_City);			
		Thread.sleep(5000);
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);
		    
		Locators_CarrieSignup.City_Submit().click();
		Thread.sleep(5000);

		driver.findElement(By.className("save")).click();
		Thread.sleep(5000);
				
		CRM_Navigation();
		String carrier_CRM_Dashboard = driver.getWindowHandle();
		Thread.sleep(8000);
			

		//filter the carrier who was added using the dot number
		js.executeScript("arguments[0].scrollIntoView()", Locators_CarrierCRM.dot_Find());
    	//click on the filter
		Locators_CarrierCRM.Dot_Filter().click();
		Thread.sleep(3000);

		//send the filter criteria
		Locators_CarrierCRM.Dot_No_Text().sendKeys(dot_Number);

    	//search
		Locators_CarrierCRM.Dot_No_Submit().click();
		Thread.sleep(3000);

		//go to Lead section
		Locators_CarrierCRM.Lead_Tab().click();
		//Locators_CarrierCRM.Contact_tab().click();
				
		Thread.sleep(5000);

		//scroll to the left in order to view the carrier profile
		//WebElement profile_Find = driver.findElement(By.id("carrierprofileview1"));
		js.executeScript("arguments[0].scrollIntoView()",Locators_CarrierCRM.profile_Find());
		Thread.sleep(1000);
			
		String Account_Name=Locators_CarrierCRM.profile_Find().getText();
		Assert.assertTrue(account_Name.equalsIgnoreCase(Account_Name), "account_Name");				
		Locators_CarrierCRM.profile_Find().click();
			
		driver.findElement(By.id("carrierprofileview1")).click();
		Thread.sleep(3000);

		//switch to the profile
		Set<String> allWindows;
		allWindows = driver.getWindowHandles();
		for(String winHandle : allWindows)
		{
			if(!winHandle.contentEquals(carrier_CRM_Dashboard))
			{
				driver.switchTo().window(winHandle);
				Thread.sleep(1000);
					
			}
		}
						
		String status_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[2]")).getText();
		//System.out.println("status" +status_Displayed);
		Assert.assertTrue(registration_Status.equalsIgnoreCase(status_Displayed), "status");
		driver.close();
		driver.switchTo().window(carrier_CRM_Dashboard);
		Logout();
		
	}
	
	//Check For Contact stage - Completed Registration
	@Test(priority=3)
	public void carrier_ContactStage() throws Exception
	{
		CarrierSignup();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
				
		String registration_Status = "Completed";
		String tax_Id = "982397956";
			
		String filePath = System.getProperty("user.dir");
		String FolderName = "\\Images_doc\\";

		String broker_Agreement_Doc = "BCA.jpg";
		String w9_Doc = "W9.jpg";
		String operating_Authority_Doc = "OA.jpg";
		String other_Doc = "others.jpg"; 
		String insurance_Doc ="Insurance.jpg";
			
		String general_Liability = "750000";
		String auto_Liability = "5000000";
		String cargo_Coverage = "100000";
		String workers_Comp = "100000";
		String reefer_Limit = "100000";
			
				
		//To enter DOT Number
		Locators_CarrieSignup.DotNumber().sendKeys(dot_Number);
			
		//To submit Dot
		Locators_CarrieSignup.SubmitDotNumber().click();
		Thread.sleep(5000);		
			    
		//Carrier Broker Agreement
		Locators_CarrieSignup.broker_Agreement().sendKeys(filePath+FolderName+broker_Agreement_Doc);
		Thread.sleep(5000);
				
		Locators_CarrieSignup.TaxId().sendKeys(tax_Id);

		//general liability
		Locators_CarrieSignup.GLLimits().sendKeys(general_Liability);				
		Locators_CarrieSignup.GLExpiry().click();
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);	    
		//Auto liability
		Locators_CarrieSignup.ALLimits().sendKeys(auto_Liability);
		Locators_CarrieSignup.ALExpiry().click();
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);	 
		//cargo coverage   
		Locators_CarrieSignup.CCLimits().sendKeys(cargo_Coverage);
		Locators_CarrieSignup.CCExpiry().click();
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		Thread.sleep(5000);	
		//workers comp
		Locators_CarrieSignup.Workers_Comp().sendKeys(workers_Comp);
    	//reefer limit
		Locators_CarrieSignup.ReeferWorkdown().sendKeys(reefer_Limit);

		//scroll down
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);


		Locators_CarrieSignup.Document_W9().sendKeys(filePath+FolderName+w9_Doc);
		Thread.sleep(5000);	 

		Locators_CarrieSignup.Document_OperatingAuthority().sendKeys(filePath+FolderName+operating_Authority_Doc);
		Thread.sleep(5000);	

		Locators_CarrieSignup.Document_CertificateOfInsurance().sendKeys(filePath+FolderName+insurance_Doc);
		Thread.sleep(5000);	
		Locators_CarrieSignup.Document_Other().sendKeys(filePath+FolderName+other_Doc);
		Thread.sleep(5000);	

		//term and conditions agree
		Locators_CarrieSignup.IAgreeCheck().click();
		//submit the paperwork section
		Locators_CarrieSignup.SubmitPaperWork().click();
		Thread.sleep(4000);
		
		CRM_Navigation();
			
		Thread.sleep(8000);
		String carrier_CRM_Dashboard = driver.getWindowHandle();
		//filter the carrier who was added using the dot number
		js.executeScript("arguments[0].scrollIntoView()", Locators_CarrierCRM.dot_Find());

		//click on the filter
		Locators_CarrierCRM.Dot_Filter().click();
		Thread.sleep(3000);

		//send the filter criteria
		Locators_CarrierCRM.Dot_No_Text().sendKeys(dot_Number);

		//search
		Locators_CarrierCRM.Dot_No_Submit().click();
		Thread.sleep(3000);

		//go to Lead section
		Locators_CarrierCRM.Contact_tab().click();
		Thread.sleep(5000);

		//scroll to the left in order to view the carrier profile			
		js.executeScript("arguments[0].scrollIntoView()",Locators_CarrierCRM.profile_Find());
		Thread.sleep(1000);			

		String Account_Name=Locators_CarrierCRM.profile_Find().getText();
		//System.out.println(Account_Name2);
		Assert.assertTrue(account_Name.equalsIgnoreCase(Account_Name), "account_Name");				
		Locators_CarrierCRM.profile_Find().click();
				
		driver.findElement(By.id("carrierprofileview1")).click();
		Thread.sleep(3000);
		//switch to the profile
		Set<String> allWindows;
		allWindows = driver.getWindowHandles();

		for(String winHandle : allWindows)
		{
			if(!winHandle.contentEquals(carrier_CRM_Dashboard))
			{
				driver.switchTo().window(winHandle);
				Thread.sleep(1000);
			}
		}
					Thread.sleep(5000);
		String status_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[3]")).getText();
    	//System.out.println("status" +status_Displayed);
		Assert.assertTrue(registration_Status.equalsIgnoreCase(status_Displayed), "status");
		driver.close();
		driver.switchTo().window(carrier_CRM_Dashboard);
		Logout();	
		driver.quit();
	}
	
	
//	@Test(priority=12)
	public void Logout() throws InterruptedException
	{
		//logout
		driver.findElement(By.xpath("//*[@id='navbar-mobile']/div/ul/li[3]/a/i")).click();
		Thread.sleep(5000);

		//confirm logout
		//driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click();
		driver.findElement(By.xpath("//*[@id='divConfirmCTRL']/div/div[2][text()='Are you sure, you want to logout?']/following-sibling::div/button[@id='divConfirmbtn']")).click();
		Thread.sleep(2000);
	}
	
}
