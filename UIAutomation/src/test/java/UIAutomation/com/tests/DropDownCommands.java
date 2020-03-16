package UIAutomation.com.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*Handaling DropDowns in Selenium:

1.The 'Select' class in Selenium WebDriver is used for selecting and deselecting option in a dropdown.

2.The objects of Select type can be initialized by passing the dropdown webElement as parameter to its constructor.

     WebElement testDropDown = driver.findElement(By.id("testingDropdown"));  
     Select dropdown = new Select(testDropDown); 

3.WebDriver provides three ways to select an option from the drop-down menu.

  a)selectByIndex - It is used to select an option based on its index, beginning with 0.	 
     
	    dropdown.selectByIndex(5);  
	
  b)selectByValue - It is used to select an option based on its 'value' attribute.
  
        dropdown.selectByValue("continents");
		
  c) selectByVisibleText - It is used to select an option based on the text over the option.
  
        dropdown.selectByVisibleText("Europe"); 
   
*/

public class DropDownCommands {

	public WebDriver driver;

	@BeforeTest
	public void start() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\Grid\\chromedriver_win32\\chromedriver.exe");
		// Create a new instance of the ChromeDriver driver
		driver = new ChromeDriver();
		// Launch the URL
		driver.navigate().to("https://demoqa.com/automation-practice-form/");
		// Maximize the window
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void dropdownoption() throws InterruptedException {

		// Step 3: Select 'Continents' Drop down ( Use Id to identify the
		// element )
		// Find Select element of "Single selection" using ID locator.
		Select selectopt = new Select(driver.findElement(By.id("continents")));

		// Step 4:) Select option 'Europe' (Use selectByIndex)
		selectopt.selectByVisibleText("Europe");

		// Using sleep command so that changes can be noticed
		Thread.sleep(2000);

		// Step 5: Select option 'Africa' now (Use selectByVisibleText)
		selectopt.selectByIndex(2);
		Thread.sleep(2000);

		// Step 6: Print all the options for the selected drop down and select
		// one option of your choice
		// Get the size of the Select element
		List<WebElement> optSize = selectopt.getOptions();
		int iListSize = optSize.size();

		// Setting up the loop to print all the options
		for (int i = 0; i < iListSize; i++) {
			// Storing the value of the option
			String sValue = selectopt.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal
			// to 'Africa" then select it
			if (sValue.equals("Africa")) {
				selectopt.selectByIndex(i);
				break;
			}

		}
	}

	@AfterTest
	public void testB() {

		driver.quit();

	}

}
