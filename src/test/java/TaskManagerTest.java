import org.example.ReminderService;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void addTask_AddTask() {
        Task task1 = new Task("Finish report", "Complete the final draft",
                LocalDateTime.now().withHour(17), "Work", false);
        Task task4 = new Task("Clean the house", "Do a quick cleaning",
                LocalDateTime.now().plusDays(3), "Personal", false);

        ReminderService reminderService = new ReminderService();
        TaskManager taskManager = new TaskManager(Arrays.asList(task1), reminderService);
        taskManager.addTask(task4);

        assertTrue(taskManager.filterTaskByCategory("Personal").contains(task4));
    }

    @Test
    void deleteTask_RemoveTask() {
        Task task1 = new Task("Finish report", "Complete the final draft",
                LocalDateTime.now().withHour(17), "Work", false);
        Task task2 = new Task("Team meeting", "Weekly sync",
                LocalDateTime.now().plusDays(1).withHour(10), "Work", false);

        ReminderService reminderService = new ReminderService();
        TaskManager taskManager = new TaskManager(Arrays.asList(task1, task2), reminderService);
        taskManager.deleteTask(task1);

        assertFalse(taskManager.filterTaskByCategory("Work").contains(task1));
    }
      //TODO ADD MORE TEST CASES NOT FINISHED
}