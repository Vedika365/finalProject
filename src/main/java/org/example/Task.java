package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task implements Rewardable, Schedulable, Storable, Trackable {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String category;
    private boolean isCompleted;


    public Task(String title, String description, LocalDateTime dueDate, String category) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.isCompleted = false;
    }

    /**
     * Edits tasks
     */
    public void editTasks(Task task, String newTitle, String newDesciption, LocalDateTime newDueDate, String newCategory) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
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
     * Loads tasks from a CSV file and adds them to a task list.
     * Each task line should contain: title, description, dueDate, isCompleted, category
     */
    public void load(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    String title = parts[0].trim();
                    String description = parts[1].trim();
                    String dueDateStr = parts[2].trim();
                    boolean isCompleted = Boolean.parseBoolean(parts[3].trim());
                    String category = parts[4].trim();

                    // Try to parse the dueDate and handle errors if invalid
                    LocalDateTime dueDate = null;
                    try {
                        dueDate = LocalDateTime.parse(dueDateStr);
                    } catch (DateTimeParseException e) {
                        System.out.println("Error parsing date: " + dueDateStr + " for task: " + title);
                        continue; // Skip this task and move to the next one
                    }

                    // Create the task and add it to the list
                    Task task = new Task(title, description, dueDate, category);
                    task.setCompleted(isCompleted); // Assuming there's a method to set the completion status
                    task.add(task);

                    System.out.println("Loaded task: " + title);
                } else {
                    System.out.println("Invalid data format (expected 5 attributes per task). Skipping line: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            throw e; // Rethrow the exception after logging it
        } catch (Exception e) {
            System.err.println("An error occurred while loading tasks: " + e.getMessage());
        }
    }

    private void add(Task task) {

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

        /**
         * organize Tasks by date
         * @param tasks a list of to filter from
         */
        public static List<Task> organizeByDate (List<Task> tasks){
          return tasks.stream()
                  .sorted((t1, t2)-> t1.getDueDate().compareTo(t2.getDueDate())).collect(Collectors.toList());
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

