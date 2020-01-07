package aaui_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility_Files.BaseClass;

public class SideMenu_Navigations extends BaseClass {

	public SideMenu_Navigations(WebDriver driver) {
		super(driver);
	}
	@Test
	//-------------------Shipper Account--------------------------------------
	public static void MenuBar_Navigation() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[1]")).click();
		Thread.sleep(5000);
		//----------------URL--------------------------
		String ShAcActual_URL=driver.getCurrentUrl();
		String ShAcExpect_URL="http://stage.amilfreight.com/shipper/list";
		System.out.println("Shipper_Account Act URL : "+ShAcActual_URL);
		System.out.println("Shipper_Account Exp URL : "+ShAcExpect_URL);
		softAssert.assertEquals(ShAcExpect_URL,ShAcActual_URL,"Shipper_Account URL is Different ");
		//---------------Title-------------------------
		String ShAcActual_Title=driver.getTitle();
		String ShAcExpect_Title="Shipper Lists | Amil Freight";
		System.out.println("Shipper_Account Act Title: "+ShAcActual_Title);
		System.out.println("Shipper_Account Exp Title: "+ShAcExpect_Title);
		softAssert.assertEquals(ShAcExpect_Title,ShAcActual_Title,"Shipper_Account Title is Different ");
		//----------------UI----------------------------
		String ShAcActual_UI=driver.findElement(By.xpath("//*[@id='lstsection']/div[1]/div/div[1]/div/h4/span")).getText();
		String ShAcExpect_UI="SHIPPER LISTS";
		System.out.println("Shipper_Account Act UI: "+ShAcActual_UI);
		System.out.println("Shipper_Account Exp UI: "+ShAcExpect_UI);
		softAssert.assertEquals(ShAcExpect_UI,ShAcActual_UI,"Shipper_Account UI is Different ");
		softAssert.assertAll();
/*	}
	//-------------------------Carrier Account---------------------
	@Test(priority=1)
	public void Carrier_Account() throws InterruptedException 
	{*/
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String CaAcActual_URL=driver.getCurrentUrl();
		String CaAcExpect_URL="http://stage.amilfreight.com/carrier/list";
		System.out.println("Carrier_Account Act URL : "+CaAcActual_URL);
		System.out.println("Carrier_Account Exp URL: "+CaAcExpect_URL);
		softAssert.assertEquals(CaAcExpect_URL,CaAcActual_URL,"Carrier_Account URL is Different ");
		//--------------------Title----------------------------
		String CaAcActual_Title=driver.getTitle();
		String CaAcExpect_Title="Carrier List | Amil Freight";
		System.out.println("Carrier_Account Act Title: "+CaAcActual_Title);
		System.out.println("Carrier_Account Exp Title: "+CaAcExpect_Title);
		softAssert.assertEquals(CaAcExpect_Title,CaAcActual_Title,"Carrier_Account Title is Different ");
		//-------------------UI-------------------------------
		String CaAcActual_UI=driver.findElement(By.xpath("//*[@id='lstsection']/div[1]/div/div/div/h4/span")).getText();
		String CaAcExpect_UI="CARRIER LISTS";
		System.out.println("Carrier_Account Act UI: "+CaAcActual_UI);
		System.out.println("Carrier_Account Exp UI: "+CaAcExpect_UI);
		softAssert.assertEquals(CaAcExpect_UI,CaAcActual_UI,"Carrier_Account UI is Different ");
		softAssert.assertAll();
	/*}
	//-----------------------Shipment DashBoard---------------------
	@Test(priority=3)
	public void ShipmentDashBoard() throws InterruptedException 
	{*/
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[3]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String ShDaActual_URL=driver.getCurrentUrl();
		String ShDaExpect_URL="http://stage.amilfreight.com/shipment/dashboard";
		System.out.println("ShipmentDashBoard Act URL : "+ShDaActual_URL);
		System.out.println("ShipmentDashBoard Exp URL: "+ShDaExpect_URL);
		softAssert.assertEquals(ShDaExpect_URL,ShDaActual_URL,"ShipmentDashBoard URL is Different ");
		//--------------------Title----------------------------
		String ShDaActual_Title=driver.getTitle();
		String ShDaExpect_Title="Shipment Dashboard | Amil Freight";
		System.out.println("Shipment_DashBoard Act Title: "+ShDaActual_Title);
		System.out.println("Shipment_DashBoard Exp Title: "+ShDaExpect_Title);
		softAssert.assertEquals(ShDaExpect_Title,ShDaActual_Title,"ShipmentDashBoard Title is Different ");
		//-------------------UI-------------------------------
		String ShDaActual_UI=driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[1]/div[1]/label")).getText();
		String ShDaExpect_UI="SHIPMENT DASHBOARD";
		System.out.println("ShipmentDashBoard Act UI: "+ShDaActual_UI);
		System.out.println("ShipmentDashBoard Exp UI: "+ShDaExpect_UI);
		softAssert.assertEquals(ShDaExpect_UI,ShDaActual_UI,"ShipmentDashBoard UI is Different ");
		softAssert.assertAll();
/*	}
	//-----------------------MAP---------------------
	@Test(priority=4)
	public void Map() throws InterruptedException 
	{*/
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[4]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String MapActual_URL=driver.getCurrentUrl();
		String MapExpect_URL="http://stage.amilfreight.com/mapview";
		System.out.println("Map Act URL:"+MapActual_URL);
		System.out.println("Map Exp URL:"+MapExpect_URL);
		softAssert.assertEquals(MapExpect_URL,MapActual_URL,"Map URL is Different ");
		//--------------------Title----------------------------
		String MapActual_Title=driver.getTitle();
		String MapExpect_Title="Maps | Amil Freight";
		System.out.println("Map Act Title: "+MapActual_Title);
		System.out.println("Map Exp Title: "+MapExpect_Title);
		softAssert.assertEquals(MapExpect_Title,MapActual_Title,"Map Title is Different ");
		//-------------------UI-------------------------------
		String MapActual_UI=driver.findElement(By.xpath("//*[@id='divMapArea']/a")).getText();
		String MapExpect_UI="Click to view the route map with all stops";
		System.out.println("Map Act UI: "+MapActual_UI);
		System.out.println("Map Exp UI: "+MapExpect_UI);
		softAssert.assertEquals(MapExpect_UI,MapActual_UI,"Map UI is Different ");
		softAssert.assertAll();
/*	}
	@Test(priority=5)
	//-------------------------Email Campaign--------------------
	public void Email_Campaign() throws InterruptedException
	{*/
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[5]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String EmCaActual_URL=driver.getCurrentUrl();
		String EmCaExpect_URL="http://stage.amilfreight.com/email/campaign";
		System.out.println("Email_Campaign Act URL:"+EmCaActual_URL);
		System.out.println("Email_Campaign Exp URL:"+EmCaExpect_URL);
		softAssert.assertEquals(EmCaExpect_URL,EmCaActual_URL,"Email_Campaign URL is Different ");
		//--------------------Title----------------------------
		String EmCaActual_Title=driver.getTitle();
		String EmCaExpect_Title="Email Campaign | Amil Freight";
		System.out.println("Email_Campaign Act Title: "+EmCaActual_Title);
		System.out.println("Email_Campaign Exp Title: "+EmCaExpect_Title);
		softAssert.assertEquals(EmCaExpect_Title,EmCaActual_Title,"Email_Campaign Title is Different ");
		//-------------------UI-------------------------------
		String EmCaActual_UI=driver.findElement(By.xpath("//*[@id='lstsection']/div[1]/div/div[1]/div/h4/span")).getText();
		String EmCaExpect_UI="CAMPAIGNS";
		System.out.println("Email_Campaign Act UI: "+EmCaActual_UI);
		System.out.println("Email_Campaign Exp UI: "+EmCaExpect_UI);
		softAssert.assertEquals(EmCaExpect_UI,EmCaActual_UI,"Email_Campaign UI is Different ");
		softAssert.assertAll();
	/*}
	@Test(priority=6)
	//--------------------------UNSUBSCRIBE EMAILS------------------------------------
	public void unsubscribe_Email() throws InterruptedException 
	{*/
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"mn-menu-container\"]/div/ul/li[6]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String UsubActual_URL=driver.getCurrentUrl();
		String UsubExpect_URL="http://stage.amilfreight.com/unsubscribeemails";
		System.out.println("unsubscribe_Email Act URL:"+UsubActual_URL);
		System.out.println("unsubscribe_Email Exp URL:"+UsubExpect_URL);
		softAssert.assertEquals(UsubExpect_URL,UsubActual_URL,"unsubscribe_Email URL is Different ");
		//--------------------Title----------------------------
		String UsubActual_Title=driver.getTitle();
		String UsubExpect_Title="Unsubscribed Emails | Amil Freight";
		System.out.println("unsubscribe_Email Act Title: "+UsubActual_Title);
		System.out.println("unsubscribe_Email Exp Title: "+UsubExpect_Title);
		softAssert.assertEquals(UsubExpect_Title,UsubActual_Title,"unsubscribe_Email Title is Different ");
		//-------------------UI-------------------------------
		String UsubActual_UI=driver.findElement(By.xpath("//*[@id='lstEmail']/div[1]/div/div/h4/span")).getText();
		String UsubExpect_UI="UNSUBSCRIBE EMAILS";
		System.out.println("unsubscribe_Email Act UI: "+UsubActual_UI);
		System.out.println("unsubscribe_Email Exp UI: "+UsubExpect_UI);
		softAssert.assertEquals(UsubExpect_UI,UsubActual_UI,"unsubscribe_Email UI is Different ");
		softAssert.assertAll();
	/*}
	@Test(priority=7)
	//--------------------------Site_Admin------------------------------------
	public void Site_Admin() throws InterruptedException 
	{*/
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[7]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String SiAdActual_URL=driver.getCurrentUrl();
		String SiAdExpect_URL="http://stage.amilfreight.com/config/adminlist";
		System.out.println("Site_Admin Act URL:"+SiAdActual_URL);
		System.out.println("Site_Admin Exp URL:"+SiAdExpect_URL);
		softAssert.assertEquals(SiAdExpect_URL,SiAdActual_URL,"Site_Admin URL is Different ");
		//--------------------Title----------------------------
		String SiAdActual_Title=driver.getTitle();
		String SiAdExpect_Title="Site Admin | Amil Freight";
		System.out.println("Site_Admin Act Title: "+SiAdActual_Title);
		System.out.println("Site_Admin Exp Title: "+SiAdExpect_Title);
		softAssert.assertEquals(SiAdExpect_Title,SiAdActual_Title,"Site_Admin Title is Different ");
		//-------------------UI-------------------------------
		String SiAdActual_UI=driver.findElement(By.xpath("//*[@id='rptmastervw']/div/div[1]/div[1]/div/div")).getText();
		String SiAdExpect_UI="ADMIN SETTINGS";
		System.out.println("Site_Admin Act UI: "+SiAdActual_UI);
		System.out.println("Site_Admin Exp UI: "+SiAdExpect_UI);
		softAssert.assertEquals(SiAdExpect_UI,SiAdActual_UI,"Site_Admin UI is Different ");
		softAssert.assertAll();
	/*}
	@Test(priority=8)
	//--------------------------CRM------------------------------------
	public void CRM() throws InterruptedException 
	{*/	
		String CRMwinHandleBefore = driver.getWindowHandle();
		//SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[8]")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String CRMActual_URL=driver.getCurrentUrl();
		String CRMExpect_URL="http://stage.amilfreight.com/crm";
		System.out.println("CRM Act URL:"+CRMActual_URL);
		System.out.println("CRM Exp URL:"+CRMExpect_URL);
		softAssert.assertEquals(CRMExpect_URL,CRMActual_URL,"CRM URL is Different ");
		//--------------------Title----------------------------
		String CRMActual_Title=driver.getTitle();
		String CRMExpect_Title="Dashboard | Amil Freight";
		System.out.println("CRM Act Title: "+CRMActual_Title);
		System.out.println("CRM Exp Title: "+CRMExpect_Title);
		softAssert.assertEquals(CRMExpect_Title,CRMActual_Title,"CRM Title is Different ");
		//-------------------UI-------------------------------
		String CRMActual_UI=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div/h4/span")).getText();
		String CRMExpect_UI="DASHBOARD";
		System.out.println("CRM Act UI: "+CRMActual_UI);
		System.out.println("CRM Exp UI: "+CRMExpect_UI);
		softAssert.assertEquals(CRMExpect_UI,CRMActual_UI,"CRM UI is Different ");
	//--------------------------Shipper CRM------------------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String Ship_CRM_Actual_URL=driver.getCurrentUrl();
		String Ship_CRM_Expect_URL="http://stage.amilfreight.com/crm/sales/shipper-opt";
		System.out.println("Shipper CRM Act URL:"+Ship_CRM_Actual_URL);
		System.out.println("Shipper CRM Exp URL:"+Ship_CRM_Expect_URL);
		softAssert.assertEquals(Ship_CRM_Expect_URL,Ship_CRM_Actual_URL,"Shipper CRM URL is Different ");
		//--------------------Title----------------------------
		String Ship_CRM_Actual_Title=driver.getTitle();
		String Ship_CRM_Expect_Title="Shipper Sales CRM | Amil Freight";
		System.out.println("Shipper CRM Act Title: "+Ship_CRM_Actual_Title);
		System.out.println("Shipper CRM Exp Title: "+Ship_CRM_Expect_Title);
		softAssert.assertEquals(Ship_CRM_Expect_Title,Ship_CRM_Actual_Title,"Shipper CRM Title is Different ");
		//-------------------UI-------------------------------
		String Ship_CRM_Actual_UI=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div[1]/ul/li/span[1]")).getText();
		String Ship_CRM_Expect_UI="Shipper CRM";
		System.out.println("Shipper CRM Act UI: "+Ship_CRM_Actual_UI);
		System.out.println("Shipper CRM Exp UI: "+Ship_CRM_Expect_UI);
		softAssert.assertEquals(Ship_CRM_Expect_UI,Ship_CRM_Actual_UI,"Shipper CRM UI is Different ");
	//--------------------------Carrier CRM----------------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[3]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String Car_CRM_Actual_URL=driver.getCurrentUrl();
		String Car_CRM_Expect_URL="http://stage.amilfreight.com/crm/sales/carrier-opt-v2";
		System.out.println("Carrier CRM Act URL:"+Car_CRM_Actual_URL);
		System.out.println("Carrier CRM Exp URL:"+Car_CRM_Expect_URL);
		softAssert.assertEquals(Car_CRM_Expect_URL,Car_CRM_Actual_URL,"Carrier CRM URL is Different ");
		//--------------------Title----------------------------
		String Car_CRM_Actual_Title=driver.getTitle();
		String Car_CRM_Expect_Title="Carrier Sales CRM | Amil Freight";
		System.out.println("Carrier CRM Act Title: "+Car_CRM_Actual_Title);
		System.out.println("Carrier CRM Exp Title: "+Car_CRM_Expect_Title);
		softAssert.assertEquals(Car_CRM_Expect_Title,Car_CRM_Actual_Title,"Carrier CRM Title is Different ");
		//-------------------UI-------------------------------
		String Car_CRM_Actual_UI=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div[1]/ul/li/span")).getText();
		String Car_CRM_Expect_UI="Carrier CRM";
		System.out.println("Carrier CRM Act UI: "+Car_CRM_Actual_UI);
		System.out.println("Carrier CRM Exp UI: "+Car_CRM_Expect_UI);
		softAssert.assertEquals(Car_CRM_Expect_UI,Car_CRM_Actual_UI,"Carrier CRM UI is Different ");
	//--------------------------Quick Look---------------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[1]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String Quick_Look_Actual_URL=driver.getCurrentUrl();
		String Quick_Look_Expect_URL="http://stage.amilfreight.com/crm/sales/quick-look";
		System.out.println("Quick Look Act URL:"+Quick_Look_Actual_URL);
		System.out.println("Quick Look Exp URL:"+Quick_Look_Expect_URL);
		softAssert.assertEquals(Quick_Look_Expect_URL,Quick_Look_Actual_URL,"Quick Look URL is Different ");
		//--------------------Title----------------------------
		String Quick_Look_Actual_Title=driver.getTitle();
		String Quick_Look_Expect_Title="QuickSearch | Amil Freight | CRM | Amil Freight";
		System.out.println("Quick Look Act Title: "+Quick_Look_Actual_Title);
		System.out.println("Quick Look Exp Title: "+Quick_Look_Expect_Title);
		softAssert.assertEquals(Quick_Look_Expect_Title,Quick_Look_Actual_Title,"Quick Look Title is Different ");
		//-------------------UI-------------------------------
		String Quick_Look_Actual_UI=driver.findElement(By.xpath("//*[@id='carriersnearby']/a")).getText();
		String Quick_Look_Expect_UI="NEARBY";
		System.out.println("Quick Look Act UI: "+Quick_Look_Actual_UI);
		System.out.println("Quick Look Exp UI: "+Quick_Look_Expect_UI);
		softAssert.assertEquals(Quick_Look_Expect_UI,Quick_Look_Actual_UI,"Quick Look UI is Different ");
	//--------------------------sales DashBoard---------------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[6]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String Sales_Actual_URL=driver.getCurrentUrl();
		String Sales_Expect_URL="http://stage.amilfreight.com/crm/TaskManagement/SalesDashboard";
		System.out.println("Sales DashBoard Act URL:"+Sales_Actual_URL);
		System.out.println("Sales DashBoard Exp URL:"+Sales_Expect_URL);
		softAssert.assertEquals(Sales_Expect_URL,Sales_Actual_URL,"Sales DashBoard URL is Different ");
		//--------------------Title----------------------------
		String Sales_Actual_Title=driver.getTitle();
		String Sales_Expect_Title="Sales Dashboard | Amil Freight";
		System.out.println("Sales DashBoard Act Title: "+Sales_Actual_Title);
		System.out.println("Sales DashBoard Exp Title: "+Sales_Expect_Title);
		softAssert.assertEquals(Sales_Expect_Title,Sales_Actual_Title,"Sales DashBoard Title is Different ");
		//-------------------UI-------------------------------
		String Sales_Actual_UI=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div/div[1]/div/h4/span")).getText();
		String Sales_Expect_UI="SALES DASHBOARD";
		System.out.println("Sales DashBoard Act UI: "+Sales_Actual_UI);
		System.out.println("Sales DashBoard Exp UI: "+Sales_Expect_UI);
		softAssert.assertEquals(Sales_Expect_UI,Sales_Actual_UI,"Sales DashBoard UI is Different ");
	//--------------------------Manager Dash Board----------------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[5]/a")).click();
		Thread.sleep(5000);
		//---------------------URL---------------------------
		String Manager_Actual_URL=driver.getCurrentUrl();
		String Manager_Expect_URL="http://stage.amilfreight.com/crm/TaskManagement/Tasklist";
		System.out.println("Manager DashBoard Act URL:"+Manager_Actual_URL);
		System.out.println("Manager DashBoard Exp URL:"+Manager_Expect_URL);
		softAssert.assertEquals(Manager_Expect_URL,Manager_Actual_URL,"Manager DashBoard URL is Different ");
		//--------------------Title----------------------------
		String Manager_Actual_Title=driver.getTitle();
		String Manager_Expect_Title="Task List| Amil Freight";
		System.out.println("Manager DashBoard Act Title: "+Manager_Actual_Title);
		System.out.println("Manager DashBoard Exp Title: "+Manager_Expect_Title);
		softAssert.assertEquals(Manager_Expect_Title,Manager_Actual_Title,"Manager DashBoard Title is Different ");
		//-------------------UI-------------------------------
		String Manager_Actual_UI=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div/div[1]/div/h4/span[1]")).getText();
		String Manager_Expect_UI="TASK MANAGEMENT";
		System.out.println("Manager DashBoard Act UI: "+Manager_Actual_UI);
		System.out.println("Manager DashBoard Exp UI: "+Manager_Expect_UI);
		softAssert.assertEquals(Manager_Expect_UI,Manager_Actual_UI,"Manager DashBoard UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(CRMwinHandleBefore);
/*	}
	@Test(priority=9)
	//--------------------------Reminder Configuration----------------------------------
	public void ReminderConfiguration() throws InterruptedException 
	{*/
		String RemiwinHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[9]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String RemiActual_URL=driver.getCurrentUrl();
		String RemiExpect_URL="http://stage.amilfreight.com/reminderconfiguration/list";
		System.out.println("Reminder Configuration Act URL:"+RemiActual_URL);
		System.out.println("Reminder Configuration Exp URL:"+RemiExpect_URL);
		softAssert.assertEquals(RemiExpect_URL,RemiActual_URL,"Reminder Configuration  URL is Different ");
		//--------------------Title----------------------------
		String RemiActual_Title=driver.getTitle();
		String RemiExpect_Title="Reminder Configuration | Amil Freight";
		System.out.println("Reminder Configuration Act Title: "+RemiActual_Title);
		System.out.println("Reminder Configuration Exp Title: "+RemiExpect_Title);
		softAssert.assertEquals(RemiExpect_Title,RemiActual_Title,"Reminder Configuration Title is Different ");
		//-------------------UI-------------------------------
		String RemiActual_UI=driver.findElement(By.xpath("//*[@id='body']/div[3]/div/div/div/div[1]/div[1]/div/div[1]/div/h4/span")).getText();
		String RemiExpect_UI="REMINDER CONFIGURATION";
		System.out.println("Reminder Configuration Act UI: "+RemiActual_UI);
		System.out.println("Reminder Configuration Exp UI: "+RemiExpect_UI);
		softAssert.assertEquals(RemiExpect_UI,RemiActual_UI,"Reminder Configuration UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(RemiwinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
/*	}
	@Test(priority=10)
	public void undeliveredMails() throws InterruptedException 
	{*/
		String UDMawinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[10]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String UDMaActual_URL=driver.getCurrentUrl();
		String UDMaExpect_URL="http://stage.amilfreight.com/undeliveredemails";
		System.out.println("Undelivered Mails Act URL:"+UDMaActual_URL);
		System.out.println("Undelivered Mails Exp URL:"+UDMaExpect_URL);
		softAssert.assertEquals(UDMaExpect_URL,UDMaActual_URL,"Undelivered Mails  URL is Different ");
		//--------------------Title----------------------------
		String UDMaActual_Title=driver.getTitle();
		String UDMaExpect_Title="Undelivered Emails | Amil Freight";
		System.out.println("Undelivered Mails Act Title: "+UDMaActual_Title);
		System.out.println("Undelivered Mails Exp Title: "+UDMaExpect_Title);
		softAssert.assertEquals(UDMaExpect_Title,UDMaActual_Title,"Undelivered Mails Title is Different ");
		//-------------------UI-------------------------------
		String UDMaActual_UI=driver.findElement(By.xpath("//*[@id='lstEmail']/div[1]/div/div/h4/span")).getText();
		String UDMaExpect_UI="UNDELIVERED EMAILS";
		System.out.println("Undelivered Mails Act UI: "+UDMaActual_UI);
		System.out.println("Undelivered Mails Exp UI: "+UDMaExpect_UI);
		softAssert.assertEquals(UDMaExpect_UI,UDMaActual_UI,"Undelivered Mails UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(UDMawinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
	/*}
	@Test(priority=11)
	public void Configuration_settings() throws InterruptedException 
	{ */
		String CosewinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[11]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String CoseActual_URL=driver.getCurrentUrl();
		String CoseExpect_URL="http://stage.amilfreight.com/config/Configuration";
		System.out.println("Configuration settings Act URL:"+CoseActual_URL);
		System.out.println("Configuration settings Exp URL:"+CoseExpect_URL);
		softAssert.assertEquals(CoseExpect_URL,CoseActual_URL,"Configuration settings  URL is Different ");
		//--------------------Title----------------------------
		String CoseActual_Title=driver.getTitle();
		String CoseExpect_Title="Configuration | Amil Freight";
		System.out.println("Configuration settings Act Title: "+CoseActual_Title);
		System.out.println("Configuration settings Exp Title: "+CoseExpect_Title);
		softAssert.assertEquals(CoseExpect_Title,CoseActual_Title,"Configuration settings Title is Different ");
		//-------------------UI-------------------------------
		String CoseActual_UI=driver.findElement(By.xpath("//*[@id='rptmastervw']/div/div[1]/div[1]/div/div")).getText();
		String CoseExpect_UI="SETTINGS";
		System.out.println("Configuration settings Act UI: "+CoseActual_UI);
		System.out.println("Configuration settings Exp UI: "+CoseExpect_UI);
		softAssert.assertEquals(CoseExpect_UI,CoseActual_UI,"Configuration settings UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(CosewinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
	/*}
	@Test(priority=12)
	public void Load_Management() throws InterruptedException 
	{*/
		String LomawinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[12]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String LomaActual_URL=driver.getCurrentUrl();
		String LomaExpect_URL="http://stage.amilfreight.com/shipment/dashboard/loadmanagement";
		System.out.println("Load Management Act URL:"+LomaActual_URL);
		System.out.println("Load Management Exp URL:"+LomaExpect_URL);
		softAssert.assertEquals(LomaExpect_URL,LomaActual_URL,"Load Management  URL is Different ");
		//--------------------Title----------------------------
		String LomaActual_Title=driver.getTitle();
		String LomaExpect_Title="Load Management Dashboard | Amil Freight | Amil Freight";
		System.out.println("Load Management Act Title: "+LomaActual_Title);
		System.out.println("Load Management Exp Title: "+LomaExpect_Title);
		softAssert.assertEquals(LomaExpect_Title,LomaActual_Title,"Load Management Title is Different ");
		//-------------------UI-------------------------------
		String LomaActual_UI=driver.findElement(By.xpath("//*[@id='AdminDashList']/div/div[1]/div[1]/label")).getText();
		String LomaExpect_UI="SHIPMENT DASHBOARD";
		System.out.println("Load Management Act UI: "+LomaActual_UI);
		System.out.println("Load Management settings Exp UI: "+LomaExpect_UI);
		softAssert.assertEquals(LomaExpect_UI,LomaActual_UI,"Load Management UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(LomawinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
/*	}
	@Test(priority=13)
	public void  CityState() throws InterruptedException 
	{*/
		String CistwinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[13]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String CistActual_URL=driver.getCurrentUrl();
		String CistExpect_URL="http://stage.amilfreight.com/Config/CityState";
		System.out.println("City/State Act URL:"+CistActual_URL);
		System.out.println("City/State Exp URL:"+CistExpect_URL);
		softAssert.assertEquals(CistExpect_URL,CistActual_URL,"City/State  URL is Different ");
		//--------------------Title----------------------------
		String CistActual_Title=driver.getTitle();
		String CistExpect_Title="Config Details | Amil Freight";
		System.out.println("City/State Act Title: "+CistActual_Title);
		System.out.println("City/State Exp Title: "+CistExpect_Title);
		softAssert.assertEquals(CistExpect_Title,CistActual_Title,"City/State Title is Different ");
		//-------------------UI-------------------------------
		String CistActual_UI=driver.findElement(By.xpath("//*[@id='InsertCountrySateid']/div[2]/div/div[1]/div/h4/span")).getText();
		String CistExpect_UI="CONFIG STATE/CITY";
		System.out.println("City/State Act UI: "+CistActual_UI);
		System.out.println("City/State settings Exp UI: "+CistExpect_UI);
		softAssert.assertEquals(CistExpect_UI,CistActual_UI,"City/State UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(CistwinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
/*	}
	@Test(priority=14)
	public void  Factoring() throws InterruptedException 
	{*/
		String FactwinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[15]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String FactActual_URL=driver.getCurrentUrl();
		String FactExpect_URL="http://stage.amilfreight.com/Master/Factoring";
		System.out.println("Factoring Act URL:"+FactActual_URL);
		System.out.println("Factoring Exp URL:"+FactExpect_URL);
		softAssert.assertEquals(FactExpect_URL,FactActual_URL,"Factoring  URL is Different ");
		//--------------------Title----------------------------
		String FactActual_Title=driver.getTitle();
		String FactExpect_Title="Factoring Company List | Amil Freight";
		System.out.println("Factoring Act Title: "+FactActual_Title);
		System.out.println("Factoring Exp Title: "+FactExpect_Title);
		softAssert.assertEquals(FactExpect_Title,FactActual_Title,"Factoring Title is Different ");
		//-------------------UI-------------------------------
		String FactActual_UI=driver.findElement(By.xpath("//*[@id='lstsection']/div[1]/div/div[1]/div/h4/span")).getText();
		String FactExpect_UI="FACTORING COMPANY LIST";
		System.out.println("Factoring Act UI: "+FactActual_UI);
		System.out.println("Factoring Exp UI: "+FactExpect_UI);
		softAssert.assertEquals(FactExpect_UI,FactActual_UI,"Factoring UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(FactwinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
	/*}
	@Test(priority=15)
	public void  PayRequest() throws InterruptedException 
	{*/
		String PayReqwinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[14]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String PayReqActual_URL=driver.getCurrentUrl();
		String PayReqExpect_URL="http://stage.amilfreight.com/Billing/AdvancePayment";
		System.out.println("Pay Request Act URL:"+PayReqActual_URL);
		System.out.println("Pay Request Exp URL:"+PayReqExpect_URL);
		softAssert.assertEquals(PayReqExpect_URL,PayReqActual_URL,"Pay Request  URL is Different ");
		//--------------------Title----------------------------
		String PayReqActual_Title=driver.getTitle();
		String PayReqExpect_Title="Advance Payment List | Amil Freight";
		System.out.println("Pay Request Act Title: "+PayReqActual_Title);
		System.out.println("Pay Request Exp Title: "+PayReqExpect_Title);
		softAssert.assertEquals(PayReqExpect_Title,PayReqActual_Title,"Pay Request Title is Different ");
		//-------------------UI-------------------------------
		String PayReqActual_UI=driver.findElement(By.xpath("//*[@id='lstsection']/div[1]/div/div/div/h4/span")).getText();
		String PayReqExpect_UI="ADDITIONAL EXPENSE ADVANCE PAYMENT LIST";
		System.out.println("Pay Request Act UI: "+PayReqActual_UI);
		System.out.println("Pay Request Exp UI: "+PayReqExpect_UI);
		softAssert.assertEquals(PayReqExpect_UI,PayReqActual_UI,"Pay Request UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(PayReqwinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
/*	}
	@Test(priority=16)
	public void  Report() throws InterruptedException 
	{*/
		String ReportwinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[16]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String ReportActual_URL=driver.getCurrentUrl();
		String ReportExpect_URL="http://stage.amilfreight.com/delineation/report";
		System.out.println("Report Act URL:"+ReportActual_URL);
		System.out.println("Report Exp URL:"+ReportExpect_URL);
		softAssert.assertEquals(ReportExpect_URL,ReportActual_URL,"Report  URL is Different ");
		//--------------------Title----------------------------
		String ReportActual_Title=driver.getTitle();
		String ReportExpect_Title="Reports | Amil Freight";
		System.out.println("Report Act Title: "+ReportActual_Title);
		System.out.println("Report Exp Title: "+ReportExpect_Title);
		softAssert.assertEquals(ReportExpect_Title,ReportActual_Title,"Report Title is Different ");
		//-------------------UI-------------------------------
		String ReportActual_UI=driver.findElement(By.xpath("//*[@id='body']/div[3]/div/div/div/div/div[1]/div/div[1]/div/div")).getText();
		String ReportExpect_UI="REPORTS";
		System.out.println("Report Act UI: "+ReportActual_UI);
		System.out.println("Report Exp UI: "+ReportExpect_UI);
		softAssert.assertEquals(ReportExpect_UI,ReportActual_UI,"Report UI is Different ");
		softAssert.assertAll();
		driver.close();
		driver.switchTo().window(ReportwinHandleBefore);
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
/*	}
	@Test(priority=17)
	public void Accounts() throws InterruptedException
	{*/
		//-------------------------------Accounts dashboard--------------------------
		String AccDaswinHandleBefore = driver.getWindowHandle();	
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		//SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[17]/a")).click();
		Thread.sleep(5000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//---------------------URL---------------------------
		String AccDasActual_URL=driver.getCurrentUrl();
		String AccDasExpect_URL="http://stage.amilfreight.com/Accounts/Payment/Accounts";
		System.out.println("Accounts Act URL:"+AccDasActual_URL);
		System.out.println("Accounts Exp URL:"+AccDasExpect_URL);
		softAssert.assertEquals(AccDasExpect_URL,AccDasActual_URL,"Accounts  URL is Different ");
		//--------------------Title----------------------------
		String AccDasActual_Title=driver.getTitle();
		String AccDasExpect_Title="Accounts";
		System.out.println("Accounts Act Title: "+AccDasActual_Title);
		System.out.println("Accounts Exp Title: "+AccDasExpect_Title);
		softAssert.assertEquals(AccDasExpect_Title,AccDasActual_Title,"Accounts Title is Different ");
		//-------------------UI-------------------------------
		String AccDasActual_UI=driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/div/div/div/h4/span")).getText();
		String AccDasExpect_UI="ACCOUNTS DASHBOARD";
		System.out.println("Accounts Act UI: "+AccDasActual_UI);
		System.out.println("Accounts Exp UI: "+AccDasExpect_UI);
		softAssert.assertEquals(AccDasExpect_UI,AccDasActual_UI,"Accounts UI is Different ");
		//-------------------------------purchase Order--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[1]/a")).click();
		//---------------------URL---------------------------
		String Purchaseorder_Actual_URL=driver.getCurrentUrl();
		String Purchaseorder_Expect_URL="http://stage.amilfreight.com/Accounts/payment/purchaseorder";
		System.out.println("Purchase Order Act URL:"+Purchaseorder_Actual_URL);
		System.out.println("Purchase Order Exp URL:"+Purchaseorder_Expect_URL);
		softAssert.assertEquals(Purchaseorder_Expect_URL,Purchaseorder_Actual_URL,"Accounts  URL is Different ");
		//--------------------Title----------------------------
		String Purchaseorder_Actual_Title=driver.getTitle();
		String Purchaseorder_Expect_Title="Purchase Order | Amil Freight";
		System.out.println("Purchase Order Act Title: "+Purchaseorder_Actual_Title);
		System.out.println("Purchase Order Exp Title: "+Purchaseorder_Expect_Title);
		softAssert.assertEquals(Purchaseorder_Expect_Title,Purchaseorder_Actual_Title,"Accounts Title is Different ");
		//-------------------UI-------------------------------
		String Purchaseorder_Actual_UI=driver.findElement(By.xpath("//*[@id='purchaseorderrepeatlist']/div[1]/div/label")).getText();
		String Purchaseorder_Expect_UI="PURCHASE ORDER";
		System.out.println("Purchase Order Act UI: "+Purchaseorder_Actual_UI);
		System.out.println("Purchase Order Exp UI: "+Purchaseorder_Expect_UI);
		softAssert.assertEquals(Purchaseorder_Expect_UI,Purchaseorder_Actual_UI,"Accounts UI is Different ");
		//-------------------------------INVOICE--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[2]/a")).click();
		//---------------------URL---------------------------
		String Invoice_Actual_URL=driver.getCurrentUrl();
		String Invoice_Expect_URL="http://stage.amilfreight.com/Accounts/payment/invoices";
		System.out.println("Invoice Act URL:"+Invoice_Actual_URL);
		System.out.println("Invoice Exp URL:"+Invoice_Expect_URL);
		softAssert.assertEquals(Invoice_Expect_URL,Invoice_Actual_URL,"Accounts  URL is Different ");
		//--------------------Title----------------------------
		String Invoice_Actual_Title=driver.getTitle();
		String Invoice_Expect_Title="Invoices | Amil Freight";
		System.out.println("Invoice Act Title: "+Invoice_Actual_Title);
		System.out.println("Invoice Exp Title: "+Invoice_Expect_Title);
		softAssert.assertEquals(Invoice_Expect_Title,Invoice_Actual_Title,"Accounts Title is Different ");
		//-------------------UI-------------------------------
		String Invoice_Actual_UI=driver.findElement(By.xpath("//*[@id='invoiceslistid']/div[1]/div/label")).getText();
		String Invoice_Expect_UI="INVOICES";
		System.out.println("Invoice Act UI: "+Invoice_Actual_UI);
		System.out.println("Invoice Exp UI: "+Invoice_Expect_UI);
		softAssert.assertEquals(Invoice_Expect_UI,Invoice_Actual_UI,"Accounts UI is Different ");
		//-------------------------------Payables--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[3]/a")).click();
		//---------------------URL---------------------------
		String Payable_Actual_URL=driver.getCurrentUrl();
		String Payable_Expect_URL="http://stage.amilfreight.com/Accounts/payment/payables";
		System.out.println("Payable Act URL:"+Payable_Actual_URL);
		System.out.println("Payable Exp URL:"+Payable_Expect_URL);
		softAssert.assertEquals(Payable_Expect_URL,Payable_Actual_URL,"Payable  URL is Different ");
		//--------------------Title----------------------------
		String Payable_Actual_Title=driver.getTitle();
		String Payable_Expect_Title="Payables | Amil Freight";
		System.out.println("Payable Act Title: "+Payable_Actual_Title);
		System.out.println("Payable Exp Title: "+Payable_Expect_Title);
		softAssert.assertEquals(Payable_Expect_Title,Payable_Actual_Title,"Payable Title is Different ");
		//-------------------UI-------------------------------
		String Payable_Actual_UI=driver.findElement(By.xpath("//*[@id='PayablesList']/div[1]/div/label")).getText();
		String Payable_Expect_UI="PAYABLES";
		System.out.println("Payable Act UI: "+Payable_Actual_UI);
		System.out.println("Payable Exp UI: "+Payable_Expect_UI);
		softAssert.assertEquals(Payable_Expect_UI,Payable_Actual_UI,"Payable UI is Different ");
		//-------------------------------Receivables--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[4]/a")).click();
		//---------------------URL---------------------------
		String Receivables_Actual_URL=driver.getCurrentUrl();
		String Receivables_Expect_URL="http://stage.amilfreight.com/Accounts/payment/Receivables";
		System.out.println("Receivables Act URL:"+Payable_Actual_URL);
		System.out.println("Receivables Exp URL:"+Payable_Expect_URL);
		softAssert.assertEquals(Receivables_Expect_URL,Receivables_Actual_URL,"Receivables  URL is Different ");
		//--------------------Title----------------------------
		String Receivables_Actual_Title=driver.getTitle();
		String Receivables_Expect_Title="Receivables | Amil Freight";
		System.out.println("Receivables Act Title: "+Receivables_Actual_Title);
		System.out.println("Receivables Exp Title: "+Receivables_Expect_Title);
		softAssert.assertEquals(Receivables_Expect_Title,Receivables_Actual_Title,"Receivables Title is Different ");
		//-------------------UI-------------------------------
		String Receivables_Actual_UI=driver.findElement(By.xpath("//*[@id='Receivables']/div[1]/div/label")).getText();
		String Receivables_Expect_UI="RECEIVABLES";
		System.out.println("Receivables Act UI: "+Receivables_Actual_UI);
		System.out.println("Receivables Exp UI: "+Receivables_Expect_UI);
		softAssert.assertEquals(Receivables_Expect_UI,Receivables_Actual_UI,"Receivables UI is Different ");
		//-------------------------------ShipmentVerification--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[5]/a")).click();
		//---------------------URL---------------------------
		String ShipmentVerification_Actual_URL=driver.getCurrentUrl();
		String ShipmentVerification_Expect_URL="http://stage.amilfreight.com/Accounts/payment/shipmenttobeverified";
		System.out.println("ShipmentVerification Act URL:"+ShipmentVerification_Actual_URL);
		System.out.println("ShipmentVerification Exp URL:"+ShipmentVerification_Expect_URL);
		softAssert.assertEquals(ShipmentVerification_Expect_URL,ShipmentVerification_Actual_URL,"ShipmentVerification  URL is Different ");
		//--------------------Title----------------------------
		String ShipmentVerification_Actual_Title=driver.getTitle();
		String ShipmentVerification_Expect_Title="Shipment Verification | Amil Freight";
		System.out.println("ShipmentVerification Act Title: "+ShipmentVerification_Actual_Title);
		System.out.println("ShipmentVerification Exp Title: "+ShipmentVerification_Expect_Title);
		softAssert.assertEquals(ShipmentVerification_Expect_Title,ShipmentVerification_Actual_Title,"ShipmentVerification Title is Different ");
		//-------------------UI-------------------------------
		String ShipmentVerification_Actual_UI=driver.findElement(By.xpath("//*[@id='shipmentverifiedid']/div[1]/div/div/div[1]/ul/li/span")).getText();
		String ShipmentVerification_Expect_UI="SHIPMENT VERIFICATION";
		System.out.println("ShipmentVerification Act UI: "+ShipmentVerification_Actual_UI);
		System.out.println("ShipmentVerification Exp UI: "+ShipmentVerification_Expect_UI);
		softAssert.assertEquals(ShipmentVerification_Expect_UI,ShipmentVerification_Actual_UI,"ShipmentVerification UI is Different ");
		//-------------------------------PaymentApproval--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[6]/a")).click();
		//---------------------URL---------------------------
		String PaymentApproval_Actual_URL=driver.getCurrentUrl();
		String PaymentApproval_Expect_URL="http://stage.amilfreight.com/Accounts/payment/paymentprocessing";
		System.out.println("PaymentApproval Act URL:"+PaymentApproval_Actual_URL);
		System.out.println("PaymentApproval Exp URL:"+PaymentApproval_Expect_URL);
		softAssert.assertEquals(PaymentApproval_Expect_URL,PaymentApproval_Actual_URL,"PaymentApproval  URL is Different ");
		//--------------------Title----------------------------
		String PaymentApproval_Actual_Title=driver.getTitle();
		String PaymentApproval_Expect_Title="Payment Approval Process | Amil Freight";
		System.out.println("PaymentApproval Act Title: "+PaymentApproval_Actual_Title);
		System.out.println("PaymentApproval Exp Title: "+PaymentApproval_Expect_Title);
		softAssert.assertEquals(PaymentApproval_Expect_Title,PaymentApproval_Actual_Title,"PaymentApproval Title is Different ");
		//-------------------UI-------------------------------
		String PaymentApproval_Actual_UI=driver.findElement(By.xpath("//*[@id='paymentprocess']/div[1]/div/div/div[1]/ul/li/span")).getText();
		String PaymentApproval_Expect_UI="Payment Processing";
		System.out.println("PaymentApproval Act UI: "+PaymentApproval_Actual_UI);
		System.out.println("PaymentApproval Exp UI: "+PaymentApproval_Expect_UI);
		softAssert.assertEquals(PaymentApproval_Expect_UI,PaymentApproval_Actual_UI,"PaymentApproval UI is Different ");
		//-------------------------------EFS Approval--------------------------
		driver.findElement(By.xpath("//*[@id='mnHide']")).click();
		driver.findElement(By.xpath("//*[@id='mn-menu-container']/div/ul/li[7]/a")).click();
		//---------------------URL---------------------------
		String EFS_Actual_URL=driver.getCurrentUrl();
		String EFS_Expect_URL="http://stage.amilfreight.com/Accounts/payment/AdvancePayment";
		System.out.println("EFS Approval Act URL:"+EFS_Actual_URL);
		System.out.println("EFS Approval Exp URL:"+EFS_Expect_URL);
		softAssert.assertEquals(EFS_Expect_URL,EFS_Actual_URL,"EFS Approval  URL is Different ");
		//--------------------Title----------------------------
		String EFS_Actual_Title=driver.getTitle();
		String EFS_Expect_Title="Advance Payment List | AmilFreight";
		System.out.println("EFS Approval Act Title: "+EFS_Actual_Title);
		System.out.println("EFS Approval Exp Title: "+EFS_Expect_Title);
		softAssert.assertEquals(EFS_Expect_Title,EFS_Actual_Title,"EFS Approval Title is Different ");
		//-------------------UI-------------------------------
		String EFS_Actual_UI=driver.findElement(By.xpath("//*[@id='lstsection']/div[1]/div/div/div/h4/span")).getText();
		String EFS_Expect_UI="ADDITIONAL EXPENSE ADVANCE PAYMENT LIST";
		System.out.println("EFS Approval Act UI: "+EFS_Actual_UI);
		System.out.println("EFS Approval Exp UI: "+EFS_Expect_UI);
		softAssert.assertEquals(EFS_Expect_UI,EFS_Actual_UI,"EFS Approval UI is Different ");
		
		driver.switchTo().window(AccDaswinHandleBefore);
		
		
	}
}
