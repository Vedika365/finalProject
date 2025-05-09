
import org.example.ReminderService;
import org.example.ScheduleManager;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TestScheduleManager {

    @Test
    void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task 1", "Description", LocalDateTime.now(), "General");
        taskManager.addTask(task);
        assertEquals(1, taskManager.getAllTasks().size());
    }

    @Test
    void testDeleteTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Task1", "Descirption", LocalDateTime.now(), "General");
        taskManager.addTask(task);
        taskManager.deleteTask(task);
        assertEquals(0,taskManager.getAllTasks().size());
    }

    @Test
     void testExportSchedule() {
        ScheduleManager scheduleManager = new ScheduleManager();
        String schedule = "My schedule data";
        boolean result = scheduleManager.exportSchedule(schedule);
        assertTrue(result, "the schedule export should return true");
    }
      @Test
    void testImportSchedule() {
        String schedule = "My schedule data";
        boolean result = ScheduleManager.importSchedule(schedule);
        assertTrue(result, "the schedule import must return true");
      }

      @Test
        void testViewCalendar_normalCase() {
        String calendar = "Work Calendar";
        ScheduleManager.viewCalendar(calendar);
      }

    @Test
    void testSearchTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Search Task", "Search for this task", LocalDateTime.now(), "Work");
        taskManager.addTask(task);
        Task foundTask = taskManager.searchTask("Search Task");
        assertEquals("Search Task", foundTask.getTitle());
    }
}









        }
