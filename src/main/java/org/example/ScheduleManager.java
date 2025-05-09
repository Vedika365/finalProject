package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Task> tasks;
    List<Task> taskForCalendar;

    /**
     * Exports the current schedule to a file
     * @param fileName the name of the file to write to
     * @return true if the export was susseful, false otherwise
     */
    public boolean exportSchedule(String fileName) {
                 if (tasks == null || tasks.isEmpty()) {
                     System.out.println("No tasks to export. ");
                     return false;
                 }
                 try (FileWriter writer = new FileWriter(fileName)) {
                     for (Task task : tasks) {
                         writer.write("Title: " + task.getTitle() + "\n");
                         writer.write("Description: " + task.getDescription() + "\n");
                         writer.write("DueDate: " + task.getDueDate() + "\n");
                         writer.write("Completed: " + task.isCompleted() + "\n");
                         writer.write("Category: " + task.getCategory() + "\n");
                         writer.write("--------\n");
                     }
                     System.out.println("Schedule exported to " + fileName);
                     return true;
                 } catch (IOException e) {
                     System.out.println("Error exporting schedule: " + e.getMessage());
                     return false;
                 }
    }

    /**
     * view calendar
     * static method to view the calendar
     */
    public void viewCalender(String calendar) {
        System.out.println("viewing calendar.......");
        if (taskForCalendar.isEmpty()) {
            System.out.println("no tasks found for this calendar.");
        } else {
            System.out.println(" Tasks in calendar : " + calendar);
            for (Task task : taskForCalendar) {
                System.out.println("- " + task.getTitle() + "Due" + task.getDueDate() + ")");
            }
        }
    }

    /**
     * Import the schedule
     * @param schedule the schedule data to be imported
     * @return true if import was successful, false otherwise
     */
    public static boolean importSchedule(String schedule) {
        System.out.println("Importing schedule : " + schedule);
        return true;
    }

    //getTasks associated with a specific calendar

    //add a method to viewAllTasks
    public void addAllTasks(List<Task> tasksToAdd) {
        if (this.tasks == null) {
            this.tasks = new ArrayList<>();
        }
        this.tasks.addAll(tasksToAdd);
    }

    public List<Task> getAllTasks() {
        if (this.tasks == null) {
            this.tasks = new ArrayList<>();
        }
        return this.tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasksForCalendar() {
        return taskForCalendar;
    }

    public void deleteTask(Task task) {
        if (this.tasks != null && this.tasks.contains(task)) {
            this.tasks.remove(task);
            System.out.println("Task '" + task.getTitle() + "' deleted from schedule.");
        } else {
            System.out.println("Task not found or task list is empty.");
        }
    }

    public void addTask(Task task) {
        if (this.tasks == null) {
            this.tasks = new ArrayList<>();
        }
        this.tasks.add(task);
    }
}
