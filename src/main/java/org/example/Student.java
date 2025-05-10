package org.example;

import java.sql.SQLOutput;
import java.util.*;

public class Student extends User {
    private List<Task> tasks;
    private Map<String, String> preference;


    public Student(String name) {
        super(name, "Default");
        this.tasks = new ArrayList<>();
        this.preference = new HashMap<>();
        this.preference.put("theme", "Default"); // Set default preference
    }


        public List<Task> getTasks() {
            return tasks;
        }

        //method to customize preferences
        public void customizePreference(String key, String value) {
            this.preference.put(key,value);
        }

        public Map<String, String> getPreferences() {
         return preference;
        }
    }


