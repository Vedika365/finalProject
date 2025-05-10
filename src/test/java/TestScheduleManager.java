
import org.example.ScheduleManager;
import org.example.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestScheduleManager {

    @Test
    void testAddTask() {
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task();
        scheduleManager.addTask(task);
        assertEquals(1, scheduleManager.getAllTasks().size());
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
        ScheduleManager scheduleManager = new ScheduleManager();
        Task task = new Task();
          scheduleManager.addTask(task);
        Task foundTask = scheduleManager.searchTask("Search Task");
        assertEquals("Search Task", foundTask.getTitle());
    }
}









        }
