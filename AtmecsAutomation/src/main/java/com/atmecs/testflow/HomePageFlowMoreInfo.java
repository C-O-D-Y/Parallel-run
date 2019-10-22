package com.atmecs.testflow;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.constants.Locators;
import com.atmecs.helpers.WebUtility;

public class HomePageFlowMoreInfo {

	WebDriver driver;
	WebUtility WebUtility;
	Locators locator = new Locators();

	public HomePageFlowMoreInfo(WebDriver driver) {
		this.driver = driver;
		WebUtility = new WebUtility(driver);
	}

	/**
	 * Method used to click to the more Info button in the homepage to maintain the
	 * flow
	 */
	public void clickMoreinfo(int counter) {
		List<WebElement> moreInfo = WebUtility.getElementsList(Locators.getLocators("loc.btn.allMoreInfo"));
		System.out.println("Size is " + moreInfo.size());

		int index = counter;
		System.out.println(Locators.getLocators("loc.btn.moreInfo").replace("xxxx", index + ""));

		WebUtility.scrollByTimeout(Locators.getLocators("loc.btn.moreInfo").replace("xxxx", index + ""));

		if (counter == moreInfo.size()) {
			counter = 0;
		}
	}

	public void clickExploreNow() {

		WebUtility.clickElement(Locators.getLocators("loc.btn.exploreNow"));
		WebUtility.explicitWait(Locators.getLocators("loc.moreInfoBtn.text.breadcrumb"));
		System.out.println("click explore now completed");
	}

	public String getPageTitle(int counter) {
		int index = counter;
		String text = WebUtility.getText(Locators.getLocators("loc.text.pageTitle").replace("xxxx", index + ""));
		return text;
	}
}
