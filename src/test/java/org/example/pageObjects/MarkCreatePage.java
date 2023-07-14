package org.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.example.help.calendar.DatePicker;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MarkCreatePage {
    public static String createTime;
    private SelenideElement dateTime = $x("//input[contains(@class,'create-date')]");
    private SelenideElement weight = $x("//div[./p[text()='Вес']]/following-sibling::div/input");
    private SelenideElement submit = $x("//button[@type=\"submit\"]");

    public MarkCreatePage setWeight(String weightVal) {
        weight.shouldBe(visible).setValue(weightVal);
        return page(MarkCreatePage.class);
    }

    public AccountPage submit() {
        dateTime.shouldBe(visible).click();
        createTime = new DatePicker().getCurrentDateTime();
        submit.click();
        return page(AccountPage.class);
    }
}
