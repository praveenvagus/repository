package utility_Files;

import java.io.File;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators_Amil.Amil_Login_Page;
import locators_Amil.QuoteMail_Page;
import locators_Amil.ShipDash_Post;

@SuppressWarnings("unused")
public class Utils 
{
	public static WebDriver driver;
	public static String driver2;

public static WebDriver Login_AmilFreight() throws Exception
{
	System.setProperty("webdriver.chrome.driver",Constant.ChromeDriver_Path);
	WebDriver driver=new ChromeDriver();
	driver.get(Constant.URLD);
	driver.manage().window().maximize();
    PropertyConfigurator.configure(Constant.lo4j);	
   	Thread.sleep(1500);
	return driver;      
}


public static String getTestCaseName(String sTestCase)throws Exception{
	String value = sTestCase;
	try{
		int posi = value.indexOf("@");
		value = value.substring(0, posi);
		posi = value.lastIndexOf(".");	
		value = value.substring(posi + 1);
		return value;
			}catch (Exception e){
		Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
		throw (e);
				}
		}


 public static void waitForElement(WebElement element){
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.elementToBeClickable(element));
 	}
	
 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		try{
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".png"));
			
		} catch (Exception e){
			
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
	}
 
 public static void Instance_NewWindow(WebDriver driver) throws Exception{
		try{
			
			for (String winHandle : driver.getWindowHandles()) {
				 driver.switchTo().window(winHandle); }

			
		} catch (Exception e){
			
			Log.error("Class Utils | Method Instance_NewWindow | Exception occured while moving Newly Opened_Window : "+e.getMessage());
			throw new Exception();
		}
	}
 

 
 public static void waitForAjax2(WebDriver driver) {
	    new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            return (Boolean) js.executeScript("return jQuery.active == 0");
	        }
	    });
	}
 
 
  
 public static WebDriver Loggout_AmilFreight() throws Exception
 {

 	Thread.sleep(1500);
 	WebElement Confirm_Button1=driver.findElement(By.xpath("//*[@id='navbar-mobile']/div/ul/li[3]/a/i"));
 	JavascriptExecutor ex=(JavascriptExecutor)driver;
 	ex.executeScript("arguments[0].click()", Confirm_Button1);
 	Thread.sleep(2500);
 	driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
 	WebElement Confirm_Button=driver.findElement(By.xpath("//*[@id='divConfirmbtn'][1]"));
 	ex.executeScript("arguments[0].click()", Confirm_Button);
 	Thread.sleep(2500);
 	return driver;
      
 }
 
 public static WebDriver QuoteMail_2_AllCarriers(WebDriver driver) throws Exception
 {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click()", QuoteMail_Page.SendQuote_MailDrop());
	 Thread.sleep(1600);
	 js.executeScript("arguments[0].click()", QuoteMail_Page.SendQuote_2All());
	 Thread.sleep(2600);
	 js.executeScript("arguments[0].click()", QuoteMail_Page.Mail_SendButton());
	 Thread.sleep(1600);
	 js.executeScript("arguments[0].click()", QuoteMail_Page.Mail_CloseIcon());
	 Thread.sleep(2300);
 	 return driver;
      
 }
 
 public static WebDriver QuoteAmount_Submission(WebDriver driver) throws Exception
 {
	 
	 driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 driver.findElement(By.id("txtAmount")).sendKeys("300");
	 driver.findElement(By.xpath("//*[@id='dtPickupTime']")).click();
     Utils2.QuotePickUp_CurrentDate(driver);
	 Select pickup_Hour = new Select(driver.findElement(By.id("PickupTimeHour")));
	 pickup_Hour.selectByIndex(10);
	 Select pickup_Minute = new Select(driver.findElement(By.id("PickupTimemin")));
	 pickup_Minute.selectByIndex(5);
	 Select AM_PM = new Select(driver.findElement(By.id("PickupTimefor")));
	 AM_PM.selectByIndex(0);
	 driver.findElement(By.xpath("//*[@id='dtDropTime']")).click();
	 Utils2.QuoteDrop_CurrentDate(driver);
	 Select drop_hour = new Select(driver.findElement(By.id("DropoffTimeHour")));
	 drop_hour.selectByIndex(5);
	 Select drop_Minute = new Select(driver.findElement(By.id("DropoffTimemin")));
	 drop_Minute.selectByIndex(5);
	 Select AM_PM_Drop = new Select(driver.findElement(By.id("DropoffTimefor")));
	 AM_PM_Drop.selectByIndex(1);
	 driver.findElement(By.id("contactname")).sendKeys("Praveen Raja");
	 driver.findElement(By.id("txtQuotePhoneNumber")).sendKeys("9159166877");
	 driver.findElement(By.xpath("//*[@id='divQuotation']/div/div/div[4]/div[3]/div[1]/div[4]/div")).click();     
     return driver;
	 
 }
 
public static List<String> Email_ReceipentList(String Shp_GUID) throws ClassNotFoundException, SQLException{
		
	 String dbURL = "jdbc:sqlserver://192.168.3.240;instance=SQLEXPRESS;"+"databaseName=AmilTruck-2.1;";
	 String user = "AmilTruckPreProduction";
	 String password = "@m!lFr3ightpro";
	 List<String> emaillist = new ArrayList<String>();
	 Connection conn = DriverManager.getConnection(dbURL, user, password);
	 CallableStatement statement = conn.prepareCall(" [CONFIG].[USP_GetLoadSpecificMails_back] @Shp_guid='"+Shp_GUID+"' ");
	 boolean hadResults = statement.execute();
	 int i =0;
	 while (hadResults) {
	 ResultSet resultSet = statement.getResultSet();
	 if(i==1) {
	 while (resultSet.next()) {
	 String emailsent = resultSet.getString("toemailid");
	 emaillist.add(emailsent);
	// System.out.println(emailsent);
	 }
	 }
	 i=i+1;
	 hadResults = statement.getMoreResults();
	 }
	 statement.close();
	return emaillist;
	 }

    	
public static WebDriver PageURL_Verification(String pr1, String pr2) throws Exception
{

	String Text1=pr1;
	String Text2=driver.findElement(By.xpath("//*[@id='signupDiv']/div[2]/p")).getText();
	String Text3=pr2;
	if(Text1.equals(Text2)) 
	{
	       System.out.println(Text2);
	       //Assert.assertTrue(Text1.equalsIgnoreCase(Text2),"Need to Login");
	}
	else 
	{
	       String Text5=driver.findElement(By.xpath("//*[@id='successDiv']/div[2]/p")).getText();
	       System.out.println(Text5);
	      // Assert.assertTrue(Text3.equalsIgnoreCase(Text5),"Success Page");
	}

return driver;
	
}




}
