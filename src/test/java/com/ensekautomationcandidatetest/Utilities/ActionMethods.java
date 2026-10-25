package com.ensekautomationcandidatetest.Utilities;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ensekautomationcandidatetest.testCases.BaseClass;



public class ActionMethods extends BaseClass {


	public static void enterText(WebElement element, String value)
	{
		try {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		logger.info(value +" "+ "is Entered");
		}

		catch (Exception e){e.getMessage();
		}

	}

	public static void click(WebElement element, String featureName) throws IOException {
	if (isDisplayed(element) == true) {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		logger.info("A click function is performed");
		return;
		}
		catch (Exception e) {System.out.println(e.getMessage());}
	}
		captureScreen(driver, featureName);
	}

	private static boolean isDisplayed(WebElement element)
	{
		try {
		wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return element.isDisplayed();
		}

	}
	public static void SelectElement(WebElement element, String Value)
	{
		 new Select(element).selectByValue(Value);
	}

	public static ExpectedCondition<Boolean> visibilityofElement(final WebElement element){
		return  new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					logger.info("The element is displayed");
				return element.isDisplayed();
				} catch (NoSuchElementException e) {
					System.out.println("No Such element here!");
					return false;}
					catch (StaleElementReferenceException el) {
						return false;
					}
			}
		};

	}
	public static ExpectedCondition<Boolean> wait(final boolean condition){
		return  new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return condition;
				}

		};

	}
}
