package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSection extends AbstractSection {
    private final List<ExperienceWork> experienceWorks;

    public ExperienceSection(List<ExperienceWork> experienceWorks) {
        this.experienceWorks = experienceWorks;
    }

    public List<ExperienceWork> getExperienceWork() {
        return experienceWorks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceSection that = (ExperienceSection) o;
        return Objects.equals(experienceWorks, that.experienceWorks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experienceWorks);
    }

    @Override
    public String toString() {
        return experienceWorks.toString();
    }
}
