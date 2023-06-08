package web.page;

import core._base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_URL = "http://demo.guru99.com/v4/";

    @FindBy(css = "[alt='Guru99 Demo Sites']")
    private WebElement logo;
    @FindBy(css = "[name='uid']")
    private WebElement userIdField;
    @FindBy(css = "[name='password']")
    private WebElement passwordField;
    @FindBy(css = "[name='btnLogin']")
    private WebElement loginBtn;

    public void visit() {
        getDriver().get(HOME_URL);
        waitForPageReady(logo);
    }

    public void login() {
        userIdField.sendKeys("mngr507948");
        passwordField.sendKeys("qYmagut");
        loginBtn.click();
    }
}