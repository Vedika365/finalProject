package org.example;

import java.time.LocalDateTime;

public class ExamTask extends Task{
    private String course;
    private LocalDateTime Date;
    private String location;
    private String format;

    public ExamTask(String title, String description, LocalDateTime dueDate, String category) {
        super(title, description, dueDate, category);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
