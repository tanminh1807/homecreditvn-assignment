package web.page;

import core._base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ManagerPage extends BasePage {
    @FindBy(css = "tbody tr:nth-child(3) td")
    private WebElement managerIdTxt;

    public void assertManagerId(String managerId) {
        String actualManagerId = managerIdTxt.getText();
        Assert.assertTrue(actualManagerId.contains(managerId));
    }
}
