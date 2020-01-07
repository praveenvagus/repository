package carrier_CRM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

@SuppressWarnings("unused")
public class Carrier_SignUp extends BaseClass {

	public Carrier_SignUp(WebDriver driver) {
		super(driver);
		}

@Test
public static void AddingNew_Carrier(String sTestCaseName) throws Exception {
		
	
		
	System.out.println(driver.getCurrentUrl());
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
   		String Carrier_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_CarrierName);
   		String Mc_Number = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_MCnumber);
   		String Street_Address = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_Address);
   		String Home_City = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_HomeCity);
   		String Home_State = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_HomeState);
   		String ZipCode = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_ZipCode);
   		String Contact_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_PrimName);
   		String Contact_Role = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_PrimRole);
   		String Contact_Phone = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_PrimPhone);
   		String Extension = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_PrimExtension);
   		String Phone_Type = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_PrimPhtype);
   		String Contact_Email = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_PrimEmail);
   		String Tractor_Count = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_TractCount);
   		String Driver_Count = ExcelUtils.getCellData(iTestCaseRow, Constant.CarrierSign_DriverCount);
   		//CarrierSign_Result 
   		
   		JavascriptExecutor js = (JavascriptExecutor)driver;					
   		WebElement DotNumber = driver.findElement(By.id("dot"));
   		DotNumber.sendKeys(Dot_Number);
 				
   		//To submit Dot
   		WebElement SubmitDotNumber =driver.findElement(By.id("btnDOT"));
   		SubmitDotNumber.click();
   		Thread.sleep(1500);		
   			
   		//Navigate to the Profile Page
   		WebElement creationLink=driver.findElement(By.xpath("//*[@id='CarrierSignUp']/div[1]/div/div[5]/div[2]/p[3]/a"));
   		creationLink.click();
   					
   		//*****************************Company Details*************************************
   		//Company Profile
   		Thread.sleep(2000);
   		WebElement accountName =driver.findElement(By.id("txtAccountName"));
   		accountName.sendKeys(Carrier_Name);
   				
   		//MC Number
   		WebElement mcNumber=	driver.findElement(By.id("txtMC"));
   		mcNumber.sendKeys(Mc_Number);
   			
   		//Street Name
   		WebElement streetName=driver.findElement(By.id("txtstreetname"));
   		streetName.sendKeys(Street_Address);
   				
   		//City Name
   		WebElement cityName = driver.findElement(By.id("txtNewCityName"));
   		cityName.sendKeys(Home_City);			
   		Thread.sleep(1500);
   		new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
   				
   		//Zip Code
   		driver.findElement(By.id("txtStateCode")).sendKeys(ZipCode);
   				
   		//**************************Contact Details***************************

   		String registration_Status = "completed";

   		//Contact Name
   		driver.findElement(By.id("txtcontactname")).sendKeys(Contact_Name);
   				
   		//Contact Role
   		Select role = new Select(driver.findElement(By.id("Sddlcontactroles")));
   		role.selectByVisibleText(Contact_Role);
   				
   		//Contact Number
   		driver.findElement(By.id("txtphone")).sendKeys(Contact_Phone);
   				
   		//Extension
   		driver.findElement(By.id("Extension")).sendKeys(Extension);
   				
   		//Eamil
   		driver.findElement(By.id("txtemail")).sendKeys(Contact_Email);

   		//************************Trailer Details**********************************

   		//No.of Tractors
   		WebElement no_Tractors = driver.findElement(By.id("nooftrailers"));
   		no_Tractors.clear();
   		no_Tractors.sendKeys(Tractor_Count);
   				
   		//No.of Drivers
   		WebElement no_Drivers=driver.findElement(By.id("noofdrivers"));
   		no_Drivers.clear();
   		no_Drivers.sendKeys(Driver_Count);
   				
   		//Trailer Selection
   		for(int i1=1 ; i1<=4 ; i1++)
   		{
   		WebElement trailer = driver.findElement(By.xpath("//*[@id='trailerType"+i1+"']"));
   		js.executeScript("arguments[0].click();", trailer);
   		}
   		   
   		//Submit
   		WebElement submitDetails = driver.findElement(By.xpath("//*[@id='trailerdetails']/div[2]/a[2]"));
   		submitDetails.click();
   		Thread.sleep(1500);

   		/***************************Lane Preferences***************************************/

   		//driver.findElement(By.xpath("//*[@id='insurance']/div[3]/a/span")).click();
   		Thread.sleep(10000);

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

   		//select the all states
   		for(int j=0; j<states.size(); j++)
   		{
   		driver.findElement(By.xpath("//*[@id='"+states.get(j)+"']")).click();
   		}

   		for(int k=0; k<origin_State.size(); k++)
   		{
   		driver.findElement(By.id("stateorigin")).sendKeys(""+origin_State.get(k));
   		Thread.sleep(1500);
   		driver.findElement(By.id("stateorigin")).sendKeys(Keys.ENTER);
   		driver.findElement(By.id("stateorigin")).click();
   		Thread.sleep(1000);

   		driver.findElement(By.id("statedestination")).sendKeys(""+destination_State.get(k));
   		Thread.sleep(1500);
   		driver.findElement(By.id("statedestination")).sendKeys(Keys.ENTER);
   		driver.findElement(By.id("statedestination")).click();
   		Thread.sleep(1000);

   		driver.findElement(By.xpath("//*[@id='statestep']/div[1]/button")).click();
   		}

   		for(int L=0; L<origin_Lane.size(); L++)
   		{
   		driver.findElement(By.id("cityorigin")).sendKeys(""+origin_Lane.get(L));
   		Thread.sleep(1500);
   		driver.findElement(By.id("cityorigin")).sendKeys(Keys.ENTER);
   		driver.findElement(By.id("cityorigin")).click();
   		Thread.sleep(1000);

   		driver.findElement(By.id("citydestination")).sendKeys(""+destination_Lane.get(L));
   		Thread.sleep(1500);
   		driver.findElement(By.id("citydestination")).sendKeys(Keys.ENTER);
   		driver.findElement(By.id("citydestination")).click();
   		Thread.sleep(1000);

   		driver.findElement(By.xpath("//*[@id='citystep']/div[1]/button")).click();
   		Thread.sleep(1000);
   		}

   		driver.findElement(By.className("save")).click();
   		Thread.sleep(1500);

   		/*********************************Paperwork*************************************/

   		//liability values
   		String general_Liability = "750000";
   		String auto_Liability = "5000000";
   		String cargo_Coverage = "100000";
   		String workers_Comp = "100000";
   		String reefer_Limit = "100000";
   		//document Required
   		String broker_Agreement_Doc = (System.getProperty("user.dir") +"/Support_Docs/Broker Carrier Agreement.pdf");
   		String w9_Doc = (System.getProperty("user.dir") +"/Support_Docs/W9.pdf");
   		String operating_Authority_Doc = (System.getProperty("user.dir") +"/Support_Docs/Operating authority.pdf");
   		String other_Doc = (System.getProperty("user.dir") +"/Support_Docs/Other.pdf"); 
   		String insurance_Doc = (System.getProperty("user.dir") +"/Support_Docs/Certificate Of Insurance.pdf");
   		String ACH_Doc = (System.getProperty("user.dir") +"/Support_Docs/ACH Form.pdf");
   		String bank_confirm_letter = (System.getProperty("user.dir") +"/Support_Docs/Bank Confirmation Letter.pdf");
   		String void_check_doc = (System.getProperty("user.dir") +"/Support_Docs/Void Check.pdf");
   		//payment thorugh company
   		String payment_Mode = "Direct Payment";
   		//payment type
   		String payment_Type = "ACH";
   		//broker agreement
   		String agreement_Doc = "Broker Carrier Agreement.pdf";
   		//payment term
   		String carrier_Payment_Term = "NET 2 (5%)";
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
   		//tax information
   		String tax_Id = "982397966";

   		//carrier broker agreement
   		WebElement broker_Agreement = driver.findElement(By.xpath("//*[@id='CBAdoc']"));
   		broker_Agreement.sendKeys(broker_Agreement_Doc);
   		Thread.sleep(1500);

   		if(payment_Mode == "Direct Payment" && payment_Type == "ACH")
   		{
   		//give no
   		driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[1]/div[2]/span[2]/input")).click();

   		//select the payment mode
   		Select payment_Type_Signup = new Select(driver.findElement(By.id("ddlBankPaymentmode")));
   		payment_Type_Signup.selectByVisibleText("ACH");

   		//give the bank details
   		driver.findElement(By.id("txtbankname")).sendKeys(bank_Name);

   		//MPVE TO CONTACT NAME BY SCROLLING
   		WebElement bank_Detail_Finder = driver.findElement(By.id("txtcontactname"));
   		js.executeScript("arguments[0].scrollIntoView()", bank_Detail_Finder);
   		Thread.sleep(1500);

   		//give the bank contact name
   		driver.findElement(By.id("txtcontactname")).sendKeys(bank_Contact_Name);

   		//street address
   		driver.findElement(By.name("address")).sendKeys(bank_Street_Address);

   		//give the city name
   		driver.findElement(By.id("txtbnkcitystate")).sendKeys(bank_City_State);
   		driver.findElement(By.id("txtbnkcitystate")).sendKeys(Keys.ENTER);

   		//zipcode
   		driver.findElement(By.name("zipcode")).sendKeys(bank_Zipcode);

   		//aba/routing number
   		driver.findElement(By.name("abanumber")).sendKeys(bank_Aba_Number);

   		//account number
   		driver.findElement(By.id("txtaccountnum")).sendKeys(bank_Account_Number);

   		//grantee name
   		driver.findElement(By.id("txtgranteename")).sendKeys(bank_grantee_Name);

   		//payment term
   		Select payment_Term = new Select(driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[8]/select")));
   		payment_Term.selectByVisibleText(carrier_Payment_Term);

   		//tax id
   		 driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[10]/input")).sendKeys(tax_Id);

   		//scroll to the document section
   		WebElement bank_Document_Finder = driver.findElement(By.xpath("//*[@id='ACHdocument']/div[1]/div[3]/div[1]/div[1]/label"));
   		js.executeScript("arguments[0].scrollIntoView()", bank_Document_Finder);
   		Thread.sleep(1500);

   		//String ACH_Doc = (System.getProperty("user.dir") +"/Support_Docs/ACH Form.pdf");
//document type that needs to be update for the ach type are ach form, bank confirmation letter, void check
driver.findElement(By.id("ACHdoc")).sendKeys((System.getProperty("user.dir") +"/Support_Docs/ACH Form.pdf"));
Thread.sleep(1500);
//bank confirmation letter
driver.findElement(By.id("BCLdoc")).sendKeys((System.getProperty("user.dir") +"/Support_Docs/Bank Confirmation Letter.pdf"));
Thread.sleep(1500);
//void check
driver.findElement(By.id("voidcheckdoc")).sendKeys((System.getProperty("user.dir") +"/Support_Docs/Void Check.pdf"));
Thread.sleep(1500);
}
   		 
   		else if(payment_Mode == "Direct Payment" && payment_Type == "Check")
   		{
   		//select the payment mode
   		Select payment_Type_Signup = new Select(driver.findElement(By.id("ddlBankPaymentmode")));
   		payment_Type_Signup.selectByVisibleText("Check");

   		//selecting the address as same as the home address and checking whether the home address is populated properly
   		driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[3]/div[1]/label[2]/input")).click();

   		//payment term
   		Select payment_Term = new Select(driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[8]/select")));
   		payment_Term.selectByVisibleText(carrier_Payment_Term);

   		//tax id
   		 driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[10]/input")).sendKeys(tax_Id);

   		/*String check_Recipient_Street_Address = driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[3]/div[1]/div[3]/div[1]/span[1]/input")).getText();
   		String check_Recipient_City_State = driver.findElement(By.xpath("//*[@id='txtBillingCityName']")).getText();
   		String check_Recipient_zipcode = driver.findElement(By.xpath("//*[@id='txtBillingStateCode']")).getText();*/
   		}
   		else
   		{
   		 //yes for payment throught factoring

   		driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[1]/div[2]/span[1]/input")).click();

   		//fill the factoring company name
   		driver.findElement(By.id("txtfactoryname")).sendKeys("give a factoring company name");


   		//give the notice of assignment
   		driver.findElement(By.id("NOAdoc")).sendKeys("C:\\Users\\User\\Downloads\\ACH Form.pdf");
   		//tax id
   		 driver.findElement(By.xpath("//*[@id='lstBankInfo']/div[10]/input")).sendKeys(tax_Id);
   		 
   		 }

   		 //general liability
   		 driver.findElement(By.xpath("//*[@id='txtCGLLimits']")).sendKeys(general_Liability);

   		 WebElement Insurance_GLExpiry=driver.findElement(By.xpath("//*[@id='dtCGLPolicyExp']"));
   		 Insurance_GLExpiry.click();
   		 new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
   		 new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
   		 Thread.sleep(2000);	    
   		 
   		 //Auto liability
   		 driver.findElement(By.xpath("//*[@id='txtALLimits']")).sendKeys(auto_Liability);
   		    
   		 WebElement Insurance_ALExpiry =driver.findElement(By.xpath("//*[@id='dtALLimits']"));
   		 Insurance_ALExpiry.click();
   		 new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
   		 new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
   		 Thread.sleep(2000);	 
   		    
   		 //cargo coverage   
   		 driver.findElement(By.xpath("//*[@id='txtCCLimits']")).sendKeys(cargo_Coverage);
   		    
   		 WebElement Insurance_CCExpiry = driver.findElement(By.xpath("//*[@id='insurance']/div[1]/div[1]/div[3]/div/div[2]/input"));
   		 Insurance_CCExpiry.click();
   		 new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
   		 new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
   		 Thread.sleep(2000);	
   		    
   		 //workers comp
   		 driver.findElement(By.id("txtWorkersComp")).sendKeys(""+workers_Comp);
   		    
   		 //reefer limit
   		 driver.findElement(By.id("Reeferbreakdown")).sendKeys(""+reefer_Limit);
   		    
   		//scroll down
   		js.executeScript("window.scrollBy(0,1000)");
   		Thread.sleep(2000);
   		    
   		driver.findElement(By.xpath("//*[@id='InsuranceDoc']")).sendKeys(w9_Doc);
   		Thread.sleep(2000);	 
   		    
   		driver.findElement(By.xpath("//*[@id='OperatingAuth']")).sendKeys(operating_Authority_Doc);
   		Thread.sleep(2000);	
   		 
   		driver.findElement(By.xpath("//*[@id='CInsurance']")).sendKeys(insurance_Doc);
   		Thread.sleep(5000);	
   		    
   		driver.findElement(By.xpath("//*[@id='Otherdocs']")).sendKeys(other_Doc);
   		Thread.sleep(2000);	
   		    
   		//term and conditions agree
   		driver.findElement(By.xpath("//*[@id='check']")).click();
   		    
   		//submit the paperwork section
   		driver.findElement(By.xpath("//*[@id='insurance']/div[3]/button")).click();
   		Thread.sleep(2000);
   		driver.close();
   		Thread.sleep(2000);
   		Utils.Instance_NewWindow(driver);
   		
		}		
   		}

   		}
