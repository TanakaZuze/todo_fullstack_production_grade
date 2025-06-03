package dev.tanaka.todo_fullstack_production_grade.service;

import dev.tanaka.todo_fullstack_production_grade.entity.Task;

import java.util.List;

public interface TaskServiceI {
//    crud methods signatures to be implemented in the task service

    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id,Task task);
    void deleteTask(Long id);
    Task isCompleteTask(Long id);


}
