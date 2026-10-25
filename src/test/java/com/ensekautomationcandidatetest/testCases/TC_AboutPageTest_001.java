package com.ensekautomationcandidatetest.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ensekautomationcandidatetest.pageObjects.AboutPage;
import com.ensekautomationcandidatetest.pageObjects.LandingPage;


public class TC_AboutPageTest_001 extends BaseClass {

	public LandingPage landingPage;
	public AboutPage aboutPage;

	@BeforeMethod
	public void setUp() throws IOException {

		landingPage = new LandingPage(driver);
		aboutPage = new AboutPage(driver);
		driver.get(baseURL);
		if (landingPage.linkIsBroken("about") == true) {
			landingPage.clickAboutLink("about");
		}

	}

	@Test(priority = 1)
	public void testAboutPageHeader() throws IOException {
		logger.info("testAboutPageHeader");
		String aboutHeadingText = "Learn a little more about us";
		// Can also use AssertEquals for validation.
		if (aboutPage.getAboutHeadingText().equals(aboutHeadingText)) {
			Assert.assertTrue(true);

		} else {
			captureScreen(driver, aboutHeadingText);
			Assert.assertTrue(false);
		}

	}

	@Test (priority = 2)
	public void testFindMoreAboutUsButton() throws IOException {
		logger.info("testFindMoreAboutUsButton");
		String actualText = aboutPage.findOutMoreLink().getText();
		aboutPage.clickFindOutMoreLink(actualText);
	}

	@Test (priority = 3)
	public void testFindButtonText() throws IOException {
		  String actual = aboutPage.getFindOutMoreText();
	        String expected = "Find out more about us ";

	        boolean areEqual = true;
	        try {
	            Assert.assertEquals(actual, expected);
	            logger.info("Text comparison passed! for " + expected);
	        } catch (AssertionError e) {
	            areEqual = false;
	        }
	        Assert.assertTrue(areEqual);
	        if (!areEqual) {
	        	captureScreen(driver, expected);
	        	logger.info("Text comparison failed! for " + expected);
	        }

	        System.out.println("Are values equal? " + areEqual);
	    }
	}


