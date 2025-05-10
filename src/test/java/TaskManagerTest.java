import org.example.ReminderService;
import org.example.Task;
import org.example.TaskManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void testAddTask() {
        Task task = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(), new ReminderService());
        taskManager.addTask(task);

        assertTrue(TaskManager.getAllTask().contains(task));
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task), new ReminderService());
        taskManager.deleteTask(task);

        assertFalse(TaskManager.getAllTask().contains(task));
    }

    @Test
    void testEditTask() {
        Task task = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task), new ReminderService());
        TaskManager.editTask(task, "New Title", "New Description", LocalDateTime.now().plusDays(1), "Home", Task.Priority.HIGH);

        assertEquals("New Title", task.getTitle());
        assertEquals("New Description", task.getDescription());
        assertEquals("Home", task.getCategory());
    }

    @Test
    void testMarkTaskAsCompleted() {
        Task task = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task), new ReminderService());
        taskManager.markTaskAsCompleted(task);

        assertTrue(task.isCompleted());
    }

    @Test
    void testFilterTaskByCategory() {
        Task task1 = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        Task task2 = new Task("Task 2", "Description 2", LocalDateTime.now(), "Home", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task1, task2), new ReminderService());

        var filteredTasks = TaskManager.filterTaskByCategory("Work");

        assertEquals(1, filteredTasks.size());
        assertTrue(filteredTasks.contains(task1));
    }

    @Test
    void testViewTaskByCategory() {
        Task task1 = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        Task task2 = new Task("Task 2", "Description 2", LocalDateTime.now(), "Home", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task1, task2), new ReminderService());

        String result = taskManager.viewTaskByCategory(Arrays.asList(task1, task2));

        assertTrue(result.contains("Category: Work"));
        assertTrue(result.contains("Title: Task 1"));
    }

    @Test
    void testSearchTask() {
        Task task = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task), new ReminderService());

        String result = TaskManager.searchTask(task);

        assertTrue(result.contains("Found Task:"));
        assertTrue(result.contains("Title: Task 1"));
    }

    @Test
    void testOrganiseTaskByDate() {
        Task task1 = new Task("Task 1", "Description 1", LocalDateTime.now().plusDays(1), "Work", false);
        Task task2 = new Task("Task 2", "Description 2", LocalDateTime.now(), "Home", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task1, task2), new ReminderService());

        TaskManager.organiseTaskByDate(TaskManager.getAllTask());

        assertEquals(task2, TaskManager.getAllTask().get(0));
        assertEquals(task1, TaskManager.getAllTask().get(1));
    }

    @Test
    void testPrioritizeTasks() {
        Task task1 = new Task("Task 1", "Description 1", LocalDateTime.now(), "Work", false);
        Task task2 = new Task("Task 2", "Description 2", LocalDateTime.now(), "Home", false);
        TaskManager taskManager = new TaskManager(Arrays.asList(task1, task2), new ReminderService());

        TaskManager.prioritizeTasks(TaskManager.getAllTask(), "Task 2");

        assertEquals(task2, TaskManager.getAllTask().get(0));
        assertEquals(task1, TaskManager.getAllTask().get(1));
    }



    @Test
    void testLoadTaskFromFile() {
        // Test case that ensures loading from a file doesn't change the state
        boolean result = TaskManager.loadTaskFromFile("dummyFile.txt");

        assertFalse(result);
    }
}