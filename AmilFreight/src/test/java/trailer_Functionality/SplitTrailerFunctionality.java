package trailer_Functionality;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utility_Files.BaseClass;
import utility_Files.Constant;
import utility_Files.ExcelUtils;
import utility_Files.Log;

public class SplitTrailerFunctionality extends BaseClass{
	
	public SplitTrailerFunctionality(WebDriver driver) {
		super(driver);
		}

	@SuppressWarnings("unused")
	@Test
	public static void Task_Manager(String sTestCaseName) throws Exception
	{
	    driver.navigate().to("http://stage.amilfreight.com/crm/TaskManagement/Tasklist");
	    Thread.sleep(2500);

		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"LoadBoard");
		int rowused = ExcelUtils.getRowUsed();
		System.out.println("Rowused"+rowused);

		for (int i=1;i<=1;i++)
		{
		String TestCasename = sTestCaseName + "_"+i; 	
		int iTestCaseRow = ExcelUtils.getRowContains(TestCasename,Constant.PostLoadShip_Testcase);
	  	Log.startTestCase(TestCasename);
   		iTestCaseRow = ExcelUtils.getRowContains(TestCasename,0);

		String Shipper_Name = ExcelUtils.getCellData(iTestCaseRow, Constant.PostLoadShip_Shipper);
		String PLShip_Trailer = ExcelUtils.getCellData(iTestCaseRow, Constant.PLShip_Trailer);
		}
		
		String TrailerType="Van";
		String TrailerNo="";
		String TrailerVinNo="";
		String trailerValue="";	
		String Amil_Profile="http://stage.amilfreight.com/carrier/profileView/a57fde80-c3f8-411f-b12d-be7929ed255a";//URL of Amil Profile 
		String BookNow="http://stage.amilfreight.com/shipment/book/8f046a7c-bdc0-4470-a336-04b7ba852153";//URL of Open Shipment
		String EDMS="http://stage.amilfreight.com/shipment/details/d45e97a2-852e-4ab8-b1be-2c41cc31858a";//URL of EDMS 
		String CRM_Profile="http://stage.amilfreight.com/crm/carrier/profile/a57fde80-c3f8-411f-b12d-be7929ed255a";//URL of CRM Profile
		String today_testtrailer="Jan2008";//Need To Change
		//Add Trailer in CRM
				trailerValue="";
				TrailerNo="CRM_trailer".concat(today_testtrailer);
				TrailerVinNo="CRM_trailerVin".concat(today_testtrailer);
				driver.navigate().to(CRM_Profile);
				String carrier_CRM_Dashboard = driver.getWindowHandle();

				JavascriptExecutor js = (JavascriptExecutor)driver;	
				js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id='trailerinfodiv']/div[1]")));
				Thread.sleep(1000);
				
				SplitTrailer_Locators.SplitTrailer_TrailerAdd().click();
				Thread.sleep(2000);
				
				ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
				
				driver.switchTo().window(tabs1.get(1));
				
				Select trailerSelect_pp= new Select(SplitTrailer_Locators.SplitTrailer_IN_TrailerType_DD());		
				trailerSelect_pp.selectByVisibleText(TrailerType);
				Thread.sleep(1000);	
				SplitTrailer_Locators.SplitTrailer_IN_TrailerNO().sendKeys(TrailerNo);
				SplitTrailer_Locators.SplitTrailer_IN_TrailerVinNO().sendKeys(TrailerVinNo);
				SplitTrailer_Locators.SplitTrailer_IN_TrailerSubmit().click();
				Thread.sleep(2000);
				
				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

				driver.switchTo().window(tabs2.get(0));
//				System.out.println("Title---"+driver.getTitle());
				List<WebElement> TrailersList_CRM=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				String trailerValue1="";
				for(int i =0; i<TrailersList_CRM.size();i++)
				{

					TrailersList_CRM.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList_CRM.get(i).getText().toLowerCase().concat(",");	

				}	
				
				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				
				Set<String> all = driver.getWindowHandles();
				for(String winHandle :all)
				{
				    if(!winHandle.equals(carrier_CRM_Dashboard))
				    {
				        driver.switchTo().window(winHandle);
					    driver.close();

					 }
				 }
				    
				driver.switchTo().window(carrier_CRM_Dashboard);
				Thread.sleep(1000);		
				driver.navigate().to(Amil_Profile);
				Thread.sleep(2000);
				SplitTrailer_Locators.SplitTrailer_AmilTrailerTab().click();
				List<WebElement> TrailersList=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				trailerValue1="";
				for(int i =0; i<TrailersList.size();i++)
				{
					TrailersList.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList.get(i).getText().toLowerCase().concat(",");	
				}	
				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
					
				
				//*******EDMS
				Thread.sleep(2000);		
				driver.navigate().to(EDMS);
				Thread.sleep(2000);
			
				//Add
				WebElement Add_Trailer_BTN= driver.findElement(By.xpath("//span[@ng-click='ShowAddTrailerToggle()']"));		
				//Edit
				WebElement Edit_Trailer_BTN= driver.findElement(By.xpath("//a[@ng-click='editTrailerName()']"));
				WebElement we_trailerOptionsPP=driver.findElement(By.xpath("//*[@id='ddlCarrierTrailerId']"));
				
				if(Add_Trailer_BTN.isDisplayed()==true)
				{
					we_trailerOptionsPP.click();
				}
				
				if(Edit_Trailer_BTN.isDisplayed()==true)
				{
					Edit_Trailer_BTN.click();
					we_trailerOptionsPP.click();
				}
				Select trailer= new Select(we_trailerOptionsPP);
						
		        List<WebElement> options = trailer.getOptions();  
		        for(WebElement we:options)  
		        {  
		         for (int i=0; i<options.size(); i++){
		             if (we.getText().equalsIgnoreCase(TrailerNo)){
		         			assertTrue(we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
		       		}
		         		else
		         		{
		         			assertTrue(!we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
		         		}
		         }
		        }		
		      
				
				
				//************BOOK NOW SCREEN
		        driver.navigate().to(BookNow);
		        Thread.sleep(2000);
		        SplitTrailer_Locators.BookNow_CarrierName().sendKeys("SHASWANK REDEMPTION");
		        Thread.sleep(1000);
				new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
			    new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		        Thread.sleep(2000);
		        SplitTrailer_Locators.BookNow_Trailer().click();		
				
				WebElement we_trailerOptionsBook=driver.findElement(By.xpath("//*[@id='ddltrailerid']"));
				Select trailerBook= new Select(we_trailerOptionsBook);
					
		        List<WebElement> optionsBook = trailerBook.getOptions();  
		        for(WebElement weBook:optionsBook)  
		        {  
		         for (int i=0; i<optionsBook.size(); i++){   
		             if (weBook.getAttribute("textContent").equalsIgnoreCase(TrailerNo)){
		            	assertTrue(weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));
		             } 
		             else
		             {
		            	assertTrue(!weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));

		             }
		             
		           }
		        } 
		      
		        Thread.sleep(3000);

		        //Add Trailer in Amil
		        trailerValue1="";
		        TrailerNo="Amil_trailer".concat(today_testtrailer);
				TrailerVinNo="Amil_trailerVin".concat(today_testtrailer);	

				//Navigate to Amil
				driver.navigate().to(Amil_Profile);
				Thread.sleep(2000);
				SplitTrailer_Locators.SplitTrailer_AmilTrailerTab().click();
				Thread.sleep(2000);
				SplitTrailer_Locators.SplitTrailer_AmilAddTrailer().click();		
				ArrayList<String> AmilTab = new ArrayList<String> (driver.getWindowHandles());
				driver.switchTo().window(AmilTab.get(1));
				Thread.sleep(2000);
				Select AmiltrailerSelect_pp= new Select(SplitTrailer_Locators.SplitTrailer_AmilTrailerOptions());		
				AmiltrailerSelect_pp.selectByVisibleText(TrailerType);
				Thread.sleep(2000);
				SplitTrailer_Locators.AmilSplitTrailer_IN_TrailerNO().sendKeys(TrailerNo);
				SplitTrailer_Locators.AmilSplitTrailer_IN_TrailerVinNO().sendKeys(TrailerVinNo);
				SplitTrailer_Locators.AmilSplitTrailer_IN_TrailerSubmit().click();
				Thread.sleep(2000);
				
				ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());	
				driver.switchTo().window(tabs3.get(0));	
				
				
				//CRM 
				driver.navigate().to(CRM_Profile);
				Thread.sleep(2000);
//				JavascriptExecutor js = (JavascriptExecutor)driver;	
				js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id='trailerinfodiv']/div[1]")));
				Thread.sleep(2000);
					
				List<WebElement> TrailersList_amil=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				trailerValue1="";
				for(int i =0; i<TrailersList_amil.size();i++)
				{
					TrailersList_amil.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList_amil.get(i).getText().toLowerCase().concat(",");	
				}	

				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				

				 //*******EDMS
				Thread.sleep(2000);		
				driver.navigate().to(EDMS);
				Thread.sleep(2000);

				//Add
				WebElement Add_Trailer_FromAmil= driver.findElement(By.xpath("//span[@ng-click='ShowAddTrailerToggle()']"));		
				//Edit
				WebElement Edit_Trailer_FromAmil= driver.findElement(By.xpath("//a[@ng-click='editTrailerName()']"));		
				WebElement we_trailerOptionsPP_FA=driver.findElement(By.xpath("//*[@id='ddlCarrierTrailerId']"));				
				if(Add_Trailer_FromAmil.isDisplayed()==true)
				{
					we_trailerOptionsPP_FA.click();					
				}	
				if(Edit_Trailer_FromAmil.isDisplayed()==true)
				{
					Edit_Trailer_BTN.click();
					we_trailerOptionsPP_FA.click();
				}
				Select trailer_FA= new Select(we_trailerOptionsPP_FA);
				List<WebElement> options_FA = trailer_FA.getOptions();  
				for(WebElement we:options_FA)  
				{  
					for (int i=0; i<options_FA.size(); i++){
		            if (we.getText().equalsIgnoreCase(TrailerNo)){
		            	assertTrue(we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));        	
		            } 
		            else
		            {
		            	assertTrue(!we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
		            } 
		          }
		       }
			
			   //******************** BOOK NOW SCREEN
		       driver.navigate().to(BookNow);
		       Thread.sleep(2000);
		       SplitTrailer_Locators.BookNow_CarrierName().sendKeys("SHASWANK REDEMPTION");
		       Thread.sleep(2000);
				new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
			    new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		       Thread.sleep(2000);
		       SplitTrailer_Locators.BookNow_Trailer().click();		
				
		       WebElement we_trailerOptionsBook_FA=driver.findElement(By.xpath("//*[@id='ddltrailerid']"));
		       Select trailerBook_FA= new Select(we_trailerOptionsBook_FA);
			   List<WebElement> optionsBook_FA = trailerBook_FA.getOptions();  
		       for(WebElement weBook:optionsBook_FA)  
		       {  
		        for (int i=0; i<optionsBook_FA.size(); i++){
		       	     if (weBook.getAttribute("textContent").equalsIgnoreCase(TrailerNo)){
		       	    	assertTrue(weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));
		           } 
		       	     else
		       	     {
		       	    	assertTrue(!weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));
		       	     }
		          }
		       } 
			   Thread.sleep(3000);


			   //Add Trailer in EDM
				TrailerNo="EDMS_trailer".concat(today_testtrailer);
				TrailerVinNo="EDMS_trailerVin".concat(today_testtrailer);
				trailerValue1="";

				//*******EDMS**************		
				Thread.sleep(1000);		
				driver.navigate().to(EDMS);
				Thread.sleep(2000);
				
				boolean Istraileradd=SplitTrailer_Locators.AddTrailer_EDMS().isDisplayed();
				boolean IstrailerEdit= SplitTrailer_Locators.EditTrailer_EDMS().isDisplayed();			
				if(Istraileradd==true)
				{
					SplitTrailer_Locators.AddTrailer_EDMS().click();
					
				}
				
				if(IstrailerEdit==true)
				{
					
					SplitTrailer_Locators.EditTrailer_EDMS().click();
					SplitTrailer_Locators.AddTrailer_EDMS().click();
				}
				
				ArrayList<String> EDMSTab = new ArrayList<String> (driver.getWindowHandles());		
				driver.switchTo().window(EDMSTab.get(1));		
				Thread.sleep(3000);
				Select EDMStrailerSelect_pp= new Select(SplitTrailer_Locators.SplitTrailer_EDMSTrailerOptions());		
				EDMStrailerSelect_pp.selectByVisibleText(TrailerType);
				Thread.sleep(3000);	
				SplitTrailer_Locators.EDMSSplitTrailer_IN_TrailerNO().sendKeys(TrailerNo);
				SplitTrailer_Locators.EDMSSplitTrailer_IN_TrailerVinNO().sendKeys(TrailerVinNo);
				SplitTrailer_Locators.EDMSSplitTrailer_IN_TrailerSubmit().click();
				Thread.sleep(2000);
				driver.switchTo().window(EDMSTab.get(0));
				
				//Amil
				driver.navigate().to(Amil_Profile);
				Thread.sleep(2000);
				SplitTrailer_Locators.SplitTrailer_AmilTrailerTab().click();
				List<WebElement> TrailersList_FEDMS=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				trailerValue1="";		
				for(int i =0; i<TrailersList_FEDMS.size();i++)
				{
					TrailersList_FEDMS.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList_FEDMS.get(i).getText().toLowerCase().concat(",");	

				}	
				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));	
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}

				//CRM		
				driver.navigate().to(CRM_Profile);
				Thread.sleep(2000);

				js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id='trailerinfodiv']/div[1]")));
				Thread.sleep(2000);					
				List<WebElement> TrailersList_CRM_FEDMS=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				trailerValue1="";
				for(int i =0; i<TrailersList_CRM_FEDMS.size();i++)
				{
					TrailersList_CRM_FEDMS.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList_CRM_FEDMS.get(i).getText().toLowerCase().concat(",");	
				}	
				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
					
				
				//******************** BOOK NOW SCREEN
			    driver.navigate().to(BookNow);
			    Thread.sleep(2000);
			    SplitTrailer_Locators.BookNow_CarrierName().sendKeys("SHASWANK REDEMPTION");
			    Thread.sleep(2000);
			    new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
				new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
			    Thread.sleep(2000);
			    SplitTrailer_Locators.BookNow_Trailer().click();		
					
				WebElement we_trailerOptionsBook_FEDMS=driver.findElement(By.xpath("//*[@id='ddltrailerid']"));
				Select trailerBook_FEDMS= new Select(we_trailerOptionsBook_FEDMS);
				List<WebElement> optionsBook_FDMS = trailerBook_FEDMS.getOptions();  	
			    for(WebElement weBook:optionsBook_FDMS)  
			    {  
			       for (int i=0; i<optionsBook_FDMS.size(); i++){	       	      
			          if (weBook.getAttribute("textContent").equalsIgnoreCase(TrailerNo)){	            	
			            	assertTrue(weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));
			            } 
			            else
			            {
			            	assertTrue(!weBook.getAttribute("textContent").toLowerCase().contains(TrailerNo.toLowerCase()));
			            }
			       }
			    }

			  //Add Trailer in Book Now
			    trailerValue1="";
				TrailerNo="Bk_trailer".concat(today_testtrailer);
				TrailerVinNo="Bk_trailerVin".concat(today_testtrailer);
				
				//******************** BOOK NOW SCREEN
		       driver.navigate().to(BookNow);
		       Thread.sleep(3000);
		       SplitTrailer_Locators.BookNow_CarrierName().sendKeys("SHASWANK REDEMPTION");
		       Thread.sleep(2000);
		       new Actions(driver).sendKeys(org.openqa.selenium.Keys.DOWN).perform();
			   new Actions(driver).sendKeys(org.openqa.selenium.Keys.ENTER).perform();
		       Thread.sleep(2000);
		       SplitTrailer_Locators.BookNowSplitTrailer_AddTrailer().click();
		       Thread.sleep(2000);
		       ArrayList<String> BOOKTab = new ArrayList<String> (driver.getWindowHandles());	   
			   driver.switchTo().window(BOOKTab.get(1));		
			   Thread.sleep(2000);
			   Select EDMStrailerSelect_pp_FBK= new Select(SplitTrailer_Locators.SplitTrailer_EDMSTrailerOptions());		
			   EDMStrailerSelect_pp_FBK.selectByVisibleText(TrailerType);
				Thread.sleep(2000);
				SplitTrailer_Locators.BookNowSplitTrailer_IN_TrailerNO().sendKeys(TrailerNo);
				SplitTrailer_Locators.BookNowSplitTrailer_IN_TrailerVinNO().sendKeys(TrailerVinNo);
				SplitTrailer_Locators.BookNowSplitTrailer_IN_TrailerSubmit().click();
				Thread.sleep(2000);
				driver.switchTo().window(BOOKTab.get(0));
					
				//*******EDMS
				Thread.sleep(2000);		
				driver.navigate().to(EDMS);
				Thread.sleep(2000);
					
				WebElement Add_Trailer_FBK= driver.findElement(By.xpath("//span[@ng-click='ShowAddTrailerToggle()']"));
				//Edit
				WebElement Edit_Trailer_FBK= driver.findElement(By.xpath("//a[@ng-click='editTrailerName()']"));
						
				WebElement we_trailerOptionsPP_FBK=driver.findElement(By.xpath("//*[@id='ddlCarrierTrailerId']"));
							
				if(Add_Trailer_FBK.isDisplayed()==true)
				{
					we_trailerOptionsPP_FBK.click();
				}
							
				if(Edit_Trailer_FBK.isDisplayed()==true)
				{
					Edit_Trailer_FBK.click();
					we_trailerOptionsPP_FBK.click();
				}
				Select trailer_FBK= new Select(we_trailerOptionsPP_FBK);
				List<WebElement> options_FBK = trailer_FBK.getOptions();  
			    for(WebElement we:options_FBK)  
			    {  
			        for (int i=0; i<options.size(); i++){
			            if (we.getText().equalsIgnoreCase(TrailerNo)){
			           	 
			            	assertTrue(we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
			            } 
			            else
			            {
			            	assertTrue(!we.getText().toLowerCase().contains(TrailerNo.toLowerCase()));
			            }
			            
			          }
			       }
					
			    driver.navigate().to(Amil_Profile);
				Thread.sleep(2000);
				SplitTrailer_Locators.SplitTrailer_AmilTrailerTab().click();
				List<WebElement> TrailersList_FBK=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				trailerValue1="";
				for(int i =0; i<TrailersList_FBK.size();i++)
				{
					TrailersList.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList_FBK.get(i).getText().toLowerCase().concat(",");	
				}		
				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
			
				//CRM
				driver.navigate().to(CRM_Profile);
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id='trailerinfodiv']/div[1]")));
				Thread.sleep(2000);
								
				List<WebElement> TrailersList_CRM_FBK=driver.findElements(By.xpath("//*[@id='trailermaster']/table/tbody/tr/td/div/div[2]/div/table/tbody/tr/td[1]"));
				trailerValue1="";
				for(int i =0; i<TrailersList_CRM_FBK.size();i++)
				{
					TrailersList_CRM_FBK.get(i).getText().toLowerCase();
					trailerValue1+=TrailersList_CRM_FBK.get(i).getText().toLowerCase().concat(",");	
				}			
				if(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()))
				{
					assertTrue(trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
				else
				{
					assertTrue(!trailerValue1.toLowerCase().contains(TrailerNo.toLowerCase()));
				}
		
		
		}
}
