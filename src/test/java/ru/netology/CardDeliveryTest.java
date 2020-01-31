package ru.netology;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    SelenideElement form = $("form");
    SelenideElement city = form.$("[data-test-id=city] input");
    SelenideElement cityClick = $(".menu");
    SelenideElement cityChoose = $(byText("Казань"));
    SelenideElement date = form.$("[data-test-id=date] input");
    SelenideElement popupDate = $(".calendar");
    SelenideElement deliveryDate = $(byText("8"));
    SelenideElement name = form.$("[data-test-id=name] input");
    SelenideElement phone = form.$("[data-test-id=phone] input");
    SelenideElement agreement = form.$("[data-test-id=agreement]");
    SelenideElement button = $$("button").find(exactText("Запланировать"));
    SelenideElement notificationSuccess = $("[data-test-id='success-notification']");
    SelenideElement replanNotification = $("[data-test-id= 'replan-notification']");
    SelenideElement buttonText = $(byText("Перепланировать"));


    private String getFutureDate(int plusDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        LocalDate currentDate = LocalDate.now();
        LocalDate controlDate = currentDate.plusDays(plusDate);
        String formattedControlDate = controlDate.format(formatter);
        return formattedControlDate;
    }

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @BeforeEach
    void openHost() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTest() {
        String address = faker.address().city();
        String surName = faker.name().lastName();
        String firstName = faker.name().firstName();
        String phoneNumber = faker.phoneNumber().phoneNumber();

        //city.setValue(address);
        city.setValue("Москва");
        cityClick.waitUntil(exist, 5000).click();
        date.doubleClick().sendKeys(Keys.BACK_SPACE);
        String futureDay = getFutureDate(3);
        date.setValue(futureDay);
        name.setValue(surName + " " + firstName);
        phone.setValue(phoneNumber);
        agreement.click();
        button.click();
        notificationSuccess.waitUntil(visible, 15000);
        date.doubleClick().sendKeys(Keys.BACK_SPACE);
        String newFutureDay = getFutureDate(5);
        date.setValue(newFutureDay);
        button.click();
        replanNotification.waitUntil(visible, 15000);
        buttonText.click();
        replanNotification.waitUntil(exist, 15000);
    }
}
