package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;
import utility_Files.Log;

public class QuoteMail_Page extends BaseClass{

	public QuoteMail_Page(WebDriver driver) {
		super(driver);		
	}
	
private static WebElement element = null;

public static WebElement BY_FREQUENCY_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='loadfrequency']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Select_CheckBox(String Carrier_Name) throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[contains(text(), '"+Carrier_Name+"')]//parent::div/span[1]/input"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement SendQuote_MailDrop() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='matchingcarrierdiv']/div[1]/div/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement SendQuote_2All() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[contains(text(),' To All')]//parent::a[@ng-click='showmail()']"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Mail_SendButton() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[contains(text(), 'Send') and @ng-click='SENDSPOTLOADMAIL()']"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement Mail_CloseIcon() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@ng-click='Closemodal()']/i"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_NearBy_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='carriersnearby']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_PREFERRED_LANE_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='preferredlanes']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_ORIGIN_BASEDHOME_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='homebase']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_DESTINATION_BASEDHOME_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='homebaseDestination']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_PREFERRED_ORIGIN_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='PreferredOrigin']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}
public static WebElement BY_PREFERRED_DESTINATION_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='PreferredDestination']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_PREFERRED_STATE_Button() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='preferredstates']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}
public static WebElement AvailCarrier_Close() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@ng-click='close();' and @title='Close']"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}

public static WebElement BY_FREQUENCY_Button1() throws Exception{
    try{ 
    	 element = driver.findElement(By.xpath("//*[@id='loadfrequency']/a"));
       }catch (Exception e){
   		Log.error(" not available");
   		throw(e);
   		}
   	return element;
}


}