package com.example.taskmanagement;

public class Task {
    private int id;
    private String name;
    private String dueDate;

    // Constructors
    public Task() {
    }

    public Task(int id, String name, String dueDate) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
