package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Notification implements Notifiable {
    private String message;
    private LocalDateTime date;


    public Notification(String message, LocalDateTime date) {
        this.message = message;
        this.date = date;
    }

    /**
     * sends notifications
     */
    public void  sendNotifications() {
        System.out.println("Notification :" + message + "at" + date);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(message, that.message) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, date);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
