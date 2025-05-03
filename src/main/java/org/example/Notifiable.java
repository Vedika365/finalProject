package org.example;

import java.time.LocalDateTime;

public interface Notifiable {

    /**
     * Sends a notification with default behavior
     */
    default void sendNotifications(String message, LocalDateTime notifyTime) {
        System.out.println("sending Notification");
    }
}
