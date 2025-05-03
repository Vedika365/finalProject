package org.example;

import java.time.LocalDateTime;
import java.util.List;
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
    public static void editTasks(Task task, String newTitle, String newDesciption, LocalDateTime newDueDate, String newCategory) {
      task.setTitle(newTitle);
      task.setDescription(newDesciption);
      task.setDueDate(newDueDate);
      task.setCategory(newCategory);
    }

    /**
     * deletes tasks
     */
    public void deleteTask(List<Task> taskList) {
      taskList.remove(this);
    }

    /**
     * mark tasks as completed
     */
    public void markCompleted() {
       this.isCompleted = true ;
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
}
