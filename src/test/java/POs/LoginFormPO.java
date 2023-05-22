package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO{
		
	By usernameInput = By.id("username");
	By passwordInput = By.id("password");
	By submitButton = By.cssSelector("button");
	By invalidBox = By.id("invalid");
	
	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
	}
	
	public BasePagePO with(String username, String pwd) {
		type(usernameInput, username);
		type(passwordInput, pwd);
		click(submitButton);
		if (getUrl().equals("https://bonigarcia.dev/selenium-webdriver-java/login-form.html"))
			return this;
		else return new LoginSuccessPO(driver);
	}
	
	public boolean invalidBoxIsPresent() {
		return isIn(invalidBox);
	}
}
