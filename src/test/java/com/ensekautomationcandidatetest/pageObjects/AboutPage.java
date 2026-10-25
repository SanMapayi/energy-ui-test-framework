package com.ensekautomationcandidatetest.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ensekautomationcandidatetest.Utilities.ActionMethods;
import com.ensekautomationcandidatetest.Utilities.getMethods;
import com.ensekautomationcandidatetest.testCases.BaseClass;

public class AboutPage extends BaseClass{


	public AboutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "About")
	private WebElement aboutLink;

	@FindBy(xpath = "//h3[@xpath='1']")
    private WebElement aboutHeading;

	@FindBy(className = "btn-primary")
	private WebElement findOutMoreLink;


	public WebElement getAboutLink() {
		return aboutLink;
	}

	public WebElement findOutMoreLink() {
		return findOutMoreLink;
	}

	public String getAboutHeadingText() {
		return getMethods.getText(aboutHeading);
    }

	  public void clickFindOutMoreLink(String featureName) throws IOException {
		  ActionMethods.click(aboutHeading, featureName);

	    }

	  public String getFindOutMoreText() {
		  return getMethods.getText(findOutMoreLink());
	  }




}
