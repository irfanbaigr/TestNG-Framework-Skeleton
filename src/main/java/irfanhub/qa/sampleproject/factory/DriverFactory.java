package irfanhub.qa.sampleproject.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
	1.init_prop
	2.init_driver
*/
public class DriverFactory {
	
	private WebDriver driver;
	private Properties prop;
	
	public Properties init_prop() throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/configuration/config.properties");
		prop =new Properties();
		prop.load(fis);
		return prop;
	}
	
	public WebDriver init_driver(Properties prop) {
		String browser =prop.getProperty("browser");
		String url= prop.getProperty("url");
		
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(); 
			
			break;
			default:
				System.out.println("Enter correct browser");
			break;
		}
		driver.get(url);
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
		
	
}
