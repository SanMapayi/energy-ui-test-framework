package com.ensekautomationcandidatetest.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ensekautomationcandidatetest.pageObjects.LandingPage;


public class TC_LandingPageTest_001 extends BaseClass{
	public LandingPage landingPage;

	@BeforeMethod
	public void setUp() {

		landingPage = new LandingPage(driver);
		driver.get(baseURL);
	}

	@Test(priority = 1)
	public void landingPageTest() throws IOException {

		if (driver.getTitle().equals("ENSEK Energy Corp. - Candidate Testss")) {
			Assert.assertTrue(true);
			logger.info("The user lands on the Home page");
		} else {
			captureScreen(driver, "PageTiteIsNotCorrectdddd");
			Assert.assertTrue(false);
			logger.info("The Homepage is not opened");

		}

	}

	@Test(priority = 2)

	public void getPageTitleTest() throws IOException {
		/***Tests to check if all links on the Homepage is active.
		The link is broken returns a boolean, this can be used to check for active links,
		Also the click{link} function can also checks if element is visible,
		 and then performs the click function e.g Landing.clickAboutLink. ***/
		landingPage.linkIsBroken("About");
		landingPage.clickAboutLink("About");
		landingPage.linkIsBroken("Home");
		landingPage.clickHomeLink();
		landingPage.linkIsBroken("Contact");
		landingPage.clickGetContactLink();
		landingPage.linkIsBroken("Register");
		landingPage.clickRegisterLink();
		landingPage.linkIsBroken("Login");
		landingPage.clickLoginLink();

	}


}
