package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task implements Rewardable, Schedulable, Storable, Trackable {
    private String title;
    private  String description;
    private  LocalDateTime dueDate;
    private  String category;
    private boolean isCompleted;


    public Task() {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.isCompleted = false;
    }

    public Task(String title, String description, LocalDateTime dueDate, String category, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.isCompleted = isCompleted;
    }


    /**
     * Edits tasks
     */
    public static void editTasks(Task task, String newTitle, String newDescription, LocalDateTime newDueDate, String newCategory) {
        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setDueDate(newDueDate);
        task.setCategory(newCategory);
    }

    /**
     * Saves the task to a file in a structured format.
     *
     * @param fileName the name of the file to save the task
     */
    public void save(String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true)) { // Open in append mode
            // Write task data in a structured format
            fw.write("Task\n");
            fw.write("Title: " + title.trim() + "\n");
            fw.write("Description: " + description.trim() + "\n");
            fw.write("DueDate: " + dueDate.toString() + "\n");
            fw.write("Completed: " + isCompleted + "\n");
            fw.write("Category: " + category.trim() + "\n");
            fw.write("END_Task\n");

            System.out.println("Task '" + title + "' saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }

    @Override
    public void trackProgress() {
        Storable.super.trackProgress();
    }

    @Override
    public void schedule() {
        Schedulable.super.schedule();
    }

    /**
     * Loads tasks from a file and returns them as a list.
     */
    public List<Task> load(String fileName) throws FileNotFoundException {
        List<Task> loadedTasks = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.equals("Task")) {
                    String title = scanner.nextLine().split(":", 2)[1].trim();
                    String description = scanner.nextLine().split(":", 2)[1].trim();
                    String dueDateStr = scanner.nextLine().split(":", 2)[1].trim();
                    boolean isCompleted = Boolean.parseBoolean(scanner.nextLine().split(":", 2)[1].trim());
                    String category = scanner.nextLine().split(":", 2)[1].trim();

                    scanner.nextLine(); // Skip "END_Task"

                    LocalDateTime dueDate;
                    try {
                        dueDate = LocalDateTime.parse(dueDateStr);
                    } catch (DateTimeParseException e) {
                        System.out.println("Error parsing date: " + dueDateStr + " for task: " + title);
                        continue;
                    }

                    Task task = new Task();
                    task.setCompleted(isCompleted);
                    loadedTasks.add(task);
                    System.out.println("Loaded task: " + title);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            throw e;
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return loadedTasks;
    }


    private void add(Task task) {

    }

    /**
     * Organizes tasks by due date.
     */
    public static List<Task> organizeByDate(List<Task> tasks) {
        return tasks.stream()
                .sorted((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()))
                .collect(Collectors.toList());
    }

    /**
         * deletes tasks
         */
        public void deleteTask (List < Task > taskList) {
            taskList.remove(this);
            System.out.println("Task : " + title + "deleted");
        }

        /**
         * mark tasks as completed
         */
        public void markCompleted () {
            this.isCompleted = true;
            System.out.println("Progress of task" + title + ":" + "completed");
        }

        /**
         * filter tasks
         * @param tasks a list of tasks to filter from
         */
        public static List<Task> filterByCategory (List < Task > tasks, String category){
            return tasks.stream()
                    .filter(task -> task.getCategory().equals(category)).collect(Collectors.toList());
        }

    @Override
    public void grantReward () {
        Rewardable.super.grantReward();
    }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public String getDescription () {
            return description;
        }

        public void setDescription (String description){
            this.description = description;
        }

        public LocalDateTime getDueDate () {
            return dueDate;
        }

        public void setDueDate (LocalDateTime dueDate){
            this.dueDate = dueDate;
        }

        public String getCategory () {
            return category;
        }

        public void setCategory (String category){
            this.category = category;
        }

        public boolean isCompleted () {
            return isCompleted;
        }

        public void setCompleted ( boolean completed){
            isCompleted = completed;
        }
}

