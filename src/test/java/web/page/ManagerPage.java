package web.page;

import core._base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ManagerPage extends BasePage {
    @FindBy(css = "tbody tr:nth-child(3) td")
    private WebElement managerIdTxt;
    @FindBy(xpath = "//*[text()='New Customer']")
    private WebElement newCustomerPageBtn;
    @FindBy(xpath = "//*[text()='Add New Customer']")
    private WebElement newCustomerPageTitle;

    public void assertManagerId(String managerId) {
        String actualManagerId = managerIdTxt.getText();
        Assert.assertTrue(actualManagerId.contains(managerId));
    }

    public void navigateToNewCustomerPage() {
        newCustomerPageBtn.click();
        waitForPageReady(newCustomerPageTitle);
    }
}
