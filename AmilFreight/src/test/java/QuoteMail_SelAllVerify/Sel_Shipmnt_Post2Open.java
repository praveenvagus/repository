package QuoteMail_SelAllVerify;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;
import utility_Files.Utils2;

public class Sel_Shipmnt_Post2Open extends BaseClass
{

	public Sel_Shipmnt_Post2Open(WebDriver driver) {
		super(driver);
	}


	@Test
	public static void PostLoad_ShipmentGUID(String sTestCaseName) throws Exception
	{
		
	    driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
	    Thread.sleep(2500);
	    driver.navigate().refresh();  Thread.sleep(5500);

		DOMConfigurator.configure("log4j.xml");							
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"QuoteSelMail");							
		int rowused = ExcelUtils.getRowUsed();							
		System.out.println("Rowused"+rowused);							
									
		for (int i=1;i<=1;i++)							
		{							
		String TestCasename = sTestCaseName + "_"+i; 							
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.SelMail_TestCaseName);							
	  	Log.startTestCase(TestCasename);							
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);							
									
		String Shipper_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_ShipperName);
		String Shipper_ID = ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_ShipMentID);
		String Pickup_Location = ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_Pickup_Location);							
		String Delievery_Loc=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_Delievery_loc);							
									
		String Trailer_Type = "RGN";							
		String Dispatch_Exec = "Thomas";							
		//String Post_Result = ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_LoadResult);							
		Thread.sleep(2700);							
									
		ShipDash_Post.Post_Shipement_Button().click();							
		Thread.sleep(3000);							
									
		Utils.Instance_NewWindow(driver);							
									
		driver.manage().window().maximize();							
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);							
		System.out.println(Shipper_Name);							
		ShipDash_Post.Shipper_Name().sendKeys(Shipper_Name);							
		Thread.sleep(2500);							
		ShipDash_Post.ShipperName_Selection().click();							
		Thread.sleep(300);							
									
		driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("2700");							
		driver.findElement(By.xpath("//*[@id='truckrate']")).sendKeys("2000");							
		Select Sale_drop=new Select(ShipDash_Post.Dispatch_Executive_DD());							
		Sale_drop.selectByVisibleText(Dispatch_Exec);							
		Thread.sleep(300);							
									
		Select Trailer_drop=new Select(ShipDash_Post.TrailerType_DD());							
		Trailer_drop.selectByVisibleText(Trailer_Type);							
		Thread.sleep(300);							
									
									
		ShipDash_Post.AddNew_Pickup().click();							
		ShipDash_Post.Pick_Picklocation().sendKeys(Pickup_Location);							
		//driver.findElement(By.id("originMainlocation")).sendKeys("austin");							
		//Texarkana, TX, USA							
		Thread.sleep(1500);							
		ShipDash_Post.Pick_Picklocation().sendKeys(Keys.ARROW_DOWN);							
		ShipDash_Post.Pick_Picklocation().sendKeys(Keys.ENTER);							
		Thread.sleep(300);							
									
		ShipDash_Post.Pick_PickUpDate().click();							
		Utils2.PostLoad_PickUpDate(driver);							
		//driver.findElement(By.xpath("html/body/div[4]/div[3]/table/tbody/tr[5]/td[6]")).click();							
		Thread.sleep(300);							
									
		WebElement Pickup_LoadText=ShipDash_Post.Pick_Weight();							
		Pickup_LoadText.sendKeys("3600");							
									
		ShipDash_Post.Pick_Package_Type().sendKeys("Chemicals");							
		Thread.sleep(1500);							
		ShipDash_Post.Pick_Package_Type().sendKeys(Keys.ARROW_DOWN);							
		ShipDash_Post.Pick_Package_Type().sendKeys(Keys.ENTER);							
		Thread.sleep(300);							
		ShipDash_Post.Pick_Material_Type().sendKeys("Ironed Fabric");							
									
		Select Pic_TimeZ=new Select(ShipDash_Post.Pick_Post_TimeZone());							
		Pic_TimeZ.selectByIndex(3);							
		driver.findElement(By.xpath("//*[@id='ddlpickupfrom']")).click();							
		driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[4]/td[6]/a")).click();							
		driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[4]/td[3]/a")).click();							
									
	  ShipDash_Post.Pick_Street().sendKeys("Manorama Street");								
	  //ShipDash_Post.Pick_ZipCode().sendKeys("5645644");								
	  ShipDash_Post.Pick_Business_Name().sendKeys("Paragon office");								
	  ShipDash_Post.Pick_Contact_Name().sendKeys("Thiruthuvaraj Robin");								
	  ShipDash_Post.Pick_Contact_Number().sendKeys("8787878778");								
	  ShipDash_Post.Pick_Contact_Email().sendKeys("ps2@gmail.com");								
	  ShipDash_Post.Pick_Package_Count().sendKeys("750");								
									
		ShipDash_Post.Post_Submit_Button().click();							
		Thread.sleep(1000);							
		ShipDash_Post.Del_AddDelievery().click();							
									
		ShipDash_Post.Del_DelLocation().sendKeys(Delievery_Loc);							
		Thread.sleep(1000);							
		ShipDash_Post.Del_DelLocation().sendKeys(Keys.ARROW_DOWN);							
		ShipDash_Post.Del_DelLocation().sendKeys(Keys.ENTER);							
		Thread.sleep(300);							
									
		ShipDash_Post.Del_FromDel().click();							
									
		driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a")).click();							
		driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a")).click();							
		Thread.sleep(300);							
									
		ShipDash_Post.Del_StreetName().sendKeys("MGR Street");							
		ShipDash_Post.Del_ZipCode().sendKeys("78978945");							
		driver.findElement(By.xpath("//*[@id='SDdtdeliverydate']")).click();							
		Utils2.PostLoad_DropDate(driver);							
		Thread.sleep(1900);							
		ShipDash_Post.Del_BusinessName().sendKeys("Jeffrin Powders");							
		ShipDash_Post.Del_ContactName().sendKeys("Raveendira Jadeja");							
		ShipDash_Post.Del_ContactNumber().sendKeys("9191919191");							
	    ShipDash_Post.Del_ContactEmail().sendKeys("ps4@gmail.com");								
	    ShipDash_Post.Del_SubmitButton().click();								
									
	    Thread.sleep(1500);								
									
		driver.findElement(By.xpath("//*[@id='PluginReferenceId']")).sendKeys("#2411");							
									
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);							
		ShipDash_Post.Confirm_Button().click();							
		System.out.println("Kathirvel Rama4 Moorthy");							
		Thread.sleep(3500);							
									
		if(driver.findElement(By.xpath("//*[@id='adddetails']/div[4]/div[2]/button[3]")).isDisplayed()) {							
			driver.findElement(By.xpath("//*[@id='adddetails']/div[4]/div[2]/button[3]")).click();						
		}							
		Thread.sleep(8000);							
  									
		Utils.Instance_NewWindow(driver);							
		Thread.sleep(1000);							
									
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);							
		boolean enabled = driver.findElement(By.xpath("//*[@id='sort-4']/span[1]/i")).isSelected();							
		System.out.println("Already not c212161hecked");							
	    if(!enabled){								
	        System.out.println("Already checked");								
		    driver.findElement(By.xpath("//*[@id='shipmentdashboardlist']/div/div[2]/a")).click();							
	    }								
	    else								
	    {								
	    	System.out.println("Already not checked");							
	    	driver.findElement(By.xpath("//*[@id='sort-4']/span[1]/i")).click();							
	    }								
	    								
	    Thread.sleep(1500);								
	    driver.findElement(By.xpath("//*[@id='shipmentdashboardlist']/div/div[2]/a")).click();								
	    boolean enabled1 = driver.findElement(By.xpath("//*[@id='shipmentdashboardlist']/div/div[2]/div/ul[2]/li[2]/label")).isSelected();								
	    if(!enabled1){    								
	        System.out.println("Already checked");								
	        driver.findElement(By.xpath("//*[@id='shipmentdashboardlist']/div/div[2]/a")).click();								
	    }								
	    else								
	    {								
	        driver.findElement(By.xpath("//*[@id='shipmentdashboardlist']/div/div[2]/div/ul[2]/li[2]/label")).click();								
	    }								
									
	    driver.findElement(By.xpath("//*[@id='dashadvance']")).click();								
									
	    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);								
									
	    driver.findElement(By.xpath("//*[@id='txtshippername']")).sendKeys(Shipper_Name);								
	    Thread.sleep(3500);								
									
	    driver.findElement(By.xpath("//*[@id='liShipperCol']/ul[1]/li/span")).click();								
	    Thread.sleep(1500);								
									
	    driver.findElement(By.xpath("//*[@id='applyAdvSearch']")).click();								
									
	Thread.sleep(3500);								
	String thomas=driver.findElement(By.xpath("//*[@id='shiplistpaging']/div[2]/div/div/div/div/div[@id='shipRpt ship']/div[1]/div[1]/div/a[1]")).getText();								
	System.out.println(thomas);								
									
	ExcelUtils.setCellData(thomas, iTestCaseRow, Constant.SelMail_ShipMentID);								
									
	String str1 = driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]//parent::div/div[3]/span[2]")).getText(); 	   							
    String[] arrSplitSpace = str1.split(","); 									
    String rplcSpace=arrSplitSpace[0].replace(" ", "");									
    System.out.println(rplcSpace);									
      									
    String pattern = "MMM dd";									
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);									
    String Date = simpleDateFormat.format(new Date());									
    String stringWithoutSpaces1 = Date.replaceAll("\\s+", "");									
    System.out.println(stringWithoutSpaces1); 									
									
									
	if(rplcSpace.equalsIgnoreCase(stringWithoutSpaces1)) {								
									
		System.out.println("Pakka condition");							
		driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]")).click();							
		Utils.Instance_NewWindow(driver);							
		String Shipper = driver.getCurrentUrl();							
		String[] Shipper_Part = Shipper.split("(/)");							
		String Shipper_GUID = Shipper_Part[5]; 							
		System.out.println(Shipper_GUID);							
		driver.close();							
		 ExcelUtils.setCellData(Shipper_GUID, iTestCaseRow, Constant.SelMail_Shipment_GUID);							
									
	}								
	else {								
									
		System.out.println("Konjam BAD condition");							
		driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]")).click();							
		Utils.Instance_NewWindow(driver);							
		String Shipper = driver.getCurrentUrl();							
		String[] Shipper_Part = Shipper.split("(/)");							
		String Shipper_GUID = Shipper_Part[5]; 							
		System.out.println(Shipper_GUID);							
		driver.close();							
		ExcelUtils.setCellData(Shipper_GUID, iTestCaseRow, Constant.SelMail_Shipment_GUID);							
		}							
									
	Utils.Instance_NewWindow(driver);								
									
	//TakeOver								
	driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]//parent::div//parent::div//parent::div/div[7]/div[1]/span/a[@class='takeover-ic']")).click();								
	Thread.sleep(3000);								
		System.out.println("Take-Overed by Praveen Raja A");							
									
		driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]//parent::div//parent::div//parent::div/div[7]/div[1]/a[@title='Bid']")).click();							
		Utils.Instance_NewWindow(driver);							
		System.out.println(driver.getCurrentUrl());							
		driver.findElement(By.xpath("//*[@id='txtBidAmount']")).sendKeys("800");							
		driver.findElement(By.xpath("//*[@id='divBidAmountSubmission']/div[4]/div/div[4]/button[2]")).click();							
		Thread.sleep(2500);							
		driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click();							
		Thread.sleep(2500);							
		Utils.Instance_NewWindow(driver);							
									
		Thread.sleep(2500);							
									
		driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]//parent::div//parent::div//parent::div/div[7]/div[1]/a[@title='Bid Accept']")).click();							
		driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click();							
		Thread.sleep(3000);							
		driver.findElement(By.xpath("//*[contains(text(),'"+thomas+"')]//parent::div//parent::div//parent::div//div[6]/span[2]")).click();							
									
		Thread.sleep(3600);							
		Utils.Instance_NewWindow(driver);							
		Thread.sleep(5000);							
		driver.findElement(By.xpath("//*[@id='adddetails']/div[4]/div[2]/button[1]")).click();							
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);							
		driver.findElement(By.xpath("//*[@id='adddetails']/div[4]/div[2]/button[3]")).click();							
		Thread.sleep(8000);							
		Utils.Instance_NewWindow(driver);							
		Thread.sleep(2800);							
		System.out.println("Ship Success");						

		driver.findElement(By.xpath("//*[@id='textsearch']")).sendKeys(Shipper_ID);
		driver.findElement(By.xpath("//i[@ng-click='basicSearch($event)']")).click();
		
//		driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[1]/div[1]/div[1]/div/i[3]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='tabOpen']")).click();
		//driver.findElement(By.xpath("//*[@id='Tak29251']/a")).click();
		Thread.sleep(3000);
		
		
		//Details
		String CarrierName	= 	"HARPERS HOT SHOT TRUCKING";
		String LoadType		=	"Live Load";
		String UnLoadType	=	"Live Load";
		String Rate			=	"123";
		String DefaultPayment= 	"Select Type";
		String PaymentMode	=	"Direct Payment";
		String DefaultPaymentType="Select Type";
		String PaymentType	=	"By Check";
		String DefaultpaymentTermNet= "Select";
		String PaymentTermNet=	"NET 2  (5%)";
		String LoadRefID	=	"Load#123";
		
		//Take Over
		WebElement we_TakeOver = driver.findElement(By.xpath("//span[@ng-click='TakeOverShipment(shipment.Id,$index)']"));
		//System.out.println("test takeover--"+we_TakeOver.isDisplayed());

		WebElement we_BookCarrier= driver.findElement(By.xpath("//span[@ng-click='bookShipment(shipment.ShipmentGuid)']"));
		if(we_TakeOver.isDisplayed()==true)
		{
			we_TakeOver.click();
			Thread.sleep(6000);
		}	
		we_BookCarrier.click();
		Thread.sleep(6000);
		
		//Book Carrier
		
		Thread.sleep(3000);
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));
		//System.out.println("title Window"+driver.getTitle());
		driver.manage().window().maximize();
		
		//Carrier Name
		WebElement we_CarrierName=	driver.findElement(By.xpath("//*[@id='carrier']"));
		we_CarrierName.sendKeys(CarrierName);
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(we_CarrierName).sendKeys(Keys.DOWN).perform();
		Thread.sleep(5000);
		actions.moveToElement(we_CarrierName).sendKeys(Keys.ENTER).perform();
		Thread.sleep(7000);
		
		//load type
				Select we_LoadType = new Select(driver.findElement(By.xpath("//*[@id='txtbookloadtype']")));
				we_LoadType.selectByVisibleText(LoadType);
				
				//Unload Type
				Select we_UnLoadType = new Select(driver.findElement(By.xpath("//*[@id='bookcarr']/following-sibling::div[5]/select")));
				we_UnLoadType.selectByVisibleText(UnLoadType);
				
				
				//Rate
				String CarrierAmount=driver.findElement(By.id("rate")).getText();
//				System.out.println(CarrierAmount);
				//System.out.println("Rate--"+driver.findElement(By.xpath("//*[@id='rate']")).getText());
				if(CarrierAmount =="") 
				{
					driver.findElement(By.id("rate")).sendKeys(Rate);
				}
				
				//Payment Mode
				WebElement we_paymentMode=driver.findElement(By.xpath("//*[@id='paymentmode']"));
				if(we_paymentMode.getText().equalsIgnoreCase(DefaultPayment))
				{
					Select we_PaymentModeOptions = new Select(we_paymentMode);
					we_PaymentModeOptions.selectByVisibleText(PaymentMode);					
				}
				//System.out.println("Load Type--" +driver.findElement(By.xpath("//*[@id='paymentmode']")).getText());
				//Payment Type
				WebElement we_PaymentType= driver.findElement(By.xpath("//*[@id='paymenttype']"));
				if(we_PaymentType.getText().equalsIgnoreCase(DefaultPaymentType))
				{
					Select we_PaymentModeOptions = new Select(we_PaymentType);
					we_PaymentModeOptions.selectByVisibleText(PaymentType);					
				}		
				//System.out.println("Payment Type--" +we_PaymentType.getText());
				
				//PaymentTermnet
				WebElement we_PaymentTermnet= driver.findElement(By.xpath("//*[@id='validatecarrierlink']/div/div/div[1]/div[2]/div[2]/div/div[17]"));
				if(we_PaymentTermnet.getText().equalsIgnoreCase(DefaultpaymentTermNet))
				{
					Select we_PaymentTermnetOptions = new Select(we_PaymentTermnet);
					we_PaymentTermnetOptions.selectByVisibleText(PaymentTermNet);					
				}		
//				System.out.println("PaymentTermNet--" +we_PaymentType.getText());
				
				String loadref=driver.findElement(By.xpath("//*[@id='PluginReferenceId']")).getText();
				if(loadref=="")
				{
					driver.findElement(By.xpath("//*[@id='PluginReferenceId']")).sendKeys(LoadRefID);
				}
				Thread.sleep(5000);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='btnBookShipment']")));
//				driver.findElement(By.xpath("//*[@id='btnBookShipment']")).click();
				Thread.sleep(4000); 
				driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click();
				
			}
			
			
		}
}
