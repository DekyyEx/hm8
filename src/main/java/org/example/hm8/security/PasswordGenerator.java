package org.example.hm8.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String adminPassword = passwordEncoder.encode("admin");
        System.out.println("Hashed admin password: " + adminPassword);

        String userPassword = passwordEncoder.encode("user");
        System.out.println("Hashed user password: " + userPassword);

        String restPassword = passwordEncoder.encode("rest");
        System.out.println("Hashed rest password: " + restPassword);
    }
}
