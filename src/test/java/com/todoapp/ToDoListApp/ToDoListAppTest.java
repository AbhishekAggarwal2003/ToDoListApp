package com.todoapp.ToDoListApp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class ToDoListAppTest {
    private ToDoListApp todoApp;

    @Before
    public void setUp() {
        todoApp = new ToDoListApp();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Task 1", "Description 1");
        todoApp.addTask(task);
        List<Task> tasks = todoApp.viewTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testMarkTaskCompleted() {
        Task task = new Task("Task 1", "Description 1");
        todoApp.addTask(task);
        todoApp.markTaskCompleted(0);
        assertTrue(todoApp.viewTasks().get(0).isCompleted());
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("Task 1", "Description 1");
        todoApp.addTask(task);
        todoApp.updateTask(0, "Updated Task", "Updated Description");
        Task updatedTask = todoApp.viewTasks().get(0);
        assertEquals("Updated Task", updatedTask.getTitle());
        assertEquals("Updated Description", updatedTask.getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("Task 1", "Description 1");
        todoApp.addTask(task);
        todoApp.deleteTask(0);
        assertEquals(0, todoApp.viewTasks().size());
    }
}
