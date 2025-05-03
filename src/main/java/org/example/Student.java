package org.example;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student extends User {
    private List<Task> tasks;
    private Map<String,String> preference;


    /**
     * Updates the student's preference using the provided key-value pairs
     * This method replaces or adds new preferences based on the input map
     * @param newPreference a map of preference categories and their values
     */
    public void customizePreference(Map<String, String> newPreference) {
      Scanner scanner = new Scanner(System.in);
      boolean customizing = true;

      if (newPreference == null ) {
          return;
      }
      preference.putAll(newPreference);
        System.out.println("Preference Updated. ");
    }

    public Student(String name, String preference) {
        super(name, preference);
    }

 }
