import org.example.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    //todo fix the errors tomorrow, need to submit right now
    @Test
    void testEditTask() {
        // Create task instance
        Task task = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12, 0), "Work");

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
        Task task = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12);
        List<Task> taskList = List.of(task);

        task.deleteTask(taskList);

        // Ensure the task list is empty after deletion
        assertTrue(taskList.isEmpty(), "The task list should be empty after deletion.");
    }

    @Test
    void testMarkCompleted() {
        // Create task instance
        Task task = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12, 0), "Work");

        // Mark the task as completed
        task.markCompleted();

        // Assert that the task is marked as completed
        assertTrue(task.isCompleted(), "The task should be marked as completed.");
    }

    @Test
    void testFilterByCategory() {
        // Create a list of tasks with different categories
        Task task1 = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12, 0), "Work");
        Task task2 = new Task("Task 2", "Description of task 2", LocalDateTime.of(2025, 5, 12, 9, 0), "Personal");
        Task task3 = new Task("Task 3", "Description of task 3", LocalDateTime.of(2025, 5, 15, 16, 0), "Work");

        List<Task> tasks = List.of(task1, task2, task3);

        // Filter tasks by category "Work"
        List<Task> filteredTasks = Task.filterByCategory(tasks, "Work");

        // Assert that the filtered tasks list contains only tasks with category "Work"
        assertEquals(2, filteredTasks.size(), "There should be 2 tasks in the 'Work' category.");
        assertTrue(filteredTasks.stream().allMatch(t -> "Work".equals(t.getCategory())), "All tasks should have category 'Work'");
    }

    @Test
    void testOrganizeByDate() {
        // Create a list of tasks with different due dates
        Task task1 = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12, 0), "Work");
        Task task2 = new Task("Task 2", "Description of task 2", LocalDateTime.of(2025, 5, 8, 9, 0), "Personal");
        Task task3 = new Task("Task 3", "Description of task 3", LocalDateTime.of(2025, 5, 12, 16, 0), "Work");

        List<Task> tasks = List.of(task1, task2, task3);

        // Organize tasks by due date
        List<Task> organizedTasks = Task.organizeByDate(Task tasks);

        // Assert that the tasks are sorted by due date in ascending order
        assertEquals(task2, organizedTasks.get(0), "The first task should be the one with the earliest due date.");
        assertEquals(task1, organizedTasks.get(1), "The second task should be the one with the second earliest due date.");
        assertEquals(task3, organizedTasks.get(2), "The third task should be the one with the latest due date.");
    }

    @Test
    void testGrantReward() {
        // Create task instance
        Task task = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12, 0), "Work");

        // Initially, the task is not completed, so reward should not be granted
        task.Grant();  // Should print "Task is not completed. No reward granted."

        // Mark the task as completed and grant reward
        task.markCompleted();
        task.GrantReward();  // Should print "Reward granted for completing the task!"
    }

    @Test
    void testTrackProgress() {
        // Create task instance
        Task task = new Task("Task 1", "Description of task 1", LocalDateTime.of(2025, 5, 10, 12, 0), "Work");

        // Initially, the task is not completed
        task();  // Should print "Task is in progress."

        // Mark the task as completed and check progress again
        task.markCompleted();
        task.trackProgress();  // Should print "Task is completed."
    }
}
