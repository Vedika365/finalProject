package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> allTask;
    private ReminderService reminders;

    public TaskManager(List<Task> allTask, ReminderService reminders) {
        this.allTask = new ArrayList<>();
        this.reminders = new ReminderService();
    }

    public  void addTask(Task task ) {
           this.allTask.add(task);
    }

    public void deleteTask(Task task ) {
         this.allTask.remove(task);
        System.out.println("Task deleted from TaskManager" + task.getTitle());
    }

    public void editTask(Task task, String newTitle, String newDescription, LocalDateTime newDueDate, String newCategory) {
        for (int i = 0; i < allTask.size(); i++) {
            if (allTask.get(i).equals(task)) {
                allTask.get(i).editTasks(task,newTitle, newDescription, newDueDate, newCategory);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public static void markTaskAsCompleted() {

    }


    public static void filterTaskByCategory() {

    }

    public static String viewTaskByCategory(List<Task> tasks) {

    }

    public static String searchTask(Task task) {

    }

    public static void organiseTaskByDate(List<Task> tasks) {

    }

    public static void prioritizeTasks(String task) {

    }

    public static boolean loadTaskFromFile(String string) {

    }


}
