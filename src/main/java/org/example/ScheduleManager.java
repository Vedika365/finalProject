package org.example;

import java.util.List;

public class ScheduleManager {
    private List<Task> tasks;

    public boolean exportSchedule(String schedule) {
                  //TODO fix this is it boolean
        return true;
    }
    /**
     * view calendar
     * static method to view the calendar without needing an instance
     */
    public static void viewCalender() {
        System.out.println("viewing calendar.......");
        //TODO LOGIC TO ADD CALENDAR
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

    /**
     * view the calendar with a specific identifier
     * @param calendar the identifier of the calendar to be viewed
     */
    public static void viewCalendar(String calendar) {
        System.out.println("Viewing calendar : " + calendar);
        //TODO ADD LOGIC TO VIEW A SPECIFIC CALENDAR
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
