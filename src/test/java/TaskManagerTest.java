package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager taskManager;
    private Task sampleTask1;
    private Task sampleTask2;

    @BeforeEach
    void setUp() {
        sampleTask1 = new Task("Title1", "Desc1", LocalDateTime.now().plusDays(1), "Work", false, Task.Priority.MEDIUM);
        sampleTask2 = new Task("Title2", "Desc2", LocalDateTime.now().plusDays(2), "Home", false, Task.Priority.HIGH);

        List<Task> taskList = new ArrayList<>();
        taskList.add(sampleTask1);
        taskList.add(sampleTask2);

        taskManager = new TaskManager(taskList, new ReminderService());
        TaskManager.setAllTask(taskList);
    }

    @Test
    void testAddTask() {
        Task task = new Task("New Task", "Description", LocalDateTime.now().plusDays(3), "Other", false, Task.Priority.LOW);
        taskManager.addTask(task);
        assertTrue(TaskManager.getAllTask().contains(task));
    }

    @Test
    void testDeleteTask() {
        taskManager.deleteTask(sampleTask1);
        assertFalse(TaskManager.getAllTask().contains(sampleTask1));
    }

    @Test
    void testEditTask() {
        TaskManager.editTask(sampleTask1, "Updated Title", "Updated Desc", LocalDateTime.now().plusDays(5), "UpdatedCat", Task.Priority.HIGH);
        assertEquals("Updated Title", sampleTask1.getTitle());
        assertEquals("Updated Desc", sampleTask1.getDescription());
        assertEquals("UpdatedCat", sampleTask1.getCategory());
        assertEquals(Task.Priority.HIGH, sampleTask1.getPriority());
    }

    @Test
    void testMarkTaskAsCompleted() {
        taskManager.markTaskAsCompleted(sampleTask2);
        assertTrue(sampleTask2.isCompleted());
    }

    @Test
    void testFilterTaskByCategory() {
        List<Task> filtered = taskManager.filterTaskByCategory("Work");
        assertEquals(1, filtered.size());
        assertEquals("Work", filtered.get(0).getCategory());
    }

    @Test
    void testViewTaskByCategory() {
        String output = taskManager.viewTaskByCategory(TaskManager.getAllTask());
        assertTrue(output.contains("Category:"));
        assertTrue(output.contains("Title: "));
    }

    @Test
    void testSearchTask() {
        String output = TaskManager.searchTask(sampleTask2);
        assertTrue(output.contains("Found Task:"));
        assertTrue(output.contains(sampleTask2.getTitle()));
    }

    @Test
    void testPrioritizeTasks() {
        TaskManager.prioritizeTasks(TaskManager.getAllTask(), sampleTask2.getTitle());
        assertEquals(sampleTask2, TaskManager.getAllTask().get(0));
    }

    @Test
    void testPrioritizeTasksByPriority() {
        TaskManager.prioritizeTasksByPriority(TaskManager.getAllTask());
        assertEquals(Task.Priority.MEDIUM, TaskManager.getAllTask().get(0).getPriority());
    }
}
