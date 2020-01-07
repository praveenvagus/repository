package utility_Files;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils2 
{
public static WebDriver driver;

public static WebDriver QuotePickUp_CurrentDate(WebDriver driver){
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
String AvailableDate = sdf.format(cal.getTime());   
String[] arrSplit_Date = AvailableDate.split("/"); 
arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");
List<WebElement> dtRows=driver.findElements(By.xpath("html/body/div[3]/div[3]/table/tbody/tr"));  
for(int j=1;j<=dtRows.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpath= "html/body/div[3]/div[3]/table/tbody/tr";
String date_xpath ="["+j+"]";
String dateRowxpath_first=dateRowxpath.concat(date_xpath);
String date_td="/td";
String date_tdvalue="["+i+"]";
String date=date_td.concat(date_tdvalue);
String datexpath_Complete=dateRowxpath_first.concat(date);
WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
String date_text= dateElement.getText();
if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
{
if((dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
{
dateElement.click();
i=8;
j=dtRows.size()+1;
}
}
}
}
return driver;
}

public static WebDriver QuoteDrop_CurrentDate(WebDriver driver){
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
String DropDate = sdf.format(cal.getTime());  
String[] arrSplit_DDate = DropDate.split("/"); 
arrSplit_DDate[0]=arrSplit_DDate[0].replaceFirst("^0*", "");
List<WebElement> dtRowsdrop=driver.findElements(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr"));     
for(int j=1;j<=dtRowsdrop.size();j++)
{
for(int i=1;i <= 7;i++)
{
String ddateRowxpath= "html/body/div[4]/div[3]/table/tbody/tr";
String ddate_xpath ="["+j+"]";
String ddateRowxpath_first=ddateRowxpath.concat(ddate_xpath);
String ddate_td="/td";
String ddate_tdvalue="["+i+"]";
String ddate=ddate_td.concat(ddate_tdvalue);
String datexpath_Complete=ddateRowxpath_first.concat(ddate);
WebElement ddateElement=driver.findElement(By.xpath(datexpath_Complete));
String ddate_text= ddateElement.getText();
if(ddate_text.equalsIgnoreCase(arrSplit_DDate[0]))
{
if((ddateElement.getAttribute("class").contentEquals("day"))||(ddateElement.getAttribute("class").contentEquals("day new")))
{
ddateElement.click();
i=8;
j=dtRowsdrop.size()+1;
}
}
}
}return driver;
}

public static WebDriver PostLoad_PickUpDate(WebDriver driver){
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 1);             
String PickupDate = sdf.format(cal.getTime());  
String[] arrSplit_Date = PickupDate.split("/"); 
arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");
List<WebElement> dtRows=driver.findElements(By.xpath("/html/body/div[4]/div[3]/table/tbody/tr"));  
for(int j=1;j<=dtRows.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpath= "/html/body/div[4]/div[3]/table/tbody/tr";
String date_xpath ="["+j+"]";
String dateRowxpath_first=dateRowxpath.concat(date_xpath);
String date_td="/td";
String date_tdvalue="["+i+"]";
String date=date_td.concat(date_tdvalue);
String datexpath_Complete=dateRowxpath_first.concat(date);
WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
String date_text= dateElement.getText();
if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
{
if((dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
{
dateElement.click();
i=8;
j=dtRows.size()+1;
}
}
}
}
return driver;	
}

public static WebDriver PostLoad_DropDate(WebDriver driver){
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 2);  
String DropDate = sdf.format(cal.getTime());            
String[] arrSplit_DropDate = DropDate.split("/"); 
arrSplit_DropDate[0]=arrSplit_DropDate[0].replaceFirst("^0*", "");     
List<WebElement> dtRows=driver.findElements(By.xpath("html/body/div[5]/div[3]/table/tbody/tr"));  
for(int j=1;j<=dtRows.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpath= "html/body/div[5]/div[3]/table/tbody/tr";
String date_xpath ="["+j+"]";
String dateRowxpath_first=dateRowxpath.concat(date_xpath);
String date_td="/td";
String date_tdvalue="["+i+"]";
String date=date_td.concat(date_tdvalue);
String datexpath_Complete=dateRowxpath_first.concat(date);                    
WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
String date_text= dateElement.getText();
if(date_text.equalsIgnoreCase(arrSplit_DropDate[0]))
{
if((dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
{
dateElement.click();
i=8;
j=dtRows.size()+1;
}
}
}
}
return driver;
}

public static WebDriver PostTruck_AvailableDate(WebDriver driver){
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
driver.findElement(By.xpath("//*[@id='txtAvailDate']")).click();
String AvailableDate = sdf.format(cal.getTime());  
String[] arrSplit_Date = AvailableDate.split("/"); 
arrSplit_Date[0]=arrSplit_Date[0].replaceFirst("^0*", "");
List<WebElement> dtRows=driver.findElements(By.xpath("html/body/div[4]/div[3]/table/tbody/tr"));  
for(int j=1;j<=dtRows.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpath= "html/body/div[4]/div[3]/table/tbody/tr";
String date_xpath ="["+j+"]";
String dateRowxpath_first=dateRowxpath.concat(date_xpath);
String date_td="/td";
String date_tdvalue="["+i+"]";
String date=date_td.concat(date_tdvalue);
String datexpath_Complete=dateRowxpath_first.concat(date);
WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
String date_text= dateElement.getText();
if(date_text.equalsIgnoreCase(arrSplit_Date[0]))
{
if((dateElement.getAttribute("class").contentEquals("day active"))||(dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
{
dateElement.click();
i=8;
j=dtRows.size()+1;
}
}
}
}
return driver;
}

public static WebDriver General_LiabilityDate(WebDriver driver) throws InterruptedException{
driver.findElement(By.xpath("//*[@id='dtCGLPolicyExp']")).click();
Thread.sleep(6000);
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
String Expirydate = sdf.format(cal.getTime());  
System.out.println("Expirydate---"+Expirydate); 
String[] arrSplit_DropDate = Expirydate.split("/"); 
arrSplit_DropDate[0]=arrSplit_DropDate[0].replaceFirst("^0*", "");
List<WebElement> dtRows=driver.findElements(By.xpath("//*[@id='CarrierSignUp']/div[2]/div[3]/table/tbody/tr"));  
for(int j=1;j<=dtRows.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpath= "//*[@id='CarrierSignUp']/div[2]/div[3]/table/tbody/tr";
String date_xpath ="["+j+"]";
String dateRowxpath_first=dateRowxpath.concat(date_xpath);
String date_td="/td";
String date_tdvalue="["+i+"]";
String date=date_td.concat(date_tdvalue);
String datexpath_Complete=dateRowxpath_first.concat(date);
WebElement dateElement=driver.findElement(By.xpath(datexpath_Complete));
String date_text= dateElement.getText();
if(date_text.equalsIgnoreCase(arrSplit_DropDate[0]))
{
if((dateElement.getAttribute("class").contentEquals("day active"))||(dateElement.getAttribute("class").contentEquals("day"))||(dateElement.getAttribute("class").contentEquals("day new")))
{
dateElement.click();
i=8;
j=dtRows.size()+1;
}
}
}
}
return driver;
}

public static WebDriver Auto_LiabilityDate(WebDriver driver){
driver.findElement(By.xpath("//*[@id='dtALLimits']")).click();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
String Expirydate = sdf.format(cal.getTime());  
System.out.println("Expirydate---"+Expirydate);    
System.out.println("Expirydate---"+Expirydate);       
String[] arrSplit_ExpiryAlDate = Expirydate.split("/"); 
arrSplit_ExpiryAlDate[0]=arrSplit_ExpiryAlDate[0].replaceFirst("^0*", "");
List<WebElement> dtRowsAL=driver.findElements(By.xpath("//*[@id='CarrierSignUp']/div[3]/div[3]/table/tbody/tr"));       
for(int j=1;j<=dtRowsAL.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpathAL= "//*[@id='CarrierSignUp']/div[3]/div[3]/table/tbody/tr";
String date_xpathAL ="["+j+"]";
String dateRowxpath_firstAL=dateRowxpathAL.concat(date_xpathAL);
String date_tdAL="/td";
String date_tdvalueAL="["+i+"]";
String dateAL=date_tdAL.concat(date_tdvalueAL);
String datexpath_CompleteAL=dateRowxpath_firstAL.concat(dateAL);
WebElement dateElementAL=driver.findElement(By.xpath(datexpath_CompleteAL));
String date_textAL= dateElementAL.getText();
if(date_textAL.equalsIgnoreCase(arrSplit_ExpiryAlDate[0]))
{
if((dateElementAL.getAttribute("class").contentEquals("day active"))||(dateElementAL.getAttribute("class").contentEquals("day"))||(dateElementAL.getAttribute("class").contentEquals("day new")))
{
dateElementAL.click();
i=8;
j=dtRowsAL.size()+1;
}
}
}
}
return driver;
}

public static WebDriver Cargo_COverageDate(WebDriver driver){
driver.findElement(By.xpath("//input[@ng-model='account.InsuranceDetail.CCPolicyEXP']")).click();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
String Expirydate = sdf.format(cal.getTime());  
System.out.println("Expirydate---"+Expirydate);    
System.out.println("Expirydate---"+Expirydate);        
String[] arrSplit_ExpiryDateCC = Expirydate.split("/"); 
arrSplit_ExpiryDateCC[0]=arrSplit_ExpiryDateCC[0].replaceFirst("^0*", "");
List<WebElement> dtRowsCC=driver.findElements(By.xpath("//*[@id='CarrierSignUp']/div[4]/div[3]/table/tbody/tr"));       
for(int j=1;j<=dtRowsCC.size();j++)
{
for(int i=1;i <= 7;i++)
{
String dateRowxpathCC= "//*[@id='CarrierSignUp']/div[4]/div[3]/table/tbody/tr";
String date_xpathCC ="["+j+"]";
String dateRowxpath_firstAL=dateRowxpathCC.concat(date_xpathCC);
String date_tdCC="/td";
String date_tdvalueCC="["+i+"]";
String dateCC=date_tdCC.concat(date_tdvalueCC);
String datexpath_CompleteCC=dateRowxpath_firstAL.concat(dateCC);
WebElement dateElementCC=driver.findElement(By.xpath(datexpath_CompleteCC));
String date_textCC= dateElementCC.getText();
if(date_textCC.equalsIgnoreCase(arrSplit_ExpiryDateCC[0]))
{
if((dateElementCC.getAttribute("class").contentEquals("day active"))||(dateElementCC.getAttribute("class").contentEquals("day"))||(dateElementCC.getAttribute("class").contentEquals("day new")))
{
dateElementCC.click();
i=8;
j=dtRowsCC.size()+1;
}
}
}
}
return driver;
}


}

