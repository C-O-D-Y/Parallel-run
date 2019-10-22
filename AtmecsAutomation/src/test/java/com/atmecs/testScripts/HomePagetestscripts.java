package com.atmecs.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomePage;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;

/*
*Class validates the functionality of homepage header buttons functionality
*/
public class HomePagetestscripts extends TestBase {
	Logger log;
	Locators locators = new Locators();
	HomePage home;
	ValidatingData data;
	HomePageFlow HomePageFlow;

	/*
	 * Test validates the homepage redirection of the atmecs.com
	 */
	@Test(priority = 1)
	public void homePageRedirection() {
		home = new HomePage(driver);
		data = new ValidatingData();
		HomePageFlow = new HomePageFlow(driver);
		log = Logger.getLogger(HomePagetestscripts.class);
		LogReport.getlogger();
		// logger = extent.startTest("HomepageRedirection");
		log.info("Starting Redirection validation");
		home.isRedirectionCorrect();
		log.info("Redirection is on the correct page");
		log.info("Starting the homepage testing");
	}

	// method validate the footer of the pages are present or not
	@Test(priority = 3, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForServices(String footer) {
		log = Logger.getLogger(HomePagetestscripts.class);
		// WebUtility.explicitWait(Locators.getLocators("loc.btn.services"));
		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}

	// clicking on the header of the services
	@Test(priority = 2)
	public void clickHeaderServices() {
		try {
			log = Logger.getLogger(HomePagetestscripts.class);
			HomePageFlow.clickHeader("Services");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// clicking on the header of the Careers
	@Test(priority = 4)
	public void clickHeaderCareers() {
		try {
			log = Logger.getLogger(HomePagetestscripts.class);
			HomePageFlow.clickHeader("Careers");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method validate the footer of the pages are present or not
	@Test(priority = 5, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForCareers(String footer) {
		log = Logger.getLogger(HomePagetestscripts.class);

		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}

	// clicking on the header of the About_Us
	@Test(priority = 6)
	public void clickHeaderAboutUs() {
		try {
			log = Logger.getLogger(HomePagetestscripts.class);
			HomePageFlow.clickHeader("About Us");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method validate the footer of the pages are present or not
	@Test(priority = 7, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForAboutUs(String footer) {
		log = Logger.getLogger(HomePagetestscripts.class);

		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}

	// clicking on the header of the Partners
	@Test(priority = 8)
	public void clickHeaderPartners() {
		try {
			log = Logger.getLogger(HomePagetestscripts.class);
			HomePageFlow.clickHeader("Partners");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 9, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForPartner(String footer) throws InterruptedException {
		log = Logger.getLogger(HomePagetestscripts.class);

		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}

	// clicking on the header of the Media
	@Test(priority = 10)
	public void clickHeaderMedia() {
		try {
			log = Logger.getLogger(HomePagetestscripts.class);
			HomePageFlow.clickHeader("Media");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method validate the footer of the pages are present or not
	@Test(priority = 11, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForMedia(String footer) throws InterruptedException {
		log = Logger.getLogger(HomePagetestscripts.class);

		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}

	// clicking on the header of the ContactUs
	@Test(priority = 12)
	public void clickContactUs() {
		log = Logger.getLogger(HomePagetestscripts.class);
		try {
			HomePageFlow.clickHeader("Contact Us");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method validate the footer of the pages are present or not
	@Test(priority = 13, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForContacts(String footer) throws InterruptedException {
		log = Logger.getLogger(HomePagetestscripts.class);

		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}

	// clicking on the header of the Insights
	@Test(priority = 14)
	public void clickInsights() {
		log = Logger.getLogger(HomePagetestscripts.class);
		try {
			HomePageFlow.clickHeader("Insights");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method validate the footer of the pages are present or not
	@Test(priority = 15, dataProvider = "footer2", dataProviderClass = TestDataProvider.class)
	public void validatefooterForInsights(String footer) throws InterruptedException {
		log = Logger.getLogger(HomePagetestscripts.class);

		home.isFooterItemsPresent(footer);
		log.info("Validation done");
	}
}
