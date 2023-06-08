package web;

import core._base.BaseRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/web/features"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        glue = {"web.steps"},
        tags = "@web.banking")
public class WebTestRunner extends BaseRunner {
}