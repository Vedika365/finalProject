import org.example.ScheduleManager;
import org.example.Task;
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
        Task task = new Task("Task 1", "Test description", LocalDateTime.now(), "Work");
        scheduleManager.addTask(task);
        assertEquals(1, scheduleManager.getAllTasks().size());
        assertEquals("Task 1", scheduleManager.getAllTasks().get(0).getTitle());
    }

    @Test
    void testDeleteTask() {
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task("Task 1", "Test description", LocalDateTime.now(), "Work");
        scheduleManager.addTask(task);
        scheduleManager.deleteTask(task);
        assertEquals(0, scheduleManager.getAllTasks().size());
    }

    @Test
    void testExportScheduleWithTasks() {
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task("Task 1", "Test description", LocalDateTime.now(), "Work");
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
        tasks.add(new Task("Task 1", "Test description", LocalDateTime.now(), "Work"));
        tasks.add(new Task("Task 2", "Another task", LocalDateTime.now().plusDays(1), "Personal"));

        scheduleManager.addAllTasks(tasks);
        assertEquals(2, scheduleManager.getAllTasks().size());
    }

    @Test
    void testImportSchedule() {
        boolean result = ScheduleManager.importSchedule("Dummy Schedule Data");
        assertTrue(result);
    }
}