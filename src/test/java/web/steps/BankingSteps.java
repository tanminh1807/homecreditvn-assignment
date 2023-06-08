package web.steps;

import core._base.BaseStep;
import io.cucumber.java8.En;
import web.page.HomePage;
import web.page.ManagerPage;
import web.page.NewCustomerPage;

public class BankingSteps extends BaseStep implements En {
    public BankingSteps() {

        Given("user opens Demo Guru99 home page", () -> {
            on(HomePage.class).visit();
        });

        And("user logins as manager successfully", () -> {
            on(HomePage.class).login("mngr507948", "qYmagut");
            on(ManagerPage.class).assertManagerId("mngr507948");
        });

        And("user navigates to New Customer page", () -> {
            on(ManagerPage.class).navigateToNewCustomerPage();
        });

        When("user creates new customer", () -> {
            on(NewCustomerPage.class).createNewCustomer();
        });

        Then("new customer should be created successfully", () -> {
            on(NewCustomerPage.class).assertCustomerRegisteredSuccessfully("Customer Registered Successfully!!!");
            String customerId = on(NewCustomerPage.class).getCustomerId();
            save(String.class, customerId);

            System.out.println("debug");
        });
    }
}