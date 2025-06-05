package dev.tanaka.todo_fullstack_production_grade.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String todoTitle;

    @Column(nullable = false)
    private String todoDescription;

    @Column(nullable = false)
    private boolean todoComplete;

//    @Data ie getter and setters etc etc

    public Task() {
    }

    public Task(Long id, String todoTitle, String todoDescription, boolean todoComplete) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
        this.todoComplete = todoComplete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public boolean isTodoComplete() {
        return todoComplete;
    }

    public void setTodoComplete(boolean todoComplete) {
        this.todoComplete = todoComplete;
    }
}
