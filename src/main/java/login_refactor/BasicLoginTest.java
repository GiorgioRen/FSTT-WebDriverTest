package login_refactor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.LoginFormPO;
import POs.LoginSuccessPO;

public class BasicLoginTest extends DriverLifeCycleSetting {
	
	private LoginFormPO login;
	private LoginSuccessPO loginSuccess;
		
	@Test
	public void testLoginOK() throws InterruptedException {	 
		login = new LoginFormPO(driver);
		loginSuccess = (LoginSuccessPO) login.with("user", "user");
		assertTrue(loginSuccess.successBoxIsPresent());
	}
	
	@Test
	public void testLoginNoOK() {
		login = new LoginFormPO(driver);
		login.with("user", "error");
		assertTrue(login.invalidBoxIsPresent());
	}

}
