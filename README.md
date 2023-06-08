# Home Credit VN Automation Assignment

This is the implementation for Home Credit VN automation assignment using Selenium, Cucumber, TestNG and Maven

There is 1 cucumber feature which represents for the required testcase: Banking.feature

To run this feature, please add `tags = {"@web.banking"}` in **WebTestRunner.java**.

> **Note:** This UI automation test can NOT be run without opening a real browser. So make sure to set `headless = false` in **browser.properties**

## To run the code:
- Using IntelliJ IDEA: Clone the project and import to IntelliJ. You may also need to install Cucumber and Gherkin for Java plugin. Run WebTestRunner.java as TestNG class

- Using command line: Make sure you have Maven installed (run mvn --version to check). In terminal, clone and cd to the project directory, then run `mvn test -Dtest=WebTestRunner`