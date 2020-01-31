package ru.netology;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor

public class CardDeliveryInfo {
    private final String city;
    private final LocalDate deliveryData;
    private final String surName;
    private final String name;
    private final String phone;
}
