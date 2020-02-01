package ru.netology;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class UserNameInfo {
    private final String surName;
    private final String name;

    public String toString() {
        return this.getSurName() + " " + this.getName();
    }
}
