package org.example.controllers;

import org.example.dtos.PasswordForgotDto;
import org.example.dtos.PasswordResetDto;
import org.example.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class PasswordResetController {

    @Autowired
    private AuthService authService;

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody PasswordForgotDto forgotPasswordDto) {
        authService.initiatePasswordReset(forgotPasswordDto.getEmail());
        return ResponseEntity.ok().build();
    }


    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordResetDto passwordResetDto) {
        authService.completePasswordReset(passwordResetDto.getToken(), passwordResetDto.getNewPassword());
        return ResponseEntity.ok().build();
    }
}