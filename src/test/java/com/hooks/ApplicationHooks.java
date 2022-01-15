package com.hooks;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	public static String featureName = null;
	public static String scenarioName = null;

	@Before(order=0)
	public static String getTheScenarioName(Scenario scenario) {
		return scenarioName = scenario.getName();

	}

	@Before(order=1)
	public static String getTheFeatureName(Scenario scenario) {
		scenario.getSourceTagNames();
		String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");

		featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

		return featureName;
	}
	@Before(order = 2)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();	
	}

	@Before(order = 3)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}