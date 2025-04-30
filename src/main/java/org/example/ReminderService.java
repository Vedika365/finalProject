package org.example;

import java.util.List;

public class ReminderService implements Notifiable {
    private List<Task> upcomingTask;

    /**
     *
     * @param upcomingTask a list of tasks which are due
     */
    public static void checkDueTasks(List<Task> upcomingTask){

    }

    /**
     * method that sends notifications
     */
    public static void sendNotifications() {

    }
}
