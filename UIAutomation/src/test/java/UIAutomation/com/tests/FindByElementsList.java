package UIAutomation.com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;import org.testng.annotations.Test;

/*FindElements in Selenium:

1. A command used to identify a list of web elements within the web page.

2. The findElements command returns an empty list if there are no elements found using the given locator strategy and locator value.Below is the syntax of findElements command.

3. List<WebElement>elementName=driver.findElements(By.LocatorStrategy("LocatorValue"));

4. Example:List<WebElement>listOfElements=driver.findElements(By.xpath("//div"));
*/

public class FindByElementsList {

	public WebDriver driver;

	@BeforeTest
	public void start() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://yahoo.com");
		// Maximize the window
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void listWebElements() throws InterruptedException {
		// Here, objLinks is a list of WebElements (List of ancher tags)
		List<WebElement> objLinks = driver.findElements(By.tagName("a"));
		// Returns the total no. of web elements with anchor tag(a)
		System.out.println(objLinks.size());

		// here, objeCurrentLink is the current WebElement
		for (WebElement objcurrentlink : objLinks) {

			// Here,getText() returns the innerText of the WebElement , lets
			// store it in a String called 'sstringtext'
			String stringLinkText = objcurrentlink.getText();

			// Print the List of WebElements
			System.out.println(stringLinkText);

			Thread.sleep(2000);
		}

	}

	@AfterTest
	public void testB() {

		driver.quit();

	}

}
