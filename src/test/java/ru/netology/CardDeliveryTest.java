package ru.netology;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

import static ru.netology.DataGenerator.generateByCard;

public class CardDeliveryTest {
    SelenideElement form = $("form");
    SelenideElement cityForm = form.$("[data-test-id=city] input");
    SelenideElement cityClick = $(".menu");
    SelenideElement dateForm = form.$("[data-test-id=date] input");
    SelenideElement nameForm = form.$("[data-test-id=name] input");
    SelenideElement phoneForm = form.$("[data-test-id=phone] input");
    SelenideElement agreementForm = form.$("[data-test-id=agreement]");
    SelenideElement button = $$("button").find(exactText("Запланировать"));
    SelenideElement notificationSuccess = $("[data-test-id='success-notification']");
    SelenideElement replanNotification = $("[data-test-id= 'replan-notification']");
    SelenideElement replanButton = $(byText("Перепланировать"));

    private Faker faker;

    @BeforeAll
    static void setUpAllAlure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @BeforeEach
    void openHost() {
        open("http://localhost:9999");
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("test success if delivery date change")
    @Test
    void shouldChangeDeliveryDate() {
        String randomCity = DataGenerator.getRandomCity();
        UserNameInfo userFullName = generateByCard();
        String phoneNumber = faker.phoneNumber().phoneNumber();

        cityForm.setValue(randomCity);
        cityClick.waitUntil(exist, 5000).click();
        dateForm.doubleClick().sendKeys(Keys.BACK_SPACE);
        dateForm.setValue(DataGenerator.getFutureDate(3));
        nameForm.setValue(String.valueOf(userFullName));
        phoneForm.setValue(phoneNumber);
        agreementForm.click();
        button.click();
        notificationSuccess.waitUntil(visible, 15000);
        dateForm.doubleClick().sendKeys(Keys.BACK_SPACE);
        dateForm.setValue(DataGenerator.getFutureDate(5));
        button.click();
        replanNotification.waitUntil(visible, 15000);
        replanButton.click();
        replanNotification.waitUntil(exist, 15000);
    }
}
