package org.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement accountMenuButton = $x("//a[./i[contains(@class, 'ico icon-user')]]");
    private SelenideElement account = $x("//app-login-menu//span[contains(.,'Личный кабинет')]");

    @Step("Перейти на страницу регистрации")
    public LoginPage goToAuthPage() {
        accountMenuButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    @Step("Перейти в личный кабинет")
    public AccountPage goToAccountPage() {
        accountMenuButton.shouldBe(visible).click();
        account.shouldBe(visible).click();
        return page(AccountPage.class);
    }


}
