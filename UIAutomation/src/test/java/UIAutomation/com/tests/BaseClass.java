package UIAutomation.com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseClass {
	public DesiredCapabilities desiredcapabilities ;
	public static WebDriver driver;
		
	@BeforeTest
	@Parameters({"browser","gridUrl"})
	public void init(@Optional("chrome")String browser,@Optional("http://localhost:4444")String gridUrl) throws MalformedURLException{
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certification-errors");
			options.addArguments("--disable-popup-blocking");
			desiredcapabilities = DesiredCapabilities.chrome();
			desiredcapabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(gridUrl),desiredcapabilities);
			driver.navigate().to("https://yahoo.com");
			
		}else if (browser.equalsIgnoreCase("firefox")) {
			
		}else if (browser.equalsIgnoreCase("ie")) {
			
		}
		
	}
	
	@AfterTest
	public void quit() {
		driver.close();
	}

}
