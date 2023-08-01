package org.example.help.utils;

import com.codeborne.selenide.SelenideElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DatePicker {
    LinkedList<String> months = new LinkedList<>(Arrays.asList("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"));
    private SelenideElement currentDay = $x("//td[contains(@class, 'current-day')]");
    private SelenideElement currentMonth = $x("//span[contains(@class, 'ui-datepicker-month')]");
    private SelenideElement currentYear = $x("//span[contains(@class, 'ui-datepicker-year')]");
    private SelenideElement currentTime = $x("//div[contains(@class, 'ui-timepicker')]");


    public String getCurrentDateTime() {
        String time = currentTime.shouldBe(visible).getText().replaceAll("\n", "");
        String day = currentDay.shouldBe(visible).getText();
        String month = String.valueOf(months.indexOf(currentMonth.getText())+1);
        String year = currentYear.getText();
        String dateTime = day + "." + month + "." + year+" "+time;

        return convert(dateTime, "dd.M.yyyy hh:mm", "dd.MM.yyyy hh:mm");
    }

    private String convert(String inputDateTime, String inputFormat, String outputFormat){
        Date date = null;
        String outputStr = "";

        try {
            date = new SimpleDateFormat(inputFormat).parse( inputDateTime );
            outputStr = new SimpleDateFormat(outputFormat).format( date );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputStr;
    }
}
