package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class ExperienceWork {
    private final String homePage;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public ExperienceWork(String homePage, LocalDate startDate, LocalDate endDate, String title, String description) {
        this.homePage = homePage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceWork that = (ExperienceWork) o;
        return Objects.equals(homePage, that.homePage) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, startDate, endDate, title, description);
    }

    @Override
    public String toString() {
        return "ExperienceWork{" +
                "homePage='" + homePage + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
