package web.steps;

import core._base.BaseStep;
import io.cucumber.java8.En;
import web.page.*;

public class BankingSteps extends BaseStep implements En {
    public BankingSteps() {

        Given("user opens Demo Guru99 home page", () -> {
            on(HomePage.class).visit();
        });

        And("user logins as manager successfully", () -> {
            on(HomePage.class).login("mngr507990", "AvAjuqe");
            on(ManagerPage.class).assertManagerId("mngr507990");
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
        });

        When("user navigates to New Account page", () -> {
            on(NewCustomerPage.class).navigateToNewAccountPage();
        });

        And("user creates new account", () -> {
            String customerId = load(String.class);
            on(AccountPage.class).createNewAccount(customerId);
        });

        Then("new account should be created successfully", () -> {
            on(AccountPage.class).assertAccountGeneratedSuccessfully("Account Generated Successfully!!!");
            String accountId = on(AccountPage.class).getAccountId();
            save(String.class, accountId);
        });

        When("user navigates to Deposit page", () -> {
            on(AccountPage.class).navigateToDepositPage();
        });

        Then("user deposits to new created account", () -> {
            String accountId = load(String.class);
            on(DepositPage.class).depositToAccount(accountId);
        });
    }
}