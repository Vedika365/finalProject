package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task implements Rewardable, Schedulable, Storable, Trackable{
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

    public void save(String fileName) {
        try (FileWriter fw = new FileWriter());
        fw.write();

    }

    @Override
    public void load(String fileName) {
          try (Scanner scanner = new Scanner(new File(fileName))) {
              while (scanner.hasNextLine()) {
                  String line = scanner.nextLine();
                  String[] parts = line.split(",");
                  if (parts.length == 5 ) {
                  this.title = parts[0];
                  this.description = parts[1];
                  this.dueDate = LocalDateTime.parse(parts[2]);
                  this.isCompleted = Boolean.parseBoolean(parts[2]);
                  this.category = parts[4];
                  System.out.println("Task" + title + " " + "loaded from " + fileName);
                  return;  //has loaded only one task
              }
              else {
                  System.out.println("invalid data format");
          } catch (IOException) {

          }
    }

    /**
     * deletes tasks
     */
    public void deleteTask(List<Task> taskList) {
        taskList.remove(this);
        System.out.println("Task" +title + "deleted");
    }

    /**
     * mark tasks as completed
     */
    public void markCompleted() {
       this.isCompleted = true ;
        System.out.println("Progress of task" + title + ":" + "completed" );
    }

    /**
     * filter tasks
     * @param tasks a list of tasks to filter from
     */
    public static List<Task> filterByCategory(List<Task> tasks, String category) {
        return tasks.stream()
                .filter(task -> task.getCategory().equals(category)).collect(Collectors.toList());
    }

    /**
     * organize Tasks by date
     * @param tasks a list of to filter from
     */
    public static void organizeByDate(Task tasks) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public void grantReward() {
        Rewardable.super.grantReward();
    }
}
