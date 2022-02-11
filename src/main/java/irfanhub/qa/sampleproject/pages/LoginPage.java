package irfanhub.qa.sampleproject.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import irfanhub.qa.sampleproject.factory.DriverFactory;
import irfanhub.qa.sampleproject.utils.ElementUtils;

/*
  	1. By locator
 	2. Constructor //should be same as class name
	3. Page Actions
*/
public class LoginPage {

	private By LoginName = 	By.xpath("//input[@id='userName']");
	private By Password = By.xpath("//input[@id='password']");
	private By Login = By.xpath("//button[@id='login']");
	
	private WebDriver driver;
	private ElementUtils elementsutil;
	private Properties prop;
	private DriverFactory driverfactory;
	
	
	public  LoginPage(WebDriver driver) throws IOException  {
		this.driver= driver;
		driverfactory= new DriverFactory();
		prop= driverfactory.init_prop();
		elementsutil= new ElementUtils(this.driver);
	}
	
	public void verifylogin() {
		elementsutil.sendkeys(LoginName,prop.getProperty("username"));
		elementsutil.sendkeys(Password,prop.getProperty("password"));
		elementsutil.click(Login);
		

	}
	public void close() {
		
		elementsutil.close();
	
	}
	
	

	
	
	
	
}
