package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;
import utility_Files.Log;

public class ShipDash_Post extends BaseClass{

	public ShipDash_Post(WebDriver driver) {
		super(driver);		
	}
	
private static WebElement element = null;

public static WebElement Post_Shipement_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[2]/div/div[1]/div/div[1]"));
       }catch (Exception e){
   		Log.error("Post_Shipement_Button not available");
   		throw(e);
   		}
   	return element;
}


public static WebElement Confirm_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='adddetails']/div[4]/div[2]/button[1]"));
       }catch (Exception e){
   		Log.error("Confirm_BUtton not available");
   		throw(e);
   		}
   	return element;
}


public static WebElement Close_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='adddetails']/div[2]/span[3]/a"));
       }catch (Exception e){
   		Log.error("Confirm_BUtton not available");
   		throw(e);
   		}
   	return element;
}


public static WebElement GetAll_Alert_Message() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@class='msgul'][2]"));
    	
       }catch (Exception e){
   		Log.error("GetAll_Alert_Message not available");
   		throw(e);
   		}
   	return element;
}


public static WebElement AlertOk_button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='btnNotiFyOk']"));
    	//*[@id="btnNotiFyOk"]
       }catch (Exception e){
   		Log.error("AlertOk_button not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Dispatch_Executive_DD() throws Exception{
    try{ 
    	 element = driver.findElement(By.id("ddlSalesRep"));
       }catch (Exception e){
   		Log.error("Dispatch_Executive_DD not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement TrailerType_DD() throws Exception{
    try{ 
    	 element = driver.findElement(By.id("trailertypeshipment"));
       }catch (Exception e){
   		Log.error("TrailerType_DD not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Shipper_Name() throws Exception{
    try{ 
    	 element = driver.findElement(By.id("ShipperName"));
       }catch (Exception e){
   		Log.error("Shipper_Name not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement ShipperName_Selection() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='liShipperout']/ul[1]/li"));
       }catch (Exception e){
   		Log.error("ShipperName_Selection not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement AddNew_Pickup() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='PickUpAddNew']"));
       }catch (Exception e){
   		Log.error("AddNew_Pick not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_Appointment_CheckBox() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='OAppointment']"));
       }catch (Exception e){
   		Log.error("Appointment_CheckBox not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_FCFS_CheckBox() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='OFCFS']"));
       }catch (Exception e){
   		Log.error("FCFS_CheckBox not available");
   		throw(e);
   		}
   	return element;
}


public static WebElement Pick_Picklocation() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='originMainlocation']"));
       }catch (Exception e){
   		Log.error("Post_Picklocation not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_Street() throws Exception{
    try{ 
    	element = driver.findElement(By.xpath("//*[@id='pickupaddress']"));
       }catch (Exception e){
   		Log.error("Post_Street not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_ZipCode() throws Exception{
    try{ 
    	element = driver.findElement(By.xpath("//*[@id='orgzip']"));
       }catch (Exception e){
   		Log.error("Post_ZipCode not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_PickUpDate() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='SDdtpickupdate']"));
       }catch (Exception e){
   		Log.error("Post_PickUpDate not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_PickUpDate_Clear() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='dateofpickupClear']"));
       }catch (Exception e){
   		Log.error("Post_PickUpDate not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Pick_Post_TimeZone() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='OTimeZone']"));
       }catch (Exception e){
   		Log.error("Post_TimeZone not available");
   		throw(e);
   		}
   	return element;
}
public static WebElement Pick_Business_Name() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='draggablepickup']/div[3]/span[1]/input"));
       }catch (Exception e){
   		Log.error("Business_Name not available");
   		throw(e);
   		}
   	return element;
}
public static WebElement Pick_Contact_Name() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='draggablepickup']/div[3]/span[2]/input"));
       }catch (Exception e){
   		Log.error("Contact_Name not available");
   		throw(e);
   		}
   	return element;
}
public static WebElement Pick_Contact_Number() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='contactnumber']"));
       }catch (Exception e){
   		Log.error("Contact_Number not available");
   		throw(e);
   		}
   	return element;
}
public static WebElement Pick_Contact_Email() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='emailpickup']"));
       }catch (Exception e){
   		Log.error("Contact_Email not available");
   		throw(e);
   		}
   	return element;
}  	
public static WebElement Pick_Package_Type() throws Exception{
   	    try{ 
   	    	 element = driver.findElement(By.xpath("//*[@id='txtpackagingtype']"));
   	       }catch (Exception e){
   	   		Log.error("Package_Type not available");
   	   		throw(e);
   	   		}
   	   	return element;
}  	   	
public static WebElement Pick_Package_Count() throws Exception{
   	    try{ 
   	    	 element = driver.findElement(By.xpath("//*[@id='draggablepickup']/div[3]/span[6]/input"));
   	       }catch (Exception e){
   	   		Log.error("Package_Count not available");
   	   		throw(e);
   	   		}
   	   	return element;
}  	   	
public static WebElement Pick_Weight() throws Exception{
   	    try{ 
   	    	 element = driver.findElement(By.xpath("//*[@id='PWeight']"));
   	       }catch (Exception e){
   	   		Log.error("Weight not available");
   	   		throw(e);
   	   		}
   	   	return element;
}  	   	
public static WebElement Pick_Material_Type() throws Exception{
   	    try{ 
   	    	 element = driver.findElement(By.xpath("//*[@id='PMaterialType']"));
   	       }catch (Exception e){
   	   		Log.error("Material_Type not available");
   	   		throw(e);
   	   		}
   	   	return element;
}  	

public static WebElement Del_AddDelievery() throws Exception{
	    try{ 
	    	 element = driver.findElement(By.xpath("//*[@id='AddDeliv']"));
	       }catch (Exception e){
	   		Log.error("Del_AddDelievery not available");
	   		throw(e);
	   		}
	   	return element;
}  


public static WebElement Del_CancelButton() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='closedest']"));
       }catch (Exception e){
   		Log.error("Del_CancelButton not available");
   		throw(e);
   		}
   	return element;
}  


public static WebElement Del_DelLocation() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='destinationMainlocation']"));
       }catch (Exception e){
   		Log.error("Del_DelLocation not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_StreetName() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='deliveryaddress']"));
       }catch (Exception e){
   		Log.error("Del_StreetName not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_ZipCode() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='deszip']"));
       }catch (Exception e){
   		Log.error("Del_ZipCode not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_DateDelivery() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='SDdtdeliverydate']"));
       }catch (Exception e){
   		Log.error("Del_DateDelivery not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_TimeZone() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='DTimeZone']"));
       }catch (Exception e){
   		Log.error("Del_TimeZone not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_FromDel() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='ddldelfrom']"));
       }catch (Exception e){
   		Log.error("Del_FromDel not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_ToDel() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='ddldelto']"));
       }catch (Exception e){
   		Log.error("Del_FromDel not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_BusinessName() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='draggabledelivery']/div[3]/span[1]/input"));
       }catch (Exception e){
   		Log.error("Del_BusinessName not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_ContactName() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='draggabledelivery']/div[3]/span[2]/input"));
       }catch (Exception e){
   		Log.error("Del_ContactName not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_ContactNumber() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='delcontactnumber']"));
       }catch (Exception e){
   		Log.error("Del_ContactNumber not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_ContactEmail() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='emaildel']"));
       }catch (Exception e){
   		Log.error("Del_ContactEmail not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_PackageType() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='txtdpackagingtype']"));
       }catch (Exception e){
   		Log.error("Del_PackageType not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_NoofPkg() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='DNoOfPack']"));
       }catch (Exception e){
   		Log.error("Del_NoofPkg not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_Weight() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='DWeight']"));
       }catch (Exception e){
   		Log.error("Del_Weight not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_MaterialType() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='DMaterialType']"));
       }catch (Exception e){
   		Log.error("Del_MaterialType not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_FCFS() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='DFCFS']"));
       }catch (Exception e){
   		Log.error("Del_FCFS not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_Appointment() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='DMaterialType']"));
       }catch (Exception e){
   		Log.error("Del_Appointment not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Del_SubmitButton() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='draggabledelivery']/div[4]/button[2]"));
       }catch (Exception e){
   		Log.error("Del_SubmitButton not available");
   		throw(e);
   		}
   	return element;
}



public static WebElement Post_Submit_Button() throws Exception{
   	    try{ 
   	    	 element = driver.findElement(By.xpath("//*[@id='draggablepickup']/div[4]/button[2]"));
   	       }catch (Exception e){
   	   		Log.error("Submit_Button not available");
   	   		throw(e);
   	   		}
   	   	return element;
}  

public static WebElement Post_SubmitConfirm_Button() throws Exception{
	    try{ 
	    	 element = driver.findElement(By.xpath("//*[@ng-click='confirmShipmentdetails(shipment)']"));
	       }catch (Exception e){
	   		Log.error("Submit_Button not available");
	   		throw(e);
	   		}
	   	return element;
}

public static WebElement Post_Cancel_Button() throws Exception{
   	    try{ 
   	    	 element = driver.findElement(By.xpath("//*[@id='closeorg']"));
   	       }catch (Exception e){
   	   		Log.error("Cancel_Button not available");
   	   		throw(e);
   	   		}
   	   	return element;
}

public static WebElement Post_PictureUp() throws Exception{
	    try{ 
	    	 element = driver.findElement(By.xpath("//*[@id='filedatadoc']"));
	       }catch (Exception e){
	   		Log.error("Post_PictureUp not available");
	   		throw(e);
	   		}
	   	return element;
}

public static WebElement Post_AddPictures() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='filedatadoc']"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Post_RefAddNew() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='divShipmentSec']/div[2]/div/div/div[1]/div[1]/div[5]/div[1]/button"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Post_RefLoadSpec() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='dynamicrcdfield']/div[2]/div[1]/div/div[2]/input"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Post_RefShipperSpec() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='dynamicrcdfield']/div[2]/div[1]/div/div[1]/input"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Post_RefField() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='dynamicrcdfield']/div[2]/div[2]/ul/li[1]/input"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Post_RefValue() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='dynamicrcdfield']/div[2]/div[2]/ul/li[2]/input"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Post_RefAdd() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='dynamicrcdfield']/div[2]/div[2]/div/div/button[1]"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}


}
