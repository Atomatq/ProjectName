package org.example.pageObjects;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement accountMenuButton = $x("//a[./i[contains(@class, 'ico icon-user')]]");
    private SelenideElement account = $x("//app-login-menu//span[contains(.,'Личный кабинет')]");

    @Step("Перейти на страницу регистрации")
    public LoginPage goToAuthPage() {
        accountMenuButton.shouldBe(visible).click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Перейти в личный кабинет")
    public AccountPage goToAccountPage() {
        accountMenuButton.shouldBe(visible).click(ClickOptions.usingJavaScript());
        account.shouldBe(visible, Duration.ofSeconds(5)).click();
        return page(AccountPage.class);
    }


}
