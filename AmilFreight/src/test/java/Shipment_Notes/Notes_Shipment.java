package Shipment_Notes;

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
import utility_Files.Utils;

public class Notes_Shipment extends BaseClass {

	public Notes_Shipment(WebDriver driver) {
		super(driver);
	}

	@Test
	public static void Notes_Verification(String sTestCaseName) throws Exception
	{
		
		DOMConfigurator.configure("log4j.xml");						
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Notes_Ship");						
		int rowused = ExcelUtils.getRowUsed();						
								
		for (int i=1;i<=rowused;i++)						
		{						
		String TestCasename = sTestCaseName + "_"+i; 						
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.Notes_TestCaseName);						
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);
   		
   		String ShipMentID=ExcelUtils.getCellData(iTestCaseRow, Constant.Notes_ShipMentID);
   		String AllMail_Shipment_GUID=ExcelUtils.getCellData(iTestCaseRow, Constant.Notes_Shipment_GUID);	
   		String Binoc_Text="Abid Ali and then with Asad Shafiq, these partnerships looked promising but Sri Lanka struck";
   		String EDMS_Text="Rahul pats it behind square on the off-side and waits for it to be wide of the backward point fielder";
   	
   		//driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
		Thread.sleep(4500);
		
		driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::div/a/img")).click();
   		Thread.sleep(3300);
   		
   		driver.switchTo().frame("overview");
   		
		Thread.sleep(1500);    
		driver.findElement(By.xpath("//*[@ng-click='getcomments(SchedulingContact.Id,1)']")).click();
		Thread.sleep(1500); 
		
		driver.findElement(By.xpath("//*[@id='Notes']/div/div[2]/span[2]/button")).click();
		
		Thread.sleep(1500);
		Utils.Instance_NewWindow(driver);
		//System.out.println(driver.getCurrentUrl());
   		driver.findElement(By.xpath("//*[@id='Child']/li[4]/label")).click();
   		driver.findElement(By.xpath("//*[@ng-click='NotesTypeSave()']")).click();
   		driver.findElement(By.xpath("//*[@ng-validate='req,Description']")).sendKeys(Binoc_Text);
   		driver.findElement(By.xpath("//*[@ng-click='SaveComments()']")).click();
   		Thread.sleep(2500); 
   		
   		//Validation_1   		
   		Utils.Instance_NewWindow(driver);
   		driver.switchTo().frame("overview");
   		List<WebElement> Dash_Notes = driver.findElements(By.xpath("//*[@class='note-cmnts ng-binding']"));
   		boolean Dash_Found=false;
   		for(WebElement e : Dash_Notes) {
   		System.out.println(e.getText());
   		if(Binoc_Text.equals(e.getText()))
   	    {
   		Dash_Found=true;
   	    break;
   	    }
   		}
   		if(Dash_Found)
   		System.out.println("BIN in BIN Added Binoc_Text comments exists");
   		else
   		System.out.println("BIN in BIN Added Binoc_Text comments does not exists");
   		
   		driver.findElement(By.xpath("//*[@ng-click='close();']")).click();
   		Thread.sleep(1800);
   		
   		driver.switchTo().parentFrame();
   		
		driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]")).click();
   	    //driver.navigate().to("http://stage.amilfreight.com/shipment/details/"+AllMail_Shipment_GUID);
   		Thread.sleep(3300);
   		Utils.Instance_NewWindow(driver);
   		Thread.sleep(3800);
   		
   		//Validation--2
   		String Expect_URL=driver.getCurrentUrl();
   		String Actual_URL="http://stage.amilfreight.com/shipment/details/"+AllMail_Shipment_GUID;
   		Assert.assertEquals(Actual_URL, Expect_URL, "Shipment EDMS Page doesn't matching");
   		
   		driver.findElement(By.xpath("//*[@ng-click='showNotes(shipment)']")).click();
   		Thread.sleep(1800);
   		
   		List<WebElement> EDMS_Notes = driver.findElements(By.xpath("//*[@class='notescmnt-ul']/li/div[3]/span[3]"));
   		boolean EDMS_Found=false;
   		for(WebElement e : EDMS_Notes) {
   		System.out.println(e.getText());
   		if(Binoc_Text.equals(e.getText()))
   	    {
   			EDMS_Found=true;
   	        break;
   	    }
   		}
   		if(EDMS_Found)
   		System.out.println("BIN in EDMS Added EDMS_Text comments exists");
   		else
   		System.out.println("BIN in EDMS Added EDMS_Text comments does not exists"); 
   		
   		
   		driver.findElement(By.xpath("//*[@title='Add New Notes']")).click();
		
		Thread.sleep(1500);
		//System.out.println(driver.getCurrentUrl());
  
   		driver.findElement(By.xpath("//*[@id='Child']/li[4]/label")).click();
   		
   		driver.findElement(By.xpath("//*[@ng-click='NotesTypeSave()']")).click();
   		
   		driver.findElement(By.xpath("//*[@ng-validate='req,Description']")).sendKeys(EDMS_Text);
   		
   		driver.findElement(By.xpath("//*[@ng-click='SaveComments()']")).click();
   		Thread.sleep(2500); 
   		
   		//Validation--3
   		List<WebElement> EDMS2_Notes = driver.findElements(By.xpath("//*[@class='note-cmnts ng-binding']"));
   		boolean EDMS2_Found=false;
   		for(WebElement e : EDMS2_Notes) {
   		System.out.println(e.getText());
   		if(Binoc_Text.equals(e.getText()))
   	    {
   			EDMS2_Found=true;
   	        break;
   	    }
   		}
   		if(EDMS2_Found)
   		System.out.println("EDMS in EDMS Added EDMS_Text comments exists");
   		else
   		System.out.println("EDMS in EDMS Added EDMS_Text comments does not exists");
   	
   		
   		driver.close();
   		Thread.sleep(1500);
   		Utils.Instance_NewWindow(driver);
   		driver.navigate().refresh();
   		Thread.sleep(3000);	
	
   	WebElement Filter_Result=driver.findElement(By.xpath("//*[contains(text(),'"+ShipMentID+"')]//parent::div/a/img"));
	JavascriptExecutor ex=(JavascriptExecutor)driver;
	ex.executeScript("arguments[0].click()", Filter_Result);
	
   		Thread.sleep(3300);
   		driver.switchTo().frame("overview");
   		
		Thread.sleep(1500);    
		driver.findElement(By.xpath("//*[@ng-click='getcomments(SchedulingContact.Id,1)']")).click();
		Thread.sleep(4500); 
		
		//Validation--4
   		List<WebElement> Dash2_Notes = driver.findElements(By.xpath("//*[@class='note-cmnts ng-binding']"));
   		boolean Dash2_Found=false;
   		for(WebElement e : Dash2_Notes) {
   		System.out.println(e.getText());
   		if(Binoc_Text.equals(e.getText()))
   	    {
   			Dash2_Found=true;
   	        break;
   	    }
   		}
   		if(Dash2_Found)
   		System.out.println("EDMS in BIN Added Binoc_Text comments exists");
   		else
   		System.out.println("EDMS in BIN Added Binoc_Text comments does not exists");
   		}
   		driver.switchTo().parentFrame();
   		driver.close();
   	
	}
	
	}

