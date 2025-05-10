package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public interface Storable {


   default void save(String fileName) {
      System.out.println("Data is saved : " + fileName);
       try {
           Path path = Paths.get(fileName);
           List<String> lines = TaskManager.getAllTask().stream()
                   .map(task -> task.getTitle() + "," + task.isCompleted())
                   .collect(Collectors.toList());
           Files.write(path, lines);
           System.out.println("Data saved successfully.");
       } catch (IOException e) {
           System.out.println("Failed to save: " + e.getMessage());
       }
   }

    /**
     * Tracks task progress by counting how many are completed.
     */
    default void trackProgress() {
        System.out.println("Tracking progress... ");
        List<Task> tasks = TaskManager.getAllTask();
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks to track.");
            return;
        }

        // Using a lambda instead of method reference
        long completed = tasks.stream()
                .filter(task -> task.isCompleted())
                .count();

        System.out.println("Progress: " + completed + "/" + tasks.size() + " tasks completed.");
    }

    /**
     * method to load info from a file
     */
    List<Task> load(String fileName) throws FileNotFoundException;
}
