import org.example.ScheduleManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestScheduleManager {

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
}
