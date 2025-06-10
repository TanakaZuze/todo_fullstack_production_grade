package dev.tanaka.todo_fullstack_production_grade.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
    public static void main(String[] args) {
        String hash = new BCryptPasswordEncoder().encode("5678");
        System.out.println(hash);
    }
}
