package com.example.a1_todolist;

public class TaskModel {

    private int id;
    private String taskName;

    public TaskModel() {
        super();
    }

    public TaskModel(String taskName) {
        this.taskName = taskName;
    }

    public TaskModel(int id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
