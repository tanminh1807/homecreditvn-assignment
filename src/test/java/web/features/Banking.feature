@web.banking
Feature: Demo Banking System

  Scenario: verify new customer can be created successfully, new account can be created successfully, deposit function work fine
    Given user opens Demo Guru99 home page
    And user logins as manager successfully
    And user navigates to New Customer page
    When user creates new customer
    Then new customer should be created successfully
    When user navigates to New Account page
    And user creates new account
    Then new account should be created successfully
    When user navigates to Deposit page