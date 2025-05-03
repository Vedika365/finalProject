package org.example;

public interface Trackable {
    default void trackProgress() {
        System.out.println("tracking the progress..");
    }
}
