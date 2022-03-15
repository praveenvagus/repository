package carrier_CRM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class Carrier_CRM extends BaseClass{

public Carrier_CRM(WebDriver driver) {
		super(driver);
		
}
	
@SuppressWarnings("unused")
@Test
public static void CarrierCRM_Verification(String sTestCaseName) throws Exception {	
	
		

	JavascriptExecutor js = (JavascriptExecutor)driver;	
	DOMConfigurator.configure("log4j.xml");
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"CarrierSignUp");
	int rowused = ExcelUtils.getRowUsed();
	System.out.println("Rowused"+rowused);	
		
	for (int i=1;i<=rowused;i++)
	{
	String TestCasename = sTestCaseName + "_"+i; 	
	int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.CarrierSign_TestCaseName);
  	Log.startTestCase(TestCasename);
		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
		System.out.println(iTestCaseRow);
		
		String Dot_Number = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_DotNumber);
		
	//Items REquired
			String dot_Number = Dot_Number;
			String account_Name = "Fathima Jeffrin Champers";
			String mc_Number = "892342";
			String street_Address = "15th North Street";
			String home_City = "AUSTIN";
			String home_State = "TEXAS";
			String zipCode = "75667";
			
			String registration_Status = "completed";
		
			//contact details required
			String contact_Name = "Praveen";
			String contact_Role = "Dispatcher";
			String contact_Phone = "9789406889";
			String extention = "289374";
			String contact_Email = "praveenrathi@carriera.com";
			String phone_Type = "Office";
			String tractor_Count = "4";
			String driver_Count = "4";
			
			//liability name
			List<String> liabilities = new ArrayList<>();
			liabilities.add("General Liability");
			liabilities.add("Auto Liability");
			liabilities.add("Cargo Coverage");
			
			//liability values

					String general_Liability = "750000";
					String auto_Liability = "5000000";
					String cargo_Coverage = "100000";
					String workers_Comp = "100000";
					String reefer_Limit = "100000";
					
					//tax information
					String tax_Id = "982397966";
					
					
					//give the preferred lanes
					List<String> origin_Lane = new ArrayList<>();
					origin_Lane.add("Portland, Connecticut(CT), US");
					origin_Lane.add("Bend, California(CA), US");
					
					List<String> destination_Lane  = new ArrayList<>();
					destination_Lane.add("Carrizo Hill, Texas(TX), US");
					destination_Lane.add("Jamestown, Pennsylvania(PA), US");
					
					//give the state lanes
					List<String> origin_State = new ArrayList<>();
					origin_State.add("Oregon");
					origin_State.add("Illinois");
					
					List<String> destination_State  = new ArrayList<>();
					destination_State.add("Arizona");
					destination_State.add("Louisiana");
					
					//select the number of states
					List<String> states = new ArrayList<>();
					states.add("AK");
					states.add("OR");
					
					//selected states expanded name
					List<String> states_In_Zone = new ArrayList<>();
					states_In_Zone.add("Alaska");
					states_In_Zone.add("Oregon");
					
					//Trailer Types
					List<String> trailer_Type = new ArrayList<>();
					trailer_Type.add("Flatbed");
					trailer_Type.add("Reefer");
					trailer_Type.add("Van");
					trailer_Type.add("Dump Trailer");
					
					Collections.sort(trailer_Type);	
					
					//payment thorugh company
					String payment_Mode = "Direct Payment";
					
					//payment type
					String payment_Type = "ACH";
					
					//documents to be checked if we are proceeding through company and follows check
					List<String> default_Documents = new ArrayList<>();
					default_Documents.add("W9.pdf");
					default_Documents.add("Other.pdf");
					default_Documents.add("Operating authority.pdf");
					default_Documents.add("Certificate Of Insurance.pdf");
					Collections.sort(default_Documents);
					
					//documents to be checked if the payment type is Factoring
					List<String> factoring_Documents = new ArrayList<>();
					factoring_Documents.add("W9.pdf");
					factoring_Documents.add("Other.pdf");
					factoring_Documents.add("Operating authority.pdf");
					factoring_Documents.add("Certificate Of Insurance.pdf");
					factoring_Documents.add("Notice Of Assignment.pdf");
					Collections.sort(factoring_Documents);
					
					//document to be checked if the payment is through company and follows ACH
					List<String> ach_Documents = new ArrayList<>();
					ach_Documents.add("ACH Form.pdf");
					ach_Documents.add("Bank Confirmation Letter.pdf");
					ach_Documents.add("Void Check.pdf");
					ach_Documents.add("W9.pdf");
					ach_Documents.add("Other.pdf");
					ach_Documents.add("Operating authority.pdf");
					ach_Documents.add("Certificate Of Insurance.pdf");
					Collections.sort(ach_Documents);
					
					//broker agreement
					String agreement_Doc = "Broker Carrier Agreement.pdf";
					
					//bank Details
					String bank_Name = "Bank one";
					String bank_Contact_Name = "bank contact name";
					String bank_Street_Address = "street name";
					String bank_City_State = "austin, texas(TX), us";
					String bank_Zipcode = "28934";
					String get_Bank_Complete_Address = bank_Street_Address+bank_City_State+bank_Zipcode;
					String bank_Complete_Address = get_Bank_Complete_Address.replaceAll("[^0-9]", "");
					String bank_Aba_Number = "234872938";
					String bank_Account_Number  ="92837498273894789";
					String bank_grantee_Name = "grantee name";
					
					//payment term
					String carrier_Payment_Term = "NET 2 (5%)";
			
					String Date_ForAll="10/22/2019";
			
			   /****************************************go to carrier CRM and Filter*************************************/
			    
   
			   //go to sign in page
				//driver.findElement(By.xpath("//*[@id='main-nav']/div/div[2]/div[3]/div/ul/li[1]/a")).click();
				System.out.println(Dot_Number+"Excel");
				System.out.println(dot_Number+"Excel7898");

				//go to carrier CRM
				driver.navigate().to("http://stage.amilfreight.com/crm/sales/carrier-opt-v2");
				Thread.sleep(3500);
				String carrier_CRM_Dashboard = driver.getWindowHandle();
				
				//filter the carrier who was added using the dot number
				//WebElement dot_Find = driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[4]/div/a/i"));
				//js.executeScript("arguments[0].scrollIntoView()", dot_Find);
				System.out.println("R3");
				//click on the filter
				driver.findElement(By.xpath("//*[@id='divDot']//parent::div/a/i[@class='filter-i icon-filter4']")).click();
				Thread.sleep(2000);
				System.out.println("R1");
				//send the filter criteria
				driver.findElement(By.name("txtsrchCRYname")).sendKeys(dot_Number);
				System.out.println("R2");
				//search
				driver.findElement(By.id("btnSrchCitystateList")).click();
				Thread.sleep(2000);
				
				//go to contact section
				driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a")).click();
				Thread.sleep(2000);
				
				//scroll to the left in order to view the carrier profile
				WebElement profile_Find = driver.findElement(By.id("carrierprofileview1"));
				js.executeScript("arguments[0].scrollIntoView()", profile_Find);
				Thread.sleep(2000);
				
				
				//open the profile
				driver.findElement(By.id("carrierprofileview1")).click();
				Thread.sleep(2000);
				
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
				
				
				driver.manage().window().maximize();
				
				//get all the details from basic info
				String account_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[1]/span")).getText();
				String dot_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[2]/span")).getText();
				
				
			    //getting only the integer value from MC
				String mc_Text = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[3]/span")).getText();
				String[] mc_Parts = mc_Text.split("-");
				String mc_Displayed = mc_Parts[1];
				
				
				//get the entire address and compare with the given address
				String physical_Address = "15TH NORTH STREET ,AUSTIN ,TEXAS ,75667";
				String[] add_Parts  =physical_Address.split(" ,");
				String street_Address_Displayed = add_Parts[0];
				String city_Displayed = add_Parts[1];
				String state_Displayed = add_Parts[2];
				String zip_Displayed = add_Parts[3];
				
				//status displayed
				String status_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span[3]")).getText();
				
				//basic info comaprison
				Assert.assertTrue(account_Name.equalsIgnoreCase(account_Displayed), "account");
				Assert.assertTrue(dot_Number.equals(dot_Displayed), "dotnumber");
				Assert.assertTrue(mc_Number.equalsIgnoreCase(mc_Displayed), "Mc");
				Assert.assertTrue(street_Address.equalsIgnoreCase(street_Address_Displayed), "street");
				Assert.assertTrue(home_City.equalsIgnoreCase(city_Displayed), "city");
				Assert.assertTrue(home_State.equalsIgnoreCase(state_Displayed), "State");
				Assert.assertTrue(zipCode.equalsIgnoreCase(zip_Displayed), "zipcode");
				Assert.assertTrue(registration_Status.equalsIgnoreCase(status_Displayed), "Status");
				
				//scroll to the contact section
				WebElement contact_Finder = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[1]"));
				js.executeScript("arguments[0].scrollIntoView()", contact_Finder);
				Thread.sleep(5000);
				
				//contact info comparison
				WebElement get_Contact_Name = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[1]"));
				String contact_Name_Displayed =get_Contact_Name.getAttribute("innerText");
				//contact number
				
				String get_Number = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/span/span[1]/a")).getText();
				String number_Displayed = get_Number.replaceAll("[^0-9]", "");
				
				String get_Extension = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/span/span[2]")).getText();
			    String extension_Displayed = get_Extension.replaceAll("[^0-9]", "");
			    
			    String phone_Type_Displayed = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]")).getText();
			    
			    
			    String email_Displayed = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[3]/a")).getText();
			    
			    String role_Displayed = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[4]")).getText();
			    
			    //to check that this is the primary contact
			  System.out.println(contact_Email+"++++++"+email_Displayed);
			    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[1]/a/i")).isDisplayed());
			    Assert.assertTrue(contact_Name.equalsIgnoreCase(contact_Name_Displayed), "contact name issue");
			    Assert.assertTrue(contact_Role.equalsIgnoreCase(role_Displayed), "role issue");
			    Assert.assertTrue(contact_Phone.equalsIgnoreCase(number_Displayed), "number issue");
			    Assert.assertTrue(extention.equalsIgnoreCase(extension_Displayed), "extension issue");
			    Assert.assertTrue(phone_Type.equalsIgnoreCase(phone_Type_Displayed), "phone type issue");
			    Assert.assertTrue(contact_Email.equalsIgnoreCase(email_Displayed), "email issue");
			    
			/*************************************document verification************************************************/
			    
			    //scroll to the document section
			    
			    WebElement document_finder = driver.findElement(By.xpath("//*[@id='documentsdiv']/div[1]"));
				js.executeScript("arguments[0].scrollIntoView()", document_finder);
				Thread.sleep(5000);
				
				List<String> document_In_CRM = new ArrayList<>();
				
				
				//total documents available
				List<WebElement> total_Documents = driver.findElements(By.xpath("//*[@id='collapsible-control-right-group3']/div/div/div[1]/table/tbody/tr"));
				for(int t=1; t<=total_Documents.size(); t++)
				{
					//get the document names and store it in a list
					String get_Document_Names = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group3']/div/div/div[1]/table/tbody/tr["+t+"]/td[1]/a")).getText();
					document_In_CRM.add(get_Document_Names);
					
				}
			    
			    //sorting the list for comparison
				Collections.sort(document_In_CRM);
				
				
				if(payment_Mode=="Direct Payment" && payment_Type=="ACH")
				{
					Assert.assertTrue(ach_Documents.equals(document_In_CRM), "ACH type document issue");
					
				}
				
				else if(payment_Mode=="Direct Payment" && payment_Type == "Check")
				{
					Assert.assertTrue(default_Documents.equals(document_In_CRM), "Check type issue");
					
				}
				else
				{
					Assert.assertTrue(factoring_Documents.equals(document_In_CRM), "Factorin doc issue");
					
				}
			    
			    //checking the broker carrier agreement
				String get_Broker_Agreement_Name = driver.findElement(By.xpath("//*[@id='divBrokerAgreement']/div[1]/table/tbody/tr/td[1]/a")).getText();
				
			    Assert.assertTrue(agreement_Doc.equals(get_Broker_Agreement_Name), "Broker agreement issue");
			    
			    //to check whether the document is in active status
			    String broker_Agreement_Status = driver.findElement(By.xpath("//*[@id='divBrokerAgreement']/div[1]/table/tbody/tr/td[4]")).getText();
			  
			    Assert.assertTrue("Active".contentEquals(broker_Agreement_Status));
			    
			    
			    
			    
			 
			/*************************************Inusrance Information check******************************************/
			    
			    WebElement insurance_finder = driver.findElement(By.xpath("//*[@id='insuranceinfodiv']"));
				js.executeScript("arguments[0].scrollIntoView()", insurance_finder);
				Thread.sleep(2000);
				
				//total liabilities given during the registration is "3"
				int liability_count = 3;
				
				//compare the liability names
				for(int m=1; m<=liability_count; m++)
				{
				String liability_Displayed = driver.findElement(By.xpath("//*[@id='insurancediv']/div[1]/div[1]/table/tbody/tr["+m+"]/td[1]")).getText();
				Assert.assertTrue(liabilities.get(m-1).equalsIgnoreCase(liability_Displayed), "Liability issue"+liability_Displayed);
				}
				
				Thread.sleep(2000);
				//limits check
				//general liability
				String get_General_Amount = driver.findElement(By.xpath("//*[@id='insurancediv']/div[1]/div[1]/table/tbody/tr[1]/td[5]")).getText();
				String general_Liability_Displayed = get_General_Amount.replaceAll("[^0-9]", "");
				Assert.assertTrue(general_Liability.equals(general_Liability_Displayed), "general liability amount issue");
				
				Thread.sleep(2000);
				
				//Auto Liability
				String get_Auto_Amount = driver.findElement(By.xpath("//*[@id='insurancediv']/div[1]/div[1]/table/tbody/tr[2]/td[5]")).getText();
				String auto_Liability_Displayed = get_Auto_Amount.replaceAll("[^0-9]", "");
				Assert.assertTrue(auto_Liability.equals(auto_Liability_Displayed), "auto liability amount issue");
				
				Thread.sleep(2000);
				
				//Cargo Insurance
				String get_Cargo_Amount = driver.findElement(By.xpath("//*[@id='insurancediv']/div[1]/div[1]/table/tbody/tr[3]/td[5]")).getText();
				String cargo_Coverage_Displayed = get_Cargo_Amount.replaceAll("[^0-9]", "");
				Assert.assertTrue(cargo_Coverage.equals(cargo_Coverage_Displayed), "cargo liability amount issue");
				
				/***********************************Invoice Setting*********************************************/
				
				//scroll to invoice settings section
				WebElement invoice_finder = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[4]/div[5]/div[8]"));
				js.executeScript("arguments[0].scrollIntoView()", invoice_finder);
				Thread.sleep(1000);
			
				//verify the TAx Id
				String tax_Id_Displayed = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[4]/span")).getText();
				Assert.assertTrue(tax_Id.equals(tax_Id_Displayed), "Tax id issue");
				
				//if the payment type is through company and follows ACH
				if(payment_Mode=="Direct Payment" && payment_Type=="ACH")
				{
					//payment mode
					String payment_Mode_Displayed = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[1]/span")).getText(); 
					Assert.assertTrue(payment_Mode.equalsIgnoreCase(payment_Mode_Displayed), "Payment Mode failed in Direct payment ACH");
					
					//Payment Type
					String payment_Type_Displayed = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[2]/span")).getText();
					Assert.assertTrue(payment_Type.equalsIgnoreCase(payment_Type_Displayed), "Payment Mode failed in Direct payment check");
					
					//bank name
					String get_bank_Name = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[5]/span")).getText();
					Assert.assertTrue(bank_Name.equalsIgnoreCase(get_bank_Name), "bank name issue");
					
					//bank contact name
					String get_Bank_Contact_Name = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[6]/span")).getText();
					Assert.assertTrue(bank_Contact_Name.equalsIgnoreCase(get_Bank_Contact_Name), "bank contact name issue");
					
					//bank address
					String get_Bank_Address = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[7]/span")).getText();
					String bank_Address_Displayed = get_Bank_Address.replaceAll("[^0-9]", "");
					Assert.assertTrue(bank_Complete_Address.equalsIgnoreCase(bank_Address_Displayed),"Bank address issue");
					
					//bank ABA number check
					String get_Bank_ABA_Number = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[1]/div[1]/span")).getText();
					Assert.assertTrue(bank_Aba_Number.equals(get_Bank_ABA_Number), "bank aba number issue");
					
					//bank account number check
					String get_Bank_Account_Number  =driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[1]/div[2]/span")).getText();
					Assert.assertTrue(bank_Account_Number.equals(get_Bank_Account_Number), "Account Number Issue");
					
					//get the grantee name and compare it
					String get_Grantee_Name = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[1]/div[3]/span")).getText();
					Assert.assertTrue(bank_grantee_Name.equalsIgnoreCase(get_Grantee_Name), "grantee name issue");
					
					
					//get the payment term and compare it
					String get_Payment_Term = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[3]/span")).getText();
					Assert.assertTrue(carrier_Payment_Term.equalsIgnoreCase(get_Payment_Term), "Payment term issue");
					
					
				}
				
				else if(payment_Mode=="Direct Payment" && payment_Type == "Check")
				{
					//payment mode
					String payment_Mode_Displayed = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[1]/span")).getText(); 
					Assert.assertTrue(payment_Mode.equalsIgnoreCase(payment_Mode_Displayed), "Payment Mode failed in Direct payment ACH");
					
					//Payment Type
					String payment_Type_Displayed = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[1]/div[2]/span")).getText();
					Assert.assertTrue(payment_Type.equalsIgnoreCase(payment_Type_Displayed), "Payment Mode failed in Direct payment check");
					
					//comparing the billing address with the physical address
				/*	String get_Physical_Address = physical_Address.replaceAll("[^0-9]", "");*/
					String get_Billing_Address = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[2]/span")).getText();
					String billing_Address_Displayed = get_Billing_Address.replaceAll("[^0-9]", "");
					
					Assert.assertTrue(physical_Address.equalsIgnoreCase(billing_Address_Displayed), "Billing address issue");
					
					//get the payment term and compare it
					String get_Payment_Term = driver.findElement(By.xpath("//*[@id='invoicediv']/div[1]/div[1]/div[2]/div[3]/span")).getText();
					Assert.assertTrue(carrier_Payment_Term.equalsIgnoreCase(get_Payment_Term), "Payment term issue");
					//*[@id="invoicediv"]/div[1]/div[1]/div[2]/div[2]/span
					
					
				}
				else
				{
					Assert.assertTrue(factoring_Documents.equals(document_In_CRM), "Factorin doc issue");
					
				}
				
				
			
/**********************************Preferred Lane Check*****************************************/
 
//if (a.replace(" ", "").equalsIgnoreCase(b.replace(" ", "")))
//c.replaceAll("[^a-zA-Z0-9]", "")
for(int n=1; n<=origin_Lane.size(); n++)
{
String origin_Displayed = driver.findElement(By.xpath("//*[@id='preferedlanelist']/div[1]/table/tbody/tr["+n+"]/td[1]")).getText();
String get_Origin_Lane = origin_Displayed.replaceAll("[^a-zA-Z0-9]", "");
System.out.println(origin_Displayed+"5444545"+get_Origin_Lane);
Assert.assertTrue(origin_Lane.get(n-1).replaceAll("[^a-zA-Z0-9]", "").equalsIgnoreCase(get_Origin_Lane), "Origin lane failed"+n);
for(int o=1; o<origin_Lane.size(); o++)
{
String destination_Displayed = driver.findElement(By.xpath("//*[@id='preferedlanelist']/div[1]/table/tbody/tr["+n+"]/td["+(o+1)+"]")).getText();
String get_Destination_Lane = destination_Displayed.replaceAll("[^a-zA-Z0-9]", "");
Assert.assertTrue(destination_Lane.get(n-1).replaceAll("[^a-zA-Z0-9]", "").equalsIgnoreCase(get_Destination_Lane), "destination lane failed"+n);
}	
}
				
/*********************************Preferred State check******************************************/
/*			
for(int p=1; p<=origin_State.size(); p++)
{
System.out.println(origin_State.size());	
String[] origin_State_Displayed = driver.findElement(By.xpath("//*[@id='preferredstatediv']/div[1]/table/tbody/tr["+p+"]/td[1]")).getText().split("\\(");
String get_Origin_State = origin_State_Displayed[0];
System.out.println(origin_State.get(p-1)+"     "+origin_State_Displayed[0]);
Assert.assertTrue(origin_State.get(p-1).equalsIgnoreCase(get_Origin_State), "Origin state failed"+p);	
for(int q=1; q<origin_Lane.size(); q++)
	{
String[] destination_State_Displayed = driver.findElement(By.xpath("//*[@id='preferredstatediv']/div[1]/table/tbody/tr["+p+"]/td["+(q+1)+"]")).getText().split("\\(");
String get_Destination_State = destination_State_Displayed[0];
Assert.assertTrue(destination_State.get(p-1).equalsIgnoreCase(get_Destination_State), "destination state failed"+p);
	}	
}
*/				
				
/************************************Zones and States*************************************/
//get the states from the 
				
for(int r=1; r<=states_In_Zone.size(); r++)
{
String zone_State_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group8']/div/div/div[1]/div[1]/ul/li/ul/li["+r+"]")).getText();
Assert.assertTrue(states_In_Zone.get(r-1).equals(zone_State_Displayed), "zones state issue"+r);
}

/*******************************Trailer Info*********************************************/
				
//go to the trailer section by scrolling
WebElement trailer_finder = driver.findElement(By.xpath("//*[@id='trailerinfodiv']/div[1]/h6/a"));
js.executeScript("arguments[0].scrollIntoView()", trailer_finder);
Thread.sleep(1000);
				
//tractor count check
String tractor_Count_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group9']/div/div[1]/div[1]/div[1]/span")).getText();
Assert.assertTrue(tractor_Count.equals(tractor_Count_Displayed), "Tractor count issue");
				
//driver count check
String driver_Count_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group9']/div/div[1]/div[1]/div[2]/span")).getText();
Assert.assertTrue(driver_Count.equals(driver_Count_Displayed), "Driver count issue");
				
				//get the trailer and compare
				//"//*[@id='collapsible-control-right-group9']/div/div[1]/div[1]/div[3]/div[1]/div/ul/li[1]/span[1]"
				
				for(int s=1; s<=trailer_Type.size(); s++)
				{
					String trailer_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group9']/div/div[1]/div[1]/div[3]/div[1]/div/ul/li["+s+"]/span[1]")).getText();
					Assert.assertTrue(trailer_Type.get(s-1).equals(trailer_Displayed), "Trailer type issue"+s);
					
				}
				
				/*****************************************************************************************/
				
				//scroll to the bottom to check the other information
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(1000);

				//verify the reefer value
				String get_Reefer_Amount = driver.findElement(By.xpath("//*[@id='otherInfodiv']/div/div[1]/div[1]/span")).getText();
				String reefer_Displayed = get_Reefer_Amount.replaceAll("[^0-9]", "");
				
				Assert.assertTrue(reefer_Limit.equals(reefer_Displayed), "Reefer Failed");
				
				
				//verifyt the workers comp
				String get_Workers_Comp = driver.findElement(By.xpath("//*[@id='otherInfodiv']/div/div[1]/div[2]/span")).getText();
				String workers_Comp_Displayed = get_Workers_Comp.replaceAll("[^0-9]", "");
				
				Assert.assertTrue(workers_Comp.equals(workers_Comp_Displayed), "workers comp failed");
				
				/**********************************************************************************************/
				
				//close the crm profil
				driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div/div[2]/div/div[2]/a")).click();
				
				//navigate to the carrier crm
				
			Utils.Instance_NewWindow(driver);

			System.out.println(driver.getCurrentUrl());
			

		}

	}



}