package dev.tanaka.todo_fullstack_production_grade.service;

import dev.tanaka.todo_fullstack_production_grade.entity.Task;
import dev.tanaka.todo_fullstack_production_grade.exception.TaskNotFoundException;
import dev.tanaka.todo_fullstack_production_grade.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceI {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //    create
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not found"));
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
//        check if id exists
        Task existingTask=taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not found"));

//        update task
        existingTask.setTodoTitle(updatedTask.getTodoTitle());
        existingTask.setTodoDescription(updatedTask.getTodoDescription());
        existingTask.setTodoComplete(updatedTask.isTodoComplete());
        return taskRepository.save(existingTask);
    }

//    delete task
    @Override
    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task with id " + id + " not found");
        }else{
            taskRepository.deleteById(id);
        }
    }

    @Override
    public Task isCompleteTask(Long id) {
        Task task=taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not found"));

        task.setTodoComplete(Boolean.TRUE);

        return taskRepository.save(task);
    }

//    is task complete

}
