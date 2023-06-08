package core._base;

import core.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    private WebDriver driver;
    protected static final int TIME_OUT_MILLISECONDS = 10;

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void waitForPageReady(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_MILLISECONDS)).until(visibilityOf(element));
    }
}
