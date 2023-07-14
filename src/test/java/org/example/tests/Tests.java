package org.example.tests;

import io.qameta.allure.Description;
import org.example.BaseTest;
import org.example.pageObjects.MainPage;
import org.example.pageObjects.MarkCreatePage;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    @Test
    @Description("Создание показателя здоровья.")
    public void test1() {
        new MainPage().goToAuthPage()
                .setUsernameAndPassword(config.getProperty("user.name"), config.getProperty("user.password"))
                .signIn()
                .goToAccountPage()
                .selectTab("Разное")
                .selectSubTab("Показатели здоровья")
                .createNewMark()
                .setWeight("4")
                .submit()
                .selectMarkFilter("Вес")
                .verifyAddedMark(MarkCreatePage.createTime, "Вес", "4 кг");
    }
}
