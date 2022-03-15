package carrier_CRM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class Carrier_AMILvsCRM extends BaseClass{

public Carrier_AMILvsCRM(WebDriver driver) {
		super(driver);
		
}
	
@SuppressWarnings("unused")
@Test
public static void CarrierCRM_Verification(String sTestCaseName) throws Exception {	
	
		
	DOMConfigurator.configure("log4j.xml");
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"CarrierSignUp");
	int rowused = ExcelUtils.getRowUsed();
	System.out.println("Rowused"+rowused);	
	JavascriptExecutor js = (JavascriptExecutor)driver;	
		
	for (int i=1;i<=rowused;i++)
	{
	String TestCasename = sTestCaseName + "_"+i; 	
	int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.CarrierSign_TestCaseName);
  	Log.startTestCase(TestCasename);
	iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
	System.out.println(iTestCaseRow);

		
			//Items REquired
			String dot_Number = "4565484";
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
			String contact_Phone = "9789406888";
			String extention = "289374";
			String contact_Email = "praveenrathi@carrier.com";
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
					String Origin_Lane1="Portland, Connecticut(CT), US".replaceAll("[^a-zA-Z0-9]", "");
					String Origin_Lane2="Bend, California(CA), US".replaceAll("[^a-zA-Z0-9]", "");
					
					
					List<String> destination_Lane  = new ArrayList<>();
					destination_Lane.add("Carrizo Hill, Texas(TX), US");
					destination_Lane.add("Jamestown, Pennsylvania(PA), US");
					
					String Dest_Lane1="Carrizo Hill, Texas(TX), US".replaceAll("[^a-zA-Z0-9]", "");
					String Dest_Lane2="Jamestown, Pennsylvania(PA), US".replaceAll("[^a-zA-Z0-9]", "");
					
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
					String State1="Alaska";
					String State2="Oregon";
					String State3="Maine";
					
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
					List<String> All_Documents = new ArrayList<>();
					All_Documents.add("ACH Form.pdf");
					All_Documents.add("Bank Confirmation Letter.pdf");
					All_Documents.add("Void Check.pdf");
					All_Documents.add("W9.pdf");
					All_Documents.add("Other.pdf");
					All_Documents.add("Operating authority.pdf");
					All_Documents.add("Certificate Of Insurance.pdf");
					All_Documents.add("Broker Carrier Agreement.pdf");
					Collections.sort(All_Documents);
								
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
					String carrier_Payment_Term = "NET 2 (5%)";
		
/****************************************go to carrier CRM and Filter*************************************/

//go to carrier Accounts
driver.navigate().to("http://stage.amilfreight.com/carrier/list");
Thread.sleep(3500);
				
driver.findElement(By.xpath("//*[@ng-model='search.CompanyName']")).sendKeys(account_Name);// Company Name/Email
driver.findElement(By.xpath("//*[@id='btnSearchCarrier']")).click();// Search Button

Thread.sleep(1800);

driver.findElement(By.xpath("//*[@id='lstCarrier']/div[2]/div[1]/div[1]/div[1]/a")).click();// CarrierList on Company Name
Utils.Instance_NewWindow(driver);
Thread.sleep(1800);

driver.findElement(By.xpath("//*[@ng-click='GetOverViewDetail(COMPANYGuid)']")).click();//Overview on Carrier ProfileView

Thread.sleep(3500);
		
	String Account_Displayed=driver.findElement(By.xpath("//*[@id='fade-tab1']/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/span"))
			.getText().replaceAll("[^a-zA-Z0-9]", "");	
	String Dot_Displayed=driver.findElement(By.xpath("//*[@id='fade-tab1']/div/div/div[2]/div[1]/div[1]/div[2]/div[5]/span")).getText();	
	String Mc_Displayed=driver.findElement(By.xpath("//*[@id='fade-tab1']/div/div/div[2]/div[1]/div[1]/div[2]/div[4]/span")).getText();	
	String Street_Address_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/span"))
			.getText().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();	
	String TaxID_Displayed=driver.findElement(By.xpath("//*[@id='fade-tab1']/div/div/div[2]/div[1]/div[1]/div[2]/div[6]/span")).getText();	
		
	String Street=street_Address.toLowerCase();
	String account_Nam=account_Name.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
	//basic info comparison
	System.out.println(account_Nam+"*account*"+Account_Displayed);
	System.out.println(dot_Number+"**dotnumber*"+Dot_Displayed);
	System.out.println(mc_Number+"**MC*"+Mc_Displayed);
	System.out.println(Street+"*ADD**"+Street_Address_Disp);
	System.out.println(tax_Id+"*TAX**"+TaxID_Displayed);
	
	Assert.assertTrue(account_Nam.equalsIgnoreCase(Account_Displayed), "account");
	Assert.assertTrue(dot_Number.equals(Dot_Displayed), "dotnumber");
	Assert.assertTrue(mc_Number.equalsIgnoreCase(Mc_Displayed), "Mc");
	//Assert.assertTrue(Street.equalsIgnoreCase(Street_Address_Disp), "street");
	Assert.assertTrue(tax_Id.equalsIgnoreCase(TaxID_Displayed), "city");
	
System.out.println("------------------------------------------------------------------------");

/*
driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a")).click();
Thread.sleep(3500);

String Origin1_Disp=driver.findElement(By.xpath("//*[@id='prefferedlanesId']/div[2]/div/div[1]/div[1]")).getText().replaceAll("[^a-zA-Z0-9]", "");
String Origin2_Disp=driver.findElement(By.xpath("//*[@id='prefferedlanesId']/div[2]/div/div[2]/div[1]")).getText().replaceAll("[^a-zA-Z0-9]", "");
String Dest1_Disp=driver.findElement(By.xpath("//*[@id='prefferedlanesId']/div[2]/div/div[1]/div[2]")).getText().replaceAll("[^a-zA-Z0-9]", "");
String Dest2_Disp=driver.findElement(By.xpath("//*[@id='prefferedlanesId']/div[2]/div/div[2]/div[2]")).getText().replaceAll("[^a-zA-Z0-9]", "");

System.out.println(Origin_Lane1+"*****"+Origin1_Disp);
System.out.println(Origin_Lane2+"*****"+Origin2_Disp);
System.out.println(Dest_Lane1+"*****"+Dest1_Disp);
System.out.println(Dest_Lane2+"*****"+Dest2_Disp);


Assert.assertTrue(Origin_Lane1.equalsIgnoreCase(Origin1_Disp), "Origin1_Disp");
Assert.assertTrue(Origin_Lane2.equalsIgnoreCase(Origin2_Disp), "Origin2_Disp");
Assert.assertTrue(Dest_Lane1.equalsIgnoreCase(Dest1_Disp), "Dest1_Disp");
Assert.assertTrue(Dest_Lane2.equalsIgnoreCase(Dest2_Disp), "Dest2_Disp");

System.out.println("------------------------------------------------------------------------");

driver.findElement(By.xpath("//*[@id='Tabs']/li[3]/a")).click();
Thread.sleep(3500);

//bank Details
String bank_Name1 = bank_Name.replaceAll("[^a-zA-Z0-9]","");
String bank_Contact_Name1 = bank_Contact_Name.replaceAll("[^a-zA-Z0-9]","");
String bank_Street_Address1 = bank_Street_Address.replaceAll("[^a-zA-Z0-9]","");
String bank_Aba_Number1 = bank_Aba_Number.replaceAll("[^a-zA-Z0-9]","");
String bank_Account_Number1  =bank_Account_Number.replaceAll("[^a-zA-Z0-9]","");
String bank_grantee_Name1 = bank_grantee_Name.replaceAll("[^a-zA-Z0-9]","");


String bank_NameDisp=driver.findElement(By.xpath("//*[@id='lstBankInfo']/form/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[1]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String bank_Contact_Disp=driver.findElement(By.xpath("//*[@id='lstBankInfo']/form/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[3]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String bank_StreetDisp=driver.findElement(By.xpath("//*[@id='lstBankInfo']/form/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[6]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String bank_AbaNoDisp=driver.findElement(By.xpath("//*[@id='lstBankInfo']/form/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[5]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String bank_AccNoDisp=driver.findElement(By.xpath("//*[@id='lstBankInfo']/form/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[2]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String bank_grantNamDisp=driver.findElement(By.xpath("//*[@id='lstBankInfo']/form/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[4]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");

System.out.println(bank_Name1+"*****"+bank_NameDisp);
System.out.println(bank_Contact_Name1+"*****"+bank_Contact_Disp);
System.out.println(bank_Street_Address1+"*****"+bank_StreetDisp);
System.out.println(bank_Aba_Number1+"*****"+bank_AbaNoDisp);
System.out.println(bank_Account_Number1+"*****"+bank_AccNoDisp);
System.out.println(bank_grantee_Name1+"*****"+bank_grantNamDisp);

Assert.assertTrue(bank_Name1.equalsIgnoreCase(bank_NameDisp), "bank_NameDisp");
Assert.assertTrue(bank_Contact_Name1.equalsIgnoreCase(bank_Contact_Disp), "bank_Contact_Disp");
Assert.assertTrue(bank_Street_Address1.equalsIgnoreCase(bank_StreetDisp), "bank_StreetDisp");
Assert.assertTrue(bank_Aba_Number1.equalsIgnoreCase(bank_AbaNoDisp), "bank_AbaNoDisp");
Assert.assertTrue(bank_Account_Number1.equalsIgnoreCase(bank_AccNoDisp), "bank_AccNoDisp");
Assert.assertTrue(bank_grantee_Name1.equalsIgnoreCase(bank_grantNamDisp), "bank_grantNamDisp");

System.out.println("------------------------------------------------------------------------");

driver.findElement(By.xpath("//*[@id='Tabs']/li[6]/a")).click();
Thread.sleep(3500);

//contact details required
String contact_Name1 = "Praveen";
String contact_Role1 = "Dispatcher";
String extention1 = "289374";
String contact_Phone1 = "9789406888"+"Ext"+extention1;
String contact_Email1 = "praveenrathi@carrier.com".replaceAll("[^a-zA-Z0-9]", "");
String phone_Type1 = "Office";

String contact_NameDisp=driver.findElement(By.xpath("//*[@id='showcontactlst']/div[1]/div[2]/table/tbody/tr/td[1]/span[3]")).getText().replaceAll("[^a-zA-Z0-9]", "");
String contact_Role_Disp=driver.findElement(By.xpath("//*[@id='showcontactlst']/div[1]/div[2]/table/tbody/tr/td[5]/span[1]")).getText().replaceAll("[^a-zA-Z0-9]", "");
String contact_PhoneDisp=driver.findElement(By.xpath("//*[@id='showcontactlst']/div[1]/div[2]/table/tbody/tr/td[2]/a")).getText().replaceAll("[^a-zA-Z0-9]", "");
String contact_EmailDisp=driver.findElement(By.xpath("//*[@id='showcontactlst']/div[1]/div[2]/table/tbody/tr/td[4]/a")).getText().replaceAll("[^a-zA-Z0-9]", "");
String phone_TypeDisp=driver.findElement(By.xpath("//*[@id='showcontactlst']/div[1]/div[2]/table/tbody/tr/td[3]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");

System.out.println(contact_Name1+"*****"+contact_NameDisp);
System.out.println(contact_Role1+"*****"+contact_Role_Disp);
System.out.println(contact_Phone1+"*****"+contact_PhoneDisp);
System.out.println(contact_Email1+"*****"+contact_EmailDisp);
System.out.println(phone_Type1+"*****"+phone_TypeDisp);

Assert.assertTrue(contact_Name1.equalsIgnoreCase(contact_NameDisp), "bank_NameDisp");
Assert.assertTrue(contact_Role1.equalsIgnoreCase(contact_Role_Disp), "bank_Contact_Disp");
Assert.assertTrue(contact_Phone1.equalsIgnoreCase(contact_PhoneDisp), "bank_StreetDisp");
Assert.assertTrue(contact_Email1.equalsIgnoreCase(contact_EmailDisp), "bank_AbaNoDisp");
Assert.assertTrue(phone_Type1.equalsIgnoreCase(phone_TypeDisp), "bank_AccNoDisp");

System.out.println("------------------------------------------------------------------------");

driver.findElement(By.xpath("//*[@id='Tabs']/li[7]/a")).click();
Thread.sleep(4500);


js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


String general_Liability1 = "750000";
String general_LiabilDate="10/22/2019";
String auto_Liability1 = "5000000";
String auto_LiabilDate ="10/22/2019";
String cargo_Coverage1 = "100000";
String cargo_CoverDate ="10/22/2019";
String reefer_Limit1 = "100000";

WebElement Element=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[3]/div/div[2]/div/span[2]/span"));
js.executeScript("arguments[0].scrollIntoView();", Element);

String general_LiabilityDisp=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[1]/div[2]/div[2]/div[4]/span[2]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String auto_LiabilityDisp=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[2]/div[1]/div[2]/div[4]/span[2]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String cargo_CoverageDisp=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[2]/div[2]/div[2]/div[4]/span[2]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");
String reefer_LimitDisp=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[3]/div/div[2]/div/span[2]/span")).getText().replaceAll("[^a-zA-Z0-9]", "");

String general_LiabilDateDis=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[1]/div[2]/div[2]/div[3]/span")).getText();
String auto_LiabilDateDis=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[2]/div[1]/div[2]/div[3]/span")).getText();
String cargo_CoverDateDis=driver.findElement(By.xpath("//*[@id='AddInsuranceDoc']/div/div[2]/div[2]/div[2]/div[3]/span")).getText();
							
System.out.println(general_Liability1+"*****"+general_LiabilityDisp);
System.out.println(auto_Liability1+"*****"+auto_LiabilityDisp);
System.out.println(cargo_Coverage1+"*****"+cargo_CoverageDisp);
System.out.println(reefer_Limit1+"*****"+reefer_LimitDisp);

System.out.println(general_LiabilDate+"*****"+general_LiabilDateDis);
System.out.println(auto_LiabilDate+"*****"+auto_LiabilDateDis);
System.out.println(cargo_CoverDate+"*****"+cargo_CoverDateDis);


Assert.assertTrue(general_Liability1.equalsIgnoreCase(general_LiabilityDisp), "general_LiabilityDisp");
Assert.assertTrue(auto_Liability1.equalsIgnoreCase(auto_LiabilityDisp), "auto_LiabilityDisp");
Assert.assertTrue(cargo_Coverage1.equalsIgnoreCase(cargo_CoverageDisp), "cargo_CoverageDisp");
Assert.assertTrue(reefer_Limit1.equalsIgnoreCase(reefer_LimitDisp), "reefer_LimitDisp");
Assert.assertTrue(general_LiabilDate.equalsIgnoreCase(general_LiabilDateDis), "general_LiabilDateDis");
Assert.assertTrue(auto_LiabilDate.equalsIgnoreCase(auto_LiabilDateDis), "auto_LiabilDateDis");
Assert.assertTrue(cargo_CoverDate.equalsIgnoreCase(cargo_CoverDateDis), "cargo_CoverDateDis");

System.out.println("------------------------------------------------------------------------");

driver.findElement(By.xpath("//*[@id='Tabs']/li[8]/a")).click();//Zones and States
Thread.sleep(4000);

//driver.findElement(By.xpath("//label[contains(text(), 'Oregon')]//parent::li/label/input[@class='statecheck66 zstates10 chkstate ng-empty']"));

WebElement State11=driver.findElement(By.xpath("//label[contains(text(), '"+State1+"')]//parent::li/label/span"));
if(State11.isSelected()){
	System.out.println("Pakka1");
}

if(driver.findElement(By.xpath("//label[contains(text(), '"+State2+"')]//parent::li/label/span")).isSelected()){
	System.out.println("Pakka2");
}
*/
System.out.println("------------------------------------------------------------------------");

driver.findElement(By.xpath("//*[@id='Tabs']/li[9]/a")).click();//Preferred States
Thread.sleep(4000);

String Origin="West Virginia(WV) ,US".replaceAll("[^a-zA-Z0-9]", "");
String Destination="South Dakota(SD) ,US".replaceAll("[^a-zA-Z0-9]", "");

String Origin_Disp=driver.findElement(By.xpath("//*[@id='amilpreferredstatediv']/div[1]/div[1]/table/tbody/tr/td[1]")).getText().replaceAll("[^a-zA-Z0-9]", "");
String Destination_Disp=driver.findElement(By.xpath("//*[@id='amilpreferredstatediv']/div[1]/div[1]/table/tbody/tr/td[2]")).getText().replaceAll("[^a-zA-Z0-9]", "");

System.out.println(Origin+"*****"+Origin_Disp);
System.out.println(Destination+"*****"+Destination_Disp);

Assert.assertTrue(Origin.equalsIgnoreCase(Origin_Disp), "general_LiabilityDisp");
Assert.assertTrue(Destination.equalsIgnoreCase(Destination_Disp), "auto_LiabilityDisp");

System.out.println("------------------------------------------------------------------------");

driver.findElement(By.xpath("//*[@id='Tabs']/li[9]/a")).click();//Preferred States
Thread.sleep(4000);


driver.findElement(By.xpath("//*[@id='Tabs']/li[10]/a")).click();//Preferred States
Thread.sleep(4000);

List<String> document_In_CRM = new ArrayList<>();

List<WebElement> total_Documents = driver.findElements(By.xpath("//*[@id='dmslist']/div[2]/table/tbody/tr/td[1]/span/a"));
for(int t=1; t<=total_Documents.size(); t++)
{
	//get the document names and store it in a list
	String get_Document_Names = driver.findElement(By.xpath("//*[@id='dmslist']/div[2]/table/tbody/tr["+t+"]/td[1]/span/a")).getText();
	System.out.println(get_Document_Names);
	document_In_CRM.add(get_Document_Names);
	
}

//sorting the list for comparison
Collections.sort(document_In_CRM);

System.out.println(document_In_CRM);

if(payment_Mode=="Direct Payment" && payment_Type=="ACH")
{
	Assert.assertTrue(All_Documents.equals(document_In_CRM), "ACH type document issue");
	
}

}
}
}