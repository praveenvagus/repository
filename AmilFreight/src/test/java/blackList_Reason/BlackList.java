package blackList_Reason;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import locators_Amil.BlackList_Locators;
import utility_Files.BaseClass;

public class BlackList extends BaseClass
{
	public BlackList(WebDriver driver) {
		super(driver);
		}

	@Test
	public static void BlackList_Arul(String sTestCaseName) throws InterruptedException {

		
		Thread.sleep(9000);
		driver.navigate().to("http://stage.amilfreight.com/carrier/list");
		Thread.sleep(2000);
		BlackList_Locators.Search_carrierName().sendKeys("BOBBY TRANSPORT INC");
		BlackList_Locators.Search_carrierName().click();
		Thread.sleep(2000);
		BlackList_Locators.profile().click();
		String parentWinHandle = driver.getWindowHandle();
		System.out.println(parentWinHandle);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		System.out.println(tabs);
		Thread.sleep(2000);
		BlackList_Locators.Click_BlackList().click();
		Thread.sleep(2000);
		Select Reason =new Select (BlackList_Locators.Black_List_reason());
		Reason.selectByVisibleText("Communication");
		BlackList_Locators.Comments().sendKeys("Praveen Raja Sonnaru");
		BlackList_Locators.movetoBlacklist().click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//span[@class='badge bg-danger']"));
		Actions action = new Actions(driver);
		 action.moveToElement(ele).build().perform();
		 WebElement toolTipEle = driver.findElement(By.xpath("//div[@class=\"tooltip-dark showonhover tt-before ng-binding\"]"));
		 String toolTipTxt = toolTipEle.getAttribute("innerText");
		 System.out.println(toolTipTxt);
		 Assert.assertEquals("Reason : Communication\n" + "Comments :Praveen Raja Sonnaru", toolTipTxt);
		 Thread.sleep(2000);
		 //---------------------------------Carrier CRM-----------------------------------------------
		 driver.navigate().to("http://stage.amilfreight.com/crm/sales/carrier-opt-v2");
		 Thread.sleep(3000);
		 BlackList_Locators.CRM_filter().click();
		 BlackList_Locators.CRM_Search_CompanyNAme().sendKeys("BOBBY TRANSPORT INC");
		 BlackList_Locators.CRM_Click_Filter().click();
		 BlackList_Locators.CRM_move_Tab().click();
		 Thread.sleep(2000);
		WebElement ele1= driver.findElement(By.xpath("//span[@class='badge bg-danger']"));
		 action.moveToElement(ele1).build().perform();
		 WebElement toolTipEle1= driver.findElement(By.xpath("//span[@class='tooltip-dark showonhover ng-binding']"));
		 String toolTipTxt1 = toolTipEle1.getAttribute("innerText");
		 System.out.println(toolTipTxt1);
		 Assert.assertEquals("Reason : Communication\n" + "Comments: Praveen Raja Sonnaru", toolTipTxt1);
	}
}

