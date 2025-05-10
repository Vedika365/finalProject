import org.example.ReminderService;
import org.example.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    @Test
    void testEditTask() {
        // Create task instance
        Task task = new Task();

        // Edit the task and check if the fields are updated correctly
        Task.editTasks(task, "Updated Task", "Updated Description", LocalDateTime.of(2025, 6, 15, 14, 0), "Personal");

        assertEquals("Updated Task", task.getTitle());
        assertEquals("Updated Description", task.getDescription());
        assertEquals(LocalDateTime.of(2025, 6, 15, 14, 0), task.getDueDate());
        assertEquals("Personal", task.getCategory());
    }

    @Test
    void testDeleteTask() {
        // Create a task list and delete the task
        Task task = new Task();
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        task.deleteTask(taskList);

        // Ensure the task list is empty after deletion
        assertTrue(taskList.isEmpty(), "The task list should be empty after deletion.");
    }

    @Test
    void testMarkCompleted() {
        // Create task instance
        Task task = new Task();

        // Mark the task as completed
        task.markCompleted();

        // Assert that the task is marked as completed
        assertTrue(task.isCompleted(), "The task should be marked as completed.");
    }

    @Test
    void testFilterByCategory() {
        // Create tasks with different categories
        Task task1 = new Task("Math homework", "Complete the exercises", null, "Study", false);
        Task task2 = new Task("Physics lab", "Finish the experiment write-up", null, "Lab", false);
        Task task3 = new Task("History essay", "Write about World War II", null, "Study", false);
        Task task4 = new Task("Grocery shopping", "Buy ingredients for dinner", null, "Personal", false);

        // Put all tasks in a list
        List<Task> allTasks = Arrays.asList(task1, task2, task3, task4);

        // Filter tasks by the "Study" category
        List<Task> filteredTasks = ReminderService.filterByCategory(allTasks, "Study");

        // Assert that only the tasks with category "Study" are returned
        assertEquals(2, filteredTasks.size());
        assertEquals("Math homework", filteredTasks.get(0).getTitle());
        assertEquals("History essay", filteredTasks.get(1).getTitle());
    }

    @Test
    void testOrganizeByDate() {
        // Create tasks with different due dates
        Task task1 = new Task("Task 1", "Description 1", LocalDateTime.of(2025, 5, 10, 9, 0), "Category 1", false);
        Task task2 = new Task("Task 2", "Description 2", LocalDateTime.of(2025, 5, 9, 9, 0), "Category 2", false);
        Task task3 = new Task("Task 3", "Description 3", LocalDateTime.of(2025, 5, 11, 9, 0), "Category 3", false);

        // Put tasks in a list
        List<Task> tasks = List.of(task1, task2, task3);

        // Organize tasks by due date
        List<Task> organizedTasks = Task.organizeByDate(tasks);

        // Assert that the tasks are sorted by due date in ascending order
        assertEquals(task2, organizedTasks.get(0), "The first task should be the one with the earliest due date.");
        assertEquals(task1, organizedTasks.get(1), "The second task should be the one with the second earliest due date.");
        assertEquals(task3, organizedTasks.get(2), "The third task should be the one with the latest due date.");
    }

    @Test
    void testGrantReward() {
        // Create task instance
        Task task = new Task();

        // Initially, the task is not completed, so reward should not be granted
        task.grantReward();  // Should print "Task is not completed. No reward granted."

        // Mark the task as completed and grant reward
        task.markCompleted();
        task.grantReward();  // Should print "Reward granted for completing the task!"
    }

    @Test
    void testTrackProgress() {
        // Create task instance
        Task task = new Task();

        // Initially, the task is not completed
        task.trackProgress();  // Should print "Task is in progress."

        // Mark the task as completed and check progress again
        task.markCompleted();
        task.trackProgress();  // Should print "Task is completed."
    }
}
