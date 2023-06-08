package web.steps;

import core._base.BaseStep;
import io.cucumber.java8.En;
import web.page.HomePage;
import web.page.ManagerPage;

public class BankingSteps extends BaseStep implements En {
    public BankingSteps() {

        Given("user opens Demo Guru99 home page", () -> {
            on(HomePage.class).visit();
        });

        And("user logins as manager successfully", () -> {
            on(HomePage.class).login();
            on(ManagerPage.class).assertManagerId("mngr507948");
        });
    }
}