package com.todoapp.ToDoListApp;

import java.util.ArrayList;
import java.util.List;

public class ToDoListApp {
    private List<Task> tasks;

    public ToDoListApp() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskCompleted(int index) {
        tasks.get(index).setCompleted(true);
    }

    public void updateTask(int index, String title, String description) {
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public List<Task> viewTasks() {
        return tasks;
    }
}
