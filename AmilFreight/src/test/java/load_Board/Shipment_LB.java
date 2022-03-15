package load_Board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import locators_Amil.ShipDash_Post;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;
import utility_Files.Utils;
import utility_Files.Utils2;

public class Shipment_LB extends BaseClass {

	public Shipment_LB(WebDriver driver) {
		super(driver);
		}

	@SuppressWarnings("unused")
	@Test
	public static void PostLoad_ShipmentGUID(String sTestCaseName) throws Exception
	{
		
	    driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
	    Thread.sleep(2500);
	    driver.navigate().refresh();  Thread.sleep(5500);

		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoadBoard");
		int rowused = ExcelUtils.getRowUsed();
		System.out.println("Rowused"+rowused);

		for (int i=1;i<=rowused;i++)
		{
		String TestCasename = sTestCaseName + "_"+i; 	
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.PostLoadShip_Testcase);
	  	Log.startTestCase(TestCasename);
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);

		String Shipper_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.PostLoadShip_Shipper);
		String PLShip_Trailer = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_Trailer);
		String PLShip_DispExec = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_DispExec);
		String PLShip_Origin = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_Origin);
		String PLShip_Destination = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_Destination);
		String PLShip_ShipmentID = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_Destination);
		String PLShip_ShipmentGUID = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_Destination);

		
		String Trailer_Type = PLShip_Trailer;
	//	String Dispatch_Exec = "Thomas";
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
		Sale_drop.selectByVisibleText(PLShip_DispExec);
		Thread.sleep(300);
		
		Select Trailer_drop=new Select(ShipDash_Post.TrailerType_DD());
		Trailer_drop.selectByVisibleText(Trailer_Type);
		Thread.sleep(300);
	

		ShipDash_Post.AddNew_Pickup().click();
		ShipDash_Post.Pick_Picklocation().sendKeys(PLShip_Origin);
		//driver.findElement(By.id("originMainlocation")).sendKeys("austin");
		//Texarkana, TX, USA
		Thread.sleep(2500);
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
		
		ShipDash_Post.Del_DelLocation().sendKeys(PLShip_Destination);				
		Thread.sleep(3500);				
		ShipDash_Post.Del_DelLocation().sendKeys(Keys.ARROW_DOWN);	
		ShipDash_Post.Del_DelLocation().sendKeys(Keys.ENTER);		
		Thread.sleep(300);	
		
		ShipDash_Post.Del_FromDel().click();	
		
		driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/a")).click();				
		driver.findElement(By.xpath("//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a")).click();							
		Thread.sleep(300);				

		ShipDash_Post.Del_StreetName().sendKeys("MGR Street");
		//ShipDash_Post.Del_ZipCode().sendKeys("78978945");
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
		Thread.sleep(8500);
		String notify = driver.findElement(By.cssSelector(".notifyjs-bootstrap-base.notifyjs-bootstrap-success>span")).getText();
		System.out.println(notify);
		
		//driver.close();
		Thread.sleep(2300);
  
		Utils.Instance_NewWindow(driver);
		Thread.sleep(2300);
		
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
	Thread.sleep(1500);
	ExcelUtils.setCellData(thomas, iTestCaseRow, Constant.PLShip_ShipmentID);
	
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
		 ExcelUtils.setCellData(Shipper_GUID, iTestCaseRow, Constant.PLShip_ShipmentGUID);
		
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
		ExcelUtils.setCellData(Shipper_GUID, iTestCaseRow, Constant.PLShip_ShipmentGUID);
		}
	
	Utils.Instance_NewWindow(driver);
	Thread.sleep(2300);
		
		
	} 
	}
	}


