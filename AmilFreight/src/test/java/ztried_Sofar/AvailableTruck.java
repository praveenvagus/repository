package ztried_Sofar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utility_Files.Utils;

public class AvailableTruck {

static WebDriver driver;
@Test(priority=1)
public void available_PostTruck() throws Exception {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\jenkins\\workspace\\AmilFreight\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://stage.amilfreight.com");
		driver.findElement(By.cssSelector("a[href='/signin']")).click();		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("admin@ebintl.com");
		driver.findElement(By.cssSelector("input[name='txtpassword']")).sendKeys("Admin@123");
		driver.findElement(By.cssSelector("input[id='btnSignIn']")).click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.navigate().to("http://stage.amilfreight.com/shipment/dashboard");
		Thread.sleep(1900);
		
		driver.findElement(By.xpath("//*[@class='set1 available-truck position-relative']/a")).click();
		driver.findElement(By.xpath("//*[@ng-click='ShowAvailableTrucks(1)']")).click();
		Thread.sleep(1900);
		Utils.Instance_NewWindow(driver);
		
		String CarrierName="TEXOIL TRUCKING";
		driver.findElement(By.xpath("//*[@id='txtcarriername']")).sendKeys(CarrierName);
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id='liCarrierColection']/li")).click();
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(2500);
		//trailer Type
	    Select TrailerType = new Select(driver.findElement(By.xpath("//*[@id='trailertype']")));
	    TrailerType.selectByVisibleText("RGN");
	    Thread.sleep(2000);
	    
	    //Pickup Location	    
	    String PickupLocation= "Yuma, Arizona(AZ)";
	    driver.findElement(By.xpath("//*[@id='curLoc']")).sendKeys(PickupLocation);	    
		Thread.sleep(3500);
	   driver.findElement(By.xpath("//*[@id='Basicinfo']/div[1]/div/div[5]/ul/li[1]/a")).click();
		
	 //Available Date			
	 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 		//Getting current date
	 		Calendar cal = Calendar.getInstance();
	 		
	 		//***********************Preferred Pickup Time*********************************
	 		driver.findElement(By.xpath("//*[@id='txtAvailDate']")).click();
	 		String AvailableDate = sdf.format(cal.getTime());  
	 			
//	 		System.out.println("Available Date : "+AvailableDate);		
	 			
	 		String[] arrSplit_Date = AvailableDate.split("/"); 
	 		arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");


	 		//To get all the rows of Calendar
	 		List<WebElement> dtRows=driver.findElements(By.xpath("html/body/div[4]/div[3]/table/tbody/tr"));	

	 	    for(int j=1;j<=dtRows.size();j++)
	 	    {
	 	    	//System.out.println("Correct");
	 	    	for(int i=1;i <= 7;i++)
	 	    	{
	 		    	String dateRowxpath= "/html/body/div[4]/div[3]/table/tbody/tr";
	 		    	String date_xpath ="["+j+"]";
	 				String dateRowxpath_first=dateRowxpath.concat(date_xpath);
	 				String date_td="/td";
	 				String date_tdvalue="["+i+"]";
	 				String date=date_td.concat(date_tdvalue);
	 				//xpath for the single date
	 				String datexpath_Complete=dateRowxpath_first.concat(date);
	 				
	 				WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
	 				
	 				//System.out.println(datexpath_Complete);
//	 				String dd1= dateElement.getAttribute("value");
	 				String date_text= dateElement.getText();
//	 				System.out.println(dd1+"::::"+dd13);
	 				if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
	 				{
	 				//	System.out.println(dateElement);
	 					if((dateElement.getAttribute("class").contentEquals("day active"))||(dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
	 					{
	 						dateElement.click();
	 						i=8;
	 						j=dtRows.size()+1;
	 						
	 					}
	 					
	 				}
	 	    	}
	 	    }
	 	    
		//Submit Details
	    driver.findElement(By.xpath("//button[@ng-click='saveTruckDetails(availableTruck)']")).click();
	    Thread.sleep(1500);
		
	    Thread.sleep(2500);
	    driver.switchTo().alert().accept();

	    driver.findElement(By.xpath("//*[@id='divConfirmbtn']")).click();
		
		driver.close();
		
	}
	}
	
	

