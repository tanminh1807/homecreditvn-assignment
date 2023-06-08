package web.page;

import com.github.javafaker.Faker;
import core._base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

    Faker faker = new Faker();

    @FindBy(css = "[name='accountno']")
    private WebElement accountNoField;
    @FindBy(css = "[name='ammount']")
    private WebElement amountField;
    @FindBy(css = "[name='desc']")
    private WebElement descriptionField;
    @FindBy(css = "[value='Submit']")
    private WebElement submitBtn;

    public void depositToAccount(String accountId) {
        accountNoField.sendKeys(accountId);
        amountField.sendKeys(faker.number().digits(10));
        descriptionField.sendKeys(faker.lorem().characters(15));
        submitBtn.click();
    }
}
