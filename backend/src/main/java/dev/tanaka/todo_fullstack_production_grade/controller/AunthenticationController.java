package dev.tanaka.todo_fullstack_production_grade.controller;

import dev.tanaka.todo_fullstack_production_grade.dto.LogInDto;
import dev.tanaka.todo_fullstack_production_grade.dto.RegisterDto;
import dev.tanaka.todo_fullstack_production_grade.service.AuthenticationService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AunthenticationController {
    private final AuthenticationService authenticationService;

    public AunthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

//register endpoint
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody RegisterDto registerDto){
        return authenticationService.register(registerDto);
    }

//    login endpoint
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String userLogin(@RequestBody LogInDto logInDto){
        return authenticationService.login(logInDto);
    }
}
