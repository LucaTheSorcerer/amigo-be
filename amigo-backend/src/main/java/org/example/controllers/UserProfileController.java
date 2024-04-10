package org.example.controllers;

import org.example.dtos.UpdateEmailDto;
import org.example.dtos.UpdateUsernameDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUsername(@PathVariable String username) {
        return userService.findUsernameByLogin(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{username}")
    public ResponseEntity<?> getEmail(@PathVariable String username) {
        return userService.findEmailByLogin(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/update-email/{userId}")
    public ResponseEntity<?> updateEmail(@PathVariable Long userId, @RequestBody UpdateEmailDto updateEmailDto) {
        return userService.updateEmail(userId, updateEmailDto.getEmail())
                .map(updatedUser -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/update-username/{userId}")
    public ResponseEntity<?> updateUsername(@PathVariable Long userId, @RequestBody UpdateUsernameDto updateUsernameDto) {
        return userService.updateUsername(userId, updateUsernameDto.getUsername())
                .map(updatedUser -> ResponseEntity.ok().build())
                .orElse(ResponseEntity.notFound().build());
    }
}
