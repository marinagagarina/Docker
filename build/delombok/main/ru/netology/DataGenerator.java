package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {}

    public static class Registration {
        private Registration() {}

        public static CardDeliveryInfo generateByCard() {
            Faker faker = new Faker(new Locale("ru"));
            return new CardDeliveryInfo(
                    faker.address().city(),
                    LocalDate.now().plusDays(5),
                    faker.name().lastName(),
                    faker.name().firstName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }
}
