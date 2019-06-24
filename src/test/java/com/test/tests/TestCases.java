package com.test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author sharikavadavat
 *
 */

public class TestCases extends ClassVariables {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void launchBrowser() {

		try {

			driver = config.driverSetUp();
			wait = new WebDriverWait(driver, 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method logs into the application
	 */
	public void load() throws InterruptedException {

		/* Logging into the application using pop-up url */
		driver.get(ClassVariables.authorURL);
		Reporter.log("URL was launched successfully");

	}

	/**
	 * This is the test case method that runs through the test case steps -
	 * Identified through keyword 'Test'
	 */
	@Test
	public void verifyQuote() {

		try {

			load();
			verifyNewQuoteAddition();

			Reporter.log("Verification of Quote and Author was completed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	@Test
	public void verifyBrowserAlertQuote() {

		try {

			load();
			verifyBrowserAlertAuthorAddition();

			Reporter.log("Verification of Browser Alert was completed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method adds a new author and quote
	 */
	public void verifyNewQuoteAddition() {


		try {
			
			addNewQuote();
			Reporter.log("New Quote and Author was added successfully");

		}

		catch (Exception e) {

			Reporter.log("New Quote and Author was not added successfully");
		}

	}
	
	public void verifyBrowserAlertAuthorAddition() {
		try {
		
			
			
			addNewQuote();
			addNewQuote();
			driver.switchTo().alert(); 
			
			Reporter.log("New Quote and Author was added successfully");


		}

		catch (Exception e) {

			Reporter.log("Browser alert was not present");
		}

	}

	/**
	 * This method adds a new quote
	 */
	public void addNewQuote() {

		try {

			WebElement quoteAdd = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.quoteAddSelector)));
			quoteAdd.click();

			WebElement authorSelect = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.newAuthor)));
			authorSelect.sendKeys(newAuthorInput);
			
			WebElement quoteSelect = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.newQuote)));
			quoteSelect.sendKeys(newQuoteInput);
			
			WebElement quoteSuccess = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.quoteSuccess)));
			quoteSuccess.click();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterTest
	public void terminateBrowser() throws InterruptedException {

		config.driverTerminate();
	}
}
