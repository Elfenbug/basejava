package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Skype"),
    MAIL("Электронная почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль StackOverflow"),
    HOME_PAGE("Домашняя страница");

    ContactType(String title) {
    }
}
