package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReminderService implements Notifiable {
    private List<Task> upcomingTask = new ArrayList<>();

    /**
     * Checks which tasks are due today and returns them
     * @param allTask a list of tasks which are due
     */
    public static List<Task> checkDueTasks(List<Task> allTask){
       List<Task> dueToday = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        for(Task task : allTask ) {
            LocalDateTime dueDateTime = task.getDueDate();
            if (dueDateTime != null && dueDateTime.toLocalDate().isEqual(ChronoLocalDate.from(today)));
            dueToday.add(task);
        }
        return dueToday;
    }

    /**
     * method that sends notifications
     */
    public void sendNotifications() {
      //TODO
    }
}
