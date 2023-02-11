package testngcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckProject {
	public static WebDriver driver;
	static String url="http://dthahab.com/Account/Login";
	
	@BeforeTest
	public void browserInit() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dthahab.com/Account/Login");
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 1, groups="regression")
	public void verifyUrlOfPage() {
		String verifyurl = driver.getCurrentUrl();
		Assert.assertEquals(verifyurl, false);
		System.out.println("Next line after url");
	}

	@Test(priority = -1, groups="regression")
	public void verifyTitleofPage() {
		String verifytitle = driver.getTitle();
		Assert.assertEquals(verifytitle, "Login | Dthahab","verifying title");
	}
	
}
