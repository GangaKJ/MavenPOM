package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
	
	private WebDriver driver;
	
	//Locators ---rules/strategy
	private By usernameField=By.id("username");
	private By passwordField=By.id("password");
	private By submitBtn=By.id("submit");
	private By successmsg=By.xpath("//h1[@class='post-title']");
	private By errormsg=By.id("error");
	
	
	//Constructor
	public LoginPageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Atomic actions as methods
	public void enterUsername(String uname)
	{
		driver.findElement(usernameField).sendKeys(uname);
	}
	public void enterPassword(String pwd)
	{
		driver.findElement(passwordField).sendKeys(pwd);
	}
	public void clickSubmitBtn()
	{
		driver.findElement(submitBtn).click();
	}
	
	//Business methods
	public void login(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		clickSubmitBtn();	
	}
	
	public String getSuccessMessage()
	{
		return driver.findElement(successmsg).getText();
		
	}
	
	public String getErrorMessage()
	{
		return driver.findElement(errormsg).getText();
	}

}
