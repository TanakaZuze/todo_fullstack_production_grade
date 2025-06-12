package dev.tanaka.todo_fullstack_production_grade.service;

import dev.tanaka.todo_fullstack_production_grade.dto.LogInDto;
import dev.tanaka.todo_fullstack_production_grade.dto.RegisterDto;

public interface AuthServiceI {
    String register(RegisterDto registerDto);
    String login(LogInDto logInDto);


}
