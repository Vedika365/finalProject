package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReminderService implements Notifiable {
    private List<Task> upcomingTask = new ArrayList<>();

    /**
     * method to check due date
     * @param allTask a list to look from
     * @return a list of tasks
     */
    public static List<Task> checkDueTasks(List<Task> allTask) {
        if (allTask == null || allTask.isEmpty()) {
            return null;
        }
        List<Task> dueToday = new ArrayList<>();
        LocalDate today = LocalDate.now(); // Using LocalDate to compare without time component

        for (Task task : allTask) {
            LocalDateTime dueDateTime = task.getDueDate();
            if (dueDateTime != null && dueDateTime.toLocalDate().isEqual(today)) {
                dueToday.add(task);
            }
        }
        return dueToday;
    }

    /**
         * Filter tasks by category
         * @param allTasks a list of tasks
         * @param category the category to use to filter
         * @return a list of tasks filtered by the given category
         */
        public static List<Task> filterByCategory(List<Task> allTasks, String category) {
            return allTasks.stream()
                    .filter(task -> task.getCategory() != null && task.getCategory().equals(category)) // Ensure category is not null and matches
                    .collect(Collectors.toList()); // Collect the filtered tasks into a list
        }

    /**
     * Method that sends notifications for pending or completed tasks.
     */
    public void sendNotifications() {
        List<Task> tasks = TaskManager.getAllTask();
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks available to send notifications.");
            return;
        }

        for (Task task : tasks) {
            if (!task.isCompleted()) {
                System.out.println("Reminder: Task \"" + task.getTitle() + "\" is not completed yet.");
            } else {
                System.out.println("✔ Task \"" + task.getTitle() + "\" is completed.");
            }
        }
    }
}
