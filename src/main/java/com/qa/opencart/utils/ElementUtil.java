package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present on the page");
			e.printStackTrace();
			return null;
		}
		return element;
	}

	public boolean elementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public boolean isElementExists(By locator) {
		if(getElements(locator).size()==1) {
			return true;
		}return false;
	}

	public boolean multipleElementExists(By locator) {
		if(getElements(locator).size()>= 1) {
			return true;
		}return false;
	}
	
	public void doSendKeys(By locator, String sendvalue) {
		getElement(locator).sendKeys(sendvalue);
	}

	public void doSendKeys(String locatortype, String locatorvalue, String sendvalue) {
		getElement(locatortype, locatorvalue).sendKeys(sendvalue);
	}

	public void doClick(By locatortype) {
		getElement(locatortype).click();
	}

	public String getText(By locatortype) {
		String value = getElement(locatortype).getText();
		return value;
	}

	public String getAttribute(By locator, String sendvalue) {
		return getElement(locator).getAttribute(sendvalue);
	}

	public By getBy(String locatortype, String locatorValue) {
		By locator = null;

		switch (locatortype.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.name(locatorValue);
			break;
		case "xpath":
			locator = By.name(locatorValue);
			break;
		case "linktext":
			locator = By.name(locatorValue);
			break;
		}
		return locator;
	}

	public WebElement getElement(String locatortype, String locatorvalue) {
		return driver.findElement(getBy(locatortype, locatorvalue));
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}
}
