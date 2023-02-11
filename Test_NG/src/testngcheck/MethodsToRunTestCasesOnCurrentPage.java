package testngcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MethodsToRunTestCasesOnCurrentPage extends Assertions {

	public void login(String username, String password) {
		driver.findElement(By.id("Username")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()='Log In']")).click();

	}
	
	public String getPageText(String txt1) {
		WebElement page = driver.findElement(By.xpath("//h4[text()='"+txt1+"']"));
		String pagetext = page.getText();
		return pagetext;
		
		
		
	}

//	public String getBlocksOnDashoards(String text) {
//		WebElement txt = driver.findElement(By.xpath("//h6[text()='"+text+"']"));
//		String gettxt = txt.getText();
//		return gettxt;
//
//	}
	
	public String getBlocksOnDashoards(String entrtxt) {
		WebElement txt = driver.findElement(By.xpath("//h6[text()='"+entrtxt+"']"));
		String gettxt = txt.getText();
		return gettxt;
	}

}
