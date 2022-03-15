package task_Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility_Files.BaseClass;

public class Task_Locators extends BaseClass
{
public Task_Locators(WebDriver driver) {
super(driver);
}
private static WebElement element = null;

public static WebElement AddTask_Button() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@ng-click='ShowTaskPopup()']"));}
catch (Exception e)
{System.out.println("AddTask_Button not available");
throw(e);}
return element;}

public static WebElement Subject_TextBox() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@type='text' and @id='subject']"));}
catch (Exception e)
{System.out.println("Subject_TextBox not available");
throw(e);}
return element;}

public static WebElement Task_Type() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@id='tasktype']"));}
catch (Exception e)
{System.out.println("Task_Type not available");
throw(e);}
return element;}

public static WebElement Priority() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@id='prioritytype']"));}
catch (Exception e)
{System.out.println("Priority not available");
throw(e);}
return element;}

public static WebElement Due_Date() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@ng-model='DueDate']"));}
catch (Exception e)
{System.out.println("Due_Date not available");
throw(e);}
return element;}

public static WebElement Shipper() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@id='txtAccountName']"));}
catch (Exception e)
{System.out.println("Shipper not available");
throw(e);}
return element;}

public static WebElement Description() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@ng-model='Description']"));}
catch (Exception e)
{System.out.println("Description not available");
throw(e);}
return element;}

public static WebElement AssignedTo() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@ng-model='salesrep']"));}
catch (Exception e)
{System.out.println("AssignedTo not available");
throw(e);}
return element;}

public static WebElement Submit_Button() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@ng-click='SaveTask()']"));}
catch (Exception e)
{System.out.println("Submit_Button not available");
throw(e);}
return element;}

public static WebElement Clear_Button() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@ng-click='Clear()']"));}
catch (Exception e)
{System.out.println("Clear_Button not available");
throw(e);}
return element;}

public static WebElement Alert_Message() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@class='msgul'][2]"));}
catch (Exception e)
{System.out.println("Alert_Message icon not available");
throw(e);}
return element;}

public static WebElement OK_AlertButton() throws Exception{
try{ 
element = driver.findElement(By.xpath("//*[@id='btnNotiFyOk']"));}
catch (Exception e)
{System.out.println("OK_AlertButton icon not available");
throw(e);}
return element;}
	
}

