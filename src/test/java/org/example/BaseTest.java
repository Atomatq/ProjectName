package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.example.help.config.ConfReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    public Properties config;
    @BeforeSuite
    public void init() {
        config = new ConfReader().readProperties("config.properties");
    }


    @BeforeTest
    public void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.screenshots = false;
        Configuration.pageLoadTimeout = 60000L;
        Selenide.open(config.getProperty("baseURL"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void afterAll() {
        Selenide.closeWebDriver();
    }
}
