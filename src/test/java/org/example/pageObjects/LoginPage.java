package org.example.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private SelenideElement userName = Selenide.$x("//input[@id='username']");
    private SelenideElement password = Selenide.$x("//input[@id='password']");
    private SelenideElement loginButton = Selenide.$x("//input[@name='login']");

    @Step("Заполнить поля регистрации.")
    public LoginPage setUsernameAndPassword(String username, String password) {
        userName.shouldBe(visible).setValue(username);
        this.password.shouldBe(visible).setValue(password);
        return page(LoginPage.class);
    }

    @Step("Нажать кнопку 'Sign in'.")
    public MainPage signIn() {
        loginButton.click();
        return page(MainPage.class);
    }
}
