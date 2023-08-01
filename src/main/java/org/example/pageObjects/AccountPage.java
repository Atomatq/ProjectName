package org.example.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AccountPage {
    private ElementsCollection cardTabs = $$x("//div[@class=\"account-tabs\"]//a");
    private ElementsCollection cardSubTabs = $$x("//div[@class=\"tabs wrap\"]//a");
    private ElementsCollection tableRows = $$x("//div[@class=\"clearfix td\"]");
    private SelenideElement createMark = $x("//div[@class=\"create-block\"]/a");
    private SelenideElement markFilter = $x("//div[@class=\"indicator-filter\"]");
    private ElementsCollection filterDropdownList = $$x("//ul[@role=\"listbox\"]//li");


    @Step("Выбрать раздел {tab}.")
    public AccountPage selectTab(String tab) {
        cardTabs.findBy(text(tab)).shouldBe(visible).click();
        return page(AccountPage.class);
    }

    @Step("Выбрать раздел {subTab}.")
    public AccountPage selectSubTab(String subTab) {
        cardSubTabs.findBy(text(subTab)).shouldBe(visible).click();
        return page(AccountPage.class);
    }

    @Step("Нажать кнопку 'Записать показатель'.")
    public MarkCreatePage createNewMark() {
        createMark.shouldBe(visible).click();
        return Selenide.page(MarkCreatePage.class);
    }
    @Step("Отфильтровать таблицу по показателю {type}.")
    public AccountPage selectMarkFilter(String type) {
        markFilter.shouldBe(visible).click();
        filterDropdownList.findBy(text(type)).shouldBe(visible).click();

        markFilter.shouldHave(text(type));
        return page(AccountPage.class);
    }

    @Step("Проверить что в таблице появилась запись.")
    public AccountPage verifyAddedMark(String date, String type, String value) {
        tableRows.findBy(text(date)).shouldHave(text(type)).shouldHave(text(value));
        return page(AccountPage.class);
    }

}
