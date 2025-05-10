import org.example.ScheduleManager;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleManagerTest {

    @AfterEach
    void cleanUpFile() {
        File file = new File("test_schedule.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testAddTask() {
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task();
        scheduleManager.addTask(task);
        assertEquals(1, scheduleManager.getAllTasks().size());
        assertEquals("Task 1", scheduleManager.getAllTasks().get(0).getTitle());
    }

    @Test
    void testDeleteTask() {
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task();
        scheduleManager.addTask(task);
        scheduleManager.deleteTask(task);
        assertEquals(0, scheduleManager.getAllTasks().size());
    }

    @Test
    void testExportScheduleWithTasks() {
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task();
        scheduleManager.addTask(task);
        boolean result = scheduleManager.exportSchedule("test_schedule.txt");
        assertTrue(result);
        assertTrue(new File("test_schedule.txt").exists());
    }

    @Test
    void testExportScheduleWithoutTasks() {
        ScheduleManager scheduleManager = new ScheduleManager();
        boolean result = scheduleManager.exportSchedule("test_schedule.txt");
        assertFalse(result);
    }

    @Test
    void testAddAllTasks() {
        ScheduleManager scheduleManager = new ScheduleManager();
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());
        tasks.add(new Task());

        scheduleManager.addAllTasks(tasks);
        assertEquals(2, scheduleManager.getAllTasks().size());
    }

    @Test
    void testImportSchedule() {
        boolean result = ScheduleManager.importSchedule("Dummy Schedule Data");
        assertTrue(result);
    }

    @Test
    public void testViewCalendarWithSpecificDate() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Description", LocalDateTime.of(2025, 5, 10, 12, 0), "Work", false));
        tasks.add(new Task("Task 2", "Description", LocalDateTime.of(2025, 5, 15, 12, 0), "Work", false));

        // Call the method
        List<Task> result = ScheduleManager.viewCalendar("2025-05-10", tasks);

        // Assert that Task 1 is returned and Task 2 is not
        assertEquals(1, result.size());
        assertTrue(result.contains(tasks.get(0))); // Task 1
        assertFalse(result.contains(tasks.get(1))); // Task 2
    }

}