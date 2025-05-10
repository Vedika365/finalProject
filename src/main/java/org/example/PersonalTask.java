package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class PersonalTask extends Task {
    private String location;
    private boolean isRecurring;
    private boolean isOptional;

    public PersonalTask(String location, boolean isRecurring, boolean isOptional, String title, String description, LocalDateTime dueDate, String category, boolean isCompleted) {
        super(title,description, dueDate, category, isCompleted);
        this.location = location;
        this.isRecurring = isRecurring;
        this.isOptional = isOptional;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonalTask that = (PersonalTask) o;
        return isRecurring == that.isRecurring && isOptional == that.isOptional && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, isRecurring, isOptional);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public boolean isOptional() {
        return isOptional;
    }

    public void setOptional(boolean optional) {
        isOptional = optional;
    }
}
