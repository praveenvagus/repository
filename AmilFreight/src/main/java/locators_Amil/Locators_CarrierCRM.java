package locators_Amil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;

public class Locators_CarrierCRM extends BaseClass{
	
	public Locators_CarrierCRM(WebDriver driver) {
		super(driver);
	}
	private static WebElement element = null;

    //SignupSections Link
    public static WebElement dot_Find() throws Exception{
     try{ 
    	 element =driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[12]"));
        }catch (Exception e){
                  System.out.println("dot_Find not available");
                  throw(e);
                  }
           return element;
    }   
	
  //Dot_Filter
    public static WebElement Dot_Filter() throws Exception{
     try{ 
    	 element =driver.findElement(By.xpath("//*[@id='tblDiv']/thead/tr/th[12]/div/a"));
        }catch (Exception e){
                  System.out.println("Dot_Filter not available");
                  throw(e);
                  }
           return element;
    }
    //Dot No Text
    public static WebElement Dot_No_Text() throws Exception{
        try{ 
       	 element =driver.findElement(By.name("txtsrchCRYname"));
           }catch (Exception e){
                     System.out.println("Dot_No_Text not available");
                     throw(e);
                     }
              return element;
       }
    //Dot No Submit
    public static WebElement Dot_No_Submit() throws Exception{
        try{ 
       	 element =driver.findElement(By.name("txtsrchCRYname"));
           }catch (Exception e){
                     System.out.println("Dot_No_Submit not available");
                     throw(e);
                     }
              return element;
       }

    //Lead Tab
    public static WebElement Lead_Tab() throws Exception{
        try{ 
       	 element =driver.findElement(By.xpath("//*[@id='Tabs']/li[1]/a"));
           }catch (Exception e){
                     System.out.println("Lead_Tab not available");
                     throw(e);
                     }
              return element;
       }
    
    //Profile 
    public static WebElement profile_Find() throws Exception{
        try{ 
       	 element =driver.findElement(By.id("carrierprofileview1"));
           }catch (Exception e){
                     System.out.println("profile_Find not available");
                     throw(e);
                     }
              return element;
       } 
    //Account Name
    public static WebElement account_Displayed_Element() throws Exception{
        try{ 
      	 element =driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[1]/span"));
           }catch (Exception e){
                     System.out.println("account_Displayed_Element not available");
                     throw(e);
                     }
              return element;
       } 
    
    //Dot Number
    public static WebElement dot_Displayed_Element() throws Exception{
        try{ 
       	 element =driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[2]/span"));
           }catch (Exception e){
                     System.out.println("dot_Displayed_Element not available");
                     throw(e);
                     }
              return element;
       } 
    
    //Status Displayed
    public static WebElement status_Displayed_Element() throws Exception{
        try{ 
       	 element =driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[2]/div[1]/span"));
           }catch (Exception e){
                     System.out.println("status_Displayed_Element not available");
                     throw(e);
                     }
              return element;
       } 
  //Scroll to Contact
    public static WebElement contact_Finder() throws Exception{
        try{ 
       	 element =driver.findElement(By.xpath("//*[@id='contactPartial']"));
           }catch (Exception e){
                     System.out.println("contact_Finder not available");
                     throw(e);
                     }
              return element;
       } 
    //**Contact Details
  //Contact Name
    public static WebElement get_Contact_Name() throws Exception{
        try{ 
       	 element =driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[1]"));
           }catch (Exception e){
                     System.out.println("get_Contact_Name not available");
                     throw(e);
                     }
              return element;
       } 
    
    
  //Contact Number
    public static WebElement get_Number_Element() throws Exception{
        try{ 
       	 element =driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/span/span[1]/a"));
       			}catch (Exception e){
                     System.out.println("get_Number_Element not available");
                     throw(e);
                     }
              return element;
       } 
  //Extension
    public static WebElement get_Extension_Element() throws Exception{
        try{ 
         	 element = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/span/span[2]"));
           }catch (Exception e){
                     System.out.println("get_Extension_Element not available");
                     throw(e);
                     }
              return element;
       } 
    //Phone type
    public static WebElement phone_Type_Displayed_Element() throws Exception{
        try{ 
 
       	 element = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]"));
           }catch (Exception e){
                     System.out.println("phone_Type_Displayed_Element not available");
                     throw(e);
                     }
              return element;
       } 
  //Email
    public static WebElement email_Displayed_Element() throws Exception{
        try{ 
 
       	 element = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[3]/a"));
           }catch (Exception e){
                     System.out.println("email_Displayed_Element not available");
                     throw(e);
                     }
              return element;
       } 
    
    //Email
    public static WebElement role_Displayed_Element() throws Exception{
        try{ 
 
       	 element = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[4]"));
           }catch (Exception e){
                     System.out.println("role_Displayed_Element not available");
                     throw(e);
                     }
              return element;
       } 
    //Primary Contact icon
    public static WebElement primaryContactIcon_Element() throws Exception{
        try{ 
 
       	 element = driver.findElement(By.xpath("//*[@id='contactPartial']/div[1]/table/tbody/tr/td[1]/a/i"));
           }catch (Exception e){
                     System.out.println("primaryContactIcon_Element not available");
                     throw(e);
                     }
              return element;
       } 
   
    public static WebElement mcnumber_Element() throws Exception{
        try{ 
 
       	 element =  driver.findElement(By.xpath("//*[@id='collapsible-control-right-group1']/div/div/div[1]/div[3]/span"));
           }catch (Exception e){
                     System.out.println("mcnumber_Element not available");
                     throw(e);
                     }
              return element;
       } 
    public static WebElement Contact_tab() throws Exception{
        try{ 
 
       	 element =  driver.findElement(By.xpath("//*[@id='Tabs']/li[2]/a"));
           }catch (Exception e){
                     System.out.println("Contact_tab not available");
                     throw(e);
                     }
              return element;
       } 
}
