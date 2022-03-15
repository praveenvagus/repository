package preferred_States;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility_Files.BaseClass;

public class EDMS extends BaseClass {
	
	public EDMS(WebDriver driver) {
		super(driver);
		}

	@Test
	public void edms_Complete(String sTestCaseName) throws InterruptedException
	{
		Thread.sleep(5000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//Driver Details
		String Driver_Name="DriverJan0707"; //Need To Change
		String Driver_PhNo="1237897457"; //Need To Change
		
		//Truck Details		
		String Truck_No="TruckJan0707"; //Need To Change
		
		//Trailer Details
		String TrailerName="TrailerJan0707"; //Need To Change
		
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
		
		
		//EDMS Page
		//Driver Selection
		WebElement Add_Driver=driver.findElement(By.xpath("//span[@ng-click='ShowAddDriverToggle()']"));	
		WebElement driverOptions = driver.findElement(By.xpath("//*[@id='ddlDriverConId']"));
		WebElement we_driverName=driver.findElement(By.xpath("//*[@id='frstname']"));
		WebElement we_driverContact=driver.findElement(By.xpath("//*[@id='txtdrivercontactnumber']"));
		WebElement we_driverSubmit=driver.findElement(By.xpath("//a[@ng-click='AddDriver(contact);']"));
	
		//Truck Details
		WebElement we_Add_Truck=driver.findElement(By.xpath("//span[@ng-click='ShowAddTruckToggle()']"));
		WebElement we_truckOptions = driver.findElement(By.xpath("//*[@id='ddlCarrierId']"));
		WebElement we_truckNumber = driver.findElement(By.xpath("//*[@id='trkname']"));
		WebElement we_truckSubmit = driver.findElement(By.xpath("//*[@id='detailsadhoctruck']/div[2]/div[3]/span[2]/a"));
		
		
		//Trailer Details
		WebElement we_Add_Trailer = driver.findElement(By.xpath("//span[@ng-click='ShowAddTrailerToggle()']"));
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
		
		Thread.sleep(6000);
		
		//Truck Selection
		
		boolean Add_truckfield=we_Add_Truck.isDisplayed();
	
		if(Add_truckfield==true)
		{
			Select truckSelect= new Select(we_truckOptions);
		
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
		Thread.sleep(6000);
		
		//Trailer Details	
		boolean Add_trailerfield=we_Add_Trailer.isDisplayed();		
		if(Add_trailerfield==true)
		{
			Thread.sleep(6000);	
			js.executeScript("arguments[0].click()", we_Add_Trailer);
			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			Thread.sleep(3000);
			WebElement we_trailerOptionsPP=driver.findElement(By.xpath("//*[@id='edittrailers']"));
			Select trailerSelect_pp= new Select(we_trailerOptionsPP);
			trailerSelect_pp.selectByIndex(1);
			WebElement we_TrailerNo=driver.findElement(By.xpath("//*[@id='TrailerNo']"));
			WebElement we_InTrailer_Add= driver.findElement(By.xpath("//button[@ng-click='SaveTrailer(COMPANYGuid)']"));
			Thread.sleep(3000);		
			we_TrailerNo.sendKeys(TrailerName);	
			js.executeScript("arguments[0].click()", we_InTrailer_Add);    
			driver.switchTo().window(tabs1.get(0));
			Thread.sleep(10000);
		}			


		
		//Signed RCD Upload
		WebElement we_UploadSignedRCD=driver.findElement(By.xpath("//*[@id='signedRCD']"));
		we_UploadSignedRCD.sendKeys(filePath+FolderName+document_SignedRCD);
		Thread.sleep(5000);
		WebElement SRCD_uploadAction=driver.findElement(By.xpath("//a[@ng-click='uploaddocument($event,shipment,18)']"));
		SRCD_uploadAction.click();
		Thread.sleep(3000);
		
		//Pickup Checkin
		driver.findElement(By.xpath("//*[@id='parrivaldate0']")).click();		
		xpath_Value="//*[@id='body']/div[8]/div[3]/table/tbody/tr";
				//"//*[@id='body']/div[7]/div[3]/table/tbody/tr";		
		dateMethod(xpath_Value);
		driver.findElement(By.xpath("//*[@id='parrivaltime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(pick,1,$index,1,shipment)']")).click();		
		Thread.sleep(3000);		

		//Skip BOL Document		
		WebElement Skip_BOL=driver.findElement(By.xpath("//a[@ng-click='SkipDocumnet(pick,5)']"));
		if(Skip_BOL.isDisplayed()==true)
		{		
			Thread.sleep(6000);		
			js.executeScript("arguments[0].click();", Skip_BOL);
		}

		//Pickup Checkout
		driver.findElement(By.xpath("//*[@id='pdeparturedate0']")).click();		
		//xpath_Value="//*[@id='body']/div[8]/div[3]/table/tbody/tr";		
		xpath_Value="//*[@id='body']/div[9]/div[3]/table/tbody/tr";
		dateMethod(xpath_Value);
		driver.findElement(By.xpath("//*[@id='pdeparturetime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
    	driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(pick,2,$index,1,shipment)']")).click();		
    	Thread.sleep(3000);	
		
		
		//Delivery Checkin
		driver.findElement(By.xpath("//*[@id='darrivaldate0']")).click();		
		xpath_Value="//*[@id='body']/div[10]/div[3]/table/tbody/tr";		
		dateMethod(xpath_Value);
		driver.findElement(By.xpath("//*[@id='darrivaltime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]";
		driver.findElement(By.xpath(xpath_time_hours)).click();		
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(dest,1,$index,2,shipment)']")).click();		
		Thread.sleep(3000);		
		
		
		//SignedBill Of Lading
		WebElement we_UploadSignedBOL=driver.findElement(By.xpath("//input[@onchange='angular.element(this).scope().AddBillofLading(this.files,this.id,6)']"));
		we_UploadSignedBOL.sendKeys(filePath+FolderName+document_SBOL);
		
		WebElement SBOL_uploadAction=driver.findElement(By.xpath("//a[@ng-click='SaveEDMSDocument(6,dest)']"));
		js.executeScript("arguments[0].click();", SBOL_uploadAction);
		Thread.sleep(3000);
				
		//Delivery Form
		WebElement Skip_DeliveryForm=driver.findElement(By.xpath("//a[@ng-click='SkipDocumnet(dest,13)']"));
		if(Skip_DeliveryForm.isDisplayed()==true)
		{
			js.executeScript("arguments[0].click();", Skip_DeliveryForm);
		}
		
		//Delivery Checkout
		driver.findElement(By.xpath("//*[@id='ddeparturedate0']")).click();		
		xpath_Value="//*[@id='body']/div[11]/div[3]/table/tbody/tr";		
		dateMethod(xpath_Value);
		driver.findElement(By.xpath("//*[@id='ddeparturetime0']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[4]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		driver.findElement(By.xpath("//a[@ng-click='updatePickupDeliveryTime(dest,2,$index,2,shipment)']")).click();		
		Thread.sleep(3000);		
		
		
		//Mark As Delivered
		WebElement we_markasDelivered=driver.findElement(By.xpath("//span[@ng-click='showMarkasdelivered()']"));
		we_markasDelivered.click();
		WebElement we_markasDelivered_yes=driver.findElement(By.xpath("//a[@ng-click='DeliveryStatus(1)']"));
		we_markasDelivered_yes.click();
		Thread.sleep(3000);
		
		//Confirm As Delivered
		WebElement we_confirmasDelivered=driver.findElement(By.xpath("//span[@ng-click='Confirmasdelivered()']"));
		we_confirmasDelivered.click();
		WebElement we_confirmasDelivered_yes=driver.findElement(By.xpath("//a[@ng-click='DeliveryStatus(2)']"));
		we_confirmasDelivered_yes.click();
		Thread.sleep(3000);
		
		//Skip Additional Expenses
		WebElement we_skipadditionalExpenses=driver.findElement(By.xpath("//span[@ng-click='skipAdditionalExpenses()']"));
		we_skipadditionalExpenses.click();
		Thread.sleep(3000);
		
		//Mark as Completes
		WebElement we_markasCompleted=driver.findElement(By.xpath("//span[@ng-click='showcompleted()']"));
		we_markasCompleted.click();
		WebElement we_markasCompleted_Yes=driver.findElement(By.xpath("//a[@ng-click='DeliveryStatus(3)']"));
		we_markasCompleted_Yes.click();		
		Thread.sleep(3000);
		
		//Upload Invoice Document
		WebElement we_Uploadinvoice=driver.findElement(By.xpath("//*[@id='carrierLoading']"));
		we_Uploadinvoice.sendKeys(filePath+FolderName+document_Invoice);
		
		WebElement Invoice_uploadAction=driver.findElement(By.xpath("//a[@ng-click='uploaddocument($event,shipment,10)']"));
		Invoice_uploadAction.click();
		Thread.sleep(3000);
		
		//Invoice Date
		driver.findElement(By.xpath("//*[@id='invoicegenerateddate']")).click();		
		xpath_Value="//*[@id='body']/div[12]/div[3]/table/tbody/tr";		
//		/html/body/div[12]/div[3]/table/tbody/tr
		dateMethod(xpath_Value);
		driver.findElement(By.xpath("//*[@id='InvoiceGeneratedTime']")).click();
		xpath_time_hours="//*[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[3]";
		driver.findElement(By.xpath(xpath_time_hours)).click();
		xpath_time_minutes="//*[@id='ui-timepicker-div']/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]";
		driver.findElement(By.xpath(xpath_time_minutes)).click();
		driver.findElement(By.xpath("//a[@ng-click='saveInvoiceGeneratedON(InvoiceGeneratedOn,InvoiceGeneratedTime)']")).click();		
		Thread.sleep(3000);	
		
		
		//Submit For Payment
		WebElement we_submitForPayment=driver.findElement(By.xpath("//span[@ng-click='showPayment()']"));
		we_submitForPayment.click();
		WebElement we_submitForPayment_Yes=driver.findElement(By.xpath("//a[@ng-click='SubmitPayment()']"));
		we_submitForPayment_Yes.click();		
		Thread.sleep(3000);
		
		
	}

	public static void dateMethod(String xpath)
	{
		//System.out.println(xpath);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Getting current date
        Calendar cal = Calendar.getInstance();
        String AvailableDate = sdf.format(cal.getTime());  
               
        //System.out.println("Available Date : "+AvailableDate);             
               
        String[] arrSplit_Date = AvailableDate.split("/"); 
        arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");


        //To get all the rows of Calendar
        List<WebElement> dtRows=driver.findElements(By.xpath(xpath));  

        for(int j=1;j<=dtRows.size();j++)
        {
        	//System.out.println("Correct");
        	for(int i=1;i <= 7;i++)
        	{
        		String dateRowxpath= xpath;
               String date_xpath ="["+j+"]";
                     String dateRowxpath_first=dateRowxpath.concat(date_xpath);
                     String date_td="/td";
                     String date_tdvalue="["+i+"]";
                     String date=date_td.concat(date_tdvalue);
                     //xpath for the single date
                     String datexpath_Complete=dateRowxpath_first.concat(date);
                     
                     WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
                     
                     //System.out.println(datexpath_Complete);
//                   String dd1= dateElement.getAttribute("value");
                     String date_text= dateElement.getText();
//                   System.out.println(dd1+"::::"+dd13);
                     if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
                     {
                     //     System.out.println(dateElement);
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
