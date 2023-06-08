package web.page;

import com.github.javafaker.Faker;
import core._base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountPage extends BasePage {

    Faker faker = new Faker();

    @FindBy(css = "[name='cusid']")
    private WebElement customerIdField;
    @FindBy(css = "[name='selaccount']")
    private WebElement selectAccountDrp;
    @FindBy(css = "[value='Savings']")
    private WebElement accountSavings;
    @FindBy(css = "[value='Current']")
    private WebElement accountCurrent;
    @FindBy(css = "[name='inideposit']")
    private WebElement initDepositField;
    @FindBy(css = "[value='submit']")
    private WebElement submitBtn;
    @FindBy(css = ".heading3")
    private WebElement accountGeneratedTxt;
    @FindBy(xpath = "//td[text()='Account ID']/following-sibling::td")
    private WebElement accountId;
    ///
    @FindBy(xpath = "//*[text()='Deposit']")
    private WebElement depositPageBtn;
    @FindBy(xpath = "//*[text()='Amount Deposit Form']")
    private WebElement depositPageTitle;

    public void createNewAccount(String customerId) {
        customerIdField.sendKeys(customerId);
        selectAccountDrp.click();
        (faker.random().nextBoolean() ? accountSavings : accountCurrent).click();
        initDepositField.sendKeys(faker.number().digits(10));
        submitBtn.click();
    }

    public void assertAccountGeneratedSuccessfully(String message) {
        String confirmationMsg = accountGeneratedTxt.getText();
        Assert.assertEquals(message, confirmationMsg);
    }

    public String getAccountId() {
        return accountId.getText();
    }

    public void navigateToDepositPage(){
        depositPageBtn.click();
        waitForPageReady(depositPageTitle);
    }
}
