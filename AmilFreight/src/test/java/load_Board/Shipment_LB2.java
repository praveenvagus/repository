package load_Board;

import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

public class Shipment_LB2 extends BaseClass {

	public Shipment_LB2(WebDriver driver) {
		super(driver);
		}

	@Test
	public static void PostLoad_ShipmentGUID(String sTestCaseName) throws Exception
	{
		Thread.sleep(7500);
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

		
		driver.get("http://stage.amilfreight.com/");
		driver.manage().window().maximize();	
		driver.findElement(By.xpath("//*[@id='main-nav']/div/div[2]/div[3]/div/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("txtusername")).sendKeys("katrina");
		driver.findElement(By.id("txtpassword")).sendKeys("Admin@123");
		driver.findElement(By.id("btnSignIn")).click();	
		Thread.sleep(10000);	
		
		String ShipmentId="AFS20010200003";
		driver.findElement(By.xpath("//*[@id='searchshipmentid']")).clear();
		driver.findElement(By.xpath("//*[@id='searchshipmentid']")).sendKeys(ShipmentId);
		driver.findElement(By.xpath("//*[@id='applyAdvSearch']")).click();
		Thread.sleep(7000);
		String ExactMatching_Category=driver.findElement(By.xpath("//*[@id='tabMatched']/a[2]/span/label")).getAttribute("innerText");
		//System.out.println(ExactMatching_Category);
		if(ExactMatching_Category.equalsIgnoreCase("Exact Matching"))
		{
			String ShipmentID_LB=driver.findElement(By.xpath("//*[@id='shipRpt ship']/div[1]/div[1]/span[1]")).getText();
			//System.out.println(ShipmentID_LB);
			assertTrue(ShipmentID_LB.equalsIgnoreCase(ShipmentId));		
		}
			
		driver.findElement(By.xpath("//*[@id='tabOther']/a[2]/span/label")).click();
		//searchAction(ShipmentId);	
		List<WebElement> we=	driver.findElements(By.xpath("//*[@id='shiplistpaging']/div[@ng-repeat='shipment in ShipmentDashboardCollection']"));
		System.out.println(we.size());
		String OtherLoad_Category=driver.findElement(By.xpath("//*[@id='tabOther']/a[2]/span/label")).getAttribute("innerText");
		if(OtherLoad_Category.equalsIgnoreCase("Other Loads"))
		{
			assertTrue(we.size()==0);
		}
		}
		
		

	}
	}


