import org.example.ReminderService;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Test
    public void testEditTask() {
        List<Task> tasks = new ArrayList<>();
        ReminderService reminderService = new ReminderService();
        TaskManager taskManager = new TaskManager(tasks, reminderService);

        Task task = new Task("OldTitle", "OldDesc", LocalDateTime.now().plusDays(1), "OldCat", false);
        tasks.add(task);

        TaskManager.editTask(task, "NewTitle", "NewDesc", LocalDateTime.now().plusDays(3), "NewCat");

        assertEquals("NewTitle", task.getTitle());
        assertEquals("NewDesc", task.getDescription());
        assertEquals("NewCat", task.getCategory());
    }

    @Test
    public void testMarkTaskAsCompleted() {
        List<Task> tasks = new ArrayList<>();
        ReminderService reminderService = new ReminderService();
        TaskManager taskManager = new TaskManager(tasks, reminderService);

        Task task = new Task("Task1", "Desc", LocalDateTime.now().plusDays(1), "General", false);
        tasks.add(task);

        taskManager.markTaskAsCompleted(task);
        
        assertTrue(task.isCompleted());
    }



}