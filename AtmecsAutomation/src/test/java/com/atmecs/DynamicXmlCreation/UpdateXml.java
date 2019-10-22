package com.atmecs.DynamicXmlCreation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.atmecs.constants.FilePath;
import com.atmecs.testScripts.HomePagetestscripts;
import com.atmecs.utils.ReadPropertiesFile;

public class UpdateXml {

	@SuppressWarnings("deprecation")
	@Test
	public void runTestFile() throws IOException {
		Properties props = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);

		List<String> names = new ArrayList<String>();
		String[] arr = props.getProperty("browser").split(",");
		for (String name : arr) {
			names.add(name);
		}

		names.forEach(name -> System.out.println(name));

		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setParallel("tests");
		xmlSuite.setThreadCount(3);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();

		for (String name : names) {

			XmlTest xmlTest1 = new XmlTest(xmlSuite);
			Map<String, String> parameter1 = new HashMap<String, String>();
			parameter1.put("browser", name);
			xmlTest1.setParameters(parameter1);
			xmlTest1.setName("Test validate " + name);

			// code to read your testNg file

			XmlClass login1Class = new XmlClass(HomePagetestscripts.class);
			List<XmlClass> xmlClassList1 = new ArrayList<XmlClass>();
			xmlClassList1.add(login1Class);
			xmlTest1.setXmlClasses(xmlClassList1);

		}

		suites.add(xmlSuite);

		TestNG testng = new TestNG();

		testng.setXmlSuites(suites);

		testng.run();

	}
}
