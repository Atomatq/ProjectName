package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.example.help.config.BaseCfg;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;


public class TestBase {
    public BaseCfg conf;

    @Parameters("browser")
    @BeforeClass
    public void init(String browser) {
        Map browserName = new HashMap<>();
        browserName.put("browser", browser);
        conf = ConfigFactory
                .create(BaseCfg.class, browserName);

        Configuration.browser = browser;
        Configuration.driverManagerEnabled = true;
        Configuration.screenshots = false;
        Configuration.pageLoadTimeout = 60000L;
        setUpWebDriverFor(browser);
        Selenide.open(conf.baseURL());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }



    @AfterTest
    public void afterAll() {
        Selenide.closeWebDriver();
    }

    private void setUpWebDriverFor(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().driverVersion(conf.browserVersion()).setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().driverVersion(conf.browserVersion()).setup();
                break;
            case "ie":
                WebDriverManager.iedriver().driverVersion(conf.browserVersion()).setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().driverVersion(conf.browserVersion()).setup();
                break;
        }
    }
}
