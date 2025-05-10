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
    void testCheckDueTasks() {
        // Creating tasks with the updated constructor
        Task dueToday = new Task("Math homework", "Complete the exercises", LocalDateTime.now(), "Study", false);
        Task dueTomorrow = new Task("Physics lab", "Finish the experiment write-up", LocalDateTime.now().plusDays(1), "Lab", false);
        Task noDueDate = new Task("General task", "Random task without a due date", null, "Misc", false);

        List<Task> allTasks = Arrays.asList(dueToday, dueTomorrow, noDueDate);

        List<Task> dueTodayList = ReminderService.checkDueTasks(allTasks);

        // Test that only the task due today is returned
        assertEquals(1, dueTodayList.size());
        assertEquals("Math homework", dueTodayList.get(0).getTitle());
    }
}

