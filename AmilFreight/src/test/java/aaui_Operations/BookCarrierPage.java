package aaui_Operations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;

public class BookCarrierPage extends BaseClass {

	public BookCarrierPage(WebDriver driver) {
		super(driver);
	}
	@Test
	public static void Open2BookCarriers(String sTestCaseName) throws Exception
	{
		
		DOMConfigurator.configure("log4j.xml");						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Shipment");						
		int rowused = ExcelUtils.getRowUsed();						
		System.out.println("Rowused"+rowused);						
								
		for (int i=1;i<=rowused;i++)						
		{						
		String TestCasename = sTestCaseName + "_"+i; 						
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.SelMail_TestCaseName);						
	  	Log.startTestCase(TestCasename);						
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
   		
   		String Shipper_ID = ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_ShipMentID);
   		String Shipment_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.SelMail_Shipment_GUID);
   		
   		driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
   		Thread.sleep(6000);
   		
   		String ShipmentDashboardWindow=driver.getWindowHandle();
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
		//String CarrierAmount=driver.findElement(By.id("rate")).getText();
//		System.out.println(CarrierAmount);
	//	System.out.println("Rate--"+driver.findElement(By.xpath("//*[@id='rate']")).getText());
//		if(CarrierAmount =="") 
//		{
			driver.findElement(By.id("rate")).clear();
			driver.findElement(By.id("rate")).sendKeys(Rate);
//		}
		
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
				
				String loadref=driver.findElement(By.xpath("//*[@id='PluginReferenceId']")).getAttribute("value");
				//System.out.println(loadref);
				if(loadref.contentEquals("0")||loadref.contentEquals(""))
				{
					driver.findElement(By.xpath("//*[@id='PluginReferenceId']")).sendKeys(LoadRefID);
				}
				Thread.sleep(5000);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='btnBookShipment']")));
				Thread.sleep(7000); 
				driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click();
				Thread.sleep(15000); 
				
				Set<String> all = driver.getWindowHandles();
				//System.out.println("all Tabs--"+all);
				    
				for(String winHandle : driver.getWindowHandles())
				{
				    if(!winHandle.equals(ShipmentDashboardWindow))
				    {
				       //Condition satisfied. Switching to the security tab and closing it
				        driver.switchTo().window(winHandle);
				        //System.out.println("inside "+driver.getWindowHandle());
					    driver.close();

					 }
				 }
				    
				 driver.switchTo().window(ShipmentDashboardWindow);
				 Thread.sleep(4000);
				 //System.out.println(driver.getTitle());
				 driver.findElement(By.xpath("//*[@id='tabBooked']")).click();
		Thread.sleep(1900);

		//Driver Details
		String Driver_Name="Praveen Raja"; //Need To Change
		String Driver_PhNo="9787636489"; //Need To Change
		//Truck Details		
		String Truck_No="TN57PF2419"; //Need To Change
		//Trailer Details
		String TrailerName="CAPTACHA"; //Need To Change
		//Signed Rcd Document
		String document_SignedRCD="RCD.jpg";		
		String document_SBOL="SBOL.pdf";		
		String document_Invoice="INVOICE.pdf";
		//Path and Folder for Documents
		String filePath = System.getProperty("user.dir");
		String FolderName = "\\Documents\\";
		//Date Selection
		String xpath_Value="";
		String xpath_time_hours="";
		String xpath_time_minutes="";
		
		driver.navigate().to("http://stage.amilfreight.com/shipment/details/"+Shipment_GUID);
		//driver.navigate().to("http://stage.amilfreight.com/shipment/book/f88e0f04-e6b6-4aa8-ab56-2ec45933b0f0");
		Thread.sleep(1500);
		
		//EDMS Page
		//Driver Selection
		WebElement Add_Driver=driver.findElement(By.xpath("//span[2]/i[@ng-click='ShowAddDriverToggle()']"));	
		WebElement driverOptions = driver.findElement(By.xpath("//*[@id='ddlDriverConId']"));
		WebElement we_driverName=driver.findElement(By.xpath("//*[@id='frstname']"));
		WebElement we_driverContact=driver.findElement(By.xpath("//*[@id='txtdrivercontactnumber']"));
		WebElement we_driverSubmit=driver.findElement(By.xpath("//a[@ng-click='AddDriver(contact);']"));
	
		//Truck Details
		WebElement we_Add_Truck=driver.findElement(By.xpath("//span[2]/i[@ng-click='ShowAddTruckToggle()']"));
		WebElement we_truckOptions = driver.findElement(By.xpath("//*[@id='ddlCarrierId']"));
		WebElement we_truckNumber = driver.findElement(By.xpath("//*[@id='trkname']"));
		WebElement we_truckSubmit = driver.findElement(By.xpath("//*[@id='detailsadhoctruck']/div[2]/div[3]/span[2]/a"));

		
			
//Trailer Details
WebElement we_Add_Trailer = driver.findElement(By.xpath("//*[@id='collapsible-controls-group81']/div[1]/div[7]/span/span[3]/i[1]"));
		
		boolean Add_driverfield=Add_Driver.isDisplayed();	
		if(Add_driverfield==true)
		{
			Select driverSelect= new Select(driverOptions);
			//System.out.println("Driver options--" +driverSelect.getOptions().size());
			
			if(driverSelect.getOptions().size()>1)
			{	
				driverSelect.selectByIndex(1);
			}
			else if(driverSelect.getOptions().size()==1)
			{				
				Add_Driver.click();
			    Thread.sleep(2520);
			    we_driverName.sendKeys(Driver_Name);           
			    we_driverContact.sendKeys(Driver_PhNo);
			    we_driverSubmit.click();	
			}			
		}
		
		Thread.sleep(3900);
		
		//Truck Selection
		
		boolean Add_truckfield=we_Add_Truck.isDisplayed();
		//System.out.println(Add_truckfield);
		
		if(Add_truckfield==true)
		{
			Select truckSelect= new Select(we_truckOptions);
			//System.out.println("Truck options--" +truckSelect.getOptions().size());
			
			if(truckSelect.getOptions().size()>1)
			{	
				truckSelect.selectByIndex(1);
			}
			else if(truckSelect.getOptions().size()==1)
			{				
				we_Add_Truck.click();
			    Thread.sleep(2520);
			    we_truckNumber.sendKeys(Truck_No);
			    we_truckSubmit.click();
			    
			}			
		}
		Thread.sleep(2500);
		
		//Trailer Details	
		boolean Add_trailerfield=we_Add_Trailer.isDisplayed();		
		//System.out.println(Add_trailerfield);		
		if(Add_trailerfield==true)
		{
			Thread.sleep(2500);
		//	Select trailerSelect= new Select(we_trailerOptions);
		//	System.out.println("Trailer options--" +trailerSelect.getOptions().size());			
			js.executeScript("arguments[0].click()", we_Add_Trailer);
			ArrayList<String> tabs11 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs11.get(1));
		//	System.out.println(tabs1.get(0)+"title--"+ driver.getTitle()+"---"+tabs1.get(1)+"title--"+ driver.getTitle());
			Thread.sleep(2500);
			WebElement we_trailerOptionsPP=driver.findElement(By.xpath("//*[@id='edittrailers']"));
			Select trailerSelect_pp= new Select(we_trailerOptionsPP);
			//System.out.println("Trailer PPoptions--" +trailerSelect_pp.getOptions().size());
			trailerSelect_pp.selectByIndex(1);
			WebElement we_TrailerNo=driver.findElement(By.xpath("//*[@id='TrailerNo']"));
			WebElement we_InTrailer_Add= driver.findElement(By.xpath("//button[@ng-click='SaveTrailer(COMPANYGuid)']"));
			Thread.sleep(2500);		
			we_TrailerNo.sendKeys(TrailerName);	
			js.executeScript("arguments[0].click()", we_InTrailer_Add);    
			driver.switchTo().window(tabs11.get(0));
			Thread.sleep(2500);
		}			


		
		//Signed RCD Upload
		WebElement we_UploadSignedRCD=driver.findElement(By.xpath("//*[@id='signedRCD']"));
		we_UploadSignedRCD.sendKeys(filePath+FolderName+document_SignedRCD);
		Thread.sleep(2900);
		WebElement SRCD_uploadAction=driver.findElement(By.xpath("//a[@ng-click='uploaddocument($event,shipment,18)']"));
		SRCD_uploadAction.click();
		Thread.sleep(5000);
		
		System.out.println("Raaja");
		//Pickup Checkin
		driver.findElement(By.xpath("//*[@id='parrivaldate0']")).click();
		
		System.out.println("Raaja2");
		xpath_Value="//*[@id='body']/div[7]/div[3]/table/tbody/tr";	
		System.out.println("Raaja3");
		DateMethod(xpath_Value);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='parrivaltime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(pick,1,$index,1,shipment)']")).click();		
		Thread.sleep(2300);		

		//Skip BOL Document		
		WebElement Skip_BOL=driver.findElement(By.xpath("//a[@ng-click='SkipDocumnet(pick,5)']"));
		if(Skip_BOL.isDisplayed()==true)
		{		
			Thread.sleep(3500);		
			js.executeScript("arguments[0].click();", Skip_BOL);
		}

		//Pickup Checkout
		driver.findElement(By.xpath("//*[@id='pdeparturedate0']")).click();		
		xpath_Value="//*[@id='body']/div[8]/div[3]/table/tbody/tr";		
		DateMethod(xpath_Value);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='pdeparturetime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		Thread.sleep(1000);
    	driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(pick,2,$index,1,shipment)']")).click();		
    	Thread.sleep(2300);	
		
		
		//Delivery Checkin
		driver.findElement(By.xpath("//*[@id='darrivaldate0']")).click();		
		xpath_Value="//*[@id='body']/div[9]/div[3]/table/tbody/tr";		
		DateMethod(xpath_Value);
		driver.findElement(By.xpath("//*[@id='darrivaltime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]";
		driver.findElement(By.xpath(xpath_time_hours)).click();		
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(dest,1,$index,2,shipment)']")).click();		
		Thread.sleep(2300);		
		
		
		//SignedBill Of Lading
		WebElement we_UploadSignedBOL=driver.findElement(By.xpath("//input[@onchange='angular.element(this).scope().AddBillofLading(this.files,this.id,6)']"));
		we_UploadSignedBOL.sendKeys(filePath+FolderName+document_SBOL);
		
		WebElement SBOL_uploadAction=driver.findElement(By.xpath("//a[@ng-click='SaveEDMSDocument(6,dest)']"));
		js.executeScript("arguments[0].click();", SBOL_uploadAction);
		Thread.sleep(2300);
				
		//Delivery Form
		WebElement Skip_DeliveryForm=driver.findElement(By.xpath("//a[@ng-click='SkipDocumnet(dest,13)']"));
		if(Skip_DeliveryForm.isDisplayed()==true)
		{
			js.executeScript("arguments[0].click();", Skip_DeliveryForm);
		}
		
		//Delivery Checkout
		driver.findElement(By.xpath("//*[@id='ddeparturedate0']")).click();		
		xpath_Value="//*[@id='body']/div[10]/div[3]/table/tbody/tr";		
		DateMethod(xpath_Value);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='ddeparturetime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(dest,2,$index,2,shipment)']")).click();		
		Thread.sleep(2300);		
		
		
		//Mark As Delivered
		WebElement we_markasDelivered=driver.findElement(By.xpath("//span[@ng-click='showMarkasdelivered()']"));
		we_markasDelivered.click();
		WebElement we_markasDelivered_yes=driver.findElement(By.xpath("//a[@ng-click='DeliveryStatus(1)']"));
		we_markasDelivered_yes.click();
		Thread.sleep(2300);
		
		//Confirm As Delivered
		WebElement we_confirmasDelivered=driver.findElement(By.xpath("//span[@ng-click='Confirmasdelivered()']"));
		we_confirmasDelivered.click();
		WebElement we_confirmasDelivered_yes=driver.findElement(By.xpath("//a[@ng-click='DeliveryStatus(2)']"));
		we_confirmasDelivered_yes.click();
		Thread.sleep(2300);
		
		//Skip Additional Expenses
		WebElement we_skipadditionalExpenses=driver.findElement(By.xpath("//span[@ng-click='skipAdditionalExpenses()']"));
		we_skipadditionalExpenses.click();
		Thread.sleep(2300);
		
		//Mark as Completes
		WebElement we_markasCompleted=driver.findElement(By.xpath("//span[@ng-click='showcompleted()']"));
		we_markasCompleted.click();
		WebElement we_markasCompleted_Yes=driver.findElement(By.xpath("//a[@ng-click='DeliveryStatus(3)']"));
		we_markasCompleted_Yes.click();		
		Thread.sleep(2300);
		
		//Upload Invoice Document
		WebElement we_Uploadinvoice=driver.findElement(By.xpath("//*[@id='carrierLoading']"));
		we_Uploadinvoice.sendKeys(filePath+FolderName+document_Invoice);
		
		WebElement Invoice_uploadAction=driver.findElement(By.xpath("//a[@ng-click='uploaddocument($event,shipment,10)']"));
		Invoice_uploadAction.click();
		Thread.sleep(5000);
		
		//Invoice Date
		driver.findElement(By.xpath("//*[@id='invoicegenerateddate']")).click();		
		xpath_Value="//*[@id='body']/div[11]/div[3]/table/tbody/tr";		
		DateMethod(xpath_Value);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='InvoiceGeneratedTime']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[3]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@ng-click='saveInvoiceGeneratedON(InvoiceGeneratedOn,InvoiceGeneratedTime)']")).click();		
		Thread.sleep(2300);	
		
		
		//Submit For Payment
		WebElement we_submitForPayment=driver.findElement(By.xpath("//span[@ng-click='showPayment()']"));
		we_submitForPayment.click();
		WebElement we_submitForPayment_Yes=driver.findElement(By.xpath("//a[@ng-click='SubmitPayment()']"));
		we_submitForPayment_Yes.click();		
		Thread.sleep(2300);
		
		}	
}	


	public static void DateMethod(String xpath)
	{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String AvailableDate = sdf.format(cal.getTime());  
        //System.out.println("Available Date : "+AvailableDate);             
        String[] arrSplit_Date = AvailableDate.split("/"); 
        arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");
        List<WebElement> dtRows=driver.findElements(By.xpath(xpath));  
        for(int j=1;j<=dtRows.size();j++)
        {
        	for(int i=1;i <= 7;i++)
        	{
        		String dateRowxpath= xpath;
               String date_xpath ="["+j+"]";
                     String dateRowxpath_first=dateRowxpath.concat(date_xpath);
                     String date_td="/td";
                     String date_tdvalue="["+i+"]";
                     String date=date_td.concat(date_tdvalue);
                     String datexpath_Complete=dateRowxpath_first.concat(date);
                     WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
                     String date_text= dateElement.getText();
                     if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
                     {
                            if((dateElement.getAttribute("class").contentEquals("day active"))||(dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
                            {
                                   dateElement.click();
                                   i=8;
                                   j=dtRows.size()+1;
                            }
                     }
        	}
        }
	}
	
	}

