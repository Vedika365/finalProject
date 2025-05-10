package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private static List<Task> allTask = new ArrayList<>();
    private ReminderService reminders;

    public TaskManager(List<Task> tasks, ReminderService reminders) {
        if (tasks != null) {
            allTask = new ArrayList<>(tasks);
        }
        this.reminders = reminders != null ? reminders : new ReminderService();
    }

    public void addTask(Task task) {
        allTask.add(task);
    }

    public void deleteTask(Task task) {
        allTask.remove(task);
        System.out.println("Task deleted from TaskManager: " + task.getTitle());
    }

    public static void editTask(Task task, String newTitle, String newDescription, LocalDateTime newDueDate, String newCategory, Task.Priority priority) {
        if (task == null || !allTask.contains(task)) {
            System.out.println("Task not found.");
            return;
        }
        Task.editTasks(task, newTitle, newDescription, newDueDate, newCategory, priority);
    }

    public void markTaskAsCompleted(Task task) {
        if (task != null && allTask.contains(task)) {
            task.markCompleted();
        } else {
            System.out.println("Task not found.");
        }
    }

    public List<Task> filterTaskByCategory(String category) {
        return allTask.stream()
                .filter(task -> task.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public String viewTaskByCategory(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return "No tasks available";
        }
        List<String> lines = new ArrayList<>();
        for (Task task : tasks) {
            lines.add("Category: " + task.getCategory());
            lines.add("Title: " + task.getTitle());
            lines.add("Description: " + task.getDescription());
            lines.add("Due Date: " + task.getDueDate());
            lines.add("Completed: " + task.isCompleted());
        }
        return String.join("\n", lines);
    }

    public static String searchTask(Task task) {
        if (task == null) {
            return "Task not found";
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

    public static void organiseTaskByDate(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }

    public static void prioritizeTasks(List<Task> tasks, String taskTitle) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(taskTitle)) {
                Task task = tasks.remove(i);
                tasks.add(0, task);
                return;
            }
        }
        System.out.println("Task not found: " + taskTitle);
    }

    public static void prioritizeTasksByPriority(List<Task> tasks) {
        tasks.sort((t1, t2) -> t2.getPriority().compareTo(t1.getPriority()));
    }

    public static boolean loadTaskFromFile(String filePath) {
        // Placeholder: implement actual file loading logic
        return false;
    }

    public static List<Task> getAllTask() {
        return allTask;
    }

    public static void setAllTask(List<Task> tasks) {
        allTask = tasks;
    }

    public ReminderService getReminders() {
        return reminders;
    }

    public void setReminders(ReminderService reminders) {
        this.reminders = reminders;
    }
}