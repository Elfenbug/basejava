package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSection extends AbstractSection {
    private final List<ExperienceWork> experienceWork;

    public ExperienceSection(List<ExperienceWork> experienceWork) {
        this.experienceWork = experienceWork;
    }

    public List<ExperienceWork> getExperienceWork() {
        return experienceWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceSection that = (ExperienceSection) o;
        return Objects.equals(experienceWork, that.experienceWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experienceWork);
    }

    @Override
    public String toString() {
        return experienceWork.toString();
    }
}
