package accounts_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Log;
import utility_Files.Utils;

public class Accounts_PageOper extends BaseClass{

public Accounts_PageOper(WebDriver driver) {
		super(driver);		
}
	
	@Test
	public static void PostLoad_ShipmentGUID(String sTestCaseName) throws Exception
	{
		Log.info("Logged into the Application");  
		
		for (String Newly_Opened : driver.getWindowHandles()) {
			driver.switchTo().window(Newly_Opened); 
			}
		
	    driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
	    Thread.sleep(2500);
	   
	

	
	driver.navigate().to("http://stage.amilfreight.com/Accounts/payment/purchaseorder");
	Thread.sleep(2500);
	
	String Shipment_ID="AFS19120300008";
	
	driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[1]/div/div/div/input")).sendKeys(Shipment_ID);
		
	driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[1]/div/div/div/i[3]")).click();
	
	Thread.sleep(3500);

	WebElement PO_Amount=driver.findElement(By.xpath("//*[contains(text(), 'PO-"+Shipment_ID+"')]//parent::div//parent::div/div[5]"));
	
	WebElement PO_Discount=driver.findElement(By.xpath("//*[contains(text(), 'PO-"+Shipment_ID+"')]//parent::div//parent::div/div[6]"));
	
	WebElement PO_Initiated=driver.findElement(By.xpath("//*[contains(text(), 'PO-"+Shipment_ID+"')]//parent::div//parent::div/div[7]"));
	
	WebElement PO_PaidAmnt=driver.findElement(By.xpath("//*[contains(text(), 'PO-"+Shipment_ID+"')]//parent::div//parent::div/div[8]"));
	
	WebElement PO_RemainAmnt=driver.findElement(By.xpath("//*[contains(text(), 'PO-"+Shipment_ID+"')]//parent::div//parent::div/div[9]"));
	
	System.out.println(PO_Amount.getText());
	System.out.println(PO_Discount.getText());
	System.out.println(PO_Initiated.getText());
	System.out.println(PO_PaidAmnt.getText());
	System.out.println(PO_RemainAmnt.getText());
	
	driver.findElement(By.xpath("//*[contains(text(), 'PO-"+Shipment_ID+"')]")).click();	
	Utils.Instance_NewWindow(driver);
	System.out.println(driver.getCurrentUrl());
	Thread.sleep(15000);
	
	//Basic Info
	//WebElement ShipmentID=driver.findElement(By.xpath(""));
	
	WebElement ShipmentID=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[3]/div/div[2]/div/div[1]/div[1]/div[1]/div[1]/a"));
	WebElement PaymentDue=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[3]/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/span"));
	WebElement Carrier_Account=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[3]/div/div[2]/div/div[1]/div[1]/div[1]/div[3]/a"));
	WebElement ShipperAccounts=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[3]/div/div[2]/div/div[1]/div[1]/div[1]/div[4]/a"));
		
	System.out.println(ShipmentID.getText());
	System.out.println(PaymentDue.getText());
	System.out.println(Carrier_Account.getText());
	System.out.println(ShipperAccounts.getText());	
			
	WebElement PO_No=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[1]/span"));
	WebElement PO_Amnt=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[2]/span"));
	WebElement Dis_Amnt=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[3]/span"));
	WebElement Default_Dis=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[4]/span"));
	WebElement Initiate_Amt=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[6]/span"));
	WebElement Paid_Amt=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[7]/span"));
	WebElement Rem_Amnt=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[1]/div[8]/span"));
	WebElement Due_Date=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[4]/div/div[2]/div/div[1]/div[2]/div[1]/span[1]"));
	
	System.out.println(PO_No.getText());
	System.out.println(PO_Amnt.getText());
	System.out.println(Dis_Amnt.getText());
	System.out.println(Default_Dis.getText());	
	System.out.println(Initiate_Amt.getText());
	System.out.println(Paid_Amt.getText());
	System.out.println(Rem_Amnt.getText());
	System.out.println(Due_Date.getText());
		
	WebElement Paymnt_Mode=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[5]/div[2]/div/div/div[1]/div[1]/span"));
	WebElement Paymnt_Type=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[5]/div[2]/div/div/div[1]/div[2]/span"));
	WebElement Paymnt_Term =driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[5]/div[2]/div/div/div[1]/div[3]/span"));
	WebElement Acc_Name=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[5]/div[2]/div/div/div[1]/div[4]/span"));
	WebElement Acc_Number=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[5]/div[2]/div/div/div[1]/div[5]/span"));
	WebElement Receiv_Name=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[4]/div[5]/div[2]/div/div/div[2]/div[1]/span"));
	
	System.out.println(Paymnt_Mode.getText());
	System.out.println(Paymnt_Type.getText());
	System.out.println(Paymnt_Term.getText());
	System.out.println(Acc_Name.getText());	
	System.out.println(Acc_Number.getText());	
	System.out.println(Receiv_Name.getText());	
		
		
		
		
		
		
		
	}
	}


