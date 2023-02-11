package testngcheck;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {

	public static WebDriver driver;
	static String url = "http://dthahab.com/Account/Login";

	@BeforeTest(alwaysRun = true, groups = "sanity,regression")
	public void browserInit() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://dthahab.com/Account/Login");
		driver.manage().window().maximize();
	}

	@Test(priority = 1, groups = "sanity")
	public void verifyUrlOfPage() {
		String verifyurl = driver.getCurrentUrl();
		SoftAssert softassrt = new SoftAssert();
		softassrt.assertEquals(verifyurl, url, "verfying url of page");
		System.out.println("Next line after softassert");
		softassrt.assertAll();
	}

	@Test(priority = -1, groups = "regression")
	public void verifyTitleofPage() {
		String verifytitle = driver.getTitle();
		SoftAssert softassrt = new SoftAssert();
		softassrt.assertEquals(verifytitle, "Login | Dthahab", "verifying title");
		System.out.println("Next line after verify title");
		softassrt.assertAll();
	}

	@Test(priority = 2, groups = "regression")
	public void verifyDashboardAfterLogin() {
		MethodsToRunTestCasesOnCurrentPage c = new MethodsToRunTestCasesOnCurrentPage();
		c.login("VELOCITY", "VELOCITY123");
		String txt = c.getPageText("Dashboard");
		Assert.assertEquals(txt, "Dashboard", "Varifying page text");
	}

	@Test(priority = 3, dependsOnMethods = "verifyDashboardAfterLogin", groups = "regression")
	public void verifydashboardBlocks() {
		MethodsToRunTestCasesOnCurrentPage c = new MethodsToRunTestCasesOnCurrentPage();
		String text1 = c.getBlocksOnDashoards("Orders");
		String text2 = c.getBlocksOnDashoards("Revenue");
		String text3 = c.getBlocksOnDashoards("Average Price");
		String text4 = c.getBlocksOnDashoards("Product Sold");
		Assert.assertEquals(text1, "ORDERS", "Veryfying page block");
		Assert.assertEquals(text2, "REVENUE", "Veryfying page block");
		Assert.assertEquals(text3, "AVERAGE PRICE", "Veryfying page block");
		Assert.assertEquals(text4, "PRODUCT SOLD", "Veryfying page block");

	}

	@AfterTest(alwaysRun = true, groups = "sanity,regression")
	void tearDown() {
		driver.quit();
	}

}
