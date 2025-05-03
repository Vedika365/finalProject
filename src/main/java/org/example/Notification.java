package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

public class Notification implements Notifiable {
    private String message;
    private LocalDateTime Date;

    /**
     * sends notifications
     */
    public void  sendNotifications() {

    }

    public Notification(String message, LocalDateTime date) {
        this.message = message;
        Date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(message, that.message) && Objects.equals(Date, that.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, Date);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }
}
