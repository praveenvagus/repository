package praveen_Developing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import common_Operations.AmilFreight_Loggedout;
import common_Operations.AmilFreight_Login;
import locators_Amil.Locators_CarrieSignup;
import locators_Amil.Locators_CarrierCRM;
import utility_Files.BaseClass;
import utility_Files.Utils;


public class Raathathi_Raaja extends BaseClass{

	public Raathathi_Raaja(WebDriver driver) {
		super(driver);
	}
	
	@Test
	public static void Verification(String sTestCaseName) throws Exception {
	
	String dot_Number ="4564565";
	String account_Name = "Cello Caprika";
	String tax_Id = "982397956";
	
	driver.navigate().to("http://stage.amilfreight.com/carriers/signup");
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

System.out.println("******************************************");

driver.navigate().to("http://stage.amilfreight.com/");	

AmilFreight_Login.Amil_UserLogin();

driver.navigate().to("http://stage.amilfreight.com/crm/sales/carrier-opt-v2");

Thread.sleep(8000);
//String carrier_CRM_Dashboard = driver.getWindowHandle();

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
Utils.Instance_NewWindow(driver);
		
String status_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[2]")).getText();
//System.out.println("status" +status_Displayed);
Assert.assertTrue(registration_Status.equalsIgnoreCase(status_Displayed), "status");
driver.close();
Thread.sleep(3000);
Utils.Instance_NewWindow(driver);
Thread.sleep(3000);
AmilFreight_Loggedout.Loggedout();
Thread.sleep(3000);
driver.navigate().to("http://stage.amilfreight.com/carriers/signup");
Thread.sleep(3000);
//To enter DOT Number
		Locators_CarrieSignup.DotNumber().sendKeys(dot_Number);
			
		//To submit Dot
		Locators_CarrieSignup.SubmitDotNumber().click();
		Thread.sleep(5000);		
			    
		//***************************lane Preferences*********************************

							
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
		Thread.sleep(3500);
					    
				//Destination State Details
				Locators_CarrieSignup.State_Destination().sendKeys(destination_State);	
				Thread.sleep(5000);
				new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
				Thread.sleep(3500);

				Locators_CarrieSignup.State_Submit().click();
				
				//City Details
				//Origin City
				Thread.sleep(3500);

				Locators_CarrieSignup.City_Origin().sendKeys(origin_City);			
				Thread.sleep(5000);
				new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
				Thread.sleep(3500);
					    
				//Destination City
				Locators_CarrieSignup.City_Destination().sendKeys(destination_City);			
				Thread.sleep(5000);
				new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
				Thread.sleep(3500);
				    
				Locators_CarrieSignup.City_Submit().click();
				Thread.sleep(3500);

				driver.findElement(By.className("save")).click();
				Thread.sleep(3500);

				driver.navigate().to("http://stage.amilfreight.com/");	
				
				AmilFreight_Login.Amil_UserLogin();
				Thread.sleep(3000);
				
				driver.navigate().to("http://stage.amilfreight.com/crm/sales/carrier-opt-v2");
				
				Thread.sleep(3000);
				
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
					
	String Account_Name1=Locators_CarrierCRM.profile_Find().getText();
	Assert.assertTrue(account_Name.equalsIgnoreCase(Account_Name1), "account_Name");				
	Locators_CarrierCRM.profile_Find().click();
					
	driver.findElement(By.id("carrierprofileview1")).click();
	Thread.sleep(3000);
				
	Utils.Instance_NewWindow(driver);
	Thread.sleep(3000);
				
	String status_Displayed1 = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[2]")).getText();
	//System.out.println("status" +status_Displayed);
	Assert.assertTrue(registration_Status.equalsIgnoreCase(status_Displayed1), "status");
	driver.close();
	Utils.Instance_NewWindow(driver);
	
	AmilFreight_Loggedout.Loggedout();
	Thread.sleep(3000);
	driver.navigate().to("http://stage.amilfreight.com/carriers/signup");
	Thread.sleep(2900);
	
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
	
	
	driver.navigate().to("http://stage.amilfreight.com/");	
	
	AmilFreight_Login.Amil_UserLogin();
	
	driver.navigate().to("http://stage.amilfreight.com/crm/sales/carrier-opt-v2");
	
	Thread.sleep(5000);

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

	String Account_Name11=Locators_CarrierCRM.profile_Find().getText();
	//System.out.println(Account_Name2);
	Assert.assertTrue(account_Name.equalsIgnoreCase(Account_Name11), "account_Name");				
	Locators_CarrierCRM.profile_Find().click();
			
	driver.findElement(By.id("carrierprofileview1")).click();
	Thread.sleep(3000);
	//switch to the profile
	Utils.Instance_NewWindow(driver);
	Thread.sleep(3700);
	String registration_Status1="Completed";
	String status_Displayed11 = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[3]")).getText();
	System.out.println("status" +status_Displayed11);
	Assert.assertTrue(registration_Status1.equalsIgnoreCase(status_Displayed11), "status");

	Thread.sleep(3700);
	driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/a")).click();
	Thread.sleep(1700);
	driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[1]/ul/li/ul/li[3]")).click();
	
	String register_Status="CARRIER";
	String Status_DisplayCarrier = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/span[1]/span[2]")).getText();
	Assert.assertTrue(register_Status.equalsIgnoreCase(Status_DisplayCarrier), "status");
				
}

}
