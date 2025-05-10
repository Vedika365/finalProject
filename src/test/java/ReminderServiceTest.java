import org.example.ReminderService;
import org.example.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReminderServiceTest {
    @Test
    void checkDueTasks_shouldReturnOnlyTodayTasks() {
        Task taskToday = new Task(
                "Finish report", "Complete the final draft",
                LocalDateTime.now().withHour(17),
                "Work", false
        );

        Task taskTomorrow = new Task(
                "Team meeting", "Weekly sync",
                LocalDateTime.now().plusDays(1).withHour(10),
                "Work", false
        );

        Task taskYesterday = new Task(
                "Call client", "Follow up on proposal",
                LocalDateTime.now().minusDays(1).withHour(12),
                "Work", true
        );

        List<Task> allTasks = Arrays.asList(taskToday, taskTomorrow, taskYesterday);

        List<Task> dueToday = ReminderService.checkDueTasks(allTasks);

        assertEquals(1, dueToday.size());
        assertTrue(dueToday.contains(taskToday));
    }


}
