package dev.tanaka.todo_fullstack_production_grade.service;

import dev.tanaka.todo_fullstack_production_grade.dto.LogInDto;
import dev.tanaka.todo_fullstack_production_grade.dto.RegisterDto;
import dev.tanaka.todo_fullstack_production_grade.entity.Role;
import dev.tanaka.todo_fullstack_production_grade.entity.User;
import dev.tanaka.todo_fullstack_production_grade.exception.TodoAPIException;
import dev.tanaka.todo_fullstack_production_grade.repository.RoleRepository;
import dev.tanaka.todo_fullstack_production_grade.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService implements AuthServiceI{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder,AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager= authenticationManager;
    }

    @Override
    public String register(RegisterDto registerDto) {
//        check if username exists in db
        if(userRepository.existsByUsername((registerDto.getUsername()))){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"User with username "+registerDto.getUsername()+" already exists");
        }
//        check if user with email exists
        if(userRepository.existsByEmail((registerDto.getEmail()))){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"User with email "+registerDto.getEmail()+" already exists");
        }

        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByRoleDescription("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles); // Add this

        userRepository.save(user);

        return "User with username "+registerDto.getUsername()+" successfully registered";
    }

    @Override
    public String login(LogInDto logInDto) {
//       check if user exists return successful login else unsuccessful log in
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                logInDto.getUsernameOrEmail(),
                logInDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Logged in successfully";
    }
}
