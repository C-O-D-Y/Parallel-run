package com.atmecs.testflow;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;

import com.atmecs.constants.Locators;
import com.atmecs.helpers.WebUtility;

/**
 * class used to maintain the flow of the homepage of the Atmecs.com
 */
public class HomePageFlow {

	WebDriver driver;
	Locators locaters = new Locators();
	WebUtility WebUtility;

	public HomePageFlow(WebDriver driver) {
		this.driver = driver;
		WebUtility = new WebUtility(driver);
	}

	/**
	 * Method used to click to the header and to the anchors to maintain the flow
	 */
	public void clickHeader(String header) throws InterruptedException {
		BasicConfigurator.configure();
		System.out.println(Locators.getLocators("loc.btns.Header").replace("[xxxx]", header));
		WebUtility.clickElement(Locators.getLocators("loc.btns.Header").replace("[xxxx]", header));
	}

	/**
	 * Method used to click to the Services header and to the digital life anchor to
	 * maintain the flow
	 */
	public void clickServices() {
		WebUtility.action(Locators.getLocators("loc.btn.services"));
		WebUtility.action(Locators.getLocators("loc.btn.digitalLife"));
	}

	/**
	 * Method used to click to the Services header and to infrastructure anchor to
	 * maintain the flow
	 */
	public void clickInfra() {
		WebUtility.action(Locators.getLocators("loc.btn.services"));
		WebUtility.action(Locators.getLocators("loc.btns.infrastructureServics"));
	}
}
