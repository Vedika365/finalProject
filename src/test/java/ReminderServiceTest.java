import org.example.ReminderService;
import org.example.Task;
import org.example.TaskManager;
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
        Task dueToday = new Task("Math homework", "Complete the exercises", LocalDateTime.now(), "Study", false, Task.Priority.LOW);
        Task dueTomorrow = new Task("Physics lab", "Finish the experiment write-up", LocalDateTime.now().plusDays(1), "Lab", false, Task.Priority.LOW);
        Task noDueDate = new Task("General task", "Random task without a due date", null, "Misc", false, Task.Priority.LOW);

        List<Task> allTasks = Arrays.asList(dueToday, dueTomorrow, noDueDate);

        List<Task> dueTodayList = ReminderService.checkDueTasks(allTasks);

        // Test that only the task due today is returned
        assertEquals(1, dueTodayList.size());
        assertEquals("Math homework", dueTodayList.get(0).getTitle());
    }

    @Test
    void testFilterByCategory_MatchFound() {
        Task task1 = new Task("Task1", "Desc", LocalDateTime.now(), "Work", false);
        Task task2 = new Task("Task2", "Desc", LocalDateTime.now(), "Home", false);
        Task task3 = new Task("Task3", "Desc", LocalDateTime.now(), "Work", false);

        List<Task> allTasks = Arrays.asList(task1, task2, task3);

        // Set the allTask list in TaskManager
        TaskManager.setAllTask(allTasks);

        List<Task> filtered = TaskManager.filterTaskByCategory("Work");

        assertEquals(2, filtered.size());
        assertTrue(filtered.contains(task1));
        assertTrue(filtered.contains(task3));
    }

    @Test
    void testFilterTaskByCategory_CaseInsensitiveMatch() {
        Task task1 = new Task("Buy groceries", "Milk and eggs", LocalDateTime.now(), "Home", false);
        Task task2 = new Task("Project work", "Module 1", LocalDateTime.now(), "Work", false);
        Task task3 = new Task("Call mom", "Weekend plan", LocalDateTime.now(), "home", false);

        TaskManager.setAllTask(Arrays.asList(task1, task2, task3)); // setting the shared allTask list

        List<Task> result = TaskManager.filterTaskByCategory("HOME");
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(task -> task.getCategory().equalsIgnoreCase("Home")));
    }

    @Test
    void testFilterTaskByCategory_NoMatch() {
        Task task1 = new Task("Buy groceries", "Milk and eggs", LocalDateTime.now(), "Home", false);
        Task task2 = new Task("Project work", "Module 1", LocalDateTime.now(), "Work", false);
        Task task3 = new Task("Call mom", "Weekend plan", LocalDateTime.now(), "home", false);

        TaskManager.setAllTask(Arrays.asList(task1, task2, task3)); // setting the shared allTask list

        List<Task> result = TaskManager.filterTaskByCategory("Fitness");
        assertTrue(result.isEmpty());
    }


}

