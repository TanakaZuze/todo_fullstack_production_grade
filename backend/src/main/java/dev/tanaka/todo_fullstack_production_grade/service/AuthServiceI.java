package dev.tanaka.todo_fullstack_production_grade.service;

import dev.tanaka.todo_fullstack_production_grade.entity.User;

public interface AuthServiceI {
    String register(User registerUser);
}
