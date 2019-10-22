package com.atmecs.DynamicXmlCreation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

import com.atmecs.testScripts.HomePagetestscripts;

public class DynamicXmlCreation {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("selectBrowser", "chrome");
		XmlSuite suite = new XmlSuite();
		suite.setName("Dynamic Suite");
		suite.setParallel(ParallelMode.NONE);
		suite.setThreadCount(3);

		XmlClass xmlClass = new XmlClass(HomePagetestscripts.class);
		xmlClass.setName("com.atmecs.testScripts.Book_OneWay_Ticket");

		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(xmlClass);
		XmlTest test = new XmlTest();
		test.setName("ThroughChrome");
		test.setThreadCount(1);
		test.setXmlClasses(classes);
		test.setVerbose(0);
		test.setParallel(ParallelMode.NONE);
		List<String> groups = new ArrayList<String>();
		groups.add("test");
		test.setIncludedGroups(groups);

		List<XmlTest> tests = new ArrayList<XmlTest>();
		tests.add(test);

		suite.setTests(tests);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
		testng.run();
	}
}
