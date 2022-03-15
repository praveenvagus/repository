package shipper_CRM;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;

public class ShipperCRMAccounts2 extends BaseClass{

	public ShipperCRMAccounts2(WebDriver driver) {
		super(driver);
		}

	@Test	
	public static void CRM_Shipper(String sTestCaseName) throws Exception {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	JavascriptExecutor js = (JavascriptExecutor)driver;	
	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		/*
		 * driver.findElement(By.xpath(
		 * "html/body/div[3]/div/div/div/div[1]/div/div/div/h4/span"));
		 * driver.navigate().to("http://stage.amilfreight.com/shipper/list");
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(
		 * "page-preloader")));
		 */
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	Date date = new Date();
	String date1= dateFormat.format(date);

	DOMConfigurator.configure("log4j.xml");
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"ShipperAdd3");
	int rowused = ExcelUtils.getRowUsed();
			
	for (int i=1;i<=rowused;i++)
	{
	String TestCasename = sTestCaseName + "_"+i; 	
	int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.ShipCRMAcc_TestCaseName);
	Log.startTestCase(TestCasename);
	iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
	//System.out.println(iTestCaseRow);

	String Shipper_Company = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ShipperName);
	String Shipper_Address = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Address);
	//String Shipper_CityState = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_CityState);
	String Shipper_Industry = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Industry);
	String Shipper_Product = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Product);
	String Shipper_AvgLoad = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_AvgLoad);
	String Shipper_Trailer = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Trailer);
	String Shipper_Sales1Rep = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Sales1Rep);
	String Shipper_Sales2Rep = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Sales2Rep);
	String Shipper_ContraType = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ContrType);
	String Shipper_Origin = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Origin);
	String Shipper_Destination = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Destination);
	String Shipper_TrailerType = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_TypeTrailer);
	String Shipper_ContactName = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ContactName);
	String Shipper_ContJobTitle = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_JobTitle);
	String Shipper_ContacNumber = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_MobileNo);
	String Shipper_ContExtense = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_Extension);
	String Shipper_MobileType = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_MobileType);
	String Shipper_ContactEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.ShipCRMAcc_ContEmail);
	
		 
try {
		
		driver.navigate().to("http://stage.amilfreight.com/shipper/list");
		//driver.navigate().to("https://stage.amilfreight.com/shipper/profileView/a2102533-0bc5-40bf-a25b-6d293986a929");
		Thread.sleep(1500);
		//System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("txtsrchCompname")).sendKeys(Shipper_Company);
		driver.findElement(By.id("btnSearchShipper")).click();
		
		WebElement Ship_Name=driver.findElement(By.xpath("//*[contains(text(),'"+Shipper_Company+"')]//parent::div/a"));
		js.executeScript("arguments[0].click()", Ship_Name);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page-preloader")));
		Utils.Instance_NewWindow(driver);
		Thread.sleep(3500);
		
		driver.findElement(By.xpath("//*[@id='chkli']")).click();
		Thread.sleep(6500);
				
		String Shipper_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/span")).getText();
		String Address_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[1]")).getText();
		String Industr_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[1]/div[3]/div[2]/div[1]/span")).getText();
		String Product_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[1]/div[3]/div[2]/div[2]/span")).getText();
		String AvgLoad_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[1]/div[3]/div[2]/div[3]/span")).getText();
		String Contrac_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[5]/span")).getText();
		String SalesRe_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/span")).getText();
		String Sale2Re_Disp=driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/span")).getText();
		
		/*List<WebElement> Trail_Prefer=driver.findElements(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/ul/li"));
		Trail_Prefer.contains(Shipper_TrailerType);*/
	
		
		System.out.println(Shipper_Disp+"**"+Shipper_Company);
		System.out.println(Address_Disp+"**"+Shipper_Address);
		System.out.println(Industr_Disp+"**"+Shipper_Industry);
		System.out.println(Product_Disp+"**"+Shipper_Product);
		System.out.println(AvgLoad_Disp+"**"+Shipper_AvgLoad);
		System.out.println(Contrac_Disp+"**"+Shipper_ContraType);
		System.out.println(SalesRe_Disp+"**"+Shipper_Sales1Rep);
		System.out.println(Sale2Re_Disp+"**"+Shipper_Sales2Rep);
				
		Assert.assertTrue(Shipper_Disp.equalsIgnoreCase(Shipper_Company), "Account name issue");
		Assert.assertTrue(SalesRe_Disp.equalsIgnoreCase(Shipper_Sales1Rep), "Sales rep in amil issue");
		Assert.assertTrue(Sale2Re_Disp.equalsIgnoreCase(Shipper_Sales2Rep), "Sales rep in amil issue");
		Assert.assertTrue(Contrac_Disp.equalsIgnoreCase(Shipper_ContraType), "Contract type in amil issue");
		Assert.assertTrue(Industr_Disp.equalsIgnoreCase(Shipper_Industry), "Industry in amil issue");
		Assert.assertTrue(Product_Disp.equalsIgnoreCase(Shipper_Product), "Product in amil issue");
		Assert.assertTrue(AvgLoad_Disp.equals(Shipper_AvgLoad), "Avg Load issue");
		Thread.sleep(1900);		

		//*************************************************************************************************
		driver.findElement(By.xpath("//*[@id='offerlane']")).click(); // Offered Lanes
		Thread.sleep(6500);	
		//required
		String lane_Origin_Amil = driver.findElement(By.xpath("//*[@id='PreferredLanesCol']/table/tbody/tr/td[1]")).getText();
		String lane_Destination_Amil = driver.findElement(By.xpath("//*[@id='PreferredLanesCol']/table/tbody/tr/td[2]")).getText();
		String lane_Trailer_Amil = driver.findElement(By.xpath("//*[@id='PreferredLanesCol']/table/tbody/tr/td[3]")).getText();
		
		System.out.println(lane_Origin_Amil+"**"+Shipper_Origin);
		System.out.println(lane_Destination_Amil+"**"+Shipper_Destination);
		System.out.println(lane_Trailer_Amil+"**"+Shipper_Trailer);

		//Assert.assertTrue(lane_Origin_Amil.equalsIgnoreCase(Shipper_Origin), "preferred origin lane issue");
		//Assert.assertTrue(lane_Destination_Amil.equalsIgnoreCase(Shipper_Destination), "preferred Destination lane issue");
		//Assert.assertTrue(lane_Trailer_Amil.equalsIgnoreCase(Shipper_Trailer), "lane trailer type issue");

		//*************************************************************************************************
		driver.findElement(By.xpath("//*[@id='contacts']")).click(); //Contacts
		Thread.sleep(6500);

		driver.findElement(By.xpath("//*[@id='showcontactlst']/div/div[2]/table/tbody/tr/td[1]/span[1]/i")).isDisplayed();

		String contact_Name_Amil = driver.findElement(By.xpath("//*[@id='showcontactlst']/div/div[2]/table/tbody/tr/td[1]/span[2]")).getText();

		String get_Contact_Amil = driver.findElement(By.xpath("//*[@id='showcontactlst']/div/div[2]/table/tbody/tr/td[3]")).getText();
		String[] split_Contact_Extension = get_Contact_Amil.split("Ext: ");
		String contact_Number_Amil = split_Contact_Extension[0].replaceAll("[^0-9]", "");
		
		String contact_Extension_Amil = split_Contact_Extension[1];

		String Job_Title=driver.findElement(By.xpath("//*[@id='showcontactlst']/div/div[2]/table/tbody/tr/td[2]/span")).getText();
		
		String contact_Phone_Type_Amil = driver.findElement(By.xpath("//*[@id='showcontactlst']/div/div[2]/table/tbody/tr/td[4]")).getText();

		String contact_Email_Amil = driver.findElement(By.xpath("//*[@id='showcontactlst']/div/div[2]/table/tbody/tr/td[5]")).getText();

		System.out.println(contact_Name_Amil+"**"+Shipper_ContactName);
		System.out.println(contact_Number_Amil+"**"+Shipper_ContacNumber);
		System.out.println(contact_Extension_Amil+"**"+Shipper_ContExtense);
		System.out.println(contact_Email_Amil+"**"+Shipper_ContactEmail);
		System.out.println(contact_Phone_Type_Amil+"**"+Shipper_MobileType);
		System.out.println(Job_Title+"**"+Shipper_ContJobTitle);
				
		Assert.assertTrue(contact_Name_Amil.equalsIgnoreCase(Shipper_ContactName), "Contact Name issue");
		Assert.assertTrue(contact_Number_Amil.equalsIgnoreCase(Shipper_ContacNumber), "Contact phone number in amil issue");
		Assert.assertTrue(contact_Extension_Amil.equalsIgnoreCase(Shipper_ContExtense), "Contact extension in amil");
		Assert.assertTrue(contact_Email_Amil.equalsIgnoreCase(Shipper_ContactEmail), "Contact email amil issue");
		Assert.assertTrue(Job_Title.equalsIgnoreCase(Shipper_ContJobTitle), "Contact Job Title not matching");
		//Assert.assertTrue(contact_Phone_Type_Amil.equalsIgnoreCase(Shipper_MobileType), "contact phone type in amil");

		driver.findElement(By.xpath("//*[@id='docstab']")).click();	//Documents Tab
		Thread.sleep(6000);

		/*Document section */
		List<String> document_Types = new ArrayList<>();
		document_Types.add("accessorial charges sheet.pdf");
		document_Types.add("contract sheet.doc");
		document_Types.add("fuel surcharge sheet.png");
		Collections.sort(document_Types);
			
		List<WebElement> total_documents_In_Amil = driver.findElements(By.xpath("//*[@id='dmslist']/div[2]/table/tbody/tr"));
		System.out.println(total_documents_In_Amil);

		List<String> document_In_Amil = new ArrayList<>();

		for(int t=1; t<=total_documents_In_Amil.size(); t++)
		{
			//get the document names and store it in a list
			String get_Document_Names = driver.findElement(By.xpath("//*[@id='dmslist']/div[2]/table/tbody/tr["+t+"]/td[1]")).getText();
			document_In_Amil.add(get_Document_Names);
		}

		System.out.println(document_In_Amil);
		//Assert.assertTrue(document_In_Amil.equals(document_Types), "document in amil issue");

		/*invoice settings check*/

		driver.findElement(By.id("invoice")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='chkli']")).click();
		Thread.sleep(6500);
		
		String actualString = driver.findElement(By.xpath("//*[@id='fade-tab1']/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/ul/li")).getText();
		assertTrue(actualString.contains(Shipper_TrailerType));

		//String pay_Term_Amil = driver.findElement(By.xpath("//*[@id='fade-tab6']/div/div[2]/div/div[1]/div/div/div/div[2]/span")).getText();
		//String pay_Type_Amil = driver.findElement(By.xpath("//*[@id='fade-tab6']/div/div[2]/div/div[1]/div/div/div/div[3]/span")).getText();
				
		//Assert.assertTrue(pay_Term_Amil.equals(pay_Term), "invoice pay term in amil issue");
		//Assert.assertTrue(pay_Type_Amil.equals(pay_Type), "invoice pay type in amil issue");
	//ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.ShipCRMAcc_Result);
	Utils.takeScreenshot(driver, Shipper_Company+"Pass"+date1);
	Thread.sleep(2500);

	}
	catch (Exception e){
	//ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.ShipCRMAcc_Result);
	Reporter.log(" "+Shipper_Company+ "  Email receipents added & Verified - Unsuccessful");
	//Utils.takeScreenshot(driver, Shipper_Name+"Fail"+date1);
	Log.error(e.getMessage());
	throw (e);
	}

	}	
	}
	}

