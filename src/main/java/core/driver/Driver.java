package core.driver;

import core._support.BROWSER;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private static WebDriver driver = null;
    private static final String HOME_URL = "about:blank";

    public static void setDriver(BROWSER browserName, Boolean headlessMode) throws Exception {
        switch (browserName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(headlessMode);
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-fullscreen");
                firefoxOptions.setHeadless(headlessMode);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new Exception("Browser " + browserName + " is not supported");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void launchApp() {
        driver.get(HOME_URL);
    }
}
