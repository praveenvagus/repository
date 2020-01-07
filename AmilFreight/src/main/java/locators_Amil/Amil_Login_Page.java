package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility_Files.BaseClass;
import utility_Files.Log;


public class Amil_Login_Page extends BaseClass {


	public Amil_Login_Page(WebDriver driver) {
		super(driver);
		}

	private static WebElement element = null;


	public static WebElement Signin_Navigator() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath("//a[contains(@href,'/signin')]"));
           }catch (Exception e){
       		Log.error("Signin_Navigator not available");
       		System.out.println("Rathi Praveen");
       		throw(e);
       		}
       	return element;
    }
	

	public static WebElement UserName_text() throws Exception{
        try{ 
        	 element = driver.findElement(By.id("txtusername"));
           }catch (Exception e){
       		Log.error("UserName_text not available");
       		throw(e);
       		}
       	return element;
    }
	
	public static WebElement Password_text() throws Exception{
        try{ 
        	 element = driver.findElement(By.id("txtpassword"));
           }catch (Exception e){
       		Log.error("Password_text not available");
       		throw(e);
       		}
       	return element;
    }
	
	public static WebElement Signin_Button() throws Exception{
        try{ 
        	 element = driver.findElement(By.id("btnSignIn"));
           }catch (Exception e){
       		Log.error("Signin_Button not available");
       		throw(e);
       		}
       	return element;
    }
	
	public static WebElement Loggedout_Icon() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath("//*[@class='icon-arrow-down12']"));
           }catch (Exception e){
       		Log.error("Loggedout_Icon not available");
       		throw(e);
       		}
       	return element;
    }
	
	public static WebElement LoggedOut_BUtton() throws Exception{
        try{ 
        	element = driver.findElement(By.xpath("//*[@onclick='Security.Logout();']"));
            }catch (Exception e){
       		Log.error("LoggedOut_Confirm not available");
       		throw(e);
       		}
       	return element;
    }
	
	public static WebElement LoggedOut_Confirm() throws Exception{
        try{ 
        	element = driver.findElement(By.xpath("//*[@onclick='Message.ConfirmOk();']"));
           }catch (Exception e){
       		Log.error("LoggedOut_Confirm not available");
       		throw(e);
       		}
       	return element;
    }
	
	

	
	
	
}
