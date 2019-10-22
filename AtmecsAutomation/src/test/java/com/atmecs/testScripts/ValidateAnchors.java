package com.atmecs.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.constants.Locators;
import com.atmecs.constants.ValidatingData;
import com.atmecs.dataProvider.TestDataProvider;
import com.atmecs.logReports.LogReport;
import com.atmecs.pages.HomePage;
import com.atmecs.testBase.TestBase;
import com.atmecs.testflow.HomePageFlow;

/**
 * Class validates the anchors of the homepage
 */
public class ValidateAnchors extends TestBase {
	Logger log;
	Locators locators;
	HomePage home;
	ValidatingData data;
	HomePageFlow HomePageFlow;

	@BeforeClass
	public void initializeVariable() {
		locators = new Locators();
		home = new HomePage(driver);
		HomePageFlow = new HomePageFlow(driver);
		data = new ValidatingData();

	}

	// maintain the flow of the anchors of the digital life anchor
	@Test(priority = 16)
	public void moveToDigitalLife() {
		log = Logger.getLogger(ValidateAnchors.class);
		LogReport.getlogger();
		// logger = extent.startTest("Validating anchors of the Digital life page");
		log.info("Starting Anchors tag validation");
		HomePageFlow.clickServices();

	}

	// Validates the Digital life anchors
	@Test(priority = 17, dataProvider = "header1", dataProviderClass = TestDataProvider.class)
	public void isDigitalLifeAnchorPresent(String anchor) {
		home.ValidateAnchors(anchor);
	}

	// validates the Infrastructure management anchors
	@Test(priority = 19, dataProvider = "header2", dataProviderClass = TestDataProvider.class)
	public void isInfrastructureAnchorPresent(String anchor) {

		home.ValidateAnchors(anchor);
	}

	// maintaining the flow of the test scripts to the infrastructure management
	// anchor
	@Test(priority = 18)
	public void moveToInfrastructure() {
		log = Logger.getLogger(ValidateAnchors.class);
		LogReport.getlogger();

		log.info("Starting Redirection validation");
		HomePageFlow.clickInfra();
	}
}
