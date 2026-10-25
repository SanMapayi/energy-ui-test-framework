package com.ensekautomationcandidatetest.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ensekautomationcandidatetest.Utilities.ActionMethods;
import com.ensekautomationcandidatetest.testCases.BaseClass;



public class LoginPage extends BaseClass {



	public LoginPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	@FindBy(id="password")
	@CacheLookup
	public WebElement txtPassword;


	@FindBy(id="username")
	@CacheLookup
	public WebElement txtUserName;

	@FindBy(css="div input.btn.btn-default")
	@CacheLookup
	public WebElement btnLogin;

	@FindBy(id ="rememberMe")
	public WebElement rememberMe;




	public void setUserName(String username)
	{
		ActionMethods.enterText(txtUserName, username);

	}
	public void setPassword(String password) {
		ActionMethods.enterText(txtPassword,password);
	}

	public void clickSigninButton() throws IOException {
		ActionMethods.click(btnLogin, baseURL);
		logger.info("The login button is clicked");
	}




	public void login(String username, String company, String password) throws IOException {
		setUserName(username);
		setPassword(password);
		clickSigninButton();

	}


}
