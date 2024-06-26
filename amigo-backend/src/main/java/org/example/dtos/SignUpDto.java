package org.example.dtos;

import org.example.enums.UserRole;


public record SignUpDto(
        String login,
        String email,
        String password,
        UserRole role) {
}
