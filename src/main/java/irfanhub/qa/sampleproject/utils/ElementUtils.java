package irfanhub.qa.sampleproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementUtils {

	private WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sendkeys(By locator, String value) {
		 driver.findElement(locator).sendKeys(value);

	}
	public void click(By locator) {
		driver.findElement(locator).click();

	}
	public void close() {
		driver.quit();

	}
}
