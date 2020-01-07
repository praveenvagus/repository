package praveen_Developing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass_OpenBrowser {
	static WebDriver driver;
	@BeforeClass
	public void Open_Browser() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\jenkins\\workspace\\AmilFreight\\drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://stage.amilfreight.com/");
	driver.manage().window().maximize();
	}
}
