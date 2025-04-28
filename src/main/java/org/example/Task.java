package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Task implements Rewardable, Schedulable, Storable, Trackable{
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String category;

    /**
     * Edits tasks
     */
    public static void editTaks() {

    }

    /**
     * deletes tasks
     */
    public void deleteTask() {

    }

    /**
     * mark tasks as completed
     */
    public void markCompleted() {

    }

    /**
     * filter tasks
     * @param tasks a list of tasks to filter from
     */
    public void filterByCategory(List<Task> tasks) {

    }

    /**
     * organize Tasks by date
     * @param tasks a list of to filter from
     */
    public void organizeByDate(List<Task> tasks) {

    }
}
