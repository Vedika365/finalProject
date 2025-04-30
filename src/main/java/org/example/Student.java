package org.example;

import java.util.List;
import java.util.Map;

public class Student extends User {
    private List<Task> tasks;
    private Map<String,String> preference;


    public static void customizePreference() {

    }

    public Student(String name, String preference) {
        super(name, preference);
    }

 }
