package com.ensekautomationcandidatetest.pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ensekautomationcandidatetest.Utilities.ActionMethods;
import com.ensekautomationcandidatetest.testCases.BaseClass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LandingPage extends BaseClass {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "a")
	private List<WebElement> anchorElements;

	@FindBy(linkText = "Home")
	private WebElement homeLink;

	@FindBy(partialLinkText = "About")
	private WebElement aboutLink;

	@FindBy(partialLinkText = "Contact")
	private WebElement contactLink;

	@FindBy(id = "registerLink")
	private WebElement registerLink;

	@FindBy(id = "loginLink")
	private WebElement loginLink;

	public List<WebElement> getAnchorElements() {
		return anchorElements;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getAboutLink() {
		return aboutLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public void clickHomeLink() {
		homeLink.click();
	}

	public void clickAboutLink(String featureName) throws IOException {
		ActionMethods.click(aboutLink, featureName);
		logger.info("About link is clicked");
	}

	public void clickGetContactLink() {
		contactLink.click();
		logger.info("Contact link is clicked");
	}

	public void clickRegisterLink() {
		registerLink.click();
		logger.info("Register link is clicked");
	}

	public void clickLoginLink() {
		loginLink.click();
		logger.info("Login link is clicked");
	}

	public String getLinkHref(WebElement webElement) {
		return webElement.getAttribute("href");
	}

	private boolean isLinkValid(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			connection.disconnect();
			return responseCode == HttpURLConnection.HTTP_OK;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean linkIsBroken(String linkName) throws IOException {
		WebElement webElement = null;
		switch (linkName.toLowerCase()) {
		case "home":
			webElement = getHomeLink();
			break;
		case "about":
			webElement = getAboutLink();
			break;
		case "contact":
			webElement = getContactLink();
			break;
		case "register":
			webElement = getRegisterLink();
			break;
		case "login":
			webElement = getLoginLink();
			break;
		default:
			webElement = null;
			break;
		}

		String linkUrl = getLinkHref(webElement);
		boolean isLinkBroken = !isLinkValid(linkUrl);

		if (isLinkBroken) {
			System.out.printf("The %s link is broken.%n", linkName);
			String screenshotmessage = linkName + "IsBroken";
			captureScreen(driver, screenshotmessage);
			Assert.assertTrue(isLinkBroken);
			logger.info("The link is broken");
		} else {
			System.out.printf("The %s link is valid.%n", linkName);
			Assert.assertTrue(!isLinkBroken);
			logger.info("The link is present");
			return true;
		}
		return false;
	}

}
