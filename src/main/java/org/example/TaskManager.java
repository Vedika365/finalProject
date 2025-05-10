package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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

    public TaskManager(List<Task> allTask) {
        this.allTask = allTask;
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

    public static List<Task> filterTaskByCategory(String category) {
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

    /**
     * Search for a specific task
     *
     * @param task
     * @return
     */
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

    /**
     * method to prioritize a specific task
     *
     * @param tasks     the list of tasks
     * @param taskTitle the title of the task to priortize
     */
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

    /**
     * Prioritize task by priority level
     *
     * @param tasks
     */
    public static void prioritizeTasksByPriority(List<Task> tasks) {
        tasks.sort((t1, t2) -> t2.getPriority().compareTo(t1.getPriority()));
    }

    public static boolean loadTaskFromFile(String filePath) {
            List<Task> loadedTasks = new ArrayList<>();

            try (Scanner scanner = new Scanner(new File(filePath))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Assuming each task's attributes are separated by commas
                    String[] taskDetails = line.split(",");
                    if (taskDetails.length == 6) { // Adjust based on how many fields per task
                        String title = taskDetails[0].trim();
                        String description = taskDetails[1].trim();
                        LocalDateTime dueDate = LocalDateTime.parse(taskDetails[2].trim(), DateTimeFormatter.ISO_DATE_TIME);
                        String category = taskDetails[3].trim();
                        boolean completed = Boolean.parseBoolean(taskDetails[4].trim());
                        Task.Priority priority = Task.Priority.valueOf(taskDetails[5].trim().toUpperCase());

                        Task task = new Task(title, description, dueDate, category, completed, priority);
                        loadedTasks.add(task);
                    }
                }
                // Add loaded tasks to allTask list (or use setAllTask to update)
                TaskManager.setAllTask(loadedTasks);
                return true; // Return true if loading was successful
            } catch (FileNotFoundException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                return false; // Return false if the file is not found
            } catch (Exception e) {
                System.out.println("Error parsing task data: " + e.getMessage());
                return false;
            }
        }


        public static List<Task> getAllTask () {
            return allTask;
        }

        public static void setAllTask (List < Task > tasks) {
            allTask = tasks;
        }

        public ReminderService getReminders () {
            return reminders;
        }

        public void setReminders (ReminderService reminders){
            this.reminders = reminders;
        }

    }
