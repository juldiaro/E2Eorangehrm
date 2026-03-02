package com.orangehrm.runners;

import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.orangehrm.stepdefinitions",
        tags = "@E2E",
        plugin = {"pretty"}
)
public class EmployeeManagementTestRunner {
    @BeforeClass
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
