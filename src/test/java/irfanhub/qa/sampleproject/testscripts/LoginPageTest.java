package irfanhub.qa.sampleproject.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import irfanhub.qa.sampleproject.factory.DriverFactory;
import irfanhub.qa.sampleproject.pages.LoginPage;
import irfanhub.qa.sampleproject.utils.ElementUtils;

public class LoginPageTest {
	
DriverFactory driverfactory;
Properties prop;
LoginPage loginElement;
WebDriver driver;
ElementUtils elementUtils;

	@BeforeTest
	public void setup() throws IOException {
		driverfactory= new DriverFactory();
		prop= driverfactory.init_prop();
		driver= driverfactory.init_driver(prop);
		//System.out.println(driver);
		
	}
	
	
	@Test(description = "ValidateTitlePage")
	public void validateTitle() throws IOException {
		loginElement = new LoginPage(this.driver);
		loginElement.verifylogin();
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "ToolsQA");
	}
	
	@AfterTest
	public void close() {
		loginElement.close();

	}
}
