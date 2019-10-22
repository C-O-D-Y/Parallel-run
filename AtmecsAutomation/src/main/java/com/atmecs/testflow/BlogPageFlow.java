package com.atmecs.testflow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import com.atmecs.constants.Locators;
import com.atmecs.helpers.WebUtility;

/**
 * Class maintain the flow of the test to the second page by clicking in the
 * blogs anchor
 */
public class BlogPageFlow {

	WebUtility WebUtility;
	WebDriver driver;

	public BlogPageFlow(WebDriver driver) {
		WebUtility = new WebUtility(driver);
		this.driver = driver;
	}

	/**
	 * Method click on the header insights ---> Blogs and then the blog img
	 */
	public void clickHeader() {

		WebUtility.action(Locators.getLocators("loc.btn.insights"));
		WebUtility.clickElement(Locators.getLocators("loc.btn.blogs"));
		WebUtility.clickElement(Locators.getLocators("loc.img.blog"));
	}

	/**
	 * Method click on the post comment button of the comment bar
	 */
	public void clickSubmit() {

		WebUtility.clickElement(Locators.getLocators("loc.btn.postComment"));
	}

	/**
	 * Method use to get the date of the blog and the system date to validate that
	 * they are 3 months old or not
	 */
	@SuppressWarnings("deprecation")
	public int getDate() {

		// getting blog date from the web
		String string = WebUtility.getText(Locators.getLocators("loc.btn.blogDate"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		LocalDate localDate = LocalDate.parse(string, formatter);
		System.out.println(localDate); // 2019-01-02

		String local[] = (localDate + "").split("-");

		// getting date of the system
		String day = Calendar.getInstance().getTime() + "";
		Date date = new Date();

		int month = date.getMonth() + 1;
//		System.out.println(day);// 5 2 1 Fri Sep 27 14:28:35 IST 2019
		String[] date1 = day.split(" ");
		String systemDate = date1[5] + month + date1[2];
		System.out.println(systemDate);
		int monthDifference = Integer.parseInt(date1[5]) - month;
		if (monthDifference < 0) {
			monthDifference = 12 - monthDifference;
		}

		int yearDifference = Integer.parseInt(local[0]) - Integer.parseInt(date1[5]);
		if (yearDifference > 0) {
			int difference = yearDifference * 12;
			monthDifference = monthDifference + difference;
		}
		return monthDifference;
	}
}
