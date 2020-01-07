package ztried_Sofar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Useful_Return_Load {

WebDriver driver;
	
	@BeforeClass
	public void Open_Browser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\AmilFreight\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://stage.amilfreight.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='main-nav']/div/div[2]/div[3]/div/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("txtusername")).sendKeys("admin@ebintl.com");
		driver.findElement(By.id("txtpassword")).sendKeys("Admin@123");
		driver.findElement(By.id("btnSignIn")).click();
		Thread.sleep(2500);
		driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);	
		
		Thread.sleep(1500);
}
	
	@Test
	public void Find_ReturnLoad() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(By.id("textsearch")).sendKeys("AFS19121300008");
		driver.findElement(By.xpath("//*[@class='icon-search4 search' and @title='Search']")).click();
		Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
		
		//Spot_Load
		WebElement Spot_Load= driver.findElement(By.xpath("//*[@id='tabSpotLoads']/span"));
		System.out.println("Spot_Load count is -- "+Spot_Load.getText());
		String SPO_No = Spot_Load.getText();
		int SPO_Res= Integer.parseInt(SPO_No);
		//Tendered_Load
		WebElement Tendered_Load= driver.findElement(By.xpath("//*[@id='tabTenderLoads']/span"));
		System.out.println("Spot_Load count is -- "+Tendered_Load.getText());
		String BL_No = Tendered_Load.getText();
		int BL_Res= Integer.parseInt(BL_No);		
		//Posted_Load
		WebElement Posted_Load= driver.findElement(By.xpath("//*[@id='tabPosted']/span"));
		System.out.println("Posted_Load count is -- "+Posted_Load.getText());
		String POS_No = Posted_Load.getText();
		int POS_Res= Integer.parseInt(POS_No);				
		//Open_Load
		WebElement Open_Load= driver.findElement(By.xpath("//*[@id='tabOpen']/span"));
		System.out.println("Open_Load count is -- "+Open_Load.getText());
		String OPN_No = Open_Load.getText();
		int OPN_Res= Integer.parseInt(OPN_No);
		//Booked_Load
		WebElement Booked_Load= driver.findElement(By.xpath("//*[@id='tabBooked']/span"));
		System.out.println("Booked_Load count is -- "+Booked_Load.getText());
		String BOK_No = Booked_Load.getText();
		int BOK_Res= Integer.parseInt(BOK_No);		
		//Intransit_Load
		WebElement Intransit_Load= driver.findElement(By.xpath("//*[@id='tabIntranist']/span"));
		System.out.println("Intransit_Load count is -- "+Intransit_Load.getText());
		String ITS_No = Intransit_Load.getText();
		int ITS_Res= Integer.parseInt(ITS_No);	
		driver.findElement(By.xpath("//*[@id='AdminUlLi']/li[7]/a/i")).click();
			
		//Delivered_Load
		WebElement Delivered_Load= driver.findElement(By.xpath("//*[@id='tabCompleted']/span"));
		System.out.println("Delivered_Load count is -- "+Delivered_Load.getText());
		String DLV_No = Delivered_Load.getText();
		int DLV_Res= Integer.parseInt(DLV_No);		
		//Completed_Load
		WebElement Completed_Load= driver.findElement(By.xpath("//*[@id='tabFullyCompleted']/span"));
		System.out.println("Completed_Load count is -- "+Completed_Load.getText());
		String COM_No = Completed_Load.getText();
		int COM_Res= Integer.parseInt(COM_No);		
		//Expired_Load
		WebElement Expired_Load= driver.findElement(By.xpath("//*[@id='tabExpired']/span"));
		System.out.println("Expired_Load count is -- "+Expired_Load.getText());
		String EXP_No = Expired_Load.getText();
		int EXP_Res= Integer.parseInt(EXP_No);				
		//Cancelled_Load
		WebElement Cancelled_Load= driver.findElement(By.xpath("//*[@id='tabCancelled']/span"));
		System.out.println("Cancelled_Load count is -- "+Cancelled_Load.getText());
		String CLE_No = Cancelled_Load.getText();
		int CLE_Res= Integer.parseInt(CLE_No);
		//Closed_Load
		WebElement Closed_Load= driver.findElement(By.xpath("//*[@id='tabClosed']/span"));
		System.out.println("Closed_Load count is -- "+Closed_Load.getText());
		String CLS_No = Closed_Load.getText();
		int CLS_Res= Integer.parseInt(CLS_No);		
		//Deleted_Load
		WebElement Deleted_Load= driver.findElement(By.xpath("//*[@id='tabDeleted']/span"));
		System.out.println("Deleted_Load count is -- "+Deleted_Load.getText());
		String DEL_No = Deleted_Load.getText();
		int DEL_Res= Integer.parseInt(DEL_No);			
		//Rejected_Load
		WebElement Rejected_Load= driver.findElement(By.xpath("//*[@id='tabRejected']/span"));
		System.out.println("Rejected_Load count is -- "+Rejected_Load.getText());
		String REJ_No = Rejected_Load.getText();
		int REJ_Res= Integer.parseInt(REJ_No);	
		//All_Load
		WebElement All_Load= driver.findElement(By.xpath("//*[@id='tabAll']/span"));
		System.out.println("All_Load count is -- "+All_Load.getText());
		
		if(SPO_Res>0) {
			Spot_Load.click();
		}
	    				
		else if(BL_Res>0) {
			Tendered_Load.click();
		}
					
		else if(POS_Res>0) {
			Posted_Load.click();
		}
					
		else if(OPN_Res>0) {
			Open_Load.click();
		}
					
		else if(BOK_Res>0) {
		Booked_Load.click();
		}
					
		else if(ITS_Res>0) {
			Intransit_Load.click();
		}
				
		else if(DLV_Res>0) {
			Delivered_Load.click();
		}
				
		else if(COM_Res>0) {
			Completed_Load.click();
		}
					
		else if(EXP_Res>0) {
			Expired_Load.click();
		}
					
		else if(CLE_Res>0) {
			Cancelled_Load.click();
		}
		
		else if(CLS_Res>0) {
			Closed_Load.click();
		}
					
		if(DEL_Res>0) {
			Deleted_Load.click();
		}
			
		if(REJ_Res>0) {
			Rejected_Load.click();
		}
	    
}
	
@Test
public void Find_ReturnLoads_Test2() throws InterruptedException {
		
WebElement Return_LoadBut=driver.findElement(By.xpath("//*[@id='shipRpt ship']/div[1]/div[7]/span[1]"));
Actions RL1=new Actions(driver);
RL1.moveToElement(Return_LoadBut).build().perform();
Thread.sleep(1500);
Return_LoadBut.click();
		
for (String winHandle : driver.getWindowHandles()) {
	 driver.switchTo().window(winHandle); }
driver.manage().window().maximize();
Thread.sleep(1500);
WebElement Miles=driver.findElement(By.xpath("//*[@id='LoadReturn']/div[1]/span[2]/input"));
Miles.clear();
Miles.sendKeys("100");
//System.out.println(Miles.getText());

String Exact_Match=driver.findElement(By.xpath("//*[@id='exactmatch']/div[1]/table/tbody/tr/td/a")).getText();
System.out.println(Exact_Match);
		
List<WebElement> list_ShipID=driver.findElements(By.xpath("//*[@id='exactmatch']/div[1]/table/tbody/tr/td/a"));
System.out.println(list_ShipID.size());
for(int i=0;i<list_ShipID.size();i++) {
System.out.println(list_ShipID.get(i).getText());
}
}

	
}
