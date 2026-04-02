package test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {

	protected WebDriver driver;
	private static String chromeBinaryPath;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager wdm = WebDriverManager.chromedriver();
		chromeBinaryPath = System.getenv("CHROME_PATH");
		if (chromeBinaryPath != null && !chromeBinaryPath.isEmpty()) {
			wdm.browserBinary(chromeBinaryPath);
		}
		wdm.setup();
	}

	@BeforeEach
	public void beforeEach() {
		ChromeOptions options = new ChromeOptions();
		if (chromeBinaryPath != null && !chromeBinaryPath.isEmpty()) {
			options.setBinary(chromeBinaryPath);
		}
		options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterEach
	public void afterEach() {
		if (driver != null) {
			driver.quit();
		}
	}
}