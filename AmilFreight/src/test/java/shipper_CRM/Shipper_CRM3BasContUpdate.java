package shipper_CRM;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class Shipper_CRM3BasContUpdate extends BaseClass{
	
	public Shipper_CRM3BasContUpdate(WebDriver driver) {
		super(driver);
	}

@SuppressWarnings("unused")
@Test	
public static void CRM_Shipper(String sTestCaseName) throws Exception {

WebDriverWait wait = new WebDriverWait(driver, 20);
JavascriptExecutor js = (JavascriptExecutor)driver;	
driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[1]/div/div/div/h4/span"));
driver.navigate().to("http://stage.amilfreight.com/crm/sales/shipper-opt");
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

DOMConfigurator.configure("log4j.xml");
ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"ShipperAdd2");
int rowused = ExcelUtils.getRowUsed();
		
for (int i=1;i<=rowused;i++)
{
String TestCasename = sTestCaseName + "_"+i; 	
int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.ShipperAdd_TestCaseName);
Log.startTestCase(TestCasename);
iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
System.out.println(iTestCaseRow);

String Shipper_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd_Shipper_Name);
String PContact_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd3_Contact_Name);
String New_Street = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd3_Address);
String New_State = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd3_City_State);
String New_ContName = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd3_Contact_Name);
String New_ContEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd3_Contact_Email);
String New_ContNo = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipperAdd3_Contact_No);

try {
	
	
driver.navigate().to("http://stage.amilfreight.com/crm/sales/shipper-opt");
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));

System.out.println("***********START***********");	
Thread.sleep(2500);
driver.findElement(By.xpath("//*[@id='Tabs']/li[4]/a")).click(); //move to client section
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
Thread.sleep(2500);
WebElement filter = driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/a/i")); //filter click
js.executeScript("arguments[0].click()", filter);

driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/input")).sendKeys(Shipper_Name);
Thread.sleep(1500);
driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[1]/div/div/div/div/a[2]")).click(); //search
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader"))); //wait till it loads

Thread.sleep(2500);
driver.findElement(By.xpath("//*[@id='tblDiv']/tbody/tr/td[1]/a")).click(); //open profile

Utils.Instance_NewWindow(driver);	
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
System.out.println(driver.getCurrentUrl());
Thread.sleep(2500);
driver.findElement(By.xpath("//*[@ng-click='OpenUpdateBasicInfo()']")).click();//Update BasicInfo
Utils.Instance_NewWindow(driver);	
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
driver.manage().window().maximize();

driver.findElement(By.xpath("//*[@ng-validate='req,Street']")).clear();//Street Text_Box
driver.findElement(By.xpath("//*[@ng-validate='req,CityState']")).clear();//City/State Text_Box
driver.findElement(By.xpath("//*[@ng-validate='req,ZipCode']")).clear();//ZipCode Text_Box
driver.findElement(By.xpath("//*[@ng-model='BasicInfo.Product']")).clear();//Product Text_Box
driver.findElement(By.xpath("//*[@ng-model='BasicInfo.AverageLoad']")).clear();//AverageLoad Text_Box
WebElement Pri_Lead=driver.findElement(By.xpath("//*[@ng-validate='req,Primary Recruitment Lead']"));//Select_PrimaryLead
WebElement Indust=driver.findElement(By.xpath("//*[@ng-validate='req,Industry']"));//Select_Industry
WebElement Sec_Lead=driver.findElement(By.xpath("//*[@ng-model='BasicInfo.SecSalesRepId']"));//Select_SceondLead
WebElement Contract=driver.findElement(By.xpath("//*[@ng-model='BasicInfo.Contracttype']"));//Select_ContractType

Select PrimC=new Select(Pri_Lead);
Select InduS=new Select(Indust);
Select SecnC=new Select(Sec_Lead);
Select ContC=new Select(Contract);

PrimC.selectByVisibleText("Select");
InduS.selectByVisibleText("Select");
SecnC.selectByVisibleText("Select");
ContC.selectByVisibleText("Select");
Thread.sleep(2500);

String ZipCode="656565";
String Industry="Firewood";
String Product="Glasses";
String Average_Load="1589";
String Contr_Type1="Broker Based";
String Sales_Rep="ShipperEx";
String Second_Sal1="ShipperEx";
String Second_Sal=Second_Sal1.replaceAll("[^a-zA-Z0-9]", "");
String Contr_Type=Contr_Type1.replaceAll("[^a-zA-Z0-9]", "");

driver.findElement(By.xpath("//*[@ng-validate='req,Street']")).sendKeys(New_Street);//Street Text_Box
Thread.sleep(900);
driver.findElement(By.xpath("//*[@ng-validate='req,CityState']")).sendKeys(New_State);//City/State Text_Box
Thread.sleep(4500);
driver.findElement(By.xpath("//*[@id='divbasicinfo']/div/div[6]/div/ul/li[1]/a")).click();
//driver.findElement(By.xpath("//*[@ng-validate='req,CityState']")).sendKeys(Keys.ENTER);
Thread.sleep(2900);
driver.findElement(By.xpath("//*[@ng-validate='req,ZipCode']")).sendKeys(ZipCode);//ZipCode Text_Box
driver.findElement(By.xpath("//*[@ng-model='BasicInfo.Product']")).sendKeys(Product);//Product Text_Box
driver.findElement(By.xpath("//*[@ng-model='BasicInfo.AverageLoad']")).sendKeys(Average_Load);//AverageLoad Text_Box

PrimC.selectByVisibleText(Sales_Rep);
InduS.selectByVisibleText(Industry);
SecnC.selectByVisibleText(Second_Sal);
ContC.selectByVisibleText(Contr_Type1);
Thread.sleep(1250);
driver.findElement(By.xpath("//*[@ng-click='saveBasicinfo()']")).click(); //Update Button
Thread.sleep(1250);

//driver.findElement(By.xpath("//*[@ng-click='Close()']")).click(); //close
Utils.Instance_NewWindow(driver);
Thread.sleep(1250);
System.out.println(driver.getCurrentUrl());
System.out.println("-----------------------------------------------------------------------");

String Complete_Address = (New_Street+New_State+ZipCode).replaceAll("[^a-zA-Z0-9]", "");

String Address_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[2]/span"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
String Industry_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[3]/span"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
String Product_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[4]/span"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
String salesRep_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span/span[1]/span[1]"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
String ContrType_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[6]/span"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
String SecondSal_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span/span/span[1]/span[1]"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
String AvgLoad_Displayed = driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[5]/span"))
.getText().replaceAll("[^a-zA-Z0-9]", "");

System.out.println(SecondSal_Displayed+"...."+Second_Sal);
System.out.println(salesRep_Displayed+"...."+Sales_Rep);

//Assert.assertTrue(Address_Displayed.equalsIgnoreCase(Complete_Address), "Address matching issue");
Assert.assertTrue(Industry_Displayed.equalsIgnoreCase(Industry), "Industry matching issue");
Assert.assertTrue(Product_Displayed.equalsIgnoreCase(Product), "Industry matching issue");
Assert.assertTrue(salesRep_Displayed.equalsIgnoreCase(Sales_Rep), "Sales_Rep matching issue");
Assert.assertTrue(ContrType_Displayed.equalsIgnoreCase(Contr_Type), "Contr_Type matching mobile issue");
Assert.assertTrue(SecondSal_Displayed.equalsIgnoreCase(Second_Sal), "Second_Sal matching issue");
Assert.assertTrue(AvgLoad_Displayed.equalsIgnoreCase(Average_Load), "Average_Load matching issue");

Utils.Instance_NewWindow(driver);

String JobTitle="Web Designer";
String Cont_NoExt="624705";
String Cont_NoTyp="Mobile";

driver.findElement(By.xpath("//*[@ng-click='showContactInfo()']")).click();//Update ContactInfo
Utils.Instance_NewWindow(driver);	
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
Thread.sleep(2500);

driver.findElement(By.xpath("//*[@ng-model='contactinfo.JobTitle']")).sendKeys(JobTitle);//Job Title

driver.findElement(By.xpath("//*[@ng-validate='req,Name']")).sendKeys(New_ContName);//Name

driver.findElement(By.xpath("//*[@ng-model='contactinfo.Email']")).sendKeys(New_ContEmail);//Email_ID

driver.findElement(By.xpath("//*[@ng-model='contactinfo.Phone.PhoneNo']")).sendKeys(New_ContNo);//Phone_No

driver.findElement(By.xpath("//*[@ng-model='contactinfo.Phone.Extension']")).sendKeys(Cont_NoExt);//Extension

WebElement phoneT=driver.findElement(By.xpath("//*[@name='PhoneType']"));//Phone_Type

Select Type_PH=new Select(phoneT);
Type_PH.selectByVisibleText(Cont_NoTyp);
Thread.sleep(2500);
//driver.findElement(By.xpath("//*[@class='checkmark']")).click();//Primary_Contact
driver.findElement(By.xpath("//*[@class='cp-successbtn']")).click();//Submit_Button
Thread.sleep(2500);
Utils.Instance_NewWindow(driver);

WebElement Primary_Contact = driver.findElement(By.xpath("//*[@title='Is Primary Contact']"));
if(Primary_Contact.isDisplayed()) {   //if the contact is primary, the test case will fail
System.out.println("Benikkiya148");
}

String Contact_Name_Displayed = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr[2]/td[1]")).getAttribute("innerText");
System.out.println(Contact_Name_Displayed);

String Contact_EmailDisp = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr[2]/td[5]/a"))
.getText();
System.out.println(Contact_EmailDisp);

String JobTitle_Disp = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr[2]/td[2]"))
.getText();
System.out.println(JobTitle_Disp);

String Cont_NoDisp = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/span/span[1]/a"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
System.out.println(Cont_NoDisp);

String Cont_NoExtDisp = driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/span/span[2]"))
.getText().replaceAll("[^a-zA-Z0-9]", "");
System.out.println(Cont_NoExtDisp);

if(driver.findElement(By.xpath("//*[@id='ContactListController']/div[1]/table/tbody/tr/td[6]/a[2]/i")).isDisplayed()) {   //if the contact is primary, the test case will fail
System.out.println("Benikkiya");
}

Assert.assertTrue(Contact_Name_Displayed.equalsIgnoreCase(New_ContName), "Contact_Name_Displayed matching issue");
System.out.println(Contact_EmailDisp+"****"+New_ContEmail);
Assert.assertTrue(Contact_EmailDisp.equalsIgnoreCase(New_ContEmail), "Contact_EmailDisp matching issue");
System.out.println(JobTitle_Disp+"****"+JobTitle);
Assert.assertTrue(JobTitle_Disp.equalsIgnoreCase(JobTitle), "JobTitle_Disp matching issue");
System.out.println(Cont_NoDisp+"****"+New_ContNo);
Assert.assertTrue(Cont_NoDisp.equalsIgnoreCase(New_ContNo), "Cont_No matching issue");
//driver.close();


WebElement Prim1_Icon=driver.findElement(By.xpath("//*[contains(text(),'"+PContact_Name+"')]//parent::a/i[@title='Is Primary Contact']"));//Primary Icon
WebElement Prim2_Icon=driver.findElement(By.xpath("//*[contains(text(),'"+New_ContName+"')]//parent::a/i[@title='Is Primary Contact']"));//Primary Icon

WebElement Edit1_Icon=driver.findElement(By.xpath("//*[contains(text(),'"+PContact_Name+"')]//parent::tr/td[6]/a/i[@ng-click='showContactInfo(contact)']"));//Edit Icon
WebElement Edit2_Icon=driver.findElement(By.xpath("//*[contains(text(),'"+New_ContName+"')]//parent::tr/td[6]/a/i[@ng-click='showContactInfo(contact)']"));//Edit Icon

WebElement Delete1_Icon=driver.findElement(By.xpath("//*[contains(text(),'"+PContact_Name+"')]//parent::tr/td[6]/a/i[@ng-click='deleteContact(contact)']"));//Delete Icon
WebElement Delete2_Icon=driver.findElement(By.xpath("//*[contains(text(),'"+New_ContName+"')]//parent::tr/td[6]/a/i[@ng-click='deleteContact(contact)']"));//Delete Icon

WebElement Prim1_Switch=driver.findElement(By.xpath("//*[contains(text(),'"+PContact_Name+"')]//parent::tr/td[6]/a[@ng-click='swapContact(contact)']"));//PrimarySwitch Icon
WebElement Prim2_Switch=driver.findElement(By.xpath("//*[contains(text(),'"+New_ContName+"')]//parent::tr/td[6]/a[@ng-click='swapContact(contact)']"));//PrimarySwitch Icon


if(Prim1_Icon.isDisplayed()) {
	
		if(Edit2_Icon.isDisplayed()) {
					
		if(Delete2_Icon.isDisplayed()) {

				if(Prim2_Switch.isDisplayed()) {
		
							Prim2_Switch.click();
				System.out.println("Awesome2 Performance");
												}
											}
										}
									}
if(Prim2_Icon.isDisplayed()) {
	
	if(Edit1_Icon.isDisplayed()) {
		
		if(Delete1_Icon.isDisplayed()) {
					
			if(Prim1_Switch.isDisplayed()) {
						
				Prim1_Switch.click();
				System.out.println("Awesome1 Performance");				
											}
										}
									}
								}
Thread.sleep(1500);
driver.findElement(By.xpath("//*[@ng-click='Close()']")).click();
Utils.Instance_NewWindow(driver);
System.out.println("***********END***********");
ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.ShipperAdd3_Result);
Utils.takeScreenshot(driver, Shipper_Name);
Thread.sleep(2500);

}
catch (Exception e){
ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.ShipperAdd3_Result);
Reporter.log(" "+Shipper_Name+ "  Email receipents added & Verified - Unsuccessful");
Utils.takeScreenshot(driver, Shipper_Name);
Log.error(e.getMessage());
throw (e);
}

}	
}
}
