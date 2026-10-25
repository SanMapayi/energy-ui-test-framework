package com.ensekautomationcandidatetest.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ensekautomationcandidatetest.testCases.BaseClass;

public class getMethods extends BaseClass{

	public static String getText(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {e.getMessage();}
		return element.getText();
	}

	public static String getAttribute(WebElement element, String attribute) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e) {e.getMessage();}
		return element.getAttribute(attribute);

	}
}