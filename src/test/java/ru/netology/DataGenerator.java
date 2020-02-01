package ru.netology;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    public DataGenerator() {
    }
    public static UserNameInfo generateByCard() {
        Faker faker = new Faker(new Locale("ru"));
        return new UserNameInfo(
                faker.name().lastName(),
                faker.name().firstName()
        );
    }
}
