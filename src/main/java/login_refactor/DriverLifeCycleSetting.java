package login_refactor;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLifeCycleSetting {
	
	protected WebDriver driver;
	
	@BeforeAll
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "library/chromedriver");
	}
	
	@BeforeEach
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterEach
	void teardown() {
		//close the browser
		if (driver != null) {
			driver.quit();
		}
	}

}
