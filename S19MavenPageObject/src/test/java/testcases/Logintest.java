package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.LoginPageObject;

public class Logintest extends BaseTest{
	
	@Test
	public void validLogin()
	{
		LoginPageObject lp=new LoginPageObject(driver);
		lp.login("student", "Password123");
		
		// Capture expected text
		String expected="Logged In Successfully";
		//
		String actual=lp.getSuccessMessage();
		//hard assert 
		Assert.assertEquals(actual, expected," Validation failed");
	}
	
	@Test
	public void invalidUsername()
	{
		LoginPageObject lp=new LoginPageObject(driver);
		lp.login("stude", "Password123");
		
		String expected="Your username is invalid!";
		String actual=lp.getErrorMessage();
		
		Assert.assertEquals(actual, expected," Validation failed");
	}

}
