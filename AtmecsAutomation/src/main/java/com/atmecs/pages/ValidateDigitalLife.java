package com.atmecs.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.helpers.WebUtility;

public class ValidateDigitalLife {
	public ValidateDigitalLife(WebDriver driver) {
		home = new HomePage(driver);
		data = new ValidatingData();
		WebUtility = new WebUtility(driver);
	}

	Logger log;
	Locators locators = new Locators();
	HomePage home;
	ValidatingData data;
	WebUtility WebUtility;

	/**
	 * Methods used to validate the anchors present in the headers
	 * 
	 * @param anchor
	 */
	public void ValidateAnchors(String anchor) {
		String text = WebUtility.getText(Locators.getLocators("loc.btns.footerTags").replace("[xxxx]", anchor));
		System.out.println(text);
		Assert.assertEquals(text, anchor, "anchor is not present");
	}
}
