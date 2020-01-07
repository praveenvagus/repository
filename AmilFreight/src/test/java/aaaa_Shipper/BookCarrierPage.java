package aaaa_Shipper;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
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
   		
        }
	}
	
	}

