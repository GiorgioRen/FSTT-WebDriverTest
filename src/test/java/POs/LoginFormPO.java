package POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFormPO extends BasePagePO {

	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password");
	private By submitButton = By.cssSelector("button");
	private By invalidBox = By.id("invalid");

	private static final String LOGIN_URL = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";

	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit(LOGIN_URL);
	}

	public BasePagePO with(String username, String pwd) {
		type(usernameInput, username);
		type(passwordInput, pwd);
		click(submitButton);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.or(
			ExpectedConditions.not(ExpectedConditions.urlToBe(LOGIN_URL)),
			ExpectedConditions.visibilityOfElementLocated(invalidBox)
		));
		if (getUrl().equals(LOGIN_URL))
			return this;
		else
			return new LoginSuccessPO(driver);
	}

	public boolean invalidBoxIsPresent() {
		return isIn(invalidBox);
	}
}