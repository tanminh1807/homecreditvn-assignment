package web.page;

import com.github.javafaker.Faker;
import core._base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewCustomerPage extends BasePage {

    Faker faker = new Faker();

    @FindBy(css = "[name='name']")
    private WebElement customerNameField;
    @FindBy(css = "[value='m']")
    private WebElement genderMale;
    @FindBy(css = "[value='f']")
    private WebElement genderFemale;
    @FindBy(css = "[name='dob']")
    private WebElement dobField;
    @FindBy(css = "[name='addr']")
    private WebElement addressField;
    @FindBy(css = "[name='city']")
    private WebElement cityField;
    @FindBy(css = "[name='state']")
    private WebElement stateField;
    @FindBy(css = "[name='pinno']")
    private WebElement pinField;
    @FindBy(css = "[name='telephoneno']")
    private WebElement phoneField;
    @FindBy(css = "[name='emailid']")
    private WebElement emailField;
    @FindBy(css = "[name='password']")
    private WebElement passwordField;
    @FindBy(css = "[value='Submit']")
    private WebElement submitBtn;
    @FindBy(css = ".heading3")
    private WebElement customerRegisteredTxt;
    @FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
    private WebElement customerId;
    @FindBy(xpath = "//*[text()='New Account']")
    private WebElement newAccountPageBtn;
    @FindBy(xpath = "//*[text()='Add new account form']")
    private WebElement newAccountPageTitle;

    public void createNewCustomer() {
        customerNameField.sendKeys(faker.name().firstName());
        (faker.random().nextBoolean() ? genderMale : genderFemale).click();
        dobField.sendKeys("18071998");
        addressField.sendKeys(faker.lorem().characters(15));
        cityField.sendKeys(faker.lorem().word());
        stateField.sendKeys(faker.lorem().word());
        pinField.sendKeys(faker.number().digits(6));
        phoneField.sendKeys(faker.number().digits(10));
        emailField.sendKeys(faker.internet().emailAddress());
        passwordField.sendKeys(faker.lorem().characters(10));
        submitBtn.click();
    }

    public void assertCustomerRegisteredSuccessfully(String message) {
        String confirmationMsg = customerRegisteredTxt.getText();
        Assert.assertEquals(message, confirmationMsg);
    }

    public String getCustomerId() {
        return customerId.getText();
    }

    public void navigateToNewAccountPage(){
        newAccountPageBtn.click();
        waitForPageReady(newAccountPageTitle);
    }
}
