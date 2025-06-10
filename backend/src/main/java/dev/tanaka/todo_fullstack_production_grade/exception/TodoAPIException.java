package dev.tanaka.todo_fullstack_production_grade.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class TodoAPIException {
    private HttpStatus httpStatus;
    private String message;
}
