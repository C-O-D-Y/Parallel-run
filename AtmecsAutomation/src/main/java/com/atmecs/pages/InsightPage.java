package com.atmecs.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.helpers.WebUtility;
import com.atmecs.testflow.BlogPageFlow;

/**
 * Class validates the insights-Blogs page with different functionality of the
 * buttons and anchors
 */
public class InsightPage {
	public InsightPage(WebDriver driver) {
		data = new ValidatingData();
		WebUtility = new WebUtility(driver);
		blog = new BlogPageFlow(driver);
	}

	Locators loc = new Locators();
	ValidatingData data;
	WebUtility WebUtility;
	BlogPageFlow blog;

	/**
	 * Method validates the content is present inside the blog or not
	 */
	public void validateContent() {

		String text = WebUtility.getText(Locators.getLocators("loc.content.txt"));
		Assert.assertEquals(text, (data.getValidatingData("content")), "Content is not present");
	}

	/**
	 * Method validates the date difference between blog posting date and system
	 * date is 3 months old or not.
	 */
	public void validateDateDifference() {
		int dateDifference = blog.getDate();
		Assert.assertFalse(dateDifference < 3);

	}

	/**
	 * Method validates the title of the blog.
	 */
	public void validateBlogTitle() {

		String title = WebUtility.getText(Locators.getLocators("loc.title.blog"));

		Assert.assertEquals(title, data.getValidatingData("Blog_Title"), "Not landed on a right page");
	}

	/**
	 * Method validates the breadcrumbs in the blog.
	 */
	public void validateBreadcrumb() {
		String breadCrumb1 = WebUtility.getText(Locators.getLocators("loc.btn.breadcrumb1"));
		Assert.assertEquals(breadCrumb1, data.getValidatingData("breadcrumb1"), "Incorrect order of the breadcrumb");
		String breadCrumb2 = WebUtility.getText(Locators.getLocators("loc.btn.breadcrumb2"));
		Assert.assertEquals(breadCrumb2, data.getValidatingData("breadcrumb2"), "Incorrect order of the breadcrumb");

	}

	/**
	 * Method validates the breadcrumbs in the blog.
	 */
	public void ValidateErrorMsg() {

		String required = WebUtility.getAttribute(Locators.getLocators("loc.hidden.msg"), "required");
		Assert.assertEquals(required, data.getValidatingData("commentAlert"), "Error msg functionality not correct");
	}
}
