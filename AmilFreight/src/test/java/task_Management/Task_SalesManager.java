package task_Management;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility_Files.BaseClass;

public class Task_SalesManager extends BaseClass {

public Task_SalesManager(WebDriver driver) {
super(driver);
}

@Test
public static void Task_Manager(String sTestCaseName) throws Exception
{
	
driver.navigate().to("http://test.amilfreight.com/crm/TaskManagement/SalesDashboard");
Thread.sleep(7500);
//List<WebElement> TaskList=driver.findElements(By.xpath("//*[@id='accordion-control']/div"));
List<WebElement> TaskList=driver.findElements(By.xpath("//*[@id='accordion-control']/div/div[1]/div[2]/h4"));

System.out.println(TaskList.size());
driver.findElement(By.xpath("//*[@id='accordion-control']/div/div[1]/div[2]/h4")).click();

for(int i=0;i<TaskList.size();i++) {
System.out.println(TaskList.get(i).getText());
}

//driver.close();

/*
for(int i=1;i<TaskList.size();i++) {
	
WebElement UpArrow=driver.findElement(By.xpath("//*[@id='accordion-control']/div["+i+"]/div[1]/div[3]/a/i[2]"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click()", UpArrow);
System.out.println("Praveen");
//$x("//*[contains(text(),'New Calls')]/parent::div/parent::div[1]/div[3]/a/i[2]")
//$x("//*[@id='accordion-control']/div/div[1]/div[2]/h4")
}
*/
}
}