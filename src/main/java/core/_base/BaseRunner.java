package core._base;

import constants.PATH;
import core._support.BROWSER;
import core.driver.Driver;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseRunner {
    private static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp() throws Exception {
        InputStream input = new FileInputStream(PATH.PROPERTIES + "/browser/browser.properties");
        Properties prop = new Properties();
        prop.load(input);
        Driver.setDriver(BROWSER.valueOf(prop.getProperty("browser_name").toUpperCase()), Boolean.valueOf(prop.getProperty("headless")));
        Driver.launchApp();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenarios(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider()
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void tearDown() {
        Driver.getDriver().quit();
        testNGCucumberRunner.finish();
    }
}