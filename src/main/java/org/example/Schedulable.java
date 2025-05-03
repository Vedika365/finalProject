package org.example;

public interface Schedulable {
    default void schedule() {
        System.out.println("Scheduling.. ");
    }
}
