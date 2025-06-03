package dev.tanaka.todo_fullstack_production_grade.controller;

import dev.tanaka.todo_fullstack_production_grade.entity.Task;
import dev.tanaka.todo_fullstack_production_grade.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TaskController {
//    crud services to be used to consume endpoints
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //    create
    @PostMapping("create-task")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

//    read
    @GetMapping("get-all-tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

//    read by id
    @GetMapping("get-task-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

//    update
    @PutMapping("/update-task/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Task updateTask(@PathVariable Long id,@RequestBody Task task){
        return taskService.updateTask(id, task);
    }

//    delete
    @DeleteMapping("/delete-tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "Task with "+id+" deleted successfully";
    }

    @PatchMapping("/is-complete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task isComplete(@PathVariable Long id){
        return taskService.isCompleteTask(id);
    }
}
