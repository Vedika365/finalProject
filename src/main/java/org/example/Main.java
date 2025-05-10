package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.time.LocalDateTime;
import java.util.List;

public class Main {
            public static void main(String[] args) {
                ReminderService reminderService = new ReminderService();
                TaskManager taskManager = new TaskManager(TaskManager.getAllTask(), reminderService);

                // Create a few tasks
                Task task1 = new Task("Buy groceries", "Buy milk and bread", LocalDateTime.now().plusDays(1), "Personal", false, Task.Priority.MEDIUM);
                Task task2 = new Task("Finish project", "Complete project draft", LocalDateTime.now().plusDays(2), "Work", false, Task.Priority.HIGH);
                Task task3 = new Task("Call friend", "Evening call", LocalDateTime.now().plusHours(5), "Friend", false, Task.Priority.LOW);

                // Add tasks
                taskManager.addTask(task1);
                taskManager.addTask(task2);
                taskManager.addTask(task3);

                System.out.println("\nAll Tasks:");
                TaskManager.getAllTask().forEach(System.out::println);

                // Mark one task as completed
                taskManager.markTaskAsCompleted(task1);

                // Edit task2
                TaskManager.editTask(task2, "Finish project draft", "Add graphs", LocalDateTime.now().plusDays(3), "Work", Task.Priority.HIGH);

                // Filter tasks by category
                List<Task> workTasks = taskManager.filterTaskByCategory("Work");
                System.out.println("\nFiltered by 'Work' Category:");
                workTasks.forEach(System.out::println);

                // View tasks by category
                System.out.println("\nView Tasks by Category:");
                System.out.println(taskManager.viewTaskByCategory(TaskManager.getAllTask()));

                // Search for a specific task
                System.out.println("\nSearch for a Task:");
                System.out.println(TaskManager.searchTask(task3));

                // Prioritize tasks by title
                TaskManager.prioritizeTasks(TaskManager.getAllTask(), "Call mom");
                System.out.println("\nAfter Prioritizing 'Call mom' by Title:");
                TaskManager.getAllTask().forEach(System.out::println);

                // Prioritize tasks by priority level
                TaskManager.prioritizeTasksByPriority(TaskManager.getAllTask());
                System.out.println("\nAfter Prioritizing by Priority:");
                TaskManager.getAllTask().forEach(System.out::println);

                // Send notifications
                System.out.println("\nSending Notifications:");
                reminderService.sendNotifications();
            }
        }
