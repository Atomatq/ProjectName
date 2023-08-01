package org.example.tests;

import org.example.TestBase;
import org.example.pageObjects.MainPage;
import io.qameta.allure.Description;
import org.example.pageObjects.MarkCreatePage;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test
    @Description("Создание показателя здоровья.")
    public void test1() {
        new MainPage().goToAuthPage()
                .setUsernameAndPassword(conf.userName(), conf.password())
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
