package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskManager {
    private static List<Task> allTask;
    private ReminderService reminders;

    public TaskManager(List<Task> allTask, ReminderService reminders) {
        this.allTask = new ArrayList<>();
        this.reminders = new ReminderService();
    }


    public void addTask(Task task) {
        this.allTask.add(task);
    }

    public void deleteTask(Task task) {
        allTask.remove(task);
        System.out.println("Task deleted from TaskManager" + task.getTitle());
    }

    public static void editTask(Task task, String newTitle, String newDescription, LocalDateTime newDueDate, String newCategory) {
        for (int i = 0; i < allTask.size(); i++) {
            if (allTask.get(i).equals(task)) {
                Task.editTasks(task, newTitle, newDescription, newDueDate, newCategory);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void markTaskAsCompleted(Task task) {
        for (int i = 0; i < allTask.size(); i++) {
            if (allTask.get(i).equals(task)) {
                allTask.get(i).markCompleted();
                return;
            }
            System.out.println("Task not found. ");
        }
    }


    public List<Task> filterTaskByCategory(String category) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : allTask) {
            if (task.getCategory().equalsIgnoreCase(category)) ;
            filteredTasks.add(task);
        }
        return filteredTasks;
    }

    /**
     * lets the user see the task by category
     *
     * @param tasks a list of tasks to check from
     * @return a String containing the tasks in order
     */
    public String viewTaskByCategory(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return "No tasks available";
        }
        List<String> lines = new ArrayList<>();
        for (Task task : tasks) {
            lines.add("Category:" + task.getCategory());
            lines.add("Title: " + task.getTitle());
            lines.add(" Description :  " + task.getDescription());
            lines.add(" Due Date : " + task.getDueDate());
            lines.add("Completed :  " + task.isCompleted());
        }
        return String.join("\n, lines");

    }

    /**
     * lets the user seach for a task
     *
     * @param task the task seraching for
     * @return a string, the string needed
     */
    public static String searchTask(Task task) {
        if (task == null) {
            return "task not found";
        }
        return String.join("\n", Arrays.asList(
                "Found Task:",
                "Title: " + task.getTitle(),
                "Description: " + task.getDescription(),
                "Due Date: " + task.getDueDate(),
                "Category: " + task.getCategory(),
                "Completed: " + task.isCompleted()
        ));
    }


    /**
     * Organise tasks by date
     * @param tasks the list of tasks
     */
    public static void organiseTaskByDate(List<Task> tasks) {

    }

    /**
     * prioritize tasks
     * @param task the list of tasks
     */
    public static void prioritizeTasks(String task) {

    }

    /**
     * load tasks from a file
     * @param filePath the filePath of the file to load from
     * @return boolean value, depending on if the procedure was successful or not
     */
    public static boolean loadTaskFromFile(String filePath) {
        return false;
    }

    public static List<Task> getAllTask() {
        return allTask;
    }

    public static void setAllTask(List<Task> allTask) {
        TaskManager.allTask = allTask;
    }

    public ReminderService getReminders() {
        return reminders;
    }

    public void setReminders(ReminderService reminders) {
        this.reminders = reminders;
    }
}
